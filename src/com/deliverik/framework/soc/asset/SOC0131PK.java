/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset;

import java.io.Serializable;


import com.deliverik.framework.base.BasePK;

/**
 * 概述: 设备关系信息(VG-PV-Meta)
 * 功能描述: 设备关系信息VO(VG-PV-Meta)
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class SOC0131PK extends BasePK implements Serializable {
	/**VG_Name*/
	protected String vgName;
	
	/**PseudoName*/
	protected String pseudoName;
	
	/**IOPaths*/
	protected String ioPaths;
	
	/**HBAPath*/
	protected String hbaPath;
	
	/**SymmSn*/
	protected String symmSn;
	
	/**SymFaPort*/
	protected String symFaPort;
	
	/**SymLogicalDevice*/
	protected String symLogicalDevice;
	
	
	/**
	 * 构造函数
	 */
	public SOC0131PK() {
		super();
	}
	
	
	/**
	 * 
	 * 构造函数
	 * @param vgName
	 * @param pseudoName
	 * @param ioPaths
	 * @param hbaPath
	 * @param symmSn
	 * @param symFaPort
	 * @param symLogicalDevice
	 */
	public SOC0131PK(String vgName, String pseudoName, String ioPaths,
			String hbaPath, String symmSn, String symFaPort,
			String symLogicalDevice) {
		super();
		this.vgName = vgName;
		this.pseudoName = pseudoName;
		this.ioPaths = ioPaths;
		this.hbaPath = hbaPath;
		this.symmSn = symmSn;
		this.symFaPort = symFaPort;
		this.symLogicalDevice = symLogicalDevice;
	}

	public String getPseudoName() {
		return pseudoName;
	}

	public void setPseudoName(String pseudoName) {
		this.pseudoName = pseudoName;
	}

	public String getIoPaths() {
		return ioPaths;
	}

	public void setIoPaths(String ioPaths) {
		this.ioPaths = ioPaths;
	}

	public String getHbaPath() {
		return hbaPath;
	}

	public void setHbaPath(String hbaPath) {
		this.hbaPath = hbaPath;
	}

	public String getSymmSn() {
		return symmSn;
	}

	public void setSymmSn(String symmSn) {
		this.symmSn = symmSn;
	}

	public String getSymFaPort() {
		return symFaPort;
	}

	public void setSymFaPort(String symFaPort) {
		this.symFaPort = symFaPort;
	}

	public String getSymLogicalDevice() {
		return symLogicalDevice;
	}

	public void setSymLogicalDevice(String symLogicalDevice) {
		this.symLogicalDevice = symLogicalDevice;
	}

	public String getVgName() {
		return vgName;
	}

	public void setVgName(String vgName) {
		this.vgName = vgName;
	}

}
