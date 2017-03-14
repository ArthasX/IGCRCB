/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
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
import com.deliverik.infogovernor.crc.bl.IGCRC21ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2101DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC2101ExcelDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2101Form;
import com.deliverik.infogovernor.crc.model.IGCRC2102VWInfo;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2102VW;
import com.deliverik.infogovernor.crc.vo.IGCRC2101VO;

/**	
 * 概述:人员工作统计查询Action
 * 功能描述：1.流程查询	
 *           2.Excel导出
 * 创建记录：yukexin    2014-8-14 17:28:40
 * 修改记录： 
 *          	
 */	

public class IGCRC2101Action extends BaseAction {
	//日志对象取得
	static Log log = LogFactory.getLog(IGCRC2101Action.class);
	
	/**	
	 * 功能：页面查询action处理
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 修改记录：
	 *          	
	 */	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.debug("================人员工作统计Action开始=============");
		//form取得
		IGCRC2101Form form = (IGCRC2101Form)actionForm;
		//BL取得
		IGCRC21BL igcrc21bl = (IGCRC21BL)getBean("igcrc21bl");
		//实例化dto
		IGCRC2101DTO dto = new IGCRC2101DTO();
		// 跳转
		String forward = "";
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
		//form传给dto
		dto.setIgcrc2101Form(form);
		
		//添加年份下拉列表
		Integer yearNum = 5;//显示年份个数
		//从2014年开始
		Integer year = 2014;
		List<LabelValueBean> yearBeanList = new ArrayList<LabelValueBean>();
		yearBeanList.add(new LabelValueBean());
		for (int i = 0; i < yearNum; i++) {
			yearBeanList.add(new LabelValueBean(year + "年",year.toString()));
			year++;
		}
		//保存到request
		request.setAttribute("yearBeanList", yearBeanList);
		
		//添加月份下拉列表
		List<LabelValueBean> monthBeanList = new ArrayList<LabelValueBean>();
		monthBeanList.add(new LabelValueBean());
		for (Integer month = 1; month < 13; month++) {
			monthBeanList.add(new LabelValueBean(month + "月",month.toString().length() == 1?"0" + month.toString() : month.toString()));
		}
		//保存到request
		request.setAttribute("monthBeanList", monthBeanList);
		
		//调用BL查询 获得部门下拉框值
		dto = igcrc21bl.searchDepartmentBeanList(dto);
		//获取dto中的部门下拉列表值
		List<IGCRC2102VWInfo> departmentBeanList = dto.getDepartmentBeanList();
		//为部门下拉框添加初始化空值
		departmentBeanList.add(0, new IGCRC2102VW());
		
		request.setAttribute("departmentBeanList", departmentBeanList);
		
		
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("========人员工作统计查询处理开始========");
			//调用BL查询 
			dto = igcrc21bl.searchEntityItemAction(dto);
			//构造VO
			IGCRC2101VO vo = new IGCRC2101VO();
			//获取查询的带合计的数据列表和总合计列表
			vo.setIgcrc2102VOList(dto.getIgcrc2102voList());
			vo.setListSum(dto.getListSum());
			super.<IGCRC2101VO>setVO(request, vo);
			log.debug("========人员工作统计查询处理结束========");
			forward = "DISP";
		}else if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("=====================人员工作统计导出开始=======================");
			//获取bl
			IGCRC21ExcelBL excelBL = (IGCRC21ExcelBL)getBean("igcrc21ExcelBL");
			//获取查询到的dto
			dto = igcrc21bl.searchEntityItemAction(dto);
			// 实例ExeclDTO
			IGCRC2101ExcelDTO excelDTO = new IGCRC2101ExcelDTO();
			excelDTO.setIgcrc2102voList(dto.getIgcrc2102voList());
			excelDTO.setListSum(dto.getListSum());
			// 填充模板编号
			excelDTO.setFileid("CRC2101");
			excelDTO.setResponse(response);
			excelBL.initExcel(excelDTO);
			log.debug("=====================人员工作统计导出结束=======================");
			log.debug("================人员工作统计Action结束=============");
			return null;
		}
		log.debug("================人员工作统计Action结束=============");
		return mapping.findForward(forward);
	}
}
