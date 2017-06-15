/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ӳع������ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGConnectPoolManagerImpl implements IGConnectPoolManager{
	
	/** ��־���� */
	protected static final Log log = LogFactory.getLog(IGConnectPoolManagerImpl.class);

	/** ���ӳش洢����key ���ӳ����ƣ�value ���ӳ� */
	protected Map<String, IGConnectPool> conPoolMap = new HashMap<String, IGConnectPool>();
	
	/**
	 * ��ʼ������
	 */
	public void init(){
		//�жϼ����Ƿ���
		if(Boolean.parseBoolean(ResourceUtility.getString("REPORT_IS_START"))){
			//�����̳߳�ʼ�����ӳ�
			Thread t = new Thread(new Runnable() {
				
				/**
				 * �߳����
				 */
				@SuppressWarnings("unchecked")
				public void run() {
					//---------------��ʼ�����ӳ�------------------
					//ȡ�������ļ���
					String filename = ResourceUtility.getString("REPORT_DATASOURCE_CONFIG_FILE");
					try {
						/*
							�ĵ���ʽ��
							<?xml version="1.0" encoding="UTF-8"?>
							<!-- ���ڵ� -->
							<root>
								<!-- �ӽڵ㣺��������������Ϣ -->
								<DataSource>
									<!-- �������ƣ��Զ��壬Ψһ��ʹ��ʱƾ������ƻ�ȡ��Ӧ���� -->
									<name>ds1</name>
									<!-- ������·�� -->
									<driverClass>com.ibm.db2.jcc.DB2Driver</driverClass>
									<!-- ����URL -->
									<jdbc>jdbc:db2://202.96.64.68:50000/IG</jdbc>
									<!-- �û��� -->
									<username>db2inst1</username>
									<!-- ���� -->
									<password>db2inst1</password>
									<!-- ��С���������������ָ��Ĭ��Ϊ 5 -->
									<minnum>5</minnum>
									<!-- ������������������ָ��Ĭ��Ϊ 50 -->
									<maxnum>50</maxnum>
								</DataSource>
								<!-- �ӽڵ㣺��������������Ϣ -->
								<DataSource>
									<!-- �������ƣ��Զ��壬Ψһ��ʹ��ʱƾ������ƻ�ȡ��Ӧ���� -->
									<name>ds2</name>
									<!-- ������·�� -->
									<driverClass>com.ibm.db2.jcc.DB2Driver</driverClass>
									<!-- ����URL -->
									<jdbc>jdbc:db2://202.96.64.68:50000/IG</jdbc>
									<!-- �û��� -->
									<username>db2inst1</username>
									<!-- ���� -->
									<password>db2inst1</password>
									<!-- ��С���������������ָ��Ĭ��Ϊ 5 -->
									<minnum>5</minnum>
									<!-- ������������������ָ��Ĭ��Ϊ 50 -->
									<maxnum>50</maxnum>
								</DataSource>
							</root>
						*/
						//��ʼ���ĵ�
						Document doc = XMLUtils.readXmlJdom(filename);
						//ȡ�ø��ڵ�
						Element root = doc.getRootElement();
						//ȡ�����ü���
						List<Element> list = root.getChildren();
						//������ݴ��ڣ�ѭ�����
						if(list != null && list.size() > 0){
							for(int i=0;i<list.size();i++){
								Element e = list.get(i);
								//ȡ����������
								String name = e.getChildText("name");
								//ȡ��������·��
								String driver = e.getChildText("driverClass");
								//ȡ��url
								String url = e.getChildText("jdbc");
								//ȡ���û���
								String username = e.getChildText("username");
								//ȡ������
								String password = e.getChildText("password");
								//ȡ����С��������
								int minNum = StringUtils.isNotEmpty(e.getChildText("minnum")) ? Integer.valueOf(e.getChildText("minnum")) : 5;
								//ȡ�������������
								int maxNum = StringUtils.isNotEmpty(e.getChildText("maxnum")) ? Integer.valueOf(e.getChildText("maxnum")) : 50;
								//ʵ�������ӳ�
								IGConnectPool pool = new IGConnectPoolImpl(driver, url, username, password, minNum, maxNum);
								//���֮ǰ����ͬ�����ӳأ��ر�����������
								if(conPoolMap.get(name) != null){
									conPoolMap.get(name).close();
								}
								//װ�����ӳض���
								conPoolMap.put(name, pool);
							}
						}
					} catch (Exception e) {
						log.error("",e);
					}
				}
			});
			//�����߳�
			t.start();
		}
	}
	
	/**
	 * ��ȡ����
	 * @param sourceName ��ʶ����
	 * @return ���Ӷ���
	 * @throws ClassNotFoundException ����������ʧ��
	 * @throws SQLException ���������쳣
	 * @throws InterruptedException �̵߳ȴ��쳣
	 */
	public IGConnection getCon(String sourceName) throws ClassNotFoundException,
			SQLException,InterruptedException{
		//ȡ�ö�Ӧ���ӳ�
		IGConnectPool pool = conPoolMap.get(sourceName);
		if(pool == null){
			return null;
		}else{
			return pool.getCon();
		}
		
	}
	
	/**
	 * ��ԭ���ݿ�����Ϊ��ʼ״̬����������С����������
	 * @throws SQLException
	 */
	public void release() throws SQLException {
		//�������ӳأ��ͷ��ͷ�����Ϊ��ʼ״̬
		for(Iterator<Entry<String, IGConnectPool>> iter = conPoolMap.entrySet().iterator();iter.hasNext();){
			Entry<String, IGConnectPool> entry = iter.next();
			IGConnectPool pool = entry.getValue();
			pool.release();
		}
	}
}
