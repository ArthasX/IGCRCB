/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset;

import java.io.Serializable;


import com.deliverik.framework.base.BasePK;

/**
 * ����: �豸��ϵ��Ϣ��FS-LV-VG��
 * ��������: �豸��ϵ��Ϣ��FS-LV-VG��
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class SOC0130PK extends BasePK implements Serializable {
	/**VG Name*/
	protected String vgNameLv;
	
	/**LV Name*/
	protected String lvName;
	
	/**MountPoint*/
	protected String mountPoint;
	
	/**FSType*/
	protected String fsType;
	
	/**
	 * ���캯��
	 */
	public SOC0130PK() {
		super();
	}

	/**
	 * ���캯��
	 * @param vgNameLv
	 * @param lvName
	 * @param mountPoint
	 * @param fsType
	 */
	public SOC0130PK(String vgNameLv, String lvName, String mountPoint,
			String fsType) {
		super();
		this.vgNameLv = vgNameLv;
		this.lvName = lvName;
		this.mountPoint = mountPoint;
		this.fsType = fsType;
	}

	/**
	 * VG Nameȡ��
	 * @return VG Name
	 */
	public String getVgNameLv() {
		return vgNameLv;
	}

	/**
	 * VG Name�趨
	 * @param nameVG Name
	 */
	public void setVgNameLv(String vgNameLv) {
		this.vgNameLv = vgNameLv;
	}
	/**
	 * LV Nameȡ��
	 * @return LV Name
	 */
	public String getLvName() {
		return lvName;
	}

	/**
	 * LV Name�趨
	 * @param nameLV Name
	 */
	public void setLvName(String lvName) {
		this.lvName = lvName;
	}

	/**
	 * MountPointȡ��
	 * @return MountPoint
	 */
	public String getMountPoint() {
		return mountPoint;
	}

	/**
	 * MountPoint�趨
	 * @param mountPoint
	 */
	public void setMountPoint(String mountPoint) {
		this.mountPoint = mountPoint;
	}

	/**
	 * FSTypeȡ��
	 * @return FSType
	 */
	public String getFsType() {
		return fsType;
	}

	/**
	 * FSType�趨
	 * @param type
	 */
	public void setFsType(String fsType) {
		this.fsType = fsType;
	}

}
