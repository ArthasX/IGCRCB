/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 概述: 知识流程关联信息检索条件接口
 * 功能描述：知识流程关联信息检索条件接口
 * 创建记录：刘鹏 2010/12/07
 * 修改记录：
 */
public interface KnowledgeProcessSearchCond {
	
	/**
	 * 知识ID取得
	 * 
	 * @return 知识ID
	 */
	public Integer getKnid();
	
	/**
	 * 知识版本取得
	 * @return 知识版本
	 */
	public Integer getKnversion();

	/**
	 * 流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPrid();
	
	/**
	 * 服务工单ID取得
	 * 
	 * @return 服务工单ID
	 */
	public Integer getSfid();

	/**
	 * 关联类型取得
	 * 
	 * @return 关联类型
	 */
	public String getConnecttype();
	
	/**
	 * 有效标识位取得
	 * @return 有效标识位
	 */
	public String getKpEffect();

}
