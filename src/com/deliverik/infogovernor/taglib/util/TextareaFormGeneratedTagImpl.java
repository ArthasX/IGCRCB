/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib.util;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.utility.IGStringUtils;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 文本域表单信息生成对应标签实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class TextareaFormGeneratedTagImpl extends FormGeneratedTagImpl{

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
		//文本域长度取得
		String textAreaSize = (String) params.get(PARAMS_TEXTAREA_SIZE);
		String width = "60".equals(textAreaSize) ? "440px" : "200px";
		//相关联事件
		String jsFunction = (String) params.get(PARAMS_JSFUNCTION);
		if(StringUtils.isNotEmpty(value)){
			value = value.replaceAll("<br>", "_#br#_");
			value = IGStringUtils.filterXMLStr(value);
			value = value.replaceAll("_#br#_", "<br>");
			value = value.replaceAll("&apos;", "'");
			//----史凯龙
		}
		//标签的生成信息
		StringBuffer tagString = new StringBuffer();
		tagString.append("<div class=\"editDiv\" contenteditable=\"true\" onkeydown=\"editDivContent(this);\" ")
				 .append("style=\"width:").append(width).append(";height:85px;\" ")
				 .append(" onblur=\"getEditDivValue(this,")
				 .append(index)
				 .append(");");
		if(StringUtils.isNotEmpty(jsFunction)){
			tagString.append(jsFunction).append("(this);");	 
		}
		tagString.append("\" id=\"pidid")
				 .append(pidid)
				 .append("\" >")
				 .append(value)
				 .append("</div><input type=\"hidden\" name=\"")
				 .append(property)
				 .append("\" value=\"")
				 .append(value)
				 .append("\" />");
		
		if(StringUtils.isNotEmpty(unit)){
			tagString.append("<span>"+unit+"</span>");
		}		
		return tagString.toString();
	}
	
	/**
	 * 公有只读标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicReadableTag(Map<String, Object> params){
		//表单名称取得
		String property = (String) params.get(PARAMS_PROPERTY);
		//表单值取得
		String value = params.get(PARAMS_VALUE)==null?null:params.get(PARAMS_VALUE).toString();
		//表单单位取得
		String unit = params.get(PARAMS_PIDUNIT)==null?null:params.get(PARAMS_PIDUNIT).toString();
		if(StringUtils.isNotEmpty(value)){
			value = value.replaceAll("<br>", "_#br#_");
			value = value.replaceAll("&nbsp;", "_kg_");
			value = value.replaceAll("&quot;", "_yh_");
			value = value.replaceAll("&amp;", "_s7_");
			value = value.replaceAll("&lt;", "_xy_");
			value = value.replaceAll("&gt;", "_dy_");
			value = IGStringUtils.filterXMLStr(value);
			value = value.replaceAll("_#br#_", "<br>");
			value = value.replaceAll("_kg_", "&nbsp;");
			value = value.replaceAll("_yh_", "&quot;");
			value = value.replaceAll("_s7_", "&amp;");
			value = value.replaceAll("_xy_", "&lt;");
			value = value.replaceAll("_dy_", "&gt;");
			value = value.replaceAll("&apos;", "'");
			//----史凯龙
		}
		//标签的生成信息
		StringBuffer tagString = new StringBuffer();
		tagString.append("<div style=\"border:none;\" class=\"editDiv\">")
				 .append(value)
				 .append("</div>")
				 .append("<input type=\"hidden\" name=\"")
				 .append(property)
				 .append("\" value=\"")
				 .append(value)
				 .append("\" />")
				 ;
		if(StringUtils.isNotEmpty(unit) && StringUtils.isNotEmpty(value)){
			tagString.append("<span>"+unit+"</span>");
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
		String value = (String) params.get(PARAMS_VALUE);
		//表单单位取得
		String unit = (String) params.get(PARAMS_PIDUNIT);
		//取得行号
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		//相关联事件
		String jsFunction = (String) params.get(PARAMS_JSFUNCTION);
		//限制长度取得
		Integer pidsize = (Integer) params.get(PARAMS_PIDSIZE);
		if(value == null || "null".equals(value)){
			value = "";
		}else{
			value = value.trim();
		}
		String width = "150px;";
		if(pidsize != null && pidsize > 0){
			width = (8 * pidsize) + "px";
		}
		//声明标签生成字符串
		StringBuffer tagString = new StringBuffer();
		tagString.append("<div class=\"editDiv\" name=\"textarea_show_value\" contenteditable=\"true\" onkeydown=\"editDivContent(this);\" ")
				 .append("style=\"width:").append(width).append(";\" ")
				 .append(" onblur=\"getTableColumnEditDivValue(this);");
		if(StringUtils.isNotEmpty(jsFunction)){
			tagString.append(jsFunction).append("(this);");
		}
		tagString.append("\">")
				 .append(value)
				 .append("</div><input type=\"hidden\" name=\"column_value\" id=\"")
				 .append(pidid)
				 .append("_")
				 .append(rownum)
				 .append("\" rownumber=\"")
				 .append(rownum)
				 .append("\"  value=\"")
				 .append(value)
				 .append("\" />");
		
		if(StringUtils.isNotEmpty(unit)){
			tagString.append("<span>"+unit+"</span>");
		}
		tagString.append("<input type=\"hidden\" name=\"column_pidid\" value=\"").append(pidid).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_rownumber\" value=\"").append(rownum).append("\" />");
		return tagString.toString();
	}
}
