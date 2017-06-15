package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.asset.model.entity.IG688VW;
import com.deliverik.framework.base.BaseModel;

/**
 * 流程与资产关系信息
 *
 */
public interface IG731Info extends BaseModel {
	
	/**
	*自增无意义主键
	*/
	public Integer getPieid();
	
	/**
	*流程ID(Ig500表)
	*/
	public Integer getPrid();

	/**
	*动态表单ID（Ig599表）
	*/
	public Integer getPiid();

	/**
	*资产ID(EntityItem表)
	*/
	public Integer getEiid();
	
	/**
	 * 资产版本号取得
	 * @return eiversion 资产版本号
	 */
	public Integer getEiversion();
	
	/**
	 * 与流程资产信息
	 * @return
	 */
	public IG013TB getEntityItemTB();
	
	/**
	 * 资产信息视图取得
	 *
	 * @return entityItemVWTB 资产信息视图
	 */
	public IG688VW getEntityItemVWTB();

}
