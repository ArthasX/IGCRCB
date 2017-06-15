/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.prm.action;

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
import com.deliverik.infogovernor.soc.prm.bl.IGPRM00BL;
import com.deliverik.infogovernor.soc.prm.dto.IGPRM00DTO;
import com.deliverik.infogovernor.soc.prm.vo.IGPRM00001VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_���̷���_ѡ����������ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGPRM0000Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRM0000Action.class);
	
	/**
	 * <p>
	 * Description:ѡ����������ACTION����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("========�������Ͳ�ѯ����ʼ========");
		//��ȡBL�ӿ�ʵ��
		IGPRM00BL ctlBL = (IGPRM00BL) getBean("socprm00BL");
		//ʵ����DTO
		IGPRM00DTO dto = new IGPRM00DTO();
		dto.setLocale(this.getLocale(request));
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUserid(user.getUserid());
		
		//ѡ���������Ͳ�ѯ
		dto.setProcessType(request.getParameter("prtype"));
		//����BL��ѯ
		dto = ctlBL.searchProcessDefinitionAction(dto);
		//����VO
		IGPRM00001VO vo = new IGPRM00001VO();
		vo.setTemplateDefinitionMap(dto.getTemplateDefinitionMap());
		vo.setGpt(dto.getGpt());
		vo.setSpt(dto.getSpt());
		super.<IGPRM00001VO>setVO(request, vo);
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		log.debug("========�������Ͳ�ѯ��������========");
		return mapping.findForward("DISP");
	}

}
