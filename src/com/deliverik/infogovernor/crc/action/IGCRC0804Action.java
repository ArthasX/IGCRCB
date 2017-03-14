/*	
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。	
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
 * 概述:变更管理，流程导出Action 
 * 功能描述：以Excel文件格式，导出问题管理流程。 
 * 创建记录：史凯龙  2014/07/18
 */
public class IGCRC0804Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCRC0804Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {


		IGWKM0101Form form = (IGWKM0101Form)actionForm;

		// BL取得
		IGCRC08BL igcrc08bl = (IGCRC08BL) getBean("igcrc08BL");
		// 实例化dto
		IGCRC08DTO dto = new IGCRC08DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		form.setUserid_q(user.getUserid());
		dto.setIgwkm0101form(form);
		// 页面初始化操作
		if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("==============个人工作管理导出操作开始====================");
			// 调用BL查询
			dto = igcrc08bl.getExcelDataList(dto);
			// 实例ExeclDTO
			IGCRC08ExcelDTO excelDTO = new IGCRC08ExcelDTO();
			// 填充流信息集合
			excelDTO.setProcessList(dto.getProcessList());
			// 填充表单集合
			excelDTO.setProcessInfoList(dto.getProcessInfoList());
			// 填充参与人集合
			excelDTO.setProcessParticipantList(dto.getProcessParticipantList());
			// 填充状态定义
			excelDTO.setProcessStatusDefList(dto.getProcessStatusDefList());
			excelDTO.setIgwkm0101form(form);
			// 取得Excel处理BL 
			IGCRC08ExcelBL excelBL = (IGCRC08ExcelBL) getBean("igcrc08ExcelBL");
			// 填充模板编号
			excelDTO.setFileid("CRC0804");
			excelDTO.setResponse(response);
			//excelBL.initExcel(excelDTO);
			excelBL.initExcel(excelDTO);
			
			log.debug("==============个人工作管理导出操作结束====================");
		}

		return null;
	}
}

