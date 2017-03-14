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
import com.deliverik.infogovernor.asset.bl.IGASM18BL;
import com.deliverik.infogovernor.asset.dto.IGASM18DTO;
import com.deliverik.infogovernor.asset.form.IGASM1812Form;

/**
 * ϵͳ��ѯ����Action����
 *
 */
public class IGASM1812Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1812Action.class);

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
		IGASM1812Form form = (IGASM1812Form)actionForm;
		
		//BLȡ��
		IGASM18BL ctlBL = (IGASM18BL) getBean("igasm18BL");
		
		//DTO����
		IGASM18DTO dto = new IGASM18DTO();
		
		
		if ("DISP".equals(mapping.getParameter())){
			//ϵͳ�޸Ĵ�����ʾ
			log.debug("========ϵͳ�޸Ĵ�����ʾ��ʼ========");

			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto.setIgasm1812Form(form);
			
			dto = ctlBL.initEntityItem(dto);
			
			log.debug("========ϵͳ�޸Ĵ�����ʾ����========");
		}
		if ("UPDATE".equals(mapping.getParameter())){
			//ϵͳ�޸Ĵ�����ʾ
			log.debug("========ϵͳ�޸Ĵ�����ʾ��ʼ========");
			dto.setIgasm1812Form(form);
			dto = ctlBL.updateEntityItem(dto);
			
			log.debug("========ϵͳ�޸Ĵ�����ʾ����========");
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
