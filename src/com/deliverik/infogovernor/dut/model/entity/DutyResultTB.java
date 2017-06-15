/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */

package com.deliverik.infogovernor.dut.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dut.model.DutyResult;

/**
 * 值班检查内容实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="DutyResult")
public class DutyResultTB extends BaseEntity implements Serializable, Cloneable, DutyResult {

	/** 值班检查内容ID */
	@Id
	@TableGenerator(
		    name="DUTYRESULT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="DUTYRESULT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="DUTYRESULT_TABLE_GENERATOR")
	protected Integer drid;

	/** 值班计划ID */
	protected Integer dpid;
	
	/** 检查项ID */
	protected Integer dadid;
	
	/**
	 * 值班类型
	 */
	protected String dadcategory;
	
	/** 检查分类 */
	protected String dadtype;
	
	/** 检查名称 */
	protected String dadname;
	
	/** 检查名称 */
	protected String dptime;
	
	/** 检查名称 */
	protected String dptype;
	
	/** 检查时间 */
	protected String dattime;
	
	/** 填报时间限制 */
	protected String datlimtime;
	
	/** 检查结果类型 */
	protected String dadcontent;
	
	/** 检查结果 */
	protected String drcontent;
	
	/** 实际填报时间 */
	protected String drfilltime;
	
	/** 结果说明 */
	protected String drresult;
	
	/** 检查结果填写人ID */
	protected String druserid;
	
	/** 检查结果填写人姓名 */
	protected String drusername;
	
	/** 检查结果填写时间 */
	protected String drcretime;
	
	/** 填报日、时限制 */
	protected String drlimdtime;
	


	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return drid;
	}
	
	/**
	 * 填报日、时限制取得
	 * @return 填报日、时限制
	 */
	public String getDrlimdtime() {
		return drlimdtime;
	}

	/**
	 * 填报日、时限制设定
	 *
	 * @param drlimdtime 填报日、时限制
	 */
	public void setDrlimdtime(String drlimdtime) {
		this.drlimdtime = drlimdtime;
	}
	
	/**
	 * 值班检查内容ID取得
	 * @return 值班检查内容ID
	 */
	public Integer getDrid() {
		return drid;
	}
	
	/**
	 * 值班检查内容ID设定
	 *
	 * @param drid 值班检查内容ID
	 */
	public void setDrid(Integer drid) {
		this.drid = drid;
	}

	/**
	 * 值班计划ID取得
	 * @return 值班计划ID
	 */
	public Integer getDpid() {
		return dpid;
	}

	/**
	 * 值班计划ID设定
	 *
	 * @param dpid 值班计划ID
	 */
	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}

	/**
	 * 检查项ID取得
	 * @return 检查项ID
	 */
	public Integer getDadid() {
		return dadid;
	}
	
	/**
	 * 检查项ID设定
	 *
	 * @param dadid 检查项ID
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
	 * 检查分类取得
	 * @return 检查分类
	 */
	public String getDadtype() {
		return dadtype;
	}
	
	/**
	 * 检查分类设定
	 *
	 * @param dadtype 检查分类
	 */
	public void setDadtype(String dadtype) {
		this.dadtype = dadtype;
	}

	/**
	 * 检查名称取得
	 * @return 检查名称
	 */
	public String getDadname() {
		return dadname;
	}
	
	/**
	 * 检查名称设定
	 *
	 * @param dadname 检查名称
	 */
	public void setDadname(String dadname) {
		this.dadname = dadname;
	}
	
	/**
	 * 值班日期取得
	 * @return 值班日期
	 */
	public String getDptime() {
		return dptime;
	}
	
	/**
	 * 值班日期设定
	 *
	 * @param dptime 值班日期
	 */
	public void setDptime(String dptime) {
		this.dptime = dptime;
	}
	
	/**
	 * 白班/夜班取得
	 * @return 白班/夜班
	 */
	public String getDptype() {
		return dptype;
	}
	
	/**
	 * 白班/夜班设定
	 *
	 * @param dptype 白班/夜班
	 */
	public void setDptype(String dptype) {
		this.dptype = dptype;
	}

	/**
	 * 检查时间取得
	 * @return 检查时间
	 */
	public String getDattime() {
		return dattime;
	}
	
	/**
	 * 检查时间设定
	 *
	 * @param dattime 检查时间
	 */
	public void setDattime(String dattime) {
		this.dattime = dattime;
	}

	/**
	 * 填报时间限制取得
	 * @return 填报时间限制
	 */
	public String getDatlimtime() {
		return datlimtime;
	}
	
	/**
	 * 填报时间限制设定
	 *
	 * @param datlimtime 填报时间限制
	 */
	public void setDatlimtime(String datlimtime) {
		this.datlimtime = datlimtime;
	}

	/**
	 * 检查结果类型取得
	 * @return 检查结果类型
	 */
	public String getDadcontent() {
		return dadcontent;
	}
	
	/**
	 * 检查结果类型设定
	 *
	 * @param dadcontent 检查结果类型
	 */
	public void setDadcontent(String dadcontent) {
		this.dadcontent = dadcontent;
	}

	/**
	 * 检查结果取得
	 * @return 检查结果
	 */
	public String getDrcontent() {
		return drcontent;
	}
	
	/**
	 * 检查结果设定
	 *
	 * @param drcontent 检查结果
	 */
	public void setDrcontent(String drcontent) {
		this.drcontent = drcontent;
	}

	/**
	 * 实际填报时间取得
	 * @return 实际填报时间
	 */
	public String getDrfilltime() {
		return drfilltime;
	}
	
	/**
	 * 实际填报时间设定
	 *
	 * @param drfilltime 实际填报时间
	 */
	public void setDrfilltime(String drfilltime) {
		this.drfilltime = drfilltime;
	}

	/**
	 * 结果说明取得
	 * @return 结果说明
	 */
	public String getDrresult() {
		return drresult;
	}
	
	/**
	 * 结果说明设定
	 *
	 * @param drresult 结果说明
	 */
	public void setDrresult(String drresult) {
		this.drresult = drresult;
	}

	/**
	 * 检查结果填写人ID取得
	 * @return 检查结果填写人ID
	 */
	public String getDruserid() {
		return druserid;
	}
	
	/**
	 * 检查结果填写人ID设定
	 *
	 * @param druserid 检查结果填写人ID
	 */
	public void setDruserid(String druserid) {
		this.druserid = druserid;
	}

	/**
	 * 检查结果填写人姓名取得
	 * @return 检查结果填写人姓名
	 */
	public String getDrusername() {
		return drusername;
	}
	
	/**
	 * 检查结果填写人姓名设定
	 *
	 * @param drusername 检查结果填写人姓名
	 */
	public void setDrusername(String drusername) {
		this.drusername = drusername;
	}

	/**
	 * 检查结果填写时间取得
	 * @return 检查结果填写时间
	 */
	public String getDrcretime() {
		return drcretime;
	}
	
	/**
	 * 检查结果填写时间设定
	 *
	 * @param drcretime 检查结果填写时间
	 */
	public void setDrcretime(String drcretime) {
		this.drcretime = drcretime;
	}
	
}
