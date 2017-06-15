/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 项目用时显示标签
 * </p>
 * 
 * @author zhangqiang@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ProjectWorkHoursRatioByBetweenTag extends TagSupport{
	
	protected String param1;
	
	protected String param2;


	


	public int doStartTag() throws JspException {
		Double plannedwork = StringUtils.isNotEmpty(param1) ? Double.valueOf(param1) : 0.0;
		Double workhours = StringUtils.isNotEmpty(param2) ? Double.valueOf(param2) : 0.0;
		int val = 0;
		if(plannedwork > 0){
			val = (int) ((workhours - plannedwork) / plannedwork * 10000);
			val = val / 100;
			if(val < 0){
				val = val * -1;
			}
		}
		TagUtils.getInstance().write(pageContext, val + "");
		return EVAL_BODY_INCLUDE;
	}
	/**
	 * param1取得
	 * @return param1 param1
	 */
	
	public String getParam1() {
		return param1;
	}


	/**
	 * param1设定
	 * @param param1 param1
	 */
	public void setParam1(String param1) {
		this.param1 = param1;
	}


	/**
	 * param2取得
	 * @return param2 param2
	 */
	
	public String getParam2() {
		return param2;
	}


	/**
	 * param2设定
	 * @param param2 param2
	 */
	public void setParam2(String param2) {
		this.param2 = param2;
	}
}
