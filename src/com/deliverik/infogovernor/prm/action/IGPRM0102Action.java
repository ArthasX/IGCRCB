/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.prm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.prm.bl.IGPRM01BL;
import com.deliverik.infogovernor.prm.dto.IGPRM01DTO;
import com.deliverik.infogovernor.prm.form.IGPRM0102Form;

public class IGPRM0102Action extends BaseAction {

	/**
	 * <p>
	 * Title : InfoGovernor ��Ϣ�������ƽ̨
	 * </p>
	 * <p>
	 * Description: ϵͳ����_ģ�����_��ѯACTION
	 * </p>
	 * 
	 * @author sunkaiyu@deliverik.com
	 * @version 1.0
	 */
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		if("INSERT".equals(mapping.getParameter())){
			IGPRM01BL igprm01BL = (IGPRM01BL)this.getBean("IGPRM01BL");
			IGPRM0102Form form = (IGPRM0102Form)actionForm;
			form.setPtstatus("a");
			IGPRM01DTO dto = new IGPRM01DTO();
			dto.setProcessTemplate(form);
			if (isTokenValid(req, true)){
				igprm01BL.insertProcessTemplate(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
		}else{
			saveToken(req);
		}

		return mapping.findForward("DISP");
	}
	
}
