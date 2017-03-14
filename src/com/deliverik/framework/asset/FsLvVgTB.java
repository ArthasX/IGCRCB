/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * 概述: 设备关系信息（FS-LV-VG）
 * 功能描述: 设备关系信息（FS-LV-VG）
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
@SuppressWarnings("serial")
@Entity
@IdClass(FsLvVgPK.class)
public class FsLvVgTB implements Serializable,Cloneable,FsLvVgInfo{
	
	/**VG Name*/
	@Id
	protected String vgNameLv;
	
	/**LV Name*/
	@Id
	protected String lvName;
	
	/**MountPoint*/
	@Id
	protected String mountPoint;
	
	/**FSType*/
	@Id
	protected String fsType;
	
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
