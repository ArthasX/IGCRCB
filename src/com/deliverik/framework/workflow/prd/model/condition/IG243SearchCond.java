/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程标题定义表检索条件接口
  * 功能描述: 流程标题定义表检索条件接口
  * 创建记录: 2012/03/30
  * 修改记录: 
  */
public interface IG243SearchCond {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPtdid();


	/**
	 * 流程定义ID取得
	 *
	 * @return 流程定义ID
	 */
	public String getPdid();

	/**
	 * 主题名称定义取得
	 *
	 * @return 主题名称定义
	 */
	public String getPtitlename();


	/**
	 * 主题名称权限 0可见；1不可见取得
	 *
	 * @return 主题名称权限 0可见；1不可见
	 */
	public String getPtitleaccess();


	/**
	 * 描述字段名称取得
	 *
	 * @return 描述字段名称
	 */
	public String getPdescname();

	/**
	 * 描述字段权限 0：可见，1不可见取得
	 *
	 * @return 描述字段权限 0：可见，1不可见
	 */
	public String getPdescaccess();

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public String getPtdid_like();
}