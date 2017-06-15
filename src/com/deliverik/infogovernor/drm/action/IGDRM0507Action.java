package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM05BL;
import com.deliverik.infogovernor.drm.dto.IGDRM05DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0507Form;

/**
 * ר��Ԥ����ϵ�༭����Action����
 *
 * @author
 */
public class IGDRM0507Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0507Action.class);

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
		IGDRM0507Form form = (IGDRM0507Form)actionForm;
		
		//BLȡ��
		IGDRM05BL ctlBL = (IGDRM05BL) getBean("igdrm05BL");
		
		//DTO����
		IGDRM05DTO dto = new IGDRM05DTO();
		
		dto = ctlBL.searchRelationListAction(dto);
		req.getSession().setAttribute("ADrelationList", dto.getRelationList());
		
		//������ת�趨
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//ר��Ԥ����ϵ�Ǽǻ��������ʾ����
			log.debug("========ר��Ԥ����ϵ�Ǽǻ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I001","ר��Ԥ����ϵ��Ϣ"));
			
			req.getSession().setAttribute("IGDRM0507Form", form);
			
			log.debug("========ר��Ԥ����ϵ�Ǽǻ��������ʾ��������========");
			
			saveToken(req);
			
			forward = "DISP";
		}

		if( "EDIT".equals(mapping.getParameter())){
			//ר��Ԥ����ϵ�༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)) {
				//���·��ذ�ťʱ�ķ��ش���
				return mapping.findForward("BACK");
			}
			
			if (form.getMode().equals("0")){
				//�����ϵ�ǼǴ���
				log.debug("========ר��Ԥ����ϵ�ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgdrm0507Form(form);
				if (isTokenValid(req, true)){
					//ר��Ԥ����ϵ�Ǽ��߼�����
					dto = ctlBL.insertEntityItemRelationAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========ר��Ԥ����ϵ�ǼǴ�������========");
				forward = "BACK";

			} else {
				//ר��Ԥ����ϵ�������
				log.debug("========ר��Ԥ����ϵ�������ʼ========");

				//DTO��������趨
				dto.setIgdrm0507Form(form);
				
				//ר��Ԥ����ϵ����߼�����
				dto = ctlBL.updateEntityItemRelationAction(dto);
				
				log.debug("========ר��Ԥ����ϵ�����������========");
				forward = "BACK";
			}
		}
		
		if ("EDIT_DISP".equals(mapping.getParameter())){
			//ר��Ԥ����ϵ������������ʾ����
			log.debug("========ר��Ԥ����ϵ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgdrm0507Form(form);
			
			//ר��Ԥ����ϵ������������ʾ�߼�����
			dto = ctlBL.initIGDRM0507Action(dto);
			
			log.debug("========ר��Ԥ����ϵ���������ʾ��������========");

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
