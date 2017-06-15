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
import com.deliverik.infogovernor.asset.bl.IGASM16BL;
import com.deliverik.infogovernor.asset.dto.IGASM16DTO;
import com.deliverik.infogovernor.asset.form.IGASM1612Form;

/**
 * ���ݲ�ѯ����Action����
 *
 */
public class IGASM1612Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1612Action.class);

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
		IGASM1612Form form = (IGASM1612Form)actionForm;
		
		//BLȡ��
		IGASM16BL ctlBL = (IGASM16BL) getBean("igasm16BL");
		
		//DTO����
		IGASM16DTO dto = new IGASM16DTO();
		
		
		if ("DISP".equals(mapping.getParameter())){
			//�����޸Ĵ�����ʾ
			log.debug("========�����޸Ĵ�����ʾ��ʼ========");

			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto.setIgasm1612Form(form);
			
			dto = ctlBL.initEntityItem(dto);
			
			log.debug("========�����޸Ĵ�����ʾ����========");
		}
		if ("UPDATE".equals(mapping.getParameter())){
			//�����޸Ĵ�����ʾ
			log.debug("========�����޸Ĵ�����ʾ��ʼ========");
			dto.setIgasm1612Form(form);
			dto = ctlBL.updateEntityItem(dto);
			
			log.debug("========�����޸Ĵ�����ʾ����========");
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
