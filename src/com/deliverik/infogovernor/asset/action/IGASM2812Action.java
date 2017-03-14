package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM28BL;
import com.deliverik.infogovernor.asset.dto.IGASM28DTO;
import com.deliverik.infogovernor.asset.form.IGASM2812Form;

/**
 * 检查项查询画面Action处理
 *
 */
public class IGASM2812Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2812Action.class);

	/**
	 * 事件处理
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
		IGASM2812Form form = (IGASM2812Form)actionForm;
		
		//BL取得
		IGASM28BL ctlBL = (IGASM28BL) getBean("igasm28BL");
		
		//DTO生成
		IGASM28DTO dto = new IGASM28DTO();
		
		
		if ("DISP".equals(mapping.getParameter())){
			//检查项修改处理显示
			log.debug("========检查项修改处理显示开始========");
			dto.setIgasm2812Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto = ctlBL.initEntityItem(dto);
			
			log.debug("========检查项修改处理显示终了========");
		}
		if ("UPDATE".equals(mapping.getParameter())){
			//检查项修改处理显示
			log.debug("========检查项修改处理显示开始========");
			dto.setIgasm2812Form(form);
			dto = ctlBL.updateEntityItem(dto);
			
			log.debug("========检查项修改处理显示终了========");
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
