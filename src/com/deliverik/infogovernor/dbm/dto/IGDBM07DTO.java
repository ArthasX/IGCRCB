/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.dbm.dto;

import com.deliverik.framework.base.BaseDTO;

public class IGDBM07DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/*��ѯ����*/
	protected String typeValue;
	
	/*��ѯ�¼�*/
	protected String yearValue;
	
	/*�±������������ռ�ȵ�����ֵ*/
	protected String pn1Value;
	
	/*���ƽ�����ʱ�䵼����ֵ*/
	protected String pn2Value;
	
	/*����������Ƶ�����ֵ*/
	protected String pn3Value;
	
	/*�����ʱ��������Ƶ�����ֵ*/
	protected String pn4Value;

	/*�±������������ռ�ȷ���ֵ*/
	protected String pieValue;
	
	/*���ƽ�����ʱ�䷵��ֵ*/
	protected String changeLineForAvg;
	
	/*����������Ʒ���ֵ*/
	protected String changeLineForCount;
	
	/*�����ʱ����ʷ���ֵ*/
	protected String changeLineForSolve;

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

	public String getPieValue() {
		return pieValue;
	}

	public void setPieValue(String pieValue) {
		this.pieValue = pieValue;
	}

	public String getChangeLineForAvg() {
		return changeLineForAvg;
	}

	public void setChangeLineForAvg(String changeLineForAvg) {
		this.changeLineForAvg = changeLineForAvg;
	}

	public String getChangeLineForCount() {
		return changeLineForCount;
	}

	public void setChangeLineForCount(String changeLineForCount) {
		this.changeLineForCount = changeLineForCount;
	}

	public String getChangeLineForSolve() {
		return changeLineForSolve;
	}

	public void setChangeLineForSolve(String changeLineForSolve) {
		this.changeLineForSolve = changeLineForSolve;
	}
	
	
}