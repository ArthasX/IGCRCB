/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.action;

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
import com.deliverik.infogovernor.sdl.bl.IGSDL04BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL04DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0402Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_��Ϣ�����޸�ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSDL0402Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0402Action.class);
	
	/**
	 * <p>
	 * Description: ��Ϣ�����޸�action����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGSDL0402Form form = (IGSDL0402Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��Ϣ�������������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I001","�Ǽǻ�����Ϣ"));
			saveToken(request);
			log.debug("========��Ϣ�������������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//��ȡBL�ӿ�ʵ��
		IGSDL04BL ctlBL = (IGSDL04BL) getBean("igSDL04BL");
		//ʵ����DTO
		IGSDL04DTO dto = new IGSDL04DTO();
		String forward = "DISP";
		//��Ϣ����
		if( "INSERT".equals(mapping.getParameter())){
			if ("1".equals(form.getMode())){
				//��Ϣ���
				log.debug("========��Ϣ�������ʼ========");
				dto.setSdlInfo(form);
				//����BL���
				dto = ctlBL.updateSdlInfoAction(dto);
				forward = "DETAIL";
				log.debug("========��Ϣ�����������========");
			} else {
				log.debug("========��Ϣ��������ʼ========");
				dto.setSdlInfo(form);
				if (isTokenValid(request, true)){
					//����BL����
					dto = ctlBL.insertSdlInfoAction(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========��Ϣ������������========");
			}
		}
		//���ҳ���ʼ��
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========��Ϣ���������ʾ����ʼ========");
			//
			dto.setIgsdl0402Form(form);
			dto = ctlBL.initSdlInfoAction(dto);
			log.debug("========��Ϣ���������ʾ��������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}
	
}
