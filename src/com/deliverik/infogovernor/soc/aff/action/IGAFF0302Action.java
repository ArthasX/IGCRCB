package com.deliverik.infogovernor.soc.aff.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;

/**
 * 设备影响分析Action处理
 *
 */
public class IGAFF0302Action extends BaseAction {

	static Log log = LogFactory.getLog(IGAFF0302Action.class);

	/**
	 * 拓扑关系展示事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {

		log.debug("==============拓扑关系展示显示开始==============");
		log.debug("==============拓扑关系展示显示结束==============");
		req.setAttribute("EIID_ID", req.getParameter("eiid"));
		req.setAttribute("STORAGE_ID", "Symmetrix ID:"+req.getParameter("storageID"));
		return mapping.findForward("DISP");
	}
}
