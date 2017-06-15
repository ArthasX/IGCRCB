/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̶����ѯ�������ɱ�ǩ
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ProcessQueryTag extends TagSupport{

	/** ��ѯ������������ */
	protected String name;
	
	/** ��ѯ������������ */
	protected String property;
	
	/** ����洢λ�� */
	protected String scope;
	
	/** ֵ */
	protected String value;
	
	/** ���� */
	protected int index;
	
	/**
	 * ��ѯ�������������趨
	 * @param name ��ѯ������������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ѯ�������������趨
	 * @param property ��ѯ������������
	 */
	public void setProperty(String property) {
		this.property = property;
	}
	
	/**
	 * ����洢λ���趨
	 * @param scope ����洢λ��
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}

	/**
	 * ֵȡ��
	 * @return value ֵ
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
	 * ֵ�趨
	 * @param value ֵ
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * �����趨
	 * @param index ����
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * ��дdoStartTag��ʽ���ɲ�ѯ��������
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
