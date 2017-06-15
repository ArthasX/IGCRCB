/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.alarm.action;

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
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.soc.alarm.bl.IGALM02BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM02DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0201Form;

/**
 * 规则模板添加处理
 * @author wangxing 
 * 2013.07.31
 */
public class IGALM0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGALM0201Action.class);

	/**
	 * 规则模板添加处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGALM0201Form form = (IGALM0201Form)actionForm;
		
		//BL取得
		IGALM02BL ctlBL = (IGALM02BL) getBean("igalm02BL");
		//DTO生成
		IGALM02DTO dto = new IGALM02DTO();
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("========规则模板添加画面初期显示处理开始========");
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========规则模板添加画面初期显示处理终了========");
			
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========规则模板添加处理开始========");
			if (isTokenValid(req, true)){
				dto.setIgalm0201Form(form);
				dto = ctlBL.insertRuleTempAndCondition(dto);
				addMessage(req, new ActionMessage("IGALM0201.I001"));
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========规则模板添加处理终了========");
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
