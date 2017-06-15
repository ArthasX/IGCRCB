/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.dbm.dto;

import com.deliverik.framework.base.BaseDTO;

public class IGDBM09DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/*��ǰʵ�ʿ�����*/
	protected String currentActualAvailability = "AD_PN1RETURN"; 
	
	/*ʵ�ʿ�����ȫ���ۼ�*/
	protected String yearActualAvailability= "AD_PN2RETURN";
	
	/*�������������*/
	protected String availabilityYearTrends= "AD_PN3RETURN";
	
	/*������ʱ���������*/
	protected String workTimelySolutionlyTrends= "AD_PN4RETURN";
	
	/*��ѡϵͳID*/
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