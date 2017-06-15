/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset.model.condition;

/**
 * 概述: 设备关系信息条件接口（FS-LV-VG）
 * 功能描述: 设备关系信息条件接口（FS-LV-VG）
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
public interface FsLvVgSearchCond {
	/**
	 * 源资产ID取得
	 * @return 源资产ID
	 */
	public String getSrpareiid_eq();


	/**
	 * DomainID取得
	 * @return DomainID
	 */
	public String getSrdomainid_eq();


	/**
	 * Domain版本取得
	 * @return Domain版本
	 */
	public String getSrdomainversion_eq();


	/**
	 * 源资产大版本取得
	 * @return 源资产大版本
	 */
	public String getSrparversion_eq();


	/**
	 * 源资产小版本取得
	 * @return 源资产小版本
	 */
	public String getSrparsmallversion_eq();

	/**
	 * 创建时间取得
	 * @return 创建时间
	 */
	public String getSrcreatetime_eq();
	

}
