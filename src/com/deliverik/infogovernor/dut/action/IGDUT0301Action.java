/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.dut.bl.IGDUT03BL;
import com.deliverik.infogovernor.dut.dto.IGDUT03DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0301Form;
import com.deliverik.infogovernor.dut.vo.IGDUT03011VO;
import com.deliverik.infogovernor.dut.vo.IGDUT03012VO;
import com.deliverik.infogovernor.dut.vo.IGDUT03013VO;

/**
 * 
 * 值班计划Action
 * 
 */
public class IGDUT0301Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0301Action.class);

	/**
	 * 值班计划
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.debug("========值班计划初期显示开始========");
		
		IGDUT03BL ctlBL = (IGDUT03BL) getBean("igdut03BL");
		IGDUT03DTO dto = new IGDUT03DTO();
		IGDUT0301Form form = (IGDUT0301Form) actionForm;
		dto.setIgdut0301Form(form);
		
		GregorianCalendar currentDay = new GregorianCalendar();
		int year = currentDay.get(Calendar.YEAR);
		int month = currentDay.get(Calendar.MONTH);
//		int today = currentDay.get(Calendar.DAY_OF_MONTH);
//		String todayYMD = year + "/" + appendZero(month + 1) + "/" + appendZero(today);
		Integer showYear = form.getShowYear();
		Integer showMonth = form.getShowMonth();
		String forward = form.getForward();
		if ("back".equals(forward)) {
			if (showMonth == 0) {
				showYear = showYear - 1;
				showMonth = 11;
			} else {
				showMonth = showMonth - 1;
			}
		} else if ("next".equals(forward)) {
			if (showMonth > 11) {
				showYear = showYear + 1;
				showMonth = 0;
			}
		}
		int calendarYear = (showYear == null) ? year : showYear;
		int calendarMonth = (showMonth == null) ? month : showMonth;
		dto.setCalendarYear(calendarYear);
		dto.setCalendarMonth(calendarMonth);
		dto.setDadcategory(form.getDadcategory());
		Calendar thisMonth = Calendar.getInstance();
		thisMonth.set(Calendar.MONTH, calendarMonth);
		thisMonth.set(Calendar.YEAR, calendarYear);
		thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
		thisMonth.set(Calendar.DAY_OF_MONTH, 1);
		int firstIndex = thisMonth.get(Calendar.DAY_OF_WEEK) - 1;
		int maxIndex = thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH);

		IGDUT03011VO vo = new IGDUT03011VO();
		vo.setCalendarYear(calendarYear);
		vo.setCalendarMonth(calendarMonth);
		int rowLenth = 5;
		if(35 - firstIndex - maxIndex < 0){
			rowLenth = 6;
		}
		dto = ctlBL.initIGDUT0301Action(dto);
		Map<String,Integer> dutyResultMap = dto.getDutyResultMap();
		Map<String, Integer> delayMap = dto.getDelayMap();
		int showDay = 1;
		List<IGDUT03012VO> rowList = new ArrayList<IGDUT03012VO>();
		for (int i = 0; i < rowLenth; i++) {
			IGDUT03012VO rowVO = new IGDUT03012VO();
			List<IGDUT03013VO> cellList = new ArrayList<IGDUT03013VO>();
			for (int j = 0; j < 7; j++) {
				IGDUT03013VO cellVO = new IGDUT03013VO();
				cellVO.setBgColor("#FFFFFF");
				cellVO.setRedimg("&nbsp;");
				if ((i == 0 && j < firstIndex) || showDay > maxIndex) {
					cellVO.setShowDay("&nbsp;");
				} else {
					String dptime = calendarYear + "/" + appendZero(calendarMonth + 1) + "/" + appendZero(showDay);
					if(dutyResultMap.get(dptime) == null){ 
						cellVO.setBgColor("#EFEFEF");
					}
					if(dutyResultMap.get(dptime) != null){ 
						cellVO.setLink("1");
						cellVO.setBgColor("#FCFACD");
						cellVO.setDptime(dptime);
					}
					cellVO.setShowDay(String.valueOf(showDay));
					showDay = showDay + 1;
					if(dutyResultMap.get(dptime) != null && dutyResultMap.get(dptime) == 1){						
						cellVO.setRedimg("<img src=\"images/red_light.gif\">");
					}
					if(dutyResultMap.get(dptime + "time") != null && dutyResultMap.get(dptime + "time") == 1){						
						cellVO.setYellowimg("<img src=\"images/yellow_light.gif\">");
					}
					if(delayMap.get(dptime) != null && delayMap.get(dptime) == 1){						
						cellVO.setDelayimg("<img src=\"images/sq.gif\">");
						cellVO.setDptime(dptime);
					}
				}
				cellList.add(cellVO);
			}
			rowVO.setCellVOList(cellList);
			rowList.add(rowVO);
		}
		vo.setWeekVOList(rowList);
		super.<IGDUT03011VO> setVO(req, vo);
		log.debug("========值班计划初期显示结束========");
		return mapping.findForward("DISP");
	}
	
	private String appendZero(int arg){
		if(arg < 10){
			return "0" + arg;
		}
		return String.valueOf(arg);
	}
}
