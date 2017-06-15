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
import com.deliverik.infogovernor.drm.bl.IGDRM11BL;
import com.deliverik.infogovernor.drm.dto.IGDRM11DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1102Form;
import com.deliverik.infogovernor.drm.vo.IGDRM11021VO;

/**
 * ��ǩ��Action����
 *
 */
public class IGDRM1102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1102Action.class);

	/**
	 * 
	 * ����
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGDRM1102Form form = (IGDRM1102Form)actionForm;
		//��ǰ��¼�û�
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//BLȡ��
		IGDRM11BL ctlBL = (IGDRM11BL) getBean("igdrm11BL");
		
		//DTO����
		IGDRM11DTO dto = new IGDRM11DTO();
		dto.setUser(user);
		dto.setIgdrm1102Form(form);
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("===========��ǩ����ʼ��ҳ����ʾ����ʼ===========");
			form.setSiuserid(null);
			dto=ctlBL.initIGDRM1102Action(dto);
			//����VO
			IGDRM11021VO vo = new IGDRM11021VO();
			vo.setSigninMap(dto.getSigninMap());
			super.<IGDRM11021VO>setVO(req, vo);
			log.debug("===========��ǩ����ʼ��ҳ����ʾ����ʼ===========");
			return mapping.findForward("DISP");
		}
		if( "SIGNIN".equals(mapping.getParameter())){
			log.debug("===========��ǩ����ʼ��ҳ����ʾ����ʼ===========");
			dto=ctlBL.updateIGDRM1102Action(dto);
			ctlBL.pushSigninHelpMessage(dto);
			log.debug("===========��ǩ����ʼ��ҳ����ʾ����ʼ===========");
			return mapping.findForward("DISP");
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
