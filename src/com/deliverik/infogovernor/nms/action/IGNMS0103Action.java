/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.action;

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
import com.deliverik.infogovernor.nms.bl.IGNMS01BL;
import com.deliverik.infogovernor.nms.bl.task.NMSBaseBLImpl;
import com.deliverik.infogovernor.nms.dto.IGNMS01DTO;
import com.deliverik.infogovernor.nms.form.IGNMS0103Form;
import com.deliverik.infogovernor.nms.vo.IGNMS01031VO;

/**
 * 概述: 任务配置Action
 * 功能描述: 任务配置Action
 * 创建记录: 2013/12/20
 * 修改记录:
 */
public class IGNMS0103Action extends BaseAction {
	static Log log = LogFactory.getLog(IGNMS0103Action.class);

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IGNMS0103Form form = (IGNMS0103Form) actionForm;
		IGNMS01BL ctlBL = (IGNMS01BL) getBean("ignms01BL");
		IGNMS01DTO dto = new IGNMS01DTO();
		if(form.getGid() == null || form.getGid() == 0) {
			form.setGid(NMSBaseBLImpl.GROUPID_DEFAULT);//默认组
		}
		dto.setNms03Info(form);
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========任务配置显示处理开始========");
			dto = ctlBL.initNMS03Action(dto);
			// 构造VO
			IGNMS01031VO vo = new IGNMS01031VO();
			vo.setLst_NMS03Info(dto.getLst_NMS03Info());
			super.<IGNMS01031VO> setVO(request, vo);
			log.debug("========任务配置显示处理结束========");
		} else if ("INS".equals(mapping.getParameter())) {
			log.debug("========任务配置新增处理开始========");
			dto = ctlBL.insertNMS03Action(dto);
			request.setAttribute("flag", "1");
			log.debug("========任务配置新增处理结束========");
		} else if ("DEL".equals(mapping.getParameter())) {
			log.debug("========任务配置删除处理开始========");
			dto = ctlBL.deleteNMS03Action(dto);
			request.setAttribute("flag", "1");
			log.debug("========任务配置删除处理结束========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
