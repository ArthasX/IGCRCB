/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: ������������ʵ��
  * ��������: ������������ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class CITaskSearchCondImpl implements
		CITaskSearchCond {
	
	/** �������� */
	protected String citdesc_like;

	/** ��ʼʱ��*/
	protected String cittime_from;
	
	/** ����ʱ��*/
	protected String cittime_to;
	
	/** ״̬ */
	protected String citstatus_eq;
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getCitdesc_like() {
		return citdesc_like;
	}

	/**
	 * ���������趨
	 * @param citdesc��������
	 */

	public void setCitdesc_like(String citdesc_like) {
		this.citdesc_like = citdesc_like;
	}

	/**
	 * ��ʼʱ��ȡ��
	 * @return ��ʼʱ��
	 */
	public String getCittime_from() {
		return cittime_from;
	}

	/**
	 * ��ʼʱ���趨
	 * @param cittime_from��ʼʱ��
	 */
	public void setCittime_from(String cittime_from) {
		this.cittime_from = cittime_from;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getCittime_to() {
		return cittime_to;
	}

	/**
	 * ����ʱ���趨
	 * @param cittime_to����ʱ��
	 */
	public void setCittime_to(String cittime_to) {
		this.cittime_to = cittime_to;
	}

	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getCitstatus_eq() {
		return citstatus_eq;
	}

	/**
	 * ״̬�趨
	 * @param citstatus_eq ״̬
	 */
	public void setCitstatus_eq(String citstatus_eq) {
		this.citstatus_eq = citstatus_eq;
	}
	
}