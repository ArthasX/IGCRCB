package com.deliverik.infogovernor.scheduling.model.condition;

public interface QuartzJobsSearchCond {

	public abstract String getQjcrtuser();
	
	public abstract String getQjimpluser();
	
	public abstract String getQjstatus();
	
	public abstract String getQjtype();
	
	public abstract String getQjname();
	
	public abstract String getQjtriname();
	
	public abstract String getStartTime();
	
	public abstract String getEndTime();
	
	public abstract Integer getQjid();
	
	public abstract String getQjcrtusername();
	
	public abstract String getQjimplusername();
	
	public abstract String getQjassetid();
	
	public abstract String getQjassettypeid();
	
	public String getQjtype_q();
	
	public String getDate_q();
	
	public String getDate_j();
	
	public String getDate();
	
	public String getYmonth_q();

	public String getUserid();
}
