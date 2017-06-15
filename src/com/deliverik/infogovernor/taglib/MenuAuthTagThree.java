/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.User;
/**
 * @Description: 菜单标签
 * @Author  
 * @History 2009-8-19     新建 
 *          2010-5-10     修改   0000476  admin用户权限的限制
 * @Version V2.0
 */

@SuppressWarnings("serial")
public class MenuAuthTagThree extends BodyTagSupport {
	// 菜单命名
	protected String actname;

	// 根据权限判断是否显示内容
	protected String permission;

	public String getActname() {
		return actname;
	}

	public void setActname(String actname) {
		this.actname = actname;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@SuppressWarnings("deprecation")
	public int doStartTag() throws JspException {
		boolean flag = false;
		if (StringUtils.isEmpty(permission)) {
			//如果不是permission为空 则按权限显示
			flag = true;
		} else if(!"true".equals(permission) || !"false".equals(permission)) {
			//如果不是permission为无效值 取permission=false，按无权限显示
			flag = false;
		}
		UserPermission userPermission = (UserPermission) this.pageContext.getSession().getAttribute("UserPermission");
		//==================> 0000476
		User user = (User)this.pageContext.getSession().getAttribute(BaseAction.SESSION_KEY_LOGIN_USER);
		String userid = user.getUserid();//admin
		if(!flag) {
			if (userPermission.checkPermission(actname)) {
				return EVAL_BODY_TAG;
			} else if ("admin".equals(userid) && actname.contains("ACT09SYM")) {
				if(actname.contains("ACT09SYM04") || actname.equals("ACT09SYM")){
					return EVAL_BODY_TAG;
				}else{
					return SKIP_BODY;
				}
			} else {
				return SKIP_BODY;
			}
		} else {
			if (userPermission.checkPermission(actname)) {
				return SKIP_BODY;
			} else if ("admin".equals(userid) && actname.contains("ACT09SYM")) {
				if(actname.contains("ACT09SYM04") || actname.equals("ACT09SYM")){
					return EVAL_BODY_TAG;
				}else{
					return SKIP_BODY;
				}
			}  else {
				return EVAL_BODY_TAG;
			}
		}
		
		//<=========================
	}

	public int doEndTag() {
		return EVAL_PAGE;
	}

	public void doInitTag() {
	}

	public int doAfterBody() throws JspException {
		BodyContent body = getBodyContent();
		try {
			body.writeOut(body.getEnclosingWriter());
		} catch (IOException exc) {
			throw new JspException(exc.toString());
		}
		return SKIP_BODY;

	}

	/**
	 * 释放资源
	 */
	public void release() {
		super.release();
		actname = null;
		permission = null;
	}

}