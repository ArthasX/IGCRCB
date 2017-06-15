package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.csebank.common.OrgValueBean;

public class CSEOrgValueWriteTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	protected String orgsyscoding;
	
	public int doStartTag() throws JspException {
		String out = OrgValueBean.getConfigInfo(orgsyscoding);
		TagUtils.getInstance().write(pageContext, out);
		return (EVAL_BODY_INCLUDE);
	}

	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}
	
}