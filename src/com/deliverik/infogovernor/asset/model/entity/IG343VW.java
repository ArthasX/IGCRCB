/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.infogovernor.asset.model.IG343Info;

/**
  * ����: IG343VWʵ��
  * ��������: IG343VWʵ��
  * ������¼: 2012/07/12
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class IG343VW implements Serializable, Cloneable, IG343Info {

	@Id
	protected Integer eiid;

	/** ���������� */
	protected String einame;

	/** �豸�ʲ� */
	protected Integer civalue;

	/** �豸�ʲ����� */
	protected Double civalue1;

	/** Ӧ���ʲ� */
	protected Integer civalue2;

	/** Ӧ���ʲ����� */
	protected Double civalue3;

	/** ��ѵ��¼ */
	protected Integer einame3;

	/** ��ѵ��¼���� */
	protected Double civalue4;
	
	/** �ϼƴ��� */
	protected Integer sumcount;
	
	/** �ϼ�ƽ���� */
	protected Double sumstore;

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ������id�趨
	 *
	 * @param eiid ������id
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �����������趨
	 *
	 * @param einame ����������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �豸�ʲ�ȡ��
	 *
	 * @return �豸�ʲ�
	 */
	public Integer getCivalue() {
		return civalue;
	}

	/**
	 * �豸�ʲ��趨
	 *
	 * @param civalue �豸�ʲ�
	 */
	public void setCivalue(Integer civalue) {
		this.civalue = civalue;
	}

	/**
	 * �豸�ʲ�����ȡ��
	 *
	 * @return �豸�ʲ�����
	 */
	public Double getCivalue1() {
		return civalue1;
	}

	/**
	 * �豸�ʲ������趨
	 *
	 * @param civalue1 �豸�ʲ�����
	 */
	public void setCivalue1(Double civalue1) {
		this.civalue1 = civalue1;
	}

	/**
	 * Ӧ���ʲ�ȡ��
	 *
	 * @return Ӧ���ʲ�
	 */
	public Integer getCivalue2() {
		return civalue2;
	}

	/**
	 * Ӧ���ʲ��趨
	 *
	 * @param civalue2 Ӧ���ʲ�
	 */
	public void setCivalue2(Integer civalue2) {
		this.civalue2 = civalue2;
	}

	/**
	 * Ӧ���ʲ�����ȡ��
	 *
	 * @return Ӧ���ʲ�����
	 */
	public Double getCivalue3() {
		return civalue3;
	}

	/**
	 * Ӧ���ʲ������趨
	 *
	 * @param civalue3 Ӧ���ʲ�����
	 */
	public void setCivalue3(Double civalue3) {
		this.civalue3 = civalue3;
	}

	/**
	 * ��ѵ��¼ȡ��
	 *
	 * @return ��ѵ��¼
	 */
	public Integer getEiname3() {
		return einame3;
	}

	/**
	 * ��ѵ��¼�趨
	 *
	 * @param einame3 ��ѵ��¼
	 */
	public void setEiname3(Integer einame3) {
		this.einame3 = einame3;
	}

	/**
	 * ��ѵ��¼����ȡ��
	 *
	 * @return ��ѵ��¼����
	 */
	public Double getCivalue4() {
		return civalue4;
	}

	/**
	 * ��ѵ��¼�����趨
	 *
	 * @param civalue4 ��ѵ��¼����
	 */
	public void setCivalue4(Double civalue4) {
		this.civalue4 = civalue4;
	}

	/**
	 * ��ȡ�ϼƴ���
	 * @return sumcount
	 */
	public Integer getSumcount() {
		return sumcount;
	}

	/**
	 * ���úϼƴ���
	 * @param sumcount
	 */
	public void setSumcount(Integer sumcount) {
		this.sumcount = sumcount;
	}

	/**
	 * ��ȡ�ϼ�ƽ����
	 * @return sumstore
	 */
	public Double getSumstore() {
		return sumstore;
	}

	/**
	 * ���úϼ�ƽ����
	 * @param sumstore
	 */
	public void setSumstore(Double sumstore) {
		this.sumstore = sumstore;
	}


}