/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * ֵ��ƻ�
 */
public class IGDUT02021VO extends BaseVO {

	private static final long serialVersionUID = 1L;

	/** ��ѡ�װ���Ա */
	protected List<UserRoleInfo> dayShiftUsers;
	
	/** ��ѡҹ����Ա */
	protected List<UserRoleInfo> nightShiftUsers;
	
	/** �װ�ֵ����Ա */
	protected List<UserRoleInfo> dayShiftDutyUsers;
	
	/** ҹ��ֵ����Ա */
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
