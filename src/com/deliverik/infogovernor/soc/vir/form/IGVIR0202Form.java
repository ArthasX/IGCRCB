/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ��Դ��������FORM
 * 
 */
@SuppressWarnings("serial")
public class IGVIR0202Form extends BaseForm{
    
    /** ������Ŀ���� */
    protected String pid;
    
    /** ��������������� */
    protected String hostNames[];
    
    /** ������ */
    protected String networkNames[];
    
    /** ������� */
    protected String vmids[];

    /** vCenter���� */
    protected Integer vcid;
    
    /** ����IP */
    protected String hostip;
    
    /** ������������ */
    protected String datacenterNames[];
    
    /** ��Դ������ */
    protected String resourcePoolNames[];
    
    /** �������� */
    protected Integer prid;
    
    /** ������������ */
    protected String dcname;
    
    /**
     * ��ȡ������Ŀ����
     * @return ������Ŀ���� 
     */
    public String getPid() {
        return pid;
    }

    /**
     * ����������Ŀ����
     * @param pid ������Ŀ����
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * ��ȡ���������������
     * @return ��������������� 
     */
    public String[] getHostNames() {
        return hostNames;
    }

    /**
     * �������������������
     * @param hostNames ���������������
     */
    public void setHostNames(String[] hostNames) {
        this.hostNames = hostNames;
    }

    /**
     * ��ȡ������
     * @return ������ 
     */
    public String[] getNetworkNames() {
        return networkNames;
    }

    /**
     * ����������
     * @param networkNames ������
     */
    public void setNetworkNames(String[] networkNames) {
        this.networkNames = networkNames;
    }

    /**
     * ��ȡ�������
     * @return ������� 
     */
    public String[] getVmids() {
        return vmids;
    }

    /**
     * �����������
     * @param vmids �������
     */
    public void setVmids(String[] vmids) {
        this.vmids = vmids;
    }

    /**
     * ��ȡvCenter����
     * @return vCenter���� 
     */
    public Integer getVcid() {
        return vcid;
    }

    /**
     * ����vCenter����
     * @param vcid vCenter����
     */
    public void setVcid(Integer vcid) {
        this.vcid = vcid;
    }

    /**
     * ��ȡ����IP
     * @return ����IP 
     */
    public String getHostip() {
        return hostip;
    }

    /**
     * ��������IP
     * @param hostip ����IP
     */
    public void setHostip(String hostip) {
        this.hostip = hostip;
    }

    /**
     * ��ȡ������������
     * @return ������������ 
     */
    public String[] getDatacenterNames() {
        return datacenterNames;
    }

    /**
     * ����������������
     * @param datacenterNames ������������
     */
    public void setDatacenterNames(String[] datacenterNames) {
        this.datacenterNames = datacenterNames;
    }

    /**
     * ��ȡ��Դ������
     * @return ��Դ������ 
     */
    public String[] getResourcePoolNames() {
        return resourcePoolNames;
    }

    /**
     * ������Դ������
     * @param resourcePoolNames ��Դ������
     */
    public void setResourcePoolNames(String[] resourcePoolNames) {
        this.resourcePoolNames = resourcePoolNames;
    }

    /**
     * ��ȡ��������
     * @return �������� 
     */
    public Integer getPrid() {
        return prid;
    }

    /**
     * ������������
     * @param prid ��������
     */
    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    /**
     * ��ȡ������������
     * @return ������������ 
     */
    public String getDcname() {
        return dcname;
    }

    /**
     * ����������������
     * @param dcname ������������
     */
    public void setDcname(String dcname) {
        this.dcname = dcname;
    }
    
}
