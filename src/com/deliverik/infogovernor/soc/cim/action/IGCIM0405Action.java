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
 * ����������Ϣ��¼�ɹ���ȷ�ϻ���Action����
 *
 */
public class IGCIM0405Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0405Action.class);

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
				//������Ϣ��ӻ�����ת
				log.debug("========������Ϣ���========");
				if("1".equals(((IGCIM0405Form) actionForm).getRoute())){
					req.setAttribute("route", "1");
				}
				return mapping.findForward("BACK");
			}
			if (req.getParameter("btn_next")!=null) {
				//��ϸ��Ϣ������ת
				log.debug("========��ϸ��Ϣ��ʾ========");
				return mapping.findForward("NEXT");
			}
		}		
		return mapping.findForward(null);
	}
}
