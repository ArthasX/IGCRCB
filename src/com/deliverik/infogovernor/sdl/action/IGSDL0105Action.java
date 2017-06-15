/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.sdl.form.IGSDL0105Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ѡ��ACTION
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

public class IGSDL0105Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0105Action.class);
	
	/**
	 * <p>
	 * Description:����ѡ��ACTION����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author sunkaiyu@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		log.debug("========������ʾ��ʼ========");

		if("show_date".equals(mapping.getParameter())){
			clearSessionFormData(request);
			
			IGSDL0105Form form = (IGSDL0105Form)actionForm;
			String forward = form.getForward();
			Integer year = form.getYear();
			Integer month = form.getMonth();
			if("back".equals(forward)){
				if(month == 0){
					request.setAttribute("year", year - 1);
					request.setAttribute("month", 11);
				} else {
					request.setAttribute("year", year);
					request.setAttribute("month", month - 1);
				}
			} else if ("next".equals(forward)){
				if(month >= 11){
					request.setAttribute("year", year + 1);
					request.setAttribute("month", 0);
				} else {
					request.setAttribute("year", year);
					request.setAttribute("month", month + 1);
				}
			}
		}
		
		log.debug("========������ʾ����========");
		return mapping.findForward("DISP");
		
	}

}
