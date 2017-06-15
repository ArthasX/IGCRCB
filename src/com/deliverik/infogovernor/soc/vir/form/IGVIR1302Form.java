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
 * Description: ��������޸�Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR1302Form extends BaseForm {

	/** ���� */
	protected Integer id;

	/** ��Ŀ���� */
	protected Integer pid;

	/** ��Ŀ���� */
	protected String pname;
	
	/** vcenter���� */
	protected Integer vcid;

	/** vCenter���� */
	protected String vcName;
	
	/** ģ������ */
	protected String templateName;

	/** ��������������� */
	protected String hostName;
	
	/** IP��ַ */
	protected String ip;

	/** ������ */
	protected String networkName;

	/** ������� */
	protected String vmName;

	/** ���CPU���� */
	protected Integer vmCpus;

	/** ����ڴ��С */
	protected Integer vmMem;

	/** ���Ӳ�̴�С */
	protected Integer vmDisk;

	/** �Զ�������� */
	protected String progress;
	
	/** ������������ */
	protected String datacenterName;
	
	/** ��Դ������ */
	protected String resourcePoolName;
	
    /** ��������� */
    protected String orgsyscoding;
    
    /** �������� */
    protected String orgname;
    
    /** �û�id */
    protected String userid;
    
    /** �û����� */
    protected String userName;
    
    /** ����ʱ�� */
    protected String applyTime;
    
    /** ����ʱ�� */
    protected String expiryTime;
    
    /** ������������id */
    protected Integer prid;
    
    /** ״̬ */
    protected String status;

	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * ��Ŀ����ȡ��
	 * @return pid ��Ŀ����
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * ��Ŀ�����趨
	 * @param pid ��Ŀ����
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * ��Ŀ����ȡ��
	 * @return pname ��Ŀ����
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * ��Ŀ�����趨
	 * @param pname ��Ŀ����
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * vcenter����ȡ��
	 * @return vcid vcenter����
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vcenter�����趨
	 * @param vcid vcenter����
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * vCenter����ȡ��
	 * @return vcName vCenter����
	 */
	public String getVcName() {
		return vcName;
	}

	/**
	 * vCenter�����趨
	 * @param vcName vCenter����
	 */
	public void setVcName(String vcName) {
		this.vcName = vcName;
	}

	/**
	 * ģ������ȡ��
	 * @return templateName ģ������
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * ģ�������趨
	 * @param templateName ģ������
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * ���������������ȡ��
	 * @return hostName ���������������
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * ����������������趨
	 * @param hostName ���������������
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
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
	 * ������ȡ��
	 * @return networkName ������
	 */
	public String getNetworkName() {
		return networkName;
	}

	/**
	 * �������趨
	 * @param networkName ������
	 */
	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	/**
	 * �������ȡ��
	 * @return vmName �������
	 */
	public String getVmName() {
		return vmName;
	}

	/**
	 * ��������趨
	 * @param vmName �������
	 */
	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

	/**
	 * ���CPU����ȡ��
	 * @return vmCpus ���CPU����
	 */
	public Integer getVmCpus() {
		return vmCpus;
	}

	/**
	 * ���CPU�����趨
	 * @param vmCpus ���CPU����
	 */
	public void setVmCpus(Integer vmCpus) {
		this.vmCpus = vmCpus;
	}

	/**
	 * ����ڴ��Сȡ��
	 * @return vmMem ����ڴ��С
	 */
	public Integer getVmMem() {
		return vmMem;
	}

	/**
	 * ����ڴ��С�趨
	 * @param vmMem ����ڴ��С
	 */
	public void setVmMem(Integer vmMem) {
		this.vmMem = vmMem;
	}

	/**
	 * ���Ӳ�̴�Сȡ��
	 * @return vmDisk ���Ӳ�̴�С
	 */
	public Integer getVmDisk() {
		return vmDisk;
	}

	/**
	 * ���Ӳ�̴�С�趨
	 * @param vmDisk ���Ӳ�̴�С
	 */
	public void setVmDisk(Integer vmDisk) {
		this.vmDisk = vmDisk;
	}

	/**
	 * �Զ��������ȡ��
	 * @return progress �Զ��������
	 */
	public String getProgress() {
		return progress;
	}

	/**
	 * �Զ���������趨
	 * @param progress �Զ��������
	 */
	public void setProgress(String progress) {
		this.progress = progress;
	}

	/**
	 * ������������ȡ��
	 * @return datacenterName ������������
	 */
	public String getDatacenterName() {
		return datacenterName;
	}

	/**
	 * �������������趨
	 * @param datacenterName ������������
	 */
	public void setDatacenterName(String datacenterName) {
		this.datacenterName = datacenterName;
	}

	/**
	 * ��Դ������ȡ��
	 * @return resourcePoolName ��Դ������
	 */
	public String getResourcePoolName() {
		return resourcePoolName;
	}

	/**
	 * ��Դ�������趨
	 * @param resourcePoolName ��Դ������
	 */
	public void setResourcePoolName(String resourcePoolName) {
		this.resourcePoolName = resourcePoolName;
	}

	/**
	 * ���������ȡ��
	 * @return orgsyscoding ���������
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * ����������趨
	 * @param orgsyscoding ���������
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
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
	 * �û�idȡ��
	 * @return userid �û�id
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�id�趨
	 * @param userid �û�id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * �û�����ȡ��
	 * @return userName �û�����
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * �û������趨
	 * @param userName �û�����
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return applyTime ����ʱ��
	 */
	public String getApplyTime() {
		return applyTime;
	}

	/**
	 * ����ʱ���趨
	 * @param applyTime ����ʱ��
	 */
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return expiryTime ����ʱ��
	 */
	public String getExpiryTime() {
		return expiryTime;
	}

	/**
	 * ����ʱ���趨
	 * @param expiryTime ����ʱ��
	 */
	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}

	/**
	 * ������������idȡ��
	 * @return prid ������������id
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ������������id�趨
	 * @param prid ������������id
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ״̬ȡ��
	 * @return status ״̬
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ״̬�趨
	 * @param status ״̬
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
