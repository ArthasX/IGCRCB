/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.fin.bl.IGFIN03BL;
import com.deliverik.infogovernor.fin.form.IGFIN0301Form;


public class IGFIN0301Action extends BaseAction {



	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		//BL取得
		IGFIN03BL finBL = (IGFIN03BL) getBean("igfin03BL");
		
		IGFIN0301Form igfin0301Form = (IGFIN0301Form)actionForm;
		
		igfin0301Form.setFinxml("");
		
		if( "DISP".equals(mapping.getParameter())){
			
			igfin0301Form.setYear(IGStringUtils.getCurrentYear());
			
			return mapping.findForward("DISP");
			
		}else if("STATISTICS".equals(mapping.getParameter())){

			finBL.getXmlByCondition(igfin0301Form);
			
			return mapping.findForward("DISP");
		}
		
		return mapping.findForward("DISP");
	}
}
