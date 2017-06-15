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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM02BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0201Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM02011VO;

/**
 * ����: ����̨��ʾAction
 * ��������: ����̨��ʾAction
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
public class IGCIM0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0201Action.class);

	/**
	 * ����̨��ʾ����
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
		IGCIM0201Form form = (IGCIM0201Form)actionForm;
		
		//BLȡ��
		IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		
		//DTO����
		IGCIM02DTO dto = new IGCIM02DTO();
		dto.setLocale(this.getLocale(req));
		dto.setIgcim0201Form(form);
		
		if ("DISP".equals(mapping.getParameter())){
			
			log.debug("========����̨��ʾ��ʼ========");
			
			//��ȡ�����б�
			dto = ctlBL.initIGCIM0201Action(dto);
			
			//VO����
			IGCIM02011VO vo = new IGCIM02011VO(dto.getEiWaitTaskList());
			
			super.<IGCIM02011VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========����̨��ʾ����========");
			
		} else if("IMPORT".equals(mapping.getParameter())){
			
			log.debug("========����̨���봦��ʼ========");
			
			if (isTokenValid(req, true)){
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				dto.setUser(user);
				dto = ctlBL.importIGCIM0201Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========����̨���봦������========");
			
		} else if("DELETE".equals(mapping.getParameter())){
			
			log.debug("========����������ɾ������ʼ========");
			
			if (isTokenValid(req, true)){
				dto = ctlBL.deleteEiWaitTaskAction(dto);
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
