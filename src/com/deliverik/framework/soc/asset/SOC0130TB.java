/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * ����: �豸��ϵ��Ϣ��FS-LV-VG��
 * ��������: �豸��ϵ��Ϣ��FS-LV-VG��
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0130PK.class)
public class SOC0130TB implements Serializable,Cloneable,SOC0130Info{
	
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
