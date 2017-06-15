/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 备选场景检索条件实现
  * 功能描述: 备选场景检索条件实现
  * 创建记录: 2016/10/09
  * 修改记录: 
  */
public class OptionSencesSearchCondImpl implements
		OptionSencesSearchCond {

	/**
	 * 流程id
	 */
	protected Integer prid_eq;

	public Integer getPrid_eq() {
		return prid_eq;
	}

	public void setPrid_eq(Integer prid_eq) {
		this.prid_eq = prid_eq;
	}

}