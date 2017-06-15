/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.action;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.deliverik.infogovernor.svc.bl.IGSVC06BL;
import com.deliverik.infogovernor.svc.dto.IGSVC06DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0640Form;
import com.deliverik.infogovernor.svc.vo.IGSVC06401VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ȹ�������ͳ��Action
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
public class IGSVC0640Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGSVC0640Action.class);
		//BLȡ��
		IGSVC06BL ctlBL = (IGSVC06BL) getBean("igsvc06BL");
		//ʵ����dto
		IGSVC06DTO dto = new IGSVC06DTO();
		//formȡ��
		IGSVC0640Form form = (IGSVC0640Form) actionForm;
		//dto�����趨
		dto.setIgsvc0640Form(form);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("=============��ȹ�������ͳ��ҳ���ʼ��������ʼ============");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			Date date = new Date();
			String year = sdf.format(date);
			form.setYear(year);
			log.debug("=============��ȹ�������ͳ��ҳ���ʼ����������============");
		}
		//ͳ�Ʋ���
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("==========ͳ�����ݲ�ѯ������ʼ========");
			dto = ctlBL.searchAnnualTrendVWAction(dto);
			//ʵ����vo
			IGSVC06401VO vo = new IGSVC06401VO();
			vo.setIncidentnum(dto.getIncidentnum());
			vo.setProblemnum(dto.getProblemnum());
			vo.setChangenum(dto.getChangenum());
			vo.setServicenum(dto.getServicenum());
			vo.setSfnum(dto.getSfnum());
			super.<IGSVC06401VO>setVO(request, vo);
			log.debug("==========ͳ�����ݲ�ѯ��������========");
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
