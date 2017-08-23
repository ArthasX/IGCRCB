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
import com.deliverik.infogovernor.crc.bl.IGCRC03BL;
import com.deliverik.infogovernor.crc.bl.IGCRC03ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC03DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC03ExcelDTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * ����:����������̵���Action 
 * ������������Excel�ļ���ʽ����������������̡� 
 * ������¼��ʷ����  2014/07/18
 */
public class IGCRC0304Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCRC0304Action.class);


	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		IGWKM0101Form form = (IGWKM0101Form)actionForm;
		// BLȡ��
		IGCRC03BL igcrc03bl = (IGCRC03BL) getBean("igcrc03BL");
		// ʵ����dto
		IGCRC03DTO dto = new IGCRC03DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		form.setUserid_q(user.getUserid());
		dto.setIgwkm0101form(form);
		// ҳ���ʼ������
		if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("==============���������������ʼ====================");
			// ����BL��ѯ
			dto = igcrc03bl.getExcelDataList(dto);
			// ʵ��ExeclDTO
			IGCRC03ExcelDTO excelDTO = new IGCRC03ExcelDTO();
			// �������˼���
			excelDTO.setProcessParticipantList(dto.getProcessParticipantList());
			excelDTO.setIgcrc0301List(dto.getIgcrc0301List());

			excelDTO.setIgwkm0101form(form);
			// ȡ��Excel����BL 
			IGCRC03ExcelBL excelBL = (IGCRC03ExcelBL) getBean("igcrc03ExcelBL");
			// ���ģ����
			excelDTO.setFileid("CRC0304");
			excelDTO.setResponse(response);
			//excelBL.initExcel(excelDTO);
			excelBL.initExcel(excelDTO);
			
			log.debug("==============�����������������====================");
		}

		return null;
	}
}

