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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.fin.bl.IGFIN01BL;
import com.deliverik.infogovernor.fin.dto.IGFIN01DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0202Form;
import com.deliverik.infogovernor.fin.vo.IGFIN02011VO;


/**
 * 预算查询画面Action处理
 *
 */
public class IGFIN0202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGFIN0202Action.class);

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
	@SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {

		IGFIN0202Form form = (IGFIN0202Form)actionForm;
		
		//BL取得
		IGFIN01BL ctlBL = (IGFIN01BL) getBean("igfin01BL");
		
		//DTO生成
		IGFIN01DTO dto = new IGFIN01DTO();

		if( "DISP".equals(mapping.getParameter())){
			//预算查询画面初期显示处理
			log.debug("========预算查询画面初期显示处理开始========");
			req.setAttribute("IGFIN0202Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","预算信息"));
			log.debug("========预算查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//预算查询画面再显示处理
			log.debug("========预算查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========预算查询画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			getPaginDTO(req,"IGFIN0202");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//预算查询处理
			log.debug("========预算查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGFIN0202Form) req.getSession().getAttribute("IGFIN0202Form");
				if ( form == null ) {
					form = new IGFIN0202Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGFIN0202Form) req.getSession().getAttribute("IGFIN0202Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGFIN0202");
			
			form.setBstatus("O");
			
			//DTO输入参数设定
			dto.setBudgetSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//预算检索逻辑调用
			dto = ctlBL.searchBudgetAction(dto);
			
			//将预算检索结果设定到VO中
			IGFIN02011VO vo = new IGFIN02011VO(dto.getBudgetList());
			
			super.<IGFIN02011VO>setVO(req, vo);
			
			log.debug("========预算查询处理终了========");
		}
		
		if ("EDIT".equals(mapping.getParameter())){
			//预算编辑画面初期处理
			log.debug("========预算编辑画面初期处理开始========");

			//DTO输入参数设定
			dto.setBudget(form);
			
			//预算编辑画面初期处理逻辑调用
			
			log.debug("========预算编辑处理终了========");
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
