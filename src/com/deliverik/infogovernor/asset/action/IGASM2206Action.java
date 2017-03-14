/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
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
 * ����: CI���������Ϣ�Ǽǳɹ�����Action����
 * ��������: CI���������Ϣ�Ǽǳɹ�����Action����
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
public class IGASM2206Action extends BaseAction{
	static Log log = LogFactory.getLog(IGASM2206Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		if( "DISP".equals(mapping.getParameter())){
			if (req.getParameter("btn_add_conf")!=null) {
				//CI���������Ϣ��ӻ�����ת
				saveToken(req);
				log.debug("========CI���������Ϣ���========");
				return mapping.findForward("CONF");
			}
			if (req.getParameter("btn_back")!=null) {
				//CI���������Ϣ����������ת
				log.debug("========CI���������Ϣ����========");
				return mapping.findForward("BACK");
			}
		}		
		return mapping.findForward(null);
	}
}
