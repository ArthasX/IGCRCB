/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
/**
 * 
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
import com.deliverik.infogovernor.iam.bl.IGIAM02BL;
import com.deliverik.infogovernor.iam.dto.IGIAM02DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0202Form;

/**
 * @author zhaomin
 *
 */
/**
 * ����: ���ù�����������action
 * �������������ù�����������action
 * �����ˣ�����
 * ������¼�� 2012-7-26
 * �޸ļ�¼��
 */
public class IGIAM0202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0202Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//��ȡform
		IGIAM0202Form form = (IGIAM0202Form)actionForm;
		
		//��ȡbl
		IGIAM02BL iajBL = (IGIAM02BL)getBean("igiam02bl");
		
		//��ȡdto
		IGIAM02DTO dto = new IGIAM02DTO();
		
		//��ȡ��ǰ��¼�û�
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);

		if("INSERT".equals(mapping.getParameter())){
			log.debug("========��������������ʼ========");
			
			form.setIajuserid(user.getUserid());
			//��������form����
			dto.setAttachFile(form);//���ø�����
			dto = iajBL.insertIAMAction(dto);
			
			log.debug("========�����������������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
