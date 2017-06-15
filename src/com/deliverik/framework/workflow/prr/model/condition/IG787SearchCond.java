/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>概述:流程共通变量视图查询条件接口</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public interface IG787SearchCond {

	/**
	 * 功能：流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid();
	
	/**
	 * 功能：共通变量ID取得
	 * @return 共通变量ID
	 */
	public Integer getPidgid();
	
}
