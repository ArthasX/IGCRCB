package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.infogovernor.common.ProcessDefineTypeValueBean;

public class ProcessDefineTypeWriteTag extends TagSupport{

    static Log log = LogFactory.getLog(ProcessDefineTypeWriteTag.class);	

	private static final long serialVersionUID = 1L;

	protected Integer prid;

	public int doStartTag() throws JspException {
		String out = ProcessDefineTypeValueBean.getConfigInfo(prid);
		TagUtils.getInstance().write(pageContext, out);
		return (EVAL_BODY_INCLUDE);
	}

	@Override
	public void release() {
		super.release();
		prid = null;
	}

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
}