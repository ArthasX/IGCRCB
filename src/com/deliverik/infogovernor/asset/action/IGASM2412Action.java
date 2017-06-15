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
import com.deliverik.infogovernor.asset.bl.IGASM24BL;
import com.deliverik.infogovernor.asset.dto.IGASM24DTO;
import com.deliverik.infogovernor.asset.form.IGASM2412Form;

/**
 * 文档查询画面Action处理
 *
 */
public class IGASM2412Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2412Action.class);

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
		IGASM2412Form form = (IGASM2412Form)actionForm;
		
		//BL取得
		IGASM24BL ctlBL = (IGASM24BL) getBean("igasm24BL");
		
		//DTO生成
		IGASM24DTO dto = new IGASM24DTO();
		
		
		if ("DISP".equals(mapping.getParameter())){
			//文档修改处理显示
			log.debug("========文档修改处理显示开始========");
			dto.setIgasm2412Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto = ctlBL.initEntityItem(dto);
			
			log.debug("========文档修改处理显示终了========");
		}
		if ("UPDATE".equals(mapping.getParameter())){
			//文档修改处理显示
			log.debug("========文档修改处理显示开始========");
			dto.setIgasm2412Form(form);
			dto = ctlBL.updateEntityItem(dto);
			
			log.debug("========文档修改处理显示终了========");
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
