package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM20BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM20DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2006Form;

/**
 * Ӧ�ù�ϵ�༭����Action����
 *
 * @author
 */
public class IGCIM2006Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM2006Action.class);

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
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGCIM2006Form form = (IGCIM2006Form)actionForm;
		
		//BLȡ��
		IGCIM20BL ctlBL = (IGCIM20BL) getBean("igcim20BL");
		
		//DTO����
		IGCIM20DTO dto = new IGCIM20DTO();
		dto.setLocale(this.getLocale(req));
		dto.setIgcim2006Form(form);
		dto = ctlBL.searchRelationListActionApp(dto);
		req.getSession().setAttribute("ADrelationList", dto.getRelationList());
		
		//������ת�趨
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//Ӧ�ù�ϵ�Ǽǻ��������ʾ����
			log.debug("========Ӧ�ù�ϵ�Ǽǻ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I001","Ӧ�ù�ϵ��Ϣ"));
			
			req.getSession().setAttribute("IGCIM2006Form", form);
			
			log.debug("========Ӧ�ù�ϵ�Ǽǻ��������ʾ��������========");
			
			saveToken(req);
			
			forward = "DISP";
		}

		if( "EDIT".equals(mapping.getParameter())){
			//Ӧ�ù�ϵ�༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)) {
				//���·��ذ�ťʱ�ķ��ش���
				return mapping.findForward("BACK");
			}
			
			if (form.getMode().equals("0")){
				//�����ϵ�ǼǴ���
				log.debug("========Ӧ�ù�ϵ�ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgcim2006Form(form);
				if (isTokenValid(req, true)){
					//Ӧ�ù�ϵ�Ǽ��߼�����
					dto = ctlBL.insertEntityItemRelationActionApp(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========Ӧ�ù�ϵ�ǼǴ�������========");
				forward = "BACK";

			} else {
				//Ӧ�ù�ϵ�������
				log.debug("========Ӧ�ù�ϵ�������ʼ========");

				//DTO��������趨
				dto.setIgcim2006Form(form);
				
				//Ӧ�ù�ϵ����߼�����
				dto = ctlBL.updateEntityItemRelationActionApp(dto);
				
				log.debug("========Ӧ�ù�ϵ�����������========");
				forward = "BACK";
			}
		}
		
		if ("EDIT_DISP".equals(mapping.getParameter())){
			//Ӧ�ù�ϵ������������ʾ����
			log.debug("========Ӧ�ù�ϵ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgcim2006Form(form);
			
			//Ӧ�ù�ϵ������������ʾ�߼�����
			dto = ctlBL.initIGCIM2006Action(dto);
			
			log.debug("========Ӧ�ù�ϵ���������ʾ��������========");

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
