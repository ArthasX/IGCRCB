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
 * 服务商基本信息成功登录后确认画面Action处理
 *
 */
public class IGASM0903Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0903Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//
		if( "DISP".equals(mapping.getParameter())){
			if (req.getParameter("btn_add_conf")!=null) {
				//服务商配置信息添加画面跳转
				saveToken(req);
				log.debug("========配置信息添加========");
				return mapping.findForward("CONF");
			}
			if (req.getParameter("btn_back")!=null) {
				//服务商基本信息添加画面跳转
				log.debug("========基本信息添加========");
				return mapping.findForward("BACK");
			}
		}		
		return mapping.findForward(null);
	}
}
