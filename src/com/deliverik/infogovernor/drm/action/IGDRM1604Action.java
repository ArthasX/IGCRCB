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
import com.deliverik.infogovernor.drm.bl.IGDRM16BL;
import com.deliverik.infogovernor.drm.dto.IGDRM16DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1604Form;
import com.deliverik.infogovernor.drm.vo.IGDRM16021VO;

public class IGDRM1604Action extends BaseAction {
	static Log log = LogFactory.getLog(IGDRM1604Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionform, HttpServletRequest request,
			HttpServletResponse res) throws Exception {

		// ���form
		IGDRM1604Form form = (IGDRM1604Form) actionform;

		// BLȡ��
		IGDRM16BL ctlBL = (IGDRM16BL) getBean("igdrm16BL");
		// DTO����
		IGDRM16DTO dto = new IGDRM16DTO();
		//dto.setForm(form);
		dto.setIgdrm1604Form(form);
		// �޸�
		if ("TOEDIT".equals(mapping.getParameter())) {
			log.debug("========�¼�����ȡֵ����ʼ========");

			dto = ctlBL.searchEventssByPK(dto);
			// ���鵽�Ľ���ŵ�vo
			IGDRM16021VO vo = new IGDRM16021VO();
			vo.setEventssInfo(dto.getEventssInfo());
			vo.setScopeInfoList(dto.getScopesInfoList());
			super.setVO(request, vo);
			log.debug("========�¼�����ȡֵ�������========");
		}
		
		if ("EDIT".equals(mapping.getParameter())) {
			log.debug("========�¼�Ӱ�췶Χ��Ӵ���ʼ========");
			// ����BL����
			IGDRM16021VO vo = new IGDRM16021VO();
            ctlBL.editScopeAction(dto);
			vo.setScopeInfoList(dto.getScopesInfoList());
			super.setVO(request, vo);
			log.debug("========�¼�Ӱ�췶Χ��Ӵ������========");
		}
		return mapping.findForward("DISP");
	}

}
