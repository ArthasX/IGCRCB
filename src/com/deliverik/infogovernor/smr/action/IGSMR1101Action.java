/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.action;

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
import com.deliverik.infogovernor.smr.bl.IGSMR11BL;
import com.deliverik.infogovernor.smr.dto.IGSMR11DTO;
import com.deliverik.infogovernor.smr.form.IGSMR1101Form;

/**
 * 月报发起Action处理
 *
 */
public class IGSMR1101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR1101Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGSMR1101Form form = (IGSMR1101Form)actionForm;
				
		//BL取得
		IGSMR11BL ctlBL = (IGSMR11BL) getBean("igSMR11BL");
				
		//DTO生成
		IGSMR11DTO dto = new IGSMR11DTO();
		if( "DISP".equals(mapping.getParameter())){
			//月报发起处理画面初期显示处理
			log.debug("========月报发起页面显示处理开始========");
			saveToken(req);
			log.debug("========月报发起页面显示处理结束========");
			
		} 
		else if( "INSERT".equals(mapping.getParameter())){
			//月报发起处理处理
			log.debug("========月报发起处理开始========");
			
			//DTO输入参数设定
			dto.setIgSMR1101Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			if (isTokenValid(req, true)){
				dto = ctlBL.insertSMR1101Action(dto);//月报发起
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			
			log.debug("========月报发起处理结束========");
			
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
