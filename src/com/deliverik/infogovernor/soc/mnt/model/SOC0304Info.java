/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 监控任务主表接口
  * 功能描述: 监控任务主表接口
  * 创建记录: 2012/05/10
  * 修改记录: 
  */
public interface SOC0304Info extends BaseModel {

	/**
	 * 任务ID取得
	 *
	 * @return 任务ID
	 */
	public Integer getMtId();

	/**
	 * 存储序列号取得
	 *
	 * @return 存储序列号
	 */
	public String getMtSsn();

	/**
	 * 组件名称取得
	 *
	 * @return 组件名称
	 */
	public String getMtCname();
	
	/**
	 * 对象名称字符串取得
	 *
	 * @return mtObjNames 对象名称字符串
	 */
	public String getMtObjNames() ;
	/**
	 * kpi取得
	 *
	 * @return kpi
	 */
	public String getMtKpi();

	/**
	 * 采集间隔取得
	 *
	 * @return 采集间隔
	 */
	public Integer getMtInterval();

	/**
	 * 采集次数取得
	 *
	 * @return 采集次数
	 */
	public Integer getMtNum();

	/**
	 * 开始时间取得
	 *
	 * @return 开始时间
	 */
	public String getMtStartTime();

	/**
	 * 结束时间取得
	 *
	 * @return 结束时间
	 */
	public String getMtStopTime();

	/**
	 * 预计结束时间取得
	 *
	 * @return 预计结束时间
	 */
	public String getMtPStopTime();

	/**
	 * 任务状态取得 0为运行 1为关闭
	 *
	 * @return 任务状态
	 */
	public String getMtStatus();

	/**
	 * 记录时间取得
	 *
	 * @return 记录时间
	 */
	public String getMtRecordTime();

	/**
	 * 记录用户id取得
	 *
	 * @return 记录用户id
	 */
	public String getMtUserId();

	/**
	 * 用户部门ID取得
	 *
	 * @return 用户部门ID
	 */
	public String getMtOrgId();

}