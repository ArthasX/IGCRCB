/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: CI变更任务表接口
  * 功能描述: CI变更任务表接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface CITaskInfo extends BaseModel {

	/**
	 * 逻辑主键取得
	 *
	 * @return 逻辑主键
	 */
	public Integer getCitid();

	/**
	 * CI变更任务描述取得
	 *
	 * @return CI变更任务描述
	 */
	public String getCitdesc();

	/**
	 * CI变更时间戳取得
	 *
	 * @return CI变更时间戳
	 */
	public String getCittime();
	
	/**
	 * 状态取得
	 * @return 状态
	 */
	public String getCitstatus();
	
	/**
	 * 最后更新时间取得
	 * @return 最后更新时间
	 */
	public String getCitupdtime();

	/**
	 * 最后对比时间取得
	 * @return 最后对比时间
	 */
	public String getCitcomptime();

}