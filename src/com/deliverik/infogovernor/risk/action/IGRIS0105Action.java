/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.action;

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
import com.deliverik.infogovernor.risk.bl.IGRIS01BL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0105Form;

/**
 * ����������Ϣ�༭����Action����
 *
 */
public class IGRIS0105Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0105Action.class);

	/**
	 * �ɹ�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ʵ����FORM
		IGRIS0105Form form = (IGRIS0105Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		//ʵ����DTO
		IGRIS01DTO dto = new IGRIS01DTO();
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========������������������ʾ����ʼ========");
			//��ȡ�汾���������б�
			dto = ctlBL.searchRiskAuditLabelInUse(dto);
			req.setAttribute("labelList", dto.getLabelList());
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I001","����������Ϣ"));
			log.debug("========������������������ʾ��������========");
		}
		if( "EDIT_DISP".equals(mapping.getParameter())){
			log.debug("========����������ϸ���������ʾ����ʼ========");
			dto.setIgRIS0105Form(form);		
			//����BL��ѯ
			dto = ctlBL.initRiskAuditDefAction(dto);
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����������ϸ���������ʾ��������========");
		}
		//���������
		if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				log.debug("========�������������ʼ========");
				dto.setIgRIS0105Form(form);				
				//����BL����
				if (isTokenValid(req, true)){
					dto = ctlBL.insertRiskAuditDefAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========�����������������========");
			}else{
				log.debug("========����������ϸ���������ʾ����ʼ========");
				dto.setIgRIS0105Form(form);		
				//����BL��ѯ
				dto = ctlBL.editRiskAuditDefAction(dto);			
				log.debug("========����������ϸ���������ʾ��������========");
				List<ActionMessage> messageList = dto.getMessageList();
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(req, message);
					}
				}
				return mapping.findForward("EDIT");			
			}
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
