/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.taglib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;
import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prr.bl.task.IG555BL;
import com.deliverik.framework.workflow.prr.model.IG555Info;
import com.deliverik.framework.workflow.prr.model.condition.IG555SearchCondImpl;

/**
 * ����: ���̴���ҳ�淵��URL
 * ��������: ���̴���ҳ�淵��URL
 * ������¼: 2013/08/29
 * �޸ļ�¼:
 */
@SuppressWarnings("serial")
public class ProcessBackUrlTag extends TagSupport {
	
	/** ƥ��${...} */
	private static String regex = "\\$\\{.*?\\}"; 
	
	/** URL��Ϣ */
	private static Map<String, String> urlMap = new HashMap<String, String>();

	static {
		IG555BL ig555BL = (IG555BL) WebApplicationSupport.getBean("ig555BL");
		List<IG555Info> lst_IG555Info = ig555BL.searchIG555Info(new IG555SearchCondImpl());
		for (IG555Info bean : lst_IG555Info) {
			urlMap.put(bean.getJump(), bean.getUrl());
		}
	}

	/** ���ر�ʶ */
	protected String jump;
	
	/** ���� */
	protected String param;

	public int doStartTag() throws JspException {
		String url = urlMap.get(jump);
		if(StringUtils.isEmpty(url)) {
			return (SKIP_BODY);
		} else {
			url = replaceURL(url, parseURL(url));
			TagUtils.getInstance().write(pageContext, "<div class=\"back\"><a href=\"" + url + "\" target=\"_self\">����</a></div>");
		}
		return (EVAL_BODY_INCLUDE);
	}

	/**
	 * ���ر�ʶȡ��
	 * 
	 * @return ���ر�ʶ
	 */
	public String getJump() {
		return jump;
	}

	/**
	 * ���ر�ʶ�趨
	 * 
	 * @param jump
	 *            ���ر�ʶ
	 */
	public void setJump(String jump) {
		this.jump = jump;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getParam() {
		return param;
	}

	/**
	 * �����趨
	 * @param param ����
	 */
	public void setParam(String param) {
		this.param = param;
	}
	
	/**
	 * @param param
	 * @return
	 */
	/**
	 * ����URL�е�EL���ʽ
	 * @param url URL
	 * @return EL���ʽ
	 */
	private static List<String> parseURL(String url) {
		List<String> lst_param = new ArrayList<String>();
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher(url); 
        while (matcher.find()) {  
            lst_param.add(matcher.group());  
        }
        return lst_param;
	}
	
	/**
	 * ת��URL�е�EL���ʽ��ֵ
	 * @param url URL
	 * @param lst_param EL���ʽ����
	 * @return ת����Ľ��
	 * @throws JspException
	 */
	private String replaceURL(String url, List<String> lst_param) throws JspException {
		for(String param : lst_param) {
			url = url.replaceAll("\\$\\{" + param.substring(2, param.length()-1) + "\\}", getELValue(param));
		}
		return url;
	}
	
	/**
	 * ��ȡEL���ʽ��ֵ
	 * @param param EL���ʽ
	 * @return EL���ʽ��ֵ
	 * @throws JspException
	 */
	private String getELValue(String param) throws JspException {
		Object obj = ExpressionEvaluatorManager.evaluate(param, param,  Object.class, this, pageContext);
		if(obj == null) {
			obj = pageContext.getRequest().getParameter(param.substring(2, param.length()-1));
		}
		return obj.toString();
	}

}