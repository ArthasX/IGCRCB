/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ѡ��ť����Ϣ���ɶ�Ӧ��ǩʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class RadioFormGeneratedTagImpl extends FormGeneratedTagImpl{

	/**
	 * ���п�д��ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicWriteableTag(Map<String, Object> params){
		//������ȡ��
		String property = params.get(PARAMS_PROPERTY)==null?null:params.get(PARAMS_PROPERTY).toString();
		//��ֵȡ��
		String value = params.get(PARAMS_VALUE)==null?null:params.get(PARAMS_VALUE).toString();
		//����λȡ��
		String unit = params.get(PARAMS_PIDUNIT)==null?null:params.get(PARAMS_PIDUNIT).toString();
		//�±�ֵȡ��
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//�Ƿ������עȡ��
		String remarks = params.get(PARAMS_REMARKS)==null?null:params.get(PARAMS_REMARKS).toString();
		//��ѡ����ʾ��ʽ
		String showstyles =  (String) params.get(PARAMS_SHOWSTYLES);
		//������¼�
		String jsFunction = (String) params.get(PARAMS_JSFUNCTION);
		//����������ȡ�� 
		String pidid = (String) params.get(PARAMS_PIDID);
		//��עȡ��
		String pidcomment = params.get(PARAMS_PIDCOMMENT) == null ? "" : params.get(PARAMS_PIDCOMMENT).toString();
		//��ѡֵȡ��
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		//��ǩ��������Ϣ
		StringBuffer tagString = new StringBuffer();
		if(options!=null){
			for(String option:options){
				tagString.append("<span style=\"display:inline-block\">");
				tagString.append("<input type=\"radio\" class=\"middleAlign\" name=\"pivarradio[")
						 .append(index)
						 .append("]\" value=\"")
						 .append(option)
						 .append("\" onclick=\"setRadio(")
						 .append(index)
						 .append(",this);");
				if(StringUtils.isNotEmpty(jsFunction)){
					tagString.append(jsFunction).append("(this);");
				}
				tagString.append("\"");
				if(StringUtils.isNotEmpty(option)&&option.equals(value)){
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
		tagString.append("<input type=\"hidden\" id=\"pidid").append(pidid).append("\" name=\"").append(property).append("\" value=\"").append(value).append("\" />");
		return tagString.toString();
	}
	
	/**
	 * ����ֻ����ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicReadableTag(Map<String, Object> params){
		//ȡ��piid
		String piid = params.get(PARAMS_PIDID)==null?null:params.get(PARAMS_PIDID).toString();
		//������ȡ��
		String property = params.get(PARAMS_PROPERTY)==null?null:params.get(PARAMS_PROPERTY).toString();
		//��ֵȡ��
		String value = params.get(PARAMS_VALUE)==null?null:params.get(PARAMS_VALUE).toString();
		//����λȡ��
		String unit = params.get(PARAMS_PIDUNIT)==null?null:params.get(PARAMS_PIDUNIT).toString();
		//�±�ֵȡ��
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//�Ƿ�ӱ�עȡ��
		String remarks = (String)params.get(PARAMS_REMARKS);
		//��ע
		String pidcomment = (String)params.get(PARAMS_PIDCOMMENT);
		//��ѡ����ʾ��ʽ
		String showstyles =  (String) params.get(PARAMS_SHOWSTYLES);
		
		//��ѡֵȡ��
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		//��ǩ��������Ϣ
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
						 .append("\" onclick=\"setRadio(")
						 .append(index)
						 .append(",this);\" disabled=\"true\"");
				if(StringUtils.isNotEmpty(option)&&option.equals(value)){
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
	 * ˽��ȫ���ɼ���ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPrivateReadableAllTag(Map<String, Object> params){
		//��ֵȡ��
		String value = params.get(PARAMS_VALUE)==null?null:params.get(PARAMS_VALUE).toString();
		//����λȡ��
		String unit = params.get(PARAMS_PIDUNIT)==null?null:params.get(PARAMS_PIDUNIT).toString();
		//ȡ��˽�б�Ȩ�޷�Χ
		String privatescope =  params.get(PARAMS_PRIVATESCOPE)==null?null:params.get(PARAMS_PRIVATESCOPE).toString();
		//������ȡ��
		String property = params.get(PARAMS_PROPERTY)==null?null:params.get(PARAMS_PROPERTY).toString();
		//PIID ȡ��
		String piid = params.get(PARAMS_PIID) == null  || "".equals(params.get(PARAMS_PIID)) ? "0" : params.get(PARAMS_PIID).toString();
		//�±�ֵȡ��
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//�Ƿ�ӱ�עȡ��
		String remarks = (String)params.get(PARAMS_REMARKS);
		//��ע
		String pidcomment = (String)params.get(PARAMS_PIDCOMMENT);
		//��ѡ����ʾ��ʽ
		String showstyles =  (String) params.get(PARAMS_SHOWSTYLES);
		//��ѡֵȡ��
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		int iRadioNum = 0;
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
					if(options!=null){
						for(String option:options){
							tagString.append("<span style=\"display:inline-block\">");
							tagString.append("<input type=\"radio\" class=\"middleAlign\" name=\"pivarradio[")
									 .append(iRadioNum)
									 .append("]\" value=\"")
									 .append(option)
									 .append("\" onclick=\"setRadio(")
									 .append(iRadioNum)
									 .append(",this);\" disabled=\"true\"");
							if(StringUtils.isNotEmpty(option)&&option.equals(ppi.getPpivalue())){
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
	 * ��������д������
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicWriteableTableColumn(Map<String, Object> params){
		//������IDȡ��
		String pidid = (String) params.get(PARAMS_PIDID);
		//��ֵȡ��
		String value = (String) params.get(PARAMS_VALUE);
		//��ֵȡ��
		String unit = (String) params.get(PARAMS_PIDUNIT);
		//ȡ���к�
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		//������¼�
		String jsFunction = (String) params.get(PARAMS_JSFUNCTION);
		//��ѡ����ʾ��ʽ
		String showstyles =  (String) params.get(PARAMS_SHOWSTYLES);
		//�Ƿ�����ʾ
		boolean isNotInline = StringUtils.isNotEmpty(showstyles) && SHOWSTYLES_TAG.equals(showstyles);
		if(value == null || "null".equals(value)){
			value = "";
		}
		//������ǩ�����ַ���
		StringBuffer tagString = new StringBuffer();
		//��ѡֵȡ��
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		if(options != null){
			for(String option:options){
				tagString.append("<span ");
				if(!isNotInline){
					tagString.append(" style=\"white-space:nowrap;\"");
				}
				tagString.append(">");
				if(value.equals(option)){
					tagString.append("<img style=\"vertical-align:middle;\" name=\"radioImg\" src=\"images/rb02.gif\" class=\"middleAlign\" flag=\"").append(option).append("\" onclick=\"columnVallueRadio(this);");
					if(StringUtils.isNotEmpty(jsFunction)){
						tagString.append(jsFunction).append("(this);");
					}
					tagString.append("\" />");
				}else{
					tagString.append("<img style=\"vertical-align:middle;\" name=\"radioImg\" src=\"images/rb01.gif\" class=\"middleAlign\" flag=\"").append(option).append("\" onclick=\"columnVallueRadio(this);");
					if(StringUtils.isNotEmpty(jsFunction)){
						tagString.append(jsFunction).append("(this);");
					}
					tagString.append("\" />");
				}
				tagString.append(option);
				tagString.append("</span>");		
				if(isNotInline){
					tagString.append("<br />");
				}
			}
		}
		if(StringUtils.isNotEmpty(unit)){
			tagString.append("<span>"+unit+"</span>");
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
		//������IDȡ��
		String pidid = (String) params.get(PARAMS_PIDID);
		//��ֵȡ��
		String value = (String) params.get(PARAMS_VALUE);
		//��ֵȡ��
		String unit = (String) params.get(PARAMS_PIDUNIT);
		//ȡ���к�
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		//��ѡ����ʾ��ʽ
		String showstyles =  (String) params.get(PARAMS_SHOWSTYLES);
		//�Ƿ�����ʾ
		boolean isNotInline = StringUtils.isNotEmpty(showstyles) && SHOWSTYLES_TAG.equals(showstyles);
		if(value == null || "null".equals(value)){
			value = "";
		}
		//������ǩ�����ַ���
		StringBuffer tagString = new StringBuffer();
		//��ѡֵȡ��
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		if(options != null){
			for(String option:options){
				tagString.append("<span ");
				if(!isNotInline){
					tagString.append(" style=\"white-space:nowrap;\"");
				}
				tagString.append(">");
				if(value.equals(option)){
					tagString.append("<img style=\"vertical-align:middle;\" name=\"radioImg\" class=\"middleAlign\" src=\"images/rb02.gif\" flag=\"").append(option).append("\" />");
				}else{
					tagString.append("<img style=\"vertical-align:middle;\" name=\"radioImg\" class=\"middleAlign\" src=\"images/rb01.gif\" flag=\"").append(option).append("\" />");
				}
				tagString.append(option);
				tagString.append("</span>");
				if(isNotInline){
					tagString.append("<br />");
				}
			}
		}
		if(StringUtils.isNotEmpty(unit)){
			tagString.append("<span>"+unit+"</span>");
		}
		tagString.append("<input type=\"hidden\" id=\"").append(pidid).append("_").append(rownum).append("\" rownumber=\"").append(rownum).append("\" name=\"column_value\" value=\"").append(value).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_pidid\" value=\"").append(pidid).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_rownumber\" value=\"").append(rownum).append("\" />");
		return tagString.toString();
	}
}
