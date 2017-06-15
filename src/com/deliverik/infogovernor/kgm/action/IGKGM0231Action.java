package com.deliverik.infogovernor.kgm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.dto.IGKGM02DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0231Form;

public class IGKGM0231Action extends BaseAction {

	static Log log = LogFactory.getLog(IGKGM0231Action.class);

	/**
	 * ֪ʶ��־��ѯ
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORMȡ��
		IGKGM0231Form form = (IGKGM0231Form) actionForm;
		// BLȡ��
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		// DTO����
		IGKGM02DTO dto = new IGKGM02DTO();
		// ֪ʶ��ѯ����
		log.debug("========֪ʶ��������ͳ�ƴ���ʼ========");
		dto.setIgkgm0231Form(form);
		dto = ctlBL.searchStatisticalKnowledgeContribution(dto);
		log.debug("========֪ʶ��������ͳ�ƴ�������========");
		return mapping.findForward("DISP");
	}
}
