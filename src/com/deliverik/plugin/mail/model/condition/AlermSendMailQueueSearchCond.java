/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.mail.model.condition;

/**
  * ����: �ʼ����б���������ӿ�
  * ��������: �ʼ����б���������ӿ�
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
public interface AlermSendMailQueueSearchCond {
	/**
	 * inserttime_beginȡ��
	 *
	 * @return inserttime_begin inserttime_begin
	 */
	public String getInserttime_begin();
	/**
	 * inserttime_endȡ��
	 *
	 * @return inserttime_end inserttime_end
	 */
	public String getInserttime_end();
	/**
	 * senttime_beginȡ��
	 *
	 * @return senttime_begin senttime_begin
	 */
	public String getSenttime_begin();
	/**
	 * senttime_endȡ��
	 *
	 * @return senttime_end senttime_end
	 */
	public String getSenttime_end();
	/**
	 * sentstatus_eqȡ��
	 *
	 * @return sentstatus_eq sentstatus_eq
	 */
	public char getSentstatus_eq();
}