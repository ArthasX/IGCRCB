/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dut.model.DutyAuditDef;
import com.deliverik.infogovernor.dut.model.DutyAuditTime;

public class IGDUT0101Form extends BaseForm  implements DutyAuditDef ,DutyAuditTime{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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


	/**检查时间ID */
	protected Integer datid;
	
	
	/**检查项时间 */
	protected String dattime;
	
	/**检查项时间数组 */
	protected String[] dattimes;
	
	/**限制时间 */
	protected String datlimtime;

	/**
	 * 页面标题显示标志0-新增,1-变更
	 */
	protected String mode = "0";
	
	/** 排序标识 */
	protected Integer dadorderby;
	
	/** 周期类型 */
	protected String periodType;
	
	protected String week_value;
	
	protected String month_value;
	
	protected String quarter_monthValue;
	
	protected String quarter_dayValue;
	
	public String getQuarter_monthValue() {
		return quarter_monthValue;
	}

	public void setQuarter_monthValue(String quarter_monthValue) {
		this.quarter_monthValue = quarter_monthValue;
	}

	public String getQuarter_dayValue() {
		return quarter_dayValue;
	}

	public void setQuarter_dayValue(String quarter_dayValue) {
		this.quarter_dayValue = quarter_dayValue;
	}

	public String getMonth_value() {
		return month_value;
	}

	public void setMonth_value(String month_value) {
		this.month_value = month_value;
	}

	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public String getWeek_value() {
		return week_value;
	}

	public void setWeek_value(String week_value) {
		this.week_value = week_value;
	}

	/**
	 * 限制时间取得
	 * @return datlimtime
	 */
	public String getDatlimtime() {
		return datlimtime;
	}

	/**
	 * 限制时间设定
	 */
	public void setDatlimtime(String datlimtime) {
		this.datlimtime = datlimtime;
	}

	
	/**
	 * 检查项时间数组取得
	 * @return dattimes
	 */
	public String[] getDattimes() {
		return dattimes;
	}

	/**
	 * 检查项时间数组设定
	 */
	public void setDattimes(String[] dattimes) {
		this.dattimes = dattimes;
	}

	/**
	 * 新增、变更标识取得
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 新增、变更标识设定
	 * @return mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
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
     * 
	 *检查时间ID取得
	 * @return 检查时间ID
	 */
	public Integer getDatid() {
		return datid;
	}
    
	/**
	 * 
	 * 检查时间ID设定
	 * @param datid 检查时间ID
	 */
	public void setDatid(Integer datid) {
		this.datid = datid;
	}
    
    
	/**
	 * 检查时间取得
	 * @return 检查时间
	 */
	public String getDattime() {
		return dattime;
	}
	
    /**
     * 检查时间设置
     * @param dattime 检查时间
     */
	public void setDattime(String dattime) {
		this.dattime = dattime;
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

	public String getPeriodValue() {
		return null;
	}

	public String getFingerPrint() {
		return null;
	}

	



}
