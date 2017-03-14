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
import com.deliverik.infogovernor.dut.bl.IGDUT02BL;
import com.deliverik.infogovernor.dut.bl.IGDUTCONSTANTS;
import com.deliverik.infogovernor.dut.dto.IGDUT02DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0201Form;
import com.deliverik.infogovernor.dut.vo.IGDUT02011VO;
import com.deliverik.infogovernor.dut.vo.IGDUT02012VO;
import com.deliverik.infogovernor.dut.vo.IGDUT02013VO;

/**
 * 
 * 值班计划Action
 * 
 */
public class IGDUT0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0201Action.class);

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
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		log.debug("========值班计划初期显示开始========");
		
		IGDUT02BL ctlBL = (IGDUT02BL) getBean("igdut02BL");
		IGDUT02DTO dto = new IGDUT02DTO();
		IGDUT0201Form form = (IGDUT0201Form) actionForm;

		GregorianCalendar currentDay = new GregorianCalendar();
		int today = currentDay.get(Calendar.DAY_OF_MONTH);
		int month = currentDay.get(Calendar.MONTH);
		int year = currentDay.get(Calendar.YEAR);

		String todayYMD = year + "/" + appendZero(month + 1) + "/" + appendZero(today);
		
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

		int calendarYear = (showYear == null || 0 == showYear) ? year : showYear;
		int calendarMonth = (showMonth == null ) ? month : showMonth;
		dto.setCalendarYear(calendarYear);
		dto.setCalendarMonth(calendarMonth);
		dto.setIgdut0201Form(form);
		dto = ctlBL.initIGDUT0201Action(dto);
		Map<String,String> dutyUserMap = dto.getDutyUserMap();
		Calendar thisMonth = Calendar.getInstance();
		thisMonth.set(Calendar.MONTH, calendarMonth);
		thisMonth.set(Calendar.YEAR, calendarYear);
		thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
		thisMonth.set(Calendar.DAY_OF_MONTH, 1);
		int firstIndex = thisMonth.get(Calendar.DAY_OF_WEEK) - 1;
		int maxIndex = thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH);

		IGDUT02011VO vo = new IGDUT02011VO();
		vo.setCalendarYear(calendarYear);
		vo.setCalendarMonth(calendarMonth);
		int rowLenth = 5;
		if(35 - firstIndex - maxIndex < 0){
			rowLenth = 6;
		}
		int showDay = 1;
		List<IGDUT02012VO> rowList = new ArrayList<IGDUT02012VO>();
		for (int i = 0; i < rowLenth; i++) {
			IGDUT02012VO rowVO = new IGDUT02012VO();
			List<IGDUT02013VO> cellList = new ArrayList<IGDUT02013VO>();
			for (int j = 0; j < 7; j++) {
				IGDUT02013VO cellVO = new IGDUT02013VO();
				if ((i == 0 && j < firstIndex) || showDay > maxIndex) {
					cellVO.setBgColor("#FFFFFF");
					cellVO.setShowDay("&nbsp;");
					cellVO.setDutyType(null);
					cellVO.setImg("&nbsp;");
				} else {
					boolean isPlan = true;
					String dptime = calendarYear + "/" + appendZero(calendarMonth + 1) + "/" + appendZero(showDay);
					String dayShiftUsers = dutyUserMap.get(IGDUTCONSTANTS.DAY_SHIFT + "_" + dptime);
					if(null == dayShiftUsers || "".equals(dayShiftUsers)){
						dayShiftUsers = "未设定";
						isPlan = false;
					}
					String nightShiftUsers = dutyUserMap.get(IGDUTCONSTANTS.NIGHT_SHIFT + "_" + dptime);
					if(null == nightShiftUsers || "".equals(nightShiftUsers)){
						nightShiftUsers = "未设定";
						isPlan = false;
					}
					cellVO.setDayShiftUsers(dayShiftUsers);
					cellVO.setNightShiftUsers(nightShiftUsers);
					String executing = dutyUserMap.get(dptime);
					if(executing != null && IGDUTCONSTANTS.PLAN_STATUS_EXECUTING.equals(executing)){ //执行日期
						cellVO.setBgColor("#ADF795");
						dto.setTodayYMD(todayYMD);
						String dayShift = dutyUserMap.get(dptime + IGDUTCONSTANTS.DAY_SHIFT);
						if(null != dayShift && dayShift.equals(IGDUTCONSTANTS.DAY_SHIFT)){
							cellVO.setLink("2");
							cellVO.setDptime(dptime);
						}
					} else if(executing != null && "34".equals(executing)){ //执行完或中止
						String nightShift = dutyUserMap.get(dptime + IGDUTCONSTANTS.NIGHT_SHIFT);
						if(null != nightShift && nightShift.equals(IGDUTCONSTANTS.NIGHT_SHIFT)){ //夜班
							cellVO.setBgColor("#EFEFEF");
							cellVO.setDptime(dptime);
						} else {
							cellVO.setBgColor("#ADF795");
						}
					} else if(dptime.compareTo(todayYMD) < 0){ //早于当前日期
						cellVO.setBgColor("#EFEFEF");
					} else { //晚于当前日期
						if(isPlan){							
							cellVO.setBgColor("#E6FDD9");
						} else {
							cellVO.setBgColor("#FCFACD");
						}
						cellVO.setLink("1");
						cellVO.setDptime(dptime);
					}
					cellVO.setDutyType("1");
					cellVO.setShowDay(String.valueOf(showDay));
					showDay = showDay + 1;
					
					if("0".equals(cellVO.getLink())){						
						cellVO.setImg("<img src=\"images/grayperson.gif\" width=\"14\" height=\"18\" border=\"0\">");
					} else {
						cellVO.setImg("<img src=\"images/cp.gif\" width=\"14\" height=\"18\" border=\"0\">");
					}
				}
				cellList.add(cellVO);
			}
			rowVO.setCellVOList(cellList);
			rowList.add(rowVO);
		}
		vo.setWeekVOList(rowList);
		super.<IGDUT02011VO> setVO(req, vo);
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
