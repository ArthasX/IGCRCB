/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0118Form;

/**
 * ����Ϣ������Ϣ�༭����Action����
 *
 */
public class IGPRD0118Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0118Action.class);

	/**
	 * ����Ϣ����
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
		IGPRD0118Form form = (IGPRD0118Form)actionForm;
		
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//����Ϣ�Ǽǻ��������ʾ����
			log.debug("========����Ϣ�Ǽǻ��������ʾ����ʼ========");
			String maxSort = ResourceUtility.getString("MAX_SORT");
			addMessage(req, new ActionMessage("IGCO10000.I001","����Ϣ������Ϣ"));
			req.setAttribute("maxSort", Integer.valueOf(maxSort));
			saveToken(req);
			log.debug("========����Ϣ�Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} else if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				//����Ϣ�ǼǴ���
				log.debug("========����Ϣ�ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgPRD0118Form(form);
				
				//����Ϣ��Ϣ�Ǽ��߼�����
				
				
				if (isTokenValid(req, true)){
					dto = ctlBL.insertProcessInfoDefGeneralAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				req.setAttribute("pdid", "");
				
				log.debug("========����Ϣ�ǼǴ�������========");
				
				forward = "DISP";
				
			} else {
				//����Ϣ�������
				log.debug("========����Ϣ������Ϣ�������ʼ========");
				
				//DTO��������趨
				dto.setIgPRD0118Form(form);
				
				//����Ϣ��Ϣ����߼�����
				dto = ctlBL.updateProcessInfoDefGeneralAction(dto);
				
				log.debug("========����Ϣ������Ϣ�����������========");
				
				forward = "BACK";
			}
		} 
		else if( "COPYGT".equals(mapping.getParameter())){
			log.debug("========��ͨ������ֵ����Ϣ������Ϣ��ʾ����ʼ========");
			form.setPdid(req.getParameter("pdid"));
			dto.setIgPRD0118Form(form);
			ctlBL.insertProcessInfoDefFromProcessInfoDefGeneralAction(dto);
			req.setAttribute("pdid", form.getPdid());
			log.debug("========��ͨ������ֵ����Ϣ������Ϣ��ʾ��������========");

			if("basic".equals(form.getBasic())) {
				forward = "BASIC";
			} else {
				forward = "DISP";
			}
		}
		else if ("EDIT".equals(mapping.getParameter())){
			log.debug("========����Ϣ������Ϣ���������ʾ����ʼ========");
			dto.setIgPRD0118Form(form);
			
			dto = ctlBL.initIGPRD0118Action(dto);
			
			log.debug("========����Ϣ������Ϣ���������ʾ��������========");

			forward = "DISP";
		} else if ("DELETE".equals(mapping.getParameter())){
				log.debug("========����Ϣɾ������ʼ========");
				
				dto.setIgPRD0118Form(form);
				
				dto = ctlBL.deleteProcessInfoDefGeneralAction(dto);
				if("no".equals(dto.getDelFalg())){
					forward = "NO";
				}
				log.debug("========����Ϣɾ����������========");
				
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
