/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_信息成功后跳转ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSDL0403Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0403Action.class);
	
	/**
	 * <p>
	 * Description: 成功后跳转
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if( "DISP".equals(mapping.getParameter())){
			if (request.getParameter("btn_add_conf")!=null) {
				log.debug("========信息管理========");
				return mapping.findForward("CONF");
			}
			if (request.getParameter("btn_back")!=null) {
				log.debug("========信息添加========");
				return mapping.findForward("BACK");
			}
		}		
		return mapping.findForward(null);
	}
	
}
