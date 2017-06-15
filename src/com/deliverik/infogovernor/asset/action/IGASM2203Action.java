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
import com.deliverik.infogovernor.asset.bl.IGASM22BL;
import com.deliverik.infogovernor.asset.dto.IGASM22DTO;
import com.deliverik.infogovernor.asset.form.IGASM2203Form;
import com.deliverik.infogovernor.asset.vo.IGASM22031VO;

/**
 * ����: CI�������̨����鿴Action
 * ��������: CI�������̨����鿴Action
 * ������¼: 2211/04/29
 * �޸ļ�¼: 
 */
public class IGASM2203Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0322Action.class);

	/**
	 * CI�������̨����鿴����
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
		IGASM2203Form form = (IGASM2203Form)actionForm;
		
		//BLȡ��
		IGASM22BL ctlBL = (IGASM22BL) getBean("igasm22BL");
		
		//DTO����
		IGASM22DTO dto = new IGASM22DTO();
		
		dto.setIgasm2203Form(form);
		
		if ("DISP".equals(mapping.getParameter())){
			
			log.debug("========CI�������̨����鿴����ʼ========");
			
			//��ȡ�����б�
			dto = ctlBL.initIGASM2203Action(dto);
			
			//VO����
			IGASM22031VO vo = new IGASM22031VO(dto.getCiWaitTask());
			
			super.<IGASM22031VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========CI�������̨����鿴��������========");
			
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
