package com.deliverik.framework.asset.model;

import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 资产信息视图
 * 
 */
public interface IG688Info {

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
	 * 资产模型名称取得
	 * @return 资产模型名称
	 */
	public String getEname();
	
	/**
	 * 资产模型编号取得
	 * @return 资产模型编号
	 */
	public String getElabel();

	/**
	 * 资产模型说明取得
	 * @return 资产模型说明
	 */
	public String getEdesc();

	/**
	 * 资产模型状态取得
	 * @return 资产模型状态
	 */
	public String getEstatus();

	/**
	 * 资产模型分类取得
	 * @return 资产模型分类
	 */
	public String getEcategory();

	/**
	 * 资产模型一级子类取得
	 * @return 资产模型一级子类
	 */
	public String getEkey1();

	/**
	 * 资产模型二级子类取得
	 * @return 资产模型二级子类
	 */
	public String getEkey2();

	/**
	 * 资产模型三级子类取得
	 * @return 资产模型三级子类
	 */
	public String getEkey3();

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
	 * 资产已建立关系总数取得
	 * @return 资产已建立关系总数
	 */
	public String getEircount();
	
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
	 * 资产所属机构信息实体取得
	 * @return 资产所属机构信息实体
	 */
	public OrganizationTB getOrganizationTB();
	/**
	 * 资产序号取得
	 * @return 资产序号
	 */
	public String getSerial();
	/**
	 * 资产购买日期取得
	 * @return 资产购买日期
	 */
	public String getBuytime();
	
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
	 * 资产模型类别取得
	 * @return 资产模型类别
	 */
	public String getEmodeltype();
	
}