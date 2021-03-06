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

/**
 * 概述: 审计任务信息登记成功画面Action处理
 * 功能描述: 审计任务信息登记成功画面Action处理
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
public class IGCIM0306Action extends BaseAction{
	static Log log = LogFactory.getLog(IGCIM0306Action.class);

	/**
	 * 事件处理
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
		if( "DISP".equals(mapping.getParameter())){
			if (req.getParameter("btn_add_conf")!=null) {
				//审计任务信息添加画面跳转
				saveToken(req);
				log.debug("========审计任务信息添加========");
				return mapping.findForward("CONF");
			}
			if (req.getParameter("btn_back")!=null) {
				//审计任务信息检索画面跳转
				log.debug("========审计任务信息检索========");
				return mapping.findForward("BACK");
			}
		}		
		return mapping.findForward(null);
	}
}
