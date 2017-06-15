/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.igflow.resultset;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 表格式表单列值信息
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface TableFormColumnValueInfo {


	/**
	 * 列全路径取得
	 * @return fullName 列全路径
	 */
	public String getFullName();

	/**
	 * 行号取得
	 * @return rownumber 行号
	 */
	public String getRownumber();

	/**
	 * 列值取得
	 * @return value 列值
	 */
	public String getValue();
}
