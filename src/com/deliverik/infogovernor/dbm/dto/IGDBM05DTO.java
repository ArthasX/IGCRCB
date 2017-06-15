/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.dbm.dto;

import com.deliverik.framework.base.BaseDTO;

public class IGDBM05DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/*查询条件*/
	protected String typeValue;
	
	/*查询事件*/
	protected String yearValue;
	
	/*月问题类型数量及占比导航条值*/
	protected String pn1Value;
	
	/*问题平均解决时间导航条值*/
	protected String pn2Value;
	
	/*问题数量趋势导航条值*/
	protected String pn3Value;
	
	/*问题及时解决率趋势导航条值*/
	protected String pn4Value;

	/*月问题类型数量及占比返回值*/
	protected String pieValue;
	
	/*问题平均解决时间返回值*/
	protected String problemLineForAvg;
	
	/*问题数量趋势返回值*/
	protected String problemLineForCount;
	
	/*问题及时解决率返回值*/
	protected String problemLineForSolve;
	
	
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

	public String getProblemLineForAvg() {
		return problemLineForAvg;
	}

	public void setProblemLineForAvg(String problemLineForAvg) {
		this.problemLineForAvg = problemLineForAvg;
	}

	public String getProblemLineForCount() {
		return problemLineForCount;
	}

	public void setProblemLineForCount(String problemLineForCount) {
		this.problemLineForCount = problemLineForCount;
	}

	public String getProblemLineForSolve() {
		return problemLineForSolve;
	}

	public void setProblemLineForSolve(String problemLineForSolve) {
		this.problemLineForSolve = problemLineForSolve;
	}
	
}