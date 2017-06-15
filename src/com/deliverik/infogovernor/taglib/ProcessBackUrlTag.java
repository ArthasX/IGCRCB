/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 概述: 流程处理页面返回URL
 * 功能描述: 流程处理页面返回URL
 * 创建记录: 2013/08/29
 * 修改记录:
 */
@SuppressWarnings("serial")
public class ProcessBackUrlTag extends TagSupport {
	
	/** 匹配${...} */
	private static String regex = "\\$\\{.*?\\}"; 
	
	/** URL信息 */
	private static Map<String, String> urlMap = new HashMap<String, String>();

	static {
		IG555BL ig555BL = (IG555BL) WebApplicationSupport.getBean("ig555BL");
		List<IG555Info> lst_IG555Info = ig555BL.searchIG555Info(new IG555SearchCondImpl());
		for (IG555Info bean : lst_IG555Info) {
			urlMap.put(bean.getJump(), bean.getUrl());
		}
	}

	/** 返回标识 */
	protected String jump;
	
	/** 参数 */
	protected String param;

	public int doStartTag() throws JspException {
		String url = urlMap.get(jump);
		if(StringUtils.isEmpty(url)) {
			return (SKIP_BODY);
		} else {
			url = replaceURL(url, parseURL(url));
			TagUtils.getInstance().write(pageContext, "<div class=\"back\"><a href=\"" + url + "\" target=\"_self\">返回</a></div>");
		}
		return (EVAL_BODY_INCLUDE);
	}

	/**
	 * 返回标识取得
	 * 
	 * @return 返回标识
	 */
	public String getJump() {
		return jump;
	}

	/**
	 * 返回标识设定
	 * 
	 * @param jump
	 *            返回标识
	 */
	public void setJump(String jump) {
		this.jump = jump;
	}

	/**
	 * 参数取得
	 * @return 参数
	 */
	public String getParam() {
		return param;
	}

	/**
	 * 参数设定
	 * @param param 参数
	 */
	public void setParam(String param) {
		this.param = param;
	}
	
	/**
	 * @param param
	 * @return
	 */
	/**
	 * 解析URL中的EL表达式
	 * @param url URL
	 * @return EL表达式
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
	 * 转换URL中的EL表达式的值
	 * @param url URL
	 * @param lst_param EL表达式集合
	 * @return 转换后的结果
	 * @throws JspException
	 */
	private String replaceURL(String url, List<String> lst_param) throws JspException {
		for(String param : lst_param) {
			url = url.replaceAll("\\$\\{" + param.substring(2, param.length()-1) + "\\}", getELValue(param));
		}
		return url;
	}
	
	/**
	 * 获取EL表达式的值
	 * @param param EL表达式
	 * @return EL表达式的值
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