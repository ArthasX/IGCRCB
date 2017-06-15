/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.risk.bl.IGRIS01BL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0110Form;

/**
 * 审计发起基本信息编辑画面Action处理
 *
 */
public class IGRIS0110Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0110Action.class);

	/**
	 * 审计发起处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGRIS0110Form form = (IGRIS0110Form)actionForm;
		
		//BL取得
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		
		//DTO生成
		IGRIS01DTO dto = new IGRIS01DTO();
		
		//画面跳转设定
		String forward = null;
		
		if( "DISP".equals(mapping.getParameter())){
			//审计发起登记画面初期显示处理
			log.debug("========审计发起登记画面初期显示处理开始========");
			
			//获取版本名称下拉列表
			dto = ctlBL.searchRiskAuditLabelInUse(dto);
			req.setAttribute("labelList", dto.getLabelList());
			
			addMessage(req, new ActionMessage("IGCO10000.I001","审计发起基本信息"));
			
			log.debug("========审计发起登记画面初期显示处理终了========");
			
			return mapping.findForward("DISP");
			
		} else if( "INSERT".equals(mapping.getParameter())){
			
			if (form.getMode().equals("0")){
				//审计发起登记处理
				log.debug("========审计发起登记处理开始========");
				
				//DTO输入参数设定
				dto.setIgRIS0110Form(form);
				
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				dto.setUser(user);
				
				//审计发起信息登记逻辑调用
				dto = ctlBL.insertRiskAuditInsAction(dto);
				
				log.debug("========审计发起登记处理终了========");
				
				forward = "DISP";
			} else {
				//审计发起变更处理
				log.debug("========审计发起基本信息变更处理开始========");
				
				//DTO输入参数设定
				dto.setIgRIS0110Form(form);
				
				//审计发起信息变更逻辑调用
				dto = ctlBL.updateRiskAuditInsAction(dto);
				
				log.debug("========审计发起基本信息变更处理终了========");
				
				forward = "BACK";
			}
			
		} else if ("CHANGE".equals(mapping.getParameter())){
				log.debug("========审计发起关闭/启用处理开始========");
				//DTO输入参数设定
				dto.setIgRIS0110Form(form);
				
				ctlBL.changeRiskAuditInsAction(dto);
				
				log.debug("========审计发起关闭/启用处理终了========");
				
				forward = "DISP";
		} else if ("EDIT".equals(mapping.getParameter())){
			log.debug("========审计发起基本信息变更初期显示处理开始========");
			
			dto.setIgRIS0110Form(form);
			
			dto = ctlBL.initIGRIS0110Action(dto);
			
			log.debug("========审计发起基本信息变更初期显示处理终了========");

			forward = "DISP";
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}
}
