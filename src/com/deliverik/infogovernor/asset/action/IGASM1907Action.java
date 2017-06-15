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
import com.deliverik.infogovernor.asset.bl.IGASM19BL;
import com.deliverik.infogovernor.asset.dto.IGASM19DTO;
import com.deliverik.infogovernor.asset.form.IGASM1907Form;

/**
 * �����¼��ϵ�༭����Action����
 *
 * @author
 */
public class IGASM1907Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1907Action.class);

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
		IGASM1907Form form = (IGASM1907Form)actionForm;
		
		//BLȡ��
		IGASM19BL ctlBL = (IGASM19BL) getBean("igasm19BL");
		
		//DTO����
		IGASM19DTO dto = new IGASM19DTO();
		
		dto = ctlBL.searchRelationListAction(dto);
		req.getSession().setAttribute("ADrelationList", dto.getRelationList());
		
		//������ת�趨
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//��Ա��ϵ�Ǽǻ��������ʾ����
			log.debug("========��Ա��ϵ�Ǽǻ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I001","��Ա��ϵ��Ϣ"));
			
			req.getSession().setAttribute("IGASM1907Form", form);
			
			log.debug("========��Ա��ϵ�Ǽǻ��������ʾ��������========");
			
			saveToken(req);
			
			forward = "DISP";
		}

		if( "EDIT".equals(mapping.getParameter())){
			//��Ա��ϵ�༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)) {
				//���·��ذ�ťʱ�ķ��ش���
				return mapping.findForward("BACK");
			}
			
			if (form.getMode().equals("0")){
				//�����ϵ�ǼǴ���
				log.debug("========��Ա��ϵ�ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgasm1907Form(form);
				
				if (isTokenValid(req, true)){
					//��Ա��ϵ�Ǽ��߼�����
					dto = ctlBL.insertEntityItemRelationAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				log.debug("========��Ա��ϵ�ǼǴ�������========");
				forward = "BACK";

			} else {
				//��Ա��ϵ�������
				log.debug("========��Ա��ϵ�������ʼ========");

				//DTO��������趨
				dto.setIgasm1907Form(form);
				
				//��Ա��ϵ����߼�����
				dto = ctlBL.updateEntityItemRelationAction(dto);
				
				log.debug("========��Ա��ϵ�����������========");
				forward = "BACK";
			}
		}
		
		if ("EDIT_DISP".equals(mapping.getParameter())){
			//��Ա��ϵ������������ʾ����
			log.debug("========��Ա��ϵ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgasm1907Form(form);
			
			//��Ա��ϵ������������ʾ�߼�����
			dto = ctlBL.initIGASM1907Action(dto);
			
			saveToken(req);
			
			log.debug("========��Ա��ϵ���������ʾ��������========");

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
