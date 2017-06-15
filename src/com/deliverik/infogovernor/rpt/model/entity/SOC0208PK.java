/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: �¼��������Ч��ʵ������
  * ��������: �¼��������Ч��ʵ������
  * ������¼: 2011/11/23
  * �޸ļ�¼: 2012/08/09 ��ServeEfficiencyPK������ΪSOC0208PK
  */
@SuppressWarnings("serial")
public class SOC0208PK extends BasePK implements Serializable {

	/** �������� */
	protected String prtype;

	/** ������Դ */
	protected String pivaralue;

	/** ʱ�� */
	protected String efficiencyTime;

	/**
	 * ���캯��
	 */
	public SOC0208PK() {

	}

	/**
	 * ���캯��
	 */
	public SOC0208PK(String prtype, String pivaralue, String efficiencyTime) {
		super();
		this.prtype = prtype;
		this.pivaralue = pivaralue;
		this.efficiencyTime = efficiencyTime;
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
	public String getPivaralue() {
		return pivaralue;
	}

	/**
	 * ������Դ�趨
	 *
	 * @param pivaralue ������Դ
	 */
	public void setPivaralue(String pivaralue) {
		this.pivaralue = pivaralue;
	}

	/**
	 * ʱ��ȡ��
	 *
	 * @return ʱ��
	 */
	public String getEfficiencyTime() {
		return efficiencyTime;
	}

	/**
	 * ʱ���趨
	 *
	 * @param efficiencyTime ʱ��
	 */
	public void setEfficiencyTime(String efficiencyTime) {
		this.efficiencyTime = efficiencyTime;
	}

}