/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dut.model.condition;

/**
  * 概述: 延时解锁信息表检索条件实现
  * 功能描述: 延时解锁信息表检索条件实现
  * 创建记录: 2012/04/05
  * 修改记录: 
  */
public class DelaySearchCondImpl implements
		DelaySearchCond {

	/** 主键id */
	protected Integer id;

	/** 日期时间从 */
	protected String datetime_from;
	
	/** 日期时间到 */
	protected String datetime_to;

	/**
	 * 日期时间从取得
	 * @return
	 */
	public String getDatetime_from() {
		return datetime_from;
	}

	/**
	 * 日期时间从设定
	 * @param datetime_from
	 */
	public void setDatetime_from(String datetime_from) {
		this.datetime_from = datetime_from;
	}

	/**
	 * 日期时间到取得
	 * @return
	 */
	public String getDatetime_to() {
		return datetime_to;
	}

	/**
	 * 日期时间到设定
	 * @param datetime_to
	 */
	public void setDatetime_to(String datetime_to) {
		this.datetime_to = datetime_to;
	}

	/** 申请单位 */
	protected String orgname_eq;

	/** 申请标题 */
	protected String title_like;

	/**
	 * 主键id取得
	 *
	 * @return 主键id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键id设定
	 *
	 * @param id 主键id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 申请单位取得
	 *
	 * @return 申请单位
	 */
	public String getOrgname_eq() {
		return orgname_eq;
	}

	/**
	 * 申请单位设定
	 *
	 * @param orgname 申请单位
	 */
	public void setOrgname_eq(String orgname_eq) {
		this.orgname_eq = orgname_eq;
	}

	/**
	 * 申请标题取得
	 *
	 * @return 申请标题
	 */
	public String getTitle_like() {
		return title_like;
	}

	/**
	 * 申请标题设定
	 *
	 * @param title 申请标题
	 */
	public void setTitle_like(String title_like) {
		this.title_like = title_like;
	}
}