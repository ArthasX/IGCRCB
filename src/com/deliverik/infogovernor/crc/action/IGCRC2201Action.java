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
import com.deliverik.infogovernor.crc.bl.IGCRC22BL;
import com.deliverik.infogovernor.crc.bl.IGCRC22ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2201DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC2201ExcelDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2201Form;
import com.deliverik.infogovernor.crc.vo.IGCRC2201VO;

/**	
 * 概述:变更总体统计Action处理
 * 功能描述： 1.查询变更总体
 *           2.导出变更总体
 * 创建记录：yukexin    2014-8-15 下午1:54:45	
 * 修改记录：
 *          
 */	
public class IGCRC2201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC2201Action.class);
	/**	
	 * 功能：事件处理
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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.debug("================变更总体统计Action开始=============");
		// Form获得
		IGCRC2201Form form = (IGCRC2201Form) actionForm;
		// BL获取
		IGCRC22BL ctlBl = (IGCRC22BL) this.getBean("igcrc22bl");
		// DTO生成
		IGCRC2201DTO dto = new IGCRC2201DTO();
		// 跳转
		String forward = "";

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
		
		//从2014年开始
		int year = 2014;
		// 添加年下拉列表
		List<LabelValueBean> yearList = new ArrayList<LabelValueBean>();
		yearList.add(new LabelValueBean("", ""));
		for (int i = 0; i < 5; i++) {
			yearList.add(new LabelValueBean(year + i + "年", year + i + ""));
		}
		//保存到request
		request.setAttribute("yearList", yearList);

		// 添加月下拉列表
		List<LabelValueBean> monthList = new ArrayList<LabelValueBean>();
		monthList.add(new LabelValueBean("", ""));
		for (int i = 1; i <= 12; i++) {
			monthList.add(new LabelValueBean(i + "月", new Integer(i).toString().length() == 1 ? "0" + i : "" + i));
		}
		//保存到request
		request.setAttribute("monthList", monthList);
		
		if ("SEARCH".equals(mapping.getParameter())) {
			log.debug("=====================变更总体统计查询开始=======================");
			// DTO参数设定
			dto.setIgcrc2201Form(form);
			// 变更统计逻辑调用
			dto = ctlBl.searchEntityItemAction(dto);
			// 将结果放入VO中
			IGCRC2201VO vo = new IGCRC2201VO();
			vo.setIgcrc2202voList(dto.getIgcrc2202voList());
			super.<IGCRC2201VO> setVO(request, vo);
			log.debug("=====================变更总体统计查询结束=======================");
			forward = "SUCCESS";
		}else if("EXCEL".equals(mapping.getParameter())){ 
			log.debug("=====================变更总体统计导出开始=======================");
			dto.setIgcrc2201Form(form);
			// 变更统计逻辑调用
			dto = ctlBl.searchEntityItemAction(dto);
			//获取excel bl
			IGCRC22ExcelBL excelBL = (IGCRC22ExcelBL)getBean("igcrc22ExcelBL");
			// 实例ExeclDTO
			IGCRC2201ExcelDTO excelDTO = new IGCRC2201ExcelDTO();
			excelDTO.setIgcrc2202voList(dto.getIgcrc2202voList());
			// 填充模板编号
			excelDTO.setFileid("CRC2201");
			excelDTO.setResponse(response);
			excelBL.initExcel(excelDTO);
			log.debug("=====================变更总体统计导出结束=======================");
			log.debug("================变更总体统计Action开结束=============");
			return null;
		}else if("DISP".equals(mapping.getParameter())) {
			forward = "DISP";
		}
		log.debug("================变更总体统计Action开结束=============");
		return mapping.findForward(forward);
		
	}
}
