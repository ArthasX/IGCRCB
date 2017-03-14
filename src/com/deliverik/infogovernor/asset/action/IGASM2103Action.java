/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM21BL;
import com.deliverik.infogovernor.asset.dto.IGASM21DTO;
import com.deliverik.infogovernor.asset.form.IGASM2103Form;
import com.deliverik.infogovernor.asset.vo.IGASM21031VO;

/**
 * 概述: 审计控制台任务查看Action
 * 功能描述: 审计控制台任务查看Action
 * 创建记录: 2111/04/29
 * 修改记录: 
 */
public class IGASM2103Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0321Action.class);

	/**
	 * 审计控制台任务查看处理
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
		IGASM2103Form form = (IGASM2103Form)actionForm;
		
		//BL取得
		IGASM21BL ctlBL = (IGASM21BL) getBean("igasm21BL");
		
		//DTO生成
		IGASM21DTO dto = new IGASM21DTO();
		
		dto.setIgasm2103Form(form);
		
		if ("DISP".equals(mapping.getParameter())){
			
			log.debug("========审计控制台任务查看处理开始========");
			
			//获取任务列表
			dto = ctlBL.initIGASM2103Action(dto);
			
			//VO生成
			IGASM21031VO vo = new IGASM21031VO(dto.getAuditWaitTask());
			
			super.<IGASM21031VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========审计控制台任务查看处理终了========");
			
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
