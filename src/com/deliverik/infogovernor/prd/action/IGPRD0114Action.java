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
import com.deliverik.infogovernor.prd.form.IGPRD0114Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01141VO;

/**
 * ����״̬_���ɽ�ɫ�趨Action
 *
 */

public class IGPRD0114Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRD0114Action.class);
	
	/**
	 * <p>
	 * Description: ���ɽ�ɫ�趨����action
	 * </p>
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGPRD0114Form form = (IGPRD0114Form)actionForm;
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");	
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		dto.setIgPRD0114Form(form);
		dto.setPdid(form.getPdid());

		if ("DISP".equals(mapping.getParameter())){
			log.debug("========����Ӳ����߲�ѯ����ʼ========");
			//����BL��ѯ
			//��ѯ������
			dto = ctlBL.searchDispatchProcessParticipant(dto);
			//��ѯȨ��
			dto = ctlBL.isProcessDefinitionInUse(dto);
			saveToken(request);
			//����VO
			IGPRD01141VO vo = new IGPRD01141VO(dto.getProcessParticipantDefList());
			request.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01141VO>setVO(request, vo);
			log.debug("========����Ӳ����߲�ѯ��������========");
		}
		//���ɽ�ɫ�趨
		if ("ASSIGN".equals(mapping.getParameter())){
			log.debug("========���ɽ�ɫ�趨����ʼ========");

			//����BL����
			if (isTokenValid(request, true)){
				if("1".equals(form.getMode())){
					ctlBL.clearProcessParticipant(dto);//���
				} else {
					ctlBL.assignProcessParticipant(dto);//�趨
				}
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========���ɽ�ɫ�趨��������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}
	
}
