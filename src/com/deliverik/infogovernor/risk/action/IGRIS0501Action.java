/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.risk.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.risk.bl.IGRIS05BL;
import com.deliverik.infogovernor.risk.bl.IGRIS05ExcelBL;
import com.deliverik.infogovernor.risk.dto.IGRIS05DTO;
import com.deliverik.infogovernor.risk.dto.IGRIS05ExcelDTO;
import com.deliverik.infogovernor.risk.form.IGRIS0501Form;
import com.deliverik.infogovernor.risk.vo.IGRIS05011VO;

/***
 * 信息安全报表统计
 * @author zhangqiang
 * @time   2014-07-09
 * @version 1.0
 */

public class IGRIS0501Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGRIS0501Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//实例化检查统计查询BL
		IGRIS05BL ctrlBL =(IGRIS05BL)getBean("igris05BL");
		//实例化检查统计DTO
		IGRIS05DTO dto = new IGRIS05DTO();
		//实例化FORM
		IGRIS0501Form igris0501Form = (IGRIS0501Form) actionForm;
		
		//跳转页面
		String forward = "DISP";
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("=====================检查统计初始化页面开始=======================");
			
			
			log.debug("=====================检查统计初始化页面结束=======================");
			
		}else if("SEARCH".equals(mapping.getParameter())){
			log.debug("=====================检查统计查询开始=======================");
			dto.setIgris0501Form(igris0501Form);
			dto.setFlag("1");
			//调用ctrlBL查询
			ctrlBL.searchRiskCount(dto);
			//页面VO设定
			IGRIS05011VO vo = new IGRIS05011VO();
			vo.setCheckWorkMap(dto.getCheckExcelWorkConutmap());
			super.<IGRIS05011VO>setVO(req, vo);
			log.debug("=====================检查统计查询结束=======================");
		}else if("EXCEL".equals(mapping.getParameter())){
			log.debug("=====================检查统计导出开始=======================");
			dto.setIgris0501Form(igris0501Form);
			dto.setFlag("2");
			//调用ctrlBL查询
			ctrlBL.searchRiskCount(dto);
			// 取得Excel处理BL
			IGRIS05ExcelBL excelBL = (IGRIS05ExcelBL) getBean("igris05ExcelBL");
			// 实例ExeclDTO
			IGRIS05ExcelDTO excelDTO = new IGRIS05ExcelDTO();
			excelDTO.setMap(dto.getCheckExcelWorkConutmap());
			excelDTO.setMapType(dto.getMapTypeExcel());
			// 填充模板编号
			excelDTO.setFileid("RIS0501");
			excelDTO.setResponse(res);
			excelBL.initExcel(excelDTO);
			log.debug("=====================检查统计导出结束=======================");
			forward=null;
		}
		return mapping.findForward(forward);
	}

}
