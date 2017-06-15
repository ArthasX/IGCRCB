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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0146Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01461VO;

/**
 * ����: ���ð�����ϵ��ʾAction IGCIM0142Action
 * ��������: ���ð�����ϵ��ʾAction
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
public class IGCIM0146Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0121Action.class);

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
		IGCIM0146Form form = (IGCIM0146Form)actionForm;
		
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO����
		IGCIM01DTO dto = new IGCIM01DTO();
		
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========���ð�����ϵ��ʾ��ʼ========");
			
			dto.setIgcim0146Form(form);
			
			dto = ctlBL.initIGASM0346Action(dto);
			
			IGCIM01461VO vo = new IGCIM01461VO(dto.getTreeNodeMap());
			
			super.<IGCIM01461VO>setVO(req, vo);
			
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
