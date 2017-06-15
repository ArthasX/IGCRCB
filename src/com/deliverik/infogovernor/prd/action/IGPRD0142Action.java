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
import com.deliverik.infogovernor.prd.form.IGPRD0142Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01421VO;

/**
 * ����: ����״̬�ɵ��������߶���Action
 * ��������: ����״̬�ɵ��������߶���Action
 * ������¼: 2012/05/09
 * �޸ļ�¼: 
 */
public class IGPRD0142Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRD0142Action.class);
	
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
		IGPRD0142Form form = (IGPRD0142Form)actionForm;
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");	
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		String forward = "DISP";
		dto.setIgPRD0142Form(form);
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========����״̬�ɵ��������߲�ѯ����ʼ========");
			dto.setPdid(form.getPdid());
			//����BL��ѯ
			dto = ctlBL.searchProcessStatusPrtChangeDefAction(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			saveToken(request);
			//����VO
			IGPRD01421VO vo = new IGPRD01421VO();
			vo.setPsdTBList(dto.getPsdTBList());
			request.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01421VO>setVO(request, vo);
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//��ʷ�汾�µĲ鿴
				forward = "VIEWHISTORY";
			}
			log.debug("========����״̬�ɵ��������߲�ѯ��������========");
		} else if ("INSERT".equals(mapping.getParameter())){//��Ӳ�����
			log.debug("========����״̬�ɵ����������趨����ʼ========");
			//ɾ����ɫ
			if (isTokenValid(request, true)){
				//����BL����
				ctlBL.changeProcessStatusPrtChangeDefAction(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========����״̬�ɵ����������趨��������========");
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
