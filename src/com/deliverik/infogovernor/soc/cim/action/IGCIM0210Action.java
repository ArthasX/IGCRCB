/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM02BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0210Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM02101VO;

/**
 * 概述: 控制台任务查看Action
 * 功能描述: 控制台任务查看Action
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
public class IGCIM0210Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0210Action.class);

	/**
	 * 控制台任务查看处理
	 *
	 * @param mapping ActionMapping 
	 * @param actionForm ActionForm 
	 * @param req HttpServletRequest 
	 * @param res HttpServletResponse 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGCIM0210Form form = (IGCIM0210Form)actionForm;
		
		//BL取得
		IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		
		//DTO生成
		IGCIM02DTO dto = new IGCIM02DTO();
		
		dto.setIgcim0210Form(form);
		
		if ("DISP".equals(mapping.getParameter())){
			
			log.debug("========控制台任务查看处理开始========");
			
			//获取任务列表
			dto = ctlBL.initIGCIM0210Action(dto);
			
			//VO生成
			IGCIM02101VO vo = new IGCIM02101VO(dto.getEiWaitTask());
			
			super.<IGCIM02101VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========控制台任务查看处理终了========");
			
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
