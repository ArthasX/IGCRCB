/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.crc.bl.IGCRC20BL;
import com.deliverik.infogovernor.crc.bl.IGCRC20ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2001DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC2001ExcelDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2001Form;
import com.deliverik.infogovernor.crc.vo.IGCRC2001VO;


/**	
 * 概述:年度工作统计查询Action
 * 功能描述： 1.年度工作统计查询
 *        2.Excel导出
 * 创建记录：lianghongyang    2014-8-14 15:28:40
 * 修改记录： 
 *          	
 */	
public class IGCRC2001Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC2001Action.class);


	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// Form获得
		IGCRC2001Form form = (IGCRC2001Form) actionForm;
		// BL获取
		IGCRC20BL ctlBl = (IGCRC20BL) getBean("igcrc20bl");
		// DTO生成
		IGCRC2001DTO dto = new IGCRC2001DTO();

		// 年份下拉列表
		int endYear = 2018;
		int beginYear = 2014;
		List<LabelValueBean> list = new ArrayList<LabelValueBean>();
		for (Integer i = beginYear; i <= endYear; i++) {
			list.add(new LabelValueBean(i.toString() + "年", i.toString()));
		}
		request.setAttribute("Yearlist", list);

		String forward = "";
		if ("SEARCH".equals(mapping.getParameter())) {
			log.debug("=====================检查统计查询开始=======================");
			// DTO参数设定
			dto.setIgcrc2001Form(form);
			// 变更统计逻辑调用
			dto = ctlBl.getFindStatistics(dto);
			// 将结果放入VO中
			IGCRC2001VO vo = new IGCRC2001VO();
			vo.setIgcrc2002voList(dto.getIgcrc2002voList());
			vo.setSumList(dto.getSumList());
			super.<IGCRC2001VO> setVO(request, vo);
			forward = "DISP";
			log.debug("=====================检查统计查询结束=======================");
			// 导出
		} else if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("=====================检查统计导出开始=======================");
			// 设置excelDTO
			IGCRC2001ExcelDTO excelDTO = new IGCRC2001ExcelDTO();
			// DTO参数设定
			dto.setIgcrc2001Form(form);
			// 调用BL查询
			dto = ctlBl.getFindStatistics(dto);
			// 取得Excel处理BL
			IGCRC20ExcelBL excelBL = (IGCRC20ExcelBL) getBean("igcrc20ExcelBL");
			// 填充要导出的结果
			excelDTO.setIgcrc2002voList(dto.getIgcrc2002voList());
			excelDTO.setSumList(dto.getSumList());
			// 填充模板编号
			excelDTO.setFileid("CRC2001");
			excelDTO.setResponse(response);
			excelBL.initExcel(excelDTO);
			log.debug("=====================检查统计导出结束=======================");
			forward = null;
		}
		return mapping.findForward(forward);
	}
}
