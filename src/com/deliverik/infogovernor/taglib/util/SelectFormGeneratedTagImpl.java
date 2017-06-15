/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.taglib.util;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����б����Ϣ���ɶ�Ӧ��ǩʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class SelectFormGeneratedTagImpl extends FormGeneratedTagImpl{

	/**
	 * ���п�д��ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicWriteableTag(Map<String, Object> params){
		//ȡ��piid
		String pidid = (String) params.get(PARAMS_PIDID);
		//������ȡ��
		String property = (String) params.get(PARAMS_PROPERTY);
		//��ֵȡ��
		String value = (String) params.get(PARAMS_VALUE);
		//����λȡ��
		String unit = (String) params.get(PARAMS_PIDUNIT);
		//�±�ֵȡ��
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//�Ƿ������עȡ��
		String remarks = params.get(PARAMS_REMARKS)==null?null:params.get(PARAMS_REMARKS).toString();
		//������¼�
		String jsFunction = (String) params.get(PARAMS_JSFUNCTION);
		//��עȡ��
		String pidcomment = params.get(PARAMS_PIDCOMMENT) == null ? "" : params.get(PARAMS_PIDCOMMENT).toString();
		//��ѡֵȡ��
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		//��ǩ��������Ϣ
		StringBuffer tagString = new StringBuffer();
		tagString.append("<select id=\"pidid").append(pidid).append("\" name=\"").append(property).append("\" value=\"").append(value).append("\" ");
		if(StringUtils.isNotEmpty(jsFunction)){
			tagString.append(" onchange=\"").append(jsFunction).append("(this);\"");
		}
		tagString.append(">");
		if(options!=null){
			for(String option:options){
				tagString.append("<option value=\"").append(option).append("\"");
				if(StringUtils.isNotEmpty(option)&&option.equals(value)){
					tagString.append(" selected=\"true\"");
				}
				tagString.append(">").append(option).append("</option>");
			}
		}
		tagString.append("</select>");
		if(StringUtils.isNotEmpty(unit)){
			tagString.append("<span>"+unit+"</span>");
		}
		if(StringUtils.isNotEmpty(remarks) && REMARK_TAG.equals(remarks)){
			tagString.append("<div class=\"editDiv\" contenteditable=\"true\" onkeydown=\"editDivContent(this);\" style=\"display:inline;width:150px;height:18px;\" id=\"comment_")
					 .append(pidid)
					 .append("\" onblur=\"getPidcommentValue(this,")
					 .append(index)
					 .append(")\">")
					 .append(pidcomment)
					 .append("</div>");
			tagString.append("<input type=\"hidden\" id=\"pidcomment[")
					 .append(index)
					 .append("]\" ")
					 .append(" name=\"pidcomment[")
					 .append(index)
					 .append("]\" value=\"")
					 .append(pidcomment)
					 .append("\"/>");
		}
		return tagString.toString();
	}
	
	/**
	 * ��������д������
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicWriteableTableColumn(Map<String, Object> params){
		//������IDȡ��
		String pidid = (String) params.get(PARAMS_PIDID);
		//��ֵȡ��
		String value = (String)params.get(PARAMS_VALUE);
		//����λȡ��
		String unit = (String)params.get(PARAMS_PIDUNIT);
		//ȡ���к�
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		//������¼�
		String jsFunction = (String) params.get(PARAMS_JSFUNCTION);
		//��ѡֵȡ��
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		//������ǩ�����ַ���
		StringBuffer tagString = new StringBuffer();
		tagString.append("<input type=\"hidden\" name=\"column_pidid\" value=\"").append(pidid).append("\" />");
		tagString.append("<select name=\"column_value\" id=\"").append(pidid).append("_").append(rownum).append("\" rownumber=\"").append(rownum).append("\"  ");
		if(StringUtils.isNotEmpty(jsFunction)){
			tagString.append(" onchange=\"").append(jsFunction).append("(this);\" ");
		}
		tagString.append(">");
		if(options != null){
			for(String option:options){
				tagString.append("<option value=\"").append(option).append("\"");
				if(StringUtils.isNotEmpty(option)&&option.equals(value)){
					tagString.append(" selected=\"true\"");
				}
				tagString.append(">").append(option).append("</option>");
			}
		}
		tagString.append("</select>");
		if(StringUtils.isNotEmpty(unit)){
			tagString.append("<span>"+unit+"</span>");
		}
		tagString.append("<input type=\"hidden\" name=\"column_rownumber\" value=\"").append(rownum).append("\" />");
		return tagString.toString();
	}
}
