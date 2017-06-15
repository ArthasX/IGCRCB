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
import com.deliverik.infogovernor.asset.bl.IGASM03BL;
import com.deliverik.infogovernor.asset.dto.IGASM03DTO;
import com.deliverik.infogovernor.asset.form.IGASM0346Form;
import com.deliverik.infogovernor.asset.vo.IGASM03461VO;

/**
 * ����: ���ð�����ϵ��ʾAction
 * ��������: ���ð�����ϵ��ʾAction
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
public class IGASM0346Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0321Action.class);

	/**
	 * ���ð�����ϵ��ʾ����
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
		IGASM0346Form form = (IGASM0346Form)actionForm;
		
		//BLȡ��
		IGASM03BL ctlBL = (IGASM03BL) getBean("igasm03BL");
		
		//DTO����
		IGASM03DTO dto = new IGASM03DTO();
		
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========���ð�����ϵ��ʾ��ʼ========");
			
			dto.setIgasm0346Form(form);
			
			dto = ctlBL.initIGASM0346Action(dto);
			
			IGASM03461VO vo = new IGASM03461VO(dto.getTreeNodeMap());
			
			super.<IGASM03461VO>setVO(req, vo);
			
			log.debug("========���ð�����ϵ��ʾ����========");
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
