package com.deliverik.infogovernor.sym.model.condition;

public interface NoticeSearchCond {

	public abstract String getNname();
	
	public abstract String getNtime_from();
	
	public abstract String getNtime_to();
	public abstract String getNid();
	public abstract String getDate();
	public abstract String getUserid();
	
	public String getPagetype();//人员 或 角色
	public String getTuserid();//人员id
	public String getTroleid();//角色id
	/**
	 * @return the fingerprint
	 */
	public String getFingerprint();
	public String[] getTroleids();//角色ids
}
