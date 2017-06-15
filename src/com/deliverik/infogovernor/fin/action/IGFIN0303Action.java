/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.fin.bl.IGFIN04BL;
import com.deliverik.infogovernor.fin.dto.IGFIN02DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0312Form;
import com.deliverik.infogovernor.fin.vo.IGFIN0303VO;

public class IGFIN0303Action extends BaseAction {

	static Log log = LogFactory.getLog(IGFIN0303Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		
		IGFIN0312Form form = (IGFIN0312Form)actionForm;
		
		IGFIN02DTO dto = new IGFIN02DTO();
		
		IGFIN04BL ctlBL = (IGFIN04BL) getBean("igfin04BL");
		
		if( "DISP".equals(mapping.getParameter())){

			log.debug("========财务统计报告画面初期显示处理开始========");
			log.debug("========财务统计报告画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			
			log.debug("========财务统计报告画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========财务统计报告画面再显示处理终了========");
			return mapping.findForward("DISP");
		}if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){

			log.debug("========财务统计处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				
				form = (IGFIN0312Form) req.getSession().getAttribute("IGFIN0312Form");
				if ( form == null ) {
					form = new IGFIN0312Form();
				}
				
			}
			String type = form.getSearchtype();
			
			if("Y".equals(type)){
				
				dto.setBudgetSearchCond(form);
				
				dto = ctlBL.findCountByBudget(dto);
				IGFIN0303VO[] vos = dto.getVos();
				
				if(vos.length == 0){
					req.setAttribute("message", "没有相关信息！");
				}
				req.setAttribute("0312form", form);
				req.setAttribute("vos", vos);
				
			}else if("F".equals(type)){
				
				form.setExopentime(form.getBopentime());
				form.setExclosetime(form.getBclosetime());
				
				dto.setExpenseSearchCond(form);
				dto.setBtype(form.getBtype());
				dto = ctlBL.findCountByExpense(dto);
				IGFIN0303VO[] vos = dto.getVos();
				req.setAttribute("0312form", form);
				req.setAttribute("vos", vos);
				if(vos.length == 0){
					req.setAttribute("message", "没有相关信息！");
				}
				
			}
			log.debug("========业务运行处理终了========");
		}
		
		return mapping.findForward("DISP");
	}

}
