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
import com.deliverik.infogovernor.drm.form.IGDRM0418Form;

/**
 * �ʲ���������ѡ����Action����
 *
 */

public class IGDRM0418Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGDRM0418Action.class);
	
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
	 * @author maozhipeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGDRM0418Form form = (IGDRM0418Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		//ʵ����DTO
		IGDRM04DTO dto = new IGDRM04DTO();
		if( "DISP".equals(mapping.getParameter())){
			//�ʲ��������ݵǼ���ʾ����
			log.debug("========�ʲ��������ݵǼǴ�����ʾ��ʼ========");
			req.setAttribute("IGDRM0418Form", new IGDRM0418Form());
			addMessage(req, new ActionMessage("IGCO10000.I001","ȡֵ��Χ�Ǽǻ�����Ϣ"));
			log.debug("========�ʲ��������ݵǼǴ�����ʾ����========");
		}
		if("INSERT".equals(mapping.getParameter())){
			log.debug("========�ʲ��������ݵǼǴ���ʼ========");
			dto.setConfigurationcodedetail(form);
			dto.setIgdrm0418Form(form);
			dto =ctlBL.insertConfigurationCodeDetailAction(dto);
			
			log.debug("========���ͻ�����Ϣ���������ʾ��������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}

}
