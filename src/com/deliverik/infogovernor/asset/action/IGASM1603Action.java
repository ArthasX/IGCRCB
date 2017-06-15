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
 * 数据基本信息成功登录后确认画面Action处理
 *
 */
public class IGASM1603Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1603Action.class);

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
				//数据配置信息添加画面跳转
				saveToken(req);
				log.debug("========配置信息添加========");
				return mapping.findForward("CONF");
			}
			if (req.getParameter("btn_back")!=null) {
				//数据基本信息添加画面跳转
				log.debug("========基本信息添加========");
				return mapping.findForward("BACK");
			}
		}		
		return mapping.findForward(null);
	}
}
