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
import com.deliverik.infogovernor.asset.bl.IGASM01BL;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.form.IGASM0104Form;

/**
 * ����������Ϣ�༭����Action����
 *
 */
public class IGASM0104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0104Action.class);

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
		IGASM0104Form form = (IGASM0104Form)actionForm;
		
		//BLȡ��
		IGASM01BL ctlBL = (IGASM01BL) getBean("igasm01BL");
		
		//DTO����
		IGASM01DTO dto = new IGASM01DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//����������Ϣ�Ǽǻ��������ʾ����
			log.debug("========����������Ϣ�Ǽǻ��������ʾ������ʼ========");
			req.setAttribute("IGASM0104Form", form);
			if("1".equals(String.valueOf(req.getAttribute("route")))){
				form.setRoute(String.valueOf(req.getAttribute("route")));
			}
			addMessage(req, new ActionMessage("IGCO10000.I001","ģ��������Ϣ"));
			log.debug("========����������Ϣ�Ǽǻ��������ʾ��������========");
			saveToken(req);
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//����������Ϣ�Ǽǻ�������ʾ����
			log.debug("========����������Ϣ�Ǽǻ�������ʾ������ʼ========");
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
				log.debug("========����������Ϣ�ǼǴ�����ʼ========");
				
				form.setCstatus("1");
				//���Թ���ģ��
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
				log.debug("========����������Ϣ���������ʼ========");
				
				//���Թ���ģ��
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
			log.debug("========����������Ϣ�༭������ڴ�����ʼ========");

			//DTO��������趨
			dto.setIgasm0104Form(form);
			
			//����������Ϣ�༭������ڴ����߼�����
			dto = ctlBL.initIGASM0104Action(dto);
			
			log.debug("========����������Ϣ�����������========");

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