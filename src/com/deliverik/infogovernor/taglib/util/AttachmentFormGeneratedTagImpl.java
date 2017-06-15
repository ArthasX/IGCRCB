/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 附件表单生成标签
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class AttachmentFormGeneratedTagImpl extends FormGeneratedTagImpl{
	/**
	 * 公有可写标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	@SuppressWarnings("unchecked")
	public String generatedPublicWriteableTag(Map<String, Object> params){
		//表单名称取得
		String pidlabel = (String) params.get(PARAMS_PIDLABEL);
		//表单模式
		String pidmodel = (String) params.get(PARAMS_PIDMODE);
		//私有表单的权限范围
		String privatescope = (String) params.get(PARAMS_PRIVATESCOPE);
		//表单定义主键取得
		String pidid = (String) params.get(PARAMS_PIDID);
		//表单名称取得
		String property = (String) params.get(PARAMS_PROPERTY);
		//取得piid
		String piid = (String) params.get(PARAMS_PIID);
		//附件显示模式取得
		Integer pidrows = (Integer) params.get(PARAMS_PIDROWS);
		//标签生成字符串
		StringBuffer returnValue = new StringBuffer();
		//相关附件取得
		Map<String,List<Attachment>> textAreaMap = null;
		if(params.get(PARAMS_TEXTAREA_ATT_MAP)!=null){
			textAreaMap = (Map<String, List<Attachment>>) params.get(PARAMS_TEXTAREA_ATT_MAP);
		}
		String category = pidlabel;
		if(IGPRDCONSTANTS.PIDMODE_PRIVATE.equals(pidmodel)){
			//用户
			if(IGPRDCONSTANTS.PRIVATESCOPE_USER.equals(privatescope)){
				String userid = (String) params.get(PARAMS_USERID);
				category = pidlabel + "_" + userid;
			//角色
			}else if(IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equals(privatescope)){
				String roleid = (String) params.get(PARAMS_ROLEID);
				category = pidlabel + "_" + roleid;
			//机构
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
							//多附件的情况
							if(pidrows != null && pidrows > 1){
								returnValue.append(" onClick=\"delFile('").append(att.getAttid()) .append("','").append(piid) .append("');\" ");
							}else{
								returnValue.append(" onClick=\"singleFileDel('").append(att.getAttid()) .append("','").append(piid) .append("','").append(pidlabel).append("');\" ");
							}
						    returnValue.append(" border=\"0\" style=\"cursor: hand;\" alt=\"删除\"/>");
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
					//多附件的情况
					if(pidrows != null && pidrows > 1){
						returnValue.append(" onClick=\"delFile('").append(att.getAttid()) .append("','").append(piid) .append("');\" ");
					}else{
						returnValue.append(" onClick=\"singleFileDel('").append(att.getAttid()) .append("','").append(piid) .append("','").append(pidlabel).append("');\" ");
					}
				    returnValue.append(" border=\"0\" style=\"cursor: hand;\" alt=\"删除\"/>");
				}
			}
		}
		if(pidrows != null && pidrows > 1){
			returnValue.append("<img src=\"images/attachment.gif\" /><a href=\"javascript:addFileMuti('")
					   .append(pidlabel)
					   .append("');\" id=\"aAddAttachMuti\">添加附件</a>&nbsp;&nbsp;&nbsp;");
		}else if(flag){
			returnValue.append("<script>formFileArr[formFileArr.length] = '").append(pidlabel).append("';</script>");
		}
		returnValue.append("<table width=\"100%\" id=\"").append(pidlabel).append("\">");
		returnValue.append("</table>");
		returnValue.append("<input type=\"hidden\" id=\"pidid").append(pidid).append("\" name=\"").append(property).append("\" value=\"att\" />");
		return returnValue.toString();
	}
	
	/**
	 * 公有只读标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicReadableTag(Map<String, Object> params){
		return readableAttachmentInfoShow(params);
	}
	
	/**
	 * 表格类表单可写列生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	@SuppressWarnings("unchecked")
	public String generatedPublicWriteableTableColumn(Map<String, Object> params){
		StringBuffer tagString = new StringBuffer();
		//已有附件信息取得
		Map<String, List<Attachment>> tableAttMap = (Map<String, List<Attachment>>) params.get(PARAMS_TABLE_COLUMN_ATTACH_INFO);
		//附件显示模式取得
		Integer pidrows = (Integer) params.get(PARAMS_PIDROWS);
		//表单值取得
		String value = (String) params.get(PARAMS_VALUE);
		if(value == null || "null".equals(value)){
			value = "";
		}
		//表单定义主键取得
		String pidid = (String) params.get(PARAMS_PIDID);
		//行号取得
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		//宽度取得
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
						tagString.append(" border=\"0\" style=\"cursor: hand;\" alt=\"删除\"/>");
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
				tagString.append(" border=\"0\" style=\"cursor: hand;\" alt=\"删除\"/>");
			}
		}
		if(pidrows != null && pidrows > 1){
			tagString.append("<img src=\"images/attachment.gif\" /><a href=\"javascript:void(0);\" onclick=\"tableColumnAddAttach(this);\">添加附件</a>");
			tagString.append("<table name=\"column_attach\" class=\"tableColumnEntity\"></table>");
		}else{
			if(flag){
				tagString.append("<table name=\"column_attach\" class=\"tableColumnEntity\" ><tr><td>");
				tagString.append("<img src=\"images/attachment.gif\" /> ");
				tagString.append("<input type=\"text\" style=\"width:").append(width).append("px;\" readonly=\true\" class=\"tableColumnFile\" name=\"show_value\" />");
				tagString.append("<img src=\"images/file_del.png\" style=\"cursor: hand;\" alt=\"清空\" onclick=\"delSingleTableColumnFileInput(this);\"/>");
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
	 * 表格类表单只读列生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	@SuppressWarnings("unchecked")
	public String generatedPublicReadableTableColumn(Map<String, Object> params){
		StringBuffer tagString = new StringBuffer();
		//已有附件信息取得
		Map<String, List<Attachment>> tableAttMap = (Map<String, List<Attachment>>) params.get(PARAMS_TABLE_COLUMN_ATTACH_INFO);
		//表单值取得
		String value = (String) params.get(PARAMS_VALUE);
		if(value == null || "null".equals(value)){
			value = "";
		}
		//表单定义主键取得
		String pidid = (String) params.get(PARAMS_PIDID);
		//行号取得
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
    *流程关闭状态状态级表单显示
    * @param params 参数
    * @return 流程关闭状态状态级表单显示
    */
   public String generatedStatusCloseTag(Map<String, Object> params){
       //取得piid
       String pidid = (String) params.get(PARAMS_PIDID);
       //表单名称取得
       String property = (String) params.get(PARAMS_PROPERTY);
       //表单值取得
//	       String value = (String) params.get(PARAMS_VALUE);
       
       //关闭之后的状态级私有表单列表
       Map<String,List<IG561VWInfo>> statusclosedetails = (Map<String,List<IG561VWInfo>>) params.get(FormGeneratedTag.PARAMS_STATUS_CLOSE);
//       //相关附件取得
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
               //在此增加特殊处理逻辑 start
               //attkey
               String value=info.getPiattkey();
               
               //默认值特殊value
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
               //在此增加特殊处理逻辑 end
               tagString.append("</td>");
               tagString.append("</tr>");
           }
           tagString.append("</table>");
       }
       
       tagString.append("<input type=\"hidden\" id=\"pidid").append(pidid).append("\" name=\"").append(property).append("\" value=\"att\" />");
       return tagString.toString();
   }
	    	
}
