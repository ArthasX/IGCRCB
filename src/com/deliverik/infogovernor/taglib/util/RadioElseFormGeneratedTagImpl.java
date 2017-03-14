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
 * Description: 单选其他表单信息生成对应标签实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class RadioElseFormGeneratedTagImpl extends FormGeneratedTagImpl{

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
		//表单单位取得
		String unit = params.get(PARAMS_PIDUNIT)==null?null:params.get(PARAMS_PIDUNIT).toString();
		//下标值取得
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//是否包含备注取得
		String remarks = params.get(PARAMS_REMARKS)==null?null:params.get(PARAMS_REMARKS).toString();
		//复选表单显示方式
		String showstyles =  (String) params.get(PARAMS_SHOWSTYLES);
		//相关联事件
		String jsFunction = (String) params.get(PARAMS_JSFUNCTION);
		//表单定义ID取得
		String pidid = (String) params.get(PARAMS_PIDID);
		//备注取得
		String pidcomment = params.get(PARAMS_PIDCOMMENT) == null ? "" : params.get(PARAMS_PIDCOMMENT).toString();
		//备选值取得
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		//是否显示其他选项标识
		boolean radio_flag = true;
		if(StringUtils.isEmpty(value)){
			radio_flag = false;
		}
		//是否选中其他选项
		String checked_other = "";
		//是否先睡其他选项控制
		String display_other = "";
		//标签的生成信息
		StringBuffer tagString = new StringBuffer();
		if(options!=null){
			for(String option:options){
				tagString.append("<span style=\"display:inline-block\">");
				tagString.append("<input type=\"radio\" class=\"middleAlign\" name=\"pivarradio[")
						 .append(index)
						 .append("]\" value=\"")
						 .append(option)
						 .append("\" onclick=\"setRadio_other(")
						 .append(index)
						 .append(",this,'else');");
				if(StringUtils.isNotEmpty(jsFunction)){
					tagString.append(jsFunction).append("(this);");
				}
				tagString.append("\"");
				if(StringUtils.isNotEmpty(option)&&option.equals(value)){
					tagString.append(" checked=\"true\"");
					radio_flag = false;
				}
				tagString.append("/>");
				tagString.append(option);
				tagString.append("</span>");
				if(StringUtils.isNotEmpty(showstyles) && SHOWSTYLES_TAG.equals(showstyles)){
					tagString.append("<br/>");
				}					
			}
		}
		if(radio_flag){
			checked_other = "checked=\"checked\"";
		}else{
			display_other = "display: none;";
		}
		tagString.append("<span style=\"white-space:nowrap;\"/><input id=\"pivarradio_Other[")
				 .append(index)
				 .append("]\" type=\"radio\" class=\"middleAlign\" name=\"pivarradio[")
				 .append(index)
				 .append("]\" value=\"")
				 .append(value)
				 .append("\" onclick=\"setRadio_other(")
				 .append(index)
				 .append(",this,'other');");
		if(StringUtils.isNotEmpty(jsFunction)){
			tagString.append(jsFunction).append("(this);");
		}
		tagString.append("\" ")
				 .append(checked_other)
				 .append("/>其他</span>");
		tagString.append("<input type=\"text\" style=\"")
				 .append(display_other)
				 .append("\" id=\"pivarvalue_Other[")
				 .append(index)
				 .append("]\" name=\"")
				 .append("\" size=\"18\" value=\"")
				 .append(StringUtils.isNotEmpty(value) && value.contains("cv_cev_") ? value.split("cv_cev_")[1] : value)
				 .append("\" onchange=\"setOnChage_other(")
				 .append(index)
				 .append(",this);\" /> ");
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
		tagString.append("<input type=\"hidden\" id=\"pidid").append(pidid). append("\" name=\"").append(property).append("\" value=\"").append(value).append("\" />");
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
		//是否显示其他选项标识
		boolean radio_flag = true;
		if(StringUtils.isEmpty(value)){
			radio_flag = false;
		}
		//是否选中其他选项
		String checked_other = "";
		//是否先睡其他选项控制
		String display_other = "";
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
				tagString.append("<span style=\"display:inline-block\">");
				tagString.append("<input type=\"radio\" class=\"middleAlign\" name=\"pivarradio[")
						 .append(index)
						 .append("]\" value=\"")
						 .append(option)
						 .append("\" onclick=\"setRadio_other(")
						 .append(index)
						 .append(",this,'else');\" disabled=\"true\"");
				if(StringUtils.isNotEmpty(option)&&option.equals(value)){
					tagString.append(" checked=\"true\"");
					radio_flag = false;
				}
				tagString.append("/>");
				tagString.append(option);
				tagString.append("</span>");
				if(StringUtils.isNotEmpty(showstyles) && SHOWSTYLES_TAG.equals(showstyles)){
					tagString.append("<br/>");
				}					
			}
		}
		if(radio_flag){
			checked_other = "checked=\"checked\"";
		}else{
			display_other = "display: none;";
		}
		tagString.append("<input id=\"pivarradio_Other[")
				 .append(index)
				 .append("]\" type=\"radio\" class=\"middleAlign\" name=\"pivarradio[")
				 .append(index)
				 .append("]\" value=\"")
				 .append(value)
				 .append("\" onclick=\"setRadio_other(")
				 .append(index)
				 .append(",this,'other');\" disabled=\"true\" ")
				 .append(checked_other)
				 .append("/>其他");
		tagString.append("<input type=\"text\" class=\"inputDisable\" style=\"")
				 .append(display_other)
				 .append("\" id=\"pivarvalue_Other[")
				 .append(index)
				 .append("]\" name=\"")
				 .append("\" size=\"18\" value=\"")
				 .append(StringUtils.isNotEmpty(value) && value.contains("cv_cev_") ? value.split("cv_cev_")[1] : value)
				 .append("\" onchange=\"setOnChage_other(")
				 .append(index)
				 .append(",this);\" /> ");
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
		//表单单位取得
		String unit = params.get(PARAMS_PIDUNIT)==null?null:params.get(PARAMS_PIDUNIT).toString();
		//取得私有表单权限范围
		String privatescope =  params.get(PARAMS_PRIVATESCOPE)==null?null:params.get(PARAMS_PRIVATESCOPE).toString();
		//表单名称取得
		String property = params.get(PARAMS_PROPERTY)==null?null:params.get(PARAMS_PROPERTY).toString();
		//PIID 取得
		String piid = params.get(PARAMS_PIID) == null  || "".equals(params.get(PARAMS_PIID)) ? "0" : params.get(PARAMS_PIID).toString();
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
		int iRadioNum = 0;
		//是否显示其他选项标识
		boolean radio_flag = true;
		//是否选中其他选项
		String checked_other = "";
		//是否先睡其他选项控制
		String display_other = "";
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
					if(options!=null){
						for(String option:options){
							tagString.append("<span style=\"display:inline-block\">");
							tagString.append("<input type=\"radio\" class=\"middleAlign\" name=\"pivarradio[")
									 .append(iRadioNum)
									 .append("]\" value=\"")
									 .append(option)
									 .append("\" onclick=\"setRadio_other(")
									 .append(iRadioNum)
									 .append(",this,'else');\" disabled=\"true\"");
							if(StringUtils.isNotEmpty(option)&&option.equals(value)){
								tagString.append(" checked=\"true\"");
								radio_flag = false;
							}
							tagString.append("/>");
							tagString.append(option);
							tagString.append("</span>");
							if(StringUtils.isNotEmpty(showstyles) && SHOWSTYLES_TAG.equals(showstyles)){
								tagString.append("<br/>");
							}							
						}
					}
					if(radio_flag){
						checked_other = "checked=\"checked\"";
					}else{
						display_other = "display: none;";
					}
					tagString.append("<input id=\"pivarradio_Other[")
							 .append(index)
							 .append("]\" type=\"radio\" class=\"middleAlign\" name=\"pivarradio[")
							 .append(index)
							 .append("]\" value=\"")
							 .append(value)
							 .append("\" onclick=\"setRadio_other(")
							 .append(index)
							 .append(",this,'other');\" disabled=\"true\" ")
							 .append(checked_other)
							 .append("/>其他");
					tagString.append("<input type=\"text\" class=\"inputDisable\" style=\"")
							 .append(display_other)
							 .append("\" id=\"pivarvalue_Other[")
							 .append(index)
							 .append("]\" name=\"")
							 .append(property)
							 .append("\" size=\"18\" value=\"")
							 .append(value)
							 .append("\" onchange=\"setOnChage_other(")
							 .append(index)
							 .append(",this);\" /> ");
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
		//复选表单显示方式
		String showstyles =  (String) params.get(PARAMS_SHOWSTYLES);
		//表单单位取得
		String unit = params.get(PARAMS_PIDUNIT)==null?null:params.get(PARAMS_PIDUNIT).toString();
		//相关联事件
		String jsFunction = (String) params.get(PARAMS_JSFUNCTION);
		//是否单行显示
		boolean isNotInline = StringUtils.isNotEmpty(showstyles) && SHOWSTYLES_TAG.equals(showstyles);
		if(value == null || "null".equals(value)){
			value = "";
		}
		//声明标签生成字符串
		StringBuffer tagString = new StringBuffer();
		//备选值取得
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		if(options != null){
			boolean eqFlag = true;
			for(String option:options){
				tagString.append("<span ");
				if(!isNotInline){
					tagString.append(" style=\"white-space:nowrap;\"");
				}
				tagString.append(">");
				if(value.equals(option)){
					eqFlag = false;
					tagString.append("<img style=\"vertical-align:middle;\" name=\"radioImg\" class=\"middleAlign\" src=\"images/rb02.gif\" flag=\"").append(option).append("\" onclick=\"columnVallueRadio(this);");
					if(StringUtils.isNotEmpty(jsFunction)){
						tagString.append(jsFunction).append("(this);");
					}
					tagString.append("\" />");
				}else{
					tagString.append("<img style=\"vertical-align:middle;\" name=\"radioImg\" class=\"middleAlign\" src=\"images/rb01.gif\" flag=\"").append(option).append("\" onclick=\"columnVallueRadio(this);");
					if(StringUtils.isNotEmpty(jsFunction)){
						tagString.append(jsFunction).append("(this);");
					}
					tagString.append("\" />");
				}
				tagString.append(option);
				tagString.append("</span>");
				if(isNotInline){
					tagString.append("<br/>");
				}
			}
			if(StringUtils.isNotEmpty(value) && eqFlag){
				tagString.append("<span ");
				if(!isNotInline){
					tagString.append(" style=\"white-space:nowrap;\"");
				}
				tagString.append(">");
				tagString.append("<img style=\"vertical-align:middle;\" name=\"radioImg\" class=\"middleAlign\" src=\"images/rb02.gif\" flag=\"\" onclick=\"columnVallueRadioElse(this);");
				if(StringUtils.isNotEmpty(jsFunction)){
					tagString.append(jsFunction).append("(this);");
				}
				tagString.append("\" />其他");
				tagString.append("</span>");
				tagString.append("<span  style=\"white-space:nowrap;\">");
				tagString.append("<input type=\"text\" name=\"show_value\" value=\"").append(StringUtils.isNotEmpty(value) && value.contains("_cev_") ? value.split("_cev_")[1] : value).append("\" onchange=\"columnVallueRadioElseTest(this);\" />");
				tagString.append("</span>");
			}else{
				tagString.append("<span ");
				if(!isNotInline){
					tagString.append(" style=\"white-space:nowrap;\"");
				}
				tagString.append(">");
				tagString.append("<img style=\"vertical-align:middle;\" name=\"radioImg\" class=\"middleAlign\" src=\"images/rb01.gif\" flag=\"\" onclick=\"columnVallueRadioElse(this);");
				if(StringUtils.isNotEmpty(jsFunction)){
					tagString.append(jsFunction).append("(this);");
				}
				tagString.append("\" />其他");
				tagString.append("</span>");
				tagString.append("<span  style=\"white-space:nowrap;\">");
				tagString.append("<input type=\"text\" name=\"show_value\" style=\"display:none;\"  onchange=\"columnVallueRadioElseTest(this);\" />");
				tagString.append("</span>");
			}
			if(StringUtils.isNotEmpty(unit)){
				tagString.append("<span>"+unit+"</span>");
			}
		}
		tagString.append("<input type=\"hidden\" id=\"").append(pidid).append("_").append(rownum).append("\" rownumber=\"").append(rownum).append("\" name=\"column_value\" value=\"").append(value).append("\" />");
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
		//复选表单显示方式
		String showstyles =  (String) params.get(PARAMS_SHOWSTYLES);
		//表单单位取得
		String unit = params.get(PARAMS_PIDUNIT)==null?null:params.get(PARAMS_PIDUNIT).toString();
		//是否单行显示
		boolean isNotInline = StringUtils.isNotEmpty(showstyles) && SHOWSTYLES_TAG.equals(showstyles);
		if(value == null || "null".equals(value)){
			value = "";
		}
		//声明标签生成字符串
		StringBuffer tagString = new StringBuffer();
		//备选值取得
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		if(options != null){
			boolean eqFlag = true;
			for(String option:options){
				tagString.append("<span ");
				if(!isNotInline){
					tagString.append(" style=\"white-space:nowrap;\"");
				}
				tagString.append(">");
				if(value.equals(option)){
					eqFlag = false;
					tagString.append("<img style=\"vertical-align:middle;\" name=\"radioImg\" class=\"middleAlign\" src=\"images/rb02.gif\" flag=\"").append(option).append("\" />");
				}else{
					tagString.append("<img style=\"vertical-align:middle;\" name=\"radioImg\" class=\"middleAlign\" src=\"images/rb01.gif\" flag=\"").append(option).append("\" />");
				}
				tagString.append(option);
				tagString.append("</span>");
				if(isNotInline){
					tagString.append("<br/>");
				}
			}
			if(StringUtils.isNotEmpty(value) && eqFlag){
				tagString.append("<span ");
				if(!isNotInline){
					tagString.append(" style=\"white-space:nowrap;\"");
				}
				tagString.append(">");
				tagString.append("<img style=\"vertical-align:middle;\" name=\"radioImg\" class=\"middleAlign\" src=\"images/rb02.gif\" flag=\"\" />其他");
				tagString.append("</span>");
				tagString.append("<span  style=\"white-space:nowrap;\">");
				tagString.append("<input type=\"text\" name=\"show_value\" value=\"").append(StringUtils.isNotEmpty(value) && value.contains("_cev_") ? value.split("_cev_")[1] : value).append("\" readonly=\true\" />");
				tagString.append("</span>");
			}else{
				tagString.append("<span ");
				if(!isNotInline){
					tagString.append(" style=\"white-space:nowrap;\"");
				}
				tagString.append(">");
				tagString.append("<img style=\"vertical-align:middle;\" name=\"radioImg\" class=\"middleAlign\" src=\"images/rb01.gif\" flag=\"\" />其他");
				tagString.append("</span>");
				tagString.append("<span  style=\"white-space:nowrap;\">");
				tagString.append("<input type=\"text\" name=\"show_value\" style=\"display:none;\"  onchange=\"columnVallueRadioElseTest(this);\" />");
				tagString.append("</span>");
			}
			if(StringUtils.isNotEmpty(unit)){
				tagString.append("<span>"+unit+"</span>");
			}
		}
		tagString.append("<input type=\"hidden\" id=\"").append(pidid).append("_").append(rownum).append("\" rownumber=\"").append(rownum).append("\" name=\"column_value\" value=\"").append(value).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_pidid\" value=\"").append(pidid).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_rownumber\" value=\"").append(rownum).append("\" />");
		return tagString.toString();
	}
}
