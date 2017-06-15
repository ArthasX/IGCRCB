/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.report.xml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;

import com.deliverik.framework.utility.ResourceUtility;
import com.dev.crc.report.utils.XMLUtils;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 报表流程对应XML文件名称管理类实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class XMLFileManagerImpl implements XMLFileManager{
	
	/** 日志对象 */
	protected static final Log log = LogFactory.getLog(XMLFileManagerImpl.class);

	/** 数据存储对象 */
	protected Map<String, String> map = new HashMap<String, String>();
	
	/**
	 * 初始化
	 */
	public void init(){
		//判断集成是否开启
		if(Boolean.parseBoolean(ResourceUtility.getString("REPORT_IS_START"))){
			/*
		 	XML格式：
		 	<?xml version="1.0" encoding="UTF-8"?>
			<!-- 根节点 -->
			<root>
				<!-- 对应关系 -->
				<relation>
					<!-- 流程定义主键前5位 -->
					<pdid>10000</pdid>
					<!-- XML文件名称 -->
					<filename>T-B-1.xml</filename>
				</relation>
				<!-- 对应关系 -->
				<relation>
					<!-- 流程定义主键前5位 -->
					<pdid>10001</pdid>
					<!-- XML文件名称 -->
					<filename>T-B-2.xml</filename>
				</relation>
		  	</root>
			 */
			//启动线程初始化文档信息
			Thread t = new Thread(new Runnable() {
				
				/**
				 * 线程入口
				 */
				@SuppressWarnings("unchecked")
				public void run() {
					//取得配置文件名
					String filename = ResourceUtility.getString("REPORT_XML_FILE_PROCESS_RELATION");
					//初始化文档
					try {
						//初始化文档
						Document doc = XMLUtils.readXmlJdom(filename);
						//取得根节点
						Element root = doc.getRootElement();
						//取得配置集合
						List<Element> list = root.getChildren();
						//如果数据存在，循环添加
						if(list != null && list.size() > 0){
							for(int i=0;i<list.size();i++){
								Element e = list.get(i);
								//取得流程定义ID
								String pdid = e.getChildText("pdid");
								//取得文件名称
								String xmlFileName = e.getChildText("filename");
								//装载数据
								map.put(pdid, xmlFileName);
							}
						}
					} catch (Exception e) {
						log.error("",e);
					}
				}
			});
			//启动线程
			t.start();
		}
	}
	
	/**
	 * 取得XML文件名称
	 * @param pdid 流程定义ID
	 * @return XML文件名称
	 */
	public String getFileName(String pdid){
		return map.get(pdid);
	}
	
	/**
	 * 取得XML文件目录
	 * @param pdid 流程定义ID
	 * @return 文件目录
	 */
	public String getDir(String pdid){
		//文件目录
		String dir = null;
		//取得流程定义ID第一位即可标识报表类别：1--年报、2--季报、3--不定期
		char c = pdid.charAt(0);
		switch (c) {
		//年报
		case '1':
			dir = "Annual";
			break;
		//季报
		case '2':
			dir = "Quarterly";
			break;
		//不定期
		case '3':
			dir = "Occasional";
			break;

		default:
			break;
		}
		return dir;
	}
}
