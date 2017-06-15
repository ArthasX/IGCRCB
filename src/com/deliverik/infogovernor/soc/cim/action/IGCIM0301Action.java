/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM03BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM03DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0301Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM03011VO;

/**
 * ����: ��ƿ���̨��ʾAction
 * ��������: ��ƿ���̨��ʾAction
 * ������¼: 2111/04/29
 * �޸ļ�¼: 
 */
public class IGCIM0301Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0301Action.class);

	/**
	 * ��ƿ���̨��ʾ����
	 *
	 * @param mapping ActionMapping 
	 * @param actionForm ActionForm 
	 * @param req HttpServletRequest 
	 * @param res HttpServletResponse 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORMȡ��
		IGCIM0301Form form = (IGCIM0301Form)actionForm;
		
		//BLȡ��
		IGCIM03BL ctlBL = (IGCIM03BL) getBean("igcim03BL");
		
		//DTO����
		IGCIM03DTO dto = new IGCIM03DTO();
		
		dto.setIgcim0301Form(form);
		
		if ("DISP".equals(mapping.getParameter())){
			
			log.debug("========��ƿ���̨��ʾ��ʼ========");
			
			//��ȡ�����б�
			dto = ctlBL.initIGCIM0301Action(dto);
			
			//VO����
			IGCIM03011VO vo = new IGCIM03011VO(dto.getAuditWaitTaskList(), dto.getAuditTaskInfo());
			
			super.<IGCIM03011VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========��ƿ���̨��ʾ����========");
			
		} else if("IMPORT".equals(mapping.getParameter())){
			
			log.debug("========��ƿ���̨���봦��ʼ========");
			
			if (isTokenValid(req, true)){
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				dto.setUser(user);
				dto = ctlBL.importIGCIM0301Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========��ƿ���̨���봦������========");
			
		} else if("COMPARE".equals(mapping.getParameter())){
			
			log.debug("========��ƿ���̨�Աȴ���ʼ========");
			
			if (isTokenValid(req, true)){
				dto = ctlBL.compareIGCIM0301Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========��ƿ���̨�Աȴ�������========");
			
		} else if("DELETE".equals(mapping.getParameter())){
			
			log.debug("========����������ɾ������ʼ========");
			
			if (isTokenValid(req, true)){
				dto = ctlBL.deleteAuditWaitTaskAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========����������ɾ����������========");
			
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
