/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0208Info;

/**
  * ����: �¼��������Ч��ʵ��
  * ��������: �¼��������Ч��ʵ��
  * ������¼: 2011/11/23
  * �޸ļ�¼: 2012/08/09 ��ServeEfficiencyTB������ΪSOC0208TB
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0208PK.class)
@Table(name="SOC0208")
public class SOC0208TB extends BaseEntity implements Serializable,
		Cloneable, SOC0208Info {

	/** �������� */
	@Id
	protected String prtype;

	/** ������Դ */
	@Id
	protected String pivaralue;

	/** ʱ�� */
	@Id
	protected String efficiencyTime;

	/** ��ǰ�·���Ч�� */
	protected String monthEfficiency;

	/** ��ʷ����Ч�� */
	protected String historyEfficiency;

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

	/**
	 * ��ǰ�·���Ч��ȡ��
	 *
	 * @return ��ǰ�·���Ч��
	 */
	public String getMonthEfficiency() {
		return monthEfficiency;
	}

	/**
	 * ��ǰ�·���Ч���趨
	 *
	 * @param monthEfficiency ��ǰ�·���Ч��
	 */
	public void setMonthEfficiency(String monthEfficiency) {
		this.monthEfficiency = monthEfficiency;
	}

	/**
	 * ��ʷ����Ч��ȡ��
	 *
	 * @return ��ʷ����Ч��
	 */
	public String getHistoryEfficiency() {
		return historyEfficiency;
	}

	/**
	 * ��ʷ����Ч���趨
	 *
	 * @param historyEfficiency ��ʷ����Ч��
	 */
	public void setHistoryEfficiency(String historyEfficiency) {
		this.historyEfficiency = historyEfficiency;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new SOC0208PK(prtype, pivaralue, efficiencyTime);
	}

}