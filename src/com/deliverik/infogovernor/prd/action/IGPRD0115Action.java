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
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0115Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01151VO;

/**
 * ���̲��нڵ������Action����
 *
 */
public class IGPRD0115Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0115Action.class);

	/**
	 * ���̲��нڵ�����崦��
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGPRD0115Form form = (IGPRD0115Form)actionForm;
		
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		dto.setIgPRD0115Form(form);
		
		if( "DISP".equals(mapping.getParameter())){
			//�������ѯ���������ʾ����
			log.debug("========���нڵ�������ѯ���������ʾ����ʼ========");
			
			dto.setPdid(form.getPdid());
			//��������Ϣ�����߼�����
			dto = ctlBL.searchConcurrencyProcessTransitionDefAction(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			req.setAttribute("processStatusDefList", dto.getLabelList());
			req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			//����������Ϣ��������趨��VO��
			IGPRD01151VO vo = new IGPRD01151VO(dto.getProcessTransitionDefList(), 
					dto.getProcessStatusDef());
			
			super.<IGPRD01151VO>setVO(req, vo);
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���нڵ�������ѯ���������ʾ��������========");
		} else if("INSERT".equals(mapping.getParameter())) {
			log.debug("========���нڵ���������Ӵ���ʼ========");
			
			//���нڵ��������Ϣ��������
			if (isTokenValid(req, true)){
				dto = ctlBL.insertConcurrencyProcessTransitionDefAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========���нڵ���������Ӵ�������========");
		} else if("DELETE".equals(mapping.getParameter())) {
			log.debug("========���нڵ������ɾ������ʼ========");
			
			//���нڵ��������Ϣɾ������
			if (isTokenValid(req, true)){
				dto = ctlBL.deleteConcurrencyProcessTransitionDefAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========���нڵ������ɾ����������========");
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
