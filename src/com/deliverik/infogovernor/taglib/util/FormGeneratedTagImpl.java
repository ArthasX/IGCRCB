/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.taglib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prr.bl.task.IG899BL;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCondImpl;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����Ϣ���ɶ�Ӧ��ǩʵ�ֻ���
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class FormGeneratedTagImpl implements FormGeneratedTag{
	
	/** ˽�б�ֵBL */
	protected IG899BL ig899BL;

	/**
	 * ˽�б�ֵBL�趨
	 * @param ig899bl ˽�б�ֵBL
	 */
	public void setIg899BL(IG899BL ig899bl) {
		ig899BL = ig899bl;
	}
	
	/**
	 * ���п�д��ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicWriteableTag(Map<String, Object> params){
		return null;
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
		//����λ
		String unit = params.get(PARAMS_PIDUNIT)==null?null:params.get(PARAMS_PIDUNIT).toString();
		//�Ƿ�ӱ�עȡ��
		String remarks = (String)params.get(PARAMS_REMARKS);
		//��ע
		String pidcomment = (String) params.get(PARAMS_PIDCOMMENT);
		//�±�ֵȡ��
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		//��ǩ��������Ϣ
		StringBuffer tagString = new StringBuffer();
		tagString.append("<pre style=\"float:left; margin:0px;\">").append(value).append("</pre>");
		tagString.append("<input type=\"hidden\" id=\"pidid")
		 .append(piid)
		 .append("\" name=\"")
		 .append(property)
		 .append("\" value=\"")
		 .append(value)
		 .append("\" />")
		 ;
		if(StringUtils.isNotEmpty(unit) && StringUtils.isNotEmpty(value)){
			tagString.append("<span style=\"float:left;line-height:15px\">&nbsp;&nbsp;").append(unit).append("</span>");
		}
		if(StringUtils.isNotEmpty(remarks) && REMARK_TAG.equals(remarks)){
			tagString.append("<pre>")
			 .append(pidcomment)
			 .append("</pre>")
			 ;
			tagString.append("<input type=\"hidden\" value=\"")
					 .append(pidcomment)
					 .append("\" name=\"pidcomment[")
					 .append(index)
					 .append("]\"/>");
		}
		return tagString.toString();
	}
	 /**
     *���̹ر�״̬״̬������ʾ
     * @param params ����
     * @return ���̹ر�״̬״̬������ʾ
     */
    public String generatedStatusCloseTag(Map<String, Object> params){
        //ȡ��piid
        String pidid = (String) params.get(PARAMS_PIDID);
        //������ȡ��
        String property = (String) params.get(PARAMS_PROPERTY);
        //��ֵȡ��
        String value = (String) params.get(PARAMS_VALUE);
        //����λȡ��
        String unit = (String)params.get(PARAMS_PIDUNIT);
        //������¼�
        
        //�ر�֮���״̬��˽�б��б�
        @SuppressWarnings("unchecked")
        Map<String,List<IG561VWInfo>> statusclosedetails = (Map<String,List<IG561VWInfo>>) params.get(FormGeneratedTag.PARAMS_STATUS_CLOSE);
        StringBuffer tagString = new StringBuffer();
        if(statusclosedetails!=null){
            tagString.append("<table class=\"table_form\" style=\"width:100%;\"> " );
            List<IG561VWInfo> list= statusclosedetails.get(pidid);
            for(IG561VWInfo info:list){
                tagString.append("<tr>")
                    .append("<td style=\"width:30%;\">").append(info.getPsdname())
                    .append("</td>")
                
                    .append("<td style=\"width:70%;\">");
                String pivarvalue = StringUtils.isBlank(info.getPivarvalue())?"":info.getPivarvalue();
                tagString.append("<pre style=\"float:left; margin:0px;\">").append(pivarvalue).append("</pre>");
                tagString.append("<input type=\"hidden\" id=\"pidid")
                         .append(info.getPiid())
                         .append("\" name=\"")
                         .append(property)
                         .append("\" value=\"")
                         .append(pivarvalue)
                         .append("\" />")
                         ;
                if(StringUtils.isNotEmpty(unit) && StringUtils.isNotEmpty(value)){
                    tagString.append("<span style=\"float:left;line-height:15px\">&nbsp;&nbsp;").append(unit).append("</span>");
                }
                tagString.append("</td>");
                tagString.append("</tr>");
            }
            tagString.append("</table>");
        }
        tagString.append("<input type=\"hidden\" id=\"pidid").append(pidid).append("\" name=\"").append(property).append("\" value=\"\" />");
        return tagString.toString();
    }
		
	/**
	 * ���в��ɼ���ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicHideTag(Map<String, Object> params){
		//ȡ��piid
		String piid = params.get(PARAMS_PIDID)==null?null:params.get(PARAMS_PIDID).toString();
		//������ȡ��
		String property = params.get(PARAMS_PROPERTY)==null?null:params.get(PARAMS_PROPERTY).toString();
		//��ֵȡ��
		String value = params.get(PARAMS_VALUE) == null?null:params.get(PARAMS_VALUE).toString();
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
		return tagString.toString();
	}
	
	/**
	 * ˽�п�д��ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPrivateWriteableTag(Map<String, Object> params){
		//piidȡ��
		String piid = (String) params.get(PARAMS_PIID);
		if(StringUtils.isNotEmpty(piid)){
			//ȡ��˽�б�Ȩ�޷�Χ
			String privatescope =  params.get(PARAMS_PRIVATESCOPE)==null?null:params.get(PARAMS_PRIVATESCOPE).toString();
			//�ж�˽�б���Ȩ�޷�Χ
			if(StringUtils.isNotEmpty(privatescope)){
				//�û�
				IG899SearchCondImpl cond = new IG899SearchCondImpl();
				cond.setPidid(params.get(PARAMS_PIDID)==null?null:params.get(PARAMS_PIDID).toString());
				cond.setPiid(Integer.valueOf(piid));
				if(IGPRDCONSTANTS.PRIVATESCOPE_USER.equals(privatescope)){
					cond.setUserid(params.get(PARAMS_USERID)==null?null:params.get(PARAMS_USERID).toString());
				//��ɫ
				}else if(IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equals(privatescope)){
					cond.setRoleid(Integer.valueOf(params.get(PARAMS_ROLEID)==null?"0":params.get(PARAMS_ROLEID).toString()));
				//����
				}else if(IGPRDCONSTANTS.PRIVATESCOPE_ORG.equals(privatescope)){
					cond.setOrgid(params.get(PARAMS_ORGID)==null?null:params.get(PARAMS_ORGID).toString());
				}
				List<IG899Info> list = ig899BL.searchIG899Info(cond);
				if(list!=null&&!list.isEmpty()){
					params.remove(PARAMS_VALUE);
					params.put(PARAMS_VALUE, list.get(0).getPpivalue());
				}
			}
		}
		return generatedPublicWriteableTag(params);
	}
	
	/**
	 * ˽��ֻ����ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPrivateReadableTag(Map<String, Object> params){
		//ȡ��˽�б�Ȩ�޷�Χ
		String privatescope =  params.get(PARAMS_PRIVATESCOPE)==null?null:params.get(PARAMS_PRIVATESCOPE).toString();
		//piidȡ��
		String piid = (String) params.get(PARAMS_PIID);
		//�ж�˽�б���Ȩ�޷�Χ
		if(StringUtils.isNotEmpty(piid)){
			//�û�
			IG899SearchCondImpl cond = new IG899SearchCondImpl();
			cond.setPidid(params.get(PARAMS_PIDID)==null?null:params.get(PARAMS_PIDID).toString());
			cond.setPiid(Integer.valueOf(piid));
			if(IGPRDCONSTANTS.PRIVATESCOPE_USER.equals(privatescope)){
				cond.setUserid(params.get(PARAMS_USERID)==null?null:params.get(PARAMS_USERID).toString());
			//��ɫ
			}else if(IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equals(privatescope)){
				cond.setRoleid(Integer.valueOf(params.get(PARAMS_ROLEID)==null?"0":params.get(PARAMS_ROLEID).toString()));
			//����
			}else if(IGPRDCONSTANTS.PRIVATESCOPE_ORG.equals(privatescope)){
				cond.setOrgid(params.get(PARAMS_ORGID)==null?null:params.get(PARAMS_ORGID).toString());
			}
			List<IG899Info> list = ig899BL.searchIG899Info(cond);
			if(list!=null&&!list.isEmpty()){
				params.remove(PARAMS_VALUE);
				params.put(PARAMS_VALUE, list.get(0).getPpivalue());
				params.put(PARAMS_PIDCOMMENT, list.get(0).getPpicommect());
			}
		}
		return generatedPublicReadableTag(params);
	}
	
	/**
	 * ˽�в��ɼ���ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPrivateHideTag(Map<String, Object> params){
		//ȡ��pidid
		String pidid = params.get(PARAMS_PIDID)==null?null:params.get(PARAMS_PIDID).toString();
		//������ȡ��
		String property = params.get(PARAMS_PROPERTY)==null?null:params.get(PARAMS_PROPERTY).toString();
		//��ֵȡ��
		String value = params.get(PARAMS_VALUE)==null?null:params.get(PARAMS_VALUE).toString();
		//����λ
		String unit = params.get(PARAMS_PIDUNIT)==null?null:params.get(PARAMS_PIDUNIT).toString();
		//ȡ��˽�б�Ȩ�޷�Χ
		String privatescope =  params.get(PARAMS_PRIVATESCOPE)==null?null:params.get(PARAMS_PRIVATESCOPE).toString();
		//������ȡ��
		String piid = (String) params.get(PARAMS_PIID);
		if(StringUtils.isNotEmpty(piid)){
			//�ж�˽�б���Ȩ�޷�Χ
			if(StringUtils.isNotEmpty(privatescope)){
				//�û�
				IG899SearchCondImpl cond = new IG899SearchCondImpl();
				cond.setPidid(params.get(PARAMS_PIDID)==null?null:params.get(PARAMS_PIDID).toString());
				cond.setPiid(Integer.valueOf(piid));
				if(IGPRDCONSTANTS.PRIVATESCOPE_USER.equals(privatescope)){
					cond.setUserid(params.get(PARAMS_USERID)==null?null:params.get(PARAMS_USERID).toString());
				//��ɫ
				}else if(IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equals(privatescope)){
					cond.setRoleid(Integer.valueOf(params.get(PARAMS_ROLEID)==null?"0":params.get(PARAMS_ROLEID).toString()));
				//����
				}else if(IGPRDCONSTANTS.PRIVATESCOPE_ORG.equals(privatescope)){
					cond.setOrgid(params.get(PARAMS_ORGID)==null?null:params.get(PARAMS_ORGID).toString());
				}
				List<IG899Info> list = ig899BL.searchIG899Info(cond);
				if(list!=null&&!list.isEmpty()){
					value = list.get(0).getPpivalue();
				}
			}
		}
		//��ǩ��������Ϣ
		StringBuffer tagString = new StringBuffer();
		tagString.append("<input type=\"hidden\" id=\"pidid")
				 .append(pidid)
				 .append("\" name=\"")
				 .append(property)
				 .append("\" value=\"")
				 .append(value)
				 .append("\" />")
				 ;
		if(StringUtils.isNotEmpty(unit)){
			tagString.append(unit);
		}
		return tagString.toString();
	}
	
	/**
	 * ˽��ȫ���ɼ���ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPrivateReadableAllTag(Map<String, Object> params){
		//ȡ��˽�б�Ȩ�޷�Χ
		String privatescope =  params.get(PARAMS_PRIVATESCOPE)==null?null:params.get(PARAMS_PRIVATESCOPE).toString();
		//������ȡ��
		String property = (String) params.get(PARAMS_PROPERTY);
		//PIID ȡ��
		String piid = params.get(PARAMS_PIID) == null  || "".equals(params.get(PARAMS_PIID)) ? "0" : params.get(PARAMS_PIID).toString();
		//����λ
		String unit = params.get(PARAMS_PIDUNIT)==null?null:params.get(PARAMS_PIDUNIT).toString();
		//��ǩ��������Ϣ
		StringBuffer tagString = new StringBuffer();
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
						if(StringUtils.isNotEmpty(unit)){
							tagString.append(unit);
						}
					}
					tagString.append("</td><td style=\"border-bottom:none;\" width=\"70%\">");
					tagString.append(ppi.getPpivalue());
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
		return "";
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
		//����λ
		String unit = params.get(PARAMS_PIDUNIT)==null?null:params.get(PARAMS_PIDUNIT).toString();
		if(value == null || "null".equals(value)){
			value = "";
		}
		//������ǩ�����ַ���
		StringBuffer tagString = new StringBuffer();
		tagString.append(StringUtils.isNotEmpty(value) ? value : "&nbsp;");
		tagString.append("<input type=\"hidden\" id=\"").append(pidid).append("_").append(rownum).append("\" rownumber=\"").append(rownum).append("\" name=\"column_value\" value='").append(value).append("' />");
		if(StringUtils.isNotEmpty(unit) && StringUtils.isNotEmpty(value)){
			tagString.append("<span style=\"line-height:15px;\">&nbsp;").append(unit).append("</span>");
		}
		tagString.append("<input type=\"hidden\" name=\"column_pidid\" value=\"").append(pidid).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_rownumber\" value=\"").append(rownum).append("\" />");
		return tagString.toString();
	}
	
	/**
	 * ��д������ʾ����
	 * @param id ��ʾλ��dom����id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String writeableAttachmentInfoShow(Map<String, Object> params){
		//������ȡ��
		String pidlabel = (String) params.get(PARAMS_PIDLABEL);
		//��ģʽ
		String pidmodel = (String) params.get(PARAMS_PIDMODE);
		//˽�б���Ȩ�޷�Χ
		String privatescope = (String) params.get(PARAMS_PRIVATESCOPE);
		//ȡ��piid
		String piid = (String) params.get(PARAMS_PIID);
		StringBuffer returnValue = new StringBuffer();
		returnValue.append("<img src=\"images/attachment.gif\" /><a href=\"javascript:addFileMuti('")
				   .append(pidlabel)
				   .append("');\" id=\"aAddAttachMuti\">��Ӹ���</a>&nbsp;&nbsp;&nbsp;");
		returnValue.append("<table width=\"100%\" id=\"").append(pidlabel).append("\"></table>");
		//��ظ���ȡ��
		Map<String,List<Attachment>> textAreaMap = null;
		if(params.get(PARAMS_TEXTAREA_ATT_MAP)!=null){
			textAreaMap = (Map<String, List<Attachment>>) params.get(PARAMS_TEXTAREA_ATT_MAP);
		}
		String category = pidlabel;
		if(IGPRDCONSTANTS.PIDMODE_PRIVATE.equals(pidmodel)){
			//�û�
			if(IGPRDCONSTANTS.PRIVATESCOPE_USER.equals(privatescope)){
				String userid = (String) params.get(PARAMS_USERID);
				category = pidlabel + "_" + userid;
			//��ɫ
			}else if(IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equals(privatescope)){
				String roleid = (String) params.get(PARAMS_ROLEID);
				category = pidlabel + "_" + roleid;
			//����
			}else if(IGPRDCONSTANTS.PRIVATESCOPE_ORG.equals(privatescope)){
				String orgid = (String) params.get(PARAMS_ORGID);
				category = pidlabel + "_" + orgid;
			}
		}
		if(textAreaMap!=null){
			Set<Entry<String, List<Attachment>>> set = textAreaMap.entrySet();
			Entry<String, List<Attachment>> entry = null;
			for(Iterator<Map.Entry<String, List<Attachment>>> iter = set.iterator();iter.hasNext();){
				entry = iter.next();
				if(entry.getKey().equals(category)){
					List<Attachment> list = entry.getValue();
					if(list!=null){
						for(Attachment att:list){
							returnValue.append("<a href=\"downloadSvcFile.do?attId=")
								       .append(att.getAttid())
								       .append("&type=svc\" id=\"")
								       .append(att.getAttid())
								       .append("\">")
								       .append(att.getAttname().substring(att.getAttname().indexOf("_")+1))
								       .append("</a><img id=\"")
								       .append(att.getAttid())
								       .append("IMG\" src=\"images/delate.gif\" align=\"middle\" onClick=\"delFile('")
								       .append(att.getAttid())
								       .append("','")
								       .append(piid)
								       .append("');\" border=\"0\" style=\"cursor: hand;\" alt=\"ɾ��\"/>");
						} 
					}
				}
			}
		}
		return returnValue.toString();
	}
	
	/**
	 * ֻ��������ʾ����
	 * @param id ��ʾλ��dom����id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String readableAttachmentInfoShow(Map<String, Object> params){
		//������ȡ��
		String pidlabel = (String) params.get(PARAMS_PIDLABEL);
		//��ģʽ
		String pidmodel = (String) params.get(PARAMS_PIDMODE);
		//˽�б���Ȩ�޷�Χ
		String privatescope = (String) params.get(PARAMS_PRIVATESCOPE);
		//��ظ���ȡ��
		Map<String,List<Attachment>> textAreaMap = null;
		if(params.get(PARAMS_TEXTAREA_ATT_MAP)!=null){
			textAreaMap = (Map<String, List<Attachment>>) params.get(PARAMS_TEXTAREA_ATT_MAP);
		}
		StringBuffer returnValue = new StringBuffer();
		String category = pidlabel;
		if(IGPRDCONSTANTS.PIDMODE_PRIVATE.equals(pidmodel)){
			//�û�
			if(IGPRDCONSTANTS.PRIVATESCOPE_USER.equals(privatescope)){
				String userid = (String) params.get(PARAMS_USERID);
				category = pidlabel + "_" + userid;
			//��ɫ
			}else if(IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equals(privatescope)){
				String roleid = (String) params.get(PARAMS_ROLEID);
				category = pidlabel + "_" + roleid;
			//����
			}else if(IGPRDCONSTANTS.PRIVATESCOPE_ORG.equals(privatescope)){
				String orgid = (String) params.get(PARAMS_ORGID);
				category = pidlabel + "_" + orgid;
			}
		}
		if(textAreaMap!=null){
			Set<Entry<String, List<Attachment>>> set = textAreaMap.entrySet();
			Entry<String, List<Attachment>> entry = null;
			for(Iterator<Map.Entry<String, List<Attachment>>> iter = set.iterator();iter.hasNext();){
				entry = iter.next();
				if(entry.getKey().equals(category)){
					List<Attachment> list = entry.getValue();
					if(list!=null){
						for(Attachment att:list){
							returnValue.append("<a href=\"downloadSvcFile.do?attId=")
								       .append(att.getAttid())
								       .append("&type=svc\" id=\"")
								       .append(att.getAttid())
								       .append("\">")
								       .append(att.getAttname().substring(att.getAttname().indexOf("_")+1))
								       .append("</a>&nbsp;");
						} 
					}
				}
			}
		}
		String value = (String) params.get(PARAMS_VALUE);
		if(StringUtils.isNotEmpty(value)){
			AttachmentBL attBL = (AttachmentBL) WebApplicationSupport.getBean("attachmentBL");
			List<Attachment> list = attBL.searchAttachmentsByAttkey(value);
			for(Attachment att:list){
				returnValue.append("<a href=\"downloadSvcFile.do?attId=")
					       .append(att.getAttid())
					       .append("&type=svc\" id=\"")
					       .append(att.getAttid())
					       .append("\">")
					       .append(att.getAttname().substring(att.getAttname().indexOf("_")+1))
					       .append("</a>");
			}
		}
		return returnValue.toString();
	}
	
	/**
	 * ��װ����
	 * @param pid ��������Ϣ
	 * @return ��װ�õĲ���map
	 */
	public static Map<String, Object> packagingParams(Map<String, Object> oldParams,IG007Info pid){
		Map<String, Object> params = new HashMap<String, Object>();
		Class<? extends IG007Info> claz = pid.getClass();
		Field[] fields = claz.getDeclaredFields();
		if(fields != null){
			for(Field field:fields){
				field.setAccessible(true);
				Object val = null;
				try {
					val = field.get(pid);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if("pidtype".equals(field.getName())){
					params.put(PARAMS_FORM_TYPE, val);
				}else if("pidoption".equals(field.getName())){
					params.put(PARAMS_OPTIONS, val);
				}else{
					params.put(field.getName(), val);
				}
			}
		}
		params.put(PARAMS_PIDACCESS, oldParams.get(PARAMS_PIDACCESS));
		params.put(PARAMS_TABLE_COLUMN_INFO, oldParams.get(PARAMS_TABLE_COLUMN_INFO));
		params.put(PARAMS_TABLE_FORM_COLUMN_VALUE, oldParams.get(PARAMS_TABLE_FORM_COLUMN_VALUE));
		params.put(PARAMS_TABLE_FORM_ENTITY_INFO, oldParams.get(PARAMS_TABLE_FORM_ENTITY_INFO));
		params.put(PARAMS_TABLE_COLUMN_ATTACH_INFO, oldParams.get(PARAMS_TABLE_COLUMN_ATTACH_INFO));
		params.put(PARAMS_PRID, oldParams.get(PARAMS_PRID));
		params.put(PARAMS_PSDNAME, oldParams.get(PARAMS_PSDNAME));
		params.put(PARAMS_PROCESSINFO_FORM_VALUE_MAP, oldParams.get(PARAMS_PROCESSINFO_FORM_VALUE_MAP));
		return params;
	}
	
	public Integer getWidth(Integer pidwidth){
		Integer width = null;
		if(pidwidth != null && pidwidth > 0){
			if(1 == pidwidth){
				width = 180;
			}else if(3 == pidwidth){
				width = 500;
			}else if(4 == pidwidth){
				width = 620;
			}else{
				width = pidwidth - 15;
			}
		}
		return width;
	}

    /**
    * ״̬��д��ǩ����
    * @param params ����
    * @return ״̬��ǩ�ַ���
    */
    public String generatedStatusWriteableTag(Map<String, Object> params) {
        return generatedPublicWriteableTag(params);
    }

    /**
     * ״ֻ̬����ǩ����
     * @param params ����
     * @return ״̬��ǩ�ַ���
     */
    public String generatedStatusReadableTag(Map<String, Object> params) {
        return generatedPublicReadableTag(params);
    }

    /**
     * ״̬���ɼ���ǩ����
     * @param params ����
     * @return ״̬��ǩ�ַ���
     */
    public String generatedStatusHideTag(Map<String, Object> params) {
        return generatedPublicHideTag(params);
    }
    
    
}
