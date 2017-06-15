/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.vim.model;

import org.apache.commons.lang.StringUtils;

/**
 * ����: �����ʵ��
 * ��������: �����ʵ��
 * ������¼:
 * �޸ļ�¼:
 */
public class VMachine {
	
	/** ��������� */
	protected String name;
	
	/** cpu������*/
	protected Integer cpuCores;
	
	/** cpu��Ƶ*/
	protected Integer cpuHz;
	
	/** �ڴ�*/
	protected String memoryMB;
	
	/** ���̴�С*/
	protected String capacity;
	
	/** �����ǩ*/
	protected String netLabels;
	
	/** �������*/
	protected String powerState;
	
	/** IP��ַ */
	protected String ip;
	
	/** cpuʹ��Ƶ��*/
	protected Integer cpuUsage;
	
	/** �ڴ�ռ�ô�С*/
	protected Integer memoryUsage;
	
	/** ���̿��Կռ�*/
	protected String freeSpace;
	
	/** ���ڱ�ʶ Y:�ѹ��� N:δ����*/
	protected String pastdueflag;
	
	/** ����ϵͳ���� ��win:windows  lin:Linux  oth:other�� */
	protected String osType;
	
	/** vcenter���� */
    protected Integer vcid;
	
	/**
	 * �ڴ�ʹ����ȡ��
	 * @return �ڴ�ʹ����
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
	 * Ӳ��ʹ����ȡ��
	 * @return Ӳ��ʹ����
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
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getName() {
		return name;
	}

	/**
	 * ���������趨
	 * @param name ��������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * cpu������ȡ��
	 * @return cpuCores cpu������
	 */
	public Integer getCpuCores() {
		return cpuCores;
	}

	/**
	 * cpu�������趨
	 * @param cpuCores cpu������
	 */
	public void setCpuCores(Integer cpuCores) {
		this.cpuCores = cpuCores;
	}

	/**
	 * cpu��Ƶȡ��
	 * @return cpuHz cpu��Ƶ
	 */
	public Integer getCpuHz() {
		return cpuHz;
	}

	/**
	 * cpu��Ƶ�趨
	 * @param cpuHz cpu��Ƶ
	 */
	public void setCpuHz(Integer cpuHz) {
		this.cpuHz = cpuHz;
	}

	/**
	 * �ڴ�ȡ��
	 * @return memoryMB �ڴ�
	 */
	public String getMemoryMB() {
		return memoryMB;
	}

	/**
	 * �ڴ��趨
	 * @param memoryMB �ڴ�
	 */
	public void setMemoryMB(String memoryMB) {
		this.memoryMB = memoryMB;
	}

	/**
	 * ���̴�Сȡ��
	 * @return capacity ���̴�С
	 */
	public String getCapacity() {
		return capacity;
	}

	/**
	 * ���̴�С�趨
	 * @param capacity ���̴�С
	 */
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	/**
	 * �����ǩȡ��
	 * @return netLabels �����ǩ
	 */
	public String getNetLabels() {
		return netLabels;
	}

	/**
	 * �����ǩ�趨
	 * @param netLabels �����ǩ
	 */
	public void setNetLabels(String netLabels) {
		this.netLabels = netLabels;
	}

	/**
	 * �������ȡ��
	 * @return powerState �������
	 */
	public String getPowerState() {
		return powerState;
	}

	/**
	 * ��������趨
	 * @param powerState �������
	 */
	public void setPowerState(String powerState) {
		this.powerState = powerState;
	}

	/**
	 * IP��ַȡ��
	 * @return ip IP��ַ
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * IP��ַ�趨
	 * @param ip IP��ַ
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * cpuʹ��Ƶ��ȡ��
	 * @return cpuUsage cpuʹ��Ƶ��
	 */
	public Integer getCpuUsage() {
		return cpuUsage;
	}

	/**
	 * cpuʹ��Ƶ���趨
	 * @param cpuUsage cpuʹ��Ƶ��
	 */
	public void setCpuUsage(Integer cpuUsage) {
		this.cpuUsage = cpuUsage;
	}

	/**
	 * �ڴ�ռ�ô�Сȡ��
	 * @return memoryUsage �ڴ�ռ�ô�С
	 */
	public Integer getMemoryUsage() {
		return memoryUsage;
	}

	/**
	 * �ڴ�ռ�ô�С�趨
	 * @param memoryUsage �ڴ�ռ�ô�С
	 */
	public void setMemoryUsage(Integer memoryUsage) {
		this.memoryUsage = memoryUsage;
	}

	/**
	 * ���̿��Կռ�ȡ��
	 * @return freeSpace ���̿��Կռ�
	 */
	public String getFreeSpace() {
		return freeSpace;
	}

	/**
	 * ���̿��Կռ��趨
	 * @param freeSpace ���̿��Կռ�
	 */
	public void setFreeSpace(String freeSpace) {
		this.freeSpace = freeSpace;
	}

	/**
	 * ���ڱ�ʶȡ��
	 * @return pastdueflag ���ڱ�ʶ
	 */
	public String getPastdueflag() {
		return pastdueflag;
	}

	/**
	 * ���ڱ�ʶ�趨
	 * @param pastdueflag ���ڱ�ʶ
	 */
	public void setPastdueflag(String pastdueflag) {
		this.pastdueflag = pastdueflag;
	}

    /**
     * ��ȡ����ϵͳ���ͣ�win:windowslin:Linuxoth:other��
     * @return ����ϵͳ���ͣ�win:windowslin:Linuxoth:other�� 
     */
    public String getOsType() {
        return osType;
    }

    /**
     * ���ò���ϵͳ���ͣ�win:windowslin:Linuxoth:other��
     * @param osType ����ϵͳ���ͣ�win:windowslin:Linuxoth:other��
     */
    public void setOsType(String osType) {
        this.osType = osType;
    }

    /**
     * ��ȡvcenter����
     * @return vcenter���� 
     */
    public Integer getVcid() {
        return vcid;
    }

    /**
     * ����vcenter����
     * @param vcid vcenter����
     */
    public void setVcid(Integer vcid) {
        this.vcid = vcid;
    }
	
	
}
