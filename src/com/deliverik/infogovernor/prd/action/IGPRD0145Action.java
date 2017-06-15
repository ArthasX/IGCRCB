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
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0145Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01451VO;

/**
 * ����: �Զ������̱���ѯ��������Action
 * ��������: �Զ������̱���ѯ��������Action
 * ������¼: 2013/03/13
 * �޸ļ�¼: 
 */
public class IGPRD0145Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��ת��ʶ
		String forward = "DISP";
		//��־����ȡ��
		Log log = LogFactory.getLog(IGPRD0145Action.class);
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		//ʵ����dto
		IGPRD01DTO dto = new IGPRD01DTO();
		//formȡ��
		IGPRD0145Form form = (IGPRD0145Form) actionForm;
		//dto�����趨
		dto.setForm(actionForm);
		dto.setPdid(form.getPdid());
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============��ѯ��������ҳ��ʼ��������ʼ=================");
			dto = ctlBL.getProcessInfoQueryInfo(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			request.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			//ʵ����vo
			IGPRD01451VO vo = new IGPRD01451VO();
			vo.setPdList(dto.getPdList());
			vo.setPqList(dto.getPqList());
			vo.setQueryShowColumnList(dto.getQueryShowColumnList());
			vo.setQueryShowColumnMap(dto.getQueryShowColumnMap());
			vo.setQueryList(dto.getQueryList());
			vo.setQueryMap(dto.getQueryMap());
			super.<IGPRD01451VO>setVO(request, vo);
			// saveToken(request);
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//��ʷ�汾�µĲ鿴
				forward = "VIEWHISTORY";
			}
			log.debug("==============��ѯ��������ҳ��ʼ����������=================");
		}
		//����
		if("EDIT".equals(mapping.getParameter())|| "WIDTH".equals(mapping.getParameter())){
			log.debug("=============��ѯ�����༭������ʼ==============");
			// if(isTokenValid(request,true)){
					dto = ctlBL.changeProcessQueryAction(dto);
			// }else{
			// addMessage(request, new ActionMessage("IGCO00000.E007"));
			// return mapping.findForward("/error1");
			// }
			log.debug("=============��ѯ�����༭��������==============");
			if ("EDIT".equals(mapping.getParameter())) {
				return new ActionForward("/IGPRD0145_Disp.do?pdid=" + dto.getPdid(), true);
			} else {
				return new ActionForward("/IGPRD0146_Disp.do?pdid=" + dto.getPdid(), true);
			}
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
