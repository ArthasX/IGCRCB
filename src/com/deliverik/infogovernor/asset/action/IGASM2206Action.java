/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;

/**
 * 概述: CI变更任务信息登记成功画面Action处理
 * 功能描述: CI变更任务信息登记成功画面Action处理
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
public class IGASM2206Action extends BaseAction{
	static Log log = LogFactory.getLog(IGASM2206Action.class);

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
				//CI变更任务信息添加画面跳转
				saveToken(req);
				log.debug("========CI变更任务信息添加========");
				return mapping.findForward("CONF");
			}
			if (req.getParameter("btn_back")!=null) {
				//CI变更任务信息检索画面跳转
				log.debug("========CI变更任务信息检索========");
				return mapping.findForward("BACK");
			}
		}		
		return mapping.findForward(null);
	}
}
