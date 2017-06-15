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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM02BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0210Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM02101VO;

/**
 * ����: ����̨����鿴Action
 * ��������: ����̨����鿴Action
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
public class IGCIM0210Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0210Action.class);

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
		IGCIM0210Form form = (IGCIM0210Form)actionForm;
		
		//BLȡ��
		IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		
		//DTO����
		IGCIM02DTO dto = new IGCIM02DTO();
		
		dto.setIgcim0210Form(form);
		
		if ("DISP".equals(mapping.getParameter())){
			
			log.debug("========����̨����鿴����ʼ========");
			
			//��ȡ�����б�
			dto = ctlBL.initIGCIM0210Action(dto);
			
			//VO����
			IGCIM02101VO vo = new IGCIM02101VO(dto.getEiWaitTask());
			
			super.<IGCIM02101VO>setVO(req, vo);
			
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
