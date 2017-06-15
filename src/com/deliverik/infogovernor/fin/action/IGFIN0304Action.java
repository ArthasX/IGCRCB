/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.fin.bl.IGFIN04BL;
import com.deliverik.infogovernor.fin.dto.IGFIN02DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0303Form;
import com.deliverik.infogovernor.fin.vo.IGFIN0303VO;


public class IGFIN0304Action extends BaseAction {

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		
		IGFIN0303Form form = (IGFIN0303Form)actionForm;
		
		IGFIN02DTO dto = new IGFIN02DTO();
		
		IGFIN04BL ctlBL = (IGFIN04BL) getBean("igfin04BL");
		
		String searchtype = req.getParameter("searchtype");
		String bopentime = req.getParameter("bopentime");
		String bclosetime = req.getParameter("bclosetime");
		String type1 = req.getParameter("type1");
		String flg = req.getParameter("flg");
		
		getPaginDTO(req,"IGFIN0303");
		PagingDTO pDto;
		pDto = (PagingDTO)req.getAttribute("PagingDTO");
		//pDto.setFromCount(form.getFromCount());
		int maxCnt = getMaxDataCount("IGFIN0303");
		
		if("Y".equals(type1)){
			form.setBopentime(bopentime);
			form.setBclosetime(bclosetime);
			form.setBtype(searchtype);
			if("B".equals(flg)){
				dto.setBudgetSearchCond(form);
				dto.setMaxSearchCount(maxCnt);
				dto.setPagingDto(pDto);
				dto = ctlBL.findBudgetByBType(dto);
				IGFIN0303VO vo = new IGFIN0303VO();
				vo.setBudgetList(dto.getBudgetList());
				req.setAttribute("vo", vo);
				return mapping.findForward("BDISP");
			}else if("E".equals(flg)){
				dto.setBudgetSearchCond(form);
				dto.setMaxSearchCount(maxCnt);
				dto.setPagingDto(pDto);
				dto.setBtype(searchtype);
				dto = ctlBL.findExpenseByBType(dto);
				IGFIN0303VO vo = new IGFIN0303VO();
				vo.setExpenseList(dto.getExpenseList());
				req.setAttribute("vo", vo);
				return mapping.findForward("EDISP");
			}
		}else if("F".equals(type1)){
			form.setExopentime(bopentime);
			form.setExclosetime(bclosetime);
			form.setBtype(searchtype);
			if("B".equals(flg)){
				dto.setExpenseSearchCond(form);
				dto.setMaxSearchCount(maxCnt);
				dto.setPagingDto(pDto);
				dto.setBtype(searchtype);
				dto = ctlBL.findBudgetByExpense(dto);
				IGFIN0303VO vo = new IGFIN0303VO();
				vo.setBudgetList(dto.getBudgetList());
				req.setAttribute("vo", vo);
			}else if("E".equals(flg)){
				dto.setExpenseSearchCond(form);
				dto.setMaxSearchCount(maxCnt);
				dto.setPagingDto(pDto);
				dto.setBtype(searchtype);
				dto = ctlBL.findExpenseByExpense(dto);
				IGFIN0303VO vo = new IGFIN0303VO();
				vo.setExpenseList(dto.getExpenseList());
				req.setAttribute("vo", vo);
				return mapping.findForward("EDISP");
			}
		}
		return mapping.findForward("DISP");
	}

}
