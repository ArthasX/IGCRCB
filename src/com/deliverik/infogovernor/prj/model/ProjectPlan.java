package com.deliverik.infogovernor.prj.model;

import com.deliverik.framework.base.BaseModel;

public interface ProjectPlan  extends BaseModel {

	public abstract Integer getPplid();

	public abstract Integer getPid();

	public abstract String getPplinfo();

	public abstract Integer getPplversion();

	public abstract String getPplstatus();

	public abstract String getPpldesc();

	public abstract String getPpldate();
	
	public String getPpltitle() ;

	public String getPplclosetime();
	
	public String getPplriskatt();
	
	public String getPplopentime();
	
	public String getPplshuttime() ;
}