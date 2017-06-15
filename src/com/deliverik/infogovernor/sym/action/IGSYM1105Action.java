/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��������_���ݵ�¼�ɹ���ȷ�ϻ���Action����
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM1105Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1105Action.class);

	/**
	 * ���ݵ�¼�ɹ���ȷ�ϻ���Action����
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
				//������ӻ�����ת
				log.debug("========�������========");
				return mapping.findForward("BACK");
			}
			if (req.getParameter("btn_next")!=null) {
				//������ϸ��Ϣ������ת
				log.debug("========������ϸ��Ϣ��ʾ========");
				return mapping.findForward("NEXT");
			}
		}		
		return mapping.findForward(null);
	}
}
