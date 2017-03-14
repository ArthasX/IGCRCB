/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.vim.model;

/**
 * 概述: 模版实体
 * 功能描述: 模版实体
 * 创建记录:
 * 修改记录:
 */
public class Template {
	
	/** vCenter配置表ID */
	protected Integer vcid;

	/** vCenter配置表显示名称 */
	protected String vcname;
	
	/** 模版名称 */
	protected String name;
	
	/** CPU个数 */
	protected Integer numCPU;
	
	/** 内存大小(G) */
	protected Integer memoryGB;
	
	/** 硬盘大小(G) */
	protected Integer diskGB;
	
	/** 网络标签 */
	protected String netName;

	/**
	 * vCenter配置表ID取得
	 * @return vCenter配置表ID
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vCenter配置表ID设定
	 * @param vcid vCenter配置表ID
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * vCenter配置表显示名称取得
	 * 
	 * @return vCenter配置表显示名称
	 */
	public String getVcname() {
		return vcname;
	}

	/**
	 * vCenter配置表显示名称设定
	 * 
	 * @param vcname vCenter配置表显示名称
	 */
	public void setVcname(String vcname) {
		this.vcname = vcname;
	}

	/**
	 * 模版名称取得
	 * 
	 * @return 模版名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 模版名称设定
	 * 
	 * @param name 模版名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * CPU个数取得
	 * @return CPU个数
	 */
	public Integer getNumCPU() {
		return numCPU;
	}

	/**
	 * CPU个数设定
	 * @param numCPU CPU个数
	 */
	public void setNumCPU(Integer numCPU) {
		this.numCPU = numCPU;
	}

	/**
	 * 内存大小(G)取得
	 * @return 内存大小(G)
	 */
	public Integer getMemoryGB() {
		return memoryGB;
	}

	/**
	 * 内存大小(G)设定
	 * @param memoryGB 内存大小(G)
	 */
	public void setMemoryGB(Integer memoryGB) {
		this.memoryGB = memoryGB;
	}

	/**
	 * 硬盘大小(G)取得
	 * @return 硬盘大小(G)
	 */
	public Integer getDiskGB() {
		return diskGB;
	}

	/**
	 * 硬盘大小(G)设定
	 * @param diskGB 硬盘大小(G)
	 */
	public void setDiskGB(Integer diskGB) {
		this.diskGB = diskGB;
	}

	/**
	 * 网络标签取得
	 * @return 网络标签
	 */
	public String getNetName() {
		return netName;
	}

	/**
	 * 网络标签设定
	 * @param netName 网络标签
	 */
	public void setNetName(String netName) {
		this.netName = netName;
	}
	
}
