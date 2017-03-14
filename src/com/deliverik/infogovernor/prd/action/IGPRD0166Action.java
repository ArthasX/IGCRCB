/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0166Form;

/**
 * ����: ����ʼ����������/�޸�Action
 * ��������: ����ʼ����������/�޸�Action
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
public class IGPRD0166Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0166Action.class);

	/**
	 * ����ʼ����������/�޸�Action
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORMȡ��
		IGPRD0166Form form = (IGPRD0166Form) actionForm;
		// BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		// DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		dto.setIgPRD0166Form(form);
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========����ʼ������������ʼ������ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========����ʼ������������ʼ���������========");
		} if ("INSERT".equals(mapping.getParameter())) {
			log.debug("========����ʼ��������������ʼ========");
			if (isTokenValid(req, true)){
				dto = ctlBL.insertIG373InfoAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����ʼ�����������������========");
		} else if ("INIT".equals(mapping.getParameter())) {
			log.debug("========����ʼ�������޸ĳ�ʼ������ʼ========");
			dto = ctlBL.initIG373InfoAction(dto);
			saveToken(req);
			log.debug("========����ʼ�������޸ĳ�ʼ���������========");
		} else if ("EDIT".equals(mapping.getParameter())) {
			log.debug("========����ʼ�������޸Ĵ���ʼ========");
			if (isTokenValid(req, true)){
				dto = ctlBL.editIG373InfoAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========����ʼ�������޸Ĵ������========");
		}
		// �߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
