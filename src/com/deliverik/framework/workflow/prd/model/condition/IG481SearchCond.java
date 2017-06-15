/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程组成员表检索条件接口
  * 功能描述: 流程组成员表检索条件接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG481SearchCond {
	
	/**
	 * 流程组id取得
	 *
	 * @return 流程组id
	 */
	public String getPgdid();

	/**
	 * 发起方式取得
	 *
	 * @return 发起方式
	 */
	public String getCreateType();
	
	public String getPdid();
	
	public String[] getPdids_in();
	/**
	 * @param 取得 单一流程定义ID模糊查询 the pdid_like 
	 */
	public String getPdid_like();

}