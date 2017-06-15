package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM10BL;
import com.deliverik.infogovernor.sym.dto.IGSYM10DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1004Form;

/**
 * ������Ϣ�༭����Action����
 *
 */
public class IGSYM1004Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1004Action.class);

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
		IGSYM1004Form form = (IGSYM1004Form)actionForm;
		
		//BLȡ��
		IGSYM10BL ctlBL = (IGSYM10BL) getBean("igsym10BL");
		
		//DTO����
		IGSYM10DTO dto = new IGSYM10DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//������Ϣ�Ǽǻ��������ʾ����
			log.debug("========������Ϣ�Ǽǻ��������ʾ����ʼ========");
			dto.setIgsym1004Form(form);
			ctlBL.initIGSYM1004Action(dto);
			req.setAttribute("IGSYM1004Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","������Ϣ"));
			log.debug("========������Ϣ�Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		}

		if( "LIST".equals(mapping.getParameter())){
			//������ݵǼǻ��������ʾ����
			log.debug("========������ݵǼǻ��������ʾ����ʼ========");
			form.setCid("");
			form.setCvalue("");
			addMessage(req, new ActionMessage("IGCO10000.I001","������Ϣ"));
			log.debug("========������ݵǼǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		}
		
		if( "INSERT".equals(mapping.getParameter())){
			//������Ϣ�༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//������Ϣ�༭���水�·��ذ�ťʱ�ķ��ش���
				if (form.getRoute().equals("0")){
					//�������͵Ǽǻ���
					return mapping.findForward("BACK1");
				} else if (form.getRoute().equals("1")){
					//����������ϸ ����
					return mapping.findForward("BACK2");
				} else {
					//���ز��������ϸ ����
					return mapping.findForward("BACK3");
				}
			}
			if (form.getMode().equals("0")||form.getMode().equals("2")){
				//������Ϣ�ǼǴ���
				log.debug("========������Ϣ�ǼǴ���ʼ========");

				//DTO��������趨
				dto.setIgsym1004Form(form);
				
				//������Ϣ�Ǽ��߼�����
				dto = ctlBL.insertCodeDetailAction(dto);
				
				log.debug("========������Ϣ�ǼǴ�������========");
				
				if (form.getRoute().equals("0")){
					forward = "DISP";
				} else if (form.getRoute().equals("1")){
					forward = "DETAIL";
				} else {
					//���ز��������ϸ ����
					forward = "BACK3";
				}

			} else {
				//������Ϣ�������
				log.debug("========������Ϣ�������ʼ========");

				//DTO��������趨
				dto.setIgsym1004Form(form);
				
				//������Ϣ����߼�����
				dto = ctlBL.updateCodeDetailAction(dto);
				if(dto.isError() == true){
					forward = "ERROR";
				} else {
					forward = "DETAIL";
				}
				log.debug("========������Ϣ�����������========");
			}
		}
		
		if ("EDIT".equals(mapping.getParameter())){
			//������Ϣ�༭������ڴ���
			log.debug("========������Ϣ�༭������ڴ���ʼ========");

			//DTO��������趨
			dto.setIgsym1004Form(form);
			
			//������Ϣ�༭������ڴ����߼�����
			dto = ctlBL.initIGSYM1004Action(dto);
			
			log.debug("========������Ϣ�����������========");

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
