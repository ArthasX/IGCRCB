/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.risk.bl.IGRIS01BL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0114Form;

/**
 * �������������ϢAction����
 *
 */
public class IGRIS0114Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0114Action.class);

	/**
	 * �ɹ�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ʵ����FORM
		IGRIS0114Form form = (IGRIS0114Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		//ʵ����DTO
		IGRIS01DTO dto = new IGRIS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========����������������ʾ����ʼ========");
			dto.setIgRIS0114Form(form);
			ctlBL.initRiskAuditResultAction(dto);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����������������ʾ��������========");
			return mapping.findForward("DISP");
		} 
		if( "UPDATE".equals(mapping.getParameter())){
			log.debug("========���������������ʼ========");
			dto.setUser(user);
			dto.setIgRIS0114Form(form);				
			//����BL����
			dto = ctlBL.updateRiskAuditResultAction(dto);
			log.debug("========�������������������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
