/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.sta.action;

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
import com.deliverik.infogovernor.sta.form.IGSTA0105Form;
import com.deliverik.infogovernor.sta.vo.IGSTA01051VO;

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

public class IGSTA0105Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSTA0105Action.class);
	
	/**
	 * <p>
	 * Description: 项目统计action处理
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
		IGSTA0105Form form = (IGSTA0105Form)actionForm;
		//获取BL接口实例
		IGSTA01BL ctlBL = (IGSTA01BL) getBean("igsta01BL");
		IGSTA01DTO dto = new IGSTA01DTO();
		
		//实例化DTO
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========项目统计查询画面初期显示处理开始========");
			log.debug("========项目统计查询画面初期显示处理终了========");
		}
		//变更查询
		else if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========项目统计查询处理开始========");
			dto.setIgsta0105Form(form);
			 //分页用DTO取得
            getPaginDTO(request,"IGSTA0105");
            
            PagingDTO pDto;
            
            pDto = (PagingDTO)request.getAttribute("PagingDTO");
          
            if (request.getParameter("PAGING") == null) {
                pDto.setFromCount(0);
                form = (IGSTA0105Form) request.getSession().getAttribute("IGSTA0105Form");
                if (form !=null) {
                    form.setFromCount(0);
                }
            }
            dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchPrjRecAction(dto);
			//构造VO
			IGSTA01051VO vo = new IGSTA01051VO();
			vo.setProjectInfo(dto.getProjectInfo());
			super.<IGSTA01051VO>setVO(request, vo);
			log.debug("========项目统计查询处理终了========");
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
