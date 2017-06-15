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
import com.deliverik.infogovernor.smr.vo.IGSMR03041VO;

/**
 * 概述:报表显示更多 
 * 功能描述：报表显示更多
 * 创建人：赵梓廷
 * 创建记录： 2013-08-14
 * 修改记录：
 */
public class IGSMR0304Action extends BaseAction {
	static Log log = LogFactory.getLog(IGSMR0304Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {		
		//BL取得
		IGSMR03BL ctlBL = (IGSMR03BL) getBean("igSMR03BL");										
		//DTO生成
		IGSMR03DTO dto = new IGSMR03DTO();								
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);						
		String forward = "DISP";
		if( "DISP".equals(mapping.getParameter())){
			dto = ctlBL.init0304Action(dto);
			//实例化vo
			IGSMR03041VO vo = new IGSMR03041VO();
			vo.setMap_more(dto.getMap_more());
			super.<IGSMR03041VO>setVO(request, vo);
		}
		return mapping.findForward(forward);
	}

}
