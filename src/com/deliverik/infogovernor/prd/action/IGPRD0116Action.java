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
import com.deliverik.infogovernor.prd.form.IGPRD0116Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01161VO;

/**
 * ����״̬_ȱʡ������_Ȩ��Action����
 *
 */
public class IGPRD0116Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0116Action.class);

	/**
	 * ����״̬_ȱʡ������_Ȩ�޴���
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
		IGPRD0116Form form = (IGPRD0116Form)actionForm;
		
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		
		//form����ֵ����ҳ�治����ʾ
		if(StringUtils.isNotEmpty(form.getPpsdid())) {
			req.setAttribute("ppsdid", form.getPpsdid());
		}
		
		if( "DISP".equals(mapping.getParameter())){
			//��ѯ���������ʾ����
			log.debug("========����״̬_ȱʡ������_Ȩ�޻��������ʾ����ʼ========");
			dto.setPdid(form.getPdid());
			dto.setIgPRD0116Form(form);
			dto = ctlBL.participantDefaultVariableInitAction(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			dto = ctlBL.searchDefaultRelevantProcessDefinitionAction(dto);
			IGPRD01161VO vo = new IGPRD01161VO();
			vo.setPsdid(form.getPsdid());
			vo.setPdid(form.getPdid());
			vo.setProcessStatusDef(dto.getProcessStatusDef());
			vo.setLst_ParticipantDefaultVariableVW(dto.getLst_ParticipantDefaultVariableVW());
			vo.setProcessParticipantButtonDefVWInfoList(dto.getProcessParticipantButtonDefVWInfoList());
			vo.setLst_processDefinitionInfo(dto.getRelevantProcessDefinitionList());
			req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01161VO>setVO(req, vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����״̬_ȱʡ������_Ȩ�޻��������ʾ��������========");
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//��ʷ�汾�µĲ鿴
				return mapping.findForward("VIEWHISTORY");
			}
			return mapping.findForward("DISP");
		} else if ( "GRANT".equals(mapping.getParameter())){
			log.debug("========����״̬_ȱʡ������_Ȩ����Ȩ����ʼ========");
			
			dto.setIgPRD0116Form(form);
			//�߼�����
			dto = ctlBL.grantDefaultPermissionAction(dto);
			// ������ط�����Զ�������������Ϣ
            dto = ctlBL.grantDefaultRelevantProcessAction(dto);
			//addMessage(req,new ActionMessage("IGCO10000.I010","Ȩ��"));
			log.debug("========����״̬_ȱʡ������_Ȩ����Ȩ��������========");
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
