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
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0107Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01071VO;

/**
 * ����״̬_������Action
 *
 */

public class IGPRD0107Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRD0107Action.class);
	
	/**
	 * <p>
	 * Description: �����ߴ���action
	 * </p>
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGPRD0107Form form = (IGPRD0107Form)actionForm;
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");	
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();

		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========�����߲�ѯ����ʼ========");
			String psdid = request.getParameter("psdid");
			String pdid = request.getParameter("pdid");
			if(psdid!=null && !"".equals(psdid)){
				form.setPsdid(psdid);
			}
			if(pdid!=null && !"".equals(pdid)){
				form.setPdid(pdid);
				request.setAttribute("pdid", pdid);
			}
			dto.setIgPRD0107Form(form);
			dto.setPdid(form.getPdid());
			//����BL��ѯ
			dto = ctlBL.getProcessParticipants(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			saveToken(request);
			//����VO
			IGPRD01071VO vo = new IGPRD01071VO(dto.getRoleList(),dto.getProcessParticipantDefList());
			vo.setProcessStatusDef(dto.getProcessStatusDef());
			vo.setProcessParticipantDefMap(dto.getProcessParticipantDefMap());
			request.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01071VO>setVO(request, vo);
			//OAģʽ
			if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(dto.getProcessStatusDef().getPsdtype())) {
				forward = "DISP2";
			}
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//��ʷ�汾�µĲ鿴
				forward = "VIEWHISTORY";
				//OAģʽ
				if(IGPRDCONSTANTS.MODE_OA.equals(dto.getProcessStatusDef().getPsdmode())) {
					forward = "VIEWHISTORY1";
				}
			}
			log.debug("========�����߲�ѯ��������========");
		} else if ("INSERT".equals(mapping.getParameter())){//��Ӳ�����
			log.debug("========�����ߴ���ʼ========");

			dto.setIgPRD0107Form(form);
			//ɾ����ɫ
			if("0".equals(form.getMode())){
				if (isTokenValid(request, true)){
					//����BL����
					ctlBL.removeProcessParticipants(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}else{//��ӽ�ɫ
				if (isTokenValid(request, true)){
					//����BL����
					ctlBL.addProcessParticipants(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}

			log.debug("========�����ߴ�������========");
		}
		if("CHANGE".equals(mapping.getParameter())){
			log.debug("===========�����߱�����������ʼ===========");
			//dto�����趨
			dto.setIgPRD0107Form(form);
			if (isTokenValid(request, true)){
				dto = ctlBL.changeProcessParticipants(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("===========�����߱�������������===========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}
	
}
