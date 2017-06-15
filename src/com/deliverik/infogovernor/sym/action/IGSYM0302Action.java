/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0302Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��ɫ����_�����޸�ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0302Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0302Action.class);
	
	/**
	 * <p>
	 * Description: ��ɫaction����
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
		IGSYM0302Form form = (IGSYM0302Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��ɫ�������������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I001","��ɫ������Ϣ"));
			log.debug("========��ɫ�������������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//��ȡBL�ӿ�ʵ��
		IGSYM03BL ctlBL = (IGSYM03BL) getBean("igsym03BL");
		//ʵ����DTO
		IGSYM03DTO dto = new IGSYM03DTO();
		String forward = "DISP";
		//��ɫ����
		if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				log.debug("========��ɫ��������ʼ========");
				dto.setRole(form);
				dto.setIgsym0302Form(form);
				//����BL����
				dto = ctlBL.insertRoleAction(dto);
				log.debug("========��ɫ������������========");
			} else {
				//��Ϣ���
				log.debug("========��ɫ�������ʼ========");
				dto.setRole(form);
				//����BL���
				dto = ctlBL.updateRoleAction(dto);
				forward = "DETAIL";
				log.debug("========��ɫ�����������========");
			}
		}
		//��ɫ���ҳ���ʼ��
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========��ɫ���������ʾ����ʼ========");
			//
			dto.setIgsym0302Form(form);
			dto = ctlBL.initIGSYM0302Action(dto);
			log.debug("========��ɫ���������ʾ��������========");
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
