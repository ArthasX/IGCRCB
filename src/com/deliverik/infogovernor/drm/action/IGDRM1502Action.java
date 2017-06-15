/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.drm.bl.IGDRM15BL;
import com.deliverik.infogovernor.drm.dto.IGDRM15DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1502Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:��ѵ�ƻ�����Action
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM1502Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1502Action.class);

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse res) throws Exception {

		// ʵ����FORM
		IGDRM1502Form form = (IGDRM1502Form) actionForm;
		// ��ȡBL�ӿ�ʵ��
		IGDRM15BL ctlBL = (IGDRM15BL) getBean("igdrm15BL");
		// ʵ����DTO
		IGDRM15DTO dto = new IGDRM15DTO();  
		// ��ȡform
		dto.setIgdrm1502Form(form);	
		// ����ҳ����ת
		if ("INSERT".equals(mapping.getParameter())) {
			log.debug("========��ѵ�ƻ�/��ѵ����ʼ========");
			ctlBL.insertTrainplanAction(dto);
			log.debug("========��ѵ�ƻ���������========");
		}
		return mapping.findForward("DISP");
	}
}
