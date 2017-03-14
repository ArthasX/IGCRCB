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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM03BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM03DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0301Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM03011VO;

/**
 * 概述: 审计控制台显示Action
 * 功能描述: 审计控制台显示Action
 * 创建记录: 2111/04/29
 * 修改记录: 
 */
public class IGCIM0301Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0301Action.class);

	/**
	 * 审计控制台显示处理
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
		IGCIM0301Form form = (IGCIM0301Form)actionForm;
		
		//BL取得
		IGCIM03BL ctlBL = (IGCIM03BL) getBean("igcim03BL");
		
		//DTO生成
		IGCIM03DTO dto = new IGCIM03DTO();
		
		dto.setIgcim0301Form(form);
		
		if ("DISP".equals(mapping.getParameter())){
			
			log.debug("========审计控制台显示开始========");
			
			//获取任务列表
			dto = ctlBL.initIGCIM0301Action(dto);
			
			//VO生成
			IGCIM03011VO vo = new IGCIM03011VO(dto.getAuditWaitTaskList(), dto.getAuditTaskInfo());
			
			super.<IGCIM03011VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========审计控制台显示终了========");
			
		} else if("IMPORT".equals(mapping.getParameter())){
			
			log.debug("========审计控制台导入处理开始========");
			
			if (isTokenValid(req, true)){
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				dto.setUser(user);
				dto = ctlBL.importIGCIM0301Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========审计控制台导入处理终了========");
			
		} else if("COMPARE".equals(mapping.getParameter())){
			
			log.debug("========审计控制台对比处理开始========");
			
			if (isTokenValid(req, true)){
				dto = ctlBL.compareIGCIM0301Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========审计控制台对比处理终了========");
			
		} else if("DELETE".equals(mapping.getParameter())){
			
			log.debug("========待处理任务删除处理开始========");
			
			if (isTokenValid(req, true)){
				dto = ctlBL.deleteAuditWaitTaskAction(dto);
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
