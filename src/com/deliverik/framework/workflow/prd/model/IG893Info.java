/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model;


/**
 * 流程参与者变量权限视图接口
 *
 */
public interface IG893Info {
	
	/**
	 * 流程变量ID取得
	 * @return 流程变量ID
	 */
	public String getPidid();
	
	/**
	 * 流程状态的ID取得
	 * @return 流程状态的ID
	 */
	public String getPsdid();
	
	/**
	 * 流程参与者角色ID取得
	 * @return 流程参与者角色ID
	 */
	public Integer getRoleid();

	/**
	 * 流程变量名称取得
	 * @return 流程变量名称
	 */
	public String getPidname();
	
	/**
	 * 流程变量显示名称取得
	 * @return 流程变量显示名称
	 */
	public String getPidlabel();
	
	/**
	 * 流程变量描述取得
	 * @return 流程变量描述
	 */
	public String getPiddesc();
	
	/**
	 * 流程变量类型取得
	 * @return 流程变量类型
	 */
	public String getPidtype();
	

	/**
	 * 流程参与者变量权限取得
	 * @return 流程参与者变量权限
	 */
	public String getPidaccess();
	
	public String getPidrequired();
	
}
