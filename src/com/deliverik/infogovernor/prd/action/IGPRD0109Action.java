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
import com.deliverik.infogovernor.prd.form.IGPRD0109Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01091VO;

/**
 * �������ѯAction����
 *
 * @author liupeng@deliverik.com
 */
public class IGPRD0109Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0109Action.class);

	/**
	 * �������ѯ����
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
		IGPRD0109Form form = (IGPRD0109Form)actionForm;
		
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			//�������ѯ���������ʾ����
			log.debug("========�������ѯ���������ʾ����ʼ========");
			
			dto.setIgPRD0109Form(form);
			dto.setPdid(form.getPdid());
			//��������Ϣ�����߼�����
			
			dto.setFlag(form.getFlag());
			dto = ctlBL.searchProcessTransitionDefAction(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
		
			req.setAttribute("processStatusDefList", dto.getLabelList());
			req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			
			//����������Ϣ��������趨��VO��
			IGPRD01091VO vo = new IGPRD01091VO(dto.getProcessTransitionDefList(), 
					dto.getProcessStatusDef(),dto.getProcessParticipantDefList());
			vo.setParticipantDefaultButtonDefInfoList(dto.getParticipantDefaultButtonDefInfoList());
			vo.setProcessParticipantButtonDefMap(dto.getProcessParticipantButtonDefMap());
			//�Ƿ�ȱʡ������
			if("1".equals(form.getFlag())) {
				forward = "DISP1";
			}
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//��ʷ�汾�µĲ鿴
				forward = "VIEWHISTORY";
				//��ʷȱʡ������
				if("1".equals(form.getFlag())) {
					forward = "VIEWHISTORY1";
				}
			}
			super.<IGPRD01091VO>setVO(req, vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�������ѯ���������ʾ��������========");
		} else if("INSERT".equals(mapping.getParameter())) {
			log.debug("========���������Ӵ���ʼ========");
			
			dto.setIgPRD0109Form(form);
			
			//��������Ϣ�����߼�����
			dto = ctlBL.insertProcessTransitionDefAction(dto);
			
			log.debug("========���������Ӵ�������========");
		} else if("DELETE".equals(mapping.getParameter())) {
			log.debug("========������ɾ������ʼ========");
			
			dto.setIgPRD0109Form(form);
			
			//��������Ϣ�����߼�����
			dto = ctlBL.deleteProcessTransitionDefAction(dto);
			
			log.debug("========������ɾ����������========");
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
