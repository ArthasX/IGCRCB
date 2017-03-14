/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model;


/**
 * 流程缺省变量权限
 * 
 */
public interface IG909Info {
	
	/**
	 * 流程缺省变量权限ID取得
	 * @return 流程缺省变量权限ID
	 */
	public String getPdvid();
	
	/**
	 * 流程变量ID取得
	 * @return 流程变量ID
	 */
	public String getPidid();
	
	/**
	 * 流程变量显示名称取得
	 * @return 流程变量显示名称
	 */
	public String getPidlabel();
	
	/**
	 * 流程缺省变量权限取得
	 * @return 流程缺省变量权限
	 */
	public String getPidaccess();
	
	/**
	 * 表单信息的模式取得
	 *
	 * @return 表单信息的模式
	 */
	public String getPidmode();
	
	/**
	 * 类型取得
	 * 
	 * @return 类型
	 */
	public String getType();
	
	public String getPidrequired();
}
