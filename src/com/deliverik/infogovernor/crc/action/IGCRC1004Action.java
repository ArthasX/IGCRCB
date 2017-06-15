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
import com.deliverik.infogovernor.crc.bl.IGCRC10BL;
import com.deliverik.infogovernor.crc.bl.IGCRC10ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC10DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC10ExcelDTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * ����:����������̵���Action 
 * ������������Excel�ļ���ʽ����������������̡� 
 * ������¼��ʷ����  2014/07/18
 */
public class IGCRC1004Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCRC1004Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		IGWKM0101Form form = (IGWKM0101Form)actionForm;
		// BLȡ��
		IGCRC10BL igcrc10bl = (IGCRC10BL) getBean("igcrc10BL");
		// ʵ����dto
		IGCRC10DTO dto = new IGCRC10DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		form.setUserid_q(user.getUserid());
		dto.setIgwkm0101form(form);
		// ҳ���ʼ������
		if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("==============���򿪷�������������ʼ====================");
			// ����BL��ѯ
			dto = igcrc10bl.getExcelDataList(dto);
			// ʵ��ExeclDTO
			IGCRC10ExcelDTO excelDTO = new IGCRC10ExcelDTO();
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
			IGCRC10ExcelBL excelBL = (IGCRC10ExcelBL) getBean("igcrc10ExcelBL");
			// ���ģ����
			excelDTO.setFileid("CRC1004");
			excelDTO.setResponse(response);
			//excelBL.initExcel(excelDTO);
			excelBL.initExcel(excelDTO);
			
			log.debug("==============���򿪷���������������====================");
		}

		return null;
	}
}

