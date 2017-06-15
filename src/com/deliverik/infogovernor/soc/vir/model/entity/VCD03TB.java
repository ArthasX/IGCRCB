/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;

/**
  * ����: ��Դ���������Ϣʵ��
  * ��������: ��Դ���������Ϣʵ��
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="VCD03")
public class VCD03TB extends BaseEntity implements Serializable,
		Cloneable, VCD03Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="VCD03_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VCD03_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VCD03_TABLE_GENERATOR")
	protected Integer id;

	/** ��Ŀ���� */
	protected Integer pid;

	/** vcloud���� */
	protected Integer vcid;
	
	/** vcloud���� */
	protected String vcname;

	/** ģ��ID */
	protected Integer templateid;
	
	/** ģ������ */
	protected String templateName;

	/** ��������������� */
	protected String hostName;

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

	/** ����� */
	protected String netWork;

	/** �洢���� */
	protected String storageProfile;

	/** ��������� */
	protected String orgsyscoding;

	/** �������� */
	protected String orgname;

	/** �Զ�������� */
	protected String progress;

	/** �û�ID */
	protected String userid;

	/** �û����� */
	protected String userName;

	/** ����ʱ�� */
	protected String applyTime;

	/** ����ʱ�� */
	protected String expiryTime;
	
	/** ������������id */
    protected Integer prid;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 *
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * ��Ŀ����ȡ��
	 *
	 * @return ��Ŀ����
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * ��Ŀ�����趨
	 *
	 * @param pid ��Ŀ����
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * vcloud����ȡ��
	 *
	 * @return vcloud����
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vcloud�����趨
	 *
	 * @param vcid vcloud����
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * vcloud����ȡ��
	 * @return vcname vcloud����
	 */
	public String getVcname() {
		return vcname;
	}

	/**
	 * vcloud�����趨
	 * @param vcname vcloud����
	 */
	public void setVcname(String vcname) {
		this.vcname = vcname;
	}

	/**
	 * ģ��IDȡ��
	 *
	 * @return ģ��ID
	 */
	public Integer getTemplateid() {
		return templateid;
	}

	/**
	 * ģ��ID�趨
	 *
	 * @param templateid ģ��ID
	 */
	public void setTemplateid(Integer templateid) {
		this.templateid = templateid;
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
	 *
	 * @return ���������������
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * ����������������趨
	 *
	 * @param hostName ���������������
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getNetworkName() {
		return networkName;
	}

	/**
	 * �������趨
	 *
	 * @param networkName ������
	 */
	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getVmName() {
		return vmName;
	}

	/**
	 * ��������趨
	 *
	 * @param vmName �������
	 */
	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

	/**
	 * ���CPU����ȡ��
	 *
	 * @return ���CPU����
	 */
	public Integer getVmCpus() {
		return vmCpus;
	}

	/**
	 * ���CPU�����趨
	 *
	 * @param vmCpus ���CPU����
	 */
	public void setVmCpus(Integer vmCpus) {
		this.vmCpus = vmCpus;
	}

	/**
	 * ����ڴ��Сȡ��
	 *
	 * @return ����ڴ��С
	 */
	public Integer getVmMem() {
		return vmMem;
	}

	/**
	 * ����ڴ��С�趨
	 *
	 * @param vmMem ����ڴ��С
	 */
	public void setVmMem(Integer vmMem) {
		this.vmMem = vmMem;
	}

	/**
	 * ���Ӳ�̴�Сȡ��
	 *
	 * @return ���Ӳ�̴�С
	 */
	public Integer getVmDisk() {
		return vmDisk;
	}

	/**
	 * ���Ӳ�̴�С�趨
	 *
	 * @param vmDisk ���Ӳ�̴�С
	 */
	public void setVmDisk(Integer vmDisk) {
		this.vmDisk = vmDisk;
	}

	/**
	 * �����ȡ��
	 *
	 * @return �����
	 */
	public String getNetWork() {
		return netWork;
	}

	/**
	 * ������趨
	 *
	 * @param netWork �����
	 */
	public void setNetWork(String netWork) {
		this.netWork = netWork;
	}

	/**
	 * �洢����ȡ��
	 *
	 * @return �洢����
	 */
	public String getStorageProfile() {
		return storageProfile;
	}

	/**
	 * �洢�����趨
	 *
	 * @param storageProfile �洢����
	 */
	public void setStorageProfile(String storageProfile) {
		this.storageProfile = storageProfile;
	}

	/**
	 * ���������ȡ��
	 *
	 * @return ���������
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * ����������趨
	 *
	 * @param orgsyscoding ���������
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ���������趨
	 *
	 * @param orgname ��������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * �Զ��������ȡ��
	 *
	 * @return �Զ��������
	 */
	public String getProgress() {
		return progress;
	}

	/**
	 * �Զ���������趨
	 *
	 * @param progress �Զ��������
	 */
	public void setProgress(String progress) {
		this.progress = progress;
	}

	/**
	 * �û�IDȡ��
	 *
	 * @return �û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�ID�趨
	 *
	 * @param userid �û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * �û�����ȡ��
	 *
	 * @return �û�����
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * �û������趨
	 *
	 * @param userName �û�����
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getApplyTime() {
		return applyTime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param applyTime ����ʱ��
	 */
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getExpiryTime() {
		return expiryTime;
	}

	/**
	 * ����ʱ���趨
	 *
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
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

}