/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.IG622BL;
import com.deliverik.framework.user.model.User;

/**
 * 概述: 首页标题显示标签
 * 功能描述：首页标题显示标签
 * 创建记录：2012/07/18
 * 修改记录：
 */
@SuppressWarnings("serial")
public class HomePageTitleTag extends TagSupport {
	
	/** 首页跳转URL定义BL */
	private static IG622BL ig622BL = (IG622BL) WebApplicationSupport.getBean("ig622BL");
	
	public int doStartTag() throws JspException {
		User user = (User)pageContext.getSession().getAttribute(BaseAction.SESSION_KEY_LOGIN_USER);
		String usertype = user.getUsertype();
		StringBuffer retHtml = new StringBuffer("");
		try {
			retHtml.append("<li><a href=\"IGCOM0105.do?index=").append(usertype)
			.append("\" class=\"subscribe\" id=\"00\">&nbsp;&nbsp;")
			.append(ig622BL.getTitle(usertype)).append("</a></li>");
			//领导和业务人员还可以看见运维首页
			if("2".equals(usertype) || "3".equals(usertype)) {
				retHtml.append("<li><a href=\"IGCOM0105.do?index=1\" class=\"subscribe\" id=\"001\">&nbsp;&nbsp;")
				.append(ig622BL.getTitle("1")).append("</a></li>");
			}
		} catch (BLException e) {
			return (SKIP_BODY);
		}
		TagUtils.getInstance().write(pageContext, retHtml.toString());
		return (EVAL_BODY_INCLUDE);
	}


	/**
	 * 释放资源
	 */
	public void release() {
        super.release();
    }
	
}