/*	
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。	
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
 * 概述:事件管理，流程导出Action 
 * 功能描述：以Excel文件格式，导出事件管理流程。 
 * 创建记录：史凯龙  2014/07/20
 */
public class IGCRC0204Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCRC0204Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IGWKM0101Form form = (IGWKM0101Form)actionForm;
		
		//判断是不是告警
		String param = form.getParam();
		if(StringUtils.isBlank(param)){
			String varnames[] = {"'事件来源'"};
			String varvalues[] = {"'邮件','电话','其他','巡检发现'"};
			form.setVarnames_in(varnames);
			form.setVarvalues_in(varvalues);
		}else if("1".equals(param)){
			String varnames[] = {"事件来源"};
			String varvalues[] = {"监控告警"};
			form.setVarnames(varnames);
			form.setVarvalues(varvalues);
		}
		// BL取得
		IGCRC0204BL igcrc0204bl = (IGCRC0204BL) getBean("igcrc0204BL");
		// 实例化dto
		IGCRC0204DTO dto = new IGCRC0204DTO();
		dto.setIgwkm0101form(form);
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		form.setUserid_q(user.getUserid());
		// 页面初始化操作
		if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("==============事件管理导出操作开始====================");
			// 调用BL查询
			dto = igcrc0204bl.getExcelDataList(dto);
			// 实例ExeclDTO
			IGCRC02ExcelDTO excelDTO = new IGCRC02ExcelDTO();
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
			IGCRC0204ExcelBL excelBL = (IGCRC0204ExcelBL) getBean("igcrc0204ExcelBL");
			// 填充模板编号
			excelDTO.setFileid("CRC0204");
			excelDTO.setResponse(response);
			//excelBL.initExcel(excelDTO);
			//判断是否是告警
			if("1".equals(param)){
				IGCRC02041ExcelBL excelBL1 = (IGCRC02041ExcelBL) getBean("igcrc02041ExcelBL");
				String fileName = excelBL1.generatedFile(excelDTO);
				//下载
				excelBL1.downloadFile(fileName, response);
				
			}else{
				excelBL.initExcel(excelDTO);
			}
			
			log.debug("==============事件管理导出操作结束====================");
		}

		return null;
	}
}

