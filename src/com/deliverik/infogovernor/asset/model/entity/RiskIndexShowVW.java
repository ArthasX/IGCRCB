/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.asset.model.RiskIndexShowVWInfo;

/**
  * ����: ����ָ��չʾ��ѯʵ��
  * ��������: ����ָ��չʾ��ѯʵ��
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RiskIndexShowVW")
public class RiskIndexShowVW extends BaseEntity implements Serializable,
		Cloneable, RiskIndexShowVWInfo {

	/** �������� */
	@Id
	protected String esyscoding;

	/** ���� */
	protected String risknum;

	/** �������� */
	protected String risk;

	/** �������� */
	protected String riskly;

	/** �������� */
	protected String riskarea;

	/** ������ */
	protected String riskitem;

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * ���������趨
	 *
	 * @param esyscoding ��������
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getRisknum() {
		return risknum;
	}

	/**
	 * �����趨
	 *
	 * @param risknum ����
	 */
	public void setRisknum(String risknum) {
		this.risknum = risknum;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRisk() {
		return risk;
	}

	/**
	 * ���������趨
	 *
	 * @param risk ��������
	 */
	public void setRisk(String risk) {
		this.risk = risk;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRiskly() {
		return riskly;
	}

	/**
	 * ���������趨
	 *
	 * @param riskly ��������
	 */
	public void setRiskly(String riskly) {
		this.riskly = riskly;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRiskarea() {
		return riskarea;
	}

	/**
	 * ���������趨
	 *
	 * @param riskarea ��������
	 */
	public void setRiskarea(String riskarea) {
		this.riskarea = riskarea;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getRiskitem() {
		return riskitem;
	}

	/**
	 * �������趨
	 *
	 * @param riskitem ������
	 */
	public void setRiskitem(String riskitem) {
		this.riskitem = riskitem;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return esyscoding;
	}

}