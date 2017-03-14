/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM03BL;
import com.csebank.lom.dto.IGLOM03DTO;
import com.csebank.lom.form.IGLOM0301Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;

/**
 * Ԥ֧����Action
 * 
 */

public class IGLOM0301Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0301Action.class);
	
	/**
	 * <p>
	 * Description: Ԥ֧��������action����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGLOM0301Form form = (IGLOM0301Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========Ԥ֧�����������������ʾ����ʼ========");
			request.getSession().setAttribute("AD_advancescost_actype", LOMHelper.getItemsCodes(CodeUtils.ADVANCESCOST_ACTYPE));
			addMessage(request, new ActionMessage("IGCO10000.I001","Ԥ֧���û�����Ϣ"));
			saveToken(request);
			log.debug("========Ԥ֧�����������������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//��ȡBL�ӿ�ʵ��
		IGLOM03BL ctlBL = (IGLOM03BL) getBean("iglom03BL");
		//ʵ����DTO
		IGLOM03DTO dto = new IGLOM03DTO();
		String forward = "DISP";
		//Ԥ֧��������
		if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				log.debug("========Ԥ֧������������ʼ========");
				User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				form.setAcuserid(user.getUserid());
				form.setAcusername(user.getUsername());
				
				dto.setIglom0301Form(form);
				if (isTokenValid(request, true)) {
					//����BL����
					dto = ctlBL.insertAdvanCescostAction(dto);
				} else {
					
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========Ԥ֧����������������========");
			} else {
				//��Ϣ���
				log.debug("========Ԥ֧���ñ������ʼ========");
				dto.setIglom0301Form(form);
				
				if (isTokenValid(request, true)) {
					//����BL���
					dto = ctlBL.updateAdvanCescostAction(dto);
				} else {
					
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========Ԥ֧���ñ����������========");
			}
		}
		//Ԥ֧���ñ��ҳ���ʼ��
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========Ԥ֧���ñ��������ʾ����ʼ========");
			dto.setIglom0301Form(form);
			dto = ctlBL.initAdvanCescostAction(dto);
			request.getSession().setAttribute("AD_advancescost_actype", LOMHelper.getItemsCodes(CodeUtils.ADVANCESCOST_ACTYPE));
			log.debug("========Ԥ֧���ñ��������ʾ��������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}
	
}
