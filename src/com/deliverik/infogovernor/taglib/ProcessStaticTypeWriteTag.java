package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.infogovernor.common.ProcessStaticTypeValueBean;

public class ProcessStaticTypeWriteTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	/** ���̰汾  */	
	protected String pdid;
	
	/** ״̬��ʶ  */	
	protected String psdcode;
	
	public int doStartTag() throws JspException {
		String out = ProcessStaticTypeValueBean.getConfigInfo(pdid, psdcode);
		TagUtils.getInstance().write(pageContext, out);
		return (EVAL_BODY_INCLUDE);
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String getPsdcode() {
		return psdcode;
	}

	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

}