/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow;

/**
 * 流程处理参数接口
 * 
 */
public interface WorkFlowParameterInfo {
	
	/**
	 * 资产ID取得
	 * 
	 * @return 资产ID
	 */
	public Integer getEiid();

	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid();

	/**
	 * 流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPrid();

	/**
	 * 扩展参数值（可用#号连接多个值）取得
	 * 
	 * @return 扩展参数值
	 */
	public String getParameters();
	
	/**
     * 主流程ID取得
     * 
     * @return 主流程ID
     */
	public Integer getParprid();
	
	public String getPruserid();
}
