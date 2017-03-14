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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR07BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR07DTO;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR07011VO;

/**
 * 概述: vCenter信息查询
 * 功能描述: vCenter信息查询Action
 * 创建记录: 2014/02/12
 * 修改记录: 
 */
public class IGVIR0701Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVIR0701Action.class);

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
		
		//BL取得
		IGVIR07BL ctlBL = (IGVIR07BL) getBean("igvir07BL");
		
		//DTO生成
		IGVIR07DTO dto = new IGVIR07DTO();
		
		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========vCenter信息查询开始========");
			ctlBL.searchVIM01(dto);
			IGVIR07011VO vo = new IGVIR07011VO();
			vo.setVim01InfoList(dto.getVim01InfoList());
			super.<IGVIR07011VO>setVO(req.getSession(), vo);
			log.debug("========vCenter信息查询终了========");
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
