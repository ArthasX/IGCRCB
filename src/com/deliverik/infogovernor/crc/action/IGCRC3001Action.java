package com.deliverik.infogovernor.crc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.crc.form.IGCRC3001Form;

/**
 * 远程发起科技服务请求流程 上传附件和表单值跳转到流程待发起页面
 */
public class IGCRC3001Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC3001Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		IGCRC3001Form form = (IGCRC3001Form) actionForm;
//		form.setPlatformuserid("000124");
//		form.setTitle("系统安全基线检查不合规整改");
//		form.setDesc("linux_node116勿动,Windows_wx");
//		form.setTree("114006003_tree_安全策略-安全基线检查变更");
//		form.setType1("否");
//		form.setType2("中");
//		form.setType3("高");
		//附件key
		String attkey = "";
		//附件id
		StringBuffer attstr = new StringBuffer("");
		if("DISP".equals(mapping.getParameter())){
			
			if(form.getFileMap() != null && form.getFileMap().size() > 0){
				
				FileUploadBL fileUploadBL = (FileUploadBL) getBean("fileUploadBL");
				AttachmentBL attachmentBL = (AttachmentBL) getBean("attachmentBL");
				
				//获取上传之后的key
				attkey = fileUploadBL.uploadFile(form.getFileMap());
				List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(attkey);
				if(attachmentList != null && attachmentList.size() > 0){
					//附件id
					for (int i = 0; i < attachmentList.size(); i++) {
						if(i != attachmentList.size() - 1){
							attstr.append(attachmentList.get(i).getAttid());
							attstr.append("*_*");
						}else{
							attstr.append(attachmentList.get(i).getAttid());
						}
						
					}
					attstr.append("*-*");
					//附件名称
					for (int i = 0; i < attachmentList.size(); i++) {
						if(i != attachmentList.size() - 1){
							attstr.append(attachmentList.get(i).getAttname().split(attachmentList.get(i).getAttkey()+"_")[1]);
							attstr.append("*_*");
						}else{
							attstr.append(attachmentList.get(i).getAttname().split(attachmentList.get(i).getAttkey()+"_")[1]);
						}
						
					}
				}
				
			}
			
			//用户id
			request.setAttribute("platformuserid", form.getPlatformuserid());
			//服务请求名称
			request.setAttribute("ptitle", form.getTitle());
			//服务请求描述
			request.setAttribute("pdesc", form.getDesc());
			//服务请求分类
			request.setAttribute("tree", form.getTree());
			//是否为生产数据导出申请
			request.setAttribute("type1", form.getType1());
			//影响程度
			request.setAttribute("type2", form.getType2());
			//紧急程度
			request.setAttribute("type3", form.getType3());
			//附件key
			request.setAttribute("attkey", attkey);
			//附件显示的串
			request.setAttribute("attstr", attstr.toString());
			
			//获取项目路径
			String requestURL = request.getRequestURL().toString();
			String path = requestURL.replace("/IGCRC3001.do", "");
			//保存路径
			request.setAttribute("path", path);
			
			return mapping.findForward("SUCCESS");
		}else{
			return mapping.findForward("DISP");
		}
	}

}
