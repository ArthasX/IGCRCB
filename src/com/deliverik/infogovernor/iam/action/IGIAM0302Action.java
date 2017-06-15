/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.iam.action;

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
import com.deliverik.infogovernor.iam.bl.IGIAM03BL;
import com.deliverik.infogovernor.iam.dto.IGIAM03DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0302Form;

/**
 * 概述: 审计报告新增form 功能描述：审计报告新增 创建人：惠涌智 创建记录： 2012-8-9 修改记录：
 */
public class IGIAM0302Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0302Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 获取form
		IGIAM0302Form form = (IGIAM0302Form) actionform;
		// 获取业务逻辑BL
		IGIAM03BL iam03BL = (IGIAM03BL) getBean("igiam03bl");
		// 声明DTO
		IGIAM03DTO igiam03DTO = new IGIAM03DTO();
		// 获取当前登录用户
		User user = (User) request.getSession().getAttribute(
				SESSION_KEY_LOGIN_USER);
		
		if("INSERT".equals(mapping.getParameter())){
			log.debug("========内审工作新增处理开始========");
			//设置新增form对象
			igiam03DTO.setAttachFile(form);//设置附件用
			igiam03DTO = iam03BL.insertIAMAction(igiam03DTO);
			
			log.debug("========内审工作新增处理结束========");
		}
		List<ActionMessage> messageList = igiam03DTO.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
