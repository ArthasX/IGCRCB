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
 * ���˹�ϵչʾAction����
 *
 */
public class IGCIM0100Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0100Action.class);

	/**
	 * ���˹�ϵչʾ�¼�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {

		log.debug("==============���˹�ϵչʾ��ʾ��ʼ==============");
		log.debug("==============���˹�ϵչʾ��ʾ����==============");
		req.setAttribute("EIID_ID", req.getParameter("eiid"));
		req.setAttribute("STORAGE_ID", "Symmetrix ID:"+req.getParameter("storageID"));
		return mapping.findForward("DISP");
	}
}
