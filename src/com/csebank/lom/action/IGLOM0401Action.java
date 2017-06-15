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

import com.csebank.lom.bl.IGLOM04BL;
import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.dto.IGLOM04DTO;
import com.csebank.lom.form.IGLOM0401Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;



/**
 * �Ӵ�����Action
 * 
 */
public class IGLOM0401Action extends BaseAction {
	
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
		IGLOM0401Form form = (IGLOM0401Form) actionForm;
		// BLȡ��
		IGLOM04BL lomBL = (IGLOM04BL) getBean("iglom04BL");
		// DTO����
		IGLOM04DTO dto = new IGLOM04DTO();
        //��Ʊ����		
		req.setAttribute("invoice_itype", LOMHelper.getItemsCodes(CodeUtils.INVOICE_ITYPE));
		//����״̬
		req.setAttribute("invoice_istatus", LOMHelper.getItemsCodes(CodeUtils.INVOICE_ISTATUS));
		//���ʽ
		req.setAttribute("invoice_ipaymenttype", LOMHelper.getItemsCodes(CodeUtils.INVOICE_IPAYMENTTYPE));
		
		if ("DISP".equals(mapping.getParameter())) {
			
			// �Ӵ��Ǽǳ�����ʾ����
			log.debug("========��Ʊ�Ǽǻ��������ʾ����ʼ========");
			//Ĭ�ϵǼ�ʱ��Ϊ��ǰʱ��
			String date = IGStringUtils.getCurrentDate();		
			form.setRdate(date);	
			addMessage(req, new ActionMessage("IGCO10000.I001", "��Ʊ������Ϣ"));
			log.debug("========��Ʊ�Ǽǻ��������ʾ��������========");
			saveToken(req);
			
			forward = "DISP";	
 		}
		if( "INSERT".equals(mapping.getParameter())){
			if((form.getMode().equals("0"))){
				// ���͵ǼǴ���
				log.debug("========��Ʊ����ʼ========");
				// DTO��������趨
				form.setIstatus(IGLOMCONSTANTS.INVOICE_TYPE_UNPLAY);
				dto.setInvoice(form);
				if (isTokenValid(req, true)) {
					// ������Ϣ�Ǽ��߼�����
					dto = lomBL.insertInvoiceAction(dto);
				} else {					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}				
				log.debug("========��Ʊ��������========");

				forward = "DISP";
				
			  }
			else {
				//��Ϣ���
				log.debug("========��Ʊ�������ʼ========");
				dto.setInvoice(form);
				//����BL���
				dto = lomBL.updateInvoiceAction(dto);
				log.debug("========��Ʊ�����������========");
				//return mapping.findForward("DETAIL");
				forward="DETAIL";
			}
		  }
				//���ҳ���ʼ��
		  if ("EDIT".equals(mapping.getParameter()))
		  {
				log.debug("========֪ͨ���������ʾ����ʼ========");
				dto.setIglom0401Form(form);
				dto = lomBL.initIGLOM0402Action(dto);
				log.debug("========֪ͨ���������ʾ��������========");
				forward="INIT_UPDATE";
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
