/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 流程表单信息
 */
public interface PrivateProcessFormInfo {
	
	/**
	 * 参与者角色ID取得
	 *
	 * @return 参与者角色ID
	 */
	public Integer getRoleid();
	
	/**
	 * 参与者用户ID取得
	 * 
	 * @return 参与者用户ID
	 */
	public String getUserid();

	/**
	 * 表单值取得
	 *
	 * @return 表单值
	 */
	public String getValue();
	
	/**
	 * 备注信息取得
	 * @return comment 备注信息
	 */
	public String getComment();

}
