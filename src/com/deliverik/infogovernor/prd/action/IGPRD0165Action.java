/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
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
import com.deliverik.infogovernor.prd.form.IGPRD0165Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01651VO;

/**
 * 概述: 表单初始化配置查询Action
 * 功能描述: 表单初始化配置查询Action
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
public class IGPRD0165Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0165Action.class);

	/**
	 * 表单初始化配置查询Action
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
		IGPRD0165Form form = (IGPRD0165Form) actionForm;
		// BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		// DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		dto.setIgPRD0165Form(form);
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========表单初始化配置查询处理开始========");
			dto = ctlBL.searchIG373InfoAction(dto);
			IGPRD01651VO vo = new IGPRD01651VO();
			vo.setLst_IG373Info(dto.getLst_IG373Info());
			super.<IGPRD01651VO> setVO(req, vo);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========表单初始化配置查询处理结束========");
		} else if ("DELETE".equals(mapping.getParameter())) {
			log.debug("========表单初始化配置删除处理开始========");
			dto = ctlBL.deleteIG373InfoAction(dto);
			log.debug("========表单初始化配置删除处理结束========");
		}
		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		// 历史版本下的查看
		if (StringUtils.isNotEmpty(form.getViewhistory())
				&& "1".equalsIgnoreCase(form.getViewhistory())) {
			return mapping.findForward("VIEWHISTORY");
		}
		return mapping.findForward("DISP");
	}
}
