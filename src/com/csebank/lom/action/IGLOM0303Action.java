/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
	 * 借款处理
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
		// FORM取得
		IGLOM0303Form form = (IGLOM0303Form) actionForm;
		// BL取得
		IGLOM03BL ctlBL = (IGLOM03BL) getBean("iglom03BL");
		// DTO生成
		IGLOM03DTO dto = new IGLOM03DTO();
		
		if ("DISP".equals(mapping.getParameter())) {
			
			// 借款登记初期显示处理
			log.debug("========借款登记画面初期显示处理开始========");

			//借款日期默认当前日期
			form.setLpddate(IGStringUtils.getCurrentDate());
			if("0".equals(form.getMode())){
				form.setLpdid(null);
			}
			//获取可用金额
			ctlBL.searchAvailableAmountAction(dto);
			
			form.setAvailableAmount(dto.getAvailableAmount());
			
			addMessage(req, new ActionMessage("IGCO10000.I003", "借款申请信息"));
			
			log.debug("========借款登记画面初期显示处理终了========");
			
			saveToken(req);
			forward = "DISP";
			
		} else if( "INSERT".equals(mapping.getParameter())){
			
			if((form.getMode().equals("0"))){
				
				log.debug("========借款处理开始========");
				// DTO输入参数设定
				dto.setLoanPayDetail(form);
				dto.setIglom0303Form(form);

				if (isTokenValid(req, true)) {
					// 借款信息登记逻辑调用
					dto = ctlBL.insertLoanPayDetailAction(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				
				log.debug("========借款处理终了========");

				forward = "DISP";
				
			}else {
				
				//借款信息变更处理
				log.debug("========借款信息变更处理开始========");
				
				//DTO输入参数设定
				dto.setLoanPayDetail(form);
				dto.setIglom0303Form(form);
				
				//借款信息变更逻辑调用
//				dto = ctlBL.updateLoanPayDetailAction(dto);
				
				log.debug("========借款信息变更处理终了========");
				
				forward = "DISP1";

			}
		} else if ("EDIT".equals(mapping.getParameter())){
			
			log.debug("========借款信息变更初期显示处理开始========");
			
			form.setMode("1");
			
			dto.setIglom0303Form(form);
			dto = ctlBL.initLoanPayDetailAction(dto);
			
			log.debug("========借款信息变更初期显示处理终了========");
			
			forward = "DISP";
		
		}

		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}

		}

		return mapping.findForward(forward);
	}

}
