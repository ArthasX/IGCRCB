/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;

/**
 * @Description: ģ̬ҳAction����
 * @Author
 * @History 
 * @Version
 */
public class IGSMR0200Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0200Action.class);
	

	/**
	 * �¼�����
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.debug("========ģ̬ҳ��ʾ����ʼ ========");
		log.debug("========ģ̬ҳ��ʾ�������========");
		return mapping.findForward("DISP");
	}
}
