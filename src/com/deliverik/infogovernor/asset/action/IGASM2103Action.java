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
import com.deliverik.infogovernor.asset.bl.IGASM21BL;
import com.deliverik.infogovernor.asset.dto.IGASM21DTO;
import com.deliverik.infogovernor.asset.form.IGASM2103Form;
import com.deliverik.infogovernor.asset.vo.IGASM21031VO;

/**
 * ����: ��ƿ���̨����鿴Action
 * ��������: ��ƿ���̨����鿴Action
 * ������¼: 2111/04/29
 * �޸ļ�¼: 
 */
public class IGASM2103Action extends BaseAction {

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
		IGASM2103Form form = (IGASM2103Form)actionForm;
		
		//BLȡ��
		IGASM21BL ctlBL = (IGASM21BL) getBean("igasm21BL");
		
		//DTO����
		IGASM21DTO dto = new IGASM21DTO();
		
		dto.setIgasm2103Form(form);
		
		if ("DISP".equals(mapping.getParameter())){
			
			log.debug("========��ƿ���̨����鿴����ʼ========");
			
			//��ȡ�����б�
			dto = ctlBL.initIGASM2103Action(dto);
			
			//VO����
			IGASM21031VO vo = new IGASM21031VO(dto.getAuditWaitTask());
			
			super.<IGASM21031VO>setVO(req, vo);
			
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
