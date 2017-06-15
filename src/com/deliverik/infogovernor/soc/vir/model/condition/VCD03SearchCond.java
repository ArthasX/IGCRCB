/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

/**
  * 概述: 资源申请虚机信息检索条件接口
  * 功能描述: 资源申请虚机信息检索条件接口
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
public interface VCD03SearchCond {


	/**
	 * 项目ID取得
	 * @return pid 项目ID
	 */
	public Integer getPid();

	/**
	 * 流程ID取得
	 * @return prid 流程ID
	 */
	public Integer getPrid();
}