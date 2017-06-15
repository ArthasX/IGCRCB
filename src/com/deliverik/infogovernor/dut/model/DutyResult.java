/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */

package com.deliverik.infogovernor.dut.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 值班检查内容实体接口
 * 
 */
public interface DutyResult  extends BaseModel {

	/**
	 * 值班检查内容ID取得
	 * @return 值班检查内容ID
	 */
	public Integer getDrid();

	/**
	 * 值班计划ID取得
	 * @return 值班计划ID
	 */
	public Integer getDpid();

	/**
	 * 检查项ID取得
	 * @return 检查项ID
	 */
	public Integer getDadid();
	
	/**
	 * 值班类型
	 */
	public String getDadcategory();

	/**
	 * 检查分类取得
	 * @return 检查分类
	 */
	public String getDadtype();

	/**
	 * 值班日期
	 */
	public String getDptime();
	
	/**
	 * 白班/夜班
	 */
	public String getDptype();
	/**
	 * 检查名称取得
	 * @return 检查名称
	 */
	public String getDadname();

	/**
	 * 检查时间取得
	 * @return 检查时间
	 */
	public String getDattime();

	/**
	 * 填报时间限制取得
	 * @return 填报时间限制
	 */
	public String getDatlimtime();

	/**
	 * 检查结果类型取得
	 * @return 检查结果类型
	 */
	public String getDadcontent();

	/**
	 * 检查结果取得
	 * @return 检查结果
	 */
	public String getDrcontent();

	/**
	 * 实际填报时间取得
	 * @return 实际填报时间
	 */
	public String getDrfilltime();

	/**
	 * 结果说明取得
	 * @return 结果说明
	 */
	public String getDrresult();

	/**
	 * 检查结果填写人ID取得
	 * @return 检查结果填写人ID
	 */
	public String getDruserid();

	/**
	 * 检查结果填写人姓名取得
	 * @return 检查结果填写人姓名
	 */
	public String getDrusername();

	/**
	 * 检查结果填写时间取得
	 * @return 检查结果填写时间
	 */
	public String getDrcretime();
	
	/** 填报日、时限制取得
	 * @return 填报日、时限制
	 */
	public String getDrlimdtime();
	
}