/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.vcd.model;

/**
 * 概述: 虚机实体
 * 功能描述: 虚机实体
 * 创建记录:
 * 修改记录:
 */
public class VirtualMachine {

    /** 虚机名称 */
    protected String name;
    
    /** 目录名称 */
    protected String catalogName;

    /** 存储名称 */
    protected String datastoreName;

    /** 客户机操作系统 */
    protected String guestOs;

    /** 硬件版本 */
    protected Integer hardwareVersion;

    /** 主机名称 */
    protected String hostName;

    /** 内存大小 */
    protected Integer memoryMB;

    protected String moref;

    /** 网络名称 */
    protected String networkName;

    /** CPU个数 */
    protected Integer numberOfCpus;

    /** 机构 */
    protected String org;

    /** 状态 */
    protected String status;

    /**
     * 获取虚机名称
     * @return 虚机名称 
     */
    public String getName() {
        return name;
    }

    /**
     * 设置虚机名称
     * @param name 虚机名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取目录名称
     * @return 目录名称 
     */
    public String getCatalogName() {
        return catalogName;
    }

    /**
     * 设置目录名称
     * @param catalogName 目录名称
     */
    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    /**
     * 获取存储名称
     * @return 存储名称 
     */
    public String getDatastoreName() {
        return datastoreName;
    }

    /**
     * 设置存储名称
     * @param datastoreName 存储名称
     */
    public void setDatastoreName(String datastoreName) {
        this.datastoreName = datastoreName;
    }

    /**
     * 获取客户机操作系统
     * @return 客户机操作系统 
     */
    public String getGuestOs() {
        return guestOs;
    }

    /**
     * 设置客户机操作系统
     * @param guestOs 客户机操作系统
     */
    public void setGuestOs(String guestOs) {
        this.guestOs = guestOs;
    }

    /**
     * 获取硬件版本
     * @return 硬件版本 
     */
    public Integer getHardwareVersion() {
        return hardwareVersion;
    }

    /**
     * 设置硬件版本
     * @param hardwareVersion 硬件版本
     */
    public void setHardwareVersion(Integer hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    /**
     * 获取主机名称
     * @return 主机名称 
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * 设置主机名称
     * @param hostName 主机名称
     */
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    /**
     * 获取内存大小
     * @return 内存大小 
     */
    public Integer getMemoryMB() {
        return memoryMB;
    }

    /**
     * 设置内存大小
     * @param memoryMB 内存大小
     */
    public void setMemoryMB(Integer memoryMB) {
        this.memoryMB = memoryMB;
    }

    /**
     * 获取moref
     * @return moref 
     */
    public String getMoref() {
        return moref;
    }

    /**
     * 设置moref
     * @param moref moref
     */
    public void setMoref(String moref) {
        this.moref = moref;
    }

    /**
     * 获取网络名称
     * @return 网络名称 
     */
    public String getNetworkName() {
        return networkName;
    }

    /**
     * 设置网络名称
     * @param networkName 网络名称
     */
    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    /**
     * 获取CPU个数
     * @return CPU个数 
     */
    public Integer getNumberOfCpus() {
        return numberOfCpus;
    }

    /**
     * 设置CPU个数
     * @param numberOfCpus CPU个数
     */
    public void setNumberOfCpus(Integer numberOfCpus) {
        this.numberOfCpus = numberOfCpus;
    }

    /**
     * 获取机构
     * @return 机构 
     */
    public String getOrg() {
        return org;
    }

    /**
     * 设置机构
     * @param org 机构
     */
    public void setOrg(String org) {
        this.org = org;
    }

    /**
     * 获取状态
     * @return 状态 
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
