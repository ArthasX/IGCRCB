/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: �����¼��ϸҳ���ѯform
 * ���������������¼��ϸҳ���ѯform
 * �����ˣ�����
 * ������¼�� 2012-7-13
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGASM2502Form extends BaseForm implements Serializable{

	/** �����̱�� */
	protected String eiid_q;
	
	/** �����¼��ʼʱ�� */
	protected String beginTime;
	
	/** �����¼����ʱ�� */
	protected String endTime;

	/** �����¼���� */
	protected String einame;
	
	/** �����¼��� */
	protected String eilabel;

	/** �����¼�Ǽ�ʱ�� */
	protected String eiinsdate;

	/** �������� */
	protected String civalue;

	/** �������� */
	protected String civalue1;

	/** �������� */
	protected String civalue2;

	/** �������� */
	protected Double civalue3;

	/**
	 * ��ȡeiid_q
	 * @return feiid_q eiid_q
	 */
	public String getEiid_q() {
		return eiid_q;
	}

	/**
	 * ����eiid_q
	 * @param eiid_q  eiid_q
	 */
	public void setEiid_q(String eiid_q) {
		this.eiid_q = eiid_q;
	}

	/**
	 * ��ȡbeginTime_q
	 * @return fbeginTime_q beginTime_q
	 */
	public String getBeginTime() {
		return beginTime;
	}

	/**
	 * ����beginTime_q
	 * @param beginTime_q  beginTime_q
	 */
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * ��ȡendTime_q
	 * @return fendTime_q endTime_q
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * ����endTime_q
	 * @param endTime_q  endTime_q
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * ��ȡeiname
	 * @return feiname einame
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ����einame
	 * @param einame  einame
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ��ȡeilabel
	 * @return feilabel eilabel
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ����eilabel
	 * @param eilabel  eilabel
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * ��ȡeiinsdate
	 * @return feiinsdate eiinsdate
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * ����eiinsdate
	 * @param eiinsdate  eiinsdate
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * ��ȡcivalue
	 * @return fcivalue civalue
	 */
	public String getCivalue() {
		return civalue;
	}

	/**
	 * ����civalue
	 * @param civalue  civalue
	 */
	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	/**
	 * ��ȡcivalue1
	 * @return fcivalue1 civalue1
	 */
	public String getCivalue1() {
		return civalue1;
	}

	/**
	 * ����civalue1
	 * @param civalue1  civalue1
	 */
	public void setCivalue1(String civalue1) {
		this.civalue1 = civalue1;
	}

	/**
	 * ��ȡcivalue2
	 * @return fcivalue2 civalue2
	 */
	public String getCivalue2() {
		return civalue2;
	}

	/**
	 * ����civalue2
	 * @param civalue2  civalue2
	 */
	public void setCivalue2(String civalue2) {
		this.civalue2 = civalue2;
	}

	/**
	 * ��ȡcivalue3
	 * @return fcivalue3 civalue3
	 */
	public Double getCivalue3() {
		return civalue3;
	}

	/**
	 * ����civalue3
	 * @param civalue3  civalue3
	 */
	public void setCivalue3(Double civalue3) {
		this.civalue3 = civalue3;
	}
	
}
