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
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0134Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01341VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:������֧�ֻ���ѡ��action 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD0134Action extends BaseAction{
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGPRD0134Action.class);
		//blȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		//ʵ����dto
		IGPRD01DTO dto = new IGPRD01DTO();
		//formȡ��
		IGPRD0134Form form = (IGPRD0134Form) actionForm;
		dto.setPdid(form.getPdid());
		String forward = "DISP";
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("===========������֧�ֻ���ѡ��ҳ���ʼ��������ʼ============");
			//form�趨
			dto.setIgprd0134Form(form);
			//��ѯ��������Ϣ
			dto = ctlBL.getProcessParticipantsByOrg(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			saveToken(request);
			request.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			//ʵ����vo
			IGPRD01341VO vo = new IGPRD01341VO();
			vo.setProcessStatusDef(dto.getProcessStatusDef());
			vo.setProcessParticipantDefList(dto.getProcessParticipantDefList());
			vo.setOrgList(dto.getLst_orgdef());
			super.<IGPRD01341VO>setVO(request, vo);
			//����ǲ��нڵ�
			if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(dto.getProcessStatusDef().getPsdtype())) {
				forward = "DISP2";
			}
			if(StringUtils.isNotEmpty(form.getViewhistory())&&"1".equals(form.getViewhistory())){
				forward += "HISTORY";
			}
			log.debug("===========������֧�ֻ���ѡ��ҳ���ʼ����������============");
		}
		
		//���������ò���
		if("INSERT".equals(mapping.getParameter())){
			log.debug("===========���������ÿ�ʼ============");
			if(isTokenValid(request,true)){
				//ҳ����Ϣ�趨
				dto.setIgprd0134Form(form);
				//ɾ��������
				if("0".equals(form.getMode())){
					ctlBL.removeProcessParticipantsByOrg(dto);
				}else{//��Ӳ�����
					ctlBL.addProcessParticipantsByOrg(dto);
				}
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("===========���������ý���============");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}

}
