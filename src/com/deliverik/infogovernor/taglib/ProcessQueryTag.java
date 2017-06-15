/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.prr.form.IGPRR0601Form;
import com.deliverik.infogovernor.taglib.processquery.ProcessQuery;
import com.deliverik.infogovernor.taglib.processquery.ProcessQueryFactory;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程定义查询条件生成标签
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ProcessQueryTag extends TagSupport{

	/** 查询条件对象名称 */
	protected String name;
	
	/** 查询对象属性名称 */
	protected String property;
	
	/** 对象存储位置 */
	protected String scope;
	
	/** 值 */
	protected String value;
	
	/** 索引 */
	protected int index;
	
	/**
	 * 查询条件对象名称设定
	 * @param name 查询条件对象名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 查询对象属性名称设定
	 * @param property 查询对象属性名称
	 */
	public void setProperty(String property) {
		this.property = property;
	}
	
	/**
	 * 对象存储位置设定
	 * @param scope 对象存储位置
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}

	/**
	 * 值取得
	 * @return value 值
	 */
	public String getValue() {
		if(StringUtils.isNotEmpty(this.value)){
			return value;
		}else{
			IGPRR0601Form form = (IGPRR0601Form) pageContext.getSession().getAttribute("IGPRR0601Form");
			String[] queryValue = form.getQueryValue();
			if(queryValue != null && queryValue.length > index && StringUtils.isNotEmpty(queryValue[index])){
				return queryValue[index];
			}
			return "";
		}
	}

	/**
	 * 值设定
	 * @param value 值
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 索引设定
	 * @param index 索引
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * 重写doStartTag方式生成查询条件内容
	 */
	public int doStartTag() throws JspException{
		try{
			Map<String, Object> map = packParam();
			ProcessQueryFactory factory = (ProcessQueryFactory) WebApplicationSupport.getBean("processQueryFactory");
			TagUtils.getInstance().write(pageContext, factory.generatedTag(map));
		}catch (Exception e) {
			throw new JspException(e);
		}
		return SKIP_BODY;
	}
	
	private Map<String, Object> packParam() throws JspException{
		Map<String, Object> map = new HashMap<String, Object>();
		Object queryObj = TagUtils.getInstance().lookup(pageContext, name, property,scope);
		map.put(ProcessQuery.PARAM_DEFINITION_OBJECT, queryObj);
		map.put(ProcessQuery.PARAM_VALUE, getValue());
		map.put(ProcessQuery.PARAM_STATUS_DEFINITION, pageContext.getSession().getAttribute("AD_STATUS_DEFINITION"));
		return map;
	}
}
