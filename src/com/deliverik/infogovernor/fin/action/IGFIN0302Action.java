/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.fin.form.IGFIN0312Form;


public class IGFIN0302Action extends BaseAction {

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		
		IGFIN0312Form  form = (IGFIN0312Form)actionForm;
		
		if(StringUtils.isEmpty(form.getBopentime())){
	        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(
	                "yyyy/MM/dd");
	        Calendar c = Calendar.getInstance();
	        c.set(Calendar.DATE, 1);
	        form.setBopentime(df.format(c.getTime()));
	        form.setBclosetime(df.format(Calendar.getInstance().getTime()));
		}		
		return mapping.findForward("DISP");
	}

}
