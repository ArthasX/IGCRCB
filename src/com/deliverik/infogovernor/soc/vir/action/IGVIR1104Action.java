/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.action;


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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR11BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR11DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1104Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR11041VO;

/**
 * 概述: 虚拟资源统计
 * 功能描述: 虚拟资源统计
 * 创建记录: 2014/02/12
 * 修改记录: 
 */
public class IGVIR1104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVIR1104Action.class);

	/**
	 * 配置包含关系显示处理
	 *
	 * @param mapping ActionMapping 
	 * @param actionForm ActionForm 
	 * @param req HttpServletRequest 
	 * @param res HttpServletResponse 
	 * @return ActionForward
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		IGVIR1104Form form = (IGVIR1104Form)actionForm;
		//BL取得
		IGVIR11BL ctlBL = (IGVIR11BL) getBean("igvir11BL");
		
		//DTO生成
		IGVIR11DTO dto = new IGVIR11DTO();
		
		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========虚拟资源统计显示开始========");
			User loginUser = (User) req.getSession().getAttribute("LOGIN_USER");
			dto.setLoginUser(loginUser);
			dto.setIgVIR1104Form(form);
//			ctlBL.searchVim03ByUser(dto);
			ctlBL.searchVim03(dto);
			IGVIR11041VO vo = new IGVIR11041VO();
			vo.setOneVim03List(dto.getOneVim03List());
//			vo.setOneVim03uList(dto.getOneVim03uList());
//			vo.setUser(dto.getUser());
			super.<IGVIR11041VO>setVO(req, vo);
			log.debug("========虚拟资源统计显示终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward(forward);
	}
}
