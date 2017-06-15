/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 备选场景接口
  * 功能描述: 备选场景接口
  * 创建记录: 2016/10/09
  * 修改记录: 
  */
public interface OptionSencesInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getOsid();

	/**
	 * 应急流程prid取得
	 *
	 * @return 应急流程prid
	 */
	public Integer getPrid();

	/**
	 * 场景eiid取得
	 *
	 * @return 场景eiid
	 */
	public Integer getSenceEiid();

}