package com.deliverik.infogovernor.prr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.prr.form.IGPRR0102Form;

public class IGPRR0100Action extends BaseAction {

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		IGPRR0102Form form = (IGPRR0102Form)actionForm;
		if("DISP".equals(mapping.getParameter())){
			clearSessionFormData(request);
		}
		return mapping.findForward("DISP");
	}

}
