/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prd.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0139Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01391VO;

/**
 * 概述: 流程状态可分派角色定义Action
 * 功能描述: 流程状态可分派角色定义Action
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
public class IGPRD0139Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRD0139Action.class);
	
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
		IGPRD0139Form form = (IGPRD0139Form)actionForm;
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");	
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		String forward = "DISP";
		dto.setIgPRD0139Form(form);
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========流程状态可分派角色定义查询处理开始========");
			dto.setPdid(form.getPdid());
			//调用BL查询
			dto = ctlBL.searchProcessStatusRoleDefAction(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			saveToken(request);
			//构造VO
			IGPRD01391VO vo = new IGPRD01391VO();
			vo.setLst_ProcessStatusRoleDef(dto.getLst_ProcessStatusRoleDef());
			vo.setLst_Role(dto.getLst_Role());
			request.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01391VO>setVO(request, vo);
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//历史版本下的查看
				forward = "VIEWHISTORY";
			}
			log.debug("========流程状态可分派角色定义查询处理终了========");
		} else if ("INSERT".equals(mapping.getParameter())){//添加参与者
			log.debug("========流程状态可分派角色定义设定处理开始========");
			//删除角色
			if("0".equals(form.getMode())){
				if (isTokenValid(request, true)){
					//调用BL发起
					ctlBL.removeProcessStatusRoleDef(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}else{//添加角色
				if (isTokenValid(request, true)){
					//调用BL发起
					ctlBL.addProcessStatusRoleDef(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}

			log.debug("========流程状态可分派角色定义设定处理终了========");
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
