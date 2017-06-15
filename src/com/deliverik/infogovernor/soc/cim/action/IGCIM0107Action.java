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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0107Form;

/**
 * �豸��ϵ�༭����Action����
 *
 * @author
 */
public class IGCIM0107Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0107Action.class);

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
		IGCIM0107Form form = (IGCIM0107Form)actionForm;
		
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO����
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setLocale(this.getLocale(req));
		dto.setIgcim0107Form(form);
		
		if("1".equals(form.getRelationType())){
			//������ϵ
			dto = ctlBL.searchEiBelongRelationListAction(dto);	
		}else{
			//��ͨ��ϵ
			dto = ctlBL.searchRelationListAction(dto);
					
		}
		//��ѯ��ϵ����
		dto = ctlBL.searchRelationType(dto);
		req.getSession().setAttribute("ADrelationTypeList", dto.getRelationTypeList());
		req.getSession().setAttribute("ADrelationList", dto.getRelationList());
		//������ת�趨
		String forward = null;
		
		req.setAttribute("backUrl", req.getParameter("backUrl"));
		//
		if( "DISP".equals(mapping.getParameter())){
			//�豸��ϵ�Ǽǻ��������ʾ����
			log.debug("========�豸��ϵ�Ǽǻ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I001","�豸��ϵ��Ϣ"));
			
			req.getSession().setAttribute("IGCIM0107Form", form);
			
			saveToken(req);
			
			log.debug("========�豸��ϵ�Ǽǻ��������ʾ��������========");
			
			forward = "DISP";
		}

		if( "EDIT".equals(mapping.getParameter())){
			//�豸��ϵ�༭����
			if ((isCancelled(req)||(req.getParameter("backUrl")!=null)) && !"add".equals(req.getParameter("param"))) {
				//���·��ذ�ťʱ�ķ��ش���
				return mapping.findForward("BACK");
			}
			
			if (form.getMode().equals("0")){
				//�����ϵ�ǼǴ���
				log.debug("========�豸��ϵ�ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgcim0107Form(form);
				
				if (isTokenValid(req, true)){
					if("1".equals(form.getRelationType())){
						//�Ǽ�������ϵ
						dto = ctlBL.insertEntityItemEiBelongRelationAction(dto);
					}else{
						//�豸��ϵ�Ǽ��߼�����
						dto = ctlBL.insertEntityItemRelationAction(dto);
					}
					
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}

				log.debug("========�豸��ϵ�ǼǴ�������========");
				forward = "BACK";

			} else {
				//�豸��ϵ�������
				log.debug("========�豸��ϵ�������ʼ========");

				//DTO��������趨
				dto.setIgcim0107Form(form);
				
				//�豸��ϵ����߼�����
				dto = ctlBL.updateEntityItemRelationAction(dto);
				
				log.debug("========�豸��ϵ�����������========");
				forward = "BACK";
			}
		}
		
		if ("EDIT_DISP".equals(mapping.getParameter())){
			//�豸��ϵ������������ʾ����
			log.debug("========�豸��ϵ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgcim0107Form(form);
			
			//�豸��ϵ������������ʾ�߼�����
			dto = ctlBL.initIGASM0307Action(dto);
			
			log.debug("========�豸��ϵ���������ʾ��������========");

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
