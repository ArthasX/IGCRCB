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
 * ���յ������Ϣ�ɹ���¼��ȷ�ϻ���Action����
 *
 */
public class IGASM2703Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2703Action.class);

	/**
	 * �¼�����
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
				//���յ�������Ϣ��ӻ�����ת
				log.debug("========������Ϣ���========");
				saveToken(req);
				return mapping.findForward("CONF");
			}
			if (req.getParameter("btn_back")!=null) {
				//���յ������Ϣ��ӻ�����ת
				log.debug("========������Ϣ���========");
				return mapping.findForward("BACK");
			}
		}		
		return mapping.findForward(null);
	}
}
