/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.iam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.iam.bl.IGIAM01BL;
import com.deliverik.infogovernor.iam.dto.IGIAM01DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0102Form;
import com.deliverik.infogovernor.iam.vo.IGIAM01011VO;


/**
 * 内审项目Action处理
 *
 * @author
 */
public class IGIAM0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0101Action.class);

	/**
	 * 内审项目查询处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGIAM0102Form form = (IGIAM0102Form)actionForm;
		
		//BL取得
		IGIAM01BL ctlBL = (IGIAM01BL) getBean("igiam01BL");
		
		//DTO生成
		IGIAM01DTO dto = new IGIAM01DTO();
		
		//内审分页查询处理
		if ("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())) {
			log.debug("========内审查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req, "IGIAM0101");			
			PagingDTO pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//由详细画面，编辑画面返回查询画面时的再检索处理
			if ("SEARCH1".equals(mapping.getParameter())){
				form.setIapYear("");
				form.setIapName("");
				form.setIapStatus("");
				form.setIapOpenTimeFrom("");
				form.setIapOpenTimeTo("");
			//进行初次查询处理
			} else {
				//进行分页处理
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGIAM0101");
			//将form封装到dto中
			dto.setIgIAM0102Form(form);
			//将查询结果的结果数封装到dto中
			dto.setMaxSearchCount(maxCnt);
			//将分页实体封装到dto中
			dto.setPagingDto(pDto);
			//审计信息检索逻辑调用
			dto = ctlBL.searchIAMAction(dto);
			//初始化VO
			IGIAM01011VO vo = new IGIAM01011VO();
			//将查询结果封装到VO中
			vo.setInternalauditprjInfoList(dto.getInternalauditprjInfoList());
			//返回VO
			super.<IGIAM01011VO>setVO(req, vo);
			
			log.debug("========内审查询处理结束========");
		}
		//内审工作登记中内审项目弹出页查询
		if ("HELPSEARCH".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req, "IGIAM0101");			
			PagingDTO pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//进行初次查询处理
				//进行分页处理
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					if (form != null) {
						form.setFromCount(0);
					}
				}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGIAM0101");
			//将form封装到dto中
			dto.setIgIAM0102Form(form);
			//将查询结果的结果数封装到dto中
			dto.setMaxSearchCount(maxCnt);
			//将分页实体封装到dto中
			dto.setPagingDto(pDto);

			//审计信息检索逻辑调用
			dto = ctlBL.helpSearch(dto);
			//初始化VO
			IGIAM01011VO vo = new IGIAM01011VO();
			vo.setHelpSearchList(dto.getHelpSearchList());
			//返回VO
			super.<IGIAM01011VO>setVO(req, vo);
		}
		//内审工作登记中内审项目弹出页查询
		if ("PROJECTSEARCH".equals(mapping.getParameter())){
			//将form封装到dto中
			dto.setIgIAM0102Form(form);
			//分页用DTO取得
			getPaginDTO(req, "IGIAM0101");			
			PagingDTO pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//进行初次查询处理
				//进行分页处理
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					if (form != null) {
						form.setFromCount(0);
					}
				}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGIAM0101");
			//将form封装到dto中
			dto.setIgIAM0102Form(form);
			//将查询结果的结果数封装到dto中
			dto.setMaxSearchCount(maxCnt);
			//将分页实体封装到dto中
			dto.setPagingDto(pDto);
			//审计信息检索逻辑调用
			dto = ctlBL.helpSearch(dto);
			//初始化VO
			IGIAM01011VO vo = new IGIAM01011VO();
			vo.setHelpSearchList(dto.getHelpSearchList());
			//返回VO
			super.<IGIAM01011VO>setVO(req, vo);
		}
		//内审确认初始化和返回
		if ("QDISP".equals(mapping.getParameter()) || "QBACK".equals(mapping.getParameter())) {
			if ("QDISP".equals(mapping.getParameter())) {
				form.setIapStatus("1");
			} else {
				form.setIapType("0");
			}
			//分页用DTO取得
			getPaginDTO(req, "IGIAM0101");			
			PagingDTO pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//进行初次查询处理
				//进行分页处理
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					if (form != null) {
						form.setFromCount(0);
					}
				}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGIAM0101");
			//将form封装到dto中
			dto.setIgIAM0102Form(form);
			//将查询结果的结果数封装到dto中
			dto.setMaxSearchCount(maxCnt);
			//将分页实体封装到dto中
			dto.setPagingDto(pDto);
			//审计信息检索逻辑调用
			dto = ctlBL.searchIAMAction(dto);
			//初始化VO
			IGIAM01011VO vo = new IGIAM01011VO();
			//将查询结果封装到VO中
			vo.setInternalauditprjInfoList(dto.getInternalauditprjInfoList());
			//返回VO
			super.<IGIAM01011VO>setVO(req, vo);
		}
		return mapping.findForward("DISP");
	}
}
