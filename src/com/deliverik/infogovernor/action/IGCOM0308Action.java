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
import com.deliverik.infogovernor.form.IGCOM0308Form;
import com.deliverik.infogovernor.vo.IGCOM03081VO;

/**
 * ������Ϣ��ʷ��¼����Action����
 *
 */
public class IGCOM0308Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0308Action.class);
	
	/**
	 * �¼�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGCOM0308Form form = (IGCOM0308Form)actionForm;
		//BLȡ��
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		//DTO����
		IGCOM03DTO dto = new IGCOM03DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//������Ϣ��ʷ��¼���������ʾ����
			log.debug("========������Ϣ��ʷ��¼���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgcom0308Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//������Ϣ��ʷ��¼���������ʾ�߼�����
			dto = ctlBL.initIGCOM0308Action(dto);
			
			
			//��������Ϣ��ʷ��¼��������趨��VO��
			IGCOM03081VO vo = new IGCOM03081VO(dto.getEntityItemVWInfoSOC(), dto.getConfigItemMapSOC());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			super.<IGCOM03081VO>setVO(req, vo);
			
			//�߼���������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			
			log.debug("========������Ϣ��ʷ��¼���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		if( "TOPOLOGY_DISP".equals(mapping.getParameter())){
			
			log.debug("========������Ϣ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgcom0308Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//������Ϣ��ʷ��¼���������ʾ�߼�����
			dto = ctlBL.showConfigAction(dto);
			
			//��������Ϣ��ʷ��¼��������趨��VO��
			IGCOM03081VO vo = new IGCOM03081VO(dto.getEntityItemVWInfoSOC(), dto.getConfigItemMapSOC());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			super.<IGCOM03081VO>setVO(req, vo);
			
			//�߼���������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			
			log.debug("========������Ϣ���������ʾ��������========");
			return mapping.findForward("TOPOLOGY_DISP");
		}
		if ("BACK".equals(mapping.getParameter())) {
			//������Ϣ��ʷ��¼���淵�ذ�ť����ʱ�ķ��ش���
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}
	
	
}
