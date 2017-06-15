package com.deliverik.infogovernor.asset.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.asset.bl.IGASM11BL;
import com.deliverik.infogovernor.asset.dto.IGASM11DTO;
import com.deliverik.infogovernor.asset.form.IGASM1112Form;

/**
 * ����༭����Action����
 *
 * @author
 */
public class IGASM1112Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1112Action.class);

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
		IGASM1112Form form = (IGASM1112Form)actionForm;
		
		//BLȡ��
		IGASM11BL ctlBL = (IGASM11BL) getBean("igasm11BL");
		
		//DTO����
		IGASM11DTO dto = new IGASM11DTO();
		
		//������ת�趨
		String forward = null;

		if ( "DISP".equals(mapping.getParameter())) {
			//����Ǽǻ��������ʾ����
			log.debug("========����Ǽǻ��������ʾ����ʼ========");
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);			
			
			addMessage(req, new ActionMessage("IGCO10000.I001","������Ϣ"));
			log.debug("========����Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		}

		if( "INSERT".equals(mapping.getParameter())){
			//����༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//����༭���水�·��ذ�ťʱ�ķ��ش���
				if (form.getMode().equals("1")){
					//���ػ����б���
					return mapping.findForward("BACK");
				}
			}
			if (form.getMode().equals("0")){
				//����ǼǴ���
				log.debug("========����ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgasm1112Form(form);
				
				//������Ϣ�Ǽ��߼�����
				dto = ctlBL.insertComputerContainerInfoAction(dto);
				
				log.debug("========����ǼǴ�������========");
				
				forward = "DISP";

			} else {
				//����������
				log.debug("========����������ʼ========");
				
				//DTO��������趨
				dto.setIgasm1112Form(form);
				
				//�������߼�����
				dto = ctlBL.updateComputerContainerAction(dto);
				
				log.debug("========��������������========");
				
				forward = "BACK";
			}
		}
		
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========������Ϣ���������ʾ����ʼ========");
			dto.setIgasm1112Form(form);
			
			dto = ctlBL.initIGASM1112Action(dto);
			if(EntityItemKeyWords.VALUE_PULLDOWN.equals(dto.getIgasm1112Form().getEimark()))
			{
				form.setJilabel(dto.getIgasm1112Form().getEilabel());
				form.setJidesc(dto.getIgasm1112Form().getEidesc());
				form.setJiname(dto.getIgasm1112Form().getEiname());
				form.setJ_total(dto.getIgasm1112Form().getU_total());
			}
			log.debug("========������Ϣ���������ʾ��������========");

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
