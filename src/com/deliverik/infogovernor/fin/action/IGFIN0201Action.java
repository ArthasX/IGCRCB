/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.fin.action;

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
import com.deliverik.infogovernor.fin.bl.IGFIN02BL;
import com.deliverik.infogovernor.fin.dto.IGFIN02DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0201Form;

/**
 * ���õǼǻ���Action����
 * 
 */
public class IGFIN0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGFIN0201Action.class);

	/**
	 * �¼�����
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		IGFIN0201Form form = (IGFIN0201Form) actionForm;
		// BLȡ��
		IGFIN02BL ctlBL = (IGFIN02BL) getBean("igfin02BL");
		// DTO����
		IGFIN02DTO dto = new IGFIN02DTO();
		if ("DISP".equals(mapping.getParameter())) {
			// ���õǼǻ��������ʾ����
			log.debug("========���õǼǻ��������ʾ����ʼ========");
			req.setAttribute("IGFIN0201Form", form);
			addMessage(req, new ActionMessage("IGCO10000.I001", "������Ϣ"));
			saveToken(req);
			log.debug("========���õǼǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} else if ("REDISP".equals(mapping.getParameter())) {
			// ���õǼǻ�������ʾ����
			log.debug("========���õǼǻ�������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========���õǼǻ�������ʾ��������========");
			return mapping.findForward("DISP");
		}

		if ("INSERT".equals(mapping.getParameter())) {
			// ���ñ༭����
			if (isCancelled(req) || (req.getParameter("btn_back") != null)) {
				// ���ñ༭���水�·��ذ�ťʱ�ķ��ش���
				if (form.getRoute().equals("0")) {
					// ���ط��õǼǻ���
					return mapping.findForward("BACK1");
				} else {
					// ���ط�����ϸ ����
					return mapping.findForward("BACK2");
				}
			}
			if (form.getExstatus().equals("O")) {
				// ���õǼǴ���
				log.debug("========���õǼǴ���ʼ========");
				// DTO��������趨
				dto.setExpense(form);
				dto.setAttachFile(form);
				if (isTokenValid(req, true)) {
					// ���õǼ��߼�����
					dto = ctlBL.insertExpenseTBDAOAction(dto);
				} else {
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				if (null == dto) {
					addMessage(req, new ActionMessage("IGCO10000.E004", "Ԥ��"));
					return mapping.findForward("ERROR");
				}
				log.debug("========���õǼǴ�������========");
			}
		}
		if ("UPDATE".equals(mapping.getParameter())) {
			// ���ñ������
			log.debug("========���ñ������ʼ========");
			// DTO��������趨
			form.setBid(Integer.valueOf(req.getParameter("id")));
			dto.setBid(Integer.valueOf(req.getParameter("id")));
			form.setBtype(dto.getBudget().getBtype());
			form.setBopentime(dto.getBudget().getBopentime());
			form.setBtitle(dto.getBudget().getBtitle());
			form.setBclosetime(dto.getBudget().getBclosetime());
			form.setBdesc(dto.getBudget().getBdesc());
			form.setByear(dto.getBudget().getByear());
			form.setBreqname(dto.getBudget().getBreqname());
			form.setBamount(dto.getBudget().getBamount());
			String bstatus = "C";
			form.setBstatus(bstatus);
			dto.setBudget(form);
			// ���ñ���߼�����
			log.debug("========���ñ����������========");

		}

		if ("DELETE".equals(mapping.getParameter())) {
			// ����ɾ������
			log.debug("========����ɾ������ʼ========");
			// DTO��������趨
			form.setExid(Integer.valueOf(req.getParameter("id")));
			dto.setDeleteExpense(form.getExid());
			// ������Ϣɾ���߼�����
			ctlBL.deleteExpenseAction(dto);
			log.debug("========����ɾ����������========");
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