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
import com.deliverik.infogovernor.asset.bl.IGASM27BL;
import com.deliverik.infogovernor.asset.dto.IGASM27DTO;
import com.deliverik.infogovernor.asset.form.IGASM2707Form;

/**
 * ���յ��ϵ�༭����Action����
 *
 * @author
 */
public class IGASM2707Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2707Action.class);

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
		IGASM2707Form form = (IGASM2707Form)actionForm;
		
		//BLȡ��
		IGASM27BL ctlBL = (IGASM27BL) getBean("igasm27BL");
		
		//DTO����
		IGASM27DTO dto = new IGASM27DTO();
		
		dto = ctlBL.searchRelationListAction(dto);
		req.getSession().setAttribute("ADrelationList", dto.getRelationList());
		
		//������ת�趨
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//���յ��ϵ�Ǽǻ��������ʾ����
			log.debug("========���յ��ϵ�Ǽǻ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I001","���յ��ϵ��Ϣ"));
			
			req.getSession().setAttribute("IGASM2707Form", form);
			
			log.debug("========���յ��ϵ�Ǽǻ��������ʾ��������========");
			
			saveToken(req);
			
			forward = "DISP";
		}

		if( "EDIT".equals(mapping.getParameter())){
			//���յ��ϵ�༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)) {
				//���·��ذ�ťʱ�ķ��ش���
				return mapping.findForward("BACK");
			}
			
			if (form.getMode().equals("0")){
				//�����ϵ�ǼǴ���
				log.debug("========���յ��ϵ�ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgasm2707Form(form);
				if (isTokenValid(req, true)){
					//���յ��ϵ�Ǽ��߼�����
					dto = ctlBL.insertEntityItemRelationAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========���յ��ϵ�ǼǴ�������========");
				forward = "BACK";

			} else {
				//���յ��ϵ�������
				log.debug("========���յ��ϵ�������ʼ========");

				//DTO��������趨
				dto.setIgasm2707Form(form);
				
				//���յ��ϵ����߼�����
				dto = ctlBL.updateEntityItemRelationAction(dto);
				
				log.debug("========���յ��ϵ�����������========");
				forward = "BACK";
			}
		}
		
		if ("EDIT_DISP".equals(mapping.getParameter())){
			//���յ��ϵ������������ʾ����
			log.debug("========���յ��ϵ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgasm2707Form(form);
			
			//���յ��ϵ������������ʾ�߼�����
			dto = ctlBL.initIGASM2707Action(dto);
			
			log.debug("========���յ��ϵ���������ʾ��������========");

			saveToken(req);
			
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
