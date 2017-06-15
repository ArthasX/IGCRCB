/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;


/**
  * 概述: 流程组实例表检索条件实现
  * 功能描述: 流程组实例表检索条件实现
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public class IG483SearchCondImpl implements
		IG483SearchCond {

	/** 流程组发起人名称 */
	protected String pgrusername_like;

	/** 流程组发起时间开始 */
	protected String pgropentime_begin;
	
	/** 流程组发起时间结束 */
	protected String pgropentime_end;

	/** 流程组序列号 */
	protected String pgrserialnum_like;

	/** 流程组标题 */
	protected String pgrtitle_like;

	/** 流程模版类型 */
	protected String pttype;
	
	/**排序标识*/
	protected String order;
	
	/** 排序字段 */
	protected String sing;
	
	/** 是否测试数据 */
	protected String istest;

	/** 流程组定义id */
	protected String pgdid;
	
	/** 流程组是否关闭 */
	protected boolean isActive;

	/**
	 * 流程组发起人名称取得
	 *
	 * @return 流程组发起人名称
	 */
	public String getPgrusername_like() {
		return pgrusername_like;
	}

	/**
	 * 流程组发起人名称设定
	 *
	 * @param pgrusername_like 流程组发起人名称
	 */
	public void setPgrusername_like(String pgrusername_like) {
		this.pgrusername_like = pgrusername_like;
	}

	/**
	 * 流程组发起时间开始取得
	 * @return 流程组发起时间开始
	 */
	public String getPgropentime_begin() {
		return pgropentime_begin;
	}

	/**
	 * 流程组发起时间开始设定
	 * @param pgropentime_begin 流程组发起时间开始
	 */
	public void setPgropentime_begin(String pgropentime_begin) {
		this.pgropentime_begin = pgropentime_begin;
	}

	/**
	 * 流程组发起时间结束取得
	 * @return 流程组发起时间结束
	 */
	public String getPgropentime_end() {
		return pgropentime_end;
	}

	/**
	 * 流程组发起时间结束设定
	 * @param pgropentime_end 流程组发起时间结束
	 */
	public void setPgropentime_end(String pgropentime_end) {
		this.pgropentime_end = pgropentime_end;
	}

	/**
	 * 流程组序列号取得
	 *
	 * @return 流程组序列号
	 */
	public String getPgrserialnum_like() {
		return pgrserialnum_like;
	}

	/**
	 * 流程组序列号设定
	 *
	 * @param pgrserialnum_like 流程组序列号
	 */
	public void setPgrserialnum_like(String pgrserialnum_like) {
		this.pgrserialnum_like = pgrserialnum_like;
	}

	/**
	 * 流程组标题取得
	 *
	 * @return 流程组标题
	 */
	public String getPgrtitle_like() {
		return pgrtitle_like;
	}

	/**
	 * 流程组标题设定
	 *
	 * @param pgrtitle_like 流程组标题
	 */
	public void setPgrtitle_like(String pgrtitle_like) {
		this.pgrtitle_like = pgrtitle_like;
	}
	
	/**
	 * 流程模版类型取得
	 * 
	 * @return 流程模版类型
	 */
	public String getPttype() {
		return pttype;
	}

	/**
	 * 流程模版类型设定
	 * 
	 * @param pttype 流程模版类型
	 */
	public void setPttype(String pttype) {
		this.pttype = pttype;
	}

	/**
	 * 排序标识取得
	 * @return order 排序标识
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * 排序标识设定
	 * @param order 排序标识
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * 排序字段取得
	 * @return sing 排序字段
	 */
	public String getSing() {
		return sing;
	}

	/**
	 * 排序字段设定
	 * @param sing 排序字段
	 */
	public void setSing(String sing) {
		this.sing = sing;
	}
	
	/**
	 * 是否测试数据设定
	 * @return 是否测试数据
	 */
	public String getIstest() {
		return istest;
	}

	/**
	 * 是否测试数据取得
	 * @param istest 是否测试数据
	 */
	public void setIstest(String istest) {
		this.istest = istest;
	}

	/**
	 * 流程组定义id取得
	 *
	 * @return 流程组定义id
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * 流程组定义id设定
	 *
	 * @param pgdid 流程组定义id
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * 流程组是否关闭取得
	 * @return 流程组是否关闭
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * 流程组是否关闭设定
	 * @param isActive 流程组是否关闭
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}