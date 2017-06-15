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
 * Description: 系统管理_基础数据_数据分类信息成功登录后确认画面Action处理
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM1103Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1103Action.class);

	/**
	 * 数据分类信息成功登录后确认画面Action处理
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
			if (req.getParameter("btn_add_conf")!=null) {
				//数据添加画面跳转
				log.debug("========配置信息添加========");
				return mapping.findForward("CONF");
			}
			if (req.getParameter("btn_back")!=null) {
				//数据分类列表画面跳转
				log.debug("========基本信息添加========");
				return mapping.findForward("BACK");
			}
		}		
		return mapping.findForward(null);
	}
}
