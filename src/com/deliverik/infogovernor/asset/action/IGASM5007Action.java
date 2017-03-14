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
import com.deliverik.infogovernor.asset.bl.IGASM50BL;
import com.deliverik.infogovernor.asset.dto.IGASM50DTO;
import com.deliverik.infogovernor.asset.form.IGASM5007Form;

/**
 * �ĵ���ϵ�༭����Action����
 *
 * @author
 */
public class IGASM5007Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM5007Action.class);

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
		IGASM5007Form form = (IGASM5007Form)actionForm;
		
		//BLȡ��
		IGASM50BL ctlBL = (IGASM50BL) getBean("igasm50BL");
		
		//DTO����
		IGASM50DTO dto = new IGASM50DTO();
		
		dto = ctlBL.searchRelationListAction(dto);
		req.getSession().setAttribute("ADrelationList", dto.getRelationList());
		
		//������ת�趨
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//�ĵ���ϵ�Ǽǻ��������ʾ����
			log.debug("========�ĵ���ϵ�Ǽǻ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I001","�ĵ���ϵ��Ϣ"));
			
			req.getSession().setAttribute("IGASM5007Form", form);
			
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
				dto.setIgasm5007Form(form);
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
				dto.setIgasm5007Form(form);
				
				//�ĵ���ϵ����߼�����
				dto = ctlBL.updateEntityItemRelationAction(dto);
				
				log.debug("========�ĵ���ϵ�����������========");
				forward = "BACK";
			}
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
