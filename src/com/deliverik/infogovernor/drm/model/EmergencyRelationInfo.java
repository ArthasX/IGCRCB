/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 流程关系实体接口
 *
 */
public interface EmergencyRelationInfo extends BaseModel {
	
	/**
	 * 流程关系ID取得
	 * 
	 * @return 流程关系ID
	 */
	public Integer getErid();

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
	

	/**
	 * 关系建立时间取得
	 * 
	 * @return 关系建立时间
	 */
	public String getPrrinstime();
	/**应急处置流程类型(1:单一场景else组合场景)*/
	public String getCldType();
	
	/** 关系类型  0：演练-场景   1 应急指挥-场景  2 演练-应急指挥 */
	public String getRelatetype();
	

}