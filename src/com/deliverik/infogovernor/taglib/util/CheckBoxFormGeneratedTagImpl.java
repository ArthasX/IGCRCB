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
 * Description: ��ѡ�����Ϣ���ɶ�Ӧ��ǩʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CheckBoxFormGeneratedTagImpl extends FormGeneratedTagImpl{

	/**
	 * ���п�д��ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicWriteableTag(Map<String, Object> params){
		//������IDȡ��
		String pidid = (String) params.get(PARAMS_PIDID);
		//������ȡ��
		String property = params.get(PARAMS_PROPERTY)==null?null:params.get(PARAMS_PROPERTY).toString();
		//��ֵȡ��
		String value = params.get(PARAMS_VALUE)==null?null:params.get(PARAMS_VALUE).toString();
		//�±�ֵȡ��
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//����λȡ��
		String unit = (String)params.get(PARAMS_PIDUNIT);
		//�Ƿ������עȡ��
		String remarks = params.get(PARAMS_REMARKS)==null?null:params.get(PARAMS_REMARKS).toString();
		//�ı��򳤶�ȡ��
		String textAreaSize = (String) params.get(PARAMS_TEXTAREA_SIZE);
		//��ѡ����ʾ��ʽ
		String showstyles =  (String) params.get(PARAMS_SHOWSTYLES);
		//������¼�
		String jsFunction = (String) params.get(PARAMS_JSFUNCTION);
		//��ѡֵȡ��
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		//��ѡֵȡ��
		String[] checkValues = null;
		if(StringUtils.isNotEmpty(value)){
			checkValues = value.split("#");
		}
		//��ǩ��������Ϣ
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
		}
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
		String unit = (String)params.get(PARAMS_PIDUNIT);
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
		//��ѡֵȡ��
		String[] checkValues = null;
		if(StringUtils.isNotEmpty(value)){
			checkValues = value.split("#");
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
		//ȡ��˽�б�Ȩ�޷�Χ
		String privatescope =  params.get(PARAMS_PRIVATESCOPE)==null?null:params.get(PARAMS_PRIVATESCOPE).toString();
		//������ȡ��
		String property = params.get(PARAMS_PROPERTY)==null?null:params.get(PARAMS_PROPERTY).toString();
		//PIID ȡ��
		String piid = params.get(PARAMS_PIID) == null || "".equals(params.get(PARAMS_PIID)) ? "0" : params.get(PARAMS_PIID).toString();
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
		//��ѡֵȡ��
		String[] checkValues = null;
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
					iRadioNum++;
					if(StringUtils.isNotEmpty(value)){
						checkValues = StringUtils.isNotEmpty(ppi.getPpivalue())?ppi.getPpivalue().split("#"):new String[0];
					}
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
		//����λȡ��
		String unit = (String)params.get(PARAMS_PIDUNIT);
		//ȡ���к�
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		//��ѡ����ʾ��ʽ
		String showstyles =  (String) params.get(PARAMS_SHOWSTYLES);
		//������¼�
		String jsFunction = (String) params.get(PARAMS_JSFUNCTION);
		//�Ƿ�����ʾ
		boolean isNotInline = StringUtils.isNotEmpty(showstyles) && SHOWSTYLES_TAG.equals(showstyles);
		if(value == null || "null".equals(value)){
			value = "";
		}
		//��ѡֵȡ��
		String[] checkValues = null;
		if(StringUtils.isNotEmpty(value)){
			checkValues = value.split("#");
		}
		//������ǩ�����ַ���
		StringBuffer tagString = new StringBuffer();
		//��ѡֵȡ��
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
	 * ������ֻ��������
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicReadableTableColumn(Map<String, Object> params){
		//������IDȡ��
		String pidid = (String) params.get(PARAMS_PIDID);
		//��ֵȡ��
		String value = (String) params.get(PARAMS_VALUE);
		//ȡ���к�
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		//����λȡ��
		String unit = (String)params.get(PARAMS_PIDUNIT);
		//��ѡ����ʾ��ʽ
		String showstyles =  (String) params.get(PARAMS_SHOWSTYLES);
		//�Ƿ�����ʾ
		boolean isNotInline = StringUtils.isNotEmpty(showstyles) && SHOWSTYLES_TAG.equals(showstyles);
		if(value == null || "null".equals(value)){
			value = "";
		}
		//��ѡֵȡ��
		String[] checkValues = null;
		if(StringUtils.isNotEmpty(value)){
			checkValues = value.split("#");
		}
		//������ǩ�����ַ���
		StringBuffer tagString = new StringBuffer();
		//��ѡֵȡ��
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
		if(isNotInline){
			tagString.append("<span>"+unit+"</span>");
		}
		tagString.append("<input type=\"hidden\" id=\"").append(pidid).append("_").append(rownum).append("\" rownumber=\"").append(rownum).append("\" name=\"column_value\" value=\"").append(value).append("\"/>");
		tagString.append("<input type=\"hidden\" name=\"column_pidid\" value=\"").append(pidid).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_rownumber\" value=\"").append(rownum).append("\" />");
		return tagString.toString();
	}
}
