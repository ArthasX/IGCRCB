package com.deliverik.infogovernor.prj.model.condition;

/**
 * 
 */
public class ProjectSearchCondImpl implements ProjectSearchCond {

	protected String ptype;
	
	protected String pname;
	
	protected String pcode;
	
	protected String popentime;
	
	protected String pclosetime;
	
	protected String pstatus;
	
	protected Integer pbid_q;//‘§À„÷˜±ÌID

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.condition.ProjectSearchCond#getPtype()
	 */
	
	
	public String getPtype() {
		return ptype;
	}

	public Integer getPbid_q() {
		return pbid_q;
	}

	public void setPbid_q(Integer pbid_q) {
		this.pbid_q = pbid_q;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.condition.ProjectSearchCond#getPname()
	 */
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.condition.ProjectSearchCond#getPcode()
	 */
	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.condition.ProjectSearchCond#getPopentime()
	 */
	public String getPopentime() {
		return popentime;
	}

	public void setPopentime(String popentime) {
		this.popentime = popentime;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.condition.ProjectSearchCond#getPclosetime()
	 */
	public String getPclosetime() {
		return pclosetime;
	}

	public void setPclosetime(String pclosetime) {
		this.pclosetime = pclosetime;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.model.condition.ProjectSearchCond#getPstatus()
	 */
	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

}
