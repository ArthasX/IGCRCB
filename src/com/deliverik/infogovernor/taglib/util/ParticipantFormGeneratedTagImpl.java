/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib.util;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.workflow.prr.model.IG506Info;

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
public class ParticipantFormGeneratedTagImpl extends FormGeneratedTagImpl{

	/**
	 * 公有可写标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	@SuppressWarnings("unchecked")
	public String generatedPublicWriteableTag(Map<String, Object> params){
		//表单定义主键取得
		String pidid = (String) params.get(PARAMS_PIDID);
		//表单名称取得
		String property = (String) params.get(PARAMS_PROPERTY);
		//表单值取得
		String value = (String) params.get(PARAMS_VALUE);
		//下标值取得
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//人员信息取得
		Map<String, IG506Info> participantFormValueMap = (Map<String, IG506Info>) params.get(PARAMS_PARTICIPANT_FORM_VALUE_MAP);
		//角色类型取得
		String ccid = (String) params.get(PARAMS_CCID);
		if(StringUtils.isEmpty(ccid)){
			ccid = "N/A";
		}
		//标签生成信息
		StringBuffer tagString = new StringBuffer();
		tagString.append("<img src=\"images/user_add.png\" alt='查询' style=\"cursor: hand;\"/>")
				 .append("<a href=\"javascript:selectPeople('")
		         .append(pidid).append("','")
		         .append(ccid)
		         .append("',")
		         .append(index)
		         .append(");\">添加人员</a>");
		//标题信息
		tagString.append("<div style=\"margin-left:3px;\">");
		tagString.append("<table id=\"people_").append(pidid).append("\" class=\"table_form\"><tr>");
		tagString.append("<th style=\"width:100px;\">姓名</th>");
		tagString.append("<th style=\"width:150px;\">机构</th>");
		tagString.append("<th style=\"width:150px;\">角色</th>");
		tagString.append("<th style=\"width:150px;\">电话</th>");
		tagString.append("<th style=\"width:50px;\">操作</th>");
		tagString.append("</tr>");
		if(participantFormValueMap != null && StringUtils.isNotEmpty(value)){
			String[] info = value.split(",");
			if(info != null && info.length > 0){
				for(String key:info){
					IG506Info entry = participantFormValueMap.get(key);
					if(entry != null){
						tagString.append("<tr name=\"").append(entry.getPiuserid()).append("\">");
						tagString.append("<td>").append(entry.getPiusername()).append("</td>");
						tagString.append("<td>").append(entry.getPiorgname()).append("</td>");
						tagString.append("<td>").append(entry.getPirolename()).append("</td>");
						tagString.append("<td>").append(entry.getPiphone()).append("</td>");
						tagString.append("<td style=\"text-align:center\"><a href=\"javascript:void(0);\" onclick=\"deleteParticipant(this,").append(index).append(",").append(entry.getPiuid()).append(");\">删除</a></td>");
						tagString.append("</tr>");
					}
				}
			}
		}
		tagString.append("</table></div>");
		tagString.append("<input type=\"hidden\" name=\"")
		         .append(property)
		         .append("\" id=\"pidid")
		         .append(pidid)
		         .append("\" value=\"")
		         .append(value)
		         .append("\" />");
		return tagString.toString();
	}
	

	/**
	 * 公有只读标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	@SuppressWarnings("unchecked")
	public String generatedPublicReadableTag(Map<String, Object> params){
		//表单定义主键取得
		String pidid = (String) params.get(PARAMS_PIDID);
		//表单名称取得
		String property = (String) params.get(PARAMS_PROPERTY);
		//表单值取得
		String value = (String) params.get(PARAMS_VALUE);
		//人员信息取得
		Map<String, IG506Info> participantFormValueMap = (Map<String, IG506Info>) params.get(PARAMS_PARTICIPANT_FORM_VALUE_MAP);
		//角色类型取得
		String ccid = (String) params.get(PARAMS_CCID);
		if(StringUtils.isEmpty(ccid)){
			ccid = "N/A";
		}
		//标签生成信息
		StringBuffer tagString = new StringBuffer();
		StringBuffer participantStr = new StringBuffer();
		//标题信息
		participantStr.append("<div style=\"margin-left:3px;\">");
		participantStr.append("<table id=\"people_").append(pidid).append("\" class=\"table_form\"><tr>");
		participantStr.append("<th style=\"width:100px;\">姓名</th>");
		participantStr.append("<th style=\"width:150px;\">机构</th>");
		participantStr.append("<th style=\"width:150px;\">角色</th>");
		participantStr.append("<th style=\"width:150px;\">电话</th>");
		participantStr.append("</tr>");
		boolean flag = false;
		if(participantFormValueMap != null && StringUtils.isNotEmpty(value)){
			String[] info = value.split(",");
			if(info != null && info.length > 0){
				for(String key:info){
					IG506Info entry = participantFormValueMap.get(key);
					if(entry != null){
						flag = true;
						participantStr.append("<tr>");
						participantStr.append("<td>").append(entry.getPiusername()).append("</td>");
						participantStr.append("<td>").append(entry.getPiorgname()).append("</td>");
						participantStr.append("<td>").append(entry.getPirolename()).append("</td>");
						participantStr.append("<td>").append(entry.getPiphone()).append("</td>");
						participantStr.append("</tr>");
					}
				}
			}
		}
		participantStr.append("</table></div>");
		if(flag){
			tagString.append(participantStr);
		}
		tagString.append("<input type=\"hidden\" name=\"")
		         .append(property)
		         .append("\" id=\"pidid")
		         .append(pidid)
		         .append("\" value=\"")
		         .append(value)
		         .append("\" />");
		return tagString.toString();
	}
}
