package com.deliverik.infogovernor.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.UserSearchCond;



/**
 * 登录画面用FORM
 * IGCOM0101Form ActionForm
 */
public class IGCOM0101Form extends BaseForm implements UserSearchCond{

	private static final long serialVersionUID = 1L;

	/**  */
	protected String userid;

	/**  */
	protected String password;
	
	protected String username;
	
	protected String orgid;
	
	protected String userid_q;
	
	protected String username_q;
	
	protected String userexist = "";
	
	protected String page_width;
	
	/** 逻辑删除标志位 */
	protected String deleteflag;

	public String getPage_width() {
		return page_width;
	}

	public void setPage_width(String page_width) {
		this.page_width = page_width;
	}

	/**
	 * 
	 * @return 
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 
	 * @param user_id 
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 
	 * @return 
	 */
	public String getPassword() {
	    return password;
	}

	/**
	 * 
	 * @param pass_word 
	 */
	public void setPassword(String password) {
	    this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getUserid_q() {
		return userid_q;
	}

	public void setUserid_q(String userid_q) {
		this.userid_q = userid_q;
	}

	public String getUsername_q() {
		return username_q;
	}

	public void setUsername_q(String username_q) {
		this.username_q = username_q;
	}

	public String getUsermobile() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	public String getUserstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUserexist() {
		return userexist;
	}

	public void setUserexist(String userexist) {
		this.userexist = userexist;
	}

	public String getUserinfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUserinfo_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getUserid_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOrgid_like() {
		// TODO Auto-generated method stub
		return null;
	}

}
