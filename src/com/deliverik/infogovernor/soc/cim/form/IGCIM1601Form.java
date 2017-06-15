package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 人员查询画面FORM
 * 
 */
public class IGCIM1601Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	private Integer pid;
	private String pwdType;
	private String userName;
	private String pwd;
	private String pwdDescription;
	private String regDate;
	private String serverIP;
	
	

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPwdType() {
		return pwdType;
	}

	public void setPwdType(String pwdType) {
		this.pwdType = pwdType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwdDescription() {
		return pwdDescription;
	}

	public void setPwdDescription(String pwdDescription) {
		this.pwdDescription = pwdDescription;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

}
