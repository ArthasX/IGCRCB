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
import com.deliverik.infogovernor.asset.bl.IGASM12BL;
import com.deliverik.infogovernor.asset.dto.IGASM12DTO;
import com.deliverik.infogovernor.asset.form.IGASM1207Form;

/**
 * �����ϵ�༭����Action����
 *
 * @author
 */
public class IGASM1207Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1207Action.class);

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
		IGASM1207Form form = (IGASM1207Form)actionForm;
		
		//BLȡ��
		IGASM12BL ctlBL = (IGASM12BL) getBean("igasm12BL");
		
		//DTO����
		IGASM12DTO dto = new IGASM12DTO();
		
		//������ת�趨
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//�����ϵ�Ǽǻ��������ʾ����
			log.debug("========�����ϵ�Ǽǻ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I001","�����ϵ��Ϣ"));
			
			req.getSession().setAttribute("IGASM1207Form", form);
			
			log.debug("========�����ϵ�Ǽǻ��������ʾ��������========");
			
			forward = "DISP";
		}

		if( "EDIT".equals(mapping.getParameter())){
			//�����ϵ�༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)) {
				//���·��ذ�ťʱ�ķ��ش���
				return mapping.findForward("BACK");
			}
			
			if (form.getMode().equals("0")){
				//�����ϵ�ǼǴ���
				log.debug("========�����ϵ�ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgasm1207Form(form);
				
				//�����ϵ�Ǽ��߼�����
				dto = ctlBL.insertEntityItemRelationAction(dto);

				log.debug("========�����ϵ�ǼǴ�������========");
				forward = "BACK";

			} else {
				//�����ϵ�������
				log.debug("========�����ϵ�������ʼ========");

				//DTO��������趨
				dto.setIgasm1207Form(form);
				
				//�����ϵ����߼�����
				dto = ctlBL.updateEntityItemRelationAction(dto);
				
				log.debug("========�����ϵ�����������========");
				forward = "BACK";
			}
		}
		
		if ("EDIT_DISP".equals(mapping.getParameter())){
			//�����ϵ������������ʾ����
			log.debug("========�����ϵ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgasm1207Form(form);
			
			//�����ϵ������������ʾ�߼�����
			dto = ctlBL.initIGASM1207Action(dto);
			
			log.debug("========�����ϵ���������ʾ��������========");

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
