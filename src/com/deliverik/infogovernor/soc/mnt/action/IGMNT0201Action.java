/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
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
 * 概述:画面跳转Action
 * 功能描述：1.画面跳转
 * 创建记录：张楠    2012/02/09
 */
public class IGMNT0201Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGMNT0201Action.class);

	/**
	 * 画面跳转
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
		String forward=null;
		if("DISP".equals(mapping.getParameter())){
			if (req.getParameter("btn_back")!=null) {
				log.debug("========界面跳转开始========");
				String flag = String.valueOf(req.getSession().getAttribute("flag"));
				if("0".equals(flag)){//监控类型管理画面
					forward="BACK0";
				}else{//监控对象管理画面
					forward="BACK1";
				}
				log.debug("========界面跳转结束========");
			}
			if (req.getParameter("btn_add")!=null) {
				//监控对象添加画面跳转
				log.debug("========监控对象添加画面跳转开始========");
				forward="ADD";
				log.debug("========监控对象添加画面跳转结束========");
			}
		}		
		return mapping.findForward(forward);
	}
}
