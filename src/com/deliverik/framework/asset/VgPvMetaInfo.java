/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset;

/**
 * 概述: 设备关系信息(VG-PV-Meta)
 * 功能描述: 设备关系信息(VG-PV-Meta)
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
public interface VgPvMetaInfo {

	/**
	 * VG_Name取得
	 * @return VG_Name
	 */
	public String getVgName();


	
	/**
	 * PseudoName取得
	 * @return PseudoName
	 */
	public String getPseudoName() ;


	/**
	 * IOPaths取得
	 * @return IOPaths
	 */ 
	public String getIoPaths() ;
	
	
	/**
	 * HBAPath取得
	 * @return HBAPath
	 */
	public String getHbaPath();
	

	
	/**
	 * SymmSn取得
	 * @return SymmSn
	 */
	public String getSymmSn();

	
	/**
	 * SymFaPort取得
	 * @return SymFaPort
	 */
	public String getSymFaPort();

	/**
	 * SymLogicalDevice取得
	 * @return SymLogicalDevice
	 */
	public String getSymLogicalDevice();
	
}
