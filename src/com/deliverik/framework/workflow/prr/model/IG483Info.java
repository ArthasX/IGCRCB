/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 流程组实例表接口
  * 功能描述: 流程组实例表接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG483Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPgrid();

	/**
	 * 流程组发起人id取得
	 *
	 * @return 流程组发起人id
	 */
	public String getPgruserid();

	/**
	 * 流程组发起人名称取得
	 *
	 * @return 流程组发起人名称
	 */
	public String getPgrusername();

	/**
	 * 流程组发起时间取得
	 *
	 * @return 流程组发起时间
	 */
	public String getPgropentime();

	/**
	 * 流程组关闭时间取得
	 *
	 * @return 流程组关闭时间
	 */
	public String getPgrclosetime();

	/**
	 * 发起流程数量取得
	 *
	 * @return 发起流程数量
	 */
	public Integer getOcount();

	/**
	 * 关闭流程数量取得
	 *
	 * @return 关闭流程数量
	 */
	public Integer getCcount();

	/**
	 * 流程组序列号取得
	 *
	 * @return 流程组序列号
	 */
	public String getPgrserialnum();

	/**
	 * 流程组标题取得
	 *
	 * @return 流程组标题
	 */
	public String getPgrtitle();

	/**
	 * 流程组发起人机构码取得
	 *
	 * @return 流程组发起人机构码
	 */
	public String getPgrorgid();

	/**
	 * 流程组发起人机构名称取得
	 *
	 * @return 流程组发起人机构名称
	 */
	public String getPgrorgname();

	/**
	 * 流程组定义id取得
	 *
	 * @return 流程组定义id
	 */
	public String getPgdid();

	/**
	 * 流程组定义名称取得
	 *
	 * @return 流程组定义名称
	 */
	public String getPgdname();
	
	/**
	 * 流程模版类型取得
	 * 
	 * @return 流程模版类型
	 */
	public String getPttype();
	
	/**
	 * 是否测试数据设定
	 * @return 是否测试数据
	 */
	public String getIstest();

}