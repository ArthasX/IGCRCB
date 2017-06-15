/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset;

/**
 * ����: �豸��ϵ��Ϣ��FS-LV-VG��
 * ��������: �豸��ϵ��Ϣ��FS-LV-VG��
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public interface FsLvVgInfo {
	/**
	 * VG Nameȡ��
	 * @return VG Name
	 */
	public String getVgNameLv();

	/**
	 * LV Nameȡ��
	 * @return LV Name
	 */
	public String getLvName();
	

	/**
	 * MountPointȡ��
	 * @return MountPoint
	 */
	public String getMountPoint() ;


	/**
	 * FSTypeȡ��
	 * @return FSType
	 */
	public String getFsType() ;


}
