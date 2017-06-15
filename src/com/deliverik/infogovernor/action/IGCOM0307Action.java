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
import com.deliverik.infogovernor.form.IGCOM0307Form;
import com.deliverik.infogovernor.vo.IGCOM03071VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ʲ���������Ϣ�汾�Ƚ�ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGCOM0307Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0307Action.class);

	/**
	 * <p>
	 * Description:�ʲ���������Ϣ�汾�Ƚ���ʾ����ACTION����
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
		//FORMȡ��
		IGCOM0307Form form = (IGCOM0307Form)actionForm;
		
		// ��ȡBL�ӿ�ʵ��
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		
		// ʵ����DTO
		IGCOM03DTO dto = new IGCOM03DTO();
		
		if( "SEARCH".equals(mapping.getParameter())){
			//�ʲ���������Ϣ�汾�Ƚϻ��������ʾ����
			log.debug("========�ʲ���������Ϣ�汾�Ƚϻ��������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgcom0307Form(form);
			
			User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//�ʲ���������Ϣ�汾�Ƚϻ��������ʾ�߼�����
			dto = ctlBL.initIGCOM0307Action(dto);
			
			//���ʲ���������Ϣ�汾�Ƚϼ�������趨��VO��
			IGCOM03071VO vo = new IGCOM03071VO(dto.getSoc0124Info(),
					dto.getConfigItemList());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			super.<IGCOM03071VO>setVO(request, vo);
			
			//�߼���������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
				
			}
			log.debug("========�ʲ���������Ϣ�汾�Ƚϻ��������ʾ��������========");
		}
		return mapping.findForward("DISP");
	}

}
