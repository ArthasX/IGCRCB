/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.sta.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.deliverik.infogovernor.sta.bl.IGSTA01BL;
import com.deliverik.infogovernor.sta.dto.IGSTA01DTO;
import com.deliverik.infogovernor.sta.form.IGSTA0102Form;
import com.deliverik.infogovernor.sta.vo.IGSTA0102VO;
import com.deliverik.infogovernor.svc.vo.IGSVC11011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_问题整改管理_查询ACTION
 * </p>
 * 
 * @author 
 * @version 1.0
 */

public class IGSTA0102Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSTA0102Action.class);
	
	/**
	 * <p>
	 * Description: 问题整改action处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author huiyongzhi
	 * @update
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGSTA0102Form form = (IGSTA0102Form)actionForm;
		//获取BL接口实例
		IGSTA01BL ctlBL = (IGSTA01BL) getBean("igsta01BL");
		if(form == null){
			request.setAttribute("prstatusValue","");
		}else{
			if(form.getPrstatus()!=null){
				request.setAttribute("prstatusValue",form.getPrstatus());
			}else{
				request.setAttribute("prstatusValue","");
			}
		}
		//实例化DTO
		IGSTA01DTO dto = new IGSTA01DTO();
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========问题整改查询画面初期显示处理开始========");
			IGSVC11011VO vo = new IGSVC11011VO();
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			Calendar c = Calendar.getInstance();
			c.set(Calendar.DATE, 1);
			int year = c.get(c.YEAR);
			// 起始时间为默认当前工作日的年初日
			form.setPropentime_from(String.valueOf(year+"/01/01"));
			// 截止日默认为当前工作日
			form.setPropentime_to(df.format(Calendar.getInstance().getTime()));
			
			super.<IGSVC11011VO>setVO(request, vo);
			request.setAttribute("vo", vo);
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========问题整改查询画面初期显示处理终了========");
		}
		//变更查询
		else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========问题整改查询处理开始========");
//			form.setPrtype(IGPROCESSType.PROBLEM_EXAMINE);
			//获取分页Bean
			getPaginDTO(request,"IGSVC1101");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				form = (IGSTA0102Form) request.getSession().getAttribute("IGSTA0102Form");
				if ( form== null){
					form = new IGSTA0102Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGSTA0102Form) request.getSession().getAttribute("IGSTA0102Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			int maxCnt = getMaxDataCount("IGSVC1101");
			dto.setIgsta0102Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchRiskcheckproblemsuperviseAction(dto);
			//构造VO
			IGSTA0102VO vo = new IGSTA0102VO();
			vo.setRiskCheckProblemSuperviseVWList(dto.getRiskCheckProblemSuperviseVWList());
			super.<IGSTA0102VO>setVO(request, vo);
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			log.debug("========问题整改查询处理终了========");
		}
		return mapping.findForward("DISP");
	}
}
