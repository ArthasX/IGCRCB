package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.csebank.common.SysConfigManager;

public class CSECodeValueWriteTag extends TagSupport{
	private static final long serialVersionUID = 1L;
	protected String codeIndex;
	protected String codeValue;
	public int doStartTag() throws JspException {
		String out = SysConfigManager.getConfigInfo(codeIndex + "_" + codeValue);
		TagUtils.getInstance().write(pageContext, out);
		return (EVAL_BODY_INCLUDE);
	}

	public String getCodeIndex() {
		return codeIndex;
	}

	public void setCodeIndex(String codeIndex) {
		this.codeIndex = codeIndex;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	
}