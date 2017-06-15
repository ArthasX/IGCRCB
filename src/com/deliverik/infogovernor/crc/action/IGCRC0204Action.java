/*	
 * ��������������������޹�˾��Ȩ���У���������Ȩ����	
 */
package com.deliverik.infogovernor.crc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.crc.bl.IGCRC02041ExcelBL;
import com.deliverik.infogovernor.crc.bl.IGCRC0204BL;
import com.deliverik.infogovernor.crc.bl.IGCRC0204ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC0204DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC02ExcelDTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * ����:�¼��������̵���Action 
 * ������������Excel�ļ���ʽ�������¼��������̡� 
 * ������¼��ʷ����  2014/07/20
 */
public class IGCRC0204Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCRC0204Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IGWKM0101Form form = (IGWKM0101Form)actionForm;
		
		//�ж��ǲ��Ǹ澯
		String param = form.getParam();
		if(StringUtils.isBlank(param)){
			String varnames[] = {"'�¼���Դ'"};
			String varvalues[] = {"'�ʼ�','�绰','����','Ѳ�췢��'"};
			form.setVarnames_in(varnames);
			form.setVarvalues_in(varvalues);
		}else if("1".equals(param)){
			String varnames[] = {"�¼���Դ"};
			String varvalues[] = {"��ظ澯"};
			form.setVarnames(varnames);
			form.setVarvalues(varvalues);
		}
		// BLȡ��
		IGCRC0204BL igcrc0204bl = (IGCRC0204BL) getBean("igcrc0204BL");
		// ʵ����dto
		IGCRC0204DTO dto = new IGCRC0204DTO();
		dto.setIgwkm0101form(form);
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		form.setUserid_q(user.getUserid());
		// ҳ���ʼ������
		if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("==============�¼�������������ʼ====================");
			// ����BL��ѯ
			dto = igcrc0204bl.getExcelDataList(dto);
			// ʵ��ExeclDTO
			IGCRC02ExcelDTO excelDTO = new IGCRC02ExcelDTO();
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
			IGCRC0204ExcelBL excelBL = (IGCRC0204ExcelBL) getBean("igcrc0204ExcelBL");
			// ���ģ����
			excelDTO.setFileid("CRC0204");
			excelDTO.setResponse(response);
			//excelBL.initExcel(excelDTO);
			//�ж��Ƿ��Ǹ澯
			if("1".equals(param)){
				IGCRC02041ExcelBL excelBL1 = (IGCRC02041ExcelBL) getBean("igcrc02041ExcelBL");
				String fileName = excelBL1.generatedFile(excelDTO);
				//����
				excelBL1.downloadFile(fileName, response);
				
			}else{
				excelBL.initExcel(excelDTO);
			}
			
			log.debug("==============�¼���������������====================");
		}

		return null;
	}
}

