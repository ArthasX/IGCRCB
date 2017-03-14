/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

/**
  * 概述: 资源申请虚机信息检索条件实现
  * 功能描述: 资源申请虚机信息检索条件实现
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
public class VCD03SearchCondImpl implements VCD03SearchCond {

	/** 项目ID */
	protected Integer pid;
	
	/** 流程ID */
	protected Integer prid;

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

	/**
	 * 流程ID取得
	 * @return prid 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
}