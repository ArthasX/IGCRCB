/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;

/**
 * 概述: 截取字符串显示省略号 功能描述：根据指定长度截取字符串并显示省略号 创建记录：
 */
public class SubstringShowEllipsisWriteTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;

	/** 截取长度 */
	protected String len;

	/** 是否显示省略号（显示：true 不显示：false） */
	protected boolean showEllipsis;

	protected String out = "";

	@SuppressWarnings("deprecation")
	public int doStartTag() throws JspException {

		

//		TagUtils.getInstance().write(pageContext, out);
		return EVAL_BODY_TAG;
	}

	public int doAfterBody() throws JspException {
		BodyContent body = getBodyContent();
		
		JspWriter jw = body.getEnclosingWriter();
		
		String str = body.getString().trim();
		int len_int = Integer.parseInt(len);
		if (str.length() > len_int) {
			out = str.substring(0, len_int);
			if (StringUtils.isNotEmpty(str) && this.showEllipsis) {
				out += "...";
			}
		} else {
			out = str;
		}
		
//		TagUtils.getInstance().write(pageContext, out);
		try {
			body.clear();
			jw.write(out);
			body.writeOut(jw);
		} catch (IOException exc) {
			throw new JspException(exc.toString());
		}
		return SKIP_BODY;

	}

	/**
	 * 释放资源
	 */
	public void release() {
		super.release();
		this.len = null;
		this.out = null;
	}

	/**
	 * 截取长度取得
	 * 
	 * @return len 截取长度
	 */
	public String getLen() {
		return len;
	}

	/**
	 * 截取长度设定
	 * 
	 * @param len
	 *            截取长度
	 */
	public void setLen(String len) {
		this.len = len;
	}

	/**
	 * 是否显示省略号（显示：true不显示：false）取得
	 * 
	 * @return showEllipsis 是否显示省略号（显示：true不显示：false）
	 */
	public boolean isShowEllipsis() {
		return showEllipsis;
	}

	/**
	 * 是否显示省略号（显示：true不显示：false）设定
	 * 
	 * @param showEllipsis
	 *            是否显示省略号（显示：true不显示：false）
	 */
	public void setShowEllipsis(boolean showEllipsis) {
		this.showEllipsis = showEllipsis;
	}

}