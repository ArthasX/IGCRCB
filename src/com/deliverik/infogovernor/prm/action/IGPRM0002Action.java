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
import com.deliverik.infogovernor.prm.vo.IGPRM00001VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_��������_ѡ��������ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGPRM0002Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRM0002Action.class);
	
	/**
	 * <p>
	 * Description:ѡ��������ACTION����
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
		//��ȡBL�ӿ�ʵ��
		IGPRM00BL ctlBL = (IGPRM00BL) getBean("igprm00BL");
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//ʵ����DTO
		IGPRM00DTO dto = new IGPRM00DTO();
		//ѡ�������Ͳ�ѯ
		log.debug("========�������Ͳ�ѯ����ʼ========");
		//����BL��ѯ
//		dto.setPtqrtzflag(request.getParameter("ptqrtzflag"));
		dto.setProcessType(request.getParameter("type"));
		dto.setUserid(user.getUserid());
		dto = ctlBL.searchWorkDefinitionAction(dto);
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
