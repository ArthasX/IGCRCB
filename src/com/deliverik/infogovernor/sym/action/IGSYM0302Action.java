/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0302Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_角色管理_新增修改ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0302Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0302Action.class);
	
	/**
	 * <p>
	 * Description: 角色action处理
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
		//实例化FORM
		IGSYM0302Form form = (IGSYM0302Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========角色新增画面初期显示处理开始========");
			addMessage(request, new ActionMessage("IGCO10000.I001","角色基本信息"));
			log.debug("========角色新增画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	
		//获取BL接口实例
		IGSYM03BL ctlBL = (IGSYM03BL) getBean("igsym03BL");
		//实例化DTO
		IGSYM03DTO dto = new IGSYM03DTO();
		String forward = "DISP";
		//角色新增
		if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				log.debug("========角色新增处理开始========");
				dto.setRole(form);
				dto.setIgsym0302Form(form);
				//调用BL新增
				dto = ctlBL.insertRoleAction(dto);
				log.debug("========角色新增处理终了========");
			} else {
				//信息变更
				log.debug("========角色变更处理开始========");
				dto.setRole(form);
				//调用BL变更
				dto = ctlBL.updateRoleAction(dto);
				forward = "DETAIL";
				log.debug("========角色变更处理终了========");
			}
		}
		//角色变更页面初始化
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========角色变更初期显示处理开始========");
			//
			dto.setIgsym0302Form(form);
			dto = ctlBL.initIGSYM0302Action(dto);
			log.debug("========角色变更初期显示处理终了========");
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
