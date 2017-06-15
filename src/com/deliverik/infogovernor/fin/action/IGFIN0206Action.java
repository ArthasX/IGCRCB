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
import com.deliverik.infogovernor.fin.bl.IGFIN02BL;
import com.deliverik.infogovernor.fin.dto.IGFIN02DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0206Form;
import com.deliverik.infogovernor.fin.vo.IGFIN02012VO;


/**
 * 费用查询画面Action处理
 *
 */
public class IGFIN0206Action extends BaseAction {

	static Log log = LogFactory.getLog(IGFIN0206Action.class);

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

		IGFIN0206Form form = (IGFIN0206Form)actionForm;
		
		//BL取得
		IGFIN02BL ctlBL = (IGFIN02BL) getBean("igfin02BL");
		
		//DTO生成
		IGFIN02DTO dto = new IGFIN02DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//费用查询画面初期显示处理
			log.debug("========费用查询画面初期显示处理开始========");
			req.setAttribute("IGFIN0206Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========费用查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//费用查询画面再显示处理
			log.debug("========费用查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========费用查询画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			getPaginDTO(req,"IGFIN0206");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//费用查询处理
			log.debug("========费用查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGFIN0206Form) req.getSession().getAttribute("IGFIN0206Form");
				if ( form == null ) {
					form = new IGFIN0206Form();
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
					form = (IGFIN0206Form) req.getSession().getAttribute("IGFIN0206Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
//			if(form!=null && !"".equals(form.getFromCount())){
//				pDto.setFromCount(form.getFromCount());
//			}else{
//				pDto.setFromCount(0);
//			}
			int maxCnt = getMaxDataCount("IGFIN0206");
			
			//DTO输入参数设定
			dto.setExpenseSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//费用检索逻辑调用
			dto = ctlBL.searchExpenseAction(dto);
			
			//将费用检索结果设定到VO中
			IGFIN02012VO vo = new IGFIN02012VO(dto.getExpenseList());
			
			super.<IGFIN02012VO>setVO(req, vo);
			
			log.debug("========费用查询处理终了========");
		}
		
		if ("EDIT".equals(mapping.getParameter())){
			//费用编辑画面初期处理
			log.debug("========费用编辑画面初期处理开始========");

			//DTO输入参数设定
			dto.setBudget(form);
			
			//费用编辑画面初期处理逻辑调用
			
			log.debug("========费用编辑处理终了========");
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
