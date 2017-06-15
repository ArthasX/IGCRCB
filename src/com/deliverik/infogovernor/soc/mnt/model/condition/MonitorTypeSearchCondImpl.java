/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * 概述: 监控类型表检索条件实现
  * 功能描述: 监控类型表检索条件实现
  * 创建记录: 2012/02/07
  * 修改记录: 
  */
public class MonitorTypeSearchCondImpl implements
		MonitorTypeSearchCond {
	/**
	 * 树形层次码
	 */
	protected String mtSyscoding;

	/**
	 * 树形层次码类似
	 */
	protected String mtSyscoding_like;
	
	/**
	 * 树形层次码类似获取
	 * @return
	 */
	public String getMtSyscoding_like() {
		return mtSyscoding_like;
	}

	/**
	 * 树形层次码类似设定
	 * @param mtSyscoding_like
	 */
	public void setMtSyscoding_like(String mtSyscoding_like) {
		this.mtSyscoding_like = mtSyscoding_like;
	}

	/**
	 * 树形层次码取得
	 * @return
	 */
	public String getMtSyscoding() {
		return mtSyscoding;
	}

	/**
	 * 树形层次码设定
	 * @param mtSyscoding
	 */
	public void setMtSyscoding(String mtSyscoding) {
		this.mtSyscoding = mtSyscoding;
	}
}