/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prr.action;

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
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0121Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01211VO;

/**
 * @Description: ���̴���_��������ѯִ����
 * @Author  
 * @History 2013-02-28     �½� 
 * @Version V1.0
 */
public class IGPRR0121Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRR0121Action.class);
	
	/**
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGPRR0121Form form = (IGPRR0121Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		//ʵ����DTO
		IGPRR01DTO dto = new IGPRR01DTO();
		String forward = "DISP";
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		dto.setIgPRR0121Form(form);
		
		//��ѯָ����ɫ�Ͳ����µ�ִ����
		if ("INIT".equals(mapping.getParameter())){
			log.debug("========ִ���˲�ѯ����ʼ========");
			
			dto = ctlBL.searchProcessExecutor(dto);
			IGPRR01211VO vo = new IGPRR01211VO();
			vo.setLst_UserRoleInfo(dto.getLst_UserRoleVW());
			super.<IGPRR01211VO>setVO(request, vo);
			saveToken(request);
			log.debug("========ִ���˲�ѯ�������========");
		}
		else if ("ADD".equals(mapping.getParameter())){
			log.debug("========���ִ���˴���ʼ========");
			if(isTokenValid(request,true)){
				ctlBL.addProcessExecutor(dto);
			}else{
				return null;
			}
			
			log.debug("========���ִ���˴�������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}
	
}
