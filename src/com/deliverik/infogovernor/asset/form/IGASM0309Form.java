package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

public class IGASM0309Form extends BaseForm {

	private static final long serialVersionUID = 1L;
	protected Integer eiid;
	protected String orgid;
	protected String orgname;
	protected String reciveUser;
	/** 设备批量下发对象 */
	protected String[] issueEiid;
	
	/** 设备当前版本号 */
	protected String eiversion;
	
	/** 设备批量下发对象 */
	protected String issue;
	
	protected String type;
	
	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getIssueEiid() {
		return issueEiid;
	}

	public void setIssueEiid(String[] issueEiid) {
		this.issueEiid = issueEiid;
	}

	public String getEiversion() {
		return eiversion;
	}

	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getReciveUser() {
		return reciveUser;
	}

	public void setReciveUser(String reciveUser) {
		this.reciveUser = reciveUser;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
