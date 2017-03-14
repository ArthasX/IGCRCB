/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.IG622BL;
import com.deliverik.framework.user.model.User;

/**
 * ����: ��ҳ������ʾ��ǩ
 * ������������ҳ������ʾ��ǩ
 * ������¼��2012/07/18
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class HomePageTitleTag extends TagSupport {
	
	/** ��ҳ��תURL����BL */
	private static IG622BL ig622BL = (IG622BL) WebApplicationSupport.getBean("ig622BL");
	
	public int doStartTag() throws JspException {
		User user = (User)pageContext.getSession().getAttribute(BaseAction.SESSION_KEY_LOGIN_USER);
		String usertype = user.getUsertype();
		StringBuffer retHtml = new StringBuffer("");
		try {
			retHtml.append("<li><a href=\"IGCOM0105.do?index=").append(usertype)
			.append("\" class=\"subscribe\" id=\"00\">&nbsp;&nbsp;")
			.append(ig622BL.getTitle(usertype)).append("</a></li>");
			//�쵼��ҵ����Ա�����Կ�����ά��ҳ
			if("2".equals(usertype) || "3".equals(usertype)) {
				retHtml.append("<li><a href=\"IGCOM0105.do?index=1\" class=\"subscribe\" id=\"001\">&nbsp;&nbsp;")
				.append(ig622BL.getTitle("1")).append("</a></li>");
			}
		} catch (BLException e) {
			return (SKIP_BODY);
		}
		TagUtils.getInstance().write(pageContext, retHtml.toString());
		return (EVAL_BODY_INCLUDE);
	}


	/**
	 * �ͷ���Դ
	 */
	public void release() {
        super.release();
    }
	
}