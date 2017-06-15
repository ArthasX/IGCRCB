/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prj.model.condition;

/**
  * 概述: 项目日志付款表检索条件实现
  * 功能描述: 项目日志付款表检索条件实现
  * 创建记录: 2012/04/11
  * 修改记录: 
  */
public class ProjectLogBusinessSearchCondImpl implements
		ProjectLogBusinessSearchCond {

	/** 主键 */
	protected Integer plbid;

	/** 合同总额 */
	protected Double plbplcsum;

	/** 一期付款金额 */
	protected Double plbfirst;

	/** 二期付款金额 */
	protected Double plbsecond;

	/** 三期付款金额 */
	protected Double plbthird;

	/** 四期付款金额 */
	protected Double plbfourth;

	/** 五期付款金额 */
	protected Double plbfifth;
	
	/** 对应项目id */
	protected Integer plbpid;

	/** 对应项目日志id */
	protected Integer plbplid;

	/** 已付款总额 */
	protected Double plbsum;

	/** 已付款比例 */
	protected Double plbscale;

	/** 未付款总额 */
	protected Double plbnotsum;

	/** 未付款比例 */
	protected Double plbnotscale;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPlbid() {
		return plbid;
	}

	/**
	 * 主键设定
	 *
	 * @param plbid 主键
	 */
	public void setPlbid(Integer plbid) {
		this.plbid = plbid;
	}

	/**
	 * 合同总额取得
	 *
	 * @return 合同总额
	 */
	public Double getPlbplcsum() {
		return plbplcsum;
	}

	/**
	 * 合同总额设定
	 *
	 * @param plbplcsum 合同总额
	 */
	public void setPlbplcsum(Double plbplcsum) {
		this.plbplcsum = plbplcsum;
	}

	/**
	 * 一期付款金额取得
	 *
	 * @return 一期付款金额
	 */
	public Double getPlbfirst() {
		return plbfirst;
	}

	/**
	 * 一期付款金额设定
	 *
	 * @param plbfirst 一期付款金额
	 */
	public void setPlbfirst(Double plbfirst) {
		this.plbfirst = plbfirst;
	}

	/**
	 * 二期付款金额取得
	 *
	 * @return 二期付款金额
	 */
	public Double getPlbsecond() {
		return plbsecond;
	}

	/**
	 * 二期付款金额设定
	 *
	 * @param plbsecond 二期付款金额
	 */
	public void setPlbsecond(Double plbsecond) {
		this.plbsecond = plbsecond;
	}

	/**
	 * 三期付款金额取得
	 *
	 * @return 三期付款金额
	 */
	public Double getPlbthird() {
		return plbthird;
	}

	/**
	 * 三期付款金额设定
	 *
	 * @param plbthird 三期付款金额
	 */
	public void setPlbthird(Double plbthird) {
		this.plbthird = plbthird;
	}

	/**
	 * 四期付款金额取得
	 *
	 * @return 四期付款金额
	 */
	public Double getPlbfourth() {
		return plbfourth;
	}

	/**
	 * 四期付款金额设定
	 *
	 * @param plbfourth 四期付款金额
	 */
	public void setPlbfourth(Double plbfourth) {
		this.plbfourth = plbfourth;
	}

	/**
	 * 五期付款金额取得
	 *
	 * @return 五期付款金额
	 */
	public Double getPlbfifth() {
		return plbfifth;
	}

	/**
	 * 五期付款金额设定
	 *
	 * @param plbfifth 五期付款金额
	 */
	public void setPlbfifth(Double plbfifth) {
		this.plbfifth = plbfifth;
	}
	
	/**
	 * 对应项目id取得
	 *
	 * @return 对应项目id
	 */
	public Integer getPlbpid() {
		return plbpid;
	}

	/**
	 * 对应项目id设定
	 *
	 * @param plbplid 对应项目日志id
	 */
	public void setPlbpid(Integer plbpid) {
		this.plbpid = plbpid;
	}

	/**
	 * 对应项目日志id取得
	 *
	 * @return 对应项目日志id
	 */
	public Integer getPlbplid() {
		return plbplid;
	}

	/**
	 * 对应项目日志id设定
	 *
	 * @param plbplid 对应项目日志id
	 */
	public void setPlbplid(Integer plbplid) {
		this.plbplid = plbplid;
	}

	/**
	 * 已付款总额取得
	 *
	 * @return 已付款总额
	 */
	public Double getPlbsum() {
		return plbsum;
	}

	/**
	 * 已付款总额设定
	 *
	 * @param plbsum 已付款总额
	 */
	public void setPlbsum(Double plbsum) {
		this.plbsum = plbsum;
	}

	/**
	 * 已付款比例取得
	 *
	 * @return 已付款比例
	 */
	public Double getPlbscale() {
		return plbscale;
	}

	/**
	 * 已付款比例设定
	 *
	 * @param plbscale 已付款比例
	 */
	public void setPlbscale(Double plbscale) {
		this.plbscale = plbscale;
	}

	/**
	 * 未付款总额取得
	 *
	 * @return 未付款总额
	 */
	public Double getPlbnotsum() {
		return plbnotsum;
	}

	/**
	 * 未付款总额设定
	 *
	 * @param plbnotsum 未付款总额
	 */
	public void setPlbnotsum(Double plbnotsum) {
		this.plbnotsum = plbnotsum;
	}

	/**
	 * 未付款比例取得
	 *
	 * @return 未付款比例
	 */
	public Double getPlbnotscale() {
		return plbnotscale;
	}

	/**
	 * 未付款比例设定
	 *
	 * @param plbnotscale 未付款比例
	 */
	public void setPlbnotscale(Double plbnotscale) {
		this.plbnotscale = plbnotscale;
	}

}