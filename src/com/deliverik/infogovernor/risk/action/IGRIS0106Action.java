/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;

/**
 * 审计项基本信息成功登录后确认画面Action处理
 *
 */
public class IGRIS0106Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0106Action.class);

	/**
	 * 成功处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {

		if( "DISP".equals(mapping.getParameter())){
			if (req.getParameter("btn_add")!=null) {
				//审计项信息添加画面跳转
				log.debug("========审计项信息添加========");
				return mapping.findForward("ADD");
			}
			if (req.getParameter("btn_search")!=null) {
				//审计项列表画面跳转
				log.debug("========审计项列表========");
				return mapping.findForward("SEARCH");
			}
		}		
		return mapping.findForward(null);
	}
}
