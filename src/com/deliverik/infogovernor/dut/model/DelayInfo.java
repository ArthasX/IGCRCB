/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dut.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 延时解锁信息表接口
  * 功能描述: 延时解锁信息表接口
  * 创建记录: 2012/04/05
  * 修改记录: 
  */
public interface DelayInfo extends BaseModel {

	/**
	 * 主键id取得
	 *
	 * @return 主键id
	 */
	public Integer getId();

	/**
	 * 日期取得
	 *
	 * @return 日期
	 */
	public String getDatetime();

	/**
	 * 申请单位取得
	 *
	 * @return 申请单位
	 */
	public String getOrgname();

	/**
	 * 申请标题取得
	 *
	 * @return 申请标题
	 */
	public String getTitle();
	
	/**
	 * 行长姓名取得
	 * @return
	 */
	public String getHzname();

	/**
	 * 行长电话取得
	 *
	 * @return 行长电话
	 */
	public String getHztel();
	
	/**
	 * 经理姓名取得
	 * @return
	 */
	public String getJlname();

	/**
	 * 经理电话取得
	 *
	 * @return 经理电话
	 */
	public String getJltel();

	/**
	 * 备注取得
	 *
	 * @return 备注
	 */
	public String getRemark();

	/**
	 * 开始时间取得
	 *
	 * @return 开始时间
	 */
	public String getStarttime();

	/**
	 * 结束时间取得
	 *
	 * @return 结束时间
	 */
	public String getEndtime();

	/**
	 * 操作人取得
	 *
	 * @return 操作人
	 */
	public String getOperater();
	
	/**
	 * 解锁时间取得
	 * @return
	 */
	public String getUnlocktime();

}