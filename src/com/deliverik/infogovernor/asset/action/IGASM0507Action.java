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
import com.deliverik.infogovernor.asset.bl.IGASM05BL;
import com.deliverik.infogovernor.asset.dto.IGASM05DTO;
import com.deliverik.infogovernor.asset.form.IGASM0507Form;

/**
 * �ĵ���ϵ�༭����Action����
 *
 * @author
 */
public class IGASM0507Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0507Action.class);

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
		IGASM0507Form form = (IGASM0507Form)actionForm;
		
		//BLȡ��
		IGASM05BL ctlBL = (IGASM05BL) getBean("igasm05BL");
		
		//DTO����
		IGASM05DTO dto = new IGASM05DTO();
		
		dto = ctlBL.searchRelationListAction(dto);
		req.getSession().setAttribute("ADrelationList", dto.getRelationList());
		
		//������ת�趨
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//�ĵ���ϵ�Ǽǻ��������ʾ����
			log.debug("========�ĵ���ϵ�Ǽǻ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I001","�ĵ���ϵ��Ϣ"));
			
			req.getSession().setAttribute("IGASM0507Form", form);
			
			log.debug("========�ĵ���ϵ�Ǽǻ��������ʾ��������========");
			
			saveToken(req);
			
			forward = "DISP";
		}

		if( "EDIT".equals(mapping.getParameter())){
			//�ĵ���ϵ�༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)) {
				//���·��ذ�ťʱ�ķ��ش���
				return mapping.findForward("BACK");
			}
			
			if (form.getMode().equals("0")){
				//�����ϵ�ǼǴ���
				log.debug("========�ĵ���ϵ�ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgasm0507Form(form);
				if (isTokenValid(req, true)){
					//�ĵ���ϵ�Ǽ��߼�����
					dto = ctlBL.insertEntityItemRelationAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========�ĵ���ϵ�ǼǴ�������========");
				forward = "BACK";

			} else {
				//�ĵ���ϵ�������
				log.debug("========�ĵ���ϵ�������ʼ========");

				//DTO��������趨
				dto.setIgasm0507Form(form);
				
				//�ĵ���ϵ����߼�����
				dto = ctlBL.updateEntityItemRelationAction(dto);
				
				log.debug("========�ĵ���ϵ�����������========");
				forward = "BACK";
			}
		}
		
		if ("EDIT_DISP".equals(mapping.getParameter())){
			//�ĵ���ϵ������������ʾ����
			log.debug("========�ĵ���ϵ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgasm0507Form(form);
			
			//�ĵ���ϵ������������ʾ�߼�����
			dto = ctlBL.initIGASM0507Action(dto);
			
			log.debug("========�ĵ���ϵ���������ʾ��������========");

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
