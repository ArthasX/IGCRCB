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
import javax.persistence.Transient;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;

/**
  * ����: ��Դ���������Ϣ��ʵ��
  * ��������: ��Դ���������Ϣ��ʵ��
  * ������¼: 2014/02/13
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="vim03")
public class VIM03TB extends BaseEntity implements Serializable,
		Cloneable, VIM03Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="VIM03_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VIM03_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VIM03_TABLE_GENERATOR")
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
    
    /** CPU���� */
    @Transient
    protected String cpucost;
    
    /** �ڴ���� */
    @Transient
    protected String memcost;
    
    /** Ӳ�̷��� */
    @Transient
    protected String diskcost;
    
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
     * ��ȡ��Ŀ����
     * @return ��Ŀ���� 
     */
    public String getPname() {
        return pname;
    }

    /**
     * ������Ŀ����
     * @param pname ��Ŀ����
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * ��ȡvcenter����
     * @return vcenter���� 
     */
    public Integer getVcid() {
        return vcid;
    }

    /**
     * ����vcenter����
     * @param vcid vcenter����
     */
    public void setVcid(Integer vcid) {
        this.vcid = vcid;
    }

    /**
     * ��ȡvCenter����
     * @return vCenter���� 
     */
    public String getVcName() {
        return vcName;
    }

    /**
     * ����vCenter����
     * @param vcName vCenter����
     */
    public void setVcName(String vcName) {
        this.vcName = vcName;
    }

    /**
	 * ģ������ȡ��
	 *
	 * @return ģ������
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * ģ�������趨
	 *
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
     * ��ȡ�Զ��������
     * @return �Զ�������� 
     */
    public String getProgress() {
        return progress;
    }

    /**
     * �����Զ��������
     * @param progress �Զ��������
     */
    public void setProgress(String progress) {
        this.progress = progress;
    }

    /**
     * ��ȡ������������
     * @return ������������ 
     */
    public String getDatacenterName() {
        return datacenterName;
    }

    /**
     * ����������������
     * @param datacenterName ������������
     */
    public void setDatacenterName(String datacenterName) {
        this.datacenterName = datacenterName;
    }

    /**
     * ��ȡ��Դ������
     * @return ��Դ������ 
     */
    public String getResourcePoolName() {
        return resourcePoolName;
    }

    /**
     * ������Դ������
     * @param resourcePoolName ��Դ������
     */
    public void setResourcePoolName(String resourcePoolName) {
        this.resourcePoolName = resourcePoolName;
    }

    /**
     * ��ȡ���������
     * @return ��������� 
     */
    public String getOrgsyscoding() {
        return orgsyscoding;
    }

    /**
     * ���û��������
     * @param orgsyscoding ���������
     */
    public void setOrgsyscoding(String orgsyscoding) {
        this.orgsyscoding = orgsyscoding;
    }

    /**
     * ��ȡ��������
     * @return �������� 
     */
    public String getOrgname() {
        return orgname;
    }

    /**
     * ���û�������
     * @param orgname ��������
     */
    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    /**
     * ��ȡ�û�id
     * @return �û�id 
     */
    public String getUserid() {
        return userid;
    }

    /**
     * �����û�id
     * @param userid �û�id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * ��ȡ�û�����
     * @return �û����� 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * �����û�����
     * @param userName �û�����
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * ��ȡ����ʱ��
     * @return ����ʱ�� 
     */
    public String getApplyTime() {
        return applyTime;
    }

    /**
     * ��������ʱ��
     * @param applyTime ����ʱ��
     */
    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * ��ȡ����ʱ��
     * @return ����ʱ�� 
     */
    public String getExpiryTime() {
        return expiryTime;
    }

    /**
     * ���õ���ʱ��
     * @param expiryTime ����ʱ��
     */
    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    /**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

	/**
     * ��ȡ������������id
     * @return ������������id 
     */
    public Integer getPrid() {
        return prid;
    }

    /**
     * ����������������id
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

	public String getCpucost() {
		return cpucost;
	}

	public void setCpucost(String cpucost) {
		this.cpucost = cpucost;
	}

	public String getMemcost() {
		return memcost;
	}

	public void setMemcost(String memcost) {
		this.memcost = memcost;
	}

	public String getDiskcost() {
		return diskcost;
	}

	public void setDiskcost(String diskcost) {
		this.diskcost = diskcost;
	}

}