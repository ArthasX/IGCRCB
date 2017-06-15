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
import com.deliverik.infogovernor.crc.bl.IGCRC01BL;
import com.deliverik.infogovernor.crc.bl.IGCRC01ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC01ExcelDTO;
import com.deliverik.infogovernor.wkm.dto.IGWKM01DTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

public class IGCRC01Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGCRC01Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGWKM0101Form form=(IGWKM0101Form) actionForm;
		if ("EXCEL".equals(mapping.getParameter())) {
		log.debug("=====================������ѯ�� ����ʼ=======================");
		IGWKM01DTO  dto=new IGWKM01DTO();
		IGCRC01BL  bl=(IGCRC01BL) getBean("igcrc01BL");
		//dto.setIgasm2814form(igasm2814form);
		// ȡ��Excel����BL
		IGCRC01ExcelBL excelBL = (IGCRC01ExcelBL) getBean("igwkm0103excelBL");
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		form.setUserid_q(user.getUserid());
		dto.setIgwkm0101From(form);
		//����bl �������ݴ���
		dto=bl.searchWorkList(dto);
		// ʵ��ExeclDTO
		IGCRC01ExcelDTO excelDTO = new IGCRC01ExcelDTO();
		excelDTO.setPrList(dto.getProcessList());
		excelDTO.setProcessInfoList(dto.getProcessInfoList());
		excelDTO.setProcessList(dto.getProcessList());
		excelDTO.setProcessParticipantList(dto.getProcessParticipantList());
		excelDTO.setProcessStatusDefList(dto.getProcessStatusDefList());
		// ���ģ����
		excelDTO.setFileid("CRC0102");
		excelDTO.setResponse(res);
		excelBL.initExcel(excelDTO);
		log.debug("=====================������ѯ�� ���Y��=======================");
		}
		return null;
	}
	
	
}
