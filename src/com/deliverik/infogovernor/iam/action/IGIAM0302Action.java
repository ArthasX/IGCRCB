/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.iam.action;

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
import com.deliverik.infogovernor.iam.bl.IGIAM03BL;
import com.deliverik.infogovernor.iam.dto.IGIAM03DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0302Form;

/**
 * ����: ��Ʊ�������form ������������Ʊ������� �����ˣ���ӿ�� ������¼�� 2012-8-9 �޸ļ�¼��
 */
public class IGIAM0302Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0302Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// ��ȡform
		IGIAM0302Form form = (IGIAM0302Form) actionform;
		// ��ȡҵ���߼�BL
		IGIAM03BL iam03BL = (IGIAM03BL) getBean("igiam03bl");
		// ����DTO
		IGIAM03DTO igiam03DTO = new IGIAM03DTO();
		// ��ȡ��ǰ��¼�û�
		User user = (User) request.getSession().getAttribute(
				SESSION_KEY_LOGIN_USER);
		
		if("INSERT".equals(mapping.getParameter())){
			log.debug("========��������������ʼ========");
			//��������form����
			igiam03DTO.setAttachFile(form);//���ø�����
			igiam03DTO = iam03BL.insertIAMAction(igiam03DTO);
			
			log.debug("========�����������������========");
		}
		List<ActionMessage> messageList = igiam03DTO.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
