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
import com.deliverik.infogovernor.prd.form.IGPRD0161Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01611VO;

/**
 * ����״̬������Ϣ�༭����Action����
 *
 */
public class IGPRD0161Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0161Action.class);

	/**
	 * ����״̬����
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
		IGPRD0161Form form = new IGPRD0161Form();
		
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		IGPRD01DTO dto =new IGPRD01DTO();
		
		//������ת�趨
		String forward = null;
		if( "DISP".equals(mapping.getParameter())){
			
			//�����ⲿ������Ϣ�Ǽǻ��������ʾ����
			log.debug("========�����ⲿ������Ϣ�Ǽǻ��������ʾ����ʼ========");
			if(StringUtils.isEmpty(form.getMode())){
				form.setMode("0");
			}
			
		 	req.setAttribute("IGPRD0161Form", form);
			saveToken(req);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","�����ⲿ���û�����Ϣ"));
			
			log.debug("========�����ⲿ������Ϣ�Ǽǻ��������ʾ��������========");
			
			return mapping.findForward("DISP");
		}else if( "DISP1".equals(mapping.getParameter())){
			
			//�����ⲿ������Ϣ�Ǽǻ��������ʾ����
			log.debug("========�����ⲿ������Ϣ�Ǽǻ��������ʾ����ʼ========");
			
				form.setMode("0");
			
			
		 	req.setAttribute("IGPRD0161Form", form);
			saveToken(req);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","�����ⲿ���û�����Ϣ"));
			
			log.debug("========�����ⲿ������Ϣ�Ǽǻ��������ʾ��������========");
			
			return mapping.findForward("DISP");
		} else if ("Update".equals(mapping.getParameter())) {
			IGPRD0161Form form1 = (IGPRD0161Form)actionForm;
			
			dto.setIgPRD0161Form(form1);
			  
			dto = ctlBL.searchProcessExternalDefByPK(dto);
			form1.setMode("1");
				//��������Ϣ��������趨��VO��				

			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========ǰ�����������ʾ��������========");
			return mapping.findForward("DISP");
		} else if ("INSERT".equals(mapping.getParameter())){
			IGPRD0161Form form1 = (IGPRD0161Form)actionForm;
			dto.setIgPRD0161Form(form1);
			 if(form1.getMode().equals("1")){
				 dto = ctlBL.updateProcessExternalDefAction(dto); 
				 addMessage(req, new ActionMessage("IGDAF0304.I001"));
			 }
			 else{
				 if (isTokenValid(req, true)){
					//����BL����
					dto = ctlBL.insertProcessExteralDefAction(dto);
					addMessage(req, new ActionMessage("IGDAF0303.I001"));
					
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			 }	
			//req.setAttribute("Pedeventid", form1.getPedeventid());
			//req.setAttribute("Pedaction", form1.getPedaction());
		//	req.setAttribute("Peddesc", form1.getPeddesc());
			req.setAttribute("form", form1);
			
			log.debug("========��ť�¼����������ʾ��������========");
			return mapping.findForward("DISP");
		}else if ("Delete".equals(mapping.getParameter())) {
            IGPRD0161Form form1 = (IGPRD0161Form)actionForm;
			dto.setIgPRD0161Form(form1);
			dto = ctlBL.deleteProcessExternalDefAction(dto);
				

			addMessage(req, new ActionMessage("IGDAF0302.I001"));
			log.debug("========�ⲿ�¼����������ʾ��������========");
			return mapping.findForward("DISP");
	  }else if ("LIST".equals(mapping.getParameter())) {
			//IGPRD0158Form form1 = (IGPRD0158Form)actionForm;
			//dto.setIgPRD0158Form(form1);
			//��������Ϣ��������趨��VO��
			dto = ctlBL.searchProcessExternalDefAction(dto);		
     		IGPRD01611VO vo = new IGPRD01611VO(dto.getProcessExternalDefList());
		
                	super.<IGPRD01611VO>setVO(req, vo); 
			
	//		req.setAttribute("pdid", form.getPdid());
	//		req.setAttribute("psdid", form.getPsdid());
	//  	req.setAttribute("psdcode", form.getPsdcode());
	//	    req.setAttribute("form", form);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�ⲿ�¼����������ʾ��������========");
			return mapping.findForward("DISP");
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
