/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: ���������������ʵ��
  * ��������: ���������������ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class AuditTaskSearchCondImpl implements
		AuditTaskSearchCond {
	
	/** ����������� */
	protected String autdesc_like;

	/** ��ʼʱ��*/
	protected String auttime_from;
	
	/** ����ʱ��*/
	protected String auttime_to;
	
	/** ״̬ */
	protected String autstatus_eq;
	
	
	
	/**
	 * �����������ȡ��
	 * @return �����������
	 */
	public String getAutdesc_like() {
		return autdesc_like;
	}

	/**
	 * ������������趨
	 * @param autdesc�����������
	 */

	public void setAutdesc_like(String autdesc_like) {
		this.autdesc_like = autdesc_like;
	}

	/**
	 * ��ʼʱ��ȡ��
	 * @return ��ʼʱ��
	 */
	public String getAuttime_from() {
		return auttime_from;
	}

	/**
	 * ��ʼʱ���趨
	 * @param auttime_from��ʼʱ��
	 */
	public void setAuttime_from(String auttime_from) {
		this.auttime_from = auttime_from;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getAuttime_to() {
		return auttime_to;
	}

	/**
	 * ����ʱ���趨
	 * @param auttime_to����ʱ��
	 */
	public void setAuttime_to(String auttime_to) {
		this.auttime_to = auttime_to;
	}
	
	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getAutstatus_eq() {
		return autstatus_eq;
	}
	
	/**
	 * ״̬�趨
	 * @param autstatus״̬
	 */
	public void setAutstatus_eq(String autstatus_eq) {
		this.autstatus_eq = autstatus_eq;
	}

}