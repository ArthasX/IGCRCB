/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.infogovernor.prd.form.IGPRD0143Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01431VO;

/**
 * ����: ����״̬�ɷ��ɻ�������Action
 * ��������: ����״̬�ɷ��ɻ�������Action
 * ������¼: 2013/02/25
 * �޸ļ�¼: 2013/02/25		130225	���̻�������޸�(״̬�ڵ�ɷ��ɻ�������)
 */
public class IGPRD0143Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRD0143Action.class);
	
	/**
	 * Action����
	 *
	 * @param mapping ActionMapping
	 * @param actionForm ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @exception Exception
	 * @return ActionForward
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGPRD0143Form form = (IGPRD0143Form)actionForm;
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");	
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		String forward = "DISP";
		dto.setIgPRD0143Form(form);
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========����״̬�ɷ��ɻ��������ѯ����ʼ========");
			dto.setPdid(form.getPdid());
			//����BL��ѯ
			dto = ctlBL.searchProcessStatusOrgDefAction(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			saveToken(request);
			//����VO
			IGPRD01431VO vo = new IGPRD01431VO();
			vo.setLst_ProcessStatusOrgDef(dto.getLst_ProcessStatusOrgDef());
			vo.setLst_Org(dto.getLst_org());
			request.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01431VO>setVO(request, vo);
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//��ʷ�汾�µĲ鿴
				forward = "VIEWHISTORY";
			}
			log.debug("========����״̬�ɷ��ɻ��������ѯ��������========");
		} else if ("INSERT".equals(mapping.getParameter())){//��Ӳ�����
			log.debug("========����״̬�ɷ��ɻ��������趨����ʼ========");
			//ɾ������
			if("0".equals(form.getMode())){
				if (isTokenValid(request, true)){
					//����BL����
					ctlBL.removeProcessStatusOrgDef(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}else{//��ӻ���
				if (isTokenValid(request, true)){
					//����BL����
					ctlBL.addProcessStatusOrgDef(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}

			log.debug("========����״̬�ɷ��ɻ��������趨��������========");
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
