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
 * Description: 树表单信息生成对应标签实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class TreeFormGeneratedTagImpl extends FormGeneratedTagImpl{

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
		//流程定义ID
		String ccid = (String) params.get(PARAMS_CCID);
		//下标值取得
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//是否包含备注取得
		String remarks = params.get(PARAMS_REMARKS)==null?null:params.get(PARAMS_REMARKS).toString();
		//相关联事件
		String jsFunction = (String) params.get(PARAMS_JSFUNCTION);
		//只选末级标识取得
		String selecedlast = (String) params.get(PARAMS_SELECED_LAST);
		//备注取得
		String pidcomment = params.get(PARAMS_PIDCOMMENT) == null ? "" : params.get(PARAMS_PIDCOMMENT).toString();
		String selecedFlag = "Y".equals(selecedlast) ? "1" : "0";
		//标签的生成信息
		StringBuffer tagString = new StringBuffer();
		tagString.append("<input type=\"text\" id=\"pidid")
				 .append(pidid)
				 .append("\" name=\"pivartreename[")
				 .append(index)
				 .append("]\" size=\"32\" value=\"")
				 .append(StringUtils.isNotEmpty(value)&&value.contains("_tree_")?value.split("_tree_")[1]:"")
				 .append("\" readonly=\"true\" ");
		if(StringUtils.isNotEmpty(jsFunction)){
			tagString.append(" onchange=\"").append(jsFunction).append("(this);\"");
		}
		tagString.append("/>");
		tagString.append("<img src=\"images/seek.gif\" alt=\"查询\" onclick=\"selectTree(")
				 .append(index)
				 .append(",'")
				 .append(ccid)
				 .append("','")
				 .append(selecedFlag)
				 .append("');\" style=\"cursor: hand\"/>");
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
		tagString.append("<input type=\"hidden\" name=\"").append(property).append("\" value=\"").append(value).append("\" />");
		return tagString.toString();
	}
	
	/**
	 * 公有只读标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicReadableTag(Map<String, Object> params){
		//取得piid
		String piid = (String) params.get(PARAMS_PIDID);
		//表单名称取得
		String property = (String) params.get(PARAMS_PROPERTY);
		//表单值取得
		String value = (String) params.get(PARAMS_VALUE);
		//表单单位取得
		String unit = (String) params.get(PARAMS_PIDUNIT);
		//下标值取得
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//是否加备注取得
		String remarks = (String)params.get(PARAMS_REMARKS);
		//备注
		String pidcomment = (String)params.get(PARAMS_PIDCOMMENT);
		//标签的生成信息
		StringBuffer tagString = new StringBuffer(StringUtils.isNotEmpty(value)&&value.contains("_tree_")?value.split("_tree_")[1]:"");
		tagString.append("<input type=\"hidden\" id=\"pidid")
		 .append(piid)
		 .append("\" name=\"")
		 .append(property)
		 .append("\" value=\"")
		 .append(value)
		 .append("\" />")
		 ;
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
		String property = (String) params.get(PARAMS_PROPERTY);
		//PIID 取得
		String piid = params.get(PARAMS_PIID) == null  || "".equals(params.get(PARAMS_PIID)) ? "0" : params.get(PARAMS_PIID).toString();
		//下标值取得
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//是否加备注取得
		String remarks = (String)params.get(PARAMS_REMARKS);
		//备注
		String pidcomment = (String)params.get(PARAMS_PIDCOMMENT);
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
					tagString.append(StringUtils.isNotEmpty(ppi.getPpivalue())&&ppi.getPpivalue().contains("_tree_")?ppi.getPpivalue().split("_tree_")[1]:"");
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
		//流程定义ID
		String ccid = (String) params.get(PARAMS_CCID);
		//取得行号
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		//相关联事件
		String jsFunction = (String) params.get(PARAMS_JSFUNCTION);
		//只选末级标识取得
		String selecedlast = (String) params.get(PARAMS_SELECED_LAST);
		//表单类型取得
		String pidtype = (String) params.get(PARAMS_FORM_TYPE);
		String selecedFlag = "Y".equals(selecedlast) ? "1" : "0";
		//表单单位取得
		String unit = params.get(PARAMS_PIDUNIT)==null?null:params.get(PARAMS_PIDUNIT).toString();
		if(value == null || "null".equals(value)){
			value = "";
		}
		//声明标签生成字符串
		StringBuffer tagString = new StringBuffer();
		tagString.append("<input type=\"text\" readonly=\"true\" pidtype=\"")
				 .append(pidtype)
				 .append("\" name=\"show_value\" ccid=\"")
				 .append(ccid)
				 .append("\" onclick=\"columnValueTree(this,'")
				 .append(selecedFlag)
				 .append("');\" value=\"")
				 .append(StringUtils.isNotEmpty(value)&&value.contains("_tree_")?value.split("_tree_")[1]:"")
				 .append("\" ");
		if(StringUtils.isNotEmpty(jsFunction)){
			tagString.append(" onchange=\"").append(jsFunction).append("(this);\" ");
		}
		tagString.append("/>");
		if(StringUtils.isNotEmpty(unit)){
			tagString.append("<span>"+unit+"</span>");
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
		//表单单位取得
		String unit = params.get(PARAMS_PIDUNIT)==null?null:params.get(PARAMS_PIDUNIT).toString();
		
		if(value == null || "null".equals(value)){
			value = "";
		}
		//声明标签生成字符串
		StringBuffer tagString = new StringBuffer();
		tagString.append("<pre>").append(StringUtils.isNotEmpty(value)&&value.contains("_tree_")?value.split("_tree_")[1]:"").append("</pre>");
		if(StringUtils.isNotEmpty(unit) && StringUtils.isNotEmpty(value)){
			tagString.append("<span>"+unit+"</span>");
		}
		tagString.append("<input type=\"hidden\" id=\"").append(pidid).append("_").append(rownum).append("\" rownumber=\"").append(rownum).append("\" name=\"column_value\" value=\"").append(value).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_pidid\" value=\"").append(pidid).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_rownumber\" value=\"").append(rownum).append("\" />");
		return tagString.toString();
	}
}
