/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM20BL;
import com.deliverik.infogovernor.asset.dto.IGASM20DTO;
import com.deliverik.infogovernor.asset.form.IGASM2010Form;
import com.deliverik.infogovernor.asset.vo.IGASM20101VO;

/**
 * ����: ����̨����鿴Action
 * ��������: ����̨����鿴Action
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
public class IGASM2010Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0321Action.class);

	/**
	 * ����̨����鿴����
	 *
	 * @param mapping ActionMapping 
	 * @param actionForm ActionForm 
	 * @param req HttpServletRequest 
	 * @param res HttpServletResponse 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORMȡ��
		IGASM2010Form form = (IGASM2010Form)actionForm;
		
		//BLȡ��
		IGASM20BL ctlBL = (IGASM20BL) getBean("igasm20BL");
		
		//DTO����
		IGASM20DTO dto = new IGASM20DTO();
		
		dto.setIgasm2010Form(form);
		
		if ("DISP".equals(mapping.getParameter())){
			
			log.debug("========����̨����鿴����ʼ========");
			
			//��ȡ�����б�
			dto = ctlBL.initIGASM2010Action(dto);
			
			//VO����
			IGASM20101VO vo = new IGASM20101VO(dto.getEiWaitTask());
			
			super.<IGASM20101VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========����̨����鿴��������========");
			
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
