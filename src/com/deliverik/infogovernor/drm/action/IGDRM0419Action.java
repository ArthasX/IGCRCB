/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.drm.bl.IGDRM04BL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0419Form;
import com.deliverik.infogovernor.drm.vo.IGDRM04191VO;

/**
 * �ʲ���������ѡ����Action����
 *
 */

public class IGDRM0419Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGDRM0419Action.class);
	
	/**
	 * <p>
	 * Description:ѡ������ACTION����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author sunkaiyu@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//��ȡBL�ӿ�ʵ��
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		//ʵ����DTO
		IGDRM04DTO dto = new IGDRM04DTO();
		//ѡ���������Ͳ�ѯ
		log.debug("========�ʲ��������ݲ�ѯ����ʼ========");
		//����BL��ѯ
		
		if ("CHANGE_NAME".equals(mapping.getParameter())){
			IGDRM0419Form form = (IGDRM0419Form)actionForm;
			dto.setIgdrm0419Form(form);
		}
		dto = ctlBL.searchConfigurationCodeDetail(dto);
		//����VO
		IGDRM04191VO vo = new IGDRM04191VO(dto.getConfigurationCodeDetailList());
		super.<IGDRM04191VO>setVO(req, vo);
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		log.debug("========�ʲ��������ݲ�ѯ��������========");
		return mapping.findForward("DISP");
	}

}
