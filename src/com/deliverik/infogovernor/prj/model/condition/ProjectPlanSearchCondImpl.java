package com.deliverik.infogovernor.prj.model.condition;

/**
 * 
 */
public class ProjectPlanSearchCondImpl implements ProjectPlanSearchCond {

	protected Integer pid;
	
	protected Integer pplversion;
	
	protected String pplstatus;
	
	protected String orderdesc;

	public Integer getPplversion() {
		return pplversion;
	}

	public void setPplversion(Integer pplversion) {
		this.pplversion = pplversion;
	}

	public String getPplstatus() {
		return pplstatus;
	}

	public void setPplstatus(String pplstatus) {
		this.pplstatus = pplstatus;
	}
	
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getPid() {
		return pid;
	}

	public String getOrderdesc() {
		return orderdesc;
	}

	public void setOrderdesc(String orderdesc) {
		this.orderdesc = orderdesc;
	}

}
