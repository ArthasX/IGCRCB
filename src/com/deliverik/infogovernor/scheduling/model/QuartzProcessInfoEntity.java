package com.deliverik.infogovernor.scheduling.model;

import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;

/**
 * 流程与资产关系信息
 *
 */
public interface QuartzProcessInfoEntity extends BaseModel {
	
	/**
	*自增无意义主键
	*/
	public Integer getQpieid();
	
	/**
	*流程ID(QuartzProcessRecord表)
	*/
	public Integer getQprid();

	/**
	*动态表单ID（QuartzProcessInfo表）
	*/
	public Integer getQpiid();

	/**
	*资产ID(QuartzEntityItem表)
	*/
	public Integer getQeiid();
	
	/**
	 * 与流程资产信息
	 * @return
	 */
	public IG013TB getEntityItemTB();
	
	public SOC0118TB getSoc0118TB();

}
