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
import com.deliverik.infogovernor.smr.bl.IGSMR01BL;
import com.deliverik.infogovernor.smr.dto.IGSMR01DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0101Form;

/**
 * �걨����Action����
 *
 */
public class IGSMR0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0101Action.class);

	/**
	 * �걨������
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
		IGSMR0101Form form = (IGSMR0101Form)actionForm;
		
		//BLȡ��
		IGSMR01BL ctlBL = (IGSMR01BL) getBean("igSMR01BL");
		
		//DTO����
		IGSMR01DTO dto = new IGSMR01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//�걨�������������ʾ����
			log.debug("========�걨����ҳ����ʾ����ʼ========");
			saveToken(req);
			log.debug("========�걨����ҳ����ʾ�������========");
			
		} else if( "INSERT".equals(mapping.getParameter())){
			//�걨��������
			log.debug("========�걨������ʼ========");
			
			//DTO��������趨
			dto.setIgSMR0101Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			if (isTokenValid(req, true)){
				dto = ctlBL.insertSMR0101Action(dto);//�걨����
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
