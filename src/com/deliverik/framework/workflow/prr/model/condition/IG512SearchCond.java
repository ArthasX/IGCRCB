/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * 流程关系查询条件接口
 * 
 */
public interface IG512SearchCond {

	/**
	 * 主动流程ID取得
	 * 
	 * @return 主动流程ID
	 */
	public Integer getParprid();

	/**
	 * 被动流程ID取得
	 * 
	 * @return 被动流程ID
	 */
	public Integer getCldprid();

}
