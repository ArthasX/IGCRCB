package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.infogovernor.common.UserIdName;

public class UserNameValueTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	protected String userid;
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int doStartTag() throws JspException {
		String username = UserIdName.getUserNameByUserId(userid);
		TagUtils.getInstance().write(pageContext, username);
		return (EVAL_BODY_INCLUDE);
	}

}