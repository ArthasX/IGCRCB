/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

/**
  * 概述: vCloud部署日志检索条件实现
  * 功能描述: vCloud部署日志检索条件实现
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
public class VCD04SearchCondImpl implements VCD04SearchCond {

	/** 项目ID */
	protected Integer pid;

	/**
	 * 项目ID取得
	 * @return pid 项目ID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 项目ID设定
	 * @param pid 项目ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
}