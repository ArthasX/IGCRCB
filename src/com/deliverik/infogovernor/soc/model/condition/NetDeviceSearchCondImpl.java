/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.condition;

/**
 * ����: �����豸�˿ڼ��������ӿ�ʵ��
 * ��������: �����豸�˿ڼ��������ӿ�ʵ��
 * ������¼: 2013/12/30
 * �޸ļ�¼: 
 */
public class NetDeviceSearchCondImpl implements NetDeviceSearchCond {
	
	/** eilabel_lk_devname */
	protected String eilabel_lk_devname;
	/** eilabel_lk_ip */
	protected String eilabel_lk_ip;
	/** civalue */
	protected String civalue_eq;

	/**
	 * eilabel_lk_devnameȡ��
	 *
	 * @return eilabel_lk_devname eilabel_lk_devname
	 */
	public String getEilabel_lk_devname() {
		return eilabel_lk_devname;
	}
	/**
	 * eilabel_lk_ipȡ��
	 *
	 * @return eilabel_lk_ip eilabel_lk_ip
	 */
	public String getEilabel_lk_ip() {
		return eilabel_lk_ip;
	}
	/**
	 * civalue_eqȡ��
	 *
	 * @return civalue_eq civalue_eq
	 */
	public String getCivalue_eq() {
		return civalue_eq;
	}
	/**
	 * eilabel_lk_devname�趨
	 *
	 * @param eilabel_lk_devname eilabel_lk_devname
	 */
	public void setEilabel_lk_devname(String eilabel_lk_devname) {
		this.eilabel_lk_devname = eilabel_lk_devname;
	}
	/**
	 * eilabel_lk_ip�趨
	 *
	 * @param eilabel_lk_ip eilabel_lk_ip
	 */
	public void setEilabel_lk_ip(String eilabel_lk_ip) {
		this.eilabel_lk_ip = eilabel_lk_ip;
	}
	/**
	 * civalue_eq�趨
	 *
	 * @param civalue_eq civalue_eq
	 */
	public void setCivalue_eq(String civalue_eq) {
		this.civalue_eq = civalue_eq;
	}

}