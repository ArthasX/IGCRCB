/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model;

/**
 * <p>概述:流程共通变量实体接口</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public interface IG787Info {
	/**
	 * 功能：流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid();

	
	/**
	 * 功能：共通变量名称取得
	 * @return 共通变量名称
	 */
	public String getGeneralname();

	/**
	 * 功能：共通变量ID取得
	 * @return 共通变量ID
	 */
	public Integer getPidgid();

	/**
	 * 功能：共通变量值取得
	 * @return 共通变量值
	 */
	public String getGeneralvalue();
}