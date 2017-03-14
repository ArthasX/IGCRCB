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
import com.deliverik.infogovernor.crc.bl.IGCRC30BL;
import com.deliverik.infogovernor.crc.bl.IGCRC30ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC30DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC30ExcelDTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * ����:�������������̵���Action 
 * ������������Excel�ļ���ʽ�������������������̡� 
 * ������¼��zhangxinru 2016/02/25
 */
public class IGCRC3002Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCRC3002Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IGWKM0101Form form = (IGWKM0101Form)actionForm;
		
		// BLȡ��
		IGCRC30BL igcrc30bl = (IGCRC30BL) getBean("igcrc30BL");
		// ʵ����dto
		IGCRC30DTO dto = new IGCRC30DTO();
		dto.setIgwkm0101form(form);
	
		// ҳ���ʼ������
		if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("==============������������������ʼ====================");
			// ����BL��ѯ
			dto = igcrc30bl.getExcelDataList(dto);
			// ʵ��ExeclDTO
			IGCRC30ExcelDTO excelDTO = new IGCRC30ExcelDTO();
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
			IGCRC30ExcelBL excelBL = (IGCRC30ExcelBL) getBean("igcrc30ExcelBL");
			// ���ģ����
			excelDTO.setFileid("CRC3002");
			excelDTO.setResponse(response);
			excelBL.initExcel(excelDTO);
			
			log.debug("==============��������������������====================");
		}

		return null;
	}
}

