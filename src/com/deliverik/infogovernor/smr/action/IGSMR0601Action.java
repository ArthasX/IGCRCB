/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.infogovernor.smr.bl.IGSMR06BL;
import com.deliverik.infogovernor.smr.dto.IGSMR06DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0601Form;

/**
 * ����:�������� 
 * ������������������ 
 * �����ˣ�����͢
 * ������¼�� 2013-08-07
 * �޸ļ�¼��
 */
public class IGSMR0601Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0601Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGSMR0601Form form = (IGSMR0601Form)actionForm;
				
		//BLȡ��
		IGSMR06BL ctlBL = (IGSMR06BL) getBean("igSMR06BL");
				
		//DTO����
		IGSMR06DTO dto = new IGSMR06DTO();
		if( "DISP".equals(mapping.getParameter())){
			//�걨�������������ʾ����
			log.debug("========�걨����ҳ����ʾ����ʼ========");
			saveToken(req);
			log.debug("========�걨����ҳ����ʾ�������========");
			
		} else if( "INSERT".equals(mapping.getParameter())){
			//�걨��������
			log.debug("========�걨������ʼ========");
			
			//DTO��������趨
			dto.setIgSMR0601Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			if (isTokenValid(req, true)){
				dto = ctlBL.insertSMR0601Action(dto);//�걨����
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			
			log.debug("========�걨���������========");
			
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
