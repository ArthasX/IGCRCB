/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.emo.model.condition;

/**
  * ����: oracle���ܲɼ���������ʵ��
  * ��������: oracle���ܲɼ���������ʵ��
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
public class EmSearchCondImpl implements
		EmSearchCond {
	
	/** ���� */
	protected String em_type;
	
	/** ���ʱ��*/
	protected String max_collecttime;
	
	/** �ܺ͵���*/
	protected String order_Totail_desc;
	
	/** ʵ����ѯ */
	protected String fingerprint;

	/**
	 * ����ȡ��
	 * @return em_type ����
	 */
	public String getEm_type() {
		return em_type;
	}

	/**
	 * �����趨
	 * @param em_type ����
	 */
	public void setEm_type(String em_type) {
		this.em_type = em_type;
	}

	/**
	 * ���ʱ��ȡ��
	 * @return max_collecttime ���ʱ��
	 */
	public String getMax_collecttime() {
		return max_collecttime;
	}

	/**
	 * ���ʱ���趨
	 * @param max_collecttime ���ʱ��
	 */
	public void setMax_collecttime(String max_collecttime) {
		this.max_collecttime = max_collecttime;
	}

	/**
	 * �ܺ͵���ȡ��
	 * @return order_Totail_desc �ܺ͵���
	 */
	public String getOrder_Totail_desc() {
		return order_Totail_desc;
	}

	/**
	 * �ܺ͵����趨
	 * @param order_Totail_desc �ܺ͵���
	 */
	public void setOrder_Totail_desc(String order_Totail_desc) {
		this.order_Totail_desc = order_Totail_desc;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	
}