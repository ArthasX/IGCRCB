/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


/**
 * ����: �豸��ϵ��Ϣ(VG-PV-Meta)
 * ��������: �豸��ϵ��ϢVO(VG-PV-Meta)
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
@Entity
@IdClass(VgPvMetaPK.class)
public class VgPvMetaTB implements Serializable,Cloneable,VgPvMetaInfo{
	
	/**VG_Name*/
	@Id
	protected String vgName;
	
	/**PseudoName*/
	@Id
	protected String pseudoName;
	
	/**IOPaths*/
	@Id
	protected String ioPaths;
	
	/**HBAPath*/
	@Id
	protected String hbaPath;
	
	/**SymmSn*/
	@Id
	protected String symmSn;
	
	/**SymFaPort*/
	@Id
	protected String symFaPort;
	
	/**SymLogicalDevice*/
	@Id
	protected String symLogicalDevice;

	/**
	 * VG_Nameȡ��
	 * @return VG_Name
	 */
	public String getVgName() {
		return vgName;
	}


	/**
	 * VG_Name�趨
	 * @param name VG_Name
	 */
	public void setVgName(String vgName) {
		this.vgName = vgName;
	}
	
	
	/**
	 * PseudoNameȡ��
	 * @return PseudoName
	 */
	public String getPseudoName() {
		return pseudoName;
	}

	/**
	 * PseudoName�趨
	 * @param pseudoName
	 */
	public void setPseudoName(String pseudoName) {
		this.pseudoName = pseudoName;
	}

	/**
	 * IOPathsȡ��
	 * @return IOPaths
	 */ 
	public String getIoPaths() {
		return ioPaths;
	}
	
	/**
	 * IOPaths�趨
	 * @param paths IOPaths
	 */
	public void setIoPaths(String ioPaths) {
		this.ioPaths = ioPaths;
	}
	
	/**
	 * HBAPathȡ��
	 * @return HBAPath
	 */
	public String getHbaPath() {
		return hbaPath;
	}
	

	/**
	 * HBAPath�趨
	 * @param path HBAPath
	 */
	
	public void setHbaPath(String hbaPath) {
		this.hbaPath = hbaPath;
	}
	
	/**
	 * SymmSnȡ��
	 * @return SymmSn
	 */
	public String getSymmSn() {
		return symmSn;
	}

	/**
	 * SymmSn�趨
	 * @param symmSn
	 */
	public void setSymmSn(String symmSn) {
		this.symmSn = symmSn;
	}
	
	/**
	 * SymFaPortȡ��
	 * @return SymFaPort
	 */
	public String getSymFaPort() {
		return symFaPort;
	}

	/**
	 * SymFaPort�趨
	 * @param symFaPort
	 */
	public void setSymFaPort(String symFaPort) {
		this.symFaPort = symFaPort;
	}
	/**
	 * SymLogicalDeviceȡ��
	 * @return SymLogicalDevice
	 */


	public String getSymLogicalDevice() {
		return symLogicalDevice;
	}
	
	/**
	 * SymLogicalDevice�趨
	 * @param symLogicalDevice
	 */
	public void setSymLogicalDevice(String symLogicalDevice) {
		this.symLogicalDevice = symLogicalDevice;
	}
	

}
