/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.dbs.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.dbs.bl.IGDBS02BL;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCondImpl;

/**
 * @概述SOC EMC运维管理存储性能总图action
 * @功能描述
 * @创建记录：杨亮 2011/01/06
 * @修改记录：崔龙 2011/08/08
 * @version 1.0
 */

public class IGDBS0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBS0201Action.class);

	/**
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		// 画面跳转设定
		String forward = "DISP";
		String strxml = "";
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========设置EMC运维管理存储管理平台性能总图处理开始========");
			String dataid = (String) req.getParameter("dataid");
			IGDBS02BL igdbm02bl = (IGDBS02BL) getBean("igDBS02BL");

			//获取性能总图的类型
			String type = (String) req.getParameter("type");
			Collect_BusySearchCondImpl cond = new Collect_BusySearchCondImpl();

			cond.setDataid(dataid);

			SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy/MM/dd");
			Date d = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			int day = c.get(Calendar.DAY_OF_MONTH);
			c.set(Calendar.DAY_OF_MONTH, day - 2);
			Date new_time = c.getTime();
			String lastdate = sdfTime.format(new_time);
			cond.setDate_from(lastdate + " 00:00");
			cond.setDate_to(lastdate + " 23:59");
			//判断跳转性能总图的处理方式 (如果获取的类型等于CX时，则显示CX性能总图)
			if (StringUtils.isNotEmpty(type)
					&& "CX".equals(type)) {
				strxml = igdbm02bl.initCXXml(cond);
				req.setAttribute("type", type);
			} else {
				String version = igdbm02bl.getSymm_version(dataid);
				String model = igdbm02bl.getSymm_model(dataid);
				cond.setSymm_model(model);
				strxml = igdbm02bl.initXml(cond);
				req.setAttribute("type", dataid);
				req.setAttribute("symm_version", version);
				req.setAttribute("symm_model", model);
			}

			req.setAttribute("strXML", strxml);

			log.debug("========设置EMC运维管理存储管理平台性能总图处理终了========");
			Locale currentLocale = (Locale) req.getSession().getAttribute(
					Globals.LOCALE_KEY);
			if ("en".equals(currentLocale.getLanguage())) {
				return mapping.findForward("DISP_EN");
			}
			return mapping.findForward(forward);
		}
		return mapping.findForward(forward);
	}
}
