/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: vCloud���⻯��Դ���뷢��form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR3001Form extends BaseForm{

	/** vCloud��֯���� */
	protected String vorg;
	
	/** vCloud����ID */
	protected Integer vcid;
	
	/** vCloud���� */
	protected String vcname;
	
	/** ������ */
	protected String orgid;
	
	/** �������� */
	protected String orgname;
	
	/** Ŀ¼���� */
	protected String catalog;
	
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
	 * vCloud��֯����ȡ��
	 * @return vorg vCloud��֯����
	 */
	public String getVorg() {
		return vorg;
	}

	/**
	 * vCloud��֯�����趨
	 * @param vorg vCloud��֯����
	 */
	public void setVorg(String vorg) {
		this.vorg = vorg;
	}

	/**
	 * vCloud����IDȡ��
	 * @return vcid vCloud����ID
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vCloud����ID�趨
	 * @param vcid vCloud����ID
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * vCloud����ȡ��
	 * @return vcname vCloud����
	 */
	public String getVcname() {
		return vcname;
	}

	/**
	 * vCloud�����趨
	 * @param vcname vCloud����
	 */
	public void setVcname(String vcname) {
		this.vcname = vcname;
	}

	/**
	 * ������ȡ��
	 * @return orgid ������
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * �������趨
	 * @param orgid ������
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * ��������ȡ��
	 * @return orgname ��������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ���������趨
	 * @param orgname ��������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * Ŀ¼����ȡ��
	 * @return catalog Ŀ¼����
	 */
	public String getCatalog() {
		return catalog;
	}

	/**
	 * Ŀ¼�����趨
	 * @param catalog Ŀ¼����
	 */
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	/**
	 * ��Ŀ����ȡ��
	 * @return projectName ��Ŀ����
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * ��Ŀ�����趨
	 * @param projectName ��Ŀ����
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * ��������ʱ��ȡ��
	 * @return expectDeployTime ��������ʱ��
	 */
	public String getExpectDeployTime() {
		return expectDeployTime;
	}

	/**
	 * ��������ʱ���趨
	 * @param expectDeployTime ��������ʱ��
	 */
	public void setExpectDeployTime(String expectDeployTime) {
		this.expectDeployTime = expectDeployTime;
	}

	/**
	 * ��Ŀ����ʱ��ȡ��
	 * @return projectExpireTime ��Ŀ����ʱ��
	 */
	public String getProjectExpireTime() {
		return projectExpireTime;
	}

	/**
	 * ��Ŀ����ʱ���趨
	 * @param projectExpireTime ��Ŀ����ʱ��
	 */
	public void setProjectExpireTime(String projectExpireTime) {
		this.projectExpireTime = projectExpireTime;
	}

	/**
	 * ��Ŀ���ȡ��
	 * @return projectType ��Ŀ���
	 */
	public String getProjectType() {
		return projectType;
	}

	/**
	 * ��Ŀ����趨
	 * @param projectType ��Ŀ���
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	/**
	 * ��Ŀ˵��ȡ��
	 * @return projectDesc ��Ŀ˵��
	 */
	public String getProjectDesc() {
		return projectDesc;
	}

	/**
	 * ��Ŀ˵���趨
	 * @param projectDesc ��Ŀ˵��
	 */
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	/**
	 * ����˵��ȡ��
	 * @return projectApplyReason ����˵��
	 */
	public String getProjectApplyReason() {
		return projectApplyReason;
	}

	/**
	 * ����˵���趨
	 * @param projectApplyReason ����˵��
	 */
	public void setProjectApplyReason(String projectApplyReason) {
		this.projectApplyReason = projectApplyReason;
	}

	/**
	 * ���ģ��ȡ��
	 * @return templates ���ģ��
	 */
	public String[] getTemplates() {
		return templates;
	}

	/**
	 * ���ģ���趨
	 * @param templates ���ģ��
	 */
	public void setTemplates(String[] templates) {
		this.templates = templates;
	}

	/**
	 * �������ȡ��
	 * @return vmnames �������
	 */
	public String[] getVmnames() {
		return vmnames;
	}

	/**
	 * ��������趨
	 * @param vmnames �������
	 */
	public void setVmnames(String[] vmnames) {
		this.vmnames = vmnames;
	}

	/**
	 * ���cpu����ȡ��
	 * @return vmcpus ���cpu����
	 */
	public String[] getVmcpus() {
		return vmcpus;
	}

	/**
	 * ���cpu�����趨
	 * @param vmcpus ���cpu����
	 */
	public void setVmcpus(String[] vmcpus) {
		this.vmcpus = vmcpus;
	}

	/**
	 * ����ڴ��Сȡ��
	 * @return vmmems ����ڴ��С
	 */
	public String[] getVmmems() {
		return vmmems;
	}

	/**
	 * ����ڴ��С�趨
	 * @param vmmems ����ڴ��С
	 */
	public void setVmmems(String[] vmmems) {
		this.vmmems = vmmems;
	}

	/**
	 * ����Ӳ�̴�Сȡ��
	 * @return vmdisks ����Ӳ�̴�С
	 */
	public String[] getVmdisks() {
		return vmdisks;
	}

	/**
	 * ����Ӳ�̴�С�趨
	 * @param vmdisks ����Ӳ�̴�С
	 */
	public void setVmdisks(String[] vmdisks) {
		this.vmdisks = vmdisks;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return applyTime ����ʱ��
	 */
	public String[] getApplyTime() {
		return applyTime;
	}

	/**
	 * ����ʱ���趨
	 * @param applyTime ����ʱ��
	 */
	public void setApplyTime(String[] applyTime) {
		this.applyTime = applyTime;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return expiryTime ����ʱ��
	 */
	public String[] getExpiryTime() {
		return expiryTime;
	}

	/**
	 * ����ʱ���趨
	 * @param expiryTime ����ʱ��
	 */
	public void setExpiryTime(String[] expiryTime) {
		this.expiryTime = expiryTime;
	}

	/**
	 * ѡ�����Ŀidȡ��
	 * @return hpid ѡ�����Ŀid
	 */
	public Integer getHpid() {
		return hpid;
	}

	/**
	 * ѡ�����Ŀid�趨
	 * @param hpid ѡ�����Ŀid
	 */
	public void setHpid(Integer hpid) {
		this.hpid = hpid;
	}
}
