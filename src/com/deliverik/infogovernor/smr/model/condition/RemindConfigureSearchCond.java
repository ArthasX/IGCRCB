/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.condition;

/**
  * 概述: 提醒配置表检索条件接口
  * 功能描述: 提醒配置表检索条件接口
  * 创建记录: 2013/08/05
  * 修改记录: 
  */
public interface RemindConfigureSearchCond {

	/**
	 * 年取得
	 *
	 * @return 年
	 */
	public String getRcyear();
	
	/**
	 * 类型取得
	 *
	 * @return 类型
	 */
	public String getRctype();
}