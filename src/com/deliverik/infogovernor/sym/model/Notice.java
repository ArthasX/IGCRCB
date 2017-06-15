package com.deliverik.infogovernor.sym.model;

import com.deliverik.framework.base.BaseModel;

public interface Notice  extends BaseModel {
	
	public abstract Integer getNid();

	public abstract String getNname();

	public abstract String getNdesc();
	
	public abstract String getNuserid();
	
	public abstract String getNusername();
	
	public abstract String getNorgid();
	
	public abstract String getNorgname();
	
	public abstract String getNtime();

	public abstract String getNattkey();

	//通知管理 add 2015-2-3 11:18:33 begin
	public abstract String getNtargettype();
	
	public abstract String getNtargetuserid();
	
	public abstract String getNtargetusername();
	
	public abstract String getNtargetroleid();
	
	public abstract String getNtargetrolename();
	
	public String getRoleid();
	
	public String getUserid();
	//通知管理 add 2015-2-3 11:18:33 end
}
