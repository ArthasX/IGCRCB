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
import com.deliverik.infogovernor.prd.form.IGPRD0105Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01051VO;

/**
 * ����������״̬������Ϣ�༭����Action����
 * ��������: ���̶���ҵ���߼�ʵ�� 
 * ������¼: 2010/11/07
 * �޸ļ�¼: 2013/02/25		130225	���̻�������޸�(״̬�ڵ�����������޸�)
 */
public class IGPRD0105Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0105Action.class);

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
		IGPRD0105Form form = (IGPRD0105Form)actionForm;
		
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		dto.setPdid(form.getPdid());
		//������ת�趨
		String forward = null;

		//====>130225Begin
		//��ѯ�����������б�
		ctlBL.searchCodedetailFromPsdassign(dto);
		// ����request
		req.setAttribute("lvPsdassignListUR", dto.getLvPsdassignListUR());
		req.setAttribute("lvPsdassignListRO", dto.getLvPsdassignListRO());
		//====>130225End
		
		if( "DISP".equals(mapping.getParameter())){
			//����״̬�Ǽǻ��������ʾ����
			log.debug("========����״̬�Ǽǻ��������ʾ����ʼ========");
			if(StringUtils.isEmpty(form.getMode())){
				form.setMode("0");
			}
			dto.setIgPRD0105Form(form);
			dto = ctlBL.searchProcessStatusDef(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			IGPRD01051VO vo = new IGPRD01051VO();
			vo.setProcessStatusDefList(dto.getProcessStatusDefList());
			super.<IGPRD01051VO>setVO(req, vo);
			addMessage(req, new ActionMessage("IGCO10000.I001","����״̬������Ϣ"));
			log.debug("========����״̬�Ǽǻ��������ʾ��������========");
			
			return mapping.findForward("DISP");
		} else if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				//����״̬�ǼǴ���
				log.debug("========����״̬�ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgPRD0105Form(form);
				
				//����״̬��Ϣ�Ǽ��߼�����
				dto = ctlBL.insertProcessStatusDefinitionAction(dto);
				
				log.debug("========����״̬�ǼǴ�������========");
				
				forward = "DISP";
				
			} else {
				//����״̬�������
				log.debug("========����״̬������Ϣ�������ʼ========");
				
				//DTO��������趨
				dto.setIgPRD0105Form(form);
				
				//����״̬��Ϣ����߼�����
				dto = ctlBL.updateProcessStatusDefinitionAction(dto);
				
				log.debug("========����״̬������Ϣ�����������========");
				if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
					//��ʷ�汾�µĲ鿴
					forward = "VIEWHISTORY";
				}else{
					forward = "DISP";
				}
			}
		} else if ("EDIT".equals(mapping.getParameter())){
			log.debug("========����״̬������Ϣ���������ʾ����ʼ========");
			form.setMode("1");
			dto.setIgPRD0105Form(form);
			
			dto = ctlBL.initIGPRD0105Action(dto);
			dto = ctlBL.searchProcessStatusDef(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			IGPRD01051VO vo = new IGPRD01051VO();
			vo.setProcessStatusDefList(dto.getProcessStatusDefList());
			vo.setApList(dto.getApList());
			super.<IGPRD01051VO>setVO(req, vo);
			req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			log.debug("========����״̬������Ϣ���������ʾ��������========");

			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//��ʷ�汾�µĲ鿴
				forward = "VIEWHISTORY";
			}else{
				forward = "DISP";
			}
		}else if("UPDATEZ".equals(mapping.getParameter())){
			log.debug("========����״̬������Ϣ���������ʾ����ʼ========");
			if(isTokenValid(req,true)){
				dto.setIgPRD0105Form(form);
				dto = ctlBL.updateProcessStatusDefZAction(dto);
			}else{
				return null;
			}
			log.debug("========����״̬������Ϣ���������ʾ��������========");
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
