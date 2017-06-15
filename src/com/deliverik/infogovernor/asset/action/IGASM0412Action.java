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
import com.deliverik.infogovernor.asset.bl.IGASM04BL;
import com.deliverik.infogovernor.asset.dto.IGASM04DTO;
import com.deliverik.infogovernor.asset.form.IGASM0412Form;

/**
 * 合同查询画面Action处理
 *
 */
public class IGASM0412Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0412Action.class);

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
		IGASM0412Form form = (IGASM0412Form)actionForm;
		
		//BL取得
		IGASM04BL ctlBL = (IGASM04BL) getBean("igasm04BL");
		
		//DTO生成
		IGASM04DTO dto = new IGASM04DTO();
		
		
		if ("DISP".equals(mapping.getParameter())){
			//合同修改处理显示
			log.debug("========合同修改处理显示开始========");

			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto.setIgasm0412Form(form);
			
			dto = ctlBL.initEntityItem(dto);
			
			log.debug("========合同修改处理显示终了========");
		}
		if ("UPDATE".equals(mapping.getParameter())){
			//合同修改处理显示
			log.debug("========合同修改处理显示开始========");
			dto.setIgasm0412Form(form);
			dto = ctlBL.updateEntityItem(dto);
			
			log.debug("========合同修改处理显示终了========");
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
