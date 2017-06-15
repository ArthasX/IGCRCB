/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.condition;

/**
 * 值班检查信息查询条件接口实现
 */
public class DutyAuditDefSearchCondImpl implements DutyAuditDefSearchCond{
	
	/**
	 * 检查分类
	 */
	protected String dadtype;
	
	/**
	 * 检查名称
	 */
	protected String dadname;
	
	/**
	 * 值班类型
	 */
	protected String dadcategory;
	
	/**
	 * 值班类型
	 * @return 值班类型
	 */
	public String getDadcategory() {
		return dadcategory;
	}

	/**
	 * 值班类型
	 * @param dadcategory 值班类型
	 */
	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}

	/**
	 * 检查分类
	 * @return 检查分类
	 */
	public String getDadtype() {
		return dadtype;
	}

	/**
	 * 检查分类
	 * @param dadtype 检查分类
	 */
	public void setDadtype(String dadtype) {
		this.dadtype = dadtype;
	}

	/**
	 * 检查名称
	 * @return 检查名称
	 */
	public String getDadname() {
		return dadname;
	}

	/**
	 * 检查名称
	 * @param dadname 检查名称
	 */
	public void setDadname(String dadname) {
		this.dadname = dadname;
	}

}
