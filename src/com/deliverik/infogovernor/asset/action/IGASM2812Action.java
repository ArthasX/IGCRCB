package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM28BL;
import com.deliverik.infogovernor.asset.dto.IGASM28DTO;
import com.deliverik.infogovernor.asset.form.IGASM2812Form;

/**
 * ������ѯ����Action����
 *
 */
public class IGASM2812Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2812Action.class);

	/**
	 * �¼�����
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
		IGASM2812Form form = (IGASM2812Form)actionForm;
		
		//BLȡ��
		IGASM28BL ctlBL = (IGASM28BL) getBean("igasm28BL");
		
		//DTO����
		IGASM28DTO dto = new IGASM28DTO();
		
		
		if ("DISP".equals(mapping.getParameter())){
			//������޸Ĵ�����ʾ
			log.debug("========������޸Ĵ�����ʾ��ʼ========");
			dto.setIgasm2812Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto = ctlBL.initEntityItem(dto);
			
			log.debug("========������޸Ĵ�����ʾ����========");
		}
		if ("UPDATE".equals(mapping.getParameter())){
			//������޸Ĵ�����ʾ
			log.debug("========������޸Ĵ�����ʾ��ʼ========");
			dto.setIgasm2812Form(form);
			dto = ctlBL.updateEntityItem(dto);
			
			log.debug("========������޸Ĵ�����ʾ����========");
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
