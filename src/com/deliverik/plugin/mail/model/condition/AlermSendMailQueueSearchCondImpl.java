/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.mail.model.condition;


/**
  * ����: �ʼ����б��������ʵ��
  * ��������: �ʼ����б��������ʵ��
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
public class AlermSendMailQueueSearchCondImpl implements AlermSendMailQueueSearchCond {
	/** �����¼ʱ�� */
	protected String inserttime_begin;
	protected String inserttime_end;
	/** ���͸澯ʱ�� */
	protected String senttime_begin;
	protected String senttime_end;
	/** ���͸澯״̬ 0 δ����orʧ�� ;1���ͳɹ� */
	protected char sentstatus_eq;
	/**
	 * inserttime_beginȡ��
	 *
	 * @return inserttime_begin inserttime_begin
	 */
	public String getInserttime_begin() {
		return inserttime_begin;
	}
	/**
	 * inserttime_endȡ��
	 *
	 * @return inserttime_end inserttime_end
	 */
	public String getInserttime_end() {
		return inserttime_end;
	}
	/**
	 * senttime_beginȡ��
	 *
	 * @return senttime_begin senttime_begin
	 */
	public String getSenttime_begin() {
		return senttime_begin;
	}
	/**
	 * senttime_endȡ��
	 *
	 * @return senttime_end senttime_end
	 */
	public String getSenttime_end() {
		return senttime_end;
	}
	/**
	 * sentstatus_eqȡ��
	 *
	 * @return sentstatus_eq sentstatus_eq
	 */
	public char getSentstatus_eq() {
		return sentstatus_eq;
	}
	/**
	 * inserttime_begin�趨
	 *
	 * @param inserttime_begin inserttime_begin
	 */
	public void setInserttime_begin(String inserttime_begin) {
		this.inserttime_begin = inserttime_begin;
	}
	/**
	 * inserttime_end�趨
	 *
	 * @param inserttime_end inserttime_end
	 */
	public void setInserttime_end(String inserttime_end) {
		this.inserttime_end = inserttime_end;
	}
	/**
	 * senttime_begin�趨
	 *
	 * @param senttime_begin senttime_begin
	 */
	public void setSenttime_begin(String senttime_begin) {
		this.senttime_begin = senttime_begin;
	}
	/**
	 * senttime_end�趨
	 *
	 * @param senttime_end senttime_end
	 */
	public void setSenttime_end(String senttime_end) {
		this.senttime_end = senttime_end;
	}
	/**
	 * sentstatus_eq�趨
	 *
	 * @param sentstatus_eq sentstatus_eq
	 */
	public void setSentstatus_eq(char sentstatus_eq) {
		this.sentstatus_eq = sentstatus_eq;
	}
}