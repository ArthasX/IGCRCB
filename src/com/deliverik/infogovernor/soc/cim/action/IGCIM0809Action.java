package com.deliverik.infogovernor.soc.cim.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM19BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM19DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0809Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM19011VO;

public class IGCIM0809Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGCIM0809Action.class);
	
	
	private final String forward = "DISP";
	private final String _IGCIM19BL = "igcim19BL";
	private final String _ACTION = "editAction";
	
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		IGCIM19DTO dto = new IGCIM19DTO();
		IGCIM19011VO vo = new IGCIM19011VO();
		IGCIM19BL ctrBL= (IGCIM19BL) getBean(_IGCIM19BL);
		IGCIM0809Form form =(IGCIM0809Form)actionForm;
		String editAction = req.getParameter(_ACTION);
		dto.setIgcim0809Form(form);
		
		if("execut".equals(editAction)){
			String meassage = ctrBL.execut();
			addMessage(req, new ActionMessage(meassage));
		}else{
			String batPath = ResourceUtility.getString("CI_RELATION_BAT_PATH");
			form.setEiname(batPath);
		}
		
		return mapping.findForward(forward);
	}

}
