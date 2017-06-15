package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
 * <p>
 * 资产信息
 * </p>
 */
public interface SOC0118Info  extends BaseModel {

	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public Integer getEiid();

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid();

	/**
	 * 资产名称取得
	 * @return 资产名称
	 */
	public String getEiname();
	
	/**
	 * 资产编号取得
	 * @return 资产编号
	 */
	public String getEilabel();

	/**
	 * 资产说明取得
	 * @return 资产说明
	 */
	public String getEidesc();

	/**
	 * 资产更新时间取得
	 * @return 资产更新时间
	 */
	public String getEiupdtime();

	/**
	 * 资产状态取得
	 * @return 资产状态
	 */
	public String getEistatus();

	/**
	 * 资产版本号取得
	 * @return 资产版本号
	 */
	public Integer getEiversion();


	/**
	 * 资产登记日取得
	 * @return 资产登记日
	 */
	public String getEiinsdate();
	
	/**
	 * 资产所属机构层次码取得
	 * @return 资产所属机构层次码
	 */
	public String getEiorgsyscoding();
	
	/**
	 * 资产模型层次码取得
	 * @return 资产模型层次码
	 */
	public String getEsyscoding();
	
	/**
	 * 资产管理人取得
	 * @return 资产管理人
	 */
	public String getEiuserid();
	
	/**
	 * 资产管理人姓名取得
	 * @return 资产管理人姓名
	 */
	public String getEiusername();
	
	/**
	 * 资产小版本取得
	 * @return 资产小版本
	 */
	public Integer getEismallversion();
	
	/**
	 * 资产所属树根节点实体标识取得
	 * @return 资产所属树根节点实体标识
	 */
	public Integer getEirootmark();
	
	
	public SOC0117TB getSoc0117TB();
	
}