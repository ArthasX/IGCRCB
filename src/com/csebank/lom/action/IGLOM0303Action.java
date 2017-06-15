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
import com.csebank.lom.form.IGLOM0303Form;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;

public class IGLOM0303Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0303Action.class);
	
	String forward = "";

	/**
	 * ����
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORMȡ��
		IGLOM0303Form form = (IGLOM0303Form) actionForm;
		// BLȡ��
		IGLOM03BL ctlBL = (IGLOM03BL) getBean("iglom03BL");
		// DTO����
		IGLOM03DTO dto = new IGLOM03DTO();
		
		if ("DISP".equals(mapping.getParameter())) {
			
			// ���Ǽǳ�����ʾ����
			log.debug("========���Ǽǻ��������ʾ����ʼ========");

			//�������Ĭ�ϵ�ǰ����
			form.setLpddate(IGStringUtils.getCurrentDate());
			if("0".equals(form.getMode())){
				form.setLpdid(null);
			}
			//��ȡ���ý��
			ctlBL.searchAvailableAmountAction(dto);
			
			form.setAvailableAmount(dto.getAvailableAmount());
			
			addMessage(req, new ActionMessage("IGCO10000.I003", "���������Ϣ"));
			
			log.debug("========���Ǽǻ��������ʾ��������========");
			
			saveToken(req);
			forward = "DISP";
			
		} else if( "INSERT".equals(mapping.getParameter())){
			
			if((form.getMode().equals("0"))){
				
				log.debug("========����ʼ========");
				// DTO��������趨
				dto.setLoanPayDetail(form);
				dto.setIglom0303Form(form);

				if (isTokenValid(req, true)) {
					// �����Ϣ�Ǽ��߼�����
					dto = ctlBL.insertLoanPayDetailAction(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				
				log.debug("========��������========");

				forward = "DISP";
				
			}else {
				
				//�����Ϣ�������
				log.debug("========�����Ϣ�������ʼ========");
				
				//DTO��������趨
				dto.setLoanPayDetail(form);
				dto.setIglom0303Form(form);
				
				//�����Ϣ����߼�����
//				dto = ctlBL.updateLoanPayDetailAction(dto);
				
				log.debug("========�����Ϣ�����������========");
				
				forward = "DISP1";

			}
		} else if ("EDIT".equals(mapping.getParameter())){
			
			log.debug("========�����Ϣ���������ʾ����ʼ========");
			
			form.setMode("1");
			
			dto.setIglom0303Form(form);
			dto = ctlBL.initLoanPayDetailAction(dto);
			
			log.debug("========�����Ϣ���������ʾ��������========");
			
			forward = "DISP";
		
		}

		// �߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}

		}

		return mapping.findForward(forward);
	}

}
