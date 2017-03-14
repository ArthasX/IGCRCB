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
import com.deliverik.infogovernor.smr.bl.IGSMR07BL;
import com.deliverik.infogovernor.smr.dto.IGSMR07DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0702Form;
import com.deliverik.infogovernor.smr.vo.IGSMR07021VO;

/**
 * 概述:我的填报（不定期报表）查询 
 * 功能描述：我的填报（不定期报表）查询 
 * 创建人：赵勇
 * 创建记录： 2013-08-08
 * 修改记录：
 */
public class IGSMR0702Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0702Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORM取得
		IGSMR0702Form form = (IGSMR0702Form)actionForm;
				
		//BL取得
		IGSMR07BL ctlBL = (IGSMR07BL) getBean("igSMR07BL");
				
		//DTO生成
		IGSMR07DTO dto = new IGSMR07DTO();
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);
		
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
			log.debug("========不定期报表查询页面显示处理开始========");
			//查询当前登录者需要处理的不定期报表
			dto = ctlBL.needMeManagerAction(dto);
			//实例化vo
			IGSMR07021VO vo = new IGSMR07021VO();
			vo.setMap_arq(dto.getMap_arq());
			super.<IGSMR07021VO>setVO(request, vo);
			log.debug("========不定期报表查询页面显示处理结束========");
		}
		if("FIRSTSEARCH".equals(mapping.getParameter())){
			log.debug("========报表审批查询页面显示处理开始========");
			//查询当前登录者需要处理的不定期报表
			dto = ctlBL.reportExamineAction(dto);
			//实例化vo
			IGSMR07021VO vo = new IGSMR07021VO();
			vo.setMap_first(dto.getMap_first());
			super.<IGSMR07021VO>setVO(request, vo);
			forward = "FIRST";
			log.debug("========报表审批查询页面显示处理结束========");
		}
		if("SECONDSEARCH".equals(mapping.getParameter())){
			log.debug("========不定期报表审批查询页面显示处理开始========");
			//查询当前登录者需要处理的不定期报表
			dto = ctlBL.AnnualreportExamineAction(dto);
			//实例化vo
			IGSMR07021VO vo = new IGSMR07021VO();
			vo.setSecond_list(dto.getSecond_list());
			super.<IGSMR07021VO>setVO(request, vo);
			forward = "SECOND";
			log.debug("========不定期报表审批查询页面显示处理结束========");
		}
		return mapping.findForward(forward);
	}

}
