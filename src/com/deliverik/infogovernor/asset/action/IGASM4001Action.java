/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.asset.bl.IGASM4001ExcelBL;
import com.deliverik.infogovernor.asset.bl.IGASM41BL;
import com.deliverik.infogovernor.asset.dto.IGASM41DTO;
import com.deliverik.infogovernor.asset.dto.IGASM41ExcelDTO;
import com.deliverik.infogovernor.asset.vo.IGASM40011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public class IGASM4001Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGASM4001Action.class);
	
	/**
	 * <p>
	 * Description: 页面查询action处理
	 * </p>
	 * 
	 * @update
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//跳转页面
		String forward = "DISP";
		//实例化DTO
		IGASM41DTO dto = new IGASM41DTO();
		//获取BL接口实例
		IGASM41BL crcBL = (IGASM41BL)getBean("igasm41bl");
		//调用BL查询 
		dto = crcBL.searchEntityItemAction(dto);
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("========风险检查统计信息查询处理开始========");
			//实例化FORM
			//IGCRC1301Form form = (IGCRC1301Form)actionForm;
			//风险检查统计信息查询
			//构造VO
			IGASM40011VO vo = new IGASM40011VO();
			vo.setRiskCheckMap(dto.getRiskCheckMap());
			super.<IGASM40011VO>setVO(request, vo);
			log.debug("========风险检查统计信息查询处理终了========");
		}else if("EXCEL".equals(mapping.getParameter())){
			log.debug("=====================风险检查统计信息导出开始=======================");
			// 取得Excel处理BL
			IGASM4001ExcelBL excelBL = (IGASM4001ExcelBL) getBean("igasm41ExcelBL");
			// 实例ExeclDTO
			IGASM41ExcelDTO excelDTO = new IGASM41ExcelDTO();
			excelDTO.setRiskCheckMap(dto.getRiskCheckMap());
			// 填充模板编号
			excelDTO.setFileid("ASM4001");
			excelDTO.setResponse(response);
			excelBL.initExcel(excelDTO);
			log.debug("=====================风险检查统计信息导出结束=======================");
			forward = null;
		}
		return mapping.findForward(forward);
	}
}
