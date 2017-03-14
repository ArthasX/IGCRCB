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
import com.deliverik.infogovernor.asset.bl.IGASM21BL;
import com.deliverik.infogovernor.asset.dto.IGASM21DTO;
import com.deliverik.infogovernor.asset.form.IGASM2101Form;
import com.deliverik.infogovernor.asset.vo.IGASM21011VO;

/**
 * ����: ��ƿ���̨��ʾAction
 * ��������: ��ƿ���̨��ʾAction
 * ������¼: 2111/04/29
 * �޸ļ�¼: 
 */
public class IGASM2101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0321Action.class);

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
		IGASM2101Form form = (IGASM2101Form)actionForm;
		
		//BLȡ��
		IGASM21BL ctlBL = (IGASM21BL) getBean("igasm21BL");
		
		//DTO����
		IGASM21DTO dto = new IGASM21DTO();
		
		dto.setIgasm2101Form(form);
		
		if ("DISP".equals(mapping.getParameter())){
			
			log.debug("========��ƿ���̨��ʾ��ʼ========");
			
			//��ȡ�����б�
			dto = ctlBL.initIGASM2101Action(dto);
			
			//VO����
			IGASM21011VO vo = new IGASM21011VO(dto.getAuditWaitTaskList(), dto.getAuditTaskInfo());
			
			super.<IGASM21011VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========��ƿ���̨��ʾ����========");
			
		} else if("IMPORT".equals(mapping.getParameter())){
			
			log.debug("========��ƿ���̨���봦��ʼ========");
			
			if (isTokenValid(req, true)){
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				dto.setUser(user);
				dto = ctlBL.importIGASM2101Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========��ƿ���̨���봦������========");
			
		} else if("COMPARE".equals(mapping.getParameter())){
			
			log.debug("========��ƿ���̨�Աȴ���ʼ========");
			
			if (isTokenValid(req, true)){
				dto = ctlBL.compareIGASM2101Action(dto);
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
