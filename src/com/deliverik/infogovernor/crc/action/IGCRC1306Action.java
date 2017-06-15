/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.crc.bl.IGCRC13BL;
import com.deliverik.infogovernor.crc.bl.IGCRC14ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC1304DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1306ExcelDTO;
import com.deliverik.infogovernor.crc.form.IGCRC1304Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 导出部门提交统计Action
 * </p>
 * 
 * @author wangnan@deliverik.com 
 * @version 1.0
 */
public class IGCRC1306Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC1306Action.class);
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("================导出部门提交统计Action开始=============");
		IGCRC1304Form form = (IGCRC1304Form)actionForm;
		
		IGCRC13BL igcrc13bl = (IGCRC13BL)getBean("igcrc13bl");
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		IGCRC1304DTO dto = new IGCRC1304DTO();
		
		dto.setUser(user);
		
		if("EXCEL".equals(mapping.getParameter())){
			log.debug("=================部门提交统计处理开始===============");
			
			int maxCnt = getMaxDataCount("IGCRC1304");
			//获取翻页DTO
			PagingDTO pDto = getPaginDTO(request, "IGCRC1304");
			//修改翻页DTO,查询全部存量数据
			pDto.setFromCount(0);
			pDto.setPageDispCount(maxCnt);
			
			dto.setIgcrc1304Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto = igcrc13bl.searchDepartSumAction(dto);
			
			//设置excel DTO
			IGCRC1306ExcelDTO excelDTO = new IGCRC1306ExcelDTO();
			excelDTO.setListVM(dto.getListVM());
			// 填充模板编号
			excelDTO.setFileid("CRC1306");
			excelDTO.setResponse(response);
			IGCRC14ExcelBL excelbl = (IGCRC14ExcelBL)getBean("igcrc14excelbl");
			excelbl.initExcel(excelDTO);
			log.debug("=================部门提交统计处理结束===============");
		}
		log.debug("================导出部门提交统计Action结束=============");
		return null;
	}

}
