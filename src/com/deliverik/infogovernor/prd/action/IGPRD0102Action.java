/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0102Form;
import com.deliverik.infogovernor.prd.form.IGPRD0104Form;

/**
 * ���̶��������Ϣ�༭����Action����
 *
 */
public class IGPRD0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0102Action.class);

	/**
	 * ���̶��崦��
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
		IGPRD0102Form form = (IGPRD0102Form)actionForm;
		
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//���̶���Ǽǻ��������ʾ����
			log.debug("========���̶���Ǽǻ��������ʾ����ʼ========");
			dto = ctlBL.searchActionListAction(dto);
			req.setAttribute("actionLabelValueList", dto.getActionLabelValueList());
			//��ܱ���
			String message = "";
			addMessage(req, new ActionMessage("IGCO10000.I001",message));
			log.debug("========���̶���Ǽǻ��������ʾ��������========");
			saveToken(req);
			return mapping.findForward("DISP");
		} else if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				//���̶���ǼǴ���
				log.debug("========���̶���ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgPRD0102Form(form);
				if (isTokenValid(req, true)){
					//���̶�����Ϣ�Ǽ��߼�����
					dto = ctlBL.insertProcessDefinitionAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========���̶���ǼǴ�������========");
				
				forward = "DISP";
				
			} else {
				//���̶���������
				log.debug("========���̶��������Ϣ�������ʼ========");
				
				//DTO��������趨
				dto.setIgPRD0102Form(form);
				
				//���̶�����Ϣ����߼�����
				dto = ctlBL.updateProcessDefinitionAction(dto);
				
				log.debug("========���̶��������Ϣ�����������========");
				
				forward = "BACK";
			}
		} else if ("EDIT".equals(mapping.getParameter())){
			log.debug("========���̶��������Ϣ���������ʾ����ʼ========");
			dto.setIgPRD0102Form(form);
			
			dto = ctlBL.initIGPRD0102Action(dto);
			dto = ctlBL.searchActionListAction(dto);
            req.setAttribute("actionLabelValueList", dto.getActionLabelValueList());
			dto.setPdid(form.getPdid());
			dto = ctlBL.isProcessDefinitionInUse(dto);
			req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			log.debug("========���̶��������Ϣ���������ʾ��������========");
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//��ʷ�汾�µĲ鿴
				forward = "VIEWHISTORY";
			}else{
				forward = "DISP";
			}
		} else if ("CHANGE".equals(mapping.getParameter())){
				log.debug("========���̶���ͣ��/���ô���ʼ========");
				IGPRD0104Form form1 = new IGPRD0104Form();
				form1.setPdid(form.getPdid());
				dto.setIgPRD0102Form(form);
				dto.setIgPRD0104Form(form1);
				
				ctlBL.changeProcessDefinitionAction(dto);
				
				log.debug("========���̶���ͣ��/���ô�������========");
				
				if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
					//��ʷ�汾�µĲ鿴
					forward = "VIEWHISTORY";
				}else{
					forward = "DISP";
				}
		} else if ("TEST".equals(mapping.getParameter())){
			log.debug("========���̶�����Դ���ʼ========");
			IGPRD0104Form form1 = new IGPRD0104Form();
			form1.setPdid(form.getPdid());
			dto.setIgPRD0102Form(form);
			dto.setIgPRD0104Form(form1);
			
			ctlBL.testProcessDefinitionAction(dto);
			
			log.debug("========���̶�����Դ�������========");
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//��ʷ�汾�µĲ鿴
				forward = "VIEWHISTORY";
			}else{
				forward = "DISP";
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
