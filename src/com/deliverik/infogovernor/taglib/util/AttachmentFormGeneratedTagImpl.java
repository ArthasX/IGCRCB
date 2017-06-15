/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.taglib.util;

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
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���������ɱ�ǩ
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class AttachmentFormGeneratedTagImpl extends FormGeneratedTagImpl{
	/**
	 * ���п�д��ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	@SuppressWarnings("unchecked")
	public String generatedPublicWriteableTag(Map<String, Object> params){
		//������ȡ��
		String pidlabel = (String) params.get(PARAMS_PIDLABEL);
		//��ģʽ
		String pidmodel = (String) params.get(PARAMS_PIDMODE);
		//˽�б���Ȩ�޷�Χ
		String privatescope = (String) params.get(PARAMS_PRIVATESCOPE);
		//����������ȡ��
		String pidid = (String) params.get(PARAMS_PIDID);
		//������ȡ��
		String property = (String) params.get(PARAMS_PROPERTY);
		//ȡ��piid
		String piid = (String) params.get(PARAMS_PIID);
		//������ʾģʽȡ��
		Integer pidrows = (Integer) params.get(PARAMS_PIDROWS);
		//��ǩ�����ַ���
		StringBuffer returnValue = new StringBuffer();
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
		boolean flag = true;
		if(textAreaMap!=null && textAreaMap.size() > 0){
			Set<Entry<String, List<Attachment>>> set = textAreaMap.entrySet();
			Entry<String, List<Attachment>> entry = null;
			for(Iterator<Map.Entry<String, List<Attachment>>> iter = set.iterator();iter.hasNext();){
				entry = iter.next();
				if(entry.getKey().equals(category)){
					List<Attachment> list = entry.getValue();
					if(list!=null){
						for(Attachment att:list){
							flag = false;
							returnValue.append("<a href=\"downloadSvcFile.do?attId=")
								       .append(att.getAttid())
								       .append("&type=svc\" id=\"")
								       .append(att.getAttid())
								       .append("\">")
								       .append(att.getAttname().substring(att.getAttname().indexOf("_")+1))
								       .append("</a><img id=\"")
								       .append(att.getAttid())
								       .append("IMG\" src=\"images/delate.gif\" align=\"middle\" ");
							//�฽�������
							if(pidrows != null && pidrows > 1){
								returnValue.append(" onClick=\"delFile('").append(att.getAttid()) .append("','").append(piid) .append("');\" ");
							}else{
								returnValue.append(" onClick=\"singleFileDel('").append(att.getAttid()) .append("','").append(piid) .append("','").append(pidlabel).append("');\" ");
							}
						    returnValue.append(" border=\"0\" style=\"cursor: hand;\" alt=\"ɾ��\"/>");
						} 
					}
				}
			}
		}
		if(flag){
			String value = (String) params.get(PARAMS_VALUE);
			if(StringUtils.isNotEmpty(value)){
				AttachmentBL attBL = (AttachmentBL) WebApplicationSupport.getBean("attachmentBL");
				List<Attachment> list = attBL.searchAttachmentsByAttkey(value);
				for(Attachment att:list){
					flag = false;
					returnValue.append("<a href=\"downloadSvcFile.do?attId=")
						       .append(att.getAttid())
						       .append("&type=svc\" id=\"")
						       .append(att.getAttid())
						       .append("\">")
						       .append(att.getAttname().substring(att.getAttname().indexOf("_")+1))
						       .append("</a><img id=\"")
						       .append(att.getAttid())
						       .append("IMG\" src=\"images/delate.gif\" align=\"middle\" ");
					//�฽�������
					if(pidrows != null && pidrows > 1){
						returnValue.append(" onClick=\"delFile('").append(att.getAttid()) .append("','").append(piid) .append("');\" ");
					}else{
						returnValue.append(" onClick=\"singleFileDel('").append(att.getAttid()) .append("','").append(piid) .append("','").append(pidlabel).append("');\" ");
					}
				    returnValue.append(" border=\"0\" style=\"cursor: hand;\" alt=\"ɾ��\"/>");
				}
			}
		}
		if(pidrows != null && pidrows > 1){
			returnValue.append("<img src=\"images/attachment.gif\" /><a href=\"javascript:addFileMuti('")
					   .append(pidlabel)
					   .append("');\" id=\"aAddAttachMuti\">��Ӹ���</a>&nbsp;&nbsp;&nbsp;");
		}else if(flag){
			returnValue.append("<script>formFileArr[formFileArr.length] = '").append(pidlabel).append("';</script>");
		}
		returnValue.append("<table width=\"100%\" id=\"").append(pidlabel).append("\">");
		returnValue.append("</table>");
		returnValue.append("<input type=\"hidden\" id=\"pidid").append(pidid).append("\" name=\"").append(property).append("\" value=\"att\" />");
		return returnValue.toString();
	}
	
	/**
	 * ����ֻ����ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicReadableTag(Map<String, Object> params){
		return readableAttachmentInfoShow(params);
	}
	
	/**
	 * ��������д������
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	@SuppressWarnings("unchecked")
	public String generatedPublicWriteableTableColumn(Map<String, Object> params){
		StringBuffer tagString = new StringBuffer();
		//���и�����Ϣȡ��
		Map<String, List<Attachment>> tableAttMap = (Map<String, List<Attachment>>) params.get(PARAMS_TABLE_COLUMN_ATTACH_INFO);
		//������ʾģʽȡ��
		Integer pidrows = (Integer) params.get(PARAMS_PIDROWS);
		//��ֵȡ��
		String value = (String) params.get(PARAMS_VALUE);
		if(value == null || "null".equals(value)){
			value = "";
		}
		//����������ȡ��
		String pidid = (String) params.get(PARAMS_PIDID);
		//�к�ȡ��
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		//���ȡ��
		Integer width = (Integer) params.get(PARAMS_PIDWIDTH);
		if(width == null || width == 0){
			width = 150;
		}else if(width > 400){
			width = 300;
		}else{
			width -= 100;
		}
		boolean flag = true;
		if(tableAttMap != null){
			if(StringUtils.isNotEmpty(value)){
				List<Attachment> list = tableAttMap.get(value);
				if(list != null){
					for(Attachment att:list){
						flag = false;
						tagString.append("<a href=\"downloadSvcFile.do?attId=")
								 .append(att.getAttid())
								 .append("&type=svc\" id=\"")
								 .append(att.getAttid())
								 .append("\">")
								 .append(att.getAttname().substring(att.getAttname().indexOf("_")+1))
								 .append("</a>");
						tagString.append("<img id=\"").append(att.getAttid()).append("IMG\" src=\"images/delate.gif\" align=\"middle\" ");
						if(pidrows != null && pidrows > 1){
							tagString.append(" onclick=\"delTableColumnFile(this,").append(att.getAttid()).append(");\" ");
						}else{
							tagString.append(" onclick=\"delSingleTableColumnFile(this,").append(att.getAttid()).append(")\" ");
						}
						tagString.append(" border=\"0\" style=\"cursor: hand;\" alt=\"ɾ��\"/>");
					}
				}
			}
		}
		if(flag && StringUtils.isNotEmpty(value)){
			AttachmentBL attBL = (AttachmentBL) WebApplicationSupport.getBean("attachmentBL");
			List<Attachment> list = attBL.searchAttachmentsByAttkey(value);
			for(Attachment att:list){
				flag = false;
				tagString.append("<a href=\"downloadSvcFile.do?attId=")
						 .append(att.getAttid())
						 .append("&type=svc\" id=\"")
						 .append(att.getAttid())
						 .append("\">")
						 .append(att.getAttname().substring(att.getAttname().indexOf("_")+1))
						 .append("</a>");
				tagString.append("<img id=\"").append(att.getAttid()).append("IMG\" src=\"images/delate.gif\" align=\"middle\" ");
				if(pidrows != null && pidrows > 1){
					tagString.append(" onclick=\"delTableColumnFile(this,").append(att.getAttid()).append(");\" ");
				}else{
					tagString.append(" onclick=\"delSingleTableColumnFile(this,").append(att.getAttid()).append(")\" ");
				}
				tagString.append(" border=\"0\" style=\"cursor: hand;\" alt=\"ɾ��\"/>");
			}
		}
		if(pidrows != null && pidrows > 1){
			tagString.append("<img src=\"images/attachment.gif\" /><a href=\"javascript:void(0);\" onclick=\"tableColumnAddAttach(this);\">��Ӹ���</a>");
			tagString.append("<table name=\"column_attach\" class=\"tableColumnEntity\"></table>");
		}else{
			if(flag){
				tagString.append("<table name=\"column_attach\" class=\"tableColumnEntity\" ><tr><td>");
				tagString.append("<img src=\"images/attachment.gif\" /> ");
				tagString.append("<input type=\"text\" style=\"width:").append(width).append("px;\" readonly=\true\" class=\"tableColumnFile\" name=\"show_value\" />");
				tagString.append("<img src=\"images/file_del.png\" style=\"cursor: hand;\" alt=\"���\" onclick=\"delSingleTableColumnFileInput(this);\"/>");
				tagString.append("<input type=\"file\" name=\"columnTempAttachFile\" onchange=\"changeSingleAttachFile(this);\" class=\"ehdel_upload\" style=\"width:").append(width).append("px;\" />");
				tagString.append("</td></tr></table>");
			}else{
				tagString.append("<table name=\"column_attach\" class=\"tableColumnEntity\"></table>");
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
	@SuppressWarnings("unchecked")
	public String generatedPublicReadableTableColumn(Map<String, Object> params){
		StringBuffer tagString = new StringBuffer();
		//���и�����Ϣȡ��
		Map<String, List<Attachment>> tableAttMap = (Map<String, List<Attachment>>) params.get(PARAMS_TABLE_COLUMN_ATTACH_INFO);
		//��ֵȡ��
		String value = (String) params.get(PARAMS_VALUE);
		if(value == null || "null".equals(value)){
			value = "";
		}
		//����������ȡ��
		String pidid = (String) params.get(PARAMS_PIDID);
		//�к�ȡ��
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		boolean flag = true;
		if(tableAttMap != null){
			if(StringUtils.isNotEmpty(value)){
				List<Attachment> list = tableAttMap.get(value);
				if(list != null){
					for(Attachment att:list){
						flag = false;
						tagString.append("<a href=\"downloadSvcFile.do?attId=")
								 .append(att.getAttid())
								 .append("&type=svc\" id=\"")
								 .append(att.getAttid())
								 .append("\">")
								 .append(att.getAttname().substring(att.getAttname().indexOf("_")+1))
								 .append("</a>");
					}
				}
			}
		}
		if(flag){
			AttachmentBL attBL = (AttachmentBL) WebApplicationSupport.getBean("attachmentBL");
			List<Attachment> list = attBL.searchAttachmentsByAttkey(value);
			for(Attachment att:list){
				tagString.append("<a href=\"downloadSvcFile.do?attId=")
						 .append(att.getAttid())
						 .append("&type=svc\" id=\"")
						 .append(att.getAttid())
						 .append("\">")
						 .append(att.getAttname().substring(att.getAttname().indexOf("_")+1))
						 .append("</a>");
			}
		}
		tagString.append("<input type=\"hidden\" id=\"").append(pidid).append("_").append(rownum).append("\" rownumber=\"").append(rownum).append("\" name=\"column_value\" value=\"").append(value).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_pidid\" value=\"").append(pidid).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_rownumber\" value=\"").append(rownum).append("\" />");
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
//	       String value = (String) params.get(PARAMS_VALUE);
       
       //�ر�֮���״̬��˽�б��б�
       Map<String,List<IG561VWInfo>> statusclosedetails = (Map<String,List<IG561VWInfo>>) params.get(FormGeneratedTag.PARAMS_STATUS_CLOSE);
//       //��ظ���ȡ��
//       Map<String,List<Attachment>> textAreaMap = null;
//       if(params.get(PARAMS_TEXTAREA_ATT_MAP)!=null){
//           textAreaMap = (Map<String, List<Attachment>>) params.get(PARAMS_TEXTAREA_ATT_MAP);
//       }

       
       StringBuffer tagString = new StringBuffer();
       if(statusclosedetails!=null){
           tagString.append("<table class=\"table_form\" style=\"width:100%;\"> " );
           List<IG561VWInfo> list= statusclosedetails.get(pidid);
           for(IG561VWInfo info:list){
               tagString.append("<tr>")
                   .append("<td style=\"width: %;\">").append(info.getPsdname())
                   .append("</td>")
                   .append("<td style=\"width:70%;\">");
               //�ڴ��������⴦���߼� start
               //attkey
               String value=info.getPiattkey();
               
               //Ĭ��ֵ����value
               if(null!=info.getPivarvalue()&&info.getPivarvalue().contains("def_")){
                   value=info.getPivarvalue().substring(4);
               }
               if(!StringUtils.isBlank(value)){
            	   AttachmentBL attBL = (AttachmentBL) WebApplicationSupport.getBean("attachmentBL");
                   List<Attachment> attlist = attBL.searchAttachmentsByAttkey(value);
                   for(Attachment att:attlist){
                       tagString.append("<a href=\"downloadSvcFile.do?attId=")
                                  .append(att.getAttid())
                                  .append("&type=svc\" id=\"")
                                  .append(att.getAttid())
                                  .append("\">")
                                  .append(att.getAttname().substring(att.getAttname().indexOf("_")+1))
                                  .append("</a>");
                   }
               }
               //�ڴ��������⴦���߼� end
               tagString.append("</td>");
               tagString.append("</tr>");
           }
           tagString.append("</table>");
       }
       
       tagString.append("<input type=\"hidden\" id=\"pidid").append(pidid).append("\" name=\"").append(property).append("\" value=\"att\" />");
       return tagString.toString();
   }
	    	
}
