/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.action;

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
import com.deliverik.infogovernor.nms.bl.IGNMS01BL;
import com.deliverik.infogovernor.nms.dto.IGNMS01DTO;
import com.deliverik.infogovernor.nms.form.IGNMS0102Form;
import com.deliverik.infogovernor.nms.vo.IGNMS01021VO;

/**
 * ����: SNMP����Action
 * ��������: SNMP����Action
 * ������¼: 2013/12/20
 * �޸ļ�¼:
 */
public class IGNMS0102Action extends BaseAction {
	static Log log = LogFactory.getLog(IGNMS0102Action.class);

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IGNMS0102Form form = (IGNMS0102Form) actionForm;
		IGNMS01BL ctlBL = (IGNMS01BL) getBean("ignms01BL");
		IGNMS01DTO dto = new IGNMS01DTO();
		dto.setNms02Info(form);
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========SNMP������ʾ����ʼ========");
			dto = ctlBL.initNMS02Action(dto);
			// ����VO
			IGNMS01021VO vo = new IGNMS01021VO();
			vo.setLst_NMS02Info(dto.getLst_NMS02Info());
			super.<IGNMS01021VO> setVO(request, vo);
			log.debug("========SNMP������ʾ�������========");
		} else if ("INS".equals(mapping.getParameter())) {
			log.debug("========SNMP������������ʼ========");
			dto = ctlBL.insertNMS02Action(dto);
			request.setAttribute("flag", "1");
			log.debug("========SNMP���������������========");
		} else if ("DEL".equals(mapping.getParameter())) {
			log.debug("========SNMP����ɾ������ʼ========");
			dto = ctlBL.deleteNMS02Action(dto);
			request.setAttribute("flag", "1");
			log.debug("========SNMP����ɾ���������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
