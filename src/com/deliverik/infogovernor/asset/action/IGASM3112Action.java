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
import com.deliverik.infogovernor.asset.bl.IGASM31BL;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.form.IGASM3112Form;

/**
 * ����ָ���ѯ����Action����
 *
 */
public class IGASM3112Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM3112Action.class);

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
		IGASM3112Form form = (IGASM3112Form)actionForm;
		
		//BLȡ��
		IGASM31BL ctlBL = (IGASM31BL) getBean("igasm31BL");
		
		//DTO����
		IGASM31DTO dto = new IGASM31DTO();
		
		
		if ("DISP".equals(mapping.getParameter())){
			//����ָ���޸Ĵ�����ʾ
			log.debug("========����ָ���޸Ĵ�����ʾ��ʼ========");
			dto.setIgasm3112Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto = ctlBL.initEntityItem(dto);
			
			log.debug("========����ָ���޸Ĵ�����ʾ����========");
		}
		if ("UPDATE".equals(mapping.getParameter())){
			//����ָ���޸Ĵ�����ʾ
			log.debug("========����ָ���޸Ĵ�����ʾ��ʼ========");
			dto.setIgasm3112Form(form);
			dto = ctlBL.updateEntityItem(dto);
			
			log.debug("========����ָ���޸Ĵ�����ʾ����========");
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
