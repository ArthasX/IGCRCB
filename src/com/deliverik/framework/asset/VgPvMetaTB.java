/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


/**
 * 概述: 设备关系信息(VG-PV-Meta)
 * 功能描述: 设备关系信息VO(VG-PV-Meta)
 * 创建记录: 2011/05/13
 * 修改记录: 
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
	 * VG_Name取得
	 * @return VG_Name
	 */
	public String getVgName() {
		return vgName;
	}


	/**
	 * VG_Name设定
	 * @param name VG_Name
	 */
	public void setVgName(String vgName) {
		this.vgName = vgName;
	}
	
	
	/**
	 * PseudoName取得
	 * @return PseudoName
	 */
	public String getPseudoName() {
		return pseudoName;
	}

	/**
	 * PseudoName设定
	 * @param pseudoName
	 */
	public void setPseudoName(String pseudoName) {
		this.pseudoName = pseudoName;
	}

	/**
	 * IOPaths取得
	 * @return IOPaths
	 */ 
	public String getIoPaths() {
		return ioPaths;
	}
	
	/**
	 * IOPaths设定
	 * @param paths IOPaths
	 */
	public void setIoPaths(String ioPaths) {
		this.ioPaths = ioPaths;
	}
	
	/**
	 * HBAPath取得
	 * @return HBAPath
	 */
	public String getHbaPath() {
		return hbaPath;
	}
	

	/**
	 * HBAPath设定
	 * @param path HBAPath
	 */
	
	public void setHbaPath(String hbaPath) {
		this.hbaPath = hbaPath;
	}
	
	/**
	 * SymmSn取得
	 * @return SymmSn
	 */
	public String getSymmSn() {
		return symmSn;
	}

	/**
	 * SymmSn设定
	 * @param symmSn
	 */
	public void setSymmSn(String symmSn) {
		this.symmSn = symmSn;
	}
	
	/**
	 * SymFaPort取得
	 * @return SymFaPort
	 */
	public String getSymFaPort() {
		return symFaPort;
	}

	/**
	 * SymFaPort设定
	 * @param symFaPort
	 */
	public void setSymFaPort(String symFaPort) {
		this.symFaPort = symFaPort;
	}
	/**
	 * SymLogicalDevice取得
	 * @return SymLogicalDevice
	 */


	public String getSymLogicalDevice() {
		return symLogicalDevice;
	}
	
	/**
	 * SymLogicalDevice设定
	 * @param symLogicalDevice
	 */
	public void setSymLogicalDevice(String symLogicalDevice) {
		this.symLogicalDevice = symLogicalDevice;
	}
	

}
