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
import com.deliverik.infogovernor.asset.action.IGASM0321Action;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM03BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM03DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0303Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM03031VO;

/**
 * 概述: 审计控制台任务查看Action
 * 功能描述: 审计控制台任务查看Action
 * 创建记录: 2111/04/29
 * 修改记录: 
 */
public class IGCIM0303Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0321Action.class);

	/**
	 * 审计控制台任务查看处理
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
		IGCIM0303Form form = (IGCIM0303Form)actionForm;
		
		//BL取得
		IGCIM03BL ctlBL = (IGCIM03BL) getBean("igcim03BL");
		
		//DTO生成
		IGCIM03DTO dto = new IGCIM03DTO();
		
		dto.setIgcim0303Form(form);
		
		if ("DISP".equals(mapping.getParameter())){
			
			log.debug("========审计控制台任务查看处理开始========");
			
			//获取任务列表
			dto = ctlBL.initIGCIM0303Action(dto);
			
			//VO生成
			IGCIM03031VO vo = new IGCIM03031VO(dto.getAuditWaitTask());
			
			super.<IGCIM03031VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========审计控制台任务查看处理终了========");
			
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
