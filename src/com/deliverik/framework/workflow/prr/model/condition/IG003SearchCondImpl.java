/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>����:������Ȼ���ͳ�Ʋ�ѯ����ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public class IG003SearchCondImpl implements IG003SearchCond {
	
	/** ��ǰ���*/
	protected String currentyear;
	
	/** ȥ�����*/
	protected String precedingyear;

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
	 * ���ܣ���ǰ���ȡ��
	 * @return currentyear ��ǰ���
	 */
	public String getCurrentyear() {
		return currentyear;
	}

	/**
	 * ���ܣ���ǰ���ȡ��
	 * @param currentyear ��ǰ���
	 */
	public void setCurrentyear(String currentyear) {
		this.currentyear = currentyear;
	}

	/**
	 * ���ܣ���һ�����ȡ��
	 * @return precedingyear ��һ�����
	 */
	public String getPrecedingyear() {
		return precedingyear;
	}

	/**
	 * ���ܣ���һ�����ȡ��
	 * @param precedingyear ��һ�����
	 */
	public void setPrecedingyear(String precedingyear) {
		this.precedingyear = precedingyear;
	}
	
}
