/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 流程组关联关系实例表接口
  * 功能描述: 流程组关联关系实例表接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG485Info extends BaseModel {

	/**
	 * 流程组关联关系主键取得
	 *
	 * @return 流程组关联关系主键
	 */
	public String getPgreid();

	/**
	 *  流程组实例id取得
	 *
	 * @return  流程组实例id
	 */
	public Integer getPgrid();

	/**
	 * 参考流程实例ID取得
	 *
	 * @return 参考流程实例ID
	 */
	public Integer getPrid();

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getPgrrstatus();

	/**
	 * 完成时间取得
	 *
	 * @return 完成时间
	 */
	public String getPgrtime();

}