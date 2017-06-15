/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.condition;

/**
  * 概述: 提醒配置表检索条件实现
  * 功能描述: 提醒配置表检索条件实现
  * 创建记录: 2013/08/05
  * 修改记录: 
  */
public class RemindConfigureSearchCondImpl implements
		RemindConfigureSearchCond {

	/** 年 */
	protected String rcyear;
	
	/** 类型 */
	protected String rctype;
	
	/**
	 * 年取得
	 *
	 * @return 年
	 */
	public String getRcyear() {
		return rcyear;
	}

	/**
	 * 年设定
	 *
	 * @param rcyear 年
	 */
	public void setRcyear(String rcyear) {
		this.rcyear = rcyear;
	}
	
	/**
	 * 类型取得
	 *
	 * @return 类型
	 */
	public String getRctype() {
		return rctype;
	}

	/**
	 * 类型设定
	 *
	 * @param rctype 类型
	 */
	public void setRctype(String rctype) {
		this.rctype = rctype;
	}
}