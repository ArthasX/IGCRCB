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
import com.csebank.lom.form.IGLOM0518Form;
import com.csebank.lom.util.CodeUtils;
import com.deliverik.framework.base.BaseAction;



/**
 * �Ϳ�����Action
 * 
 */
public class IGLOM0518Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0518Action.class);
	
	String forward = "";

	/**
	 * �Ϳ���Ϣ����
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
		IGLOM0518Form form = (IGLOM0518Form) actionForm;
		// BLȡ��
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		// DTO����
		IGLOM05DTO dto = new IGLOM05DTO();
		
		if ("DISP".equals(mapping.getParameter())) {
			
			log.debug("========�Ϳ��Ǽǻ��������ʾ����ʼ========");
			
			req.getSession().setAttribute("IGLOM0518Form", new IGLOM0518Form());
			addMessage(req, new ActionMessage("IGCO10000.I001", "�Ϳ���Ϣ"));
			
			log.debug("========�Ϳ��Ǽǻ��������ʾ��������========");
			saveToken(req);
			
			forward = "DISP";
			
		} else if( "INSERT".equals(mapping.getParameter())){
			if((form.getMode().equals("0"))){
				// �Ϳ��ǼǴ���
				log.debug("========�Ϳ���Ϣ�ǼǴ���ʼ========");
				// DTO��������趨
				
				//�Ϳ�����
				form.setSelectid(CodeUtils.CARD_CATEGORY);
				//�Ϳ���ֵ
				form.setType(form.getPrince());
				//����ֵ
				form.setTypecode(form.getAllowance());
				//����״̬
				form.setDesc("1");
				
				dto.setItemsCodes(form);
				dto.setIglom0518Form(form);
				if (isTokenValid(req, true)) {
					dto = ctlBL.insertLunchCardAction(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				
				log.debug("========�Ϳ���Ϣ�ǼǴ�������========");

				forward = "DISP";
				
			}else {
				//�Ӵ���Ϣ�������
				log.debug("========ʳ�óɱ���Ϣ�������ʼ========");
				
				//DTO��������趨
				dto.setItemsCodes(form);
				dto.setIglom0518Form(form);
				form.setType(form.getPrince());
				form.setTypecode(form.getAllowance());
				//�Ӵ���Ϣ����߼�����
				dto = ctlBL.updateLunchCardAction(dto);
				
				log.debug("========ʳ�óɱ���Ϣ�����������========");
				
				return mapping.findForward("DETAIL");

			}
		}	else if ("EDIT".equals(mapping.getParameter())){
			
			log.debug("========�Ϳ�����������ʼ========");
			
			//DTO��������趨
			dto.setIglom0518Form(form);
			
			dto = ctlBL.initLunchCardAction(dto);
			
			log.debug("========�Ϳ�������������ʾ��������========");
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
