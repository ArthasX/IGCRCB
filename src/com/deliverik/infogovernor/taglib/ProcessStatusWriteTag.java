package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.infogovernor.common.ProcessStatusValueBean;

public class ProcessStatusWriteTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	protected String prid;
	
	public int doStartTag() throws JspException {
		String out = ProcessStatusValueBean.getProcessStatus(prid);
		TagUtils.getInstance().write(pageContext, out);
		return (EVAL_BODY_INCLUDE);
	}

	public String getPrid() {
		return prid;
	}

	public void setPrid(String prid) {
		this.prid = prid;
	}


}