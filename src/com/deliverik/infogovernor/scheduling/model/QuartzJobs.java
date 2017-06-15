package com.deliverik.infogovernor.scheduling.model;

import com.deliverik.framework.base.BaseModel;

public interface QuartzJobs  extends BaseModel {

	public abstract Integer getQjid();

	public abstract String getQjname();

	public abstract String getQjdesc();
	
	public abstract String getQjtriname();
	
	public abstract String getQjtrigrp();
	
	public abstract String getQjtricron();
	
	public abstract String getQjcrtuser();
	
	public abstract String getQjimpluser();

	public abstract String getQjcrttime();

	public abstract String getQjendtime();
	
	public abstract String getQjtype();

	public abstract String getQjstatus();

	public abstract String getQjinfo();
	
	public abstract String getQjcrtusername();
	
	public abstract String getQjimplusername();
	
	public abstract String getQjperiodinfo();
	
	public String getQjorgid();

	public String getQjorgname();
	
	public abstract String getQjassetid();
	
	public abstract String getQjassettypeid();
	
	public String getQjdtime();
	
}