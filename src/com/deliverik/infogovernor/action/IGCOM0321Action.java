/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.action;

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
import com.deliverik.infogovernor.bl.IGCOM03BL;
import com.deliverik.infogovernor.dto.IGCOM03DTO;
import com.deliverik.infogovernor.form.IGCOM0321Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ʲ�����_Ӱ�����ͼ�鿴ACTION
 * </p>
 * 
 * @version 1.0
 */

public class IGCOM0321Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0321Action.class);

	/**
	 * <p>
	 * Description:Ӱ�����ͼACTION����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//FORMȡ��
		IGCOM0321Form form = (IGCOM0321Form)actionForm;
		
		// ��ȡBL�ӿ�ʵ��
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		
		// ʵ����DTO
		IGCOM03DTO dto = new IGCOM03DTO();
		
		//DTO��������趨
		dto.setIgcom0321Form(form);
		// ѡ��Ӱ�����ͼ��ѯ
		log.debug("========Ӱ�����ͼ��ѯ����ʼ========");
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		
		if("DISP".equals(mapping.getParameter())){
			//Ӱ�����ͼ���������ʾ����
			log.debug("========Ӱ�����ͼ���������ʾ����ʼ========");
			
			//Ӱ�����ͼ���������ʾ�߼�����
			dto = ctlBL.initIGCOM0321Action(dto);
			
			saveToken(request);
			log.debug("========Ӱ�����ͼ���������ʾ��������========");
			
		}
		//ҳ����ʾ��Ϣ�趨
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
