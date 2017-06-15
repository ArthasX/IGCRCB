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
import com.deliverik.infogovernor.prd.form.IGPRD0108Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01081VO;

/**
 * ����״̬_������_Ȩ��Action����
 *
 */
public class IGPRD0108Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0108Action.class);

	/**
	 * ����״̬_������_Ȩ�޴���
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
		IGPRD0108Form form = (IGPRD0108Form)actionForm;
		
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		String forwar = "DISP";
		if( "DISP".equals(mapping.getParameter())){
			//��ѯ���������ʾ����
			log.debug("========����״̬_������_Ȩ�޻��������ʾ����ʼ========");
			String psdid = req.getParameter("psdid");
			String ppdid = req.getParameter("ppdid");
			String pdid = req.getParameter("pdid");
			if(psdid!=null && !"".equals(psdid)){
				form.setPsdid(psdid);
			}
			if(ppdid!=null && !"".equals(ppdid)){
				form.setPpdid(ppdid);
			}
			if(pdid!=null && !"".equals(pdid)){
				form.setPdid(pdid);
			}
			dto.setPdid(form.getPdid());
			dto.setIgPRD0108Form(form);
			dto = ctlBL.processInfoParticipantDefInitAction(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			dto = ctlBL.searchRelevantProcessDefinitionAction(dto);
			IGPRD01081VO vo = new IGPRD01081VO();

			vo.setProcessStatusDef(dto.getProcessStatusDef());
			vo.setLst_processInfoParticipantDefVW(dto.getLst_ProcessInfoParticipantDefVW());
			vo.setProcessParticipantDef(dto.getProcessParticipantDef());
			vo.setProcessParticipantButtonDefVWInfoList(dto.getProcessParticipantButtonDefVWInfoList());
			vo.setLst_processDefinitionInfo(dto.getRelevantProcessDefinitionList());
			req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01081VO>setVO(req, vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����״̬_������_Ȩ�޻��������ʾ��������========");
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//��ʷ�汾�µĲ鿴
				return mapping.findForward("VIEWHISTORY");
			}
			return mapping.findForward("DISP");
		} else if ( "GIVE".equals(mapping.getParameter())){
			log.debug("========����״̬_������_Ȩ����Ȩ����ʼ========");
			
			dto.setIgPRD0108Form(form);
			//�߼�����
			dto = ctlBL.grantPermissionAction(dto);
			// ������ط�����Զ�������������Ϣ
			dto = ctlBL.grantRelevantProcessAction(dto);
			if(StringUtils.isNotEmpty(dto.getProcessParticipantDef().getOrgid())){
				forwar = "DISP2";
			}
			log.debug("========����״̬_������_Ȩ����Ȩ��������========");
		} 
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forwar);
	}
}
