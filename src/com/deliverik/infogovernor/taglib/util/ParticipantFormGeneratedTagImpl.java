/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.taglib.util;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.workflow.prr.model.IG506Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
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
	 * ���п�д��ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	@SuppressWarnings("unchecked")
	public String generatedPublicWriteableTag(Map<String, Object> params){
		//����������ȡ��
		String pidid = (String) params.get(PARAMS_PIDID);
		//������ȡ��
		String property = (String) params.get(PARAMS_PROPERTY);
		//��ֵȡ��
		String value = (String) params.get(PARAMS_VALUE);
		//�±�ֵȡ��
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//��Ա��Ϣȡ��
		Map<String, IG506Info> participantFormValueMap = (Map<String, IG506Info>) params.get(PARAMS_PARTICIPANT_FORM_VALUE_MAP);
		//��ɫ����ȡ��
		String ccid = (String) params.get(PARAMS_CCID);
		if(StringUtils.isEmpty(ccid)){
			ccid = "N/A";
		}
		//��ǩ������Ϣ
		StringBuffer tagString = new StringBuffer();
		tagString.append("<img src=\"images/user_add.png\" alt='��ѯ' style=\"cursor: hand;\"/>")
				 .append("<a href=\"javascript:selectPeople('")
		         .append(pidid).append("','")
		         .append(ccid)
		         .append("',")
		         .append(index)
		         .append(");\">�����Ա</a>");
		//������Ϣ
		tagString.append("<div style=\"margin-left:3px;\">");
		tagString.append("<table id=\"people_").append(pidid).append("\" class=\"table_form\"><tr>");
		tagString.append("<th style=\"width:100px;\">����</th>");
		tagString.append("<th style=\"width:150px;\">����</th>");
		tagString.append("<th style=\"width:150px;\">��ɫ</th>");
		tagString.append("<th style=\"width:150px;\">�绰</th>");
		tagString.append("<th style=\"width:50px;\">����</th>");
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
						tagString.append("<td style=\"text-align:center\"><a href=\"javascript:void(0);\" onclick=\"deleteParticipant(this,").append(index).append(",").append(entry.getPiuid()).append(");\">ɾ��</a></td>");
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
	 * ����ֻ����ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	@SuppressWarnings("unchecked")
	public String generatedPublicReadableTag(Map<String, Object> params){
		//����������ȡ��
		String pidid = (String) params.get(PARAMS_PIDID);
		//������ȡ��
		String property = (String) params.get(PARAMS_PROPERTY);
		//��ֵȡ��
		String value = (String) params.get(PARAMS_VALUE);
		//��Ա��Ϣȡ��
		Map<String, IG506Info> participantFormValueMap = (Map<String, IG506Info>) params.get(PARAMS_PARTICIPANT_FORM_VALUE_MAP);
		//��ɫ����ȡ��
		String ccid = (String) params.get(PARAMS_CCID);
		if(StringUtils.isEmpty(ccid)){
			ccid = "N/A";
		}
		//��ǩ������Ϣ
		StringBuffer tagString = new StringBuffer();
		StringBuffer participantStr = new StringBuffer();
		//������Ϣ
		participantStr.append("<div style=\"margin-left:3px;\">");
		participantStr.append("<table id=\"people_").append(pidid).append("\" class=\"table_form\"><tr>");
		participantStr.append("<th style=\"width:100px;\">����</th>");
		participantStr.append("<th style=\"width:150px;\">����</th>");
		participantStr.append("<th style=\"width:150px;\">��ɫ</th>");
		participantStr.append("<th style=\"width:150px;\">�绰</th>");
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
