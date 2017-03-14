/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditDefSearchCond;

/**
 * 
 * 值班检查管理form
 *
 */
public class IGDUT0102Form extends BaseForm implements DutyAuditDefSearchCond{


	private static final long serialVersionUID = 1L;
	
	/**
	 * 检查项ID
	 */
	protected Integer dadid;

	/**
	 * 检查分类
	 */
	protected String dadtype;
	
	/**
	 * 检查名称
	 */
	protected String dadname;
	
	/**
	 * 状态 启用:1 停用:2
	 */
	protected String dadstatus;
	
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
	 * 检查项ID
	 * @return 检查项ID
	 */
	public Integer getDadid() {
		return dadid;
	}

	/**
	 * 检查项ID
	 * @param dadid 检查项ID
	 */
	public void setDadid(Integer dadid) {
		this.dadid = dadid;
	}
	
	/**
	 * 值班检查状态
	 * @return 值班检查状态
	 */
	public String getDadstatus() {
		return dadstatus;
	}

	/**
	 * 值班检查状态
	 * @param dadstatus 值班检查状态
	 */
	public void setDadstatus(String dadstatus) {
		this.dadstatus = dadstatus;
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
