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
import com.deliverik.infogovernor.crc.bl.IGCRC23BL;
import com.deliverik.infogovernor.crc.bl.IGCRC23ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2301DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC2301ExcelDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2301Form;
import com.deliverik.infogovernor.crc.vo.IGCRC2301VO;

/**	
 * 概述:程序开发统计查询Action
 * 功能描述： 1.程序开发统计查询
 *           2.程序开发统计导出
 * 创建记录：yukexin    2014-8-15 下午1:55:43	
 * 修改记录：
 *          
 */	
public class IGCRC2301Action extends BaseAction {
	//日志对象取得
	static Log log = LogFactory.getLog(IGCRC2301Action.class);

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

		log.debug("================程序开发统计Action开始=============");
		//form取得
		IGCRC2301Form form = (IGCRC2301Form)actionForm;
		//BL取得
		IGCRC23BL igcrc23bl = (IGCRC23BL)getBean("igcrc23bl");
		//实例化dto
		IGCRC2301DTO dto = new IGCRC2301DTO();
		
		//获取当前时间
		Calendar calendar = Calendar.getInstance();
		
		//初始化页面时间
		if(null == form.getYear()){
			Integer year = calendar.get(Calendar.YEAR);
			form.setYear(year.toString());
		}
		if(null == form.getMonth()){
			Integer month = calendar.get(Calendar.MONTH) + 1;
			form.setMonth(month.toString().length() == 1 ? "0" + month : month.toString());
		}
		
		dto.setIgcrc2301Form(form);
		
		// 跳转
		String forward = "";
		
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
		
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("========程序开发统计查询处理开始========");
			//调用BL查询 
			dto = igcrc23bl.searchEntityItemAction(dto);
			//构造VO
			IGCRC2301VO vo = new IGCRC2301VO();
			//获取查询的带合计的数据列表和总合计列表
			vo.setIgcrc2301VWList(dto.getEntityItemVWInfoList());
			super.<IGCRC2301VO>setVO(request, vo);
			log.debug("========程序开发统计查询处理终了========");
			forward = "DISP";
		}else if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("=====================程序开发统计导出开始=======================");
			//BL取得
			IGCRC23ExcelBL excelBL = (IGCRC23ExcelBL)getBean("igcrc23ExcelBL");
			//dto获取
			dto = igcrc23bl.searchEntityItemAction(dto);
			
			// 实例ExeclDTO
			IGCRC2301ExcelDTO excelDTO = new IGCRC2301ExcelDTO();
			//dto数据传给excelDto	
			excelDTO.setIgcrc2301VWList(dto.getEntityItemVWInfoList());
			// 填充模板编号
			excelDTO.setFileid("CRC2301");
			excelDTO.setResponse(response);
			excelBL.initExcel(excelDTO);
			log.debug("=====================程序开发统计导出结束=======================");
			log.debug("================程序开发统计Action结束=============");
			return null;
		}
		log.debug("================程序开发统计Action结束=============");
		return mapping.findForward(forward);
	}
}
