/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
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
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0172Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01721VO;

/**
 * ���鿴Ȩ��
 * @author byf 2012-10-16
 *
 */
public class IGPRD0172Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRD0172Action.class);
	
	/**
	 * <p>
	 * Description: ��Ȩ����action
	 * </p>
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGPRD0172Form form = (IGPRD0172Form)actionForm;
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");	
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();

		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========��Ȩ��ѯ����ʼ========");
			request.setAttribute("pdid", form.getPdid());
			request.setAttribute("roleid", form.getRoleid());
			dto.setIgPRD0172Form(form);
			dto.setPdid(form.getPdid());
			//����BL��ѯ
			
			dto = ctlBL.getProcessRoleFormRelationAction(dto);
			
			dto = ctlBL.isProcessDefinitionInUse(dto);
			saveToken(request);
			//����VO
			IGPRD01721VO vo = new IGPRD01721VO();
			vo.setIg701InfoList(dto.getIg701InfoList());
			vo.setIg007InfoList(dto.getProcessInfoDefList());
			request.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01721VO>setVO(request, vo);
			log.debug("========��Ȩ��ѯ��������========");
		} else if ("INSERT".equals(mapping.getParameter())){//��Ӳ�����
			log.debug("========��Ȩ����ʼ========");

			dto.setIgPRD0172Form(form);
			//ɾ����ɫ
			if("0".equals(form.getMode())){
				if (isTokenValid(request, true)){
					//����BL����
					ctlBL.removeProcessRoleFormRelation(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}else{//��ӽ�ɫ
				if (isTokenValid(request, true)){
					//����BL����
					ctlBL.addProcessRoleFormRelation(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}

			log.debug("========��Ȩ��������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}
}
