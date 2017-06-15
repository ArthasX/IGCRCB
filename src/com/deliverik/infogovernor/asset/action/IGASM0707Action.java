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
import com.deliverik.infogovernor.asset.bl.IGASM07BL;
import com.deliverik.infogovernor.asset.dto.IGASM07DTO;
import com.deliverik.infogovernor.asset.form.IGASM0707Form;

/**
 * �豸��ϵ�༭����Action����
 *
 * @author
 */
public class IGASM0707Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0707Action.class);

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
		IGASM0707Form form = (IGASM0707Form)actionForm;
		
		//BLȡ��
		IGASM07BL ctlBL = (IGASM07BL) getBean("igasm07BL");
		
		//DTO����
		IGASM07DTO dto = new IGASM07DTO();
		
		//������ת�趨
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//�豸��ϵ�Ǽǻ��������ʾ����
			log.debug("========�豸��ϵ�Ǽǻ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I001","�豸��ϵ��Ϣ"));
			
			req.getSession().setAttribute("IGASM0707Form", form);
			
			log.debug("========�豸��ϵ�Ǽǻ��������ʾ��������========");
			
			forward = "DISP";
		}

		if( "EDIT".equals(mapping.getParameter())){
			//�豸��ϵ�༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)) {
				//���·��ذ�ťʱ�ķ��ش���
				return mapping.findForward("BACK");
			}
			
			if (form.getMode().equals("0")){
				//�����ϵ�ǼǴ���
				log.debug("========�豸��ϵ�ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgasm0707Form(form);
				
				//�豸��ϵ�Ǽ��߼�����
				dto = ctlBL.insertEntityItemRelationAction(dto);

				log.debug("========�豸��ϵ�ǼǴ�������========");
				forward = "BACK";

			} else {
				//�豸��ϵ�������
				log.debug("========�豸��ϵ�������ʼ========");

				//DTO��������趨
				dto.setIgasm0707Form(form);
				
				//�豸��ϵ����߼�����
				dto = ctlBL.updateEntityItemRelationAction(dto);
				
				log.debug("========�豸��ϵ�����������========");
				forward = "BACK";
			}
		}
		
		if ("EDIT_DISP".equals(mapping.getParameter())){
			//�豸��ϵ������������ʾ����
			log.debug("========�豸��ϵ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgasm0707Form(form);
			
			//�豸��ϵ������������ʾ�߼�����
			dto = ctlBL.initIGASM0707Action(dto);
			
			log.debug("========������ϵ���������ʾ��������========");

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
