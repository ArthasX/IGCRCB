package com.deliverik.infogovernor.dut.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dut.model.condition.DutyPlanSearchCond;

public class IGDUT0202Form extends BaseForm implements DutyPlanSearchCond{

	private static final long serialVersionUID = 1L;

	private String dptime;
	private String dadcategory;
	private String dpstatus;
	private String[] dayShiftUserids;
	private String[] nightShiftUserids;
	private String[] dayShiftDutyUserids;
	private String[] nightShiftDutyUserids;
	private Integer dpid;
	private String mode;
	private String dayshift;
	private String showYear;
	private String showMonth;
	
	public String getDadcategory() {
		return dadcategory;
	}

	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}

	public String getDptime() {
		return dptime;
	}

	public void setDptime(String dptime) {
		this.dptime = dptime;
	}

	public String getDpstatus() {
		return dpstatus;
	}

	public void setDpstatus(String dpstatus) {
		this.dpstatus = dpstatus;
	}

	public Integer getDpid() {
		return dpid;
	}

	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String[] getDayShiftUserids() {
		return dayShiftUserids;
	}

	public void setDayShiftUserids(String[] dayShiftUserids) {
		this.dayShiftUserids = dayShiftUserids;
	}

	public String[] getNightShiftUserids() {
		return nightShiftUserids;
	}

	public void setNightShiftUserids(String[] nightShiftUserids) {
		this.nightShiftUserids = nightShiftUserids;
	}

	public String[] getDayShiftDutyUserids() {
		return dayShiftDutyUserids;
	}

	public void setDayShiftDutyUserids(String[] dayShiftDutyUserids) {
		this.dayShiftDutyUserids = dayShiftDutyUserids;
	}

	public String[] getNightShiftDutyUserids() {
		return nightShiftDutyUserids;
	}

	public void setNightShiftDutyUserids(String[] nightShiftDutyUserids) {
		this.nightShiftDutyUserids = nightShiftDutyUserids;
	}

	public String getDptype() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDptime_ge() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDptime_le() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDayshift() {
		return dayshift;
	}

	public void setDayshift(String dayshift) {
		this.dayshift = dayshift;
	}

	public String getShowYear() {
		return showYear;
	}

	public void setShowYear(String showYear) {
		this.showYear = showYear;
	}

	public String getShowMonth() {
		return showMonth;
	}

	public void setShowMonth(String showMonth) {
		this.showMonth = showMonth;
	}

}
