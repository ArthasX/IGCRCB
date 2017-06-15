/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.rpt.model.SOC0209Info;

/**
  * ����: ������Դ��ͼʵ��
  * ��������: ������Դ��ͼʵ��
  * ������¼: 2011/11/24
  * �޸ļ�¼: 2012/08/09 ��ProcessRecordInfoVW������ΪSOC0209VW
  */
@SuppressWarnings("serial")
@Entity
public class SOC0209VW implements Serializable,
		Cloneable, SOC0209Info {

	/** ����ID */
	@Id
	protected Integer prid;

	/** �������� */
	protected String prtype;

	/** ������Դ */
	protected String pivarvalue;

	/** ���̷���ʱ�� */
	protected String propentime;

	/** ���̴�����ʱ */
	protected Integer prfacttime;

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ���������趨
	 *
	 * @param prtype ��������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ������Դȡ��
	 *
	 * @return ������Դ
	 */
	public String getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * ������Դ�趨
	 *
	 * @param pivarvalue ������Դ
	 */
	public void setPivarvalue(String pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * ���̷���ʱ��ȡ��
	 *
	 * @return ���̷���ʱ��
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * ���̷���ʱ���趨
	 *
	 * @param propentime ���̷���ʱ��
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * ���̴�����ʱȡ��
	 *
	 * @return ���̴�����ʱ
	 */
	public Integer getPrfacttime() {
		return prfacttime;
	}

	/**
	 * ���̴�����ʱ�趨
	 *
	 * @param prfacttime ���̴�����ʱ
	 */
	public void setPrfacttime(Integer prfacttime) {
		this.prfacttime = prfacttime;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return prid;
	}

}