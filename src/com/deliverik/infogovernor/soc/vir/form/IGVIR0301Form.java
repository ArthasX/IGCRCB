/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ��Ŀ�б���FORM
 * 
 */
@SuppressWarnings("serial")
public class IGVIR0301Form extends BaseForm{

    /** ������Ŀ���� */
    protected Integer pid;
    
    /** ������� */
    protected Integer vmids[];
    
    /** ���cpu���� */
    protected String vmcpus[];
    
    /** ����ڴ��С */
    protected String vmmems[];
    
    /** ����Ӳ�̴�С */
    protected String vmdisks[];
    
    /** ��ʷ���cpu���� */
    protected String vmcpus_h[];
    
    /** ��ʷ����ڴ��С */
    protected String vmmems_h[];
    
    /** ��ʷ����Ӳ�̴�С */
    protected String vmdisks_h[];

    /**
     * ��ȡ������Ŀ����
     * @return ������Ŀ���� 
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * ����������Ŀ����
     * @param pid ������Ŀ����
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * ��ȡ�������
     * @return ������� 
     */
    public Integer[] getVmids() {
        return vmids;
    }

    /**
     * �����������
     * @param vmids �������
     */
    public void setVmids(Integer[] vmids) {
        this.vmids = vmids;
    }

    /**
     * ��ȡ���cpu����
     * @return ���cpu���� 
     */
    public String[] getVmcpus() {
        return vmcpus;
    }

    /**
     * �������cpu����
     * @param vmcpus ���cpu����
     */
    public void setVmcpus(String[] vmcpus) {
        this.vmcpus = vmcpus;
    }

    /**
     * ��ȡ����ڴ��С
     * @return ����ڴ��С 
     */
    public String[] getVmmems() {
        return vmmems;
    }

    /**
     * ��������ڴ��С
     * @param vmmems ����ڴ��С
     */
    public void setVmmems(String[] vmmems) {
        this.vmmems = vmmems;
    }

    /**
     * ��ȡ����Ӳ�̴�С
     * @return ����Ӳ�̴�С 
     */
    public String[] getVmdisks() {
        return vmdisks;
    }

    /**
     * ��������Ӳ�̴�С
     * @param vmdisks ����Ӳ�̴�С
     */
    public void setVmdisks(String[] vmdisks) {
        this.vmdisks = vmdisks;
    }

    /**
     * ��ȡ��ʷ���cpu����
     * @return ��ʷ���cpu���� 
     */
    public String[] getVmcpus_h() {
        return vmcpus_h;
    }

    /**
     * ������ʷ���cpu����
     * @param vmcpus_h ��ʷ���cpu����
     */
    public void setVmcpus_h(String[] vmcpus_h) {
        this.vmcpus_h = vmcpus_h;
    }

    /**
     * ��ȡ��ʷ����ڴ��С
     * @return ��ʷ����ڴ��С 
     */
    public String[] getVmmems_h() {
        return vmmems_h;
    }

    /**
     * ������ʷ����ڴ��С
     * @param vmmems_h ��ʷ����ڴ��С
     */
    public void setVmmems_h(String[] vmmems_h) {
        this.vmmems_h = vmmems_h;
    }

    /**
     * ��ȡ��ʷ����Ӳ�̴�С
     * @return ��ʷ����Ӳ�̴�С 
     */
    public String[] getVmdisks_h() {
        return vmdisks_h;
    }

    /**
     * ������ʷ����Ӳ�̴�С
     * @param vmdisks_h ��ʷ����Ӳ�̴�С
     */
    public void setVmdisks_h(String[] vmdisks_h) {
        this.vmdisks_h = vmdisks_h;
    }
    
    
}
