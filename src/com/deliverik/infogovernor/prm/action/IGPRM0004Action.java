/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prm.action;

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
import com.deliverik.infogovernor.prm.bl.IGPRM00BL;
import com.deliverik.infogovernor.prm.dto.IGPRM00DTO;
import com.deliverik.infogovernor.prm.form.IGPRM0004Form;
import com.deliverik.infogovernor.prm.vo.IGPRM00001VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���񹤵���ݷ�������ѡ����������ACTION
 * </p>
 * 
 * @author masai@deliverik.com
 * @version 1.0
 */

public class IGPRM0004Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRM0004Action.class);
	
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
	 * @author masai@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		log.debug("========�������Ͳ�ѯ����ʼ========");
		
		IGPRM0004Form form = (IGPRM0004Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGPRM00BL ctlBL = (IGPRM00BL) getBean("igprm00BL");
		//ʵ����DTO
		IGPRM00DTO dto = new IGPRM00DTO();
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUserid(user.getUserid());
		
		dto.setProcessType(form.getPrtype());
		//ѡ���������Ͳ�ѯ
		dto = ctlBL.searchQuickProcessDefinitionAction(dto);
		//����VO
		IGPRM00001VO vo = new IGPRM00001VO();
		
		vo.setTemplateDefinitionMap(dto.getTemplateDefinitionMap());
		
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
