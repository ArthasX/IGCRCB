/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: �����¼ͳ��ҳ���ѯform
 * ���������������¼ͳ��ҳ���ѯform
 * �����ˣ�����
 * ������¼�� 2012-7-12
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGASM2501Form extends BaseForm implements Serializable{

	/** ���������� */
	protected String einame_like;
	
	/** �����¼��ʼʱ�� */
	protected String beginTime_q;
	
	/** �����¼����ʱ�� */
	protected String endTime_q;

	protected Integer eiid;

	/** ���������� */
	protected String einame;

	/** �豸�ʲ� */
	protected String civalue;

	/** �豸�ʲ����� */
	protected String civalue1;

	/** Ӧ���ʲ� */
	protected String civalue2;

	/** Ӧ���ʲ����� */
	protected String civalue3;

	/** ��ѵ��¼ */
	protected String einame3;

	/** ��ѵ��¼���� */
	protected String civalue4;
	
	/** �ϼƴ��� */
	protected Integer sumcount;
	
	/** �ϼ�ƽ���� */
	protected Double sumstore;
	
	/**
	 * ��ȡeiname_like
	 * @return feiname_like einame_like
	 */
	public String getEiname_like() {
		return einame_like;
	}

	/**
	 * ����einame_like
	 * @param einame_like  einame_like
	 */
	public void setEiname_like(String einame_like) {
		this.einame_like = einame_like;
	}

	/**
	 * ��ȡbeginTime_q
	 * @return fbeginTime_q beginTime_q
	 */
	public String getBeginTime_q() {
		return beginTime_q;
	}

	/**
	 * ����beginTime_q
	 * @param beginTime_q  beginTime_q
	 */
	public void setBeginTime_q(String beginTime_q) {
		this.beginTime_q = beginTime_q;
	}

	/**
	 * ��ȡendTime_q
	 * @return fendTime_q endTime_q
	 */
	public String getEndTime_q() {
		return endTime_q;
	}

	/**
	 * ����endTime_q
	 * @param endTime_q  endTime_q
	 */
	public void setEndTime_q(String endTime_q) {
		this.endTime_q = endTime_q;
	}
	/**
	 * ��ȡeiid
	 * @return feiid eiid
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ����eiid
	 * @param eiid  eiid
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
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
	public String getCivalue3() {
		return civalue3;
	}

	/**
	 * ����civalue3
	 * @param civalue3  civalue3
	 */
	public void setCivalue3(String civalue3) {
		this.civalue3 = civalue3;
	}

	/**
	 * ��ȡeiname3
	 * @return feiname3 einame3
	 */
	public String getEiname3() {
		return einame3;
	}

	/**
	 * ����einame3
	 * @param einame3  einame3
	 */
	public void setEiname3(String einame3) {
		this.einame3 = einame3;
	}

	/**
	 * ��ȡcivalue4
	 * @return fcivalue4 civalue4
	 */
	public String getCivalue4() {
		return civalue4;
	}

	/**
	 * ����civalue4
	 * @param civalue4  civalue4
	 */
	public void setCivalue4(String civalue4) {
		this.civalue4 = civalue4;
	}

	/**
	 * ��ȡsumcount
	 * @return fsumcount sumcount
	 */
	public Integer getSumcount() {
		return sumcount;
	}

	/**
	 * ����sumcount
	 * @param sumcount  sumcount
	 */
	public void setSumcount(Integer sumcount) {
		this.sumcount = sumcount;
	}

	/**
	 * ��ȡsumstore
	 * @return fsumstore sumstore
	 */
	public Double getSumstore() {
		return sumstore;
	}

	/**
	 * ����sumstore
	 * @param sumstore  sumstore
	 */
	public void setSumstore(Double sumstore) {
		this.sumstore = sumstore;
	}
	
	
}
