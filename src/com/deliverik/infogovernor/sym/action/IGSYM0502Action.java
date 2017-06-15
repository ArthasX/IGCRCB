/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.sym.bl.IGSYM05BL;
import com.deliverik.infogovernor.sym.dto.IGSYM05DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0502Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_通知管理_新增修改ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0502Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0502Action.class);
	
	/**
	 * <p>
	 * Description: 通知action处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		IGSYM0502Form form = (IGSYM0502Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			form.setNuserid(user.getUserid());
			form.setNusername(user.getUsername());
			form.setNorgid(user.getOrgid());
			form.setNorgname(user.getOrgname());
			form.setNtime(CommonDefineUtils.DATETIME_FORMAT.format(new Date()));
			log.debug("========通知新增画面初期显示处理开始========");
			addMessage(request, new ActionMessage("IGCO10000.I001","通知基本信息"));
			saveToken(request);
			log.debug("========通知新增画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		IGSYM05BL ctlBL = (IGSYM05BL) getBean("igsym05BL");
		IGSYM05DTO dto = new IGSYM05DTO();
		//通知新增
		if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				log.debug("========通知新增处理开始========");
				dto.setNotice(form);
				dto.setAttachFile(form);//设置form
				if (isTokenValid(request, true)){
					//调用BL新增
					dto = ctlBL.insertNoticeAction(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				List<ActionMessage> messageList = dto.getMessageList();
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(request, message);
					}
				}
				log.debug("========通知新增处理终了========");
				return mapping.findForward("DISP");
			} else {
				//信息变更
				log.debug("========通知变更处理开始========");
				dto.setNotice(form);
				dto.setAttachFile(form);//设置form
				
				//调用BL变更
				dto = ctlBL.updateNoticeAction(dto);
				List<ActionMessage> messageList = dto.getMessageList();
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(request, message);
					}
				}
				log.debug("========通知变更处理终了========");
				return mapping.findForward("DETAIL");
			}
		}
		//变更页面初始化
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========通知变更初期显示处理开始========");
			dto.setIgsym0502Form(form);
			dto = ctlBL.initIGSYM0502Action(dto);
			
			if (form.getNattkey()!=null &&!form.getNattkey().equals("")) {
				AttachmentBL attachmentBL=(AttachmentBL) getBean("attachmentBL");		
				List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(form.getNattkey());
				form.setAttachmentList(attachmentList);
			}
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			log.debug("========通知变更初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		//附件下载
		if ("LOADFILE".equals(mapping.getParameter())){
			log.debug("========通知附件下载处理开始========");
			String exattkey=request.getParameter("exattkey");
			String attId=request.getParameter("attid");	
			String type="sym";
			request.setAttribute("type", type);
			request.setAttribute("attId", attId);

			log.debug("========通知附件下载处理结束========");
			return mapping.findForward("LOADFILE");
		}
		
		return mapping.findForward("DISP");
	}
	
}
