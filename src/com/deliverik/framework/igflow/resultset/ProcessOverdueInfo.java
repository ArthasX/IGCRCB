/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.igflow.resultset;

/**
 * 流程逾期未处理参与者信息
 */
public interface ProcessOverdueInfo {

	/**
	 * 参与人ID设定
	 * @return 参与人ID
	 */
	public String getUserid();

	/**
	 * 参与人姓名取得
	 * @return 参与人姓名
	 */
	public String getUsername();
	
}
