package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.infogovernor.common.ProcessFormValueBean;

public class ProcessFormValueWriteTag extends TagSupport{

    static Log log = LogFactory.getLog(ProcessFormValueWriteTag.class);	

	private static final long serialVersionUID = 1L;

	protected Integer prid;
	protected String pidname;
	
	public int doStartTag() throws JspException {
		String out = ProcessFormValueBean.getFormValue(prid, pidname);
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

	public String getPidname() {
		return pidname;
	}

	public void setPidname(String pidname) {
		this.pidname = pidname;
	}



	
}