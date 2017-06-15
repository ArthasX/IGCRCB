/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.report.jdbc.connectpool;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;

import com.deliverik.framework.utility.ResourceUtility;
import com.dev.crc.report.jdbc.connection.IGConnection;
import com.dev.crc.report.utils.XMLUtils;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 连接池管理对象实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGConnectPoolManagerImpl implements IGConnectPoolManager{
	
	/** 日志对象 */
	protected static final Log log = LogFactory.getLog(IGConnectPoolManagerImpl.class);

	/** 连接池存储对象：key 连接池名称，value 连接池 */
	protected Map<String, IGConnectPool> conPoolMap = new HashMap<String, IGConnectPool>();
	
	/**
	 * 初始化方法
	 */
	public void init(){
		//判断集成是否开启
		if(Boolean.parseBoolean(ResourceUtility.getString("REPORT_IS_START"))){
			//启动线程初始化连接池
			Thread t = new Thread(new Runnable() {
				
				/**
				 * 线程入口
				 */
				@SuppressWarnings("unchecked")
				public void run() {
					//---------------初始化连接池------------------
					//取得配置文件名
					String filename = ResourceUtility.getString("REPORT_DATASOURCE_CONFIG_FILE");
					try {
						/*
							文档格式：
							<?xml version="1.0" encoding="UTF-8"?>
							<!-- 根节点 -->
							<root>
								<!-- 子节点：具体链接配置信息 -->
								<DataSource>
									<!-- 链接名称，自定义，唯一；使用时凭借该名称获取对应链接 -->
									<name>ds1</name>
									<!-- 驱动类路径 -->
									<driverClass>com.ibm.db2.jcc.DB2Driver</driverClass>
									<!-- 链接URL -->
									<jdbc>jdbc:db2://202.96.64.68:50000/IG</jdbc>
									<!-- 用户名 -->
									<username>db2inst1</username>
									<!-- 密码 -->
									<password>db2inst1</password>
									<!-- 最小连接数量：如果不指定默认为 5 -->
									<minnum>5</minnum>
									<!-- 最大连接数量：如果不指定默认为 50 -->
									<maxnum>50</maxnum>
								</DataSource>
								<!-- 子节点：具体链接配置信息 -->
								<DataSource>
									<!-- 链接名称，自定义，唯一；使用时凭借该名称获取对应链接 -->
									<name>ds2</name>
									<!-- 驱动类路径 -->
									<driverClass>com.ibm.db2.jcc.DB2Driver</driverClass>
									<!-- 链接URL -->
									<jdbc>jdbc:db2://202.96.64.68:50000/IG</jdbc>
									<!-- 用户名 -->
									<username>db2inst1</username>
									<!-- 密码 -->
									<password>db2inst1</password>
									<!-- 最小连接数量：如果不指定默认为 5 -->
									<minnum>5</minnum>
									<!-- 最大连接数量：如果不指定默认为 50 -->
									<maxnum>50</maxnum>
								</DataSource>
							</root>
						*/
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
								//取得连接名称
								String name = e.getChildText("name");
								//取得驱动类路径
								String driver = e.getChildText("driverClass");
								//取得url
								String url = e.getChildText("jdbc");
								//取得用户名
								String username = e.getChildText("username");
								//取得密码
								String password = e.getChildText("password");
								//取得最小连接数量
								int minNum = StringUtils.isNotEmpty(e.getChildText("minnum")) ? Integer.valueOf(e.getChildText("minnum")) : 5;
								//取得最大连接数量
								int maxNum = StringUtils.isNotEmpty(e.getChildText("maxnum")) ? Integer.valueOf(e.getChildText("maxnum")) : 50;
								//实例化连接池
								IGConnectPool pool = new IGConnectPoolImpl(driver, url, username, password, minNum, maxNum);
								//如果之前存在同名连接池，关闭其所有连接
								if(conPoolMap.get(name) != null){
									conPoolMap.get(name).close();
								}
								//装载连接池对象
								conPoolMap.put(name, pool);
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
	 * 获取连接
	 * @param sourceName 标识名称
	 * @return 连接对象
	 * @throws ClassNotFoundException 加载驱动类失败
	 * @throws SQLException 创建连接异常
	 * @throws InterruptedException 线程等待异常
	 */
	public IGConnection getCon(String sourceName) throws ClassNotFoundException,
			SQLException,InterruptedException{
		//取得对应连接池
		IGConnectPool pool = conPoolMap.get(sourceName);
		if(pool == null){
			return null;
		}else{
			return pool.getCon();
		}
		
	}
	
	/**
	 * 还原数据库连接为初始状态（即保留最小连接数量）
	 * @throws SQLException
	 */
	public void release() throws SQLException {
		//遍历连接池，释放释放连接为初始状态
		for(Iterator<Entry<String, IGConnectPool>> iter = conPoolMap.entrySet().iterator();iter.hasNext();){
			Entry<String, IGConnectPool> entry = iter.next();
			IGConnectPool pool = entry.getValue();
			pool.release();
		}
	}
}
