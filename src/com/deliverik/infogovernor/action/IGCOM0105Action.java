/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.bl.IGCOM01BL;
import com.deliverik.infogovernor.dto.IGCOM01DTO;

/**
 * 概述: 首页跳转功能Action
 * 功能描述: 首页跳转功能Action
 * 创建记录: 2012/07/18
 * 修改记录: 
 */
public class IGCOM0105Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCOM0105Action.class);

	/**
	 * 首页跳转功能Action
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.debug("========首页跳转处理开始========");
		//高亮首页链接
		setSessionAttribute(req, "firstactid", "00");
		setSessionAttribute(req, "secondactid", null);
		clearSessionFormData(req);
		IGCOM01BL ctrlBL = (IGCOM01BL) getBean("IGCOM01BL");
		IGCOM01DTO dto = new IGCOM01DTO();
		//跳转标识,从登录页跳转到首页index无值，点击首页链接跳转时index的值为起对应的hpid
		String index = req.getParameter("index");
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		if(StringUtils.isEmpty(index)) {
			//从登录页跳转
			dto.setUser(user);
		} else {
			dto.setUsertype(index);
		}
		ctrlBL.initIGCOM0105Action(dto);
		if(StringUtils.isEmpty(index)) {
			setSessionAttribute(req, "UserPermission", dto.getUserPermission());
		} else {
			//当用户可看见多个首页时，匹配首页超链接的light属性值进行高亮显示
			if(!user.getUsertype().equals(index)) {
				req.setAttribute("light", index);
			}
		}
		/*if(dto.getUserPermission() == null || dto.getUserPermission().getActionSize() == 0){
			addMessage(req, new ActionMessage("IGCOM0101.E005","您没有访问权限，请联系管理员。"));
			return mapping.findForward("NOROLE");
		}*/
		log.debug("========首页跳转处理结束========");
		return new ActionForward(dto.getHomepage());
	}

}
