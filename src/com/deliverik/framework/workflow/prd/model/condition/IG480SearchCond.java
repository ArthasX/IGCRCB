/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程组定义表检索条件接口
  * 功能描述: 流程组定义表检索条件接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG480SearchCond {
	/**
	 * 流程组定义ID取得
	 * @return 流程组定义ID
	 */
	public String getPgdid_like();

	/**
	 * 描述 (like)
	 * @return
	 */
	public String getPgddesc();
	/**
	 * 流程组定义名称
	 * @return
	 */
	public String getPgdname_like();
	/**
	 * 流程组状态
	 * @return
	 */
	public String getPgdstatus();
	/**
	 * 流程组模板类型
	 * @return
	 */
	public Integer getPtid();
	
}