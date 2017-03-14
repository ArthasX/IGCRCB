/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0165Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01651VO;

/**
 * ����: ����ʼ�����ò�ѯAction
 * ��������: ����ʼ�����ò�ѯAction
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
public class IGPRD0165Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0165Action.class);

	/**
	 * ����ʼ�����ò�ѯAction
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORMȡ��
		IGPRD0165Form form = (IGPRD0165Form) actionForm;
		// BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		// DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		dto.setIgPRD0165Form(form);
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========����ʼ�����ò�ѯ����ʼ========");
			dto = ctlBL.searchIG373InfoAction(dto);
			IGPRD01651VO vo = new IGPRD01651VO();
			vo.setLst_IG373Info(dto.getLst_IG373Info());
			super.<IGPRD01651VO> setVO(req, vo);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����ʼ�����ò�ѯ�������========");
		} else if ("DELETE".equals(mapping.getParameter())) {
			log.debug("========����ʼ������ɾ������ʼ========");
			dto = ctlBL.deleteIG373InfoAction(dto);
			log.debug("========����ʼ������ɾ���������========");
		}
		// �߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		// ��ʷ�汾�µĲ鿴
		if (StringUtils.isNotEmpty(form.getViewhistory())
				&& "1".equalsIgnoreCase(form.getViewhistory())) {
			return mapping.findForward("VIEWHISTORY");
		}
		return mapping.findForward("DISP");
	}
}
