/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>����:�¼��ͷ����������̻���ͳ�Ʋ�ѯ����ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public class IG019SearchCondImpl implements
		IG019SearchCond {
	
	/** ���������*/
	protected String orgsyscoding;
	
	/** ���*/
	protected String year;
	
	/** ��������*/
	protected String prtype;
	
	/** �¼�ͳ��ģ��id*/
    protected String ipdid;
    /** ����ͳ��ģ��id*/
    protected String ppdid;
    /** ���ͳ��ģ��id*/
    protected String cpdid;
    /** ��������ͳ��ģ��id*/
    protected String spdid;

	/**
     * �¼�ͳ��ģ��idȡ��
     *
     * @return ipdid �¼�ͳ��ģ��id
     */
    public String getIpdid() {
        return ipdid;
    }

    /**
     * �¼�ͳ��ģ��id�趨
     *
     * @param ipdid �¼�ͳ��ģ��id
     */
    public void setIpdid(String ipdid) {
        this.ipdid = ipdid;
    }

    /**
     * ����ͳ��ģ��idȡ��
     *
     * @return ppdid ����ͳ��ģ��id
     */
    public String getPpdid() {
        return ppdid;
    }

    /**
     * ����ͳ��ģ��id�趨
     *
     * @param ppdid ����ͳ��ģ��id
     */
    public void setPpdid(String ppdid) {
        this.ppdid = ppdid;
    }

    /**
     * ���ͳ��ģ��idȡ��
     *
     * @return cpdid ���ͳ��ģ��id
     */
    public String getCpdid() {
        return cpdid;
    }

    /**
     * ���ͳ��ģ��id�趨
     *
     * @param cpdid ���ͳ��ģ��id
     */
    public void setCpdid(String cpdid) {
        this.cpdid = cpdid;
    }

    /**
     * ��������ͳ��ģ��idȡ��
     *
     * @return spdid ��������ͳ��ģ��id
     */
    public String getSpdid() {
        return spdid;
    }

    /**
     * ��������ͳ��ģ��id�趨
     *
     * @param spdid ��������ͳ��ģ��id
     */
    public void setSpdid(String spdid) {
        this.spdid = spdid;
    }

    /**
	 * ���ܣ����������ȡ��
	 * @retrun Orgsyscoding �����㼶��
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * ���ܣ����������ȡ��
	 * @param orgsyscoding ���������
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * ���ܣ����ȡ��
	 * @return year ���
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ���ܣ����
	 * @param year ���
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * ���ܣ���������
	 * @return prtype ��������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ���ܣ���������
	 * @param prtype ��������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

}
