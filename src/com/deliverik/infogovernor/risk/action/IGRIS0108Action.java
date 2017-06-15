/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.action;

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
import com.deliverik.infogovernor.risk.bl.IGRIS01BL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0104Form;
import com.deliverik.infogovernor.risk.vo.IGRIS01051VO;

/**
 * �������ϸ��ѯAction����
 *
 */
public class IGRIS0108Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0108Action.class);

	/**
	 * �ɹ�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ʵ����FORM
		IGRIS0104Form form = (IGRIS0104Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		//ʵ����DTO
		IGRIS01DTO dto = new IGRIS01DTO();
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========����������ϸ���������ʾ����ʼ========");
			dto.setIgRIS0104Form(form);
			
			dto.setRiskAuditDefSearchCond(form);
			
			//����BL��ѯ
			dto = ctlBL.initIGRIS0108Action(dto);
			//����VO
			IGRIS01051VO vo = new IGRIS01051VO();
			vo.setRiskAuditDef(dto.getRiskAuditDef());
			super.<IGRIS01051VO>setVO(req, vo);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����������ϸ���������ʾ��������========");
			return mapping.findForward("DISP");
		} 
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
