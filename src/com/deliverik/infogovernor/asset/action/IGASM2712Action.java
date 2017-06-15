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
import com.deliverik.infogovernor.asset.bl.IGASM27BL;
import com.deliverik.infogovernor.asset.dto.IGASM27DTO;
import com.deliverik.infogovernor.asset.form.IGASM2712Form;

/**
 * ���յ��ѯ����Action����
 *
 */
public class IGASM2712Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2712Action.class);

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
		IGASM2712Form form = (IGASM2712Form)actionForm;
		
		//BLȡ��
		IGASM27BL ctlBL = (IGASM27BL) getBean("igasm27BL");
		
		//DTO����
		IGASM27DTO dto = new IGASM27DTO();
		
		
		if ("DISP".equals(mapping.getParameter())){
			//���յ��޸Ĵ�����ʾ
			log.debug("========���յ��޸Ĵ�����ʾ��ʼ========");
			dto.setIgasm2712Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto = ctlBL.initEntityItem(dto);
			
			log.debug("========���յ��޸Ĵ�����ʾ����========");
		}
		if ("UPDATE".equals(mapping.getParameter())){
			//���յ��޸Ĵ�����ʾ
			log.debug("========���յ��޸Ĵ�����ʾ��ʼ========");
			dto.setIgasm2712Form(form);
			dto = ctlBL.updateEntityItem(dto);
			
			log.debug("========���յ��޸Ĵ�����ʾ����========");
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
