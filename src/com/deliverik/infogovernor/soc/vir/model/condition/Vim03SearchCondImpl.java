/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

import java.util.List;

/**
  * ����: ��Դ���������Ϣ���������ʵ��
  * ��������: ��Դ���������Ϣ���������ʵ��
  * ������¼: 2014/02/13
  * �޸ļ�¼: 
  */
public class Vim03SearchCondImpl implements Vim03SearchCond {

    /** ��Ŀ���� */
    protected Integer pid_eq;
    
    /** �û�id */
    protected String userid_eq;
    
	/** �Զ�������� */
	protected String progress_eq;
	
    /** ��������� */
    protected String orgsyscoding_eq;

    /** δ���� */
    protected boolean progressIsNull = false;
    
    /** �������� */
    protected Integer prid;
    
    /** ״̬ */
    protected String status;
    
    /** ����ID */
    protected Integer vcid;
    
    /** �������� */
    protected String hostname;
    
    /** ״̬ */
    protected String status_nq;
    
    /** ����ID���� */
    protected List<Integer> prid_in;
    
    /** ������� */
    protected String vmName;
    
    /**
     * ��ȡ��Ŀ����
     * @return ��Ŀ���� 
     */
    public Integer getPid_eq() {
        return pid_eq;
    }

    /**
     * ������Ŀ����
     * @param pid_eq ��Ŀ����
     */
    public void setPid_eq(Integer pid_eq) {
        this.pid_eq = pid_eq;
    }

	/**
	 * �û�idȡ��
	 * @return userid_eq �û�id
	 */
	public String getUserid_eq() {
		return userid_eq;
	}

	/**
	 * �û�id�趨
	 * @param userid_eq �û�id
	 */
	public void setUserid_eq(String userid_eq) {
		this.userid_eq = userid_eq;
	}

	/**
	 * �Զ��������ȡ��
	 * @return progress_eq �Զ��������
	 */
	public String getProgress_eq() {
		return progress_eq;
	}

	/**
	 * �Զ���������趨
	 * @param progress_eq �Զ��������
	 */
	public void setProgress_eq(String progress_eq) {
		this.progress_eq = progress_eq;
	}

	/**
	 * ���������ȡ��
	 * @return orgsyscoding_eq ���������
	 */
	public String getOrgsyscoding_eq() {
		return orgsyscoding_eq;
	}

	/**
	 * ����������趨
	 * @param orgsyscoding_eq ���������
	 */
	public void setOrgsyscoding_eq(String orgsyscoding_eq) {
		this.orgsyscoding_eq = orgsyscoding_eq;
	}

    /**
     * ��ȡδ����
     * @return δ���� 
     */
    public boolean isProgressIsNull() {
        return progressIsNull;
    }

    /**
     * ����δ����
     * @param progressIsNull δ����
     */
    public void setProgressIsNull(boolean progressIsNull) {
        this.progressIsNull = progressIsNull;
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

	/**
	 * ����IDȡ��
	 * @return vcid ����ID
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * ����ID�趨
	 * @param vcid ����ID
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * ��������ȡ��
	 * @return hostname ��������
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * ���������趨
	 * @param hostname ��������
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	/**
	 * ״̬ȡ��
	 * @return status_nq ״̬
	 */
	public String getStatus_nq() {
		return status_nq;
	}

	/**
	 * ״̬�趨
	 * @param status_nq ״̬
	 */
	public void setStatus_nq(String status_nq) {
		this.status_nq = status_nq;
	}

	/**
	 * ����ID����ȡ��
	 * @return prid_in ����ID����
	 */
	public List<Integer> getPrid_in() {
		return prid_in;
	}

	/**
	 * ����ID�����趨
	 * @param prid_in ����ID����
	 */
	public void setPrid_in(List<Integer> prid_in) {
		this.prid_in = prid_in;
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
}