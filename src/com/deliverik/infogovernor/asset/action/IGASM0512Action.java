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
import com.deliverik.infogovernor.asset.bl.IGASM05BL;
import com.deliverik.infogovernor.asset.dto.IGASM05DTO;
import com.deliverik.infogovernor.asset.form.IGASM0512Form;

/**
 * �ĵ���ѯ����Action����
 *
 */
public class IGASM0512Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0512Action.class);

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
		IGASM0512Form form = (IGASM0512Form)actionForm;
		
		//BLȡ��
		IGASM05BL ctlBL = (IGASM05BL) getBean("igasm05BL");
		
		//DTO����
		IGASM05DTO dto = new IGASM05DTO();
		
		
		if ("DISP".equals(mapping.getParameter())){
			//�ĵ��޸Ĵ�����ʾ
			log.debug("========�ĵ��޸Ĵ�����ʾ��ʼ========");
			dto.setIgasm0512Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto = ctlBL.initEntityItem(dto);
			
			log.debug("========�ĵ��޸Ĵ�����ʾ����========");
		}
		if ("UPDATE".equals(mapping.getParameter())){
			//�ĵ��޸Ĵ�����ʾ
			log.debug("========�ĵ��޸Ĵ�����ʾ��ʼ========");
			dto.setIgasm0512Form(form);
			dto = ctlBL.updateEntityItem(dto);
			
			log.debug("========�ĵ��޸Ĵ�����ʾ����========");
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
