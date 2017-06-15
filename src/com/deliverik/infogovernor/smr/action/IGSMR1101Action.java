/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.action;

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
import com.deliverik.infogovernor.smr.bl.IGSMR11BL;
import com.deliverik.infogovernor.smr.dto.IGSMR11DTO;
import com.deliverik.infogovernor.smr.form.IGSMR1101Form;

/**
 * �±�����Action����
 *
 */
public class IGSMR1101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR1101Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGSMR1101Form form = (IGSMR1101Form)actionForm;
				
		//BLȡ��
		IGSMR11BL ctlBL = (IGSMR11BL) getBean("igSMR11BL");
				
		//DTO����
		IGSMR11DTO dto = new IGSMR11DTO();
		if( "DISP".equals(mapping.getParameter())){
			//�±��������������ʾ����
			log.debug("========�±�����ҳ����ʾ����ʼ========");
			saveToken(req);
			log.debug("========�±�����ҳ����ʾ�������========");
			
		} 
		else if( "INSERT".equals(mapping.getParameter())){
			//�±���������
			log.debug("========�±�������ʼ========");
			
			//DTO��������趨
			dto.setIgSMR1101Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			if (isTokenValid(req, true)){
				dto = ctlBL.insertSMR1101Action(dto);//�±�����
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			
			log.debug("========�±����������========");
			
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
