/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.infogovernor.prd.form.IGPRD0159Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01591VO;

/**
 * ����: ���̲���֪ͨ���趨Action
 * ��������: ���̲���֪ͨ���趨Action
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
public class IGPRD0159Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRD0159Action.class);
	
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
		IGPRD0159Form form = (IGPRD0159Form)actionForm;
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");	
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		String forward = "DISP";
		dto.setIgPRD0159Form(form);
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========���̲���֪ͨ�˲�ѯ����ʼ========");
			//����BL��ѯ
			dto = ctlBL.initIGPRD0159Action(dto);
			//����VO
			IGPRD01591VO vo = new IGPRD01591VO();
			vo.setLst_IGPRD01592VO(dto.getLst_UserRoleInfo());
			super.<IGPRD01591VO>setVO(request, vo);
			log.debug("========���̲���֪ͨ�˲�ѯ��������========");
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
