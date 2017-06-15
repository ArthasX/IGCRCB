/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.prr.model.DispatchStatisticsVWInfo;

/**
  * 概述: 发文流程统计实体
  * 功能描述: 发文流程统计实体
  * 创建记录: 2013/02/27
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
public class DispatchStatisticsVW implements Serializable, Cloneable, DispatchStatisticsVWInfo {

	/** 主键用户ID */
	@Id
	protected String dsuserid;

	/** 用户名 */
	protected String dsusername;

	/** 正常完成数量 */
	protected Integer sumzc;

	/** 延时完成数量 */
	protected Integer sumys;

	/** 未完成数量 */
	protected Integer sumwwc;

	/** 合计数量 */
	protected Integer sumnum;

	/**
	 * 主键用户ID取得
	 *
	 * @return 主键用户ID
	 */
	public String getDsuserid() {
		return dsuserid;
	}

	/**
	 * 主键用户ID设定
	 *
	 * @param dsuserid 主键用户ID
	 */
	public void setDsuserid(String dsuserid) {
		this.dsuserid = dsuserid;
	}

	/**
	 * 用户名取得
	 *
	 * @return 用户名
	 */
	public String getDsusername() {
		return dsusername;
	}

	/**
	 * 用户名设定
	 *
	 * @param dsusername 用户名
	 */
	public void setDsusername(String dsusername) {
		this.dsusername = dsusername;
	}

	/**
	 * 正常完成数量取得
	 *
	 * @return 正常完成数量
	 */
	public Integer getSumzc() {
		return sumzc;
	}

	/**
	 * 正常完成数量设定
	 *
	 * @param sumzc 正常完成数量
	 */
	public void setSumzc(Integer sumzc) {
		this.sumzc = sumzc;
	}

	/**
	 * 延时完成数量取得
	 *
	 * @return 延时完成数量
	 */
	public Integer getSumys() {
		return sumys;
	}

	/**
	 * 延时完成数量设定
	 *
	 * @param sumys 延时完成数量
	 */
	public void setSumys(Integer sumys) {
		this.sumys = sumys;
	}

	/**
	 * 未完成数量取得
	 *
	 * @return 未完成数量
	 */
	public Integer getSumwwc() {
		return sumwwc;
	}

	/**
	 * 未完成数量设定
	 *
	 * @param sumwwc 未完成数量
	 */
	public void setSumwwc(Integer sumwwc) {
		this.sumwwc = sumwwc;
	}

	/**
	 * 合计数量取得
	 *
	 * @return 合计数量
	 */
	public Integer getSumnum() {
		return sumnum;
	}

	/**
	 * 合计数量设定
	 *
	 * @param sumnum 合计数量
	 */
	public void setSumnum(Integer sumnum) {
		this.sumnum = sumnum;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return dsuserid;
	}

}