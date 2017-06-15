/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.report.jdbc.connection;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ݿ����Ӷ���ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGConnection {

	/**
	 * ȡ�õ�ǰ����
	 * @return ���ݿ����Ӷ���
	 */
	public IGConnection getCon();
	
	/**
	 * ��ȡ���Ӷ���
	 * @return ���Ӷ���
	 */
	public Connection getConnection();
	
	/**
	 * �ͷ���Դ
	 */
	public void release();
	
	/**
	 * ��ǰ�����Ƿ����
	 * @return
	 */
	public boolean isLeisure();
	
	/**
	 * �ر����ݿ�����
	 * @throws SQLException ���ݿ����ӹر��쳣
	 */
	public void close() throws SQLException;
}
