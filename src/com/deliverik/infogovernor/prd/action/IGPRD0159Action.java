/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0159Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01591VO;

/**
 * 概述: 流程策略通知人设定Action
 * 功能描述: 流程策略通知人设定Action
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
public class IGPRD0159Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRD0159Action.class);
	
	/**
	 * Action处理
	 *
	 * @param mapping ActionMapping
	 * @param actionForm ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @exception Exception
	 * @return ActionForward
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGPRD0159Form form = (IGPRD0159Form)actionForm;
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");	
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		String forward = "DISP";
		dto.setIgPRD0159Form(form);
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========流程策略通知人查询处理开始========");
			//调用BL查询
			dto = ctlBL.initIGPRD0159Action(dto);
			//构造VO
			IGPRD01591VO vo = new IGPRD01591VO();
			vo.setLst_IGPRD01592VO(dto.getLst_UserRoleInfo());
			super.<IGPRD01591VO>setVO(request, vo);
			log.debug("========流程策略通知人查询处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}
	
}
