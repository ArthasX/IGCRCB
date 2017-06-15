/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: ��ͬ�ʲ���Ϣ��ͼ��������ʵ��
  * ��������: ��ͬ�ʲ���Ϣ��ͼ��������ʵ��
  * ������¼: 2012/04/10
  * �޸ļ�¼: 
  */
public class IG499SearchCondImpl implements
		IG499SearchCond {
	
	/** ��ͬ��� */
	protected String compacttype;
	
	/** ǩ��ʱ�� */
	protected String condudetime;
	
	/** ������ */
	protected String facilitator;
	
	/** ������ */
	protected String operator;
	
	/** ��ͬ���� */
	protected String einame;
	
	/** ��ͬ��� */
	protected String eilabel;
	
	/** ��ѯʱ��� */
	protected String datetime;
	
	/** ǩ��ʱ��:�� */
	protected String condudetime_from;
	
	/** ǩ��ʱ��:�� */
	protected String condudetime_to;
	
	protected String eiid;

	/** �Ƿ񸶿���� */
	protected String payed;//1:�ǣ�0����
	
	/** ���������� */
	protected String eiorgsyscoding_in;
	
	protected String eiusername;
	
	/** �ʲ�ģ���� */
    protected String ename;
    
	/** �ʲ�������ģ��*/
    public String esyscoding;
	/**
	 * ��ͬ���ȡ��
	 * @return ��ͬ���
	 */
	public String getCompacttype() {
		return compacttype;
	}

	/**
	 * ��ͬ����趨
	 * @param compacttype��ͬ���
	 */
	public void setCompacttype(String compacttype) {
		this.compacttype = compacttype;
	}

	/**
	 * ǩ��ʱ��ȡ��
	 * @return ǩ��ʱ��
	 */
	public String getCondudetime() {
		return condudetime;
	}

	/**
	 * ǩ��ʱ���趨
	 * @param condudetimeǩ��ʱ��
	 */
	public void setCondudetime(String condudetime) {
		this.condudetime = condudetime;
	}

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getFacilitator() {
		return facilitator;
	}

	/**
	 * �������趨
	 * @param facilitator������
	 */
	public void setFacilitator(String facilitator) {
		this.facilitator = facilitator;
	}

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * �������趨
	 * @param operator������
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * ��ͬ����ȡ��
	 * @return ��ͬ����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ��ͬ�����趨
	 * @param einame��ͬ����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ��ͬ���ȡ��
	 * @return ��ͬ���
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ��ͬ����趨
	 * @param eilabel��ͬ���
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * ��ѯʱ���ȡ��
	 * @return ��ѯʱ���
	 */
	public String getDatetime() {
		return datetime;
	}

	/**
	 * ��ѯʱ����趨
	 * @param datetime��ѯʱ���
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	/**
	 * ǩ��ʱ��:��ȡ��
	 * @return ǩ��ʱ��:��
	 */
	public String getCondudetime_from() {
		return condudetime_from;
	}

	/**
	 * ǩ��ʱ��:���趨
	 * @param condudetime_fromǩ��ʱ��:��
	 */
	public void setCondudetime_from(String condudetime_from) {
		this.condudetime_from = condudetime_from;
	}

	/**
	 * ǩ��ʱ��:��ȡ��
	 * @return ǩ��ʱ��:��
	 */
	public String getCondudetime_to() {
		return condudetime_to;
	}

	/**
	 * ǩ��ʱ��:���趨
	 * @param condudetime_toǩ��ʱ��:��
	 */
	public void setCondudetime_to(String condudetime_to) {
		this.condudetime_to = condudetime_to;
	}

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	public String getPayed() {
		return payed;
	}

	public void setPayed(String payed) {
		this.payed = payed;
	}

	/**
	 * �����������ȡ
	 * @return eiorgsyscoding_in
	 */
	public String getEiorgsyscoding_in() {
		return eiorgsyscoding_in;
	}

	/**
	 * �����������趨
	 * @param eiorgsyscoding_in
	 */
	public void setEiorgsyscoding_in(String eiorgsyscoding_in) {
		this.eiorgsyscoding_in = eiorgsyscoding_in;
	}
	
	
	/**
	 * eiusernameȡ��
	 *
	 * @return eiusername eiusername
	 */
	public String getEiusername() {
		return eiusername;
	}

	/**
	 * eiusername�趨
	 *
	 * @param eiusername eiusername
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

    /**
     * �ʲ�ģ����ȡ��
     *
     * @return ename �ʲ�ģ����
     */
    public String getEname() {
        return ename;
    }

    /**
     * �ʲ�������ģ��ȡ��
     *
     * @return esyscoding �ʲ�������ģ��
     */
    public String getEsyscoding() {
        return esyscoding;
    }

    /**
     * �ʲ�ģ�����趨
     *
     * @param ename �ʲ�ģ����
     */
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**
     * �ʲ�������ģ���趨
     *
     * @param esyscoding �ʲ�������ģ��
     */
    public void setEsyscoding(String esyscoding) {
        this.esyscoding = esyscoding;
    }

}