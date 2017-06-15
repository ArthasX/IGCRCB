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
import com.deliverik.infogovernor.drm.form.IGDRM1501Form;
import com.deliverik.infogovernor.drm.vo.IGDRM15011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:��ѵ�ƻ��༭Action
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM1512Action extends BaseAction {
	static Log log = LogFactory.getLog(IGDRM1512Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionform, HttpServletRequest request,
			HttpServletResponse res) throws Exception {

		// ���form
		IGDRM1501Form form = (IGDRM1501Form) actionform;
		// BLȡ��
		IGDRM15BL ctlBL = (IGDRM15BL) getBean("igdrm15BL");
		// DTO����
		IGDRM15DTO dto = new IGDRM15DTO();
		//dto.setForm(form);
		dto.setIgdrm1501Form(form);
		// �޸�
		if ("TOEDIT".equals(mapping.getParameter())) {
			log.debug("========��ѵ�ƻ�����ѵ�������ȡֵ����ʼ========");

			dto = ctlBL.searchTrainPlanMissionAction(dto);
			// ���鵽�Ľ���ŵ�vo
			IGDRM15011VO vo = new IGDRM15011VO();
			vo.setTrainmissionInfoList(dto.getTrainmissionInfoList());
			vo.setTrainplanInfo(dto.getTrainplanInfo());
			vo.setResultList(dto.getResultList());
			super.setVO(request, vo);
			log.debug("========��ѵ�ƻ�����ѵ�������ȡֵ�������========");
		}
		
		if ("TOUPDATE".equals(mapping.getParameter())) {
			log.debug("========��ѵ�ƻ�/��ѵ������´���ʼ========");
			// ����BL����
//			IGDRM15011VO vo = new IGDRM15011VO();
            ctlBL.updateTrainPlanMission(dto);
			
			log.debug("========��ѵ�ƻ�/��ѵ������´������========");
		}
		return mapping.findForward("DISP");
	}

}
