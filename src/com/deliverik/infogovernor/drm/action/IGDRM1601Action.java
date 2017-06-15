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
import com.deliverik.infogovernor.drm.form.IGDRM1601Form;
import com.deliverik.infogovernor.drm.vo.IGDRM16021VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM1601Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1601Action.class);

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse res) throws Exception {

		// ʵ����FORM
		IGDRM1601Form form = (IGDRM1601Form) actionForm;
		// ��ȡBL�ӿ�ʵ��
		IGDRM16BL ctlBL = (IGDRM16BL) getBean("igdrm16BL");
		// ʵ����DTO
		IGDRM16DTO dto = new IGDRM16DTO();
        
		// ��ȡform
		dto.setIgdrm1601Form(form);
		
		//�����¼���ʼ��
		if ("SEARCH1".equals(mapping.getParameter())) {
			log.debug("========�¼�������ʼ����ʼ========");
			
			dto=ctlBL.searchMaxLabelsAction(dto);
			
			IGDRM16021VO vo = new IGDRM16021VO();
			vo.setEventssInfoList(dto.getEventssInfoList());
			super.<IGDRM16021VO>setVO(request, vo);
			log.debug("========�¼�������ʼ������========");
		}
		// ����ҳ����ת
		if ("INSERT".equals(mapping.getParameter())) {
			log.debug("========�¼�������ʼ========");
			ctlBL.insertEventssAction(dto);
			log.debug("========�¼���������========");
		}
		return mapping.findForward("DISP");
	}
}
