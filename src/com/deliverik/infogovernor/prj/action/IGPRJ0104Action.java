/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.prj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.prj.bl.IGPRJ01BL;
import com.deliverik.infogovernor.prj.dto.IGPRJ01DTO;
import com.deliverik.infogovernor.prj.form.IGPRJ0104Form;
import com.deliverik.infogovernor.prj.vo.IGPRJ0104VO;


public class IGPRJ0104Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRJ0104Action.class);
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) {
		//实例化FORM
		IGPRJ0104Form form = (IGPRJ0104Form)actionForm;
		//获取BL接口实例
		IGPRJ01BL prjBL = (IGPRJ01BL) getBean("igprj01BL");
		//实例化DTO
		IGPRJ01DTO dto = new IGPRJ01DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setIgprj0104Form(form);
		dto.setUserId(user.getUserid());
		IGPRJ0104VO vo = new IGPRJ0104VO();
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========负责人查询处理开始========");
			//调用BL查询
			try {
				dto = prjBL.getPrincipal(dto);
			} catch (BLException e) {
			}
			//构造VO
			vo.setPrincipalList(dto.getPrincipalList());
			vo.setRoleMap(dto.getRoleMap());
			super.<IGPRJ0104VO>setVO(request, vo);
			log.debug("========负责人查询处理终了========");
		}
		//合作人
		if ("PRINCIPAL".equals(mapping.getParameter())){
			log.debug("========负责人处理开始========");
			if("0".equals(form.getMode())){//删除角色
				try {
					dto = prjBL.removePrincipal(dto);
				} catch (BLException e) {
					request.setAttribute("pid", form.getPid());
					return mapping.findForward("DELETE_ERROR");
				}
			}else{//添加角色
				try {
					dto = prjBL.addPrincipal(dto);
				} catch (BLException e) {
					request.setAttribute("pid", form.getPid());
					return mapping.findForward("ADD_ERROR");
				}
			}
			request.setAttribute("pid", form.getPid());
			log.debug("========负责人处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}
	
}
