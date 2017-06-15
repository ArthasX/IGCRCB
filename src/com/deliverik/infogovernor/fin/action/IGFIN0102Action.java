/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.fin.bl.IGFIN01BL;
import com.deliverik.infogovernor.fin.dto.IGFIN01DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0102Form;
import com.deliverik.infogovernor.fin.vo.IGFIN01011VO;
import com.deliverik.infogovernor.fin.vo.IGFIN01013VO;


/**
 * 预算查询画面Action处理
 *
 */
public class IGFIN0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGFIN0102Action.class);

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

		IGFIN0102Form form = (IGFIN0102Form)actionForm;
		
		//BL取得
		IGFIN01BL ctlBL = (IGFIN01BL) getBean("igfin01BL");
		
		//DTO生成
		IGFIN01DTO dto = new IGFIN01DTO();
		//预算年费列表
		List<LabelValueBean> byearList = new ArrayList<LabelValueBean>();
		if( "DISP".equals(mapping.getParameter())){
			//预算查询画面初期显示处理
			log.debug("========预算查询画面初期显示处理开始========");
			req.setAttribute("IGFIN0102Form", form);
			//获取当前年份
			int currentYear = Integer.parseInt(IGStringUtils.getCurrentYear());
			//计算当前年份的前五年及后一年
			for(int i=5;i>0;i--){
				int temp = currentYear - i;
				byearList.add(new LabelValueBean(temp+"",temp+""));
			}
			byearList.add(new LabelValueBean(currentYear+"",currentYear+""));
			byearList.add(new LabelValueBean(currentYear +1+"",currentYear +1+""));

			//存储年份列表
			form.setByear_q(IGStringUtils.getCurrentYear());
			//存储年份列表
			req.setAttribute("byearList", byearList);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========预算查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//预算查询画面再显示处理
			log.debug("========预算查询画面再显示处理开始========");
			//获取当前年份
			int currentYear = Integer.parseInt(IGStringUtils.getCurrentYear());
			//计算当前年份的前五年及后一年
			for(int i=5;i>0;i--){
				int temp = currentYear - i;
				byearList.add(new LabelValueBean(temp+"",temp+""));
			}
			byearList.add(new LabelValueBean(currentYear+"",currentYear+""));
			byearList.add(new LabelValueBean(currentYear +1+"",currentYear +1+""));
			dto.setByearList(byearList);
			//存储年份列表
			form.setByear_q(currentYear+"");
			req.setAttribute("byearList", byearList);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========预算查询画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			getPaginDTO(req,"IGFIN0102");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			//预算查询处理
			log.debug("========预算查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGFIN0102Form) req.getSession().getAttribute("IGFIN0102Form");
				if ( form == null ) {
					form = new IGFIN0102Form();
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
					form = (IGFIN0102Form) req.getSession().getAttribute("IGFIN0102Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			
			int maxCnt = getMaxDataCount("IGFIN0102");
			//DTO输入参数设定
			dto.setBudgetSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//预算检索逻辑调用
			dto = ctlBL.searchBudgetAction(dto);

			//将预算检索结果设定到VO中
			IGFIN01011VO vo = new IGFIN01011VO();
			vo.setBudgetFormList(dto.getBudgetFormList());
			//获取当前年份
			int currentYear = Integer.parseInt(IGStringUtils.getCurrentYear());
			//计算当前年份的前五年及后一年
			for(int i=5;i>0;i--){
				int temp = currentYear - i;
				byearList.add(new LabelValueBean(temp+"",temp+""));
			}
			byearList.add(new LabelValueBean(currentYear+"",currentYear+""));
			byearList.add(new LabelValueBean(currentYear +1+"",currentYear +1+""));
			//存储年份列表
			if(null==form.getByear_q()){
				form.setByear_q(IGStringUtils.getCurrentYear());
			}
			
			req.setAttribute("byearList", byearList);
			super.<IGFIN01011VO>setVO(req, vo);
			
			log.debug("========预算查询处理终了========");
		}
		if ("EDIT".equals(mapping.getParameter())){
			//预算编辑画面初期处理
			log.debug("========预算编辑画面初期处理开始========");
			//获取当前年份
			int currentYear = Integer.parseInt(IGStringUtils.getCurrentYear());
			//计算当前年份的前五年及后一年
			for(int i=5;i>0;i--){
				int temp = currentYear - i;
				byearList.add(new LabelValueBean(temp+"",temp+""));
			}
			byearList.add(new LabelValueBean(currentYear+"",currentYear+""));
			byearList.add(new LabelValueBean(currentYear +1+"",currentYear +1+""));
			//存储年份列表
			req.setAttribute("byearList", byearList);
//			//DTO输入参数设定
			dto.setIgfin0102Form(form);
			dto = ctlBL.initIGFIN0102Action(dto);
			//预算编辑画面初期处理逻辑调用
			log.debug("========预算编辑处理终了========");
		}

		if ("UPDATE".equals(mapping.getParameter())){
			
			//预算变更处理
			log.debug("========预算变更处理开始========");
			//获取当前年份
			int currentYear = Integer.parseInt(IGStringUtils.getCurrentYear());
			//计算当前年份的前五年及后一年
			for(int i=5;i>0;i--){
				int temp = currentYear - i;
				byearList.add(new LabelValueBean(temp+"",temp+""));
			}
			byearList.add(new LabelValueBean(currentYear+"",currentYear+""));
			byearList.add(new LabelValueBean(currentYear +1+"",currentYear +1+""));
			//存储年份列表
			form.setByear_q(currentYear+"");
			req.setAttribute("byearList", byearList);
			//DTO输入参数设定
			form.setBamount(Double.parseDouble(form.getBamount_show()));//将用于格式化显示的项目金额赋值给form中的属性
			dto.setIgfin0102Form(form);
			dto.setBudget(form);
			
			//预算变更逻辑调用
			dto = ctlBL.updateBudgetAction(dto);
			/**执行修改后按钮显示标识*/
			form.setUpdateShow("show");
			log.debug("========预算变更处理终了========");
			
		}
		if ("PROJECTSEARCH".equals(mapping.getParameter())){
			dto.setIgfin0102Form(form);
			//项目登记中预算集合显示查找
			dto = ctlBL.initProjectBudgetList(dto);
			IGFIN01013VO vo = new IGFIN01013VO();
			vo.setPbsummaryList(dto.getPbsummaryList());
			super.<IGFIN01013VO>setVO(req, vo);
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
