/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.action;

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
 * Description: �ۺϹ���_ʳ�óɱ��Ǽ�_�ɹ�����תACTION
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0570Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0570Action.class);
	
	/**
	 * <p>
	 * Description: �ɹ�����ת
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if( "DISP".equals(mapping.getParameter())){
			if (request.getParameter("btn_add_conf")!=null) {
				log.debug("========ʳ����Ϣ����========");
				return mapping.findForward("CONF");
			}
			if (request.getParameter("btn_back")!=null) {
				log.debug("========ʳ����Ϣ���========");
				return mapping.findForward("BACK");
			}
		}		
		return mapping.findForward(null);
	}
	
}
