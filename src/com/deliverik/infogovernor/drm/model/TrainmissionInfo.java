/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 培训任务表接口
  * 功能描述: 培训任务表接口
  * 创建记录: 2015/04/10
  * 修改记录: 
  */
public interface TrainmissionInfo extends BaseModel {

	/**
	 * tmid取得
	 *
	 * @return tmid
	 */
	public Integer getTmid();

	/**
	 * 外键取得
	 *
	 * @return 外键
	 */
	public Integer  getTpid();

	/**
	 * 培训课程取得
	 *
	 * @return 培训课程
	 */
	public String getTmcourse();

	/**
	 * 培训机构取得
	 *
	 * @return 培训机构
	 */
	public String getTmorg();

	/**
	 * 培训时间取得
	 *
	 * @return 培训时间
	 */
	public String getTmtime();

	/**
	 * 培训对象取得
	 *
	 * @return 培训对象
	 */
	public String getTmtarget();

	/**
	 * 附件取得
	 *
	 * @return 附件
	 */
	public String getTmatt();
}