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

import com.csebank.lom.bl.IGLOM04BL;
import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.dto.IGLOM04DTO;
import com.csebank.lom.form.IGLOM0401Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;



/**
 * 接待处理Action
 * 
 */
public class IGLOM0401Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0101Action.class);
	
	String forward = "";

	/**
	 * 接待处理
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
		IGLOM0401Form form = (IGLOM0401Form) actionForm;
		// BL取得
		IGLOM04BL lomBL = (IGLOM04BL) getBean("iglom04BL");
		// DTO生成
		IGLOM04DTO dto = new IGLOM04DTO();
        //发票类型		
		req.setAttribute("invoice_itype", LOMHelper.getItemsCodes(CodeUtils.INVOICE_ITYPE));
		//付款状态
		req.setAttribute("invoice_istatus", LOMHelper.getItemsCodes(CodeUtils.INVOICE_ISTATUS));
		//付款方式
		req.setAttribute("invoice_ipaymenttype", LOMHelper.getItemsCodes(CodeUtils.INVOICE_IPAYMENTTYPE));
		
		if ("DISP".equals(mapping.getParameter())) {
			
			// 接待登记初期显示处理
			log.debug("========发票登记画面初期显示处理开始========");
			//默认登记时间为当前时间
			String date = IGStringUtils.getCurrentDate();		
			form.setRdate(date);	
			addMessage(req, new ActionMessage("IGCO10000.I001", "发票基本信息"));
			log.debug("========发票登记画面初期显示处理终了========");
			saveToken(req);
			
			forward = "DISP";	
 		}
		if( "INSERT".equals(mapping.getParameter())){
			if((form.getMode().equals("0"))){
				// 类型登记处理
				log.debug("========发票处理开始========");
				// DTO输入参数设定
				form.setIstatus(IGLOMCONSTANTS.INVOICE_TYPE_UNPLAY);
				dto.setInvoice(form);
				if (isTokenValid(req, true)) {
					// 类型信息登记逻辑调用
					dto = lomBL.insertInvoiceAction(dto);
				} else {					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}				
				log.debug("========发票处理终了========");

				forward = "DISP";
				
			  }
			else {
				//信息变更
				log.debug("========发票变更处理开始========");
				dto.setInvoice(form);
				//调用BL变更
				dto = lomBL.updateInvoiceAction(dto);
				log.debug("========发票变更处理终了========");
				//return mapping.findForward("DETAIL");
				forward="DETAIL";
			}
		  }
				//变更页面初始化
		  if ("EDIT".equals(mapping.getParameter()))
		  {
				log.debug("========通知变更初期显示处理开始========");
				dto.setIglom0401Form(form);
				dto = lomBL.initIGLOM0402Action(dto);
				log.debug("========通知变更初期显示处理终了========");
				forward="INIT_UPDATE";
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
