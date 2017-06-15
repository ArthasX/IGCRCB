/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.parameter;

/**
 * 公有表单信息
 */
public interface PublicProcessInfoValueInfo {
	
	/**
	 * 表单名称取得
	 * 
	 * @return 表单名称
	 */
	public String getFormname();

	/**
	 * 表单值取得
	 * 
	 * @return 表单值
	 */
	public String getFormvalue();
	
	/**
	 * 日志参数信息取得
	 * 
	 * @return 日志参数信息
	 */
	public WorkFlowLogInfo getLogInfo();

}
