/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.vcd.model;

/**
 * ����: ���ʵ��
 * ��������: ���ʵ��
 * ������¼:
 * �޸ļ�¼:
 */
public class VirtualMachine {

    /** ������� */
    protected String name;
    
    /** Ŀ¼���� */
    protected String catalogName;

    /** �洢���� */
    protected String datastoreName;

    /** �ͻ�������ϵͳ */
    protected String guestOs;

    /** Ӳ���汾 */
    protected Integer hardwareVersion;

    /** �������� */
    protected String hostName;

    /** �ڴ��С */
    protected Integer memoryMB;

    protected String moref;

    /** �������� */
    protected String networkName;

    /** CPU���� */
    protected Integer numberOfCpus;

    /** ���� */
    protected String org;

    /** ״̬ */
    protected String status;

    /**
     * ��ȡ�������
     * @return ������� 
     */
    public String getName() {
        return name;
    }

    /**
     * �����������
     * @param name �������
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ��ȡĿ¼����
     * @return Ŀ¼���� 
     */
    public String getCatalogName() {
        return catalogName;
    }

    /**
     * ����Ŀ¼����
     * @param catalogName Ŀ¼����
     */
    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    /**
     * ��ȡ�洢����
     * @return �洢���� 
     */
    public String getDatastoreName() {
        return datastoreName;
    }

    /**
     * ���ô洢����
     * @param datastoreName �洢����
     */
    public void setDatastoreName(String datastoreName) {
        this.datastoreName = datastoreName;
    }

    /**
     * ��ȡ�ͻ�������ϵͳ
     * @return �ͻ�������ϵͳ 
     */
    public String getGuestOs() {
        return guestOs;
    }

    /**
     * ���ÿͻ�������ϵͳ
     * @param guestOs �ͻ�������ϵͳ
     */
    public void setGuestOs(String guestOs) {
        this.guestOs = guestOs;
    }

    /**
     * ��ȡӲ���汾
     * @return Ӳ���汾 
     */
    public Integer getHardwareVersion() {
        return hardwareVersion;
    }

    /**
     * ����Ӳ���汾
     * @param hardwareVersion Ӳ���汾
     */
    public void setHardwareVersion(Integer hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    /**
     * ��ȡ��������
     * @return �������� 
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * ������������
     * @param hostName ��������
     */
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    /**
     * ��ȡ�ڴ��С
     * @return �ڴ��С 
     */
    public Integer getMemoryMB() {
        return memoryMB;
    }

    /**
     * �����ڴ��С
     * @param memoryMB �ڴ��С
     */
    public void setMemoryMB(Integer memoryMB) {
        this.memoryMB = memoryMB;
    }

    /**
     * ��ȡmoref
     * @return moref 
     */
    public String getMoref() {
        return moref;
    }

    /**
     * ����moref
     * @param moref moref
     */
    public void setMoref(String moref) {
        this.moref = moref;
    }

    /**
     * ��ȡ��������
     * @return �������� 
     */
    public String getNetworkName() {
        return networkName;
    }

    /**
     * ������������
     * @param networkName ��������
     */
    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    /**
     * ��ȡCPU����
     * @return CPU���� 
     */
    public Integer getNumberOfCpus() {
        return numberOfCpus;
    }

    /**
     * ����CPU����
     * @param numberOfCpus CPU����
     */
    public void setNumberOfCpus(Integer numberOfCpus) {
        this.numberOfCpus = numberOfCpus;
    }

    /**
     * ��ȡ����
     * @return ���� 
     */
    public String getOrg() {
        return org;
    }

    /**
     * ���û���
     * @param org ����
     */
    public void setOrg(String org) {
        this.org = org;
    }

    /**
     * ��ȡ״̬
     * @return ״̬ 
     */
    public String getStatus() {
        return status;
    }

    /**
     * ����״̬
     * @param status ״̬
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
