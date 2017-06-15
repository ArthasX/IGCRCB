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
import com.deliverik.infogovernor.prm.form.IGPRM0003Form;
import com.deliverik.infogovernor.prm.vo.IGPRM00001VO;

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

public class IGPRM0003Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRM0003Action.class);
	
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
		IGPRM0003Form form = (IGPRM0003Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGPRM00BL ctlBL = (IGPRM00BL) getBean("igprm00BL");
		//ʵ����DTO
		IGPRM00DTO dto = new IGPRM00DTO();
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUserid(user.getUserid());
		
		dto.setProcessType(form.getPrtype());
		//ѡ���������Ͳ�ѯ
		if ("RelevantProcess".equals(mapping.getParameter())) {
		    dto.setPdid(request.getParameter("pdid"));
		    dto.setPsdid(request.getParameter("psdid"));
		    dto.setRoleid(Integer.valueOf(request.getParameter("roleid")));
		    dto = ctlBL.searchRelevantProcessAction(dto);
		} else {
		    dto = ctlBL.searchQuickProcessDefinitionAction(dto);
		}
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
