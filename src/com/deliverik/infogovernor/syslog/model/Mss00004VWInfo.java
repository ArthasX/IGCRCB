package com.deliverik.infogovernor.syslog.model;

public interface Mss00004VWInfo {
	/**
	 * ruletempid取得
	 *
	 * @return ruletempid
	 */
	public Integer getRuletempid();

	/**
	 * devicetype取得
	 *
	 * @return devicetype
	 */
	public String getRuletempname();


	/**
	 * tempstate取得
	 *
	 * @return tempstate
	 */
	public Integer getTempstate();
	
	/**
	 * 设备类型取得
	 */
	public String getTypeid();
	
	/**
	 * 规则条件取得
	 */
	public Integer getRulecondition();
	
	/**
	 * 创建时间取得
	 */
	public String getCreatetime();
	
	/**
	 * 描述取得
	 */
	public String getTempdesc();
	
	/**
	 * 条件个数取得
	 */
	public String getConditionCount();
	
	public String getSummary();
}
