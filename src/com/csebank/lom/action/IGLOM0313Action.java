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
	 * 还款处理
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
		IGLOM0313Form form = (IGLOM0313Form) actionForm;
		// BL取得
		IGLOM03BL ctlBL = (IGLOM03BL) getBean("iglom03BL");
		// DTO生成
		IGLOM03DTO dto = new IGLOM03DTO();
		//下拉菜单
		req.getSession().setAttribute("ADloanpaydetail_lpdtype", LOMHelper.getItemsCodes(CodeUtils.LOANPAYDETAIL_LPDTYPE));
		
		if ("DISP".equals(mapping.getParameter())) {
			
			// 还款登记初期显示处理
			log.debug("========还款登记画面初期显示处理开始========");

			//还款日期默认当前日期
			form.setLpddate(IGStringUtils.getCurrentDate());
			
			addMessage(req, new ActionMessage("IGCO10000.I003", "还款信息"));
			
			log.debug("========还款登记画面初期显示处理终了========");
			
			saveToken(req);
			forward = "DISP";
			
		} else if ("CHANGE".equals(mapping.getParameter())){
			
			log.debug("========借款确认处理开始========");
			//DTO输入参数设定
			dto.setIglom0313Form(form);

			if (isTokenValid(req, true)) {
				ctlBL.changeLoanPayInvoiceAction(dto);
			} else {
				
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			
			log.debug("========借款确认处理终了========");
			
			forward = "CHANGE";
			
		} else if ("DELETE".equals(mapping.getParameter())){
			
			log.debug("========借款删除处理开始========");
			//DTO输入参数设定
			dto.setIglom0313Form(form);
			
			if (isTokenValid(req, true)) {
				ctlBL.deleteLoanPayInvoiceAction(dto);
			} else {
				
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========借款删除处理终了========");
			
			forward = "DELETE";
			
		} else if( "INSERT".equals(mapping.getParameter())){
			
			log.debug("========还款处理开始========");
			// DTO输入参数设定
			dto.setLoanPayDetail(form);
			dto.setIglom0313Form(form);

			if (isTokenValid(req, true)) {
				// 还款信息登记逻辑调用
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
			
			
			log.debug("========还款处理终了========");

			forward = "DISP";
				
			
		} else if( "SEARCH".equals(mapping.getParameter())){
			//还款查询处理
			log.debug("========还款查询处理开始========");
			

			form = (IGLOM0313Form) req.getSession().getAttribute("IGLOM0313Form");
			
			//DTO输入参数设定
//			dto.setLoanPayDetailSearchCond(null);
			
			dto.setIglom0313Form(form);
			//还款信息检索逻辑调用
			dto = ctlBL.searchLoanPayInvoiceAction(dto);
			

			//还款日期默认当前日期
			form.setLpddate(IGStringUtils.getCurrentDate());
			//还款人为借款人
			form.setLpdactuser(dto.getLoanPayDetailData().getLpduser());
			form.setLpduser(dto.getLoanPayDetailData().getLpduser());
			//默认发票还款
			form.setLpdtype(IGLOMCONSTANTS.LPD_TYPE_PAY_INVOICE);
			
			//将还款信息检索结果设定到VO中
			IGLOM03131VO vo = new IGLOM03131VO();
			vo.setLoanPayDetailList(dto.getLoanPayDetailList());
			vo.setLoanPayDetailData(dto.getLoanPayDetailData());
			vo.setDb(dto.getDb());
			super.<IGLOM03131VO>setVO(req.getSession(), vo);
			
			saveToken(req);
			
			log.debug("========还款查询处理终了========");
			
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
