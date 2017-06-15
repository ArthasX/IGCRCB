/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.action;

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
import com.deliverik.infogovernor.fin.bl.IGFIN01BL;
import com.deliverik.infogovernor.fin.dto.IGFIN01DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0101Form;
import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.fin.vo.IGFIN01021VO;



/**
 * 预算详细信息画面Action处理
 *
 */
public class IGFIN0103Action extends BaseAction {

	static Log log = LogFactory.getLog(IGFIN0103Action.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGFIN0101Form form = new IGFIN0101Form();
		
		//BL取得
		IGFIN01BL ctlBL = (IGFIN01BL) getBean("igfin01BL");
		
		//DTO生成
		IGFIN01DTO dto = new IGFIN01DTO();

		if( "DISP".equals(mapping.getParameter())){
			//预算查询详细画面显示处理
			log.debug("========预算查询画面详细显示处理开始========");
			
			String bid = req.getParameter("eid");
			
			dto.setBid(Integer.valueOf(bid));
			
			form.setBid(Integer.valueOf(bid));
			
			dto.setIgfin0101Form(form);
			
			//预算查询画面详细显示处理逻辑调用
			dto = ctlBL.initIGFIN0103Action(dto);
			
			//预算检索结果设定到VO中
			Budget budget = dto.getBudget();
			
			IGFIN01021VO vo = new IGFIN01021VO(budget);
			
			vo.setBstatus(budget.getBstatus());
			
			super.<IGFIN01021VO>setVO(req,vo);
			
			log.debug("========预算查询画面详细显示处理终了========");
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//预算删除处理
			log.debug("========预算删除处理开始========");
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//返回处理
				return mapping.findForward("BACK");
			}
			
			log.debug("========资产配置删除处理终了========");
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
