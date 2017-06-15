/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;

/**
 * @topo map
 * @version 1.0
 */

public class IGDBM0111Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0110Action.class);
	
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//画面跳转设定
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========topo map初期显示处理开始========");
			log.debug("========topo map初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		return mapping.findForward(forward);
	}
}
