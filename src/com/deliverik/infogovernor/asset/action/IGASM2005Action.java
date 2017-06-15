/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.asset.bl.IGASM20BL;
import com.deliverik.infogovernor.asset.dto.IGASM20DTO;
import com.deliverik.infogovernor.asset.form.IGASM2005Form;

/**
 * ����: ��ʾ�ʲ�������ϸ��ϢAction����
 * ��������: ��ʾ�ʲ�������ϸ��ϢAction����
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
public class IGASM2005Action extends BaseAction {
	static Log log = LogFactory.getLog(IGASM2005Action.class);

	/**
	 * �¼�����
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
		IGASM2005Form form = (IGASM2005Form) actionForm;
		// BLȡ��
		 IGASM20BL ctlBL = (IGASM20BL) getBean("igasm20BL");
		// DTO����
		IGASM20DTO dto = new IGASM20DTO();
		
		// ������ת�趨
		String forward = null;
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========�ʲ����������ʾ����ʼ========");
			dto.setIgasm2005Form(form);
			dto = ctlBL.initIGASM2005Action(dto);
			log.debug("========�ʲ����������ʾ��������========");
			forward = "DISP";
		}
		if("BACK".equals(mapping.getParameter())){
			//�ʲ�������Ϣ��ѯ������ת
			log.debug("========�ʲ�������Ϣ��ѯ========");
			forward="BACK";
		}
		return mapping.findForward(forward);
	}
}
