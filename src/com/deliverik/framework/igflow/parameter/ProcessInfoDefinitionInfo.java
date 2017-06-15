/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.igflow.parameter;

/**
 * 表单定义信息
 */
public interface ProcessInfoDefinitionInfo {

	/**
	 * 表单定义主键取得
	 * @return 表单定义主键
	 */
	public String getPidid();
	
	/**
	 * 表单名称取得
	 * @return 表单名称
	 */
	public String getPidname();

	/**
	 * 父级表单定义主键取得
	 * @return 父级表单定义主键
	 */
	public String getPpidid();
}
