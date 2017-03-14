/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib.util;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCondImpl;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CheckBoxElseFormGeneratedTagImpl extends FormGeneratedTagImpl{
	/**
	 * 公有可写标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicWriteableTag(Map<String, Object> params){
		//表单名称取得
		String property = params.get(PARAMS_PROPERTY)==null?null:params.get(PARAMS_PROPERTY).toString();
		//表单值取得
		String value = params.get(PARAMS_VALUE)==null?null:params.get(PARAMS_VALUE).toString();
		//下标值取得
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//表单单位取得
		String unit = (String)params.get(PARAMS_PIDUNIT);
		//是否包含备注取得
		String remarks = params.get(PARAMS_REMARKS)==null?null:params.get(PARAMS_REMARKS).toString();
		//文本域长度取得
		String textAreaSize = (String) params.get(PARAMS_TEXTAREA_SIZE);
		//复选表单显示方式
		String showstyles =  (String) params.get(PARAMS_SHOWSTYLES);
		//相关联事件
		String jsFunction = (String) params.get(PARAMS_JSFUNCTION);
		//表单定义主键取得
	    String pidid = (String) params.get(PARAMS_PIDID);
		//备选值取得
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		//多选值取得
		String[] checkValues = null;
		if(StringUtils.isNotEmpty(value)){
			checkValues = value.split("#");
		}
		//判断其他选项是否被选中
		boolean checkElse = false;
		String elseStr = "";
		if(checkValues != null && checkValues.length > 0 ){
			for(String s:checkValues){
				if(s.indexOf("_cev_") > -1){
					checkElse = true;
					elseStr = s;
				}
			}
		}
		if(StringUtils.isNotEmpty(elseStr)){
			elseStr = elseStr.split("_cev_")[1];
		}
		//标签的生成信息
		StringBuffer tagString = new StringBuffer();
		if(options!=null){
			for(String option:options){
				boolean checked = false;
				if(StringUtils.isNotEmpty(option)){
					if(checkValues!=null&&checkValues.length>0){
						for(String s:checkValues){
							if(option.equals(s)){
								checked = true;
							}
						}
					}
				}
				tagString.append("<span style=\"display:block;float:left;height:24px;width:200px;");
				if(checked){
					tagString.append("color:red;");
				}
				tagString.append("\">");
				tagString.append("<input type=\"checkbox\" class=\"middleAlign\" name=\"pivarcheckbox[")
						 .append(index)
						 .append("]\" value=\"")
						 .append(option)
						 .append("\" onclick=\"setCheckbox(")
						 .append(index)
						 .append(",this);");
				if(StringUtils.isNotEmpty(jsFunction)){
					tagString.append(jsFunction).append("(this);");
				}
				tagString.append("\"");
				if(checked){
					tagString.append(" checked=\"true\"");
				}
				tagString.append("/>");
				tagString.append(option);
				tagString.append("</span>");
				if(StringUtils.isNotEmpty(showstyles) && SHOWSTYLES_TAG.equals(showstyles)){
					tagString.append("<br/>");
				}
			}
			
			tagString.append("<span style=\"display:block;float:left;height:24px;width:200px;");
			if(checkElse){
				tagString.append("color:red;");
			}
			tagString.append("\">");
			tagString.append("<input type=\"checkbox\" class=\"middleAlign\" name=\"pivarcheckbox[")
			 		 .append(index)
			 		 .append("]\" value=\"\" onclick=\"showOrHiddenCheckBoxElse(this,")
			 		 .append(index)
			 		 .append(");");
			if(StringUtils.isNotEmpty(jsFunction)){
				tagString.append(jsFunction).append("(this);");
			}
			tagString.append("\"");
			if(checkElse){
				tagString.append(" checked=\"true\"");
			}
			tagString.append("/>其他");
			tagString.append("<input type=\"text\" onchange=\"setCheckBoxElseValue(this,").append(index).append(");\"");
			if(!checkElse){
				tagString.append("style=\"display:none;\" ");
			}
			tagString.append(" name=\"pivarcheckboxElseText[").append(index).append("]\" value=\"").append(elseStr).append("\" />");
			tagString.append("</span>");
		}
		tagString.append("<input type=\"hidden\" id=\"pidid").append(pidid).append("\" name=\"").append(property).append("\" value=\"").append(value).append("\" />");
		if(StringUtils.isNotEmpty(unit)){
			tagString.append("<span>"+unit+"</span>");
		}
		if(StringUtils.isNotEmpty(remarks) && REMARK_TAG.equals(remarks)){
			tagString.append("<textarea id=\"pidcomment[")
			 .append(index)
			 .append("]\"")
			 .append(" cols=\"")
			 .append(textAreaSize)
			 .append("\" rows=\"5\" name=\"pidcomment[")
			 .append(index)
			 .append("]\" >")
			 .append(value)
			 .append("</textarea>")
			 ;
		}
		return tagString.toString();
	}
	
	/**
	 * 公有只读标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicReadableTag(Map<String, Object> params){
		//取得piid
		String piid = params.get(PARAMS_PIDID)==null?null:params.get(PARAMS_PIDID).toString();
		//表单名称取得
		String property = params.get(PARAMS_PROPERTY)==null?null:params.get(PARAMS_PROPERTY).toString();
		//表单值取得
		String value = params.get(PARAMS_VALUE)==null?null:params.get(PARAMS_VALUE).toString();
		//下标值取得
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//表单单位取得
		String unit = (String)params.get(PARAMS_PIDUNIT);
		//是否加备注取得
		String remarks = (String)params.get(PARAMS_REMARKS);
		//备注
		String pidcomment = (String)params.get(PARAMS_PIDCOMMENT);
		//复选表单显示方式
		String showstyles =  (String) params.get(PARAMS_SHOWSTYLES);
		//备选值取得
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		//多选值取得
		String[] checkValues = null;
		if(StringUtils.isNotEmpty(value)){
			checkValues = value.split("#");
		}
		//判断其他选项是否被选中
		boolean checkElse = false;
		String elseStr = "";
		if(checkValues != null && checkValues.length > 0 ){
			for(String s:checkValues){
				if(s.indexOf("_cev_") > -1){
					checkElse = true;
					elseStr = s;
				}
			}
		}
		if(StringUtils.isNotEmpty(elseStr)){
			elseStr = elseStr.split("_cev_")[1];
		}
		//标签的生成信息
		StringBuffer tagString = new StringBuffer();
		tagString.append("<input type=\"hidden\" id=\"pidid")
				 .append(piid)
				 .append("\" name=\"")
				 .append(property)
				 .append("\" value=\"")
				 .append(value)
				 .append("\" />")
				 ;
		if(options!=null){
			for(String option:options){
				boolean checked = false;
				if(StringUtils.isNotEmpty(option)){
					if(checkValues!=null&&checkValues.length>0){
						for(String s:checkValues){
							if(option.equals(s)){
								checked = true;
							}
						}
					}
				}
				tagString.append("<span style=\"display:block;float:left;height:24px;width:200px;");
				if(checked){
					tagString.append("color:red;");
				}
				tagString.append("\">");
				tagString.append("<input type=\"checkbox\" class=\"middleAlign\" name=\"pivarcheckbox[")
						 .append(index)
						 .append("]\" value=\"")
						 .append(option)
						 .append("\" onclick=\"setCheckbox(")
						 .append(index)
						 .append(",this);\" disabled=\"true\"");
				if(checked){
					tagString.append(" checked=\"true\"");
				}
				tagString.append("/>");
				tagString.append(option);
				tagString.append("</span>");
				if(StringUtils.isNotEmpty(showstyles) && SHOWSTYLES_TAG.equals(showstyles)){
					tagString.append("<br/>");
				}
			}
		}
		tagString.append("<span style=\"display:block;float:left;height:24px;width:200px;");
		if(checkElse){
			tagString.append("color:red;");
		}
		tagString.append("\">");
		tagString.append("<input type=\"checkbox\" class=\"middleAlign\" name=\"pivarcheckbox[")
		 		 .append(index)
		 		 .append("]\" value=\"\"  disabled=\"true\" onclick=\"showOrHiddenCheckBoxElse(this,")
		 		 .append(index)
		 		 .append(",this);\"");
		if(checkElse){
			tagString.append(" checked=\"true\"");
		}
		tagString.append("/>其他");
		if(checkElse){
			tagString.append("<input type=\"text\" onchange=\"setCheckBoxElseValue(this,").append(index).append(");\"");
			tagString.append("  disabled=\"true\" name=\"pivarcheckboxElseText[").append(index).append("]\" value=\"").append(elseStr).append("\" />");
		}
		tagString.append("</span>");
		if(StringUtils.isNotEmpty(unit) && StringUtils.isNotEmpty(value)){
			tagString.append("<span>"+unit+"</span>");
		}
		if(StringUtils.isNotEmpty(remarks) && REMARK_TAG.equals(remarks)){
			tagString.append("<pre>")
			 .append(pidcomment)
			 .append("</pre>")
			 .append("<input type=\"hidden\" name=\"")
			 .append("pidcomment[")
			 .append(index)
			 .append("]\" value=\"")
			 .append(value)
			 .append("\" />")
			 ;
		}
		return tagString.toString();
	}
	
	/**
	 * 私有全部可见标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPrivateReadableAllTag(Map<String, Object> params){
		//表单值取得
		String value = params.get(PARAMS_VALUE)==null?null:params.get(PARAMS_VALUE).toString();
		//取得私有表单权限范围
		String privatescope =  params.get(PARAMS_PRIVATESCOPE)==null?null:params.get(PARAMS_PRIVATESCOPE).toString();
		//表单名称取得
		String property = params.get(PARAMS_PROPERTY)==null?null:params.get(PARAMS_PROPERTY).toString();
		//PIID 取得
		String piid = params.get(PARAMS_PIID) == null || "".equals(params.get(PARAMS_PIID)) ? "0" : params.get(PARAMS_PIID).toString();
		//表单单位取得
		String unit = params.get(PARAMS_PIDUNIT)==null?null:params.get(PARAMS_PIDUNIT).toString();
		//下标值取得
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//是否加备注取得
		String remarks = (String)params.get(PARAMS_REMARKS);
		//备注
		String pidcomment = (String)params.get(PARAMS_PIDCOMMENT);
		//复选表单显示方式
		String showstyles =  (String) params.get(PARAMS_SHOWSTYLES);
		//备选值取得
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		//多选值取得
		String[] checkValues = null;
		int iRadioNum = 0;
		//标签的生成信息
		StringBuffer tagString = new StringBuffer(value);
		tagString.append("<table width=\"100%\" >");
		//判断私有表单的权限范围
		if(StringUtils.isNotEmpty(privatescope)){
			IG899SearchCondImpl cond = new IG899SearchCondImpl();
			cond.setPidid(params.get(PARAMS_PIDID)==null?null:params.get(PARAMS_PIDID).toString());
			cond.setPiid(Integer.valueOf(piid));
			List<IG899Info> list = ig899BL.searchIG899Info(cond);
			if(list!=null&&!list.isEmpty()){
				for(IG899Info ppi:list){
					iRadioNum++;
					if(StringUtils.isNotEmpty(value)){
						checkValues = StringUtils.isNotEmpty(ppi.getPpivalue())?ppi.getPpivalue().split("#"):new String[0];
					}
					//当前私有表单值
					boolean flag = false;
					tagString.append("<tr><td style=\"border-bottom:none;\" width=\"30%\">");
					//用户
					if(IGPRDCONSTANTS.PRIVATESCOPE_USER.equals(privatescope)){
						tagString.append(ppi.getUserTB().getUsername());
						if(ppi.getUserid().equals(params.get(PARAMS_USERID)==null?null:params.get(PARAMS_USERID).toString())){
							flag = true;
						}
					//角色
					}else if(IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equals(privatescope)){
						tagString.append(ppi.getRoleTB().getRolename());
						if(ppi.getRoleid().equals(Integer.valueOf(params.get(PARAMS_ROLEID)==null?"0":params.get(PARAMS_ROLEID).toString()))){
							flag = true;
						}
					//机构
					}else if(IGPRDCONSTANTS.PRIVATESCOPE_ORG.equals(privatescope)){
						tagString.append(ppi.getOrg().getOrgname());
						if(ppi.getOrg().getOrgid().equals(params.get(PARAMS_ORGID)==null?null:params.get(PARAMS_ORGID))){
							flag = true;
						}
					}
					if(flag){
						tagString.append("<input type=\"hidden\" name=\"").append(property).append("\" value=\"").append(ppi.getPpivalue()).append("\"/>");
					}
					tagString.append("</td><td style=\"border-bottom:none;\" width=\"70%\">");
					//判断其他选项是否被选中
					boolean checkElse = false;
					String elseStr = "";
					if(checkValues != null && checkValues.length > 0 ){
						for(String s:checkValues){
							if(s.indexOf("_cev_") > -1){
								checkElse = true;
								elseStr = s;
							}
						}
					}
					if(StringUtils.isNotEmpty(elseStr)){
						elseStr = elseStr.split("_cev_")[1];
					}
					if(options!=null){
						for(String option:options){
							tagString.append("<span style=\"display:block;float:left;height:24px;width:120px;\">");
							tagString.append("<input type=\"checkbox\" class=\"middleAlign\" name=\"pivarcheckbox[")
									 .append(iRadioNum)
									 .append("]\" value=\"")
									 .append(option)
									 .append("\" onclick=\"setCheckbox(")
									 .append(iRadioNum)
									 .append(",this);\" disabled=\"true\"");
							if(StringUtils.isNotEmpty(option)){
								if(checkValues!=null&&checkValues.length>0){
									for(String s:checkValues){
										if(option.equals(s)){
											tagString.append(" checked=\"true\"");
										}
									}
								}
							}
							tagString.append("/>");
							tagString.append(option);
							tagString.append("</span>");
							if(StringUtils.isNotEmpty(showstyles) && SHOWSTYLES_TAG.equals(showstyles)){
								tagString.append("<br/>");
							}
						}
					}
					tagString.append("<span style=\"display:block;float:left;height:24px;width:240px;\">");
					tagString.append("<input type=\"checkbox\" class=\"middleAlign\" name=\"pivarcheckbox[")
					 		 .append(iRadioNum)
					 		 .append("]\" value=\"\"  disabled=\"true\" onclick=\"showOrHiddenCheckBoxElse(this,")
					 		 .append(iRadioNum)
					 		 .append(",this);\"");
					if(checkElse){
						tagString.append(" checked=\"true\"");
					}
					tagString.append("/>其他");
					if(checkElse){
						tagString.append("<input type=\"text\" onchange=\"setCheckBoxElseValue(this,").append(iRadioNum).append(");\"");
						tagString.append("  disabled=\"true\" name=\"pivarcheckboxElseText[").append(iRadioNum).append("]\" value=\"").append(elseStr).append("\" />");
					}
					tagString.append("</span>");
					if(StringUtils.isNotEmpty(unit)){
						tagString.append("<span>"+unit+"</span>");
					}
					if(StringUtils.isNotEmpty(remarks) && REMARK_TAG.equals(remarks)){
						tagString.append("<pre>")
						 .append(pidcomment)
						 .append("</pre>")
						 .append("<input type=\"hidden\" name=\"")
						 .append("pidcomment[")
						 .append(index)
						 .append("]\" value=\"")
						 .append(value)
						 .append("\" />")
						 ;
					}
					tagString.append("</td></tr>");
				}
			}
		}
		tagString.append("</table>");
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
		//取得行号
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		//表单单位取得
		String unit = (String)params.get(PARAMS_PIDUNIT);
		if(StringUtils.isEmpty(unit)){
			unit = "";
		}
		//复选表单显示方式
		String showstyles =  (String) params.get(PARAMS_SHOWSTYLES);
		//相关联事件
		String jsFunction = (String) params.get(PARAMS_JSFUNCTION);
		//是否单行显示
		boolean isNotInline = StringUtils.isNotEmpty(showstyles) && SHOWSTYLES_TAG.equals(showstyles);
		if(value == null || "null".equals(value)){
			value = "";
		}
		//多选值取得
		String[] checkValues = null;
		if(StringUtils.isNotEmpty(value)){
			checkValues = value.split("#");
		}
		//判断其他选项是否被选中
		boolean checkElse = false;
		String elseStr = "";
		if(checkValues != null && checkValues.length > 0 ){
			for(String s:checkValues){
				if(s.indexOf("_cev_") > -1){
					checkElse = true;
					elseStr = s;
				}
			}
		}
		if(StringUtils.isNotEmpty(elseStr)){
			elseStr = elseStr.split("_cev_")[1];
		}
		//声明标签生成字符串
		StringBuffer tagString = new StringBuffer();
		//备选值取得
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		if(options != null && options.length > 0){
			for(String option:options){
				tagString.append("<span ");
				if(!isNotInline){
					tagString.append(" style=\"white-space:nowrap;\"");
				}
				tagString.append(">");
				tagString.append("<input type=\"checkbox\" name=\"column_checkbox\" class=\"middleAlign\" onclick=\"columnValueCheckBox(this);");
				if(StringUtils.isNotEmpty(jsFunction)){
					tagString.append(jsFunction).append("(this);");
				}
				tagString.append("\" ");
				if(checkValues!=null&&checkValues.length>0){
					for(String s:checkValues){
						if(option.equals(s)){
							tagString.append(" checked=\"true\"");
						}
					}
				}
				tagString.append(" value=\"").append(option).append("\" ");
				tagString.append(" />").append(option);
				tagString.append("</span>");
				if(isNotInline){
					tagString.append("<br/>");
				}
			}
			tagString.append("<span ");
			if(!isNotInline){
				tagString.append(" style=\"white-space:nowrap;\"");
			}
			tagString.append(">");
			tagString.append("<input type=\"checkbox\" name=\"column_checkbox\" class=\"middleAlign\" value=\"\" onclick=\"showOrHiddenTableColumnCheckBoxElse(this);");
			if(StringUtils.isNotEmpty(jsFunction)){
				tagString.append(jsFunction).append("(this);");
			}
			tagString.append("\"");
			if(checkElse){
				tagString.append(" checked=\"true\"");
			}
			tagString.append("/>其他");
			tagString.append("</span>");
			tagString.append("<input type=\"text\" onchange=\"setTableColumnCheckBoxElseValue(this);\"");
			if(!checkElse){
				tagString.append("style=\"width:90px;display:none;\" ");
			}
			tagString.append(" name=\"show_value\" value=\"").append(elseStr).append("\" />");
		}
		if(StringUtils.isNotEmpty(unit)){
			tagString.append("<span>"+unit+"</span>").append("<br />");
		}
		tagString.append("<input type=\"hidden\" id=\"").append(pidid).append("_").append(rownum).append("\" rownumber=\"").append(rownum).append("\" name=\"column_value\" value=\"").append(value).append("\"/>");
		tagString.append("<input type=\"hidden\" name=\"column_pidid\" value=\"").append(pidid).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_rownumber\" value=\"").append(rownum).append("\" />");
		return tagString.toString();
	}
	
	/**
	 * 表格类表单只读列生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicReadableTableColumn(Map<String, Object> params){
		//表单定义ID取得
		String pidid = (String) params.get(PARAMS_PIDID);
		//表单值取得
		String value = (String) params.get(PARAMS_VALUE);
		//取得行号
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		//表单单位取得
		String unit = (String)params.get(PARAMS_PIDUNIT);
		if(StringUtils.isEmpty(unit)){
			unit = "";
		}
		//复选表单显示方式
		String showstyles =  (String) params.get(PARAMS_SHOWSTYLES);
		//是否单行显示
		boolean isNotInline = StringUtils.isNotEmpty(showstyles) && SHOWSTYLES_TAG.equals(showstyles);
		if(value == null || "null".equals(value)){
			value = "";
		}
		//多选值取得
		String[] checkValues = null;
		if(StringUtils.isNotEmpty(value)){
			checkValues = value.split("#");
		}
		//声明标签生成字符串
		StringBuffer tagString = new StringBuffer();
		//备选值取得
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		//判断其他选项是否被选中
		boolean checkElse = false;
		String elseStr = "";
		if(checkValues != null && checkValues.length > 0 ){
			for(String s:checkValues){
				if(s.indexOf("_cev_") > -1){
					checkElse = true;
					elseStr = s;
				}
			}
		}
		if(StringUtils.isNotEmpty(elseStr)){
			elseStr = elseStr.split("_cev_")[1];
		}
		if(options != null && options.length > 0){
			for(String option:options){
				tagString.append("<span ");
				if(!isNotInline){
					tagString.append(" style=\"white-space:nowrap;\"");
				}
				tagString.append(">");
				tagString.append("<input type=\"checkbox\" name=\"column_checkbox\" class=\"middleAlign\" onclick=\"columnValueCheckBox(this);\" ");
				if(checkValues!=null&&checkValues.length>0){
					for(String s:checkValues){
						if(option.equals(s)){
							tagString.append(" checked=\"true\"");
						}
					}
				}
				tagString.append(" disabled=\"true\" value=\"").append(option).append("\" ");
				tagString.append(" />").append(option);
				tagString.append("</span>");
				if(StringUtils.isNotEmpty(showstyles) && SHOWSTYLES_TAG.equals(showstyles)){
					tagString.append("<br/>");
				}
			}
		}
		tagString.append("<span ");
		if(!isNotInline){
			tagString.append(" style=\"white-space:nowrap;\"");
		}
		tagString.append(">");
		tagString.append("<input type=\"checkbox\" disabled=\"true\" name=\"column_checkbox\" class=\"middleAlign\" value=\"\" onclick=\"showOrHiddenTableColumnCheckBoxElse(this);\"");
		if(checkElse){
			tagString.append(" checked=\"true\"");
		}
		tagString.append("/>其他");
		tagString.append("</span>");
		tagString.append("<span style=\"white-space:nowrap;\">");
		tagString.append("<input type=\"text\" onchange=\"setTableColumnCheckBoxElseValue(this);\"");
		if(!checkElse){
			tagString.append("style=\"display:none;\" ");
		}
		tagString.append(" disabled=\"true\" name=\"show_value\" value=\"").append(elseStr).append("\" />");
		tagString.append("</span><br />");
		if(isNotInline){
			tagString.append("<span>"+unit+"</span>");
		}
		tagString.append("<input type=\"hidden\" id=\"").append(pidid).append("_").append(rownum).append("\" rownumber=\"").append(rownum).append("\" name=\"column_value\" value=\"").append(value).append("\"/>");
		tagString.append("<input type=\"hidden\" name=\"column_pidid\" value=\"").append(pidid).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_rownumber\" value=\"").append(rownum).append("\" />");
		return tagString.toString();
	}
}
