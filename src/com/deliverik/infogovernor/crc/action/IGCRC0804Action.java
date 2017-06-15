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
import com.deliverik.infogovernor.crc.bl.IGCRC08BL;
import com.deliverik.infogovernor.crc.bl.IGCRC08ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC08DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC08ExcelDTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * ����:����������̵���Action 
 * ������������Excel�ļ���ʽ����������������̡� 
 * ������¼��ʷ����  2014/07/18
 */
public class IGCRC0804Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCRC0804Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {


		IGWKM0101Form form = (IGWKM0101Form)actionForm;

		// BLȡ��
		IGCRC08BL igcrc08bl = (IGCRC08BL) getBean("igcrc08BL");
		// ʵ����dto
		IGCRC08DTO dto = new IGCRC08DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		form.setUserid_q(user.getUserid());
		dto.setIgwkm0101form(form);
		// ҳ���ʼ������
		if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("==============���˹���������������ʼ====================");
			// ����BL��ѯ
			dto = igcrc08bl.getExcelDataList(dto);
			// ʵ��ExeclDTO
			IGCRC08ExcelDTO excelDTO = new IGCRC08ExcelDTO();
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
			IGCRC08ExcelBL excelBL = (IGCRC08ExcelBL) getBean("igcrc08ExcelBL");
			// ���ģ����
			excelDTO.setFileid("CRC0804");
			excelDTO.setResponse(response);
			//excelBL.initExcel(excelDTO);
			excelBL.initExcel(excelDTO);
			
			log.debug("==============���˹�����������������====================");
		}

		return null;
	}
}

