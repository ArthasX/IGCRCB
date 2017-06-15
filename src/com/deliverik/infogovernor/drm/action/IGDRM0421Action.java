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
import com.deliverik.infogovernor.drm.form.IGDRM0421Form;
import com.deliverik.infogovernor.drm.vo.IGDRM04211VO;

/**
 * �ʲ���������ѡ����Action����
 *
 */

public class IGDRM0421Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGDRM0421Action.class);
	
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
		IGDRM0421Form form = (IGDRM0421Form)actionForm;
		//ʵ����DTO
		IGDRM04DTO dto = new IGDRM04DTO();
		//ѡ���������Ͳ�ѯ
		log.debug("========�ʲ��������ݲ�ѯ����ʼ========");
		
		//����BL��ѯ
		if("DISP".equals(mapping.getParameter())){
			saveToken(req);
			dto.setIgdrm0421Form(form);
			dto = ctlBL.getCfgCodeDetailByCategory(dto);
			IGDRM04211VO vo = new IGDRM04211VO();
			vo.setConfigurationCodeDetail(dto.getConfigurationcodedetail());
			saveToken(req);
			super.<IGDRM04211VO>setVO(req, vo);
		} else if ("INSERT".equals(mapping.getParameter())){
			dto.setIgdrm0421Form(form);
			if (isTokenValid(req, true)){
				dto = ctlBL.insertCfgCodeDetailAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
		}
		
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
