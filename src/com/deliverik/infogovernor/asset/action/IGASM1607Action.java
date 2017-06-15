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
import com.deliverik.infogovernor.asset.bl.IGASM16BL;
import com.deliverik.infogovernor.asset.dto.IGASM16DTO;
import com.deliverik.infogovernor.asset.form.IGASM1607Form;

/**
 * ���ݹ�ϵ�༭����Action����
 *
 * @author
 */
public class IGASM1607Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1607Action.class);

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
		IGASM1607Form form = (IGASM1607Form)actionForm;
		
		//BLȡ��
		IGASM16BL ctlBL = (IGASM16BL) getBean("igasm16BL");
		
		//DTO����
		IGASM16DTO dto = new IGASM16DTO();
		
		dto = ctlBL.searchRelationListAction(dto);
		req.getSession().setAttribute("ADrelationList", dto.getRelationList());
		
		//������ת�趨
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//���ݹ�ϵ�Ǽǻ��������ʾ����
			log.debug("========���ݹ�ϵ�Ǽǻ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I001","���ݹ�ϵ��Ϣ"));
			
			req.getSession().setAttribute("IGASM1607Form", form);
			
			log.debug("========���ݹ�ϵ�Ǽǻ��������ʾ��������========");
			
			saveToken(req);
			
			forward = "DISP";
		}

		if( "EDIT".equals(mapping.getParameter())){
			//���ݹ�ϵ�༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)) {
				//���·��ذ�ťʱ�ķ��ش���
				return mapping.findForward("BACK");
			}
			
			if (form.getMode().equals("0")){
				//�����ϵ�ǼǴ���
				log.debug("========���ݹ�ϵ�ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgasm1607Form(form);
				if (isTokenValid(req, true)){
					//���ݹ�ϵ�Ǽ��߼�����
					dto = ctlBL.insertEntityItemRelationAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}

				log.debug("========���ݹ�ϵ�ǼǴ�������========");
				forward = "BACK";

			} else {
				//���ݹ�ϵ�������
				log.debug("========���ݹ�ϵ�������ʼ========");

				//DTO��������趨
				dto.setIgasm1607Form(form);
				
				//���ݹ�ϵ����߼�����
				dto = ctlBL.updateEntityItemRelationAction(dto);
				
				log.debug("========���ݹ�ϵ�����������========");
				forward = "BACK";
			}
		}
		
		if ("EDIT_DISP".equals(mapping.getParameter())){
			//���ݹ�ϵ������������ʾ����
			log.debug("========���ݹ�ϵ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgasm1607Form(form);
			
			//���ݹ�ϵ������������ʾ�߼�����
			dto = ctlBL.initIGASM1607Action(dto);
			
			log.debug("========���ݹ�ϵ���������ʾ��������========");

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
