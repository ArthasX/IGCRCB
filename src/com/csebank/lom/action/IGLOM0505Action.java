/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM05BL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0505Form;
import com.csebank.lom.vo.IGLOM05051VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 食堂管理_工作餐收益统计管理_统计查询ACTION
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0505Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0505Action.class);
	
	/**
	 * <p>
	 * Description:工作餐收益统计查询ACTION处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author wuzhenqiu@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGLOM0505Form form = (IGLOM0505Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========工作餐收益统计查询画面初期显示处理开始========");
			form.setYear(IGStringUtils.getCurrentYear());
			form.setMonth(IGStringUtils.getCurrentDate().substring(5,7));
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========工作餐收益统计查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	
		//获取BL接口实例
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		//实例化DTO
		IGLOM05DTO dto = new IGLOM05DTO();
		//统计查询
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========工作餐收益统计查询处理开始========");
			
			dto.setWorkLunchEaterySearchCond(form);
			dto.setIglom0505Form(form);
			form.setDetail("");
			//调用BL查询
			dto = ctlBL.searchWorkLunchEateryAction(dto);
			
			//构造VO
			IGLOM05051VO vo = new IGLOM05051VO();
			vo.setMap(dto.getMapel());
			super.<IGLOM05051VO>setVO(request, vo);
			log.debug("========工作餐收益统计查询处理终了========");
			
		}else if( "REPORT".equals(mapping.getParameter())){
			log.debug("========工作餐收益统计查询处理开始========");
			dto.setWorkLunchEaterySearchCond(form);
			dto.setIglom0505Form(form);
			if("D".equals(form.getDetail())){
				form.setSearchtype("D");
			}
			//调用BL查询
			dto = ctlBL.searchWorkLunchEateryAction(dto);
			if("D".equals(form.getDetail())){
				IGLOM05051VO vo = new IGLOM05051VO();
				vo.setWorkLunchEateryList(dto.getWorkLunchEateryList());
				super.<IGLOM05051VO>setVO(request, vo);
				form.setYearD(request.getSession().getAttribute("ADedate").toString().substring(0,4));
				form.setMonthD(request.getSession().getAttribute("ADedate").toString().substring(5,7));
				request.setAttribute("form", form);
				request.setAttribute("IGLOM05051VO", vo);
			}else{
				//构造VO
				IGLOM05051VO vo = new IGLOM05051VO();
				vo.setMap(dto.getMapel());
				super.<IGLOM05051VO>setVO(request, vo);
				
				request.setAttribute("form", form);
				request.setAttribute("IGLOM05051VO", vo);
			}
			
			log.debug("========工作餐收益统计查询处理终了========");
			return mapping.findForward("REPORT");

		}else if( "DETAIL".equals(mapping.getParameter())){
			log.debug("========工作餐收益统计明细查询处理开始========");
			form.setSearchtype("D");
			dto.setWorkLunchEaterySearchCond(form);
			dto.setIglom0505Form(form);
			form.setDetail("D");
			//调用BL查询
			dto = ctlBL.searchWorkLunchEateryAction(dto);
			
			//构造VO
			IGLOM05051VO vo = new IGLOM05051VO();
			vo.setWorkLunchEateryList(dto.getWorkLunchEateryList());
			request.setAttribute("edate", form.getEdate());
			request.getSession().setAttribute("ADedate", form.getEdate());
			super.<IGLOM05051VO>setVO(request, vo);
			
			log.debug("========工作餐收益统计明细查询处理终了========");
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
