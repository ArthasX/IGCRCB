/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM02BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0201Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM02011VO;

/**
 * 概述: 控制台显示Action
 * 功能描述: 控制台显示Action
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
public class IGCIM0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0201Action.class);

	/**
	 * 控制台显示处理
	 *
	 * @param mapping ActionMapping 
	 * @param actionForm ActionForm 
	 * @param req HttpServletRequest 
	 * @param res HttpServletResponse 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGCIM0201Form form = (IGCIM0201Form)actionForm;
		
		//BL取得
		IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		
		//DTO生成
		IGCIM02DTO dto = new IGCIM02DTO();
		dto.setLocale(this.getLocale(req));
		dto.setIgcim0201Form(form);
		
		if ("DISP".equals(mapping.getParameter())){
			
			log.debug("========控制台显示开始========");
			
			//获取任务列表
			dto = ctlBL.initIGCIM0201Action(dto);
			
			//VO生成
			IGCIM02011VO vo = new IGCIM02011VO(dto.getEiWaitTaskList());
			
			super.<IGCIM02011VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========控制台显示终了========");
			
		} else if("IMPORT".equals(mapping.getParameter())){
			
			log.debug("========控制台导入处理开始========");
			
			if (isTokenValid(req, true)){
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				dto.setUser(user);
				dto = ctlBL.importIGCIM0201Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========控制台导入处理终了========");
			
		} else if("DELETE".equals(mapping.getParameter())){
			
			log.debug("========待处理任务删除处理开始========");
			
			if (isTokenValid(req, true)){
				dto = ctlBL.deleteEiWaitTaskAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========待处理任务删除处理终了========");
			
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
