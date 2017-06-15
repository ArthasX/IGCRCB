/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.report.jdbc.connectpool;

import java.sql.SQLException;

import com.dev.crc.report.jdbc.connection.IGConnection;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ӳض���ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGConnectPool {

	/**
	 * ��ȡ���Ӷ���
	 * @return ���Ӷ���
	 * @throws ClassNotFoundException driver����ʧ��
	 * @throws SQLException ���������쳣
	 * @throws InterruptedException �߳��쳣
	 */
	public IGConnection getCon() throws ClassNotFoundException,SQLException,InterruptedException;
	
	/**
	 * �ͷŶ�������
	 * ����ʹ�ô��ڿ���״̬����Ҫ�ͷŵ����������
	 * ����Ϊ��������С���������������������ȫ���ر�
	 */
	public void release() throws SQLException;
	
	/**
	 * �ر����ӳ�
	 * ���򣺲������κ����ӣ�ȫ���ر�
	 */
	public void close() throws SQLException;
}
