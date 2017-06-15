/**
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM02BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0205Form;

/**
 * ����: ��ʾ�ʲ�������ϸ��ϢAction����
 * ��������: ��ʾ�ʲ�������ϸ��ϢAction����
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
public class IGCIM0205Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCIM0205Action.class);

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
		IGCIM0205Form form = (IGCIM0205Form) actionForm;
		// BLȡ��
		 IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		// DTO����
		IGCIM02DTO dto = new IGCIM02DTO();
		dto.setLocale(this.getLocale(req));
		// ������ת�趨
		String forward = null;
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========�ʲ����������ʾ����ʼ========");
			dto.setIgcim0205Form(form);
			dto = ctlBL.initIGCIM0205Action(dto);
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
