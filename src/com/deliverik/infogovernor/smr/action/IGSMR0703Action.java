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
import com.deliverik.infogovernor.smr.form.IGSMR0703Form;
import com.deliverik.infogovernor.smr.vo.IGSMR07031VO;

/**
 * 概述:我的填报（不定期）查询 
 * 功能描述：我的填报（年报）查询 
 * 创建人：赵勇
 * 创建记录： 2013-08-08
 * 修改记录：
 */
public class IGSMR0703Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSMR0703Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORM取得
		IGSMR0703Form form = (IGSMR0703Form)actionForm;
						
		//BL取得
		IGSMR07BL ctlBL = (IGSMR07BL) getBean("igSMR07BL");
						
		//DTO生成
		IGSMR07DTO dto = new IGSMR07DTO();
				
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);
				
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
			log.debug("========填报查询页面显示处理开始========");
			//将form放进dto中
			dto.setIGSMR0703Form(form);
			//查询当前登录者需要处理的年报
			dto = ctlBL.seeFillInAction(dto);
			//实例化vo
			IGSMR07031VO vo = new IGSMR07031VO();
			vo.setMap_see(dto.getMap_see());
			super.<IGSMR07031VO>setVO(request, vo);
			saveToken(request);
			log.debug("========填报审批查询页面显示处理结束========");
		}
		return mapping.findForward(forward);
	}

}
