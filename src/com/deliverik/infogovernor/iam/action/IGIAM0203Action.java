/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
/**
 * 
 */
package com.deliverik.infogovernor.iam.action;

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
import com.deliverik.infogovernor.iam.bl.IGIAM02BL;
import com.deliverik.infogovernor.iam.dto.IGIAM02DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0203Form;
import com.deliverik.infogovernor.iam.vo.IGIAM02011VO;

/**
 * @author zhaomin
 *
 */
/**
 * ����: ���ù��������޸ġ�ɾ��action
 * �������������ù��������޸ġ�ɾ��action
 * �����ˣ�����
 * ������¼�� 2012-7-27
 * �޸ļ�¼��
 */
public class IGIAM0203Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0203Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//��ȡform
		IGIAM0203Form form = (IGIAM0203Form)actionForm;
		
		//��ȡbl
		IGIAM02BL iajBL = (IGIAM02BL)getBean("igiam02bl");
		
		//��ȡdto
		IGIAM02DTO dto = new IGIAM02DTO();
		
		if("EDIT".equals(mapping.getParameter())){
			log.debug("========�������༭����ʼ========");
			dto.setIgiam0203form(form);
			dto = iajBL.dsearchIAMAction(dto);
			//��ʼ��VO
			IGIAM02011VO vo = new IGIAM02011VO();
			vo.setIgiam0203form(form);
			vo.setAttkeyList(dto.getAttkeyList());
			super.<IGIAM02011VO>setVO(request, vo);
			log.debug("========�������༭�������========");
		}
		if("UPDATE".equals(mapping.getParameter())){
			log.debug("========�������޸Ĵ���ʼ========");
			dto.setIgiam0203form(form);
			dto = iajBL.updateIAMAction(dto);
			log.debug("========�������޸Ĵ������========");
		}
		if("DELETE".equals(mapping.getParameter())){
			log.debug("========������ɾ������ʼ========");
			String iajids = request.getParameter("iajids");
			
			dto.setIajids(iajids);
			dto = iajBL.deleteIAMAction(dto);
			log.debug("========������ɾ���������========");
		}
		//��������
		if ("LOADFILE".equals(mapping.getParameter())){
			log.debug("========֪ͨ�������ش���ʼ========");
			
			String attId = request.getParameter("attId");
			String type="iam";
			request.setAttribute("type", type);
			request.setAttribute("attId", attId);

			log.debug("========֪ͨ�������ش������========");
			return mapping.findForward("LOADFILE");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
