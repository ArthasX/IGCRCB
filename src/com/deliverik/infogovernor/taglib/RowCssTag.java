package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

/**
 * 
 */

@SuppressWarnings("serial")
public class RowCssTag extends TagSupport{

	private int index = 0;

	public int doStartTag() throws JspException {

		String css = "bgRow0";

		if (index % 2 == 1)
			css = "bgRow1";

		TagUtils.getInstance().write(pageContext, css);

		return (EVAL_BODY_INCLUDE);
	}


	public void setIndex(int index) {
	 this.index = index;
	}


}