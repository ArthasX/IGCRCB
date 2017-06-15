/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.asset.action.IGASM0321Action;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM03BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM03DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0303Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM03031VO;

/**
 * ����: ��ƿ���̨����鿴Action
 * ��������: ��ƿ���̨����鿴Action
 * ������¼: 2111/04/29
 * �޸ļ�¼: 
 */
public class IGCIM0303Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0321Action.class);

	/**
	 * ��ƿ���̨����鿴����
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
		IGCIM0303Form form = (IGCIM0303Form)actionForm;
		
		//BLȡ��
		IGCIM03BL ctlBL = (IGCIM03BL) getBean("igcim03BL");
		
		//DTO����
		IGCIM03DTO dto = new IGCIM03DTO();
		
		dto.setIgcim0303Form(form);
		
		if ("DISP".equals(mapping.getParameter())){
			
			log.debug("========��ƿ���̨����鿴����ʼ========");
			
			//��ȡ�����б�
			dto = ctlBL.initIGCIM0303Action(dto);
			
			//VO����
			IGCIM03031VO vo = new IGCIM03031VO(dto.getAuditWaitTask());
			
			super.<IGCIM03031VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========��ƿ���̨����鿴��������========");
			
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
