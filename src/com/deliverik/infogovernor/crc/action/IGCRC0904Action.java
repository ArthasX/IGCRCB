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
import com.deliverik.infogovernor.crc.bl.IGCRC09BL;
import com.deliverik.infogovernor.crc.bl.IGCRC09ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC09DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC09ExcelDTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * ����:����������̵���Action 
 * ������������Excel�ļ���ʽ����������������̡� 
 * ������¼��ʷ����  2014/07/18
 */
public class IGCRC0904Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCRC0904Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IGWKM0101Form form = (IGWKM0101Form)actionForm;
		// BLȡ��
		IGCRC09BL igcrc09bl = (IGCRC09BL) getBean("igcrc09BL");
		// ʵ����dto
		IGCRC09DTO dto = new IGCRC09DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		form.setUserid_q(user.getUserid());
		dto.setIgwkm0101form(form);
		// ҳ���ʼ������
		if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("==============ָ�ɹ���������������ʼ====================");
			// ����BL��ѯ
			dto = igcrc09bl.getExcelDataList(dto);
			// ʵ��ExeclDTO
			IGCRC09ExcelDTO excelDTO = new IGCRC09ExcelDTO();
			// �������Ϣ����
			excelDTO.setProcessList(dto.getProcessList());
			// ��������
			excelDTO.setProcessInfoList(dto.getProcessInfoList());
			// �������˼���
			excelDTO.setProcessParticipantList(dto.getProcessParticipantList());
			// ���״̬����
			excelDTO.setProcessStatusDefList(dto.getProcessStatusDefList());

			// ȡ��Excel����BL 
			IGCRC09ExcelBL excelBL = (IGCRC09ExcelBL) getBean("igcrc09ExcelBL");
			// ���ģ����
			excelDTO.setFileid("CRC0904");
			excelDTO.setResponse(response);
			//excelBL.initExcel(excelDTO);
			excelBL.initExcel(excelDTO);
			
			log.debug("==============ָ�ɹ�����������������====================");
		}

		return null;
	}
}

