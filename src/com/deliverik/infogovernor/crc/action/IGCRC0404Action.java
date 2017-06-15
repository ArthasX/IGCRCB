/*	
 * ��������������������޹�˾��Ȩ���У���������Ȩ����	
 */
package com.deliverik.infogovernor.crc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.crc.bl.IGCRC04BL;
import com.deliverik.infogovernor.crc.bl.IGCRC04ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC04DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC04ExcelDTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * ����:����������̵���Action 
 * ����������1.��Excel�ļ���ʽ�������������̡� 
 * ������¼�������� 2014/07/07
 */

public class IGCRC0404Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCRC0404Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		IGWKM0101Form form = (IGWKM0101Form)actionForm;
		
		// BLȡ��
		IGCRC04BL igcrc04bl = (IGCRC04BL) getBean("igcrc04BL");
		// ʵ����dto
		IGCRC04DTO dto = new IGCRC04DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		form.setUserid_q(user.getUserid());
		dto.setIgwkm0101form(form);
		// ҳ���ʼ������
		if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("==============�������������ʼ====================");
			// ����BL��ѯ
			dto = igcrc04bl.getExcelDataList(dto);
			// ʵ��ExeclDTO
			IGCRC04ExcelDTO excelDTO = new IGCRC04ExcelDTO();
			// �������Ϣ����
			excelDTO.setProcessList(dto.getProcessList());
			// ��������
			excelDTO.setProcessInfoList(dto.getProcessInfoList());
			// �������˼���
			excelDTO.setProcessParticipantList(dto.getProcessParticipantList());
			// ���״̬����
			excelDTO.setProcessStatusDefList(dto.getProcessStatusDefList());
			excelDTO.setIgwkm0101form(form);
			// ȡ��Excel����BL
			IGCRC04ExcelBL excelBL = (IGCRC04ExcelBL) getBean("igcrc04ExcelBL");
			// ���ģ����
			excelDTO.setFileid("CRC0404");
			excelDTO.setResponse(response);
			//excelBL.initExcel(excelDTO);
			excelBL.initExcel(excelDTO);
			
			log.debug("==============���������������====================");
		}

		return null;
	}
}
