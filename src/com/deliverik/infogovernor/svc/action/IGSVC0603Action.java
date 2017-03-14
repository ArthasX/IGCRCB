package com.deliverik.infogovernor.svc.action;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.infogovernor.svc.form.IGSVC0602Form;
import com.deliverik.infogovernor.sym.bl.IGSYM01BL;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;

public class IGSVC0603Action extends BaseAction {

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		
		IGSVC0602Form igsvc0602Form = (IGSVC0602Form)actionForm;
		
		if(StringUtils.isEmpty(igsvc0602Form.getPropentime_from())){
	        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(
	                "yyyy/MM/dd");
	        Calendar c = Calendar.getInstance();
	        c.set(Calendar.DATE, 1);
	        igsvc0602Form.setPropentime_from(df.format(c.getTime()));
	        igsvc0602Form.setPropentime_to(df.format(Calendar.getInstance().getTime()));
		}
		if(req.getParameter("type") != null && "user".equals(req.getParameter("type"))){
			IGSYM01BL ctlBL = (IGSYM01BL) getBean("igsym01BL");
			//ÊµÀý»¯DTO
			IGSYM01DTO dto = new IGSYM01DTO();
			dto = ctlBL.searchOrganizationAll(dto);
			List<Organization> organizationList = dto.getOrganizationList();
			
			req.setAttribute("organizationList", organizationList);
		}
				
		return mapping.findForward("DISP");
	}

}
