package com.deliverik.infogovernor.scheduling.model;

import com.deliverik.framework.base.BaseModel;

public interface QuartzProcessRecord  extends BaseModel {

	public abstract Integer getQprid();

	public abstract String getQprtype();

	public abstract String getQprsubtype();

	public abstract String getQprstatus();

	public abstract String getQprsubstatus();

	public abstract String getQprtitle();

	public abstract String getQprdesc();

	public abstract String getQpropentime();

	public abstract String getQprclosetime();

	public abstract String getQprplantime();

	public abstract String getQprduration();

	public abstract String getQprurgency();

	public abstract String getQprimpact();

	public abstract Integer getQprassetid();

	public abstract String getQprassetname();

	public abstract String getQprbusiness();

	public abstract String getQprimplplan();

	public abstract String getQprbackplan();

	public abstract String getQprvfyplan();
	
	public abstract Integer getQpid();
	
	public abstract String getQpcode();
	
	public abstract String getQpname();
	
	public abstract String getQprinfo();
	
	public abstract Integer getQprcorid();
	
	public abstract String getQprcortype();
	
	public abstract String getQprcortitle();
	
	public abstract String getQprassetcategory();
	
	public abstract String getQpruserid();
	
	public abstract String getQprusername();
	
	public abstract Integer getQprroleid();
	
	public abstract String getQprrolename();
	
	public abstract String getQprpdid();
	
	public abstract String getQprpdname();
	
	public abstract String getQprorgid();
	
	public abstract String getQprorgname();
	
	public abstract String getQprattkey();

}