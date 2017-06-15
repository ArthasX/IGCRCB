package com.deliverik.infogovernor.sym.model.condition;

public interface NoticeSearchCond {

	public abstract String getNname();
	
	public abstract String getNtime_from();
	
	public abstract String getNtime_to();
	public abstract String getNid();
	public abstract String getDate();
	public abstract String getUserid();
	
	public String getPagetype();//��Ա �� ��ɫ
	public String getTuserid();//��Աid
	public String getTroleid();//��ɫid
	/**
	 * @return the fingerprint
	 */
	public String getFingerprint();
	public String[] getTroleids();//��ɫids
}
