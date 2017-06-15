/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM22BL;
import com.deliverik.infogovernor.asset.dto.IGASM22DTO;
import com.deliverik.infogovernor.asset.form.IGASM2201Form;
import com.deliverik.infogovernor.asset.vo.IGASM22011VO;

/**
 * ����: CI�������̨��ʾAction
 * ��������: CI�������̨��ʾAction
 * ������¼: 2211/04/29
 * �޸ļ�¼: 
 */
public class IGASM2201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2201Action.class);

	/**
	 * CI�������̨��ʾ����
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
		IGASM2201Form form = (IGASM2201Form)actionForm;
		
		//BLȡ��
		IGASM22BL ctlBL = (IGASM22BL) getBean("igasm22BL");
		
		//DTO����
		IGASM22DTO dto = new IGASM22DTO();
		
		dto.setIgasm2201Form(form);
		
		if ("DISP".equals(mapping.getParameter())){
			
			log.debug("========CI�������̨��ʾ��ʼ========");
			
			//��ȡ�����б�
			dto = ctlBL.initIGASM2201Action(dto);
			
			//VO����
			IGASM22011VO vo = new IGASM22011VO(dto.getCiWaitTaskList(), dto.getCiTaskInfo());
			
			super.<IGASM22011VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========CI�������̨��ʾ����========");
			
		} else if("IMPORT".equals(mapping.getParameter())){
			
			log.debug("========CI�������̨���봦��ʼ========");
			
			if (isTokenValid(req, true)){
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				dto.setUser(user);
				dto = ctlBL.importIGASM2201Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========CI�������̨���봦������========");
			
		} else if("COMPARE".equals(mapping.getParameter())){
			
			log.debug("========CI�������̨�Աȴ���ʼ========");
			
			if (isTokenValid(req, true)){
				dto = ctlBL.compareIGASM2201Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========CI�������̨�Աȴ�������========");
			
		} else if("DELETE".equals(mapping.getParameter())){
			
			log.debug("========����������ɾ������ʼ========");
			
			if (isTokenValid(req, true)){
				dto = ctlBL.deleteCIWaitTaskAction(dto);
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
