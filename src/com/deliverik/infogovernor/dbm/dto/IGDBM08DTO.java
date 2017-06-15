/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.dbm.dto;

import com.deliverik.framework.base.BaseDTO;

public class IGDBM08DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/*查询条件*/
	protected String typeValue;
	
	/*查询事件*/
	protected String yearValue;
	
	/*月工作类型数量及占比导航条值*/
	protected String pn1Value;
	
	/*工作平均解决时间导航条值*/
	protected String pn2Value;
	
	/*工作数量趋势导航条值*/
	protected String pn3Value;
	
	/*工作及时解决率趋势导航条值*/
	protected String pn4Value;

	/*月工作类型数量及占比返回值*/
	protected String pieValue;
	
	/*工作平均解决时间返回值*/
	protected String workLineForAvg;
	
	/*工作数量趋势返回值*/
	protected String workLineForCount;
	
	/*工作及时解决率返回值*/
	protected String workLineForSolve;

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

	public String getWorkLineForAvg() {
		return workLineForAvg;
	}

	public void setWorkLineForAvg(String workLineForAvg) {
		this.workLineForAvg = workLineForAvg;
	}

	public String getWorkLineForCount() {
		return workLineForCount;
	}

	public void setWorkLineForCount(String workLineForCount) {
		this.workLineForCount = workLineForCount;
	}

	public String getWorkLineForSolve() {
		return workLineForSolve;
	}

	public void setWorkLineForSolve(String workLineForSolve) {
		this.workLineForSolve = workLineForSolve;
	}

	
	
}