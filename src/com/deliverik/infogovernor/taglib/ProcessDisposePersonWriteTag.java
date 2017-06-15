package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.infogovernor.common.ProcessDisposePersonValueBean;

public class ProcessDisposePersonWriteTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	protected String prid;
	
	protected String prstatus;
	
	public int doStartTag() throws JspException {
		String out = ProcessDisposePersonValueBean.getDisposePersonInfo(prid,prstatus);
		TagUtils.getInstance().write(pageContext, out);
		return (EVAL_BODY_INCLUDE);
	}

	public String getPrid() {
		return prid;
	}

	public void setPrid(String prid) {
		this.prid = prid;
	}

	public String getPrstatus() {
		return prstatus;
	}

	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}


}