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

import com.csebank.lom.bl.IGLOM01BL;
import com.csebank.lom.dto.IGLOM01DTO;
import com.csebank.lom.form.IGLOM0101Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.deliverik.framework.base.BaseAction;



/**
 * �Ӵ�����Action
 * 
 */
public class IGLOM0101Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0101Action.class);
	
	String forward = "";

	/**
	 * �Ӵ�����
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
		IGLOM0101Form form = (IGLOM0101Form) actionForm;
		// BLȡ��
		IGLOM01BL ctlBL = (IGLOM01BL) getBean("iglom01BL");
		// DTO����
		IGLOM01DTO dto = new IGLOM01DTO();
		// �����˵�
		req.setAttribute("recption_rscale", LOMHelper.getItemsCodes(CodeUtils.RECPTION_RSCALE));
		req.setAttribute("recption_status", LOMHelper.getItemsCodes(CodeUtils.RECPTION_STATUS));
		req.setAttribute("recption_rstandard", LOMHelper.getItemsCodes(CodeUtils.RECPTION_RSTANDARD));
		req.setAttribute("lodge_standard", LOMHelper.getItemsCodes(CodeUtils.LODGE_STANDARD));
		
		if ("DISP".equals(mapping.getParameter())) {
			
			// �Ӵ��Ǽǳ�����ʾ����
			log.debug("========�Ӵ��Ǽǻ��������ʾ����ʼ========");

			addMessage(req, new ActionMessage("IGCO10000.I001", "�Ӵ�������Ϣ"));
			
			log.debug("========�Ӵ��Ǽǻ��������ʾ��������========");
			saveToken(req);
			
			forward = "DISP";
			
		} else if("REDISP".equals(mapping.getParameter())){
			
			//�Ӵ��Ǽǻ�������ʾ����
			log.debug("========�Ӵ��Ǽǻ�������ʾ����ʼ========");
			
			dto.setIglom0101Form(form);
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			
			log.debug("========�Ӵ��Ǽǻ�������ʾ��������========");
			
			forward = "DISP";
			
		}else
		
		
		if( "INSERT".equals(mapping.getParameter())){
			if((form.getMode().equals("0"))){
				// ���͵ǼǴ���
				log.debug("========�Ӵ�����ʼ========");
				// DTO��������趨
				dto.setRecption(form);
				dto.setIglom0101Form(form);
               //strutsͬ�����ƻ��ƣ���ֹ�ظ��ύ
				if (isTokenValid(req, true)) {
					dto = ctlBL.insertRecptionAction(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				
				log.debug("========�Ӵ���������========");

				forward = "DISP";
				
			}else {
				//�Ӵ���Ϣ�������
				log.debug("========�Ӵ���Ϣ�������ʼ========");
				
				//DTO��������趨
				dto.setRecption(form);
				dto.setIglom0101Form(form);

				if (isTokenValid(req, true)) {
					
					//�Ӵ���Ϣ����߼�����
					dto = ctlBL.updateRecptionAction(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				log.debug("========�Ӵ���Ϣ�����������========");
				
				forward = "DISP1";

			}
		}
		//���ҳ���ʼ��
		if("EDIT".equals(mapping.getParameter())){
			
			log.debug("========�Ӵ���Ϣ���������ʾ����ʼ========");
			form.setMode("1");
			
			dto.setIglom0101Form(form);

			dto = ctlBL.initRecption(dto);
			forward = "DISP";
			log.debug("========�Ӵ���Ϣ���������ʾ��������========");
		
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
