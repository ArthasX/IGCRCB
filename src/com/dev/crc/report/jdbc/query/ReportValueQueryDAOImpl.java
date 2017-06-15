/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.report.jdbc.query;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.utility.ResourceUtility;
import com.dev.crc.report.jdbc.connection.IGConnection;
import com.dev.crc.report.jdbc.connectpool.IGConnectPoolManager;
import com.dev.crc.report.utils.XMLUtils;
import com.dev.crc.report.xml.XMLFileManager;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 报表值查询DAO实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ReportValueQueryDAOImpl implements ReportValueQueryDAO{
	
	/** 日志对象 */
	protected static final Log log = LogFactory.getLog(ReportValueQueryDAOImpl.class);
	
	/** 流程XML对应关系管理对象 */
	protected XMLFileManager xmlFileManager;
	
	/** 数据库连接管理对象 */
	protected IGConnectPoolManager connectPoolManager;

	/**
	 * 流程XML对应关系管理对象设定
	 * @param xmlFileManager 流程XML对应关系管理对象
	 */
	public void setXmlFileManager(XMLFileManager xmlFileManager) {
		this.xmlFileManager = xmlFileManager;
	}

	/**
	 * 数据库连接管理对象设定
	 * @param connectPoolManager 数据库连接管理对象
	 */
	public void setConnectPoolManager(IGConnectPoolManager connectPoolManager) {
		this.connectPoolManager = connectPoolManager;
	}

	/**
	 * 查询报表表单值
	 * 通过流程定义ID，取得XML配置文件名称，通过XML文件取得该流程对应的所有取值sql
	 * 通过连接取得所有的表单值组装成Map返回
	 * 返回值格式：key -- 表单全路径（例：顶级标题#二级标题#三级标题）
	 *            value -- 表单值集合，可能是多行，所以是个List
	 * @param pdid 报表流程ID
	 * @return 表单值结合
	 */
	@SuppressWarnings("unchecked")
	public Map<String,List<String>> getValue(String pdid){
		log.debug("==============查询表单值操作开始=============");
		//装载表单值数据
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		//判断集成是否开启
		if(Boolean.parseBoolean(ResourceUtility.getString("REPORT_IS_START"))){
			//取得对应XML文件根路径
			String path = ResourceUtility.getString("REPORT_XML_ROOT_PATH");
			//取得子集目录名称（年报、季报、不定期分别对应 Annual、Quarterly、Occasional三个目录）
			String dir = xmlFileManager.getDir(pdid);
			//从配置中取得xml文件名称
			String filename = xmlFileManager.getFileName(pdid);
			//检测文件存在
			if(StringUtils.isNotEmpty(filename)){
				String allFileName = path + File.separator + dir + File.separator + filename;
				//初始化文档
				try {
					/*
					 	文档格式
						<?xml version="1.0" encoding="UTF-8"?>
						<Root>
							<DATE>2014-06-11 11:10:09</DATE>
							<DATA>
								<SOURCE>ds1</SOURCE>  //对应config.xml中数据库连接配置的名称
								<FORMURL>信息科技战略规划#信息科技战略规划名称</ FORMURL >  
								<SQL>select pivarname from ig.ig599 where piid = 4030</ SQL >
							</ DATA >
							<DATA>
								<SOURCE>ds1</SOURCE>  //对应config.xml中数据库连接配置的名称
								<FORMURL>信息科技战略规划#是否建立信息科技战略规划</ FORMURL >  
								<DBNAME>IG1</ DBNAME >
								<SQL>select pivarname from ig.ig599 where piid = 4031</ SQL >
							</ DATA >
						</Root>
					*/
					Document doc = XMLUtils.readXmlJdom(allFileName);
					//取得根节点
					Element root = doc.getRootElement();
					//取得配置集合
					List<Element> list = root.getChildren();
					//如果数据存在，循环添加
					if(list != null && list.size() > 0){
						for(int i=0;i<list.size();i++){
							Element e = list.get(i);
							//取得连接标识名称（根据标识名称去连接池管理对象中取得对应的连接）
							String sourceName = e.getChildText("SOURCE");
							//取得表单全路径 （表单的唯一标识）
							String formUrl = e.getChildText("FORMURL");
							//取得SQL语句
							String sql = e.getChildText("SQL");
							//取得连接
							IGConnection con = connectPoolManager.getCon(sourceName);
							if(con == null){
								throw new BLException("IGCO10000.E004","数据库连接");
							}
							//取得数据库连接对象
							Connection connection = con.getConnection();
							//取得查询对象
							PreparedStatement pstm = connection.prepareStatement(sql);
							//查询结果
							ResultSet rs = pstm.executeQuery();
							//存放表单值
							List<String> valueList = new ArrayList<String>();
							//遍历结果集存放表单值
							while(rs.next()){
								valueList.add(rs.getString(1));
							}
							//组装数据
							if(!valueList.isEmpty()){
								map.put(formUrl, valueList);
							}
							//close 结果集
							rs.close();
							//close 查询对象
							pstm.close();
							//释放连接对象
							con.release();
						}
					}
					
					//释放数据库连接为初始状态（保持最小连接数）
					connectPoolManager.release();
				} catch (Exception e) {
					log.error("",e);
				}
			}
		}
		log.debug("==============查询表单值操作结束=============");
		return map;
	}
}
