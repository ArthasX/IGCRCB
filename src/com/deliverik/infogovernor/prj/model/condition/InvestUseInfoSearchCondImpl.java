/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.model.condition;

/**
 * 概述: 
 * 功能描述：
 * 创建人：王廷志
 * 创建记录： 2012-5-22
 * 修改记录：
 */
public class InvestUseInfoSearchCondImpl implements InvestUseInfoSearchCond{
	/** 项目发起时间开始 */
	private String popentime_start;
	/** 项目发起时间结束 */
	private String popentime_end;
	/**
	 * 项目发起时间开始取得
	 * @return popentime_start 项目发起时间开始
	 */
	public String getPopentime_start() {
		return popentime_start;
	}
	/**
	 * 项目发起时间开始设定
	 * @param popentime_start 项目发起时间开始
	 */
	public void setPopentime_start(String popentime_start) {
		this.popentime_start = popentime_start;
	}
	/**
	 * 项目发起时间结束取得
	 * @return popentime_end 项目发起时间结束
	 */
	public String getPopentime_end() {
		return popentime_end;
	}
	/**
	 * 项目发起时间结束设定
	 * @param popentime_end 项目发起时间结束
	 */
	public void setPopentime_end(String popentime_end) {
		this.popentime_end = popentime_end;
	}
}
