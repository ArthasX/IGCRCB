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
import com.deliverik.infogovernor.asset.bl.IGASM08BL;
import com.deliverik.infogovernor.asset.dto.IGASM08DTO;
import com.deliverik.infogovernor.asset.form.IGASM0812Form;

/**
 * Ӧ�ò�ѯ����Action����
 *
 */
public class IGASM0812Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0812Action.class);

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
		IGASM0812Form form = (IGASM0812Form)actionForm;
		
		//BLȡ��
		IGASM08BL ctlBL = (IGASM08BL) getBean("igasm08BL");
		
		//DTO����
		IGASM08DTO dto = new IGASM08DTO();
		
		
		if ("DISP".equals(mapping.getParameter())){
			//Ӧ���޸Ĵ�����ʾ
			log.debug("========Ӧ���޸Ĵ�����ʾ��ʼ========");

			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto.setIgasm0812Form(form);
			
			dto = ctlBL.initEntityItem(dto);
			
			log.debug("========Ӧ���޸Ĵ�����ʾ����========");
		}
		if ("UPDATE".equals(mapping.getParameter())){
			//Ӧ���޸Ĵ�����ʾ
			log.debug("========Ӧ���޸Ĵ�����ʾ��ʼ========");
			dto.setIgasm0812Form(form);
			dto = ctlBL.updateEntityItem(dto);
			
			log.debug("========Ӧ���޸Ĵ�����ʾ����========");
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
