/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset;

import java.io.Serializable;


import com.deliverik.framework.base.BasePK;

/**
 * 概述: 设备关系信息（FS-LV-VG）
 * 功能描述: 设备关系信息（FS-LV-VG）
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class FsLvVgPK extends BasePK implements Serializable {
	/**VG Name*/
	protected String vgNameLv;
	
	/**LV Name*/
	protected String lvName;
	
	/**MountPoint*/
	protected String mountPoint;
	
	/**FSType*/
	protected String fsType;
	
	/**
	 * 构造函数
	 */
	public FsLvVgPK() {
		super();
	}

	/**
	 * 构造函数
	 * @param vgNameLv
	 * @param lvName
	 * @param mountPoint
	 * @param fsType
	 */
	public FsLvVgPK(String vgNameLv, String lvName, String mountPoint,
			String fsType) {
		super();
		this.vgNameLv = vgNameLv;
		this.lvName = lvName;
		this.mountPoint = mountPoint;
		this.fsType = fsType;
	}

	/**
	 * VG Name取得
	 * @return VG Name
	 */
	public String getVgNameLv() {
		return vgNameLv;
	}

	/**
	 * VG Name设定
	 * @param nameVG Name
	 */
	public void setVgNameLv(String vgNameLv) {
		this.vgNameLv = vgNameLv;
	}
	/**
	 * LV Name取得
	 * @return LV Name
	 */
	public String getLvName() {
		return lvName;
	}

	/**
	 * LV Name设定
	 * @param nameLV Name
	 */
	public void setLvName(String lvName) {
		this.lvName = lvName;
	}

	/**
	 * MountPoint取得
	 * @return MountPoint
	 */
	public String getMountPoint() {
		return mountPoint;
	}

	/**
	 * MountPoint设定
	 * @param mountPoint
	 */
	public void setMountPoint(String mountPoint) {
		this.mountPoint = mountPoint;
	}

	/**
	 * FSType取得
	 * @return FSType
	 */
	public String getFsType() {
		return fsType;
	}

	/**
	 * FSType设定
	 * @param type
	 */
	public void setFsType(String fsType) {
		this.fsType = fsType;
	}

}
