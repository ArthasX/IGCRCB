/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.dbm.dto;

import com.deliverik.framework.base.BaseDTO;

public class IGDBM10DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ����ҵ��ʵʱ����
	 */
	protected String channelsBusinessRealtime;
	
	/**
	 * db2��Ϣ����
	 */
	protected String db2Information;
	
	/**
	 * ���������HCAMP״ֵ̬
	 */
	protected String backupAndHCAMPType;
	
	/**
	 * cpuռ����TOP5ֵ
	 */
	protected String cpuOccupancyrateTOP5;
	
	/**
	 * ���������HCAMP״ֵ̬ѡ��
	 */
	protected String hostid;
	
	/**
	 * Omnibus�¼�����ֵ
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