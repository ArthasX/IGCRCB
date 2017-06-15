package com.deliverik.infogovernor.drm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.drm.form.IGDRM0415Form;

/**
 * 类型配置信息登录成功后确认画面Action处理
 *
 */
public class IGDRM0415Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0415Action.class);

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
				//配置信息添加画面跳转
				log.debug("========配置信息添加========");
				if("1".equals(((IGDRM0415Form) actionForm).getRoute())){
					req.setAttribute("route", "1");
				}
				return mapping.findForward("BACK");
			}
			if (req.getParameter("btn_next")!=null) {
				//详细信息画面跳转
				log.debug("========详细信息显示========");
				return mapping.findForward("NEXT");
			}
		}		
		return mapping.findForward(null);
	}
}
