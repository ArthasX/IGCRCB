/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_֪ͨ����_�����޸�ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0502Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0502Action.class);
	
	/**
	 * <p>
	 * Description: ֪ͨaction����
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
			log.debug("========֪ͨ�������������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I001","֪ͨ������Ϣ"));
			saveToken(request);
			log.debug("========֪ͨ�������������ʾ��������========");
			return mapping.findForward("DISP");
		}
		IGSYM05BL ctlBL = (IGSYM05BL) getBean("igsym05BL");
		IGSYM05DTO dto = new IGSYM05DTO();
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
			log.debug("========֪ͨ���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		//��������
		if ("LOADFILE".equals(mapping.getParameter())){
			log.debug("========֪ͨ�������ش���ʼ========");
			String exattkey=request.getParameter("exattkey");
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
