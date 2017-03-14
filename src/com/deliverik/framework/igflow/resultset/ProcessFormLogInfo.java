/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 处理表单日志信息
 */
public interface ProcessFormLogInfo {

	/**
	 * 表单定义ID取得
	 * @return 表单定义ID
	 */
	public String getPidid();

	/**
	 * 表单名称取得
	 * @return 表单名称
	 */
	public String getName();

	/**
	 * 表单值取得
	 * @return 表单值
	 */
	public String getValue();
	
}
