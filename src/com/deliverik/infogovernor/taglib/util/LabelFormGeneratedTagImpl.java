/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib.util;

import java.util.Map;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 固定文本表单标签生成类
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class LabelFormGeneratedTagImpl extends FormGeneratedTagImpl{
	
	/**
	 * 表格类表单列生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicWriteableTableColumn(Map<String, Object> params){
		return generatedPublicTableColumn(params);
	}
	
	/**
	 * 表格类表单只读列生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicReadableTableColumn(Map<String, Object> params){
		return generatedPublicTableColumn(params);
	}

	/**
	 * 表格类表单列生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicTableColumn(Map<String, Object> params){
		//表单定义主键取得
		String pidid = (String) params.get(PARAMS_PIDID);
		//行号取得
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		//备选值取得
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		//值取得
		String value = "";
		if(rownum != null){
			if(!"_#_".equals(rownum)){
				
				int index =0;
				if(rownum.indexOf("_")> -1){
					index = Integer.parseInt(rownum.substring(rownum.lastIndexOf("_") + 1));
				}else{
					index = Integer.parseInt(rownum);
				}
				if(options != null){
					if(options.length >= index){
						value = options[index-1];
					}
				}
			}
		}
		//表单生成标签字符串
		StringBuffer tagString = new StringBuffer(value);
		tagString.append("<input type=\"hidden\" id=\"").append(pidid).append("_").append(rownum).append("\" rownumber=\"").append(rownum).append("\" name=\"column_value\" value='").append(value).append("'/>");
		tagString.append("<input type=\"hidden\" name=\"column_pidid\" value=\"").append(pidid).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_rownumber\" value=\"").append(rownum).append("\" />");
		return tagString.toString();
	}
}
