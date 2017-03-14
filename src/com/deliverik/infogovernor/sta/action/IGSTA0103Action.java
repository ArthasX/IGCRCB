/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.sta.action;

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
import com.deliverik.infogovernor.sta.form.IGSTA0103Form;
import com.deliverik.infogovernor.sta.vo.IGSTA01031VO;

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

public class IGSTA0103Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSTA0103Action.class);
	
	/**
	 * <p>
	 * Description: 合同统计action处理
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
		IGSTA0103Form form = (IGSTA0103Form)actionForm;
		//获取BL接口实例
		IGSTA01BL ctlBL = (IGSTA01BL) getBean("igsta01BL");
		IGSTA01DTO dto = new IGSTA01DTO();
		//查询合同模型
		ctlBL.getContractLabel(dto);
		request.setAttribute("contractLabel", dto.getContractType());
		
		//实例化DTO
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========合同统计查询画面初期显示处理开始========");
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			form.setCurYear(String.valueOf(year));
			log.debug("========合同统计查询画面初期显示处理终了========");
		}
		//变更查询
		else if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========合同统计查询处理开始========");
			dto.setIgsta0103Form(form);
			
			//调用BL查询
			dto = ctlBL.searchContractAmountAction(dto);
			//构造VO
			IGSTA01031VO vo = new IGSTA01031VO();
			vo.setContracts(dto.getContracts());
			super.<IGSTA01031VO>setVO(request, vo);
			log.debug("========合同统计查询处理终了========");
		}
		else if("FETCH".equals(mapping.getParameter())){
		    log.debug("========合同统计钻取查询处理开始========");
		    
		    //分页用DTO取得
            getPaginDTO(request,"IGSTA0103");
            
            PagingDTO pDto;
            
            pDto = (PagingDTO)request.getAttribute("PagingDTO");
          
            if (request.getParameter("PAGING") == null) {
                pDto.setFromCount(0);
                form = (IGSTA0103Form) request.getSession().getAttribute("IGSTA0103Form");
                if (form !=null) {
                    form.setFromCount(0);
                }
            }
            dto.setIgsta0103Form(form);
            dto.setPagingDto(pDto);
            
		    //调用BL查询
		    dto = ctlBL.searchEntityItemAction(dto);
		    //构造VO
		    IGSTA01031VO vo = new IGSTA01031VO();
		    vo.setEntityItemCompactVWInfoList(dto.getEntityItemCompactVWInfoList());
		    super.<IGSTA01031VO>setVO(request, vo);
		    log.debug("========合同统计钻取查询处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
		    for (ActionMessage message : messageList) {	
		        addMessage(request, message);
		    }
		}
		return mapping.findForward("DISP");
	}
}
