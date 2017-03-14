/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.infogovernor.prd.bl.IGPRD03BL;
import com.deliverik.infogovernor.prd.dto.IGPRD03DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0302Form;
import com.deliverik.infogovernor.prd.form.IGPRD0303Form;
import com.deliverik.infogovernor.prd.vo.IGPRD03031VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������������̱���Action
 * </p>
 * 
 * @version 1.0
 */
public class IGPRD0303Action extends BaseAction{

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGPRD0303Action.class);
		//BLȡ��
		IGPRD03BL ctlBL = (IGPRD03BL) getBean("igprd03BL");
		//ʵ����dto
		IGPRD03DTO dto = new IGPRD03DTO();
		//formȡ��
		IGPRD0303Form form = (IGPRD0303Form) actionForm;
		//dto�����趨
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.info("�������Ա�༭��ʼ����ʼ");
			if(StringUtils.isEmpty(form.getPgdid())){
				form.setPgdid(((IGPRD0302Form)req.getAttribute("IGPRD0302Form")).getPgdid());
			}
			dto.setIgprd0303Form(form);
			ctlBL.initPGDRelition(dto);
			IGPRD03031VO vo = new IGPRD03031VO();
			vo.setInnerPds(dto.getInnerPds());
			vo.setOuterPds(dto.getOuterPds());
			vo.setProcessGroupDefinition(dto.getProcessGroupDefinition());
			super.<IGPRD03031VO>setVO(req, vo);
			log.info("�������Ա�༭��ʼ������");
		}
		if("ADD".equals(mapping.getParameter())){
			log.info("��������ӳ�Ա��ʼ");
			dto.setIgprd0303Form(form);
			ctlBL.addMember(dto);
			log.info("��������ӳ�Ա����");
		}
		if("DEL".equals(mapping.getParameter())){
			log.info("ɾ���������ڳ�Ա��ʼ");
			dto.setIgprd0303Form(form);
			ctlBL.delMember(dto);
			log.info("ɾ���������ڳ�Ա����");
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