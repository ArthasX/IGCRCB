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

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.prm.bl.IGPRM01BL;
import com.deliverik.infogovernor.prm.dto.IGPRM01DTO;
import com.deliverik.infogovernor.prm.form.IGPRM0102Form;
import com.deliverik.infogovernor.prm.vo.IGPRM01011VO;

public class IGPRM0101Action extends BaseAction {

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

		IGPRM01BL igprm01BL = (IGPRM01BL)this.getBean("IGPRM01BL");
		IGPRM01DTO dto = new IGPRM01DTO();
		if("CHANGE_STATUS".equals(mapping.getParameter())){
			IGPRM0102Form form = (IGPRM0102Form)actionForm;
			dto.setProcessTemplate(form);
			igprm01BL.changePTStatus(dto);
		} else {
			dto = igprm01BL.findAllProcessTemplate(dto);
			IGPRM01011VO vo = new IGPRM01011VO();
			vo.setProcessTemplateList(dto.getProcessTemplateList());
			req.setAttribute("vo", vo);
		}
		
		return mapping.findForward("DISP");
	}
	
}
