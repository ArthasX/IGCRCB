/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 资源申请审批FORM
 * 
 */
@SuppressWarnings("serial")
public class IGVIR0202Form extends BaseForm{
    
    /** 申请项目主键 */
    protected String pid;
    
    /** 虚机所在主机名称 */
    protected String hostNames[];
    
    /** 网络名 */
    protected String networkNames[];
    
    /** 虚机主键 */
    protected String vmids[];

    /** vCenter主键 */
    protected Integer vcid;
    
    /** 主机IP */
    protected String hostip;
    
    /** 数据中心名称 */
    protected String datacenterNames[];
    
    /** 资源池名称 */
    protected String resourcePoolNames[];
    
    /** 流程主键 */
    protected Integer prid;
    
    /** 数据中心名称 */
    protected String dcname;
    
    /**
     * 获取申请项目主键
     * @return 申请项目主键 
     */
    public String getPid() {
        return pid;
    }

    /**
     * 设置申请项目主键
     * @param pid 申请项目主键
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * 获取虚机所在主机名称
     * @return 虚机所在主机名称 
     */
    public String[] getHostNames() {
        return hostNames;
    }

    /**
     * 设置虚机所在主机名称
     * @param hostNames 虚机所在主机名称
     */
    public void setHostNames(String[] hostNames) {
        this.hostNames = hostNames;
    }

    /**
     * 获取网络名
     * @return 网络名 
     */
    public String[] getNetworkNames() {
        return networkNames;
    }

    /**
     * 设置网络名
     * @param networkNames 网络名
     */
    public void setNetworkNames(String[] networkNames) {
        this.networkNames = networkNames;
    }

    /**
     * 获取虚机主键
     * @return 虚机主键 
     */
    public String[] getVmids() {
        return vmids;
    }

    /**
     * 设置虚机主键
     * @param vmids 虚机主键
     */
    public void setVmids(String[] vmids) {
        this.vmids = vmids;
    }

    /**
     * 获取vCenter主键
     * @return vCenter主键 
     */
    public Integer getVcid() {
        return vcid;
    }

    /**
     * 设置vCenter主键
     * @param vcid vCenter主键
     */
    public void setVcid(Integer vcid) {
        this.vcid = vcid;
    }

    /**
     * 获取主机IP
     * @return 主机IP 
     */
    public String getHostip() {
        return hostip;
    }

    /**
     * 设置主机IP
     * @param hostip 主机IP
     */
    public void setHostip(String hostip) {
        this.hostip = hostip;
    }

    /**
     * 获取数据中心名称
     * @return 数据中心名称 
     */
    public String[] getDatacenterNames() {
        return datacenterNames;
    }

    /**
     * 设置数据中心名称
     * @param datacenterNames 数据中心名称
     */
    public void setDatacenterNames(String[] datacenterNames) {
        this.datacenterNames = datacenterNames;
    }

    /**
     * 获取资源池名称
     * @return 资源池名称 
     */
    public String[] getResourcePoolNames() {
        return resourcePoolNames;
    }

    /**
     * 设置资源池名称
     * @param resourcePoolNames 资源池名称
     */
    public void setResourcePoolNames(String[] resourcePoolNames) {
        this.resourcePoolNames = resourcePoolNames;
    }

    /**
     * 获取流程主键
     * @return 流程主键 
     */
    public Integer getPrid() {
        return prid;
    }

    /**
     * 设置流程主键
     * @param prid 流程主键
     */
    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    /**
     * 获取数据中心名称
     * @return 数据中心名称 
     */
    public String getDcname() {
        return dcname;
    }

    /**
     * 设置数据中心名称
     * @param dcname 数据中心名称
     */
    public void setDcname(String dcname) {
        this.dcname = dcname;
    }
    
}
