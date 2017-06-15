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
 * Description: ���ӳع������ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGConnectPoolManager {

	/**
	 * ��ȡ����
	 * @param sourceName ��ʶ����
	 * @return ���Ӷ���
	 * @throws ClassNotFoundException ����������ʧ��
	 * @throws SQLException ���������쳣
	 * @throws InterruptedException �̵߳ȴ��쳣
	 */
	public IGConnection getCon(String sourceName) throws ClassNotFoundException,
			SQLException,InterruptedException;
	
	/**
	 * ��ԭ���ݿ�����Ϊ��ʼ״̬����������С����������
	 * @throws SQLException
	 */
	public void release() throws SQLException;
}
