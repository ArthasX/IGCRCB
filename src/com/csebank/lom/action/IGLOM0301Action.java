/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM03BL;
import com.csebank.lom.dto.IGLOM03DTO;
import com.csebank.lom.form.IGLOM0301Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;

/**
 * 预支管理Action
 * 
 */

public class IGLOM0301Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0301Action.class);
	
	/**
	 * <p>
	 * Description: 预支费用新增action处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGLOM0301Form form = (IGLOM0301Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========预支费用新增画面初期显示处理开始========");
			request.getSession().setAttribute("AD_advancescost_actype", LOMHelper.getItemsCodes(CodeUtils.ADVANCESCOST_ACTYPE));
			addMessage(request, new ActionMessage("IGCO10000.I001","预支费用基本信息"));
			saveToken(request);
			log.debug("========预支费用新增画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	
		//获取BL接口实例
		IGLOM03BL ctlBL = (IGLOM03BL) getBean("iglom03BL");
		//实例化DTO
		IGLOM03DTO dto = new IGLOM03DTO();
		String forward = "DISP";
		//预支费用新增
		if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				log.debug("========预支费用新增处理开始========");
				User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				form.setAcuserid(user.getUserid());
				form.setAcusername(user.getUsername());
				
				dto.setIglom0301Form(form);
				if (isTokenValid(request, true)) {
					//调用BL新增
					dto = ctlBL.insertAdvanCescostAction(dto);
				} else {
					
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========预支费用新增处理终了========");
			} else {
				//信息变更
				log.debug("========预支费用变更处理开始========");
				dto.setIglom0301Form(form);
				
				if (isTokenValid(request, true)) {
					//调用BL变更
					dto = ctlBL.updateAdvanCescostAction(dto);
				} else {
					
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========预支费用变更处理终了========");
			}
		}
		//预支费用变更页面初始化
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========预支费用变更初期显示处理开始========");
			dto.setIglom0301Form(form);
			dto = ctlBL.initAdvanCescostAction(dto);
			request.getSession().setAttribute("AD_advancescost_actype", LOMHelper.getItemsCodes(CodeUtils.ADVANCESCOST_ACTYPE));
			log.debug("========预支费用变更初期显示处理终了========");
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
