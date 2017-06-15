/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset;

/**
 * 概述: 设备关系信息（FS-LV-VG）
 * 功能描述: 设备关系信息（FS-LV-VG）
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
public interface SOC0130Info {
	/**
	 * VG Name取得
	 * @return VG Name
	 */
	public String getVgNameLv();

	/**
	 * LV Name取得
	 * @return LV Name
	 */
	public String getLvName();
	

	/**
	 * MountPoint取得
	 * @return MountPoint
	 */
	public String getMountPoint() ;


	/**
	 * FSType取得
	 * @return FSType
	 */
	public String getFsType() ;


}
