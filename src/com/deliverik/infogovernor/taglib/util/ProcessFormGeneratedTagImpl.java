/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib.util;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prr.model.IG505Info;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCondImpl;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程表单信息生成对应标签实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings({ "unchecked", "serial" })
public class ProcessFormGeneratedTagImpl extends FormGeneratedTagImpl{

	/**
	 * 公有可写标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicWriteableTag(Map<String, Object> params){
		//取得piid
		String pidid = params.get(PARAMS_PIDID)==null?null:params.get(PARAMS_PIDID).toString();
		//表单名称取得
		String property = params.get(PARAMS_PROPERTY)==null?null:params.get(PARAMS_PROPERTY).toString();
		//表单值取得
		String value = params.get(PARAMS_VALUE)==null?null:params.get(PARAMS_VALUE).toString();
		//下标值取得
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//流程模式取得
		Integer pidrows = (Integer) params.get(PARAMS_PIDROWS);
		//流程类表单值取得
		Map<String, IG505Info> processInfoFormValueMap = (Map<String, IG505Info>) params.get(PARAMS_PROCESSINFO_FORM_VALUE_MAP);
		//流程范围取得
		String ccid = (String) params.get(PARAMS_CCID);
		//标签的生成信息
		StringBuffer tagString = new StringBuffer();
		boolean flag = true;
		if(processInfoFormValueMap != null){
			if(StringUtils.isNotEmpty(value)){
				String[] infos = value.split(",");
				if(infos != null && infos.length > 0){
					tagString.append("<table style=\"border:none;\">");
					for(String s:infos){
						IG505Info entity = processInfoFormValueMap.get(s);
						if(entity != null){
							tagString.append("<tr><td>");
							tagString.append("<a href=\"javascript:openRelatedProcess(")
							         .append(entity.getPiprid())
							         .append(",'WD'")
							         .append(");\" id=\"")
									 .append(entity.getPiprrid())
									 .append("\">")
								     .append(entity.getPiprtitle())
								     .append("</a><img src=\"images/delate.gif\" style=\"cursor: hand;\" align=\"middle\" id=\"")
								     .append(entity.getPiprrid())
								     .append("PRO\" ");
							if(pidrows != null && pidrows > 1){
								tagString.append(" onclick=\"deleteProcessValue('")
										 .append(entity.getPiprrid())
										 .append("',")
										 .append(index)
										 .append(");\"");
							}else{
								tagString.append(" onclick=\"deleteSingleProcessValue('")
										 .append(entity.getPiprrid())
										 .append("',")
										 .append(index)
										 .append(",'")
										 .append(pidid)
										 .append("','")
										 .append(ccid)
										 .append("');\"");
							}
							tagString.append("/></td></tr>");
							flag = false;
						}
					}
					tagString.append("</table>");
				}
			}
		}
		if(pidrows != null && pidrows > 1){
			tagString.append("<img src=\"images/process_add.png\" style=\"cursor: hand;\"/><a href=\"javascript:addProcessForm('")
					 .append(pidid)
					 .append("',")
					 .append(index)
					 .append(",'")
					 .append(ccid)
					 .append("');\">添加流程</a>")
					 .append("<table style=\"border:none;\" id=\"processform")
				     .append(pidid)
				     .append("\"></table>");
		}else{
			tagString.append("<table style=\"border:none;\" id=\"processform")
					 .append(pidid)
					 .append("\">");
			if(flag){
				tagString.append("<tr id=\"only\"><td style=\"border:none;\"><input type=\"text\" size=\"32\" name=\"show_value\" /><img src=\"images/seek.gif\" alt=\"查询\" onclick=\"openSVCPage(this,")
						 .append(index)
						 .append(",'")
						 .append(ccid)
						 .append("');\" style=\"cursor: hand;\"/></td></tr>");
			}
			tagString.append("</table> ");
		}
		tagString.append("<input type=\"hidden\" name=\"").append(property).append("\" value=\"").append(value).append("\" />");
		return tagString.toString();
	}
	
	/**
	 * 公有只读标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicReadableTag(Map<String, Object> params){
		//表单名称取得
		String property = params.get(PARAMS_PROPERTY)==null?null:params.get(PARAMS_PROPERTY).toString();
		//表单值取得
		String value = params.get(PARAMS_VALUE)==null?null:params.get(PARAMS_VALUE).toString();
		//流程类表单值取得
		Map<String, IG505Info> processInfoFormValueMap = (Map<String, IG505Info>) params.get(PARAMS_PROCESSINFO_FORM_VALUE_MAP);
		//标签的生成信息
		StringBuffer tagString = new StringBuffer();
		if(processInfoFormValueMap != null){
			if(StringUtils.isNotEmpty(value)){
				String[] infos = value.split(",");
				if(infos != null && infos.length > 0){
					tagString.append("<table style=\"border:none;\">");
					for(String s:infos){
						IG505Info entity = processInfoFormValueMap.get(s);
						if(entity != null){
							tagString.append("<tr><td>");
							tagString.append("<a href=\"javascript:openRelatedProcess(")
							         .append(entity.getPiprid())
                                     .append(",'WD'")
							         .append(");\" id=\"")
									 .append(entity.getPiprrid())
									 .append("\">")
								     .append(entity.getPiprtitle())
								     .append("</a>")
								     .append("</td></tr>");
						}
					}
					tagString.append("</table>");
				}
			}
		}
		tagString.append("<input type=\"hidden\" name=\"").append(property).append("\" value=\"").append(value).append("\" />");
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
		String property = (String) params.get(PARAMS_PROPERTY);
		//PIID 取得
		String piid = params.get(PARAMS_PIID) == null  || "".equals(params.get(PARAMS_PIID)) ? "0" : params.get(PARAMS_PIID).toString();
		//流程类表单值取得
		Map<String, IG505Info> processInfoFormValueMap = (Map<String, IG505Info>) params.get(PARAMS_PROCESSINFO_FORM_VALUE_MAP);
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
					
					
					if(processInfoFormValueMap != null){
						if(StringUtils.isNotEmpty(ppi.getPpivalue())){
							String[] infos = ppi.getPpivalue().split(",");
							if(infos != null && infos.length > 0){
								tagString.append("<table style=\"border:none;\">");
								for(String s:infos){
									IG505Info entity = processInfoFormValueMap.get(s);
									if(entity != null){
										tagString.append("<tr><td>");
										tagString.append("<a href=\"javascript:openRelatedProcess(")
										         .append(entity.getPiprid())
										         .append(",'WD'")
										         .append(");\" id=\"")
												 .append(entity.getPiprrid())
												 .append("\">")
											     .append(entity.getPiprtitle())
											     .append("</a>")
											     .append("</td></tr>");
									}
								}
								tagString.append("</table>");
							}
						}
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
		//表单值取得
		String value = (String) params.get(PARAMS_VALUE);
		//流程类表单值取得
		Map<String, IG505Info> processInfoFormValueMap = (Map<String, IG505Info>) params.get(PARAMS_PROCESSINFO_FORM_VALUE_MAP);
		//流程模式取得
		Integer pidrows = (Integer) params.get(PARAMS_PIDROWS);
		//表单定义主键取得
		String pidid = (String) params.get(PARAMS_PIDID);
		//取得行号
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		StringBuffer tagString = new StringBuffer();
		boolean flag = true;
		if(processInfoFormValueMap != null){
			if(StringUtils.isNotEmpty(value)){
				String[] infos = value.split(",");
				if(infos != null && infos.length > 0){
					tagString.append("<table style=\"border:none;\">");
					for(String s:infos){
						IG505Info entity = processInfoFormValueMap.get(s);
						if(entity != null){
							tagString.append("<tr><td style=\"border:none;\">");
							tagString.append("<a href=\"javascript:openRelatedProcess(")
							         .append(entity.getPiprid())
							         .append(",'WD'")
							         .append(");\">")
								     .append(entity.getPiprtitle())
								     .append("</a><img src=\"images/delate.gif\" style=\"cursor: hand;\" align=\"middle\" id=\"")
								     .append(entity.getPiprrid())
								     .append("PRO\" ");
							if(pidrows != null && pidrows > 1){
								tagString.append(" onclick=\"deleteTableProcessValue(this,")
										 .append(entity.getPiprrid())
										 .append(");\"");
							}else{
								tagString.append(" onclick=\"deleteSingleTableProcessValue(this,")
										 .append(entity.getPiprrid())
										 .append(");\"");
							}
							tagString.append("/></td></tr>");
							flag = false;
						}
					}
					tagString.append("</table>");
				}
			}
		}
		if(pidrows != null && pidrows > 1){
			tagString.append("<img src=\"images/process_add.png\" style=\"cursor: hand;\"/><a href=\"javascript:void(0);\" onclick=\"addTableProcessForm(this);\">添加流程</a>")
					 .append("<table style=\"border:none;\" name=\"table_column_process\"></table>");
		}else{
			if(flag){
				tagString.append("<table style=\"border:none;\" name=\"table_column_process\">");
				tagString.append("<tr id=\"only\"><td style=\"border:none;\"><input type=\"text\" readonly=\"true\" name=\"column_show\" size=\"18\"/>");
				tagString.append("<img src=\"images/seek.gif\" border=\"0\" width=\"16\" height=\"16\" alt=\"查询\" style=\"cursor: hand;\" onclick=\"columnSelectProcess(this);\" />");
				tagString.append("</td></tr></table>");
			}else{
				tagString.append("<table style=\"border:none;\" name=\"table_column_process\"></table>");
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
		//表单值取得
		String value = (String) params.get(PARAMS_VALUE);
		//流程类表单值取得
		Map<String, IG505Info> processInfoFormValueMap = (Map<String, IG505Info>) params.get(PARAMS_PROCESSINFO_FORM_VALUE_MAP);
		//表单定义主键取得
		String pidid = (String) params.get(PARAMS_PIDID);
		//取得行号
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		StringBuffer tagString = new StringBuffer();
		if(processInfoFormValueMap != null){
			if(StringUtils.isNotEmpty(value)){
				String[] infos = value.split(",");
				if(infos != null && infos.length > 0){
					tagString.append("<table style=\"border:none;\">");
					for(String s:infos){
						IG505Info entity = processInfoFormValueMap.get(s);
						if(entity != null){
							tagString.append("<tr><td style=\"border:none;\">");
							tagString.append("<a href=\"javascript:openRelatedProcess(")
							         .append(entity.getPiprid())
							         .append(",'WD'")
							         .append(");\">")
								     .append(entity.getPiprtitle())
								     .append("</a></td></tr>");
						}
					}
					tagString.append("</table>");
				}
			}
		}
		tagString.append("<input type=\"hidden\" id=\"").append(pidid).append("_").append(rownum).append("\" rownumber=\"").append(rownum).append("\" name=\"column_value\" value=\"").append(value).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_pidid\" value=\"").append(pidid).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_rownumber\" value=\"").append(rownum).append("\" />");
		return tagString.toString();
	}
}
