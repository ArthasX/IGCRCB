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
import com.deliverik.infogovernor.risk.form.IGRIS0102Form;

/**
 * 审计版本基本信息编辑画面Action处理
 *
 */
public class IGRIS0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0102Action.class);

	/**
	 * 审计版本处理
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
		IGRIS0102Form form = (IGRIS0102Form)actionForm;
		
		//BL取得
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		
		//DTO生成
		IGRIS01DTO dto = new IGRIS01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//审计版本登记画面初期显示处理
			log.debug("========审计版本登记画面初期显示处理开始========");
			
			addMessage(req, new ActionMessage("IGCO10000.I001","审计版本基本信息"));
			
			log.debug("========审计版本登记画面初期显示处理终了========");
			
		} else if( "INSERT".equals(mapping.getParameter())){
			//审计版本登记处理
			log.debug("========审计版本登记处理开始========");
			
			//DTO输入参数设定
			dto.setIgRIS0102Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//审计版本信息登记逻辑调用
			dto = ctlBL.insertRiskAuditAction(dto);
			
			log.debug("========审计版本登记处理终了========");
			
		} else if ("CHANGE".equals(mapping.getParameter())){
				log.debug("========审计版本停用/启用处理开始========");
				//DTO输入参数设定
				dto.setIgRIS0102Form(form);
				
				ctlBL.changeRiskAuditAction(dto);
				
				log.debug("========审计版本停用/启用处理终了========");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
