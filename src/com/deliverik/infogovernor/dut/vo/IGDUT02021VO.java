/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * 值班计划
 */
public class IGDUT02021VO extends BaseVO {

	private static final long serialVersionUID = 1L;

	/** 可选白班人员 */
	protected List<UserRoleInfo> dayShiftUsers;
	
	/** 可选夜班人员 */
	protected List<UserRoleInfo> nightShiftUsers;
	
	/** 白班值班人员 */
	protected List<UserRoleInfo> dayShiftDutyUsers;
	
	/** 夜班值班人员 */
	protected List<UserRoleInfo> nightShiftDutyUsers;

	protected String dayShift;
	
	public List<UserRoleInfo> getDayShiftUsers() {
		return dayShiftUsers;
	}

	public void setDayShiftUsers(List<UserRoleInfo> dayShiftUsers) {
		this.dayShiftUsers = dayShiftUsers;
	}

	public List<UserRoleInfo> getNightShiftUsers() {
		return nightShiftUsers;
	}

	public void setNightShiftUsers(List<UserRoleInfo> nightShiftUsers) {
		this.nightShiftUsers = nightShiftUsers;
	}

	public List<UserRoleInfo> getDayShiftDutyUsers() {
		return dayShiftDutyUsers;
	}

	public void setDayShiftDutyUsers(List<UserRoleInfo> dayShiftDutyUsers) {
		this.dayShiftDutyUsers = dayShiftDutyUsers;
	}

	public List<UserRoleInfo> getNightShiftDutyUsers() {
		return nightShiftDutyUsers;
	}

	public void setNightShiftDutyUsers(List<UserRoleInfo> nightShiftDutyUsers) {
		this.nightShiftDutyUsers = nightShiftDutyUsers;
	}

	public String getDayShift() {
		return dayShift;
	}

	public void setDayShift(String dayShift) {
		this.dayShift = dayShift;
	}

}
