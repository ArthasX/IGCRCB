/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.dbm.dto;

import com.deliverik.framework.base.BaseDTO;

public class IGDBM10DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 渠道业务实时数据
	 */
	protected String channelsBusinessRealtime;
	
	/**
	 * db2信息数据
	 */
	protected String db2Information;
	
	/**
	 * 备份情况及HCAMP状态值
	 */
	protected String backupAndHCAMPType;
	
	/**
	 * cpu占用率TOP5值
	 */
	protected String cpuOccupancyrateTOP5;
	
	/**
	 * 备份情况或HCAMP状态值选择
	 */
	protected String hostid;
	
	/**
	 * Omnibus事件警告值
	 */
	protected String omnibusEventWarning;

	public String getChannelsBusinessRealtime() {
		return channelsBusinessRealtime;
	}

	public void setChannelsBusinessRealtime(String channelsBusinessRealtime) {
		this.channelsBusinessRealtime = channelsBusinessRealtime;
	}

	public String getDb2Information() {
		return db2Information;
	}

	public void setDb2Information(String db2Information) {
		this.db2Information = db2Information;
	}

	public String getBackupAndHCAMPType() {
		return backupAndHCAMPType;
	}

	public void setBackupAndHCAMPType(String backupAndHCAMPType) {
		this.backupAndHCAMPType = backupAndHCAMPType;
	}

	public String getOmnibusEventWarning() {
		return omnibusEventWarning;
	}

	public void setOmnibusEventWarning(String omnibusEventWarning) {
		this.omnibusEventWarning = omnibusEventWarning;
	}

	public String getCpuOccupancyrateTOP5() {
		return cpuOccupancyrateTOP5;
	}

	public void setCpuOccupancyrateTOP5(String cpuOccupancyrateTOP5) {
		this.cpuOccupancyrateTOP5 = cpuOccupancyrateTOP5;
	}

	public String getHostid() {
		return hostid;
	}

	public void setHostid(String hostid) {
		this.hostid = hostid;
	}
	
	
	
}