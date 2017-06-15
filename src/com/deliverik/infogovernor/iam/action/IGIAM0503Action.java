/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.iam.action;

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
import com.deliverik.infogovernor.iam.bl.IGIAM05BL;
import com.deliverik.infogovernor.iam.dto.IGIAM05DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0503Form;
import com.deliverik.infogovernor.iam.vo.IGIAM050301VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_审计项目相关问题查询_查询ACTION
 * </p>
 * 
 * @author zhaomin
 * @version 1.0
 */

public class IGIAM0503Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGIAM0503Action.class);
	
	/**
	 * <p>
	 * Description: 审计项目相关问题查询action处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author zhaomin
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGIAM0503Form form = (IGIAM0503Form)actionForm;
		//获取BL接口实例
		IGIAM05BL ctlBL = (IGIAM05BL) getBean("igiam05BL");

		//实例化DTO
		IGIAM05DTO dto = new IGIAM05DTO();
		//变更查询
		if( "SEARCH".equals(mapping.getParameter())|| "SEARCH1".equals(mapping.getParameter())){
			log.debug("========审计项目相关问题查询处理开始========");
			getPaginDTO(request, "IGIAM0503");	
			PagingDTO pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
                //由详细画面，编辑画面返回查询画面时的再检索处理
                form = (IGIAM0503Form) request.getSession().getAttribute("IGIAM0503Form");
                if ( form == null ) {
                    form = new IGIAM0503Form();
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
                    form = (IGIAM0503Form) request.getSession().getAttribute("IGIAM0503Form");
                    if (form !=null) {
                        form.setFromCount(0);
                    }
                 }
            }
			
			
			int maxCnt = getMaxDataCount("IGIAM0503");
			form.setFromCount(0);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setIgiam0503Form(form);
			//调用BL查询
			dto = ctlBL.getProcessRecords(dto);
			//构造VO
			IGIAM050301VO vo = new IGIAM050301VO(dto.getProcessInfos());
			super.<IGIAM050301VO>setVO(request, vo);
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			log.debug("========审计项目相关问题查询处理终了========");
		} 
		return mapping.findForward("DISP");
	}
}
