/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.dbm.dto;

import com.deliverik.framework.base.BaseDTO;

public class IGDBM06DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/*��ѯ����*/
	protected String typeValue;
	
	/*��ѯ�¼�*/
	protected String yearValue;
	
	/*���¼�����������ռ�ȵ�����ֵ*/
	protected String pn1Value;
	
	/*�¼�ƽ�����ʱ�䵼����ֵ*/
	protected String pn2Value;
	
	/*�¼��������Ƶ�����ֵ*/
	protected String pn3Value;
	
	/*�¼���ʱ��������Ƶ�����ֵ*/
	protected String pn4Value;

	/*���¼�����������ռ�ȷ���ֵ*/
	protected String pieValue;
	
	/*�¼�ƽ�����ʱ�䷵��ֵ*/
	protected String incidentLineForAvg;
	
	/*�¼��������Ʒ���ֵ*/
	protected String incidentLineForCount;
	
	/*�¼���ʱ����ʷ���ֵ*/
	protected String incidentLineForSolve;
	
	
	public String getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}

	public String getYearValue() {
		return yearValue;
	}

	public void setYearValue(String yearValue) {
		this.yearValue = yearValue;
	}

	public String getPieValue() {
		return pieValue;
	}

	public void setPieValue(String pieValue) {
		this.pieValue = pieValue;
	}

	public String getPn1Value() {
		return pn1Value;
	}

	public void setPn1Value(String pn1Value) {
		this.pn1Value = pn1Value;
	}

	public String getPn2Value() {
		return pn2Value;
	}

	public void setPn2Value(String pn2Value) {
		this.pn2Value = pn2Value;
	}

	public String getPn3Value() {
		return pn3Value;
	}

	public void setPn3Value(String pn3Value) {
		this.pn3Value = pn3Value;
	}

	public String getPn4Value() {
		return pn4Value;
	}

	public void setPn4Value(String pn4Value) {
		this.pn4Value = pn4Value;
	}

	public String getIncidentLineForAvg() {
		return incidentLineForAvg;
	}

	public void setIncidentLineForAvg(String incidentLineForAvg) {
		this.incidentLineForAvg = incidentLineForAvg;
	}

	public String getIncidentLineForCount() {
		return incidentLineForCount;
	}

	public void setIncidentLineForCount(String incidentLineForCount) {
		this.incidentLineForCount = incidentLineForCount;
	}

	public String getIncidentLineForSolve() {
		return incidentLineForSolve;
	}

	public void setIncidentLineForSolve(String incidentLineForSolve) {
		this.incidentLineForSolve = incidentLineForSolve;
	}
	
}