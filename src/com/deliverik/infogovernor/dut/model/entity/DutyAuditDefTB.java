/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dut.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dut.model.DutyAuditDef;

/**
 * 值班检查管理实体
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="DutyAuditDef")
public class DutyAuditDefTB extends BaseEntity implements Serializable, Cloneable, DutyAuditDef {
	
	@Id
	@TableGenerator(
		    name="DUTYAUDITDEF_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="DUTYAUDITDEF_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="DUTYAUDITDEF_TABLE_GENERATOR")
	
	
	/**
	 * 检查项ID
	 */
	protected Integer dadid;

	/**
	 * 值班类型
	 */
	protected String dadcategory;
	
	/**
	 * 检查分类
	 */
	protected String dadtype;
	
	/**
	 * 检查名称
	 */
	protected String dadname;
	
	/**
	 * 填报时间限制
	 */
	protected String dadlimtime;
	
	/**
	 * 检查结果内容
	 */
	protected String dadcontent;
	
	/**
	 * 结果说明
	 */
	protected String dadinfo;
	
	/**
	 * 使用状态
	 */
	protected String dadstatus;
	
	/**
	 * 更新者ID
	 */
	protected String daduserid;
	
	/**
	 * 更新者姓名
	 */
	protected String dadusername;
	
	/**
	 * 更新时间
	 */
	protected String dadupdtime;
	
	/** 排序标识 */
	protected Integer dadorderby;
	
	/** 周期类型 */
	protected String periodType;
	
	/** 周期时间 */
	protected String periodValue;
	
	/**
	 * 周期类型取得
	 * @return 周期类型
	 */
	public String getPeriodType() {
		return periodType;
	}

	/**
	 * 周期类型设定
	 * @param periodType 周期类型
	 */
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	/**
	 * 周期时间取得
	 * @return 周期时间
	 */
	public String getPeriodValue() {
		return periodValue;
	}

	/**
	 * 周期时间设定
	 * @param periodValue周期时间
	 */
	public void setPeriodValue(String periodValue) {
		this.periodValue = periodValue;
	}

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return dadid;
	}
	
	/**
	 * 检查项ID
	 * @return 检查项ID
	 */
	public Integer getDadid() {
		return dadid;
	}

	/**
	 * 值班类型
	 * @param dadid 值班类型
	 */
	public void setDadid(Integer dadid) {
		this.dadid = dadid;
	}

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

	/**
	 * 填报时间限制
	 * @return 填报时间限制
	 */
	public String getDadlimtime() {
		return dadlimtime;
	}

	/**
	 * 填报时间限制
	 * @param dadlimtime 填报时间限制
	 */
	public void setDadlimtime(String dadlimtime) {
		this.dadlimtime = dadlimtime;
	}

	/**
	 * 检查结果内容
	 * @return 检查结果内容
	 */
	public String getDadcontent() {
		return dadcontent;
	}

	/**
	 * 检查结果内容
	 * @param dadcontent 检查结果内容
	 */
	public void setDadcontent(String dadcontent) {
		this.dadcontent = dadcontent;
	}

	/**
	 * 结果说明
	 * @return 结果说明
	 */
	public String getDadinfo() {
		return dadinfo;
	}

	/**
	 * 结果说明
	 * @param dadinfo 结果说明
	 */
	public void setDadinfo(String dadinfo) {
		this.dadinfo = dadinfo;
	}

	/**
	 * 使用状态
	 * @return 使用状态
	 */
	public String getDadstatus() {
		return dadstatus;
	}

	/**
	 * 使用状态
	 * @param dadstatus 使用状态
	 */
	public void setDadstatus(String dadstatus) {
		this.dadstatus = dadstatus;
	}

	/**
	 * 更新者ID
	 * @return 更新者ID
	 */
	public String getDaduserid() {
		return daduserid;
	}

	/**
	 * 更新者ID
	 * @param daduserid 更新者ID
	 */
	public void setDaduserid(String daduserid) {
		this.daduserid = daduserid;
	}

	/**
	 * 更新者姓名
	 * @return 更新者姓名
	 */
	public String getDadusername() {
		return dadusername;
	}

	/**
	 * 更新者姓名
	 * @param dadusername 更新者姓名
	 */
	public void setDadusername(String dadusername) {
		this.dadusername = dadusername;
	}

	/**
	 * 更新时间
	 * @return 更新时间
	 */
	public String getDadupdtime() {
		return dadupdtime;
	}

	/**
	 * 更新时间
	 * @param dadupdtime 更新时间
	 */
	public void setDadupdtime(String dadupdtime) {
		this.dadupdtime = dadupdtime;
	}

	/**
	 * 排序标识取得
	 *
	 * @return dadorderby 排序标识
	 */
	public Integer getDadorderby() {
		return dadorderby;
	}

	/**
	 * 排序标识设定
	 *
	 * @param dadorderby 排序标识
	 */
	public void setDadorderby(Integer dadorderby) {
		this.dadorderby = dadorderby;
	}

}
