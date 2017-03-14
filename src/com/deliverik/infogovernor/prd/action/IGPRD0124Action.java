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
import com.deliverik.infogovernor.prd.form.IGPRD0124Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01241VO;

/**
 * ����״̬_��ȨAction
 *
 */

public class IGPRD0124Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRD0124Action.class);
	
	/**
	 * <p>
	 * Description: ��Ȩ����action
	 * </p>
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGPRD0124Form form = (IGPRD0124Form)actionForm;
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");	
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();

		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========��Ȩ��ѯ����ʼ========");
			String psdid = request.getParameter("psdid");
			String pdid = request.getParameter("pdid");
			if(psdid!=null && !"".equals(psdid)){
				form.setPsdid(psdid);
			}
			if(pdid!=null && !"".equals(pdid)){
				form.setPdid(pdid);
				request.setAttribute("pdid", pdid);
			}
			dto.setIgPRD0124Form(form);
			dto.setPdid(form.getPdid());
			//����BL��ѯ
			
			dto = ctlBL.getProcessRoleTypeDefAction(dto);
			
			dto = ctlBL.isProcessDefinitionInUse(dto);
			saveToken(request);
			//����VO
			IGPRD01241VO vo = new IGPRD01241VO();
			vo.setCodeDetailList(dto.getCodeDetailList());
			vo.setProcessRoleTypeDefList(dto.getProcessRoleTypeDefList());
			vo.setProcessStatusDef(dto.getProcessStatusDef());
			request.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01241VO>setVO(request, vo);
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//��ʷ�汾�µĲ鿴
				forward = "VIEWHISTORY";
			}
			log.debug("========��Ȩ��ѯ��������========");
		} else if ("INSERT".equals(mapping.getParameter())){//��Ӳ�����
			log.debug("========��Ȩ����ʼ========");

			dto.setIgPRD0124Form(form);
			//ɾ����ɫ
			if("0".equals(form.getMode())){
				if (isTokenValid(request, true)){
					//����BL����
					ctlBL.removeProcessRoleTypes(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}else{//��ӽ�ɫ
				if (isTokenValid(request, true)){
					//����BL����
					ctlBL.addProcessRoleTypes(dto);
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
