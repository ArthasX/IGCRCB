/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

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
import com.deliverik.infogovernor.asset.bl.IGASM22BL;
import com.deliverik.infogovernor.asset.dto.IGASM22DTO;
import com.deliverik.infogovernor.asset.form.IGASM2201Form;
import com.deliverik.infogovernor.asset.vo.IGASM22011VO;

/**
 * 概述: CI变更控制台显示Action
 * 功能描述: CI变更控制台显示Action
 * 创建记录: 2211/04/29
 * 修改记录: 
 */
public class IGASM2201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2201Action.class);

	/**
	 * CI变更控制台显示处理
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
		IGASM2201Form form = (IGASM2201Form)actionForm;
		
		//BL取得
		IGASM22BL ctlBL = (IGASM22BL) getBean("igasm22BL");
		
		//DTO生成
		IGASM22DTO dto = new IGASM22DTO();
		
		dto.setIgasm2201Form(form);
		
		if ("DISP".equals(mapping.getParameter())){
			
			log.debug("========CI变更控制台显示开始========");
			
			//获取任务列表
			dto = ctlBL.initIGASM2201Action(dto);
			
			//VO生成
			IGASM22011VO vo = new IGASM22011VO(dto.getCiWaitTaskList(), dto.getCiTaskInfo());
			
			super.<IGASM22011VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========CI变更控制台显示终了========");
			
		} else if("IMPORT".equals(mapping.getParameter())){
			
			log.debug("========CI变更控制台导入处理开始========");
			
			if (isTokenValid(req, true)){
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				dto.setUser(user);
				dto = ctlBL.importIGASM2201Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========CI变更控制台导入处理终了========");
			
		} else if("COMPARE".equals(mapping.getParameter())){
			
			log.debug("========CI变更控制台对比处理开始========");
			
			if (isTokenValid(req, true)){
				dto = ctlBL.compareIGASM2201Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========CI变更控制台对比处理终了========");
			
		} else if("DELETE".equals(mapping.getParameter())){
			
			log.debug("========待处理任务删除处理开始========");
			
			if (isTokenValid(req, true)){
				dto = ctlBL.deleteCIWaitTaskAction(dto);
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
