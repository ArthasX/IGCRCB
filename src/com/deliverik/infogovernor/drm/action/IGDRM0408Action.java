/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM04BL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0408Form;


/**
 * Ӧ����Դ��ݵǼ�Action
 * @author �Ž�
 *
 * 2015-2-12 ����9:51:47
 */
public class IGDRM0408Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0408Action.class);

	/**
	 * 
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		//BLȡ��
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		
		IGDRM0408Form form = (IGDRM0408Form)actionForm;
		
		//DTO����
		IGDRM04DTO dto = new IGDRM04DTO();
		dto.setUser(user);
		
		//������ת�趨
		String forward = "DISP";

		if( "DISP".equals(mapping.getParameter())){
			log.info("=============Ӧ���ʲ���ݵǼ�Ԥ����ʼ===============");
			log.info("=============Ӧ���ʲ���ݵǼ�Ԥ�������===============");
			
		}
		if("INSERT".equals(mapping.getParameter())){
			log.info("=============Ӧ���ʲ���ݵǼǿ�ʼ===============");
			dto.setForm(form);
			dto.setUser(user);
			ctlBL.regEmergencyResourceShortcut(dto);
			dto.getMessageList().add(new ActionMessage("IGCO10000.I000","Ӧ����Դ����ɹ���"));
			log.info("=============Ӧ���ʲ���ݵǼǽ���===============");
			
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward(forward);
	}
}
