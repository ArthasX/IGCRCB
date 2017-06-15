/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM14BL;
import com.deliverik.infogovernor.drm.dto.IGDRM14DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1402Form;

/**
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * Description: ϵͳ����_֪ͨ����_�����޸�ACTION
 * 
 */

public class IGDRM1402Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGDRM1402Action.class);
	
	/**
	 * Description: ֪ͨaction����
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		IGDRM1402Form form = (IGDRM1402Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			form.setNuserid(user.getUserid());
			form.setNusername(user.getUsername());
			form.setNorgid(user.getOrgid());
			form.setNorgname(user.getOrgname());
			form.setNtime(CommonDefineUtils.DATETIME_SECOND_FORMAT.format(new Date()).substring(0,16));
			log.debug("========֪ͨ�������������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I001","֪ͨ������Ϣ"));
			saveToken(request);
			log.debug("========֪ͨ�������������ʾ��������========");
			return mapping.findForward("DISP");
		}
		IGDRM14BL ctlBL = (IGDRM14BL) getBean("igdrm14BL");
		IGDRM14DTO dto = new IGDRM14DTO();
		//֪ͨ����
		if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				log.debug("========֪ͨ��������ʼ========");
				dto.setNotice(form);
				dto.setAttachFile(form);//����form
				if (isTokenValid(request, true)){
					//����BL����
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
				log.debug("========֪ͨ������������========");
				return mapping.findForward("DISP");
			} else {
				//��Ϣ���
				log.debug("========֪ͨ�������ʼ========");
				dto.setNotice(form);
				dto.setAttachFile(form);//����form
				
				//����BL���
				dto = ctlBL.updateNoticeAction(dto);
				List<ActionMessage> messageList = dto.getMessageList();
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(request, message);
					}
				}
				log.debug("========֪ͨ�����������========");
				return mapping.findForward("DETAIL");
			}
		}
		//���ҳ���ʼ��
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========֪ͨ���������ʾ����ʼ========");
			dto.setIgdrm1402Form(form);
			dto = ctlBL.initIGDRM1402Action(dto);
			
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
			log.debug("========֪ͨ���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		//��������
		if ("LOADFILE".equals(mapping.getParameter())){
			log.debug("========֪ͨ�������ش���ʼ========");
			String attId=request.getParameter("attid");	
			String type="sym";
			request.setAttribute("type", type);
			request.setAttribute("attId", attId);

			log.debug("========֪ͨ�������ش������========");
			return mapping.findForward("LOADFILE");
		}
		
		return mapping.findForward("DISP");
	}
	
}
