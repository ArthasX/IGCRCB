/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.vim.model;

import org.apache.commons.lang.StringUtils;

/**
 * 概述: 虚拟机实体
 * 功能描述: 虚拟机实体
 * 创建记录:
 * 修改记录:
 */
public class VMachine {
	
	/** 虚拟机名称 */
	protected String name;
	
	/** cpu核心数*/
	protected Integer cpuCores;
	
	/** cpu主频*/
	protected Integer cpuHz;
	
	/** 内存*/
	protected String memoryMB;
	
	/** 磁盘大小*/
	protected String capacity;
	
	/** 网络标签*/
	protected String netLabels;
	
	/** 开机情况*/
	protected String powerState;
	
	/** IP地址 */
	protected String ip;
	
	/** cpu使用频率*/
	protected Integer cpuUsage;
	
	/** 内存占用大小*/
	protected Integer memoryUsage;
	
	/** 磁盘可以空间*/
	protected String freeSpace;
	
	/** 过期标识 Y:已过期 N:未过期*/
	protected String pastdueflag;
	
	/** 操作系统类型 （win:windows  lin:Linux  oth:other） */
	protected String osType;
	
	/** vcenter主键 */
    protected Integer vcid;
	
	/**
	 * 内存使用率取得
	 * @return 内存使用率
	 */
	public String getMemoryUseRate(){
		String s = "0%";
		if(StringUtils.isNotEmpty(memoryMB) && memoryUsage != null && memoryUsage > 0){
			long round = Math.round((memoryUsage * 100 / Double.parseDouble(memoryMB)));
			s = round + "%";
		}
		return s;
	}
	
	/**
	 * 硬盘使用率取得
	 * @return 硬盘使用率
	 */
	public String getDiskUseRate(){
		String s = "0%";
		if(StringUtils.isNotEmpty(capacity) && StringUtils.isNotEmpty(freeSpace)){
			long round = Math.round((Double.parseDouble(freeSpace) * 100 / Double.parseDouble(capacity)));
			s = (100 - round) + "%";
		}
		return s;
	}
	
	public String getCpuUseRate(){
		String s = "0%";
		if(cpuCores != null && cpuCores > 0 && cpuHz != null && cpuHz > 0 && cpuUsage != null && cpuUsage > 0){
			long round = Math.round((((double)(cpuUsage * 100)) /((double)(cpuCores * cpuHz))));
			s = round + "%";
		}
		return s;
	}

	/**
	 * 主机名称取得
	 * @return 主机名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 主机名称设定
	 * @param name 主机名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * cpu核心数取得
	 * @return cpuCores cpu核心数
	 */
	public Integer getCpuCores() {
		return cpuCores;
	}

	/**
	 * cpu核心数设定
	 * @param cpuCores cpu核心数
	 */
	public void setCpuCores(Integer cpuCores) {
		this.cpuCores = cpuCores;
	}

	/**
	 * cpu主频取得
	 * @return cpuHz cpu主频
	 */
	public Integer getCpuHz() {
		return cpuHz;
	}

	/**
	 * cpu主频设定
	 * @param cpuHz cpu主频
	 */
	public void setCpuHz(Integer cpuHz) {
		this.cpuHz = cpuHz;
	}

	/**
	 * 内存取得
	 * @return memoryMB 内存
	 */
	public String getMemoryMB() {
		return memoryMB;
	}

	/**
	 * 内存设定
	 * @param memoryMB 内存
	 */
	public void setMemoryMB(String memoryMB) {
		this.memoryMB = memoryMB;
	}

	/**
	 * 磁盘大小取得
	 * @return capacity 磁盘大小
	 */
	public String getCapacity() {
		return capacity;
	}

	/**
	 * 磁盘大小设定
	 * @param capacity 磁盘大小
	 */
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	/**
	 * 网络标签取得
	 * @return netLabels 网络标签
	 */
	public String getNetLabels() {
		return netLabels;
	}

	/**
	 * 网络标签设定
	 * @param netLabels 网络标签
	 */
	public void setNetLabels(String netLabels) {
		this.netLabels = netLabels;
	}

	/**
	 * 开机情况取得
	 * @return powerState 开机情况
	 */
	public String getPowerState() {
		return powerState;
	}

	/**
	 * 开机情况设定
	 * @param powerState 开机情况
	 */
	public void setPowerState(String powerState) {
		this.powerState = powerState;
	}

	/**
	 * IP地址取得
	 * @return ip IP地址
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * IP地址设定
	 * @param ip IP地址
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * cpu使用频率取得
	 * @return cpuUsage cpu使用频率
	 */
	public Integer getCpuUsage() {
		return cpuUsage;
	}

	/**
	 * cpu使用频率设定
	 * @param cpuUsage cpu使用频率
	 */
	public void setCpuUsage(Integer cpuUsage) {
		this.cpuUsage = cpuUsage;
	}

	/**
	 * 内存占用大小取得
	 * @return memoryUsage 内存占用大小
	 */
	public Integer getMemoryUsage() {
		return memoryUsage;
	}

	/**
	 * 内存占用大小设定
	 * @param memoryUsage 内存占用大小
	 */
	public void setMemoryUsage(Integer memoryUsage) {
		this.memoryUsage = memoryUsage;
	}

	/**
	 * 磁盘可以空间取得
	 * @return freeSpace 磁盘可以空间
	 */
	public String getFreeSpace() {
		return freeSpace;
	}

	/**
	 * 磁盘可以空间设定
	 * @param freeSpace 磁盘可以空间
	 */
	public void setFreeSpace(String freeSpace) {
		this.freeSpace = freeSpace;
	}

	/**
	 * 过期标识取得
	 * @return pastdueflag 过期标识
	 */
	public String getPastdueflag() {
		return pastdueflag;
	}

	/**
	 * 过期标识设定
	 * @param pastdueflag 过期标识
	 */
	public void setPastdueflag(String pastdueflag) {
		this.pastdueflag = pastdueflag;
	}

    /**
     * 获取操作系统类型（win:windowslin:Linuxoth:other）
     * @return 操作系统类型（win:windowslin:Linuxoth:other） 
     */
    public String getOsType() {
        return osType;
    }

    /**
     * 设置操作系统类型（win:windowslin:Linuxoth:other）
     * @param osType 操作系统类型（win:windowslin:Linuxoth:other）
     */
    public void setOsType(String osType) {
        this.osType = osType;
    }

    /**
     * 获取vcenter主键
     * @return vcenter主键 
     */
    public Integer getVcid() {
        return vcid;
    }

    /**
     * 设置vcenter主键
     * @param vcid vcenter主键
     */
    public void setVcid(Integer vcid) {
        this.vcid = vcid;
    }
	
	
}
