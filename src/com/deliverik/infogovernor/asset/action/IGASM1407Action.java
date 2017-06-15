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
import com.deliverik.infogovernor.asset.bl.IGASM14BL;
import com.deliverik.infogovernor.asset.dto.IGASM14DTO;
import com.deliverik.infogovernor.asset.form.IGASM1407Form;

/**
 * �����¼��ϵ�༭����Action����
 *
 * @author
 */
public class IGASM1407Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1407Action.class);

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
		IGASM1407Form form = (IGASM1407Form)actionForm;
		
		//BLȡ��
		IGASM14BL ctlBL = (IGASM14BL) getBean("igasm14BL");
		
		//DTO����
		IGASM14DTO dto = new IGASM14DTO();
		
		//������ת�趨
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//�����¼��ϵ�Ǽǻ��������ʾ����
			log.debug("========�����¼��ϵ�Ǽǻ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I001","�����¼��ϵ��Ϣ"));
			
			req.getSession().setAttribute("IGASM1407Form", form);
			
			log.debug("========�����¼��ϵ�Ǽǻ��������ʾ��������========");
			
			forward = "DISP";
		}

		if( "EDIT".equals(mapping.getParameter())){
			//�����¼��ϵ�༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)) {
				//���·��ذ�ťʱ�ķ��ش���
				return mapping.findForward("BACK");
			}
			
			if (form.getMode().equals("0")){
				//�����ϵ�ǼǴ���
				log.debug("========�����¼��ϵ�ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgasm1407Form(form);
				
				//�����¼��ϵ�Ǽ��߼�����
				dto = ctlBL.insertEntityItemRelationAction(dto);

				log.debug("========�����¼��ϵ�ǼǴ�������========");
				forward = "BACK";

			} else {
				//�����¼��ϵ�������
				log.debug("========�����¼��ϵ�������ʼ========");

				//DTO��������趨
				dto.setIgasm1407Form(form);
				
				//�����¼��ϵ����߼�����
				dto = ctlBL.updateEntityItemRelationAction(dto);
				
				log.debug("========�����¼��ϵ�����������========");
				forward = "BACK";
			}
		}
		
		if ("EDIT_DISP".equals(mapping.getParameter())){
			//�����¼��ϵ������������ʾ����
			log.debug("========�����¼��ϵ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgasm1407Form(form);
			
			//�����¼��ϵ������������ʾ�߼�����
			dto = ctlBL.initIGASM1407Action(dto);
			
			log.debug("========�����¼��ϵ���������ʾ��������========");

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
