package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.infogovernor.common.PrjTypeValueBean;

public class PRJTypeWriteTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	protected String ptype;
	
	public int doStartTag() throws JspException {
		String out = PrjTypeValueBean.getConfigInfo(ptype);
		TagUtils.getInstance().write(pageContext, out);
		return (EVAL_BODY_INCLUDE);
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	
	
}