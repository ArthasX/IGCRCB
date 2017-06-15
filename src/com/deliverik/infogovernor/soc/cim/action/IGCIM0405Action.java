package com.deliverik.infogovernor.soc.cim.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0405Form;

/**
 * 类型配置信息登录成功后确认画面Action处理
 *
 */
public class IGCIM0405Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0405Action.class);

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
				if("1".equals(((IGCIM0405Form) actionForm).getRoute())){
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
