/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.IG499SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * ����: ��ͬͳ��Form
 * ��������: ��ͬͳ��Form
 * ������¼: 2013/06/22
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM0424Form extends BaseForm implements IG499SearchCond{
	
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
	
	/** ��ѯʱ��:�� */
	protected String time_from;
	
	/** ��ѯʱ��:�� */
	protected String time_to;
	
	public String getTime_from() {
		return time_from;
	}

	public void setTime_from(String time_from) {
		this.time_from = time_from;
	}

	public String getTime_to() {
		return time_to;
	}

	public void setTime_to(String time_to) {
		this.time_to = time_to;
	}

	/** �Ƿ񸶿���� */
	protected String payed;//1:�ǣ�0����

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
		// TODO Auto-generated method stub
		return null;
	}

	public String getPayed() {
		return payed;
	}

	public void setPayed(String payed) {
		this.payed = payed;
	}

	public String getEiorgsyscoding_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiusername() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEiorgsyscoding_in(String arg0) {
		// TODO Auto-generated method stub
		
	}

    /* (non-Javadoc)
     * @see com.deliverik.framework.asset.model.condition.IG499SearchCond#getEname()
     */
    public String getEname() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.deliverik.framework.asset.model.condition.IG499SearchCond#getEsyscoding()
     */
    public String getEsyscoding() {
        // TODO Auto-generated method stub
        return null;
    }
}
