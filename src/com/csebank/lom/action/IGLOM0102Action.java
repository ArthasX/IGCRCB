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

import com.csebank.lom.bl.IGLOM01BL;
import com.csebank.lom.dto.IGLOM01DTO;
import com.csebank.lom.form.IGLOM0102Form;
import com.deliverik.framework.base.BaseAction;



/**
 * 接待客人处理Action
 * 
 */
public class IGLOM0102Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0102Action.class);
	
	String forward = "";

	/**
	 * 接待客人处理
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
		IGLOM0102Form form = (IGLOM0102Form) actionForm;
		// BL取得
		IGLOM01BL ctlBL = (IGLOM01BL) getBean("iglom01BL");
		// DTO生成
		IGLOM01DTO dto = new IGLOM01DTO();
		
		if ("DISP".equals(mapping.getParameter())) {
			
			// 接待客人登记初期显示处理
			log.debug("========接待客人登记画面初期显示处理开始========");
					

			IGLOM0102Form fm =  new IGLOM0102Form();
			fm.setRid(form.getRid());
			req.setAttribute("IGLOM0102Form", fm);
			req.getSession().setAttribute("IGLOM0102Form", fm);
			addMessage(req, new ActionMessage("IGCO10000.I001", "接待客人基本信息"));
			
			log.debug("========接待客人登记画面初期显示处理终了========");
			saveToken(req);
			
			forward = "DISP";
			
		} else if("REDISP".equals(mapping.getParameter())){
			
			//接待客人登记画面再显示处理
			log.debug("========接待客人登记画面再显示处理开始========");
			
			dto.setIglom0102Form(form);
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			
			log.debug("========接待客人登记画面再显示处理终了========");
			
			forward = "DISP";
			
		}else
		
		//新增
		if( "INSERT".equals(mapping.getParameter())){
			if((form.getMode().equals("0"))){
				// 类型登记处理
				log.debug("========接待客人处理开始========");
				// DTO输入参数设定
				dto.setRecptionGuest(form);
				dto.setIglom0102Form(form);

				if (isTokenValid(req, true)) {
					// 类型信息登记逻辑调用
					dto = ctlBL.insertRecptionGuestAction(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				
				log.debug("========接待客人处理终了========");

				forward = "DISP";
				
			}else {
				//接待客人信息变更处理
				log.debug("========接待客人信息变更处理开始========");
				
				//DTO输入参数设定
				dto.setRecptionGuest(form);
				dto.setIglom0102Form(form);
				

				if (isTokenValid(req, true)) {
					
					//接待客人信息变更逻辑调用
					dto = ctlBL.updateRecptionGuestAction(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				
				log.debug("========接待客人信息变更处理终了========");
				
				forward = "DISP1";

			}
		}
		//变更页面初始化
		if("EDIT".equals(mapping.getParameter())){
			
			log.debug("========接待客人信息变更初期显示处理开始========");
			form.setMode("1");
			
			dto.setIglom0102Form(form);
					
			dto = ctlBL.initRecptionGuest(dto);
			
			forward = "DISP";
			log.debug("========接待客人信息变更初期显示处理终了========");
		
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
