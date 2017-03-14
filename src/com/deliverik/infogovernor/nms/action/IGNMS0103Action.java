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
import com.deliverik.infogovernor.nms.bl.task.NMSBaseBLImpl;
import com.deliverik.infogovernor.nms.dto.IGNMS01DTO;
import com.deliverik.infogovernor.nms.form.IGNMS0103Form;
import com.deliverik.infogovernor.nms.vo.IGNMS01031VO;

/**
 * ����: ��������Action
 * ��������: ��������Action
 * ������¼: 2013/12/20
 * �޸ļ�¼:
 */
public class IGNMS0103Action extends BaseAction {
	static Log log = LogFactory.getLog(IGNMS0103Action.class);

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IGNMS0103Form form = (IGNMS0103Form) actionForm;
		IGNMS01BL ctlBL = (IGNMS01BL) getBean("ignms01BL");
		IGNMS01DTO dto = new IGNMS01DTO();
		if(form.getGid() == null || form.getGid() == 0) {
			form.setGid(NMSBaseBLImpl.GROUPID_DEFAULT);//Ĭ����
		}
		dto.setNms03Info(form);
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========����������ʾ����ʼ========");
			dto = ctlBL.initNMS03Action(dto);
			// ����VO
			IGNMS01031VO vo = new IGNMS01031VO();
			vo.setLst_NMS03Info(dto.getLst_NMS03Info());
			super.<IGNMS01031VO> setVO(request, vo);
			log.debug("========����������ʾ�������========");
		} else if ("INS".equals(mapping.getParameter())) {
			log.debug("========����������������ʼ========");
			dto = ctlBL.insertNMS03Action(dto);
			request.setAttribute("flag", "1");
			log.debug("========�������������������========");
		} else if ("DEL".equals(mapping.getParameter())) {
			log.debug("========��������ɾ������ʼ========");
			dto = ctlBL.deleteNMS03Action(dto);
			request.setAttribute("flag", "1");
			log.debug("========��������ɾ���������========");
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
