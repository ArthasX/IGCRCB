/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0151Form;

/**
 * ����: �������ˣ�Ӧ����ϸAction
 * ��������: �������ˣ�Ӧ����ϸAction
 * ������¼: 2013/10/25
 * �޸ļ�¼: 
 */
public class IGCIM0151Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0151Action.class);

	/**
	 * Ӧ����ϸ��ʾ����
	 *
	 * @param mapping ActionMapping 
	 * @param actionForm ActionForm 
	 * @param req HttpServletRequest 
	 * @param res HttpServletResponse 
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGCIM0151Form form = (IGCIM0151Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========���������ʾ����ʼ========");
			
			
			log.debug("========���������ʾ��������========");
		}
		return mapping.findForward("DISP");
	}
}
