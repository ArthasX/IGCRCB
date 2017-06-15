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
import com.deliverik.infogovernor.asset.bl.IGASM18BL;
import com.deliverik.infogovernor.asset.dto.IGASM18DTO;
import com.deliverik.infogovernor.asset.form.IGASM1807Form;

/**
 * ϵͳ��ϵ�༭����Action����
 *
 * @author
 */
public class IGASM1807Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1807Action.class);

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
		IGASM1807Form form = (IGASM1807Form)actionForm;
		
		//BLȡ��
		IGASM18BL ctlBL = (IGASM18BL) getBean("igasm18BL");
		
		//DTO����
		IGASM18DTO dto = new IGASM18DTO();
		
		dto = ctlBL.searchRelationListAction(dto);
		req.getSession().setAttribute("ADrelationList", dto.getRelationList());
		
		//������ת�趨
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//ϵͳ��ϵ�Ǽǻ��������ʾ����
			log.debug("========ϵͳ��ϵ�Ǽǻ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I001","ϵͳ��ϵ��Ϣ"));
			
			req.getSession().setAttribute("IGASM1807Form", form);
			
			log.debug("========ϵͳ��ϵ�Ǽǻ��������ʾ��������========");
			
			saveToken(req);
			
			forward = "DISP";
		}

		if( "EDIT".equals(mapping.getParameter())){
			//ϵͳ��ϵ�༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)) {
				//���·��ذ�ťʱ�ķ��ش���
				return mapping.findForward("BACK");
			}
			
			if (form.getMode().equals("0")){
				//�����ϵ�ǼǴ���
				log.debug("========ϵͳ��ϵ�ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgasm1807Form(form);
				if (isTokenValid(req, true)){
					//ϵͳ��ϵ�Ǽ��߼�����
					dto = ctlBL.insertEntityItemRelationAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========ϵͳ��ϵ�ǼǴ�������========");
				forward = "BACK";

			} else {
				//ϵͳ��ϵ�������
				log.debug("========ϵͳ��ϵ�������ʼ========");

				//DTO��������趨
				dto.setIgasm1807Form(form);
				
				//ϵͳ��ϵ����߼�����
				dto = ctlBL.updateEntityItemRelationAction(dto);
				
				log.debug("========ϵͳ��ϵ�����������========");
				forward = "BACK";
			}
		}
		
		if ("EDIT_DISP".equals(mapping.getParameter())){
			//ϵͳ��ϵ������������ʾ����
			log.debug("========ϵͳ��ϵ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgasm1807Form(form);
			
			//ϵͳ��ϵ������������ʾ�߼�����
			dto = ctlBL.initIGASM1807Action(dto);
			
			log.debug("========ϵͳ��ϵ���������ʾ��������========");

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
