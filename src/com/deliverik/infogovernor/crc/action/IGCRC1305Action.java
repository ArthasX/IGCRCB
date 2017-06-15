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
import com.deliverik.infogovernor.crc.bl.IGCRC13ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC1303DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1305ExcelDTO;
import com.deliverik.infogovernor.crc.form.IGCRC1303Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 导出文档存量统计Action
 * </p>
 * 
 * @author wangnan@deliverik.com
 * @version 1.0
 */
public class IGCRC1305Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGCRC1305Action.class);
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("================导出文档存量统计Action开始=============");
		
		IGCRC1303Form form = (IGCRC1303Form)actionForm;
		
		IGCRC13BL igcrc13bl = (IGCRC13BL)getBean("igcrc13bl");
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		IGCRC1303DTO dto = new IGCRC1303DTO();
		
		dto.setUser(user);
		
		if("EXCEL".equals(mapping.getParameter())){
			log.debug("=================导出文档存量统计处理开始===============");
			int maxCnt = getMaxDataCount("IGCRC1303");
			//获取翻页DTO
			PagingDTO pDto = getPaginDTO(request, "IGCRC1303");
			//修改翻页DTO,查询全部存量数据
			pDto.setFromCount(0);
			pDto.setPageDispCount(maxCnt);
			
			
			dto.setIgcrc1303Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto = igcrc13bl.searchEntitySumAction(dto);
			
			//设置excel DTO
			IGCRC1305ExcelDTO excelDTO = new IGCRC1305ExcelDTO();
			excelDTO.setListVM(dto.getListVM());
			// 填充模板编号
			excelDTO.setFileid("CRC1305");
			excelDTO.setResponse(response);
			IGCRC13ExcelBL excelbl = (IGCRC13ExcelBL)getBean("igcrc13excelbl");
			excelbl.initExcel(excelDTO);
			log.debug("=================导出文档存量统计处理结束===============");
		}
		log.debug("================导出文档存量统计Action结束=============");
		return null;
	}

}
