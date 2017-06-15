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
import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.dto.IGLOM03DTO;
import com.csebank.lom.form.IGLOM0313Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM03131VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;

public class IGLOM0313Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0313Action.class);
	
	String forward = "";

	/**
	 * �����
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
		IGLOM0313Form form = (IGLOM0313Form) actionForm;
		// BLȡ��
		IGLOM03BL ctlBL = (IGLOM03BL) getBean("iglom03BL");
		// DTO����
		IGLOM03DTO dto = new IGLOM03DTO();
		//�����˵�
		req.getSession().setAttribute("ADloanpaydetail_lpdtype", LOMHelper.getItemsCodes(CodeUtils.LOANPAYDETAIL_LPDTYPE));
		
		if ("DISP".equals(mapping.getParameter())) {
			
			// ����Ǽǳ�����ʾ����
			log.debug("========����Ǽǻ��������ʾ����ʼ========");

			//��������Ĭ�ϵ�ǰ����
			form.setLpddate(IGStringUtils.getCurrentDate());
			
			addMessage(req, new ActionMessage("IGCO10000.I003", "������Ϣ"));
			
			log.debug("========����Ǽǻ��������ʾ��������========");
			
			saveToken(req);
			forward = "DISP";
			
		} else if ("CHANGE".equals(mapping.getParameter())){
			
			log.debug("========���ȷ�ϴ���ʼ========");
			//DTO��������趨
			dto.setIglom0313Form(form);

			if (isTokenValid(req, true)) {
				ctlBL.changeLoanPayInvoiceAction(dto);
			} else {
				
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			
			log.debug("========���ȷ�ϴ�������========");
			
			forward = "CHANGE";
			
		} else if ("DELETE".equals(mapping.getParameter())){
			
			log.debug("========���ɾ������ʼ========");
			//DTO��������趨
			dto.setIglom0313Form(form);
			
			if (isTokenValid(req, true)) {
				ctlBL.deleteLoanPayInvoiceAction(dto);
			} else {
				
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========���ɾ����������========");
			
			forward = "DELETE";
			
		} else if( "INSERT".equals(mapping.getParameter())){
			
			log.debug("========�����ʼ========");
			// DTO��������趨
			dto.setLoanPayDetail(form);
			dto.setIglom0313Form(form);

			if (isTokenValid(req, true)) {
				// ������Ϣ�Ǽ��߼�����
				dto = ctlBL.insertPayInvioceAction(dto);
				form.setLpdinvoiceamount(null);
				form.setLpdinvoicecomment(null);
				form.setLpdinvoicecor(null);
				form.setLpdinvoicedate(null);
				form.setLpdinvoicenum(null);
				form.setLpdactinvoice(null);
				form.setLpdactuser(null);
				form.setLpdtype(null);
				form.setLpdamount(null);
				form.setLpddate(null);
				
				req.getSession().setAttribute("IGLOM0313Form",form);
			} else {
				
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			
			log.debug("========���������========");

			forward = "DISP";
				
			
		} else if( "SEARCH".equals(mapping.getParameter())){
			//�����ѯ����
			log.debug("========�����ѯ����ʼ========");
			

			form = (IGLOM0313Form) req.getSession().getAttribute("IGLOM0313Form");
			
			//DTO��������趨
//			dto.setLoanPayDetailSearchCond(null);
			
			dto.setIglom0313Form(form);
			//������Ϣ�����߼�����
			dto = ctlBL.searchLoanPayInvoiceAction(dto);
			

			//��������Ĭ�ϵ�ǰ����
			form.setLpddate(IGStringUtils.getCurrentDate());
			//������Ϊ�����
			form.setLpdactuser(dto.getLoanPayDetailData().getLpduser());
			form.setLpduser(dto.getLoanPayDetailData().getLpduser());
			//Ĭ�Ϸ�Ʊ����
			form.setLpdtype(IGLOMCONSTANTS.LPD_TYPE_PAY_INVOICE);
			
			//��������Ϣ��������趨��VO��
			IGLOM03131VO vo = new IGLOM03131VO();
			vo.setLoanPayDetailList(dto.getLoanPayDetailList());
			vo.setLoanPayDetailData(dto.getLoanPayDetailData());
			vo.setDb(dto.getDb());
			super.<IGLOM03131VO>setVO(req.getSession(), vo);
			
			saveToken(req);
			
			log.debug("========�����ѯ��������========");
			
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
