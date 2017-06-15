/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>概述:流程相关人员汇总统计查询条件实现</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public class IG160SearchCondImpl implements IG160SearchCond {

	/** 机构ID*/
	protected String orgid;

	/** 查询开始时间*/
	protected String propentime_from;

	/** 查询结束时间*/
	protected String propentime_to;

	/**
	 * 功能：机构ID取得
	 * @return orgid 机构ID
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 功能：机构ID设置
	 * @param orgid 机构ID
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * 功能：查询开始时间取得
	 * @return propentime_from 查询开始时间
	 */
	public String getPropentime_from() {
		return propentime_from;
	}

	/**
	 * 功能：查询开始时间设置
	 * @param propentime_from 查询开始时间
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}

	/**
	 * 功能：查询结束时间取得
	 * @return propentime_to 查询结束时间
	 */
	public String getPropentime_to() {
		return propentime_to;
	}

	/**
	 * 功能：查询结束时间设置
	 * @param propentime_to 查询结束时间
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}
	
}
