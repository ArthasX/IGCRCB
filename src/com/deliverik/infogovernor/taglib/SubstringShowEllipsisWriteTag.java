/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;

/**
 * ����: ��ȡ�ַ�����ʾʡ�Ժ� ��������������ָ�����Ƚ�ȡ�ַ�������ʾʡ�Ժ� ������¼��
 */
public class SubstringShowEllipsisWriteTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;

	/** ��ȡ���� */
	protected String len;

	/** �Ƿ���ʾʡ�Ժţ���ʾ��true ����ʾ��false�� */
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
	 * �ͷ���Դ
	 */
	public void release() {
		super.release();
		this.len = null;
		this.out = null;
	}

	/**
	 * ��ȡ����ȡ��
	 * 
	 * @return len ��ȡ����
	 */
	public String getLen() {
		return len;
	}

	/**
	 * ��ȡ�����趨
	 * 
	 * @param len
	 *            ��ȡ����
	 */
	public void setLen(String len) {
		this.len = len;
	}

	/**
	 * �Ƿ���ʾʡ�Ժţ���ʾ��true����ʾ��false��ȡ��
	 * 
	 * @return showEllipsis �Ƿ���ʾʡ�Ժţ���ʾ��true����ʾ��false��
	 */
	public boolean isShowEllipsis() {
		return showEllipsis;
	}

	/**
	 * �Ƿ���ʾʡ�Ժţ���ʾ��true����ʾ��false���趨
	 * 
	 * @param showEllipsis
	 *            �Ƿ���ʾʡ�Ժţ���ʾ��true����ʾ��false��
	 */
	public void setShowEllipsis(boolean showEllipsis) {
		this.showEllipsis = showEllipsis;
	}

}