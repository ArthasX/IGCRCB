/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.vim.model;

import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * ����: ����ʵ��
 * ��������: ����ʵ��
 * ������¼:
 * �޸ļ�¼:
 */
public class Host {
	
	/** �������� */
	protected String name;
	
	/** cpu������*/
	protected Integer cpuCores;
	
	/** cpu��Ƶ*/
	protected Integer cpuHz;
	
	/** cpuʹ��Ƶ��*/
	protected Integer cpuUsage;
	
	/** �ڴ�*/
	protected String memoryMB;
	
	/** �ڴ�ռ�ô�С*/
	protected Integer memoryUsage;
	
	/** ���̴�С*/
	protected String capacity;
	
	/** ���̿��Կռ�*/
	protected String freeSpace;
	
	/** ����б�*/
	protected List<VMachine> vmsList;
	
	/** ���������*/
	protected Integer vm_powereOn_num;
	
	/** ����ػ���*/
	protected Integer vm_powereOff_num;
	
	/** �������*/
	protected Integer vm_num;
	
	/** ����״��*/
	protected String connectionState;
	
	/** Host״̬:poweredOn:���� poweredOff �ػ� */
	protected String powerState;
	
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
	 * @return name ��������
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
	 * �ڴ�ȡ��
	 * @return memoryMB �ڴ�
	 */
	public String getMemoryMB() {
		return memoryMB;
	}
	
	/**
	 * �ڴ�ȡ��
	 * @return
	 */
	public String getMemoryGB(){
		return String.format("%.1f", StringUtils.isEmpty(this.memoryMB) ? 0.0 : Double.parseDouble(this.memoryMB) / 1024.0);
	}

	/**
	 * �ڴ��趨
	 * @param memoryMB �ڴ�
	 */
	public void setMemoryMB(String memoryMB) {
		this.memoryMB = memoryMB;
	}

	/**
	 * �ڴ�ռ�ô�Сȡ��
	 * @return memoryUsage �ڴ�ռ�ô�С
	 */
	public Integer getMemoryUsage() {
		return memoryUsage;
	}
	
	/**
	 * �ڴ�ռ�ô�Сȡ��
	 */
	public String getMemoryUsageGB(){
		return String.format("%.1f", this.memoryUsage == null ? 0.0 : this.memoryUsage / 1024.0);
	}

	/**
	 * �ڴ�ռ�ô�С�趨
	 * @param memoryUsage �ڴ�ռ�ô�С
	 */
	public void setMemoryUsage(Integer memoryUsage) {
		this.memoryUsage = memoryUsage;
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
	 * ����б�ȡ��
	 * @return vmsList ����б�
	 */
	public List<VMachine> getVmsList() {
		return vmsList;
	}

	/**
	 * ����б��趨
	 * @param vmsList ����б�
	 */
	public void setVmsList(List<VMachine> vmsList) {
		this.vmsList = vmsList;
	}

	/**
	 * ���������ȡ��
	 * @return vm_powereOn_num ���������
	 */
	public Integer getVm_powereOn_num() {
		return vm_powereOn_num;
	}

	/**
	 * ����������趨
	 * @param vm_powereOn_num ���������
	 */
	public void setVm_powereOn_num(Integer vm_powereOn_num) {
		this.vm_powereOn_num = vm_powereOn_num;
	}

	/**
	 * ����ػ���ȡ��
	 * @return vm_powereOff_num ����ػ���
	 */
	public Integer getVm_powereOff_num() {
		return vm_powereOff_num;
	}

	/**
	 * ����ػ����趨
	 * @param vm_powereOff_num ����ػ���
	 */
	public void setVm_powereOff_num(Integer vm_powereOff_num) {
		this.vm_powereOff_num = vm_powereOff_num;
	}

	/**
	 * �������ȡ��
	 * @return vm_num �������
	 */
	public Integer getVm_num() {
		return vm_num;
	}

	/**
	 * ��������趨
	 * @param vm_num �������
	 */
	public void setVm_num(Integer vm_num) {
		this.vm_num = vm_num;
	}

	/**
	 * ����״��ȡ��
	 * @return connectionState ����״��
	 */
	public String getConnectionState() {
		return connectionState;
	}

	/**
	 * ����״���趨
	 * @param connectionState ����״��
	 */
	public void setConnectionState(String connectionState) {
		this.connectionState = connectionState;
	}

	/**
	 * Host״̬ȡ��
	 * @return powerState Host״̬
	 */
	public String getPowerState() {
		return powerState;
	}

	/**
	 * Host״̬�趨
	 * @param powerState Host״̬
	 */
	public void setPowerState(String powerState) {
		this.powerState = powerState;
	}
}
