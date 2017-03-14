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
 * Description: ���⻯��Դ���봦��Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR3002Form extends BaseForm{

    /** ������Ŀ���� */
    protected Integer pid;
    
    /** ��������������� */
    protected String hostNames[];
    
    /** ������ */
    protected String networkNames[];
    
    /** ������� */
    protected String vmids[];

    /** vCloud���� */
    protected Integer vcid;
    
    /** ����IP */
    protected String hostip;
    
    /** ������������ */
    protected String datacenterNames[];
    
    /** ��Դ������ */
    protected String resourcePoolNames[];
    
    /** �������� */
    protected Integer prid;

	/**
	 * ������Ŀ����ȡ��
	 * @return pid ������Ŀ����
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * ���������������ȡ��
	 * @return hostNames ���������������
	 */
	public String[] getHostNames() {
		return hostNames;
	}

	/**
	 * ������ȡ��
	 * @return networkNames ������
	 */
	public String[] getNetworkNames() {
		return networkNames;
	}

	/**
	 * �������ȡ��
	 * @return vmids �������
	 */
	public String[] getVmids() {
		return vmids;
	}

	/**
	 * vCloud����ȡ��
	 * @return vcid vCloud����
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * ����IPȡ��
	 * @return hostip ����IP
	 */
	public String getHostip() {
		return hostip;
	}

	/**
	 * ������������ȡ��
	 * @return datacenterNames ������������
	 */
	public String[] getDatacenterNames() {
		return datacenterNames;
	}

	/**
	 * ��Դ������ȡ��
	 * @return resourcePoolNames ��Դ������
	 */
	public String[] getResourcePoolNames() {
		return resourcePoolNames;
	}

	/**
	 * ��������ȡ��
	 * @return prid ��������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ������Ŀ�����趨
	 * @param pid ������Ŀ����
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * ����������������趨
	 * @param hostNames ���������������
	 */
	public void setHostNames(String[] hostNames) {
		this.hostNames = hostNames;
	}

	/**
	 * �������趨
	 * @param networkNames ������
	 */
	public void setNetworkNames(String[] networkNames) {
		this.networkNames = networkNames;
	}

	/**
	 * ��������趨
	 * @param vmids �������
	 */
	public void setVmids(String[] vmids) {
		this.vmids = vmids;
	}

	/**
	 * vCloud�����趨
	 * @param vcid vCloud����
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * ����IP�趨
	 * @param hostip ����IP
	 */
	public void setHostip(String hostip) {
		this.hostip = hostip;
	}

	/**
	 * �������������趨
	 * @param datacenterNames ������������
	 */
	public void setDatacenterNames(String[] datacenterNames) {
		this.datacenterNames = datacenterNames;
	}

	/**
	 * ��Դ�������趨
	 * @param resourcePoolNames ��Դ������
	 */
	public void setResourcePoolNames(String[] resourcePoolNames) {
		this.resourcePoolNames = resourcePoolNames;
	}

	/**
	 * ���������趨
	 * @param prid ��������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
}
