/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.vim.model;

import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 概述: 主机实体
 * 功能描述: 主机实体
 * 创建记录:
 * 修改记录:
 */
public class Host {
	
	/** 主机名称 */
	protected String name;
	
	/** cpu核心数*/
	protected Integer cpuCores;
	
	/** cpu主频*/
	protected Integer cpuHz;
	
	/** cpu使用频率*/
	protected Integer cpuUsage;
	
	/** 内存*/
	protected String memoryMB;
	
	/** 内存占用大小*/
	protected Integer memoryUsage;
	
	/** 磁盘大小*/
	protected String capacity;
	
	/** 磁盘可以空间*/
	protected String freeSpace;
	
	/** 虚机列表*/
	protected List<VMachine> vmsList;
	
	/** 虚机开机数*/
	protected Integer vm_powereOn_num;
	
	/** 虚机关机数*/
	protected Integer vm_powereOff_num;
	
	/** 虚机总数*/
	protected Integer vm_num;
	
	/** 连接状况*/
	protected String connectionState;
	
	/** Host状态:poweredOn:开机 poweredOff 关机 */
	protected String powerState;
	
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
	 * @return name 主机名称
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
	 * 内存取得
	 * @return memoryMB 内存
	 */
	public String getMemoryMB() {
		return memoryMB;
	}
	
	/**
	 * 内存取得
	 * @return
	 */
	public String getMemoryGB(){
		return String.format("%.1f", StringUtils.isEmpty(this.memoryMB) ? 0.0 : Double.parseDouble(this.memoryMB) / 1024.0);
	}

	/**
	 * 内存设定
	 * @param memoryMB 内存
	 */
	public void setMemoryMB(String memoryMB) {
		this.memoryMB = memoryMB;
	}

	/**
	 * 内存占用大小取得
	 * @return memoryUsage 内存占用大小
	 */
	public Integer getMemoryUsage() {
		return memoryUsage;
	}
	
	/**
	 * 内存占用大小取得
	 */
	public String getMemoryUsageGB(){
		return String.format("%.1f", this.memoryUsage == null ? 0.0 : this.memoryUsage / 1024.0);
	}

	/**
	 * 内存占用大小设定
	 * @param memoryUsage 内存占用大小
	 */
	public void setMemoryUsage(Integer memoryUsage) {
		this.memoryUsage = memoryUsage;
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
	 * 虚机列表取得
	 * @return vmsList 虚机列表
	 */
	public List<VMachine> getVmsList() {
		return vmsList;
	}

	/**
	 * 虚机列表设定
	 * @param vmsList 虚机列表
	 */
	public void setVmsList(List<VMachine> vmsList) {
		this.vmsList = vmsList;
	}

	/**
	 * 虚机开机数取得
	 * @return vm_powereOn_num 虚机开机数
	 */
	public Integer getVm_powereOn_num() {
		return vm_powereOn_num;
	}

	/**
	 * 虚机开机数设定
	 * @param vm_powereOn_num 虚机开机数
	 */
	public void setVm_powereOn_num(Integer vm_powereOn_num) {
		this.vm_powereOn_num = vm_powereOn_num;
	}

	/**
	 * 虚机关机数取得
	 * @return vm_powereOff_num 虚机关机数
	 */
	public Integer getVm_powereOff_num() {
		return vm_powereOff_num;
	}

	/**
	 * 虚机关机数设定
	 * @param vm_powereOff_num 虚机关机数
	 */
	public void setVm_powereOff_num(Integer vm_powereOff_num) {
		this.vm_powereOff_num = vm_powereOff_num;
	}

	/**
	 * 虚机总数取得
	 * @return vm_num 虚机总数
	 */
	public Integer getVm_num() {
		return vm_num;
	}

	/**
	 * 虚机总数设定
	 * @param vm_num 虚机总数
	 */
	public void setVm_num(Integer vm_num) {
		this.vm_num = vm_num;
	}

	/**
	 * 连接状况取得
	 * @return connectionState 连接状况
	 */
	public String getConnectionState() {
		return connectionState;
	}

	/**
	 * 连接状况设定
	 * @param connectionState 连接状况
	 */
	public void setConnectionState(String connectionState) {
		this.connectionState = connectionState;
	}

	/**
	 * Host状态取得
	 * @return powerState Host状态
	 */
	public String getPowerState() {
		return powerState;
	}

	/**
	 * Host状态设定
	 * @param powerState Host状态
	 */
	public void setPowerState(String powerState) {
		this.powerState = powerState;
	}
}
