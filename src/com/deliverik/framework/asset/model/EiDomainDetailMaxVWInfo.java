/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset.model;

import com.deliverik.framework.asset.model.entity.EiDomainDefTB;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BaseModel;

/**
 * 概述: 资产域明细表接口
 * 功能描述: 资产域明细表接口
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public interface EiDomainDetailMaxVWInfo extends BaseModel {

	/**
	 * 资产域ID取得
	 *
	 * @return 资产域ID
	 */
	public Integer getEiddid();

	/**
	 * 资产域版本取得
	 *
	 * @return 资产域版本
	 */
	public Integer getEiddversion();

	/**
	 * 资产名称取得
	 *
	 * @return 资产ID
	 */
	public  String getEiname();

	/**
	 * 资产导入版本取得
	 *
	 * @return 资产导入版本
	 */
	public Integer getEiImportversion();
	
	/**
	 * 逻辑删除标识取得
	 *
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag();
	
	/** 创建时间 */
	public String getCreatetime();
	
//	/**
//	 * 域信息取得
//	 * @return 域信息
//	 */
//	public EiDomainDefVW getEiDomainDefVW();
	/**
	 * 域信息取得
	 * @return 域信息
	 */
	public EiDomainDefTB getEiDomainDefTB();
	
	public Integer getEiid();
	
	public IG013TB getEntityItemTB();
	/**链路数量*/
	public Integer getEircount();
	/**所属数量*/
	public Integer getBelongcount();
}
