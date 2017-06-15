/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.smr.bl.IGSMR03BL;
import com.deliverik.infogovernor.smr.dto.IGSMR03DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0301Form;
import com.deliverik.infogovernor.smr.vo.IGSMR03011VO;

/**
 * 概述:我的填报（年报）查询 
 * 功能描述：我的填报（年报）查询 
 * 创建人：赵梓廷
 * 创建记录： 2013-07-25
 * 修改记录：
 */
public class IGSMR0301Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0301Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORM取得
		IGSMR0301Form form = (IGSMR0301Form)actionForm;
				
		//BL取得
		IGSMR03BL ctlBL = (IGSMR03BL) getBean("igSMR03BL");
				
		//DTO生成
		IGSMR03DTO dto = new IGSMR03DTO();
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);
		
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
			log.debug("========年报查询页面显示处理开始========");
			//查询当前登录者需要处理的年报
			dto = ctlBL.needMeManagerAction(dto);
			//实例化vo
			IGSMR03011VO vo = new IGSMR03011VO();
			vo.setMap_arq(dto.getMap_arq());
			super.<IGSMR03011VO>setVO(request, vo);
			log.debug("========年报查询页面显示处理结束========");
		}
		if("FIRSTSEARCH".equals(mapping.getParameter())){
			log.debug("========报表审批查询页面显示处理开始========");
			//查询当前登录者需要处理的年报
			dto = ctlBL.reportExamineAction(dto);
			//实例化vo
			IGSMR03011VO vo = new IGSMR03011VO();
			vo.setMap_first(dto.getMap_first());
			super.<IGSMR03011VO>setVO(request, vo);
			forward = "FIRST";
			log.debug("========报表审批查询页面显示处理结束========");
		}
		if("SECONDSEARCH".equals(mapping.getParameter())){
			log.debug("========年报审批查询页面显示处理开始========");
			//查询当前登录者需要处理的年报
			dto = ctlBL.AnnualreportExamineAction(dto);
			//实例化vo
			IGSMR03011VO vo = new IGSMR03011VO();
			vo.setSecond_list(dto.getSecond_list());
			super.<IGSMR03011VO>setVO(request, vo);
			forward = "SECOND";
			log.debug("========年报审批查询页面显示处理结束========");
		}
		return mapping.findForward(forward);
	}

}
