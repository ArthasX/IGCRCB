/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.condition;

/**
 * ������Ӧ����־��Ϣ���������ʵ��
 * ����������Ӧ����־��Ϣ���������ʵ��
 * ������¼��2014/05/19
 * (1)�����뽵������������EmergencyLogTB�е��ֶ���Ϊ��������ֻ�Ǽ�����û�漰���ӹ�ϵ
 * �޸ļ�¼��
 */
public class EmergencyLogSearchCondImpl implements EmergencyLogSearchCond {
	/**Ӧ���������ID(��ȫƥ��)*/
	protected String elprid_eq;
	/**��־��Ϣ����(��ȫƥ��)*/
	protected String ellitype_eq;
	
	protected String[] psdid_in;

	/**��������������*/
	protected String[] ascs;
	/**��������������*/
	protected String[] desc;
	
	protected Integer[] prid_in;
	
	
	/**
	 * @return the prid_in
	 */
	public Integer[] getPrid_in() {
		return prid_in;
	}
	/**
	 * @param prid_in the prid_in to set
	 */
	public void setPrid_in(Integer[] prid_in) {
		this.prid_in = prid_in;
	}
	/**
	 * Getter and Setter
	 */
	/**
	 * Ӧ���������ID(��ȫƥ��)ȡ��
	 * @return elprid_eq
	 */
	public String getElprid_eq() {
		return elprid_eq;
	}
	/**
	 * Ӧ���������ID(��ȫƥ��)�趨
	 * @param elprid_eq
	 */
	public void setElprid_eq(String elprid_eq) {
		this.elprid_eq = elprid_eq;
	}
	
	/**
	 * ��־��Ϣ����(��ȫƥ��)ȡ��
	 * @return ellitype_eq
	 */
	public String getEllitype_eq() {
		return ellitype_eq;
	}
	/**
	 * ��־��Ϣ����(��ȫƥ��)�趨
	 * @param ellitype_eq
	 */
	public void setEllitype_eq(String ellitype_eq) {
		this.ellitype_eq = ellitype_eq;
	}
	
	/**
	 * ��������������ȡ��
	 * @return ascs
	 */
	public String[] getAscs() {
		return ascs;
	}
	/**
	 * ���������������趨
	 * @param ascs
	 */
	public void setAscs(String[] ascs) {
		this.ascs = ascs;
	}
	
	/**
	 * ��������������ȡ��
	 * @return desc
	 */
	public String[] getDesc() {
		return desc;
	}
	/**
	 * ���������������趨
	 * @param desc
	 */
	public void setDesc(String[] desc) {
		this.desc = desc;
	}
	public String[] getPsdid_in() {
		return psdid_in;
	}
	public void setPsdid_in(String[] psdid_in) {
		this.psdid_in = psdid_in;
	}
}