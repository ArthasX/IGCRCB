package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.infogovernor.common.ProcessDisposePersonValueBean;
import com.deliverik.infogovernor.common.ProcessUrgencyValueBean;

public class ProcessUrgencyWriteTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	protected String prid;
	
	protected String pdid;
	
	public int doStartTag() throws JspException {
		String out = ProcessUrgencyValueBean.getProcessUrgencyImg(prid,pdid);
		TagUtils.getInstance().write(pageContext, out);
		return (EVAL_BODY_INCLUDE);
	}

	public String getPrid() {
		return prid;
	}

	public void setPrid(String prid) {
		this.prid = prid;
	}
	
	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

}