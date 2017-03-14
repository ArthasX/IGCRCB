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
import com.deliverik.infogovernor.form.IGCOM0314Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ʲ�����_��ϵͼ�鿴ACTION
 * </p>
 * 
 * @version 1.0
 */

public class IGCOM0314Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0314Action.class);

	/**
	 * <p>
	 * Description:��ϵͼACTION����
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
		IGCOM0314Form form = (IGCOM0314Form)actionForm;
		
		// ��ȡBL�ӿ�ʵ��
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		
		// ʵ����DTO
		IGCOM03DTO dto = new IGCOM03DTO();
		
		//DTO��������趨
		dto.setIgcom0314Form(form);
		// ѡ���ϵͼ��ѯ
		log.debug("========��ϵͼ��ѯ����ʼ========");
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		
		if("DISP".equals(mapping.getParameter())){
			//��ϵͼ���������ʾ����
			log.debug("========��ϵͼ���������ʾ����ʼ========");
			
			//��ϵͼ���������ʾ�߼�����
			dto = ctlBL.initIGCOM0314Action(dto);
			
			saveToken(request);
			log.debug("========��ϵͼ���������ʾ��������========");
			
		}
		//ҳ����ʾ��Ϣ�趨
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		if(dto.getEsyscoding().startsWith("999001009")){
			return mapping.findForward("STORAGEDISP");
		}else if(dto.getEsyscoding().startsWith("999001006")){
			return mapping.findForward("SWITCHDISP");
		}else{
			return mapping.findForward("HOSTDISP");
		}
	}

}
