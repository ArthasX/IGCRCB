/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.prm.action;

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
import com.deliverik.infogovernor.soc.prm.bl.IGPRM00BL;
import com.deliverik.infogovernor.soc.prm.dto.IGPRM00DTO;
import com.deliverik.infogovernor.soc.prm.vo.IGPRM00001VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_流程发起_选择流程类型ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGPRM0000Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRM0000Action.class);
	
	/**
	 * <p>
	 * Description:选择流程类型ACTION处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("========流程类型查询处理开始========");
		//获取BL接口实例
		IGPRM00BL ctlBL = (IGPRM00BL) getBean("socprm00BL");
		//实例化DTO
		IGPRM00DTO dto = new IGPRM00DTO();
		dto.setLocale(this.getLocale(request));
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUserid(user.getUserid());
		
		//选择流程类型查询
		dto.setProcessType(request.getParameter("prtype"));
		//调用BL查询
		dto = ctlBL.searchProcessDefinitionAction(dto);
		//构造VO
		IGPRM00001VO vo = new IGPRM00001VO();
		vo.setTemplateDefinitionMap(dto.getTemplateDefinitionMap());
		vo.setGpt(dto.getGpt());
		vo.setSpt(dto.getSpt());
		super.<IGPRM00001VO>setVO(request, vo);
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		log.debug("========流程类型查询处理终了========");
		return mapping.findForward("DISP");
	}

}
