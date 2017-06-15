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

import com.csebank.lom.bl.IGLOM05BL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0501Form;
import com.deliverik.framework.base.BaseAction;



/**
 * �Ӵ�����Action
 * 
 */
public class IGLOM0501Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0501Action.class);
	
	String forward = "";

	/**
	 * ʳ�óɱ���Ϣ����
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
		IGLOM0501Form form = (IGLOM0501Form) actionForm;
		// BLȡ��
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		// DTO����
		IGLOM05DTO dto = new IGLOM05DTO();
		
		if ("DISP".equals(mapping.getParameter())) {
			
			// ʳ�óɱ��Ǽǳ�����ʾ����
			log.debug("========ʳ�óɱ��Ǽǻ��������ʾ����ʼ========");
			
			req.getSession().setAttribute("IGLOM0501Form", new IGLOM0501Form());
			addMessage(req, new ActionMessage("IGCO10000.I001", "ʳ�óɱ���Ϣ"));
			
			log.debug("========ʳ�óɱ���Ϣ�Ǽǻ��������ʾ��������========");
			saveToken(req);
			
			forward = "DISP";
			
		} else if( "INSERT".equals(mapping.getParameter())){
			if((form.getMode().equals("0"))){
				// ���͵ǼǴ���
				log.debug("========ʳ�óɱ���Ϣ�ǼǴ���ʼ========");
				// DTO��������趨
				dto.setEatery(form);
				dto.setIglom0501Form(form);

				if (isTokenValid(req, true)) {
					// ������Ϣ�Ǽ��߼�����
					dto = ctlBL.insertEateryAction(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				
				log.debug("========ʳ�óɱ���Ϣ�ǼǴ�������========");

				forward = "DISP";
				
			}else {
				//�Ӵ���Ϣ�������
				log.debug("========ʳ�óɱ���Ϣ�������ʼ========");
				
				//DTO��������趨
				dto.setEatery(form);
				dto.setIglom0501Form(form);
				
				//�Ӵ���Ϣ����߼�����
				dto = ctlBL.updateEateryAction(dto);
				
				log.debug("========ʳ�óɱ���Ϣ�����������========");
				
				return mapping.findForward("DETAIL");

			}
		}	else if ("EDIT".equals(mapping.getParameter())){
			
			log.debug("========ʳ�óɱ�����������ʼ========");
			
			//DTO��������趨
			dto.setIglom0501Form(form);
			
			dto = ctlBL.initEateryAction(dto);
			
			log.debug("========ʳ�óɱ�������������ʾ��������========");
			return mapping.findForward("DISP");
			
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
