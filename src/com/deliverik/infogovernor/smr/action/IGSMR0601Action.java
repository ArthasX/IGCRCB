/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
import com.deliverik.infogovernor.smr.bl.IGSMR06BL;
import com.deliverik.infogovernor.smr.dto.IGSMR06DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0601Form;

/**
 * 概述:季报发起 
 * 功能描述：季报发起 
 * 创建人：赵梓廷
 * 创建记录： 2013-08-07
 * 修改记录：
 */
public class IGSMR0601Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0601Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGSMR0601Form form = (IGSMR0601Form)actionForm;
				
		//BL取得
		IGSMR06BL ctlBL = (IGSMR06BL) getBean("igSMR06BL");
				
		//DTO生成
		IGSMR06DTO dto = new IGSMR06DTO();
		if( "DISP".equals(mapping.getParameter())){
			//年报发起处理画面初期显示处理
			log.debug("========年报发起页面显示处理开始========");
			saveToken(req);
			log.debug("========年报发起页面显示处理结束========");
			
		} else if( "INSERT".equals(mapping.getParameter())){
			//年报发起处理处理
			log.debug("========年报发起处理开始========");
			
			//DTO输入参数设定
			dto.setIgSMR0601Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			if (isTokenValid(req, true)){
				dto = ctlBL.insertSMR0601Action(dto);//年报发起
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			
			log.debug("========年报发起处理结束========");
			
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
