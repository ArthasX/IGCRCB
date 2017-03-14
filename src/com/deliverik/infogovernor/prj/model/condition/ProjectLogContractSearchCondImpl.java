/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prj.model.condition;

/**
  * 概述: 项目日志合同表检索条件实现
  * 功能描述: 项目日志合同表检索条件实现
  * 创建记录: 2012/04/10
  * 修改记录: 
  */
public class ProjectLogContractSearchCondImpl implements
		ProjectLogContractSearchCond {
	
	/** 主键 */
	protected Integer plcid;

	/** 合同金额 */
	protected Double plcsum;

	/** 合同付款条件 */
	protected String plcsumterm;

	/** 一期付款金额 */
	protected Double plcfirst;

	/** 一期付款条件 */
	protected String plcfirstterm;

	/** 二期付款金额 */
	protected Double plcsecond;

	/** 二期付款条件 */
	protected String plcsecondterm;

	/** 三期付款金额 */
	protected Double plcthird;

	/** 三期付款条件 */
	protected String plcthirdterm;

	/** 四期付款金额 */
	protected Double plcfourth;

	/** 四期付款条件 */
	protected String plcfourthterm;

	/** 五期付款金额 */
	protected Double plcfifth;

	/** 五期付款条件 */
	protected String plcfifthterm;
	
	/** 对应项目id */
	protected Integer plcpid;

	/** 对应项目日志id */
	protected Integer plcplid;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPlcid() {
		return plcid;
	}

	/**
	 * 主键设定
	 *
	 * @param plcid 主键
	 */
	public void setPlcid(Integer plcid) {
		this.plcid = plcid;
	}

	/**
	 * 合同金额取得
	 *
	 * @return 合同金额
	 */
	public Double getPlcsum() {
		return plcsum;
	}

	/**
	 * 合同金额设定
	 *
	 * @param plcsum 合同金额
	 */
	public void setPlcsum(Double plcsum) {
		this.plcsum = plcsum;
	}

	/**
	 * 合同付款条件取得
	 *
	 * @return 合同付款条件
	 */
	public String getPlcsumterm() {
		return plcsumterm;
	}

	/**
	 * 合同付款条件设定
	 *
	 * @param plcsumterm 合同付款条件
	 */
	public void setPlcsumterm(String plcsumterm) {
		this.plcsumterm = plcsumterm;
	}

	/**
	 * 一期付款金额取得
	 *
	 * @return 一期付款金额
	 */
	public Double getPlcfirst() {
		return plcfirst;
	}

	/**
	 * 一期付款金额设定
	 *
	 * @param plcfirst 一期付款金额
	 */
	public void setPlcfirst(Double plcfirst) {
		this.plcfirst = plcfirst;
	}

	/**
	 * 一期付款条件取得
	 *
	 * @return 一期付款条件
	 */
	public String getPlcfirstterm() {
		return plcfirstterm;
	}

	/**
	 * 一期付款条件设定
	 *
	 * @param plcfirstterm 一期付款条件
	 */
	public void setPlcfirstterm(String plcfirstterm) {
		this.plcfirstterm = plcfirstterm;
	}

	/**
	 * 二期付款金额取得
	 *
	 * @return 二期付款金额
	 */
	public Double getPlcsecond() {
		return plcsecond;
	}

	/**
	 * 二期付款金额设定
	 *
	 * @param plcsecond 二期付款金额
	 */
	public void setPlcsecond(Double plcsecond) {
		this.plcsecond = plcsecond;
	}

	/**
	 * 二期付款条件取得
	 *
	 * @return 二期付款条件
	 */
	public String getPlcsecondterm() {
		return plcsecondterm;
	}

	/**
	 * 二期付款条件设定
	 *
	 * @param plcsecondterm 二期付款条件
	 */
	public void setPlcsecondterm(String plcsecondterm) {
		this.plcsecondterm = plcsecondterm;
	}

	/**
	 * 三期付款金额取得
	 *
	 * @return 三期付款金额
	 */
	public Double getPlcthird() {
		return plcthird;
	}

	/**
	 * 三期付款金额设定
	 *
	 * @param plcthird 三期付款金额
	 */
	public void setPlcthird(Double plcthird) {
		this.plcthird = plcthird;
	}

	/**
	 * 三期付款条件取得
	 *
	 * @return 三期付款条件
	 */
	public String getPlcthirdterm() {
		return plcthirdterm;
	}

	/**
	 * 三期付款条件设定
	 *
	 * @param plcthirdterm 三期付款条件
	 */
	public void setPlcthirdterm(String plcthirdterm) {
		this.plcthirdterm = plcthirdterm;
	}

	/**
	 * 四期付款金额取得
	 *
	 * @return 四期付款金额
	 */
	public Double getPlcfourth() {
		return plcfourth;
	}

	/**
	 * 四期付款金额设定
	 *
	 * @param plcfourth 四期付款金额
	 */
	public void setPlcfourth(Double plcfourth) {
		this.plcfourth = plcfourth;
	}

	/**
	 * 四期付款条件取得
	 *
	 * @return 四期付款条件
	 */
	public String getPlcfourthterm() {
		return plcfourthterm;
	}

	/**
	 * 四期付款条件设定
	 *
	 * @param plcfourthterm 四期付款条件
	 */
	public void setPlcfourthterm(String plcfourthterm) {
		this.plcfourthterm = plcfourthterm;
	}

	/**
	 * 五期付款金额取得
	 *
	 * @return 五期付款金额
	 */
	public Double getPlcfifth() {
		return plcfifth;
	}

	/**
	 * 五期付款金额设定
	 *
	 * @param plcfifth 五期付款金额
	 */
	public void setPlcfifth(Double plcfifth) {
		this.plcfifth = plcfifth;
	}

	/**
	 * 五期付款条件取得
	 *
	 * @return 五期付款条件
	 */
	public String getPlcfifthterm() {
		return plcfifthterm;
	}

	/**
	 * 五期付款条件设定
	 *
	 * @param plcfifthterm 五期付款条件
	 */
	public void setPlcfifthterm(String plcfifthterm) {
		this.plcfifthterm = plcfifthterm;
	}
	
	/**
	 * 对应项目id取得
	 *
	 * @return 对应项目id
	 */
	public Integer getPlcpid() {
		return plcpid;
	}

	/**
	 * 对应项目id设定
	 *
	 * @param plcplid 对应项目id
	 */
	public void setPlcpid(Integer plcpid) {
		this.plcpid = plcpid;
	}

	/**
	 * 对应项目日志id取得
	 *
	 * @return 对应项目日志id
	 */
	public Integer getPlcplid() {
		return plcplid;
	}

	/**
	 * 对应项目日志id设定
	 *
	 * @param plcplid 对应项目日志id
	 */
	public void setPlcplid(Integer plcplid) {
		this.plcplid = plcplid;
	}
}