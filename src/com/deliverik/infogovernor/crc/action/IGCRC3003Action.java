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
import com.deliverik.infogovernor.crc.form.IGCRC3003Form;

/**
 * 远程发起变更流程 上传附件和表单值跳转到流程待发起页面
 */
public class IGCRC3003Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC3003Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		IGCRC3003Form form = (IGCRC3003Form) actionForm;
//		form.setPlatformuserid("000124");
//		form.setTitle("变更发起测试");
//		form.setDesc("测试");
//		/** 计划执行开始时间 */
//		form.setBegintime("2016/03/30 15:46");
//		/** 变更类型 */
//		form.setTree("110003_tree_项目类");
//		/** 变更类别 */
//		form.setType1("常规变更");
//		/** 变更分类 */
//		form.setType2("新增需求");
//		/** 更新平台 */
//		form.setType3("测试");
//		/** 变更原因分类 */
//		form.setType4("其他");
//		/** 变更原因 */
//		form.setText1("测试变更原因");
//		/** 变更内容 */
//		form.setText2("测试变更内容");
//		/** 是否影响业务 */
//		form.setType5("否");;
//		/** 执行计划 */
//		form.setText3("测试执行计划");
//		/** 回退计划 */
//		form.setText4("测试回退计划");
//		/** 验证计划 */
//		form.setText5("测试验证计划");
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
			//计划执行开始时间 
			request.setAttribute("begintime", form.getBegintime());
			// 变更类型
			request.setAttribute("tree", form.getTree());
			//变更类别 
			request.setAttribute("type1", form.getType1());
			//变更分类 
			request.setAttribute("type2", form.getType2());
			//更新平台 
			request.setAttribute("type3", form.getType3());
			//变更原因分类 
			request.setAttribute("type4", form.getType4());
			//变更原因 
			request.setAttribute("text1", form.getText1());
			//变更内容 
			request.setAttribute("text2", form.getText2());
			//是否影响业务 
			request.setAttribute("type5", form.getType5());
			//执行计划 
			request.setAttribute("text3", form.getText3());
			//回退计划 
			request.setAttribute("text4", form.getText4());
			//验证计划 
			request.setAttribute("text5", form.getText5());
			
			//附件key
			request.setAttribute("attkey", attkey);
			//附件显示的串
			request.setAttribute("attstr", attstr.toString());
			
			//获取项目路径
			String requestURL = request.getRequestURL().toString();
			String path = requestURL.replace("/IGCRC3003.do", "");
			//保存路径
			request.setAttribute("path", path);
			
			return mapping.findForward("SUCCESS");
		}else{
			return mapping.findForward("DISP");
		}
	}

}
