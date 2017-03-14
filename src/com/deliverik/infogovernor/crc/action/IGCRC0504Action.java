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
import com.deliverik.infogovernor.crc.bl.IGCRC05BL;
import com.deliverik.infogovernor.crc.bl.IGCRC05ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC05DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC05ExcelDTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * ����:����������̵���Action 
 * ������������Excel�ļ���ʽ����������������̡� 
 * ������¼��ʷ����  2014/07/18
 */
public class IGCRC0504Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCRC0504Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		IGWKM0101Form form = (IGWKM0101Form)actionForm;
		// BLȡ��
		IGCRC05BL igcrc05bl = (IGCRC05BL) getBean("igcrc05BL");
		// ʵ����dto
		IGCRC05DTO dto = new IGCRC05DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		form.setUserid_q(user.getUserid());
		dto.setIgwkm0101form(form);
		// ҳ���ʼ������
		if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("==============�Ƽ��������������������ʼ====================");
			// ����BL��ѯ
			dto = igcrc05bl.getExcelDataList(dto);
			// ʵ��ExeclDTO
			IGCRC05ExcelDTO excelDTO = new IGCRC05ExcelDTO();
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
			IGCRC05ExcelBL excelBL = (IGCRC05ExcelBL) getBean("igcrc05ExcelBL");
			// ���ģ����
			excelDTO.setFileid("CRC0504");
			excelDTO.setResponse(response);
			//excelBL.initExcel(excelDTO);
			excelBL.initExcel(excelDTO);
			
			log.debug("==============�Ƽ����������������������====================");
		}

		return null;
	}
}

