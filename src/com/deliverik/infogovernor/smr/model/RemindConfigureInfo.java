/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 提醒配置表接口
  * 功能描述: 提醒配置表接口
  * 创建记录: 2013/08/05
  * 修改记录: 
  */
public interface RemindConfigureInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getRcid();

	/**
	 * 年取得
	 *
	 * @return 年
	 */
	public String getRcyear();

	/**
	 * 月取得
	 *
	 * @return 月
	 */
	public String getRcmonth();

	/**
	 * 日取得
	 *
	 * @return 日
	 */
	public String getRcday();

	/**
	 * 类型取得
	 *
	 * @return 类型
	 */
	public String getRctype();

}