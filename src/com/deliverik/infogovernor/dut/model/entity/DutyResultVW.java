/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dut.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.infogovernor.dut.model.DutyResultVWInfo;

/**
 * 值班日报视图
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "DutyResultVW")
@IdClass(DutyResultVWPK.class)
@SuppressWarnings("serial")
public class DutyResultVW implements Serializable, DutyResultVWInfo {
	
	/** 检查项ID */
	@Id
	protected Integer dadid;
	
	/** 值班日报ID */
	protected Integer drid;
	
	/** 值班计划ID */
	protected Integer dpid;
	
	/** 检查分类 */
	protected String dadtype;
	
	/** 检查名称 */
	protected String dadname;
	
	/** 检查时间 */
	@Id
	protected String dattime;
	
	/** 填报时间限制 */
	protected String datlimtime;
	
	/** 检查结果类型 */
	protected String dadcontent;
	
	/** 结果说明 */
	protected String dadinfo;
	
	/** 使用状态 */
	protected String dadstatus;
	
	/** 检查结果 */
	protected String drcontent;
	
	/** 实际填报时间 */
	protected String drfilltime;
	
	/** 结果说明 */
	protected String drresult;

	/** 值班类型 */
	protected String dadcategory;
	
	/** 填报日、时限制 */
	protected String drlimdtime;
	
	/** 限制时间 */
	protected String dadlimtime;

	/** 排序标识 */
	protected String dadorderby;
	
	/** 周期类型 */
	protected String periodType;
	
	/** 周期时间 */
	protected String periodValue;
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return new DutyResultVWPK(dadid,dattime);
	}

	
	/**
	 * 周期类型取得
	 * @return 周期类型
	 */
	public String getPeriodType() {
		return periodType;
	}


	/**
	 * 周期类型设定
	 * @param periodType周期类型
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
	 * 限制时间取得
	 * @return 限制时间
	 */
	public String getDadlimtime() {
		return dadlimtime;
	}



	/**
	 * 限制时间设定
	 *
	 * @param dadlimtime 限制时间
	 */
	public void setDadlimtime(String dadlimtime) {
		this.dadlimtime = dadlimtime;
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
	 * 值班类型取得
	 * @return 值班类型
	 */
	public String getDadcategory() {
		return dadcategory;
	}




	/**
	 * 值班类型设定
	 *
	 * @param dadcategory 值班类型
	 */
	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
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
	 * 值班日报ID取得
	 * @return 值班日报ID
	 */
	public Integer getDrid() {
		return drid;
	}



	/**
	 * 检查分类取得
	 * @return 检查分类
	 */
	public String getDadtype() {
		return dadtype;
	}



	/**
	 * 检查名称取得
	 * @return 检查名称
	 */
	public String getDadname() {
		return dadname;
	}



	/**
	 * 检查时间取得
	 * @return 检查时间
	 */
	public String getDattime() {
		return dattime;
	}



	/**
	 * 填报时间限制取得
	 * @return 填报时间限制
	 */
	public String getDatlimtime() {
		return datlimtime;
	}



	/**
	 * 检查结果类型取得
	 * @return 检查结果类型
	 */
	public String getDadcontent() {
		return dadcontent;
	}



	/**
	 * 结果说明取得
	 * @return 结果说明
	 */
	public String getDadinfo() {
		return dadinfo;
	}



	/**
	 * 使用状态取得
	 * @return 使用状态
	 */
	public String getDadstatus() {
		return dadstatus;
	}



	/**
	 * 检查结果取得
	 * @return 检查结果
	 */
	public String getDrcontent() {
		return drcontent;
	}



	/**
	 * 实际填报时间取得
	 * @return 实际填报时间
	 */
	public String getDrfilltime() {
		return drfilltime;
	}



	/**
	 * 结果说明取得
	 * @return 结果说明
	 */
	public String getDrresult() {
		return drresult;
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
	 * 值班日报ID设定
	 *
	 * @param drid 值班日报ID
	 */
	public void setDrid(Integer drid) {
		this.drid = drid;
	}



	/**
	 * 检查分类 设定
	 *
	 * @param dadtype 检查分类 
	 */
	public void setDadtype(String dadtype) {
		this.dadtype = dadtype;
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
	 * 检查时间设定
	 *
	 * @param dattime 检查时间
	 */
	public void setDattime(String dattime) {
		this.dattime = dattime;
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
	 * 检查结果类型设定
	 *
	 * @param dadcontent 检查结果类型
	 */
	public void setDadcontent(String dadcontent) {
		this.dadcontent = dadcontent;
	}



	/**
	 * 结果说明设定
	 *
	 * @param dadinfo 结果说明
	 */
	public void setDadinfo(String dadinfo) {
		this.dadinfo = dadinfo;
	}



	/**
	 * 使用状态设定
	 *
	 * @param dadstatus 使用状态
	 */
	public void setDadstatus(String dadstatus) {
		this.dadstatus = dadstatus;
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
	 * 实际填报时间设定
	 *
	 * @param drfilltime 实际填报时间
	 */
	public void setDrfilltime(String drfilltime) {
		this.drfilltime = drfilltime;
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
	 * 排序标识取得
	 *
	 * @return dadorderby 排序标识
	 */
	public String getDadorderby() {
		return dadorderby;
	}



	/**
	 * 排序标识设定
	 *
	 * @param dadorderby 排序标识
	 */
	public void setDadorderby(String dadorderby) {
		this.dadorderby = dadorderby;
	}
	
	
	

	
}
