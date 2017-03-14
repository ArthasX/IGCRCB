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
import com.deliverik.infogovernor.asset.bl.IGASM31BL;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.form.IGASM3112Form;

/**
 * 风险指标查询画面Action处理
 *
 */
public class IGASM3112Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM3112Action.class);

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
		IGASM3112Form form = (IGASM3112Form)actionForm;
		
		//BL取得
		IGASM31BL ctlBL = (IGASM31BL) getBean("igasm31BL");
		
		//DTO生成
		IGASM31DTO dto = new IGASM31DTO();
		
		
		if ("DISP".equals(mapping.getParameter())){
			//风险指标修改处理显示
			log.debug("========风险指标修改处理显示开始========");
			dto.setIgasm3112Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto = ctlBL.initEntityItem(dto);
			
			log.debug("========风险指标修改处理显示终了========");
		}
		if ("UPDATE".equals(mapping.getParameter())){
			//风险指标修改处理显示
			log.debug("========风险指标修改处理显示开始========");
			dto.setIgasm3112Form(form);
			dto = ctlBL.updateEntityItem(dto);
			
			log.debug("========风险指标修改处理显示终了========");
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
