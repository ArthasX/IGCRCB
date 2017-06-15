/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.action;

import java.util.ArrayList;
import java.util.Calendar;
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
import com.deliverik.infogovernor.crc.bl.IGCRC21BL;
import com.deliverik.infogovernor.crc.bl.IGCRC24BL;
import com.deliverik.infogovernor.crc.bl.IGCRC24ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2101DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC2401DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC2401ExcelDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2401Form;
import com.deliverik.infogovernor.crc.model.IGCRC2102VWInfo;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2102VW;
import com.deliverik.infogovernor.crc.vo.IGCRC2401VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 告警平均响应时间Action
 *              zhangq@deliverik.com
 * </p>
 * @version 1.0
 */
public class IGCRC2404Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC2404Action.class);

	/**
	 * <p>
	 * Description: 事件平均解决时间action处理
	 * </p>
	 * 
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// Form获得
		IGCRC2401Form form = (IGCRC2401Form) actionForm;
		// BL获取
		IGCRC24BL ctlBl = (IGCRC24BL) getBean("igcrc24bl");
		// DTO生成
		IGCRC2401DTO dto = new IGCRC2401DTO();
		
		//设定为事件
		form.setSign("2");
		
		// 年份下拉列表
		int beginYear = 2014;
		int endYear = 2018;
		// 年份List
		List<LabelValueBean> yearList = new ArrayList<LabelValueBean>();
		yearList.add(new LabelValueBean());
		for (Integer i = beginYear; i <= endYear; i++) {
			yearList.add(new LabelValueBean(i + "年", i.toString()));
		}
		request.setAttribute("yearList", yearList);
		// 月份下拉列表
		int endMonth = 12;
		int beginMonth = 1;
		// 月份List
		List<LabelValueBean> monthList = new ArrayList<LabelValueBean>();
		monthList.add(new LabelValueBean());
		for (Integer i = beginMonth; i <= endMonth; i++) {
			monthList.add(new LabelValueBean(i + "月",i.toString().length() == 1?"0" + i.toString() : i.toString()));
		}
		request.setAttribute("monthList", monthList);

		// 部门下拉列表
		IGCRC21BL igcrc21bl = (IGCRC21BL) getBean("igcrc21bl");
		IGCRC2101DTO dto2101 = new IGCRC2101DTO();
		dto2101 = igcrc21bl.searchDepartmentBeanList(dto2101);
		// 获取dto中的部门下拉列表值
		List<IGCRC2102VWInfo> departmentBeanList = dto2101.getDepartmentBeanList();
		// 为部门下拉框添加初始化空值
		departmentBeanList.add(0, new IGCRC2102VW());

		request.setAttribute("deptList", departmentBeanList);
		//获取当前时间
		Calendar calendar = Calendar.getInstance();
		//初始化页面时间(年月) 
		if(null == form.getYear()){
			Integer year = calendar.get(Calendar.YEAR);
			form.setYear(year.toString());
		}
		if(null == form.getMonth()){
			Integer month = calendar.get(Calendar.MONTH) + 1;
			//月份如果是1位时不全2位
			form.setMonth(month.toString().length() == 1 ? "0" + month : month.toString());
		}
		// DTO参数设定
		dto.setIgcrc2401Form(form);
		String forward = "";
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========风险事件查询画面初期显示处理开始========");
			forward = "DISP";
			log.debug("========风险事件查询画面初期显示处理结束========");
		} else if ("SEARCH".equals(mapping.getParameter())) {
			log.debug("=====================检查统计查询开始=======================");
			// 调用BL查询
			dto = ctlBl.getFindStatisticsConfirm(dto);
			
			IGCRC2401VO vo = new IGCRC2401VO();
			// 将结果放入VO中
			vo.setIgcrc2402voList(dto.getIgcrc2402voList());
			super.<IGCRC2401VO> setVO(request, vo);
			forward = "DISP";
			log.debug("=====================检查统计查询结束=======================");
		} else if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("=====================检查统计导出开始=======================");
			// DTO参数设定
			dto.setIgcrc2401Form(form);
			// 调用BL查询
			dto = ctlBl.getFindStatisticsConfirm(dto);
			// 取得Excel处理BL
			IGCRC24ExcelBL excelBL = (IGCRC24ExcelBL) getBean("igcrc24ExcelBL");
			// 设置excelDTO
			IGCRC2401ExcelDTO excelDTO = new IGCRC2401ExcelDTO();
			// 填充要导出的结果
			excelDTO.setIgcrc2402voList(dto.getIgcrc2402voList());
			// 填充模板编号
			excelDTO.setFileid("CRC2401");
			excelDTO.setResponse(response);
			excelBL.initExcel(excelDTO);
			log.debug("=====================检查统计导出结束=======================");
			forward = null;
		}
		return mapping.findForward(forward);
	}

}
