package com.deliverik.infogovernor.dut.action;

/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
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
 * Description: �������_ֵ�����_�ɹ�����תACTION
 * </p>

 */

public class IGDUT0103Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGDUT0103Action.class);
	
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
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if( "DISP".equals(mapping.getParameter())){
			if (request.getParameter("btn_add_conf")!=null) {
				log.debug("========ֵ�������========");
				return mapping.findForward("CONF");
			}
			if (request.getParameter("btn_back")!=null) {
				log.debug("========ֵ�����趨========");
				return mapping.findForward("BACK");
			}
		}		
		return mapping.findForward(null);
	}
	
}
