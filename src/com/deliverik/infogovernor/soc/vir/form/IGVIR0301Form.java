/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 项目列表画面FORM
 * 
 */
@SuppressWarnings("serial")
public class IGVIR0301Form extends BaseForm{

    /** 申请项目主键 */
    protected Integer pid;
    
    /** 虚机主键 */
    protected Integer vmids[];
    
    /** 虚机cpu个数 */
    protected String vmcpus[];
    
    /** 虚机内存大小 */
    protected String vmmems[];
    
    /** 虚拟硬盘大小 */
    protected String vmdisks[];
    
    /** 历史虚机cpu个数 */
    protected String vmcpus_h[];
    
    /** 历史虚机内存大小 */
    protected String vmmems_h[];
    
    /** 历史虚拟硬盘大小 */
    protected String vmdisks_h[];

    /**
     * 获取申请项目主键
     * @return 申请项目主键 
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置申请项目主键
     * @param pid 申请项目主键
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取虚机主键
     * @return 虚机主键 
     */
    public Integer[] getVmids() {
        return vmids;
    }

    /**
     * 设置虚机主键
     * @param vmids 虚机主键
     */
    public void setVmids(Integer[] vmids) {
        this.vmids = vmids;
    }

    /**
     * 获取虚机cpu个数
     * @return 虚机cpu个数 
     */
    public String[] getVmcpus() {
        return vmcpus;
    }

    /**
     * 设置虚机cpu个数
     * @param vmcpus 虚机cpu个数
     */
    public void setVmcpus(String[] vmcpus) {
        this.vmcpus = vmcpus;
    }

    /**
     * 获取虚机内存大小
     * @return 虚机内存大小 
     */
    public String[] getVmmems() {
        return vmmems;
    }

    /**
     * 设置虚机内存大小
     * @param vmmems 虚机内存大小
     */
    public void setVmmems(String[] vmmems) {
        this.vmmems = vmmems;
    }

    /**
     * 获取虚拟硬盘大小
     * @return 虚拟硬盘大小 
     */
    public String[] getVmdisks() {
        return vmdisks;
    }

    /**
     * 设置虚拟硬盘大小
     * @param vmdisks 虚拟硬盘大小
     */
    public void setVmdisks(String[] vmdisks) {
        this.vmdisks = vmdisks;
    }

    /**
     * 获取历史虚机cpu个数
     * @return 历史虚机cpu个数 
     */
    public String[] getVmcpus_h() {
        return vmcpus_h;
    }

    /**
     * 设置历史虚机cpu个数
     * @param vmcpus_h 历史虚机cpu个数
     */
    public void setVmcpus_h(String[] vmcpus_h) {
        this.vmcpus_h = vmcpus_h;
    }

    /**
     * 获取历史虚机内存大小
     * @return 历史虚机内存大小 
     */
    public String[] getVmmems_h() {
        return vmmems_h;
    }

    /**
     * 设置历史虚机内存大小
     * @param vmmems_h 历史虚机内存大小
     */
    public void setVmmems_h(String[] vmmems_h) {
        this.vmmems_h = vmmems_h;
    }

    /**
     * 获取历史虚拟硬盘大小
     * @return 历史虚拟硬盘大小 
     */
    public String[] getVmdisks_h() {
        return vmdisks_h;
    }

    /**
     * 设置历史虚拟硬盘大小
     * @param vmdisks_h 历史虚拟硬盘大小
     */
    public void setVmdisks_h(String[] vmdisks_h) {
        this.vmdisks_h = vmdisks_h;
    }
    
    
}
