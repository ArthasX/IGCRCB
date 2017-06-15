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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.risk.bl.IGRIS01BL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0113Form;
import com.deliverik.infogovernor.risk.vo.IGRIS01131VO;

/**
 * ���������ѯAction����
 *
 */
public class IGRIS0113Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0113Action.class);

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
		IGRIS0113Form form = (IGRIS0113Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		//ʵ����DTO
		IGRIS01DTO dto = new IGRIS01DTO();
		//��ȡ��Ʊ�������б�
		ctlBL.searchRiskAuditInsLabelInUse(dto);
		req.setAttribute("labelList", dto.getLabelList());
		User user =(User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========����������������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����������������ʾ��������========");
			return mapping.findForward("DISP");
		} 
		if( "SEARCH".equals(mapping.getParameter())){	//��Ʋ�ѯ
			log.debug("========���������ѯ����ʼ========");

			form.setRaruserid(user.getUserid());
			dto.setIgRIS0113Form(form);

			//����BL��ѯ
			dto = ctlBL.searchRiskAuditResultAction(dto);
			//����VO
			IGRIS01131VO vo = new IGRIS01131VO(dto.getRiskAuditResultList());
			super.<IGRIS01131VO>setVO(req, vo);
			log.debug("========���������ѯ��������========");
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
