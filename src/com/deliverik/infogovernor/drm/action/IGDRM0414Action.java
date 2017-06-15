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
import com.deliverik.infogovernor.drm.bl.IGDRM04BL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0414Form;

/**
 * ����������Ϣ�༭����Action����
 *
 */
public class IGDRM0414Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0414Action.class);

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
		IGDRM0414Form form = (IGDRM0414Form)actionForm;
		
		//BLȡ��
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		
		//DTO����
		IGDRM04DTO dto = new IGDRM04DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//����������Ϣ�Ǽǻ��������ʾ����
			log.debug("========����������Ϣ�Ǽǻ��������ʾ����ʼ========");
			req.setAttribute("IGDRM0414Form", form);
			if("1".equals(String.valueOf(req.getAttribute("route")))){
				form.setRoute(String.valueOf(req.getAttribute("route")));
			}
			addMessage(req, new ActionMessage("IGCO10000.I001","����������Ϣ"));
			log.debug("========����������Ϣ�Ǽǻ��������ʾ��������========");
			saveToken(req);
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//����������Ϣ�Ǽǻ�������ʾ����
			log.debug("========����������Ϣ�Ǽǻ�������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����������Ϣ�Ǽǻ�������ʾ��������========");
			saveToken(req);
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//����������Ϣ�༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//����������Ϣ�༭���水�·��ذ�ťʱ�ķ��ش���
				if (form.getRoute().equals("0")){
					//�������͵Ǽǻ���
					return mapping.findForward("BACK1");
				} else {
					//����������ϸ ����
					return mapping.findForward("BACK2");
				}
			}
			if (form.getMode().equals("0")){
				//����������Ϣ�ǼǴ���
				log.debug("========����������Ϣ�ǼǴ���ʼ========");
				
				form.setCstatus("1");
				//���Թ�������
				if("4".equals(form.getCattach())){
					form.setCoption(form.getCesyscoding());
				}
				//DTO��������趨
				dto.setConfiguration(form);
				
				if (isTokenValid(req, true)){
					//����������Ϣ�Ǽ��߼�����
					dto = ctlBL.insertConfigurationAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				log.debug("========����������Ϣ�ǼǴ�������========");
				
				forward = "DISP";

			} else {
				//����������Ϣ�������
				log.debug("========����������Ϣ�������ʼ========");
				
				//���Թ�������
				if("4".equals(form.getCattach())){
					form.setCoption(form.getCesyscoding());
				}

				//DTO��������趨
				dto.setConfiguration(form);
				
				//����������Ϣ����߼�����
				dto = ctlBL.updateConfigurationAction(dto);
				
				log.debug("========����������Ϣ�����������========");

				forward = "DETAIL";
			}
		}
		
		if ("EDIT".equals(mapping.getParameter())){
			//����������Ϣ�༭������ڴ���
			log.debug("========����������Ϣ�༭������ڴ���ʼ========");

			//DTO��������趨
			dto.setIgdrm0414Form(form);
			
			//����������Ϣ�༭������ڴ����߼�����
			dto = ctlBL.initIGDRM0414Action(dto);
			
			log.debug("========����������Ϣ�����������========");

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
