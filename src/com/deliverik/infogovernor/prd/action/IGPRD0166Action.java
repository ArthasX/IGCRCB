/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
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
import com.deliverik.infogovernor.prd.form.IGPRD0166Form;

/**
 * 概述: 表单初始化配置新增/修改Action
 * 功能描述: 表单初始化配置新增/修改Action
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
public class IGPRD0166Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0166Action.class);

	/**
	 * 表单初始化配置新增/修改Action
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORM取得
		IGPRD0166Form form = (IGPRD0166Form) actionForm;
		// BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		// DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		dto.setIgPRD0166Form(form);
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========表单初始化配置新增初始化处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========表单初始化配置新增初始化处理结束========");
		} if ("INSERT".equals(mapping.getParameter())) {
			log.debug("========表单初始化配置新增处理开始========");
			if (isTokenValid(req, true)){
				dto = ctlBL.insertIG373InfoAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========表单初始化配置新增处理结束========");
		} else if ("INIT".equals(mapping.getParameter())) {
			log.debug("========表单初始化配置修改初始化处理开始========");
			dto = ctlBL.initIG373InfoAction(dto);
			saveToken(req);
			log.debug("========表单初始化配置修改初始化处理结束========");
		} else if ("EDIT".equals(mapping.getParameter())) {
			log.debug("========表单初始化配置修改处理开始========");
			if (isTokenValid(req, true)){
				dto = ctlBL.editIG373InfoAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========表单初始化配置修改处理结束========");
		}
		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
