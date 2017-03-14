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
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.sdl.bl.IGSDL03BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL03DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0302Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_Ŀ�������޸�ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSDL0302Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0302Action.class);
	
	/**
	 * <p>
	 * Description: Ŀ�������޸�action����
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
		IGSDL0302Form form = (IGSDL0302Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========Ŀ���������������ʾ����ʼ========");
			form.setSdiyear(IGStringUtils.getCurrentYear());
			addMessage(request, new ActionMessage("IGCO10000.I001","Ŀ�������Ϣ"));
			log.debug("========Ŀ���������������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//��ȡBL�ӿ�ʵ��
		IGSDL03BL ctlBL = (IGSDL03BL) getBean("igSDL03BL");
		//ʵ����DTO
		IGSDL03DTO dto = new IGSDL03DTO();
		String forward = "DISP";
		//Ŀ������
		if( "INSERT".equals(mapping.getParameter())){
			if ("1".equals(form.getMode())){
				//��Ϣ���
				log.debug("========Ŀ��������ʼ========");
				dto.setSdlDefineInfo(form);
				//����BL���
				dto = ctlBL.updateSdlDefineInfoAction(dto);
				forward = "DETAIL";
				log.debug("========Ŀ������������========");
			} else {
				log.debug("========Ŀ����������ʼ========");
				dto.setSdlDefineInfo(form);
				//����BL����
				dto = ctlBL.insertSdlDefineInfoAction(dto);
				log.debug("========Ŀ��������������========");
			}
		}
		//���ҳ���ʼ��
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========Ŀ����������ʾ����ʼ========");
			//
			dto.setIgsdl0302Form(form);
			dto = ctlBL.initSdlDefineInfoAction(dto);
			log.debug("========Ŀ����������ʾ��������========");
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
