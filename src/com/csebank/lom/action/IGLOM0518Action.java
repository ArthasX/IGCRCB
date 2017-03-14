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

import com.csebank.lom.bl.IGLOM05BL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0518Form;
import com.csebank.lom.util.CodeUtils;
import com.deliverik.framework.base.BaseAction;



/**
 * 餐卡处理Action
 * 
 */
public class IGLOM0518Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0518Action.class);
	
	String forward = "";

	/**
	 * 餐卡信息处理
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
		IGLOM0518Form form = (IGLOM0518Form) actionForm;
		// BL取得
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		// DTO生成
		IGLOM05DTO dto = new IGLOM05DTO();
		
		if ("DISP".equals(mapping.getParameter())) {
			
			log.debug("========餐卡登记画面初期显示处理开始========");
			
			req.getSession().setAttribute("IGLOM0518Form", new IGLOM0518Form());
			addMessage(req, new ActionMessage("IGCO10000.I001", "餐卡信息"));
			
			log.debug("========餐卡登记画面初期显示处理终了========");
			saveToken(req);
			
			forward = "DISP";
			
		} else if( "INSERT".equals(mapping.getParameter())){
			if((form.getMode().equals("0"))){
				// 餐卡登记处理
				log.debug("========餐卡信息登记处理开始========");
				// DTO输入参数设定
				
				//餐卡类型
				form.setSelectid(CodeUtils.CARD_CATEGORY);
				//餐卡面值
				form.setType(form.getPrince());
				//补贴值
				form.setTypecode(form.getAllowance());
				//启用状态
				form.setDesc("1");
				
				dto.setItemsCodes(form);
				dto.setIglom0518Form(form);
				if (isTokenValid(req, true)) {
					dto = ctlBL.insertLunchCardAction(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				
				log.debug("========餐卡信息登记处理终了========");

				forward = "DISP";
				
			}else {
				//接待信息变更处理
				log.debug("========食堂成本信息变更处理开始========");
				
				//DTO输入参数设定
				dto.setItemsCodes(form);
				dto.setIglom0518Form(form);
				form.setType(form.getPrince());
				form.setTypecode(form.getAllowance());
				//接待信息变更逻辑调用
				dto = ctlBL.updateLunchCardAction(dto);
				
				log.debug("========食堂成本信息变更处理终了========");
				
				return mapping.findForward("DETAIL");

			}
		}	else if ("EDIT".equals(mapping.getParameter())){
			
			log.debug("========餐卡管理变更处理开始========");
			
			//DTO输入参数设定
			dto.setIglom0518Form(form);
			
			dto = ctlBL.initLunchCardAction(dto);
			
			log.debug("========餐卡管理变更初期显示处理终了========");
			return mapping.findForward("DISP");
			
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
