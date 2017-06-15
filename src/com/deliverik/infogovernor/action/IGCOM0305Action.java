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
import com.deliverik.infogovernor.form.IGCOM0305Form;
import com.deliverik.infogovernor.vo.IGCOM03051VO;

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

public class IGCOM0305Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0305Action.class);

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
		IGCOM0305Form form = (IGCOM0305Form)actionForm;
		// ��ȡBL�ӿ�ʵ��
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		// ʵ����DTO
		IGCOM03DTO dto = new IGCOM03DTO();
		dto.setIgcom0305Form(form);
		
		// ѡ���ϵͼ��ѯ
		log.debug("========��ϵͼ��ѯ����ʼ========");
		if(request.getParameter("eiid")!=null){
		dto.setEiid(Integer.parseInt(request.getParameter("eiid")));
		}
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		// ����BL��ѯ
		dto = ctlBL.searchRelationAction(dto);
		// ����VO
		IGCOM03051VO vo = new IGCOM03051VO(dto.getEntityItemVWInfo(), dto
				.getParEntityItemRelationMap());
		//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
		vo.setFlag(dto.getFlag());
		super.<IGCOM03051VO> setVO(request, vo);
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		log.debug("========��ϵͼ��ѯ��������========");
		return mapping.findForward("DISP");
	}

}
