package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.infogovernor.common.UserIdName;

/***
 * 根据ID 获取用户名
 * @author zhao
 *
 */

public class UserNameSValueTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	protected String userids;
	
	public String getUserids() {
		return userids;
	}

	public void setUserids(String userids) {
		this.userids = userids;
	}

	public int doStartTag() throws JspException {
		String username = "";
		
		String[] userid = userids.split(",");
		for (int i=0;i<userid.length;i++){
			username  += UserIdName.getUserNameByUserId(userid[i])+",";	
		}
		
		if(username!=""){
		TagUtils.getInstance().write(pageContext, username.substring(0,username.length()-1));
		}else {
			TagUtils.getInstance().write(pageContext,username);
		}
		return (EVAL_BODY_INCLUDE);
	}

}