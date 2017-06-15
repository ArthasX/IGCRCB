package com.deliverik.infogovernor.scheduling.model;

import com.deliverik.framework.base.BaseModel;

public interface QuartzProcessParticipant  extends BaseModel {

	public abstract Integer getQppid();

	public abstract Integer getQprid();

	public abstract Integer getQpproleid();
	
	public abstract String getQpporgid();
	
	public abstract String getQpporgname();

	public abstract String getQpprolename();

	public abstract String getQppuserid();

	public abstract String getQppusername();

	public abstract String getQpptype();

	public abstract String getQppuserinfo();

	public abstract String getQppcomment();

	public abstract String getQppstatus();

	public abstract String getQppattkey();
	
	public abstract String getQppinittime();
	
	public abstract String getQppproctime();
	
	public abstract String getQppsubstatus();
}