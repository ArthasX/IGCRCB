/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;

/**
 * ��Ʒ��������Ϣ�ɹ���¼��ȷ�ϻ���Action����
 *
 */
public class IGRIS0111Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0111Action.class);

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
				//������Ϣ��ӻ�����ת
				log.debug("========������Ϣ���========");
				return mapping.findForward("ADD");
			}
			if (req.getParameter("btn_search")!=null) {
				//��Ʒ����б�����ת
				log.debug("========��Ʒ����б�========");
				return mapping.findForward("SEARCH");
			}
		}		
		return mapping.findForward(null);
	}
}
