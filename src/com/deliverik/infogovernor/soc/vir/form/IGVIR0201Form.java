/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ��Դ���뻭��FORM
 * 
 */
public class IGVIR0201Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** ��Ŀ���� */
    protected String projectName;

    /** ��������ʱ�� */
    protected String expectDeployTime;

    /** ��Ŀ����ʱ�� */
    protected String projectExpireTime;

    /** ��Ŀ��� */
    protected String projectType;

    /** ��Ŀ˵�� */
    protected String projectDesc;

    /** ����˵�� */
    protected String projectApplyReason;

	/** ���ģ��  */
	protected String templates[];
	
	/** ������� */
	protected String vmnames[];
	
	/** ���cpu���� */
	protected String vmcpus[];
	
	/** ����ڴ��С */
	protected String vmmems[];
	
	/** ����Ӳ�̴�С */
	protected String vmdisks[];

	/** ����ʱ�� */
    protected String applyTime[];
    
    /** ����ʱ�� */
    protected String expiryTime[];
    
    /** ѡ�����Ŀid */
    protected Integer hpid;
    
    /**
     * ��ȡ��Ŀ����
     * @return ��Ŀ���� 
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * ������Ŀ����
     * @param projectName ��Ŀ����
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * ��ȡ��������ʱ��
     * @return ��������ʱ�� 
     */
    public String getExpectDeployTime() {
        return expectDeployTime;
    }

    /**
     * ������������ʱ��
     * @param expectDeployTime ��������ʱ��
     */
    public void setExpectDeployTime(String expectDeployTime) {
        this.expectDeployTime = expectDeployTime;
    }

    /**
     * ��ȡ��Ŀ����ʱ��
     * @return ��Ŀ����ʱ�� 
     */
    public String getProjectExpireTime() {
        return projectExpireTime;
    }

    /**
     * ������Ŀ����ʱ��
     * @param projectExpireTime ��Ŀ����ʱ��
     */
    public void setProjectExpireTime(String projectExpireTime) {
        this.projectExpireTime = projectExpireTime;
    }

    /**
     * ��ȡ��Ŀ���
     * @return ��Ŀ��� 
     */
    public String getProjectType() {
        return projectType;
    }

    /**
     * ������Ŀ���
     * @param projectType ��Ŀ���
     */
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    /**
     * ��ȡ��Ŀ˵��
     * @return ��Ŀ˵�� 
     */
    public String getProjectDesc() {
        return projectDesc;
    }

    /**
     * ������Ŀ˵��
     * @param projectDesc ��Ŀ˵��
     */
    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    /**
     * ��ȡ����˵��
     * @return ����˵�� 
     */
    public String getProjectApplyReason() {
        return projectApplyReason;
    }

    /**
     * ��������˵��
     * @param projectApplyReason ����˵��
     */
    public void setProjectApplyReason(String projectApplyReason) {
        this.projectApplyReason = projectApplyReason;
    }

    /**
     * ��ȡ���ģ��
     * @return ���ģ�� 
     */
    public String[] getTemplates() {
        return templates;
    }

    /**
     * �������ģ��
     * @param templates ���ģ��
     */
    public void setTemplates(String[] templates) {
        this.templates = templates;
    }

    /**
     * ��ȡ�������
     * @return ������� 
     */
    public String[] getVmnames() {
        return vmnames;
    }

    /**
     * �����������
     * @param vmnames �������
     */
    public void setVmnames(String[] vmnames) {
        this.vmnames = vmnames;
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
     * ��ȡ����ʱ��
     * @return ����ʱ�� 
     */
    public String[] getApplyTime() {
        return applyTime;
    }

    /**
     * ��������ʱ��
     * @param applyTime ����ʱ��
     */
    public void setApplyTime(String[] applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * ��ȡ����ʱ��
     * @return ����ʱ�� 
     */
    public String[] getExpiryTime() {
        return expiryTime;
    }

    /**
     * ���õ���ʱ��
     * @param expiryTime ����ʱ��
     */
    public void setExpiryTime(String[] expiryTime) {
        this.expiryTime = expiryTime;
    }

    /**
     * ��ȡѡ�����Ŀid
     * @return ѡ�����Ŀid 
     */
    public Integer getHpid() {
        return hpid;
    }

    /**
     * ����ѡ�����Ŀid
     * @param hpid ѡ�����Ŀid
     */
    public void setHpid(Integer hpid) {
        this.hpid = hpid;
    }
	
}
