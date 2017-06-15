/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG933TB;

/**
 * 概述: 知识流程关联信息接口
 * 功能描述：知识流程关联信息接口
 * 创建记录：刘鹏    2010/12/07
 * 修改记录：
 */
public interface KnowledgeProcess extends BaseModel {
	
	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public Integer getKpid();

	/**
	 * 知识ID取得
	 * 
	 * @return 知识ID
	 */
	public Integer getKnid();

	/**
	 * 流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPrid();
	
	/**
	 * 工单ID取得
	 * 
	 * @return 工单ID
	 */
	public Integer getSfid();

	/**
	 * 关联类型取得
	 * 
	 * @return 关联类型
	 */
	public String getConnecttype();
	
	/**
	 * 是否有效标识取得
	 * 
	 * @return 是否有效标识
	 */
	public String getKpEffect();
	
	/**
	 * 知识信息取得
	 * @return 知识信息
	 */
	public Knowledge getKnowledge();

	/**
	 * 流程信息取得
	 * @return 流程信息
	 */
	public IG500Info getProcessRecord();

	/**
	 * 知识版本取得
	 * @return 知识版本
	 */
	public Integer getKnversion();
	
	/**
	 * 服务工单取得
	 * @return 服务工单
	 */
	public IG933TB getServiceForm(); 
}
