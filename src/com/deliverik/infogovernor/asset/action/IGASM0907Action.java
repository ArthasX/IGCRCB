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
import com.deliverik.infogovernor.asset.bl.IGASM09BL;
import com.deliverik.infogovernor.asset.dto.IGASM09DTO;
import com.deliverik.infogovernor.asset.form.IGASM0907Form;

/**
 * �����̹�ϵ�༭����Action����
 *
 * @author
 */
public class IGASM0907Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0907Action.class);

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
		IGASM0907Form form = (IGASM0907Form)actionForm;
		
		//BLȡ��
		IGASM09BL ctlBL = (IGASM09BL) getBean("igasm09BL");
		
		//DTO����
		IGASM09DTO dto = new IGASM09DTO();
		
		dto = ctlBL.searchRelationListAction(dto);
		req.getSession().setAttribute("ADrelationList", dto.getRelationList());
		
		//������ת�趨
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//�����̹�ϵ�Ǽǻ��������ʾ����
			log.debug("========�����̹�ϵ�Ǽǻ��������ʾ������ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I001","�����̹�ϵ��Ϣ"));
			
			req.getSession().setAttribute("IGASM0907Form", form);
			
			log.debug("========�����̹�ϵ�Ǽǻ��������ʾ��������========");
			
			saveToken(req);
			
			forward = "DISP";
		}

		if( "EDIT".equals(mapping.getParameter())){
			//�����̹�ϵ�༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)) {
				//���·��ذ�ťʱ�ķ��ش���
				return mapping.findForward("BACK");
			}
			
			if (form.getMode().equals("0")){
				//�����ϵ�ǼǴ���
				log.debug("========�����̹�ϵ�ǼǴ�����ʼ========");
				
				//DTO��������趨
				dto.setIgasm0907Form(form);
				
				if (isTokenValid(req, true)){
					//�����̹�ϵ�Ǽ��߼�����
					dto = ctlBL.insertEntityItemRelationAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========�����̹�ϵ�ǼǴ�������========");
				forward = "BACK";

			} else {
				//�����̹�ϵ�������
				log.debug("========�����̹�ϵ���������ʼ========");

				//DTO��������趨
				dto.setIgasm0907Form(form);
				
				//�����̹�ϵ����߼�����
				dto = ctlBL.updateEntityItemRelationAction(dto);
				
				log.debug("========�����̹�ϵ�����������========");
				forward = "BACK";
			}
		}
		
		if ("EDIT_DISP".equals(mapping.getParameter())){
			//�����̹�ϵ������������ʾ����
			log.debug("========�����̹�ϵ���������ʾ������ʼ========");
			
			//DTO��������趨
			dto.setIgasm0907Form(form);
			
			//�����̹�ϵ������������ʾ�߼�����
			dto = ctlBL.initIGASM0907Action(dto);
			
			log.debug("========�����̹�ϵ���������ʾ��������========");

			saveToken(req);
			
			forward = "DISP";
			
		}
		
		//�߼����������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}
}