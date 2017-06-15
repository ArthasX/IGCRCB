package com.deliverik.infogovernor.syslog.model;

public interface Mss00004VWInfo {
	/**
	 * ruletempidȡ��
	 *
	 * @return ruletempid
	 */
	public Integer getRuletempid();

	/**
	 * devicetypeȡ��
	 *
	 * @return devicetype
	 */
	public String getRuletempname();


	/**
	 * tempstateȡ��
	 *
	 * @return tempstate
	 */
	public Integer getTempstate();
	
	/**
	 * �豸����ȡ��
	 */
	public String getTypeid();
	
	/**
	 * ��������ȡ��
	 */
	public Integer getRulecondition();
	
	/**
	 * ����ʱ��ȡ��
	 */
	public String getCreatetime();
	
	/**
	 * ����ȡ��
	 */
	public String getTempdesc();
	
	/**
	 * ��������ȡ��
	 */
	public String getConditionCount();
	
	public String getSummary();
}
