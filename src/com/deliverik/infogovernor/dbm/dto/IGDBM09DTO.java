/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.dbm.dto;

import com.deliverik.framework.base.BaseDTO;

public class IGDBM09DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/*当前实际可用率*/
	protected String currentActualAvailability = "AD_PN1RETURN"; 
	
	/*实际可用率全年累计*/
	protected String yearActualAvailability= "AD_PN2RETURN";
	
	/*可用率年度趋势*/
	protected String availabilityYearTrends= "AD_PN3RETURN";
	
	/*工作及时解决率趋势*/
	protected String workTimelySolutionlyTrends= "AD_PN4RETURN";
	
	/*所选系统ID*/
	protected String selectSystemId;

	public String getCurrentActualAvailability() {
		return currentActualAvailability;
	}

	public void setCurrentActualAvailability(String currentActualAvailability) {
		this.currentActualAvailability = currentActualAvailability;
	}

	public String getYearActualAvailability() {
		return yearActualAvailability;
	}

	public void setYearActualAvailability(String yearActualAvailability) {
		this.yearActualAvailability = yearActualAvailability;
	}

	public String getAvailabilityYearTrends() {
		return availabilityYearTrends;
	}

	public void setAvailabilityYearTrends(String availabilityYearTrends) {
		this.availabilityYearTrends = availabilityYearTrends;
	}

	public String getWorkTimelySolutionlyTrends() {
		return workTimelySolutionlyTrends;
	}

	public void setWorkTimelySolutionlyTrends(String workTimelySolutionlyTrends) {
		this.workTimelySolutionlyTrends = workTimelySolutionlyTrends;
	}

	public String getSelectSystemId() {
		return selectSystemId;
	}

	public void setSelectSystemId(String selectSystemId) {
		this.selectSystemId = selectSystemId;
	}
	
}