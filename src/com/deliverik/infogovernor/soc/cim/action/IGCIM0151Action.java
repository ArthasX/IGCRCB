/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0151Form;

/**
 * 概述: 阜新拓扑，应用详细Action
 * 功能描述: 阜新拓扑，应用详细Action
 * 创建记录: 2013/10/25
 * 修改记录: 
 */
public class IGCIM0151Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0151Action.class);

	/**
	 * 应用详细显示处理
	 *
	 * @param mapping ActionMapping 
	 * @param actionForm ActionForm 
	 * @param req HttpServletRequest 
	 * @param res HttpServletResponse 
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGCIM0151Form form = (IGCIM0151Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========画面初期显示处理开始========");
			
			
			log.debug("========画面初期显示处理终了========");
		}
		return mapping.findForward("DISP");
	}
}
