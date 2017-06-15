/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.action;

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
import com.deliverik.infogovernor.dut.bl.IGDUT04BL;
import com.deliverik.infogovernor.dut.dto.IGDUT04DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0401Form;

/**
 * ��ʱ�����Ǽ�Action
 */
public class IGDUT0401Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0401Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORMȡ��
		IGDUT0401Form form = (IGDUT0401Form)actionForm;
		
		//BLȡ��
		IGDUT04BL ctlBL = (IGDUT04BL) getBean("igdut04BL");
		
		//DTO����
		IGDUT04DTO dto = new IGDUT04DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//��ʱ�����Ǽǻ��������ʾ����
			log.debug("========��ʱ�����Ǽǻ��������ʾ����ʼ========");
			form.setOperater(user.getUsername());
			saveToken(req);
			log.debug("========��ʱ�����Ǽǻ��������ʾ��������========");
			forward = "DISP";
		} else if("INSERT".equals(mapping.getParameter())){
			if((form.getMode().equals("0"))){
				//��ʱ�����ǼǴ���
				log.debug("========��ʱ�����ǼǴ���ʼ========");
				
				dto.setUser(user);
				String[] titles = form.getTitles();
				String title="";
				for (String ttl : titles) {
					title+=ttl;
				}
				form.setTitle(title);
				dto.setIgdut0401Form(form);
				if (isTokenValid(req, true)){
					dto = ctlBL.insertEntityAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========��ʱ�����ǼǴ�������========");
				
				forward = "DISP";
			}else{
				//��ʱ�����������
				log.debug("========��ʱ�����������ʼ========");
				
				String[] titles = form.getTitles();
				String title="";
				for (String ttl : titles) {
					title+=ttl;
				}
				form.setTitle(title);
				//DTO��������趨
				dto.setIgdut0401Form(form);
				
				//��ʱ��������߼�����
				dto = ctlBL.updateDelayAuditAction(dto);
				
				log.debug("========��ʱ���������������========");
				
				forward = "DISP1";
			}
		}//���ҳ���ʼ��
		else if("EDIT".equals(mapping.getParameter())){
			log.debug("========��ʱ�������������ʾ����ʼ========");
			form.setMode("1");
			
			dto.setIgdut0401Form(form);
					
			dto = ctlBL.initDelayAudit(dto);
			
			forward = "DISP";
			log.debug("========��ʱ�������������ʾ��������========");
		
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
