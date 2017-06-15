/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.report.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.deliverik.framework.utility.IGStringUtils;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ݿ����Ӷ���ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGConnectionImpl implements IGConnection{
	
	/** ״̬������ */
	private static final String STATUS_LEISURE = "L";
	
	/** ״̬��ʹ���� */
	private static final String STATUS_USING = "U";

	/** ���Ӷ��� */
	protected Connection connection;
	
	/** ����״̬ */
	protected String status;
	
	/** ����ʱ�� */
	protected String createTime;
	
	/** �ͷ�ʱ�� */
	protected String releaseTime;
	
	/**
	 * ���췽��
	 * @param driver driver��·��
	 * @param url ����URL
	 * @param username �û���
	 * @param password ����
	 */
	public IGConnectionImpl(String driver,String url ,String username,String password) 
			throws ClassNotFoundException,SQLException{
		//����driver
		Class.forName(driver);
		//ȡ�����Ӷ���
		Connection conn = DriverManager.getConnection(url, username, password);
		//���õ�ǰ���Ӷ���
		connection = conn;
		//����״̬Ϊ����
		status = STATUS_LEISURE;
		//���ô���ʱ��
		createTime = IGStringUtils.getCurrentDateTime();
		//��ʼ���ͷ�ʱ��Ϊ����ʱ��
		releaseTime = createTime;
	}
	
	/**
	 * ȡ�õ�ǰ����
	 * @return ���ݿ����Ӷ���
	 */
	public IGConnection getCon(){
		//����״̬Ϊʹ����
		this.status = STATUS_USING;
		return this;
	}
	
	/**
	 * ��ȡ���Ӷ���
	 * @return ���Ӷ���
	 */
	public Connection getConnection(){
		if(STATUS_USING.equals(status)){
			return this.connection;
		}else{
			return null;
		}
	}
	
	/**
	 * �ͷ���Դ
	 */
	public void release(){
		//����״̬Ϊ�ͷ�
		this.status = STATUS_LEISURE;
		//�����ͷ�ʱ��
		this.releaseTime = IGStringUtils.getCurrentDateTime();
	}
	
	/**
	 * ��ǰ�����Ƿ����
	 * @return
	 */
	public boolean isLeisure(){
		return STATUS_LEISURE.equals(status);
	}
	
	/**
	 * �ر����ݿ�����
	 * @throws SQLException ���ݿ����ӹر��쳣
	 */
	public void close() throws SQLException{
		this.connection.close();
	}
}
