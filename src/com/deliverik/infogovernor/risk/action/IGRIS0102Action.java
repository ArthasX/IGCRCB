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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.risk.bl.IGRIS01BL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0102Form;

/**
 * ��ư汾������Ϣ�༭����Action����
 *
 */
public class IGRIS0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0102Action.class);

	/**
	 * ��ư汾����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGRIS0102Form form = (IGRIS0102Form)actionForm;
		
		//BLȡ��
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		
		//DTO����
		IGRIS01DTO dto = new IGRIS01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//��ư汾�Ǽǻ��������ʾ����
			log.debug("========��ư汾�Ǽǻ��������ʾ����ʼ========");
			
			addMessage(req, new ActionMessage("IGCO10000.I001","��ư汾������Ϣ"));
			
			log.debug("========��ư汾�Ǽǻ��������ʾ��������========");
			
		} else if( "INSERT".equals(mapping.getParameter())){
			//��ư汾�ǼǴ���
			log.debug("========��ư汾�ǼǴ���ʼ========");
			
			//DTO��������趨
			dto.setIgRIS0102Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//��ư汾��Ϣ�Ǽ��߼�����
			dto = ctlBL.insertRiskAuditAction(dto);
			
			log.debug("========��ư汾�ǼǴ�������========");
			
		} else if ("CHANGE".equals(mapping.getParameter())){
				log.debug("========��ư汾ͣ��/���ô���ʼ========");
				//DTO��������趨
				dto.setIgRIS0102Form(form);
				
				ctlBL.changeRiskAuditAction(dto);
				
				log.debug("========��ư汾ͣ��/���ô�������========");
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
