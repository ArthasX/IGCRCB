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
import com.deliverik.infogovernor.crc.bl.IGCRC06BL;
import com.deliverik.infogovernor.crc.bl.IGCRC06ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC06DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC06ExcelDTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * ����:����������̵���Action 
 * ������������Excel�ļ���ʽ����������������̡� 
 * ������¼��ʷ����  2014/07/18
 */
public class IGCRC0604Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCRC0604Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		IGWKM0101Form form = (IGWKM0101Form)actionForm;
		// BLȡ��
		IGCRC06BL igcrc06bl = (IGCRC06BL) getBean("igcrc06BL");
		// ʵ����dto
		IGCRC06DTO dto = new IGCRC06DTO();
		dto.setIgwkm0101form(form);
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		form.setUserid_q(user.getUserid());
		// ҳ���ʼ������
		if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("==============ҵ��������������������ʼ====================");
			// ����BL��ѯ
			dto = igcrc06bl.getExcelDataList(dto);
			// ʵ��ExeclDTO
			IGCRC06ExcelDTO excelDTO = new IGCRC06ExcelDTO();
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
			IGCRC06ExcelBL excelBL = (IGCRC06ExcelBL) getBean("igcrc06ExcelBL");
			// ���ģ����
			excelDTO.setFileid("CRC0604");
			excelDTO.setResponse(response);
			//excelBL.initExcel(excelDTO);
			excelBL.initExcel(excelDTO);
			
			log.debug("==============ҵ����������������������====================");
		}

		return null;
	}
}

