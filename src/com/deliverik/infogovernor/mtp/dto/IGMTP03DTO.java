/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */

package com.deliverik.infogovernor.mtp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.mtp.form.IGMTP0103Form;
import com.deliverik.infogovernor.mtp.form.IGMTP0107Form;
import com.deliverik.infogovernor.mtp.vo.IGMTP01011VO;
import com.deliverik.infogovernor.mtp.vo.IGMTP01042VO;
import com.deliverik.infogovernor.mtp.vo.IGMTP01061VO;

/**
 * 值班管理DTO
 * 
 */
public class IGMTP03DTO extends BaseDTO implements Serializable{
	
	private static final long serialVersionUID = -6214724454446012825L;
	
	/** 工作计划画面 */
	protected IGMTP0107Form igmtp0107Form;
	protected IGMTP0103Form igmtp0103Form;
	
	protected int calendarYear;
	
	protected int calendarMonth;
	
	protected boolean canChangeDuty = false;
	
	protected String todayYMD;
	//计划起始年
	protected int syear;
	//计划起始月
	protected int smonth;
	
	protected List<IGMTP01042VO> rowList;
	
	// 存放选择的日期
	protected 	Map<String, String> selectedCheck;
	
	protected 	IGMTP01061VO igmtp01061VO;
	protected 	IGMTP01011VO igmtp01011VO;
	
	protected List<String> dateList;
	

	
	
	
	public int getCalendarYear() {
		return calendarYear;
	}

	public void setCalendarYear(int calendarYear) {
		this.calendarYear = calendarYear;
	}

	public int getCalendarMonth() {
		return calendarMonth;
	}

	public void setCalendarMonth(int calendarMonth) {
		this.calendarMonth = calendarMonth;
	}



	public boolean isCanChangeDuty() {
		return canChangeDuty;
	}

	public void setCanChangeDuty(boolean canChangeDuty) {
		this.canChangeDuty = canChangeDuty;
	}

	public String getTodayYMD() {
		return todayYMD;
	}

	public void setTodayYMD(String todayYMD) {
		this.todayYMD = todayYMD;
	}


	public IGMTP0107Form getIgmtp0107Form() {
		return igmtp0107Form;
	}

	public void setIgmtp0107Form(IGMTP0107Form igmtp0107Form) {
		this.igmtp0107Form = igmtp0107Form;
	}

	public List<IGMTP01042VO> getRowList() {
		return rowList;
	}

	public void setRowList(List<IGMTP01042VO> rowList) {
		this.rowList = rowList;
	}

	public Map<String, String> getSelectedCheck() {
		return selectedCheck;
	}

	public void setSelectedCheck(Map<String, String> selectedCheck) {
		this.selectedCheck = selectedCheck;
	}

	public IGMTP01061VO getIgmtp01061VO() {
		return igmtp01061VO;
	}

	public void setIgmtp01061VO(IGMTP01061VO igmtp01061VO) {
		this.igmtp01061VO = igmtp01061VO;
	}

	public int getSyear() {
		return syear;
	}

	public void setSyear(int syear) {
		this.syear = syear;
	}

	public int getSmonth() {
		return smonth;
	}

	public void setSmonth(int smonth) {
		this.smonth = smonth;
	}

	public IGMTP0103Form getIgmtp0103Form() {
		return igmtp0103Form;
	}

	public void setIgmtp0103Form(IGMTP0103Form igmtp0103Form) {
		this.igmtp0103Form = igmtp0103Form;
	}

	public List<String> getDateList() {
		return dateList;
	}

	public void setDateList(List<String> dateList) {
		this.dateList = dateList;
	}

	public IGMTP01011VO getIgmtp01011VO() {
		return igmtp01011VO;
	}

	public void setIgmtp01011VO(IGMTP01011VO igmtp01011VO) {
		this.igmtp01011VO = igmtp01011VO;
	}
	
}
