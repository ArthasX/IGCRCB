/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.svc.action;

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
import com.deliverik.infogovernor.svc.bl.IGSVC01BL;
import com.deliverik.infogovernor.svc.dto.IGSVC01DTO;
import com.deliverik.infogovernor.svc.vo.IGSVC01011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�ҵĹ���_��ѯACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSVC0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSVC0101Action.class);

	/**
	 * <p>
	 * Description: �ҵĹ���action����
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
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// ��ȡBL�ӿ�ʵ��
		IGSVC01BL ctlBL = (IGSVC01BL) getBean("igsvc01BL");
		// ʵ����DTO
		IGSVC01DTO dto = new IGSVC01DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUserid(user.getUserid());
		dto.setUsername(user.getUsername());
		// �ҵĹ�����ѯ
		log.debug("========�ҵĹ�����ѯ����ʼ========");
		// ����BL��ѯ
		dto = ctlBL.getWorkAssignedToMe(dto);
		// ����VO
		IGSVC01011VO vo = new IGSVC01011VO();
		
		vo.setWorkList(dto.getWorkList());

		super.<IGSVC01011VO> setVO(request, vo);

		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		log.debug("========�ҵĹ�����ѯ��������========");
		return mapping.findForward("DISP");
	}

}
