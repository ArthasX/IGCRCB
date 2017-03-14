/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.action;

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
import com.deliverik.infogovernor.risk.bl.IGRIS01BL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0110Form;

/**
 * ��Ʒ��������Ϣ�༭����Action����
 *
 */
public class IGRIS0110Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0110Action.class);

	/**
	 * ��Ʒ�����
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
		IGRIS0110Form form = (IGRIS0110Form)actionForm;
		
		//BLȡ��
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		
		//DTO����
		IGRIS01DTO dto = new IGRIS01DTO();
		
		//������ת�趨
		String forward = null;
		
		if( "DISP".equals(mapping.getParameter())){
			//��Ʒ���Ǽǻ��������ʾ����
			log.debug("========��Ʒ���Ǽǻ��������ʾ����ʼ========");
			
			//��ȡ�汾���������б�
			dto = ctlBL.searchRiskAuditLabelInUse(dto);
			req.setAttribute("labelList", dto.getLabelList());
			
			addMessage(req, new ActionMessage("IGCO10000.I001","��Ʒ��������Ϣ"));
			
			log.debug("========��Ʒ���Ǽǻ��������ʾ��������========");
			
			return mapping.findForward("DISP");
			
		} else if( "INSERT".equals(mapping.getParameter())){
			
			if (form.getMode().equals("0")){
				//��Ʒ���ǼǴ���
				log.debug("========��Ʒ���ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgRIS0110Form(form);
				
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				dto.setUser(user);
				
				//��Ʒ�����Ϣ�Ǽ��߼�����
				dto = ctlBL.insertRiskAuditInsAction(dto);
				
				log.debug("========��Ʒ���ǼǴ�������========");
				
				forward = "DISP";
			} else {
				//��Ʒ���������
				log.debug("========��Ʒ��������Ϣ�������ʼ========");
				
				//DTO��������趨
				dto.setIgRIS0110Form(form);
				
				//��Ʒ�����Ϣ����߼�����
				dto = ctlBL.updateRiskAuditInsAction(dto);
				
				log.debug("========��Ʒ��������Ϣ�����������========");
				
				forward = "BACK";
			}
			
		} else if ("CHANGE".equals(mapping.getParameter())){
				log.debug("========��Ʒ���ر�/���ô���ʼ========");
				//DTO��������趨
				dto.setIgRIS0110Form(form);
				
				ctlBL.changeRiskAuditInsAction(dto);
				
				log.debug("========��Ʒ���ر�/���ô�������========");
				
				forward = "DISP";
		} else if ("EDIT".equals(mapping.getParameter())){
			log.debug("========��Ʒ��������Ϣ���������ʾ����ʼ========");
			
			dto.setIgRIS0110Form(form);
			
			dto = ctlBL.initIGRIS0110Action(dto);
			
			log.debug("========��Ʒ��������Ϣ���������ʾ��������========");

			forward = "DISP";
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}
}
