/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.infogovernor.prd.bl.IGPRD03BL;
import com.deliverik.infogovernor.prd.dto.IGPRD03DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0302Form;
import com.deliverik.infogovernor.prd.vo.IGPRD03021VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����鶨�屣��Action
 * </p>
 * 
 * @version 1.0
 */
public class IGPRD0302Action extends BaseAction{
	//��־����ȡ��
	static Log log = LogFactory.getLog(IGPRD0302Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse response) throws Exception {
		//BLȡ��
		IGPRD03BL ctlBL = (IGPRD03BL) getBean("igprd03BL");
		//ʵ����dto
		IGPRD03DTO dto = new IGPRD03DTO();
		//formȡ��
		IGPRD0302Form form = (IGPRD0302Form) actionForm;
		//dto�����趨
		//ҳ���ʼ������
		
		if("INSERT".equals(mapping.getParameter())||"NEXT".equals(mapping.getParameter())){
			log.info("�����鶨�屣�濪ʼ");
			dto.setIgprd0302Form(form);
			if (isTokenValid(req, true)){
				ctlBL.regProcessGroupDefinition(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			form.setPgdid(dto.getProcessGroupDefinition().getPgdid());
			log.info("�����鶨�屣�����");
			
		}
		if("EDIT".equals(mapping.getParameter())){
			log.info("������༭Ԥ����ʼ");
			dto.setIgprd0302Form(form);
			ctlBL.initPGDforEdit(dto);
			IGPRD03021VO vo = new IGPRD03021VO();
			vo.setProcessGroupDefinition(dto.getProcessGroupDefinition());
			super.<IGPRD03021VO>setVO(req, vo);
			saveToken(req);
			log.info("������༭Ԥ�������");
		}
		
		
		if("DISP".equals(mapping.getParameter())){
			req.removeAttribute("IGPRD0302Form");
			if(form == null) {
				req.setAttribute("ptid", req.getParameter("ptid"));
			} else {
				req.setAttribute("ptid", form.getPtid());
			}
			saveToken(req);
		}
		
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}

}