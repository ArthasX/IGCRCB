/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
/**
 * 
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
import com.deliverik.infogovernor.iam.bl.IGIAM02BL;
import com.deliverik.infogovernor.iam.dto.IGIAM02DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0202Form;

/**
 * @author zhaomin
 *
 */
/**
 * 概述: 内置工作管理新增action
 * 功能描述：内置工作管理新增action
 * 创建人：赵敏
 * 创建记录： 2012-7-26
 * 修改记录：
 */
public class IGIAM0202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0202Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//获取form
		IGIAM0202Form form = (IGIAM0202Form)actionForm;
		
		//获取bl
		IGIAM02BL iajBL = (IGIAM02BL)getBean("igiam02bl");
		
		//获取dto
		IGIAM02DTO dto = new IGIAM02DTO();
		
		//获取当前登录用户
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);

		if("INSERT".equals(mapping.getParameter())){
			log.debug("========内审工作新增处理开始========");
			
			form.setIajuserid(user.getUserid());
			//设置新增form对象
			dto.setAttachFile(form);//设置附件用
			dto = iajBL.insertIAMAction(dto);
			
			log.debug("========内审工作新增处理结束========");
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
