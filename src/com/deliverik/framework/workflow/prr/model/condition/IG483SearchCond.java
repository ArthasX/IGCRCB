/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 流程组实例表检索条件接口
  * 功能描述: 流程组实例表检索条件接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG483SearchCond {

	/**
	 * 流程组发起人名称取得
	 *
	 * @return 流程组发起人名称
	 */
	public String getPgrusername_like();

	/**
	 * 流程组发起时间开始取得
	 * @return 流程组发起时间开始
	 */
	public String getPgropentime_begin();

	/**
	 * 流程组发起时间结束取得
	 * @return 流程组发起时间结束
	 */
	public String getPgropentime_end();

	/**
	 * 流程组序列号取得
	 *
	 * @return 流程组序列号
	 */
	public String getPgrserialnum_like();

	/**
	 * 流程组标题取得
	 *
	 * @return 流程组标题
	 */
	public String getPgrtitle_like();
	
	/**
	 * 流程模版类型取得
	 * 
	 * @return 流程模版类型
	 */
	public String getPttype();

	/**
	 * 排序标识取得
	 * @return order 排序标识
	 */
	public String getOrder();

	/**
	 * 排序字段取得
	 * @return sing 排序字段
	 */
	public String getSing();
	
	/**
	 * 是否测试数据设定
	 * @return 是否测试数据
	 */
	public String getIstest();

	/**
	 * 流程组定义id取得
	 *
	 * @return 流程组定义id
	 */
	public String getPgdid();

	/**
	 * 流程组是否关闭取得
	 * @return 流程组是否关闭
	 */
	public boolean isActive();

}