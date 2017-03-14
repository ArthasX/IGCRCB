package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 用户资产信息
 * 
 */
public interface SOC0163Info {

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
	 * 资产更新时间取得
	 * @return 资产更新时间
	 */
	public String getEiupdtime();


	/**
	 * 资产模型名称取得
	 * @return 资产模型名称
	 */
	public String getEname();
	

	/**
	 * 资产版本号取得
	 * @return 资产版本号
	 */
	public Integer getEiversion();

	
	/**
	 * 资产所属机构取得
	 * @return 资产所属机构
	 */
	public String getEiorgsyscoding();
	/**
	 * 资产模型取得
	 * @return 资产模型
	 */
	public String getEsyscoding();
	
	/**
	 * 资产所属机构信息实体取得
	 * @return 资产所属机构信息实体
	 */
	public OrganizationTB getOrganizationTB();
	
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
	

	/**
	 * 资产ip获取
	 * @return
	 */
	public String getIp();
}