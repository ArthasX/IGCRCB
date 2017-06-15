/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̱���Ϣ���ɶ�Ӧ��ǩʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings({ "unchecked", "serial" })
public class ProcessFormGeneratedTagImpl extends FormGeneratedTagImpl{

	/**
	 * ���п�д��ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicWriteableTag(Map<String, Object> params){
		//ȡ��piid
		String pidid = params.get(PARAMS_PIDID)==null?null:params.get(PARAMS_PIDID).toString();
		//������ȡ��
		String property = params.get(PARAMS_PROPERTY)==null?null:params.get(PARAMS_PROPERTY).toString();
		//��ֵȡ��
		String value = params.get(PARAMS_VALUE)==null?null:params.get(PARAMS_VALUE).toString();
		//�±�ֵȡ��
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//����ģʽȡ��
		Integer pidrows = (Integer) params.get(PARAMS_PIDROWS);
		//�������ֵȡ��
		Map<String, IG505Info> processInfoFormValueMap = (Map<String, IG505Info>) params.get(PARAMS_PROCESSINFO_FORM_VALUE_MAP);
		//���̷�Χȡ��
		String ccid = (String) params.get(PARAMS_CCID);
		//��ǩ��������Ϣ
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
					 .append("');\">�������</a>")
					 .append("<table style=\"border:none;\" id=\"processform")
				     .append(pidid)
				     .append("\"></table>");
		}else{
			tagString.append("<table style=\"border:none;\" id=\"processform")
					 .append(pidid)
					 .append("\">");
			if(flag){
				tagString.append("<tr id=\"only\"><td style=\"border:none;\"><input type=\"text\" size=\"32\" name=\"show_value\" /><img src=\"images/seek.gif\" alt=\"��ѯ\" onclick=\"openSVCPage(this,")
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
	 * ����ֻ����ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicReadableTag(Map<String, Object> params){
		//������ȡ��
		String property = params.get(PARAMS_PROPERTY)==null?null:params.get(PARAMS_PROPERTY).toString();
		//��ֵȡ��
		String value = params.get(PARAMS_VALUE)==null?null:params.get(PARAMS_VALUE).toString();
		//�������ֵȡ��
		Map<String, IG505Info> processInfoFormValueMap = (Map<String, IG505Info>) params.get(PARAMS_PROCESSINFO_FORM_VALUE_MAP);
		//��ǩ��������Ϣ
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
	 * ˽��ȫ���ɼ���ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPrivateReadableAllTag(Map<String, Object> params){
		//��ֵȡ��
		String value = params.get(PARAMS_VALUE)==null?null:params.get(PARAMS_VALUE).toString();
		//ȡ��˽�б�Ȩ�޷�Χ
		String privatescope =  params.get(PARAMS_PRIVATESCOPE)==null?null:params.get(PARAMS_PRIVATESCOPE).toString();
		//������ȡ��
		String property = (String) params.get(PARAMS_PROPERTY);
		//PIID ȡ��
		String piid = params.get(PARAMS_PIID) == null  || "".equals(params.get(PARAMS_PIID)) ? "0" : params.get(PARAMS_PIID).toString();
		//�������ֵȡ��
		Map<String, IG505Info> processInfoFormValueMap = (Map<String, IG505Info>) params.get(PARAMS_PROCESSINFO_FORM_VALUE_MAP);
		//��ǩ��������Ϣ
		StringBuffer tagString = new StringBuffer(value);
		tagString.append("<table width=\"100%\" >");
		//�ж�˽�б���Ȩ�޷�Χ
		if(StringUtils.isNotEmpty(privatescope)){
			IG899SearchCondImpl cond = new IG899SearchCondImpl();
			cond.setPidid(params.get(PARAMS_PIDID)==null?null:params.get(PARAMS_PIDID).toString());
			cond.setPiid(Integer.valueOf(piid));
			List<IG899Info> list = ig899BL.searchIG899Info(cond);
			if(list!=null&&!list.isEmpty()){
				for(IG899Info ppi:list){
					//��ǰ˽�б�ֵ
					boolean flag = false;
					tagString.append("<tr><td style=\"border-bottom:none;\" width=\"30%\">");
					//�û�
					if(IGPRDCONSTANTS.PRIVATESCOPE_USER.equals(privatescope)){
						tagString.append(ppi.getUserTB().getUsername());
						if(ppi.getUserid().equals(params.get(PARAMS_USERID)==null?null:params.get(PARAMS_USERID).toString())){
							flag = true;
						}
					//��ɫ
					}else if(IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equals(privatescope)){
						tagString.append(ppi.getRoleTB().getRolename());
						if(ppi.getRoleid().equals(Integer.valueOf(params.get(PARAMS_ROLEID)==null?"0":params.get(PARAMS_ROLEID).toString()))){
							flag = true;
						}
					//����
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
	 * ��������д������
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicWriteableTableColumn(Map<String, Object> params){
		//��ֵȡ��
		String value = (String) params.get(PARAMS_VALUE);
		//�������ֵȡ��
		Map<String, IG505Info> processInfoFormValueMap = (Map<String, IG505Info>) params.get(PARAMS_PROCESSINFO_FORM_VALUE_MAP);
		//����ģʽȡ��
		Integer pidrows = (Integer) params.get(PARAMS_PIDROWS);
		//����������ȡ��
		String pidid = (String) params.get(PARAMS_PIDID);
		//ȡ���к�
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
			tagString.append("<img src=\"images/process_add.png\" style=\"cursor: hand;\"/><a href=\"javascript:void(0);\" onclick=\"addTableProcessForm(this);\">�������</a>")
					 .append("<table style=\"border:none;\" name=\"table_column_process\"></table>");
		}else{
			if(flag){
				tagString.append("<table style=\"border:none;\" name=\"table_column_process\">");
				tagString.append("<tr id=\"only\"><td style=\"border:none;\"><input type=\"text\" readonly=\"true\" name=\"column_show\" size=\"18\"/>");
				tagString.append("<img src=\"images/seek.gif\" border=\"0\" width=\"16\" height=\"16\" alt=\"��ѯ\" style=\"cursor: hand;\" onclick=\"columnSelectProcess(this);\" />");
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
	 * ������ֻ��������
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicReadableTableColumn(Map<String, Object> params){
		//��ֵȡ��
		String value = (String) params.get(PARAMS_VALUE);
		//�������ֵȡ��
		Map<String, IG505Info> processInfoFormValueMap = (Map<String, IG505Info>) params.get(PARAMS_PROCESSINFO_FORM_VALUE_MAP);
		//����������ȡ��
		String pidid = (String) params.get(PARAMS_PIDID);
		//ȡ���к�
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
