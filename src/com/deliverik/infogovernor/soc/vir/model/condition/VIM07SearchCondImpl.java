/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

/**
  * 概述: 虚机调整信息表检索条件实现
  * 功能描述: 虚机调整信息表检索条件实现
  * 创建记录: 2014/03/24
  * 修改记录: 
  */
public class VIM07SearchCondImpl implements VIM07SearchCond {

	/** 流程ID */
	protected Integer prid;
	
	/** 项目ID */
	protected Integer pid;

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