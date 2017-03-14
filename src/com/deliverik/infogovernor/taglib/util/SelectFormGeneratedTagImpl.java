/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib.util;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 下拉列表表单信息生成对应标签实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class SelectFormGeneratedTagImpl extends FormGeneratedTagImpl{

	/**
	 * 公有可写标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicWriteableTag(Map<String, Object> params){
		//取得piid
		String pidid = (String) params.get(PARAMS_PIDID);
		//表单名称取得
		String property = (String) params.get(PARAMS_PROPERTY);
		//表单值取得
		String value = (String) params.get(PARAMS_VALUE);
		//表单单位取得
		String unit = (String) params.get(PARAMS_PIDUNIT);
		//下标值取得
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//是否包含备注取得
		String remarks = params.get(PARAMS_REMARKS)==null?null:params.get(PARAMS_REMARKS).toString();
		//相关联事件
		String jsFunction = (String) params.get(PARAMS_JSFUNCTION);
		//备注取得
		String pidcomment = params.get(PARAMS_PIDCOMMENT) == null ? "" : params.get(PARAMS_PIDCOMMENT).toString();
		//备选值取得
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		//标签的生成信息
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
	 * 表格类表单可写列生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicWriteableTableColumn(Map<String, Object> params){
		//表单定义ID取得
		String pidid = (String) params.get(PARAMS_PIDID);
		//表单值取得
		String value = (String)params.get(PARAMS_VALUE);
		//表单单位取得
		String unit = (String)params.get(PARAMS_PIDUNIT);
		//取得行号
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		//相关联事件
		String jsFunction = (String) params.get(PARAMS_JSFUNCTION);
		//备选值取得
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		//声明标签生成字符串
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
