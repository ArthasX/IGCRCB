/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.mnt.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;

/**
 * 概述: flash跳转页
 * 功能描述: flash跳转页
 * 创建记录: 2012/05/17
 * 修改记录: 
 */
public class IGMNT0108Action extends BaseAction{

	static Log log = LogFactory.getLog(IGMNT0107Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm arg1,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		log.debug("=============显示DMXRealTime开始=============");
		//请求转发
		//req.getRequestDispatcher("mnt/IGMNT0108.jsp").forward(req, resp);
		log.debug("=============显示DMXRealTime终了=============");
		return mapping.findForward("DISP");
	}

}
