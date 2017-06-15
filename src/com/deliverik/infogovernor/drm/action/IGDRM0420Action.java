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
import com.deliverik.infogovernor.drm.form.IGDRM0420Form;
import com.deliverik.infogovernor.drm.vo.IGDRM04201VO;

/**
 * �ʲ���������ѡ����Action����
 *
 */

public class IGDRM0420Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGDRM0420Action.class);
	
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
		IGDRM0420Form form = (IGDRM0420Form)actionForm;
		//ʵ����DTO
		IGDRM04DTO dto = new IGDRM04DTO();
		dto.setIgdrm0420Form(form);
		//ѡ���������Ͳ�ѯ
		log.debug("========�ʲ��������ݲ�ѯ����ʼ========");
		
		//����BL��ѯ
		if("CHANGE_STATUS".equals(mapping.getParameter())){
			dto.setStrflag("status");
		}else if("CHANGE_VALUE".equals(mapping.getParameter())){
			dto.setStrflag("changeValue");
		}
		dto = ctlBL.searchCfgCodeDetailByCategory(dto);
		//����VO
		IGDRM04201VO vo = new IGDRM04201VO(dto.getConfigurationCodeDetailList());
		super.<IGDRM04201VO>setVO(req, vo);
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
