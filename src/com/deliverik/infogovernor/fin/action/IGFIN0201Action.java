/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
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
 * 费用登记画面Action处理
 * 
 */
public class IGFIN0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGFIN0201Action.class);

	/**
	 * 事件处理
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
		// BL取得
		IGFIN02BL ctlBL = (IGFIN02BL) getBean("igfin02BL");
		// DTO生成
		IGFIN02DTO dto = new IGFIN02DTO();
		if ("DISP".equals(mapping.getParameter())) {
			// 费用登记画面初期显示处理
			log.debug("========费用登记画面初期显示处理开始========");
			req.setAttribute("IGFIN0201Form", form);
			addMessage(req, new ActionMessage("IGCO10000.I001", "费用信息"));
			saveToken(req);
			log.debug("========费用登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if ("REDISP".equals(mapping.getParameter())) {
			// 费用登记画面再显示处理
			log.debug("========费用登记画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========费用登记画面再显示处理终了========");
			return mapping.findForward("DISP");
		}

		if ("INSERT".equals(mapping.getParameter())) {
			// 费用编辑处理
			if (isCancelled(req) || (req.getParameter("btn_back") != null)) {
				// 费用编辑画面按下返回按钮时的返回处理
				if (form.getRoute().equals("0")) {
					// 返回费用登记画面
					return mapping.findForward("BACK1");
				} else {
					// 返回费用详细 画面
					return mapping.findForward("BACK2");
				}
			}
			if (form.getExstatus().equals("O")) {
				// 费用登记处理
				log.debug("========费用登记处理开始========");
				// DTO输入参数设定
				dto.setExpense(form);
				dto.setAttachFile(form);
				if (isTokenValid(req, true)) {
					// 费用登记逻辑调用
					dto = ctlBL.insertExpenseTBDAOAction(dto);
				} else {
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				if (null == dto) {
					addMessage(req, new ActionMessage("IGCO10000.E004", "预算"));
					return mapping.findForward("ERROR");
				}
				log.debug("========费用登记处理终了========");
			}
		}
		if ("UPDATE".equals(mapping.getParameter())) {
			// 费用变更处理
			log.debug("========费用变更处理开始========");
			// DTO输入参数设定
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
			// 费用变更逻辑调用
			log.debug("========费用变更处理终了========");

		}

		if ("DELETE".equals(mapping.getParameter())) {
			// 费用删除处理
			log.debug("========费用删除处理开始========");
			// DTO输入参数设定
			form.setExid(Integer.valueOf(req.getParameter("id")));
			dto.setDeleteExpense(form.getExid());
			// 费用信息删除逻辑调用
			ctlBL.deleteExpenseAction(dto);
			log.debug("========费用删除处理终了========");
		}
		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}