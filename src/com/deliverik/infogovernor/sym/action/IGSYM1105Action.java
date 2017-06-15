/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
 * Description: 系统管理_基础数据_数据登录成功后确认画面Action处理
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM1105Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1105Action.class);

	/**
	 * 数据登录成功后确认画面Action处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//
		if( "DISP".equals(mapping.getParameter())){
			if (req.getParameter("btn_add_conf")!=null) {
				//数据添加画面跳转
				log.debug("========数据添加========");
				return mapping.findForward("BACK");
			}
			if (req.getParameter("btn_next")!=null) {
				//数据详细信息画面跳转
				log.debug("========数据详细信息显示========");
				return mapping.findForward("NEXT");
			}
		}		
		return mapping.findForward(null);
	}
}
