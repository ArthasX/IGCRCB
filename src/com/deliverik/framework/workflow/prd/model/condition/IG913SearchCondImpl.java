package com.deliverik.framework.workflow.prd.model.condition;


/**
 * ����ȱʡ����Ȩ����ͼ��������ʵ��
 * 
 */
public class IG913SearchCondImpl implements IG913SearchCond {
	
	/** ����״̬ID */
	protected String psdid;

	/** ��������ID */
	protected String pdid;
	
	/** ��ɫID */
	protected Integer roleid;

	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}
	
	/**
	 * ����״̬ID�趨
	 * @param psdid����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ��������ID�趨
	 * 
	 * @param pdid ��������ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

    /**
     * @return the ��ɫID
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * @param ��ɫID the roleid to set
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
	
}
