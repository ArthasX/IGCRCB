/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;

/**
 * ����Ϣ������Ϣ�ɹ���¼��ȷ�ϻ���Action����
 *
 */
public class IGPRD0112Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0112Action.class);

	/**
	 * �ɹ�����
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
			if (req.getParameter("btn_add")!=null) {
				//״̬��Ϣ��ӻ�����ת
				log.debug("========״̬��Ϣ���========");
				return mapping.findForward("ADD");
			}
			if (req.getParameter("btn_search")!=null) {
				//������Ϣ��ӻ�����ת
				log.debug("========������Ϣ���========");
				return mapping.findForward("SEARCH");
			}
		}		
		return mapping.findForward(null);
	}
}
