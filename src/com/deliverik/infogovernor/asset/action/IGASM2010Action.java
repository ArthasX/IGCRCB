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
import com.deliverik.infogovernor.asset.bl.IGASM20BL;
import com.deliverik.infogovernor.asset.dto.IGASM20DTO;
import com.deliverik.infogovernor.asset.form.IGASM2010Form;
import com.deliverik.infogovernor.asset.vo.IGASM20101VO;

/**
 * 概述: 控制台任务查看Action
 * 功能描述: 控制台任务查看Action
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
public class IGASM2010Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0321Action.class);

	/**
	 * 控制台任务查看处理
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
		IGASM2010Form form = (IGASM2010Form)actionForm;
		
		//BL取得
		IGASM20BL ctlBL = (IGASM20BL) getBean("igasm20BL");
		
		//DTO生成
		IGASM20DTO dto = new IGASM20DTO();
		
		dto.setIgasm2010Form(form);
		
		if ("DISP".equals(mapping.getParameter())){
			
			log.debug("========控制台任务查看处理开始========");
			
			//获取任务列表
			dto = ctlBL.initIGASM2010Action(dto);
			
			//VO生成
			IGASM20101VO vo = new IGASM20101VO(dto.getEiWaitTask());
			
			super.<IGASM20101VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========控制台任务查看处理终了========");
			
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
