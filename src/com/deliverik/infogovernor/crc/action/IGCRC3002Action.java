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
import com.deliverik.infogovernor.crc.bl.IGCRC30BL;
import com.deliverik.infogovernor.crc.bl.IGCRC30ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC30DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC30ExcelDTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * 概述:对外服务管理，流程导出Action 
 * 功能描述：以Excel文件格式，导出对外服务管理流程。 
 * 创建记录：zhangxinru 2016/02/25
 */
public class IGCRC3002Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCRC3002Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IGWKM0101Form form = (IGWKM0101Form)actionForm;
		
		// BL取得
		IGCRC30BL igcrc30bl = (IGCRC30BL) getBean("igcrc30BL");
		// 实例化dto
		IGCRC30DTO dto = new IGCRC30DTO();
		dto.setIgwkm0101form(form);
	
		// 页面初始化操作
		if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("==============对外服务管理导出操作开始====================");
			// 调用BL查询
			dto = igcrc30bl.getExcelDataList(dto);
			// 实例ExeclDTO
			IGCRC30ExcelDTO excelDTO = new IGCRC30ExcelDTO();
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
			IGCRC30ExcelBL excelBL = (IGCRC30ExcelBL) getBean("igcrc30ExcelBL");
			// 填充模板编号
			excelDTO.setFileid("CRC3002");
			excelDTO.setResponse(response);
			excelBL.initExcel(excelDTO);
			
			log.debug("==============对外服务管理导出操作结束====================");
		}

		return null;
	}
}

