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
import com.csebank.lom.form.IGLOM0506Form;
import com.deliverik.framework.base.BaseAction;



/**
 * �Ӵ�����Action
 * 
 */
public class IGLOM0506Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0506Action.class);
	
	String forward = "";

	/**
	 * ʳ�ýӴ���Ϣ����
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
		IGLOM0506Form form = (IGLOM0506Form) actionForm;
		// BLȡ��
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		// DTO����
		IGLOM05DTO dto = new IGLOM05DTO();
		
		if ("DISP".equals(mapping.getParameter())) {
			
			// ʳ�ýӴ��Ǽǳ�����ʾ����
			log.debug("========ʳ�ýӴ��Ǽǻ��������ʾ����ʼ========");

			addMessage(req, new ActionMessage("IGCO10000.I001", "ʳ�ýӴ���Ϣ"));
			
			log.debug("========ʳ�ýӴ���Ϣ�Ǽǻ��������ʾ��������========");
			saveToken(req);
			
			forward = "DISP";
			
		} else if( "INSERT".equals(mapping.getParameter())){
			if((form.getMode().equals("0"))){
				
				log.debug("========ʳ�ýӴ���Ϣ�ǼǴ���ʼ========");
				// DTO��������趨
				dto.setEentertainment(form);
				dto.setIglom0506Form(form);

				if (isTokenValid(req, true)) {
					// ʳ�ýӴ���Ϣ�Ǽ��߼�����
					dto = ctlBL.insertEentertainmentAction(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				
				log.debug("========ʳ�ýӴ���Ϣ�ǼǴ�������========");

				forward = "DISP";
				
			}else {
				//ʳ�ýӴ���Ϣ�������
				log.debug("========ʳ�ýӴ���Ϣ�������ʼ========");
				
				//DTO��������趨
				dto.setEentertainment(form);
				dto.setIglom0506Form(form);
				
				//ʳ�ýӴ���Ϣ����߼�����
				dto = ctlBL.updateEentertainmentAction(dto);
				
				log.debug("========ʳ�ýӴ���Ϣ�����������========");
				
				return mapping.findForward("DETAIL");

			}
		}	else if ("EDIT".equals(mapping.getParameter())){
			
			log.debug("========ʳ�ýӴ�����������ʼ========");
			
			//DTO��������趨
			dto.setIglom0506Form(form);
			
			dto = ctlBL.initEentertainmentAction(dto);
			
			log.debug("========ʳ�ýӴ�������������ʾ��������========");
			return mapping.findForward("DISP");
			
		}//ɾ��
		else if ("DELETE".equals(mapping.getParameter())){
			log.debug("========֪ͨɾ������ʼ========");
			dto.setDeleteEeid(form.getDeleteEeid());
			ctlBL.deleteEentertainmentAction(dto);
			forward = "DISP";
			log.debug("========֪ͨɾ����������========");
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
