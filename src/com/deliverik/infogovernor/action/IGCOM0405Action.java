/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.bl.IGCOM04BL;
import com.deliverik.infogovernor.dto.IGCOM01DTO;
import com.deliverik.infogovernor.dto.IGCOM04DTO;
import com.deliverik.infogovernor.vo.IGCOM04051VO;

/**
 * @Description: 业务人员首页用Action处理
 * 
 */
public class IGCOM0405Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0405Action.class);

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		IGCOM01DTO dto = new IGCOM01DTO();
		User user = (User) req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		IGCOM04BL igcom04BL = (IGCOM04BL) getBean("igcom04BL");
		IGCOM04DTO igcom04DTO = new IGCOM04DTO();
		igcom04DTO.setUserId(user.getUserid());
		IGCOM04051VO vo = new IGCOM04051VO();
		// 取得首页相关信息
		igcom04BL.initIGCOM0405Action(igcom04DTO, vo);
		super.<IGCOM04051VO>setVO(req, vo);
		return mapping.findForward("SUCCESS");
	}

}
