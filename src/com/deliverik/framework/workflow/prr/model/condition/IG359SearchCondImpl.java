/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>����:����ʲ�����ͳ�ƻ���ͳ�Ʋ�ѯ����ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public class IG359SearchCondImpl implements IG359SearchCond {

	/** �ʲ����̱���*/
	protected String prassetcategory;

	/** ͳ�Ʋ�ѯʱ��_��*/
	protected String propentime_from;

	/** ͳ�Ʋ�ѯʱ��_��*/
	protected String propentime_to;

	/** �¼�ͳ��ģ��id*/
	protected String ipdid;
	/** ����ͳ��ģ��id*/
	protected String ppdid;
	/** ���ͳ��ģ��id*/
	protected String cpdid;
	/** ��������ͳ��ģ��id*/
	protected String spdid;

	/**
	 * ���ܣ�����ʲ����̱���ȡ��
	 * @return prassetcategory
	 */
	public String getPrassetcategory() {
		return prassetcategory;
	}

	/**
	 * ���ܣ�����ʲ����̱����趨
	 * @param prassetcategory ����ʲ����̱���
	 */
	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	/**
	 * ���ܣ�ͳ�Ʋ�ѯʱ��_��ȡ��
	 * @return propentime_from ͳ�Ʋ�ѯʱ��_��
	 */
	public String getPropentime_from() {
		return propentime_from;
	}

	/**
	 * ���ܣ�ͳ�Ʋ�ѯʱ��_���趨
	 * @param propentime_from ͳ�Ʋ�ѯʱ��_��
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}

	/**
	 * ���ܣ�ͳ�Ʋ�ѯʱ��_��ȡ��
	 * @return propentime_to ͳ�Ʋ�ѯʱ��_��
	 */
	public String getPropentime_to() {
		return propentime_to;
	}

	/**
	 * ���ܣ�ͳ�Ʋ�ѯʱ��_���趨
	 * @param propentime_to ͳ�Ʋ�ѯʱ��_��
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}

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
	
	
}
