/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0202Info;

/**
  * ����: ���ӱ���ʵ��
  * ��������: ���ӱ���ʵ��
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/09 ��ReportAnnexationTB������ΪSOC0202TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0202")
public class SOC0202TB extends BaseEntity implements Serializable,
		Cloneable, SOC0202Info {

	/** ����ID */
	@Id
	@TableGenerator(
		name="REPORTANNEXATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="REPORTANNEXATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REPORTANNEXATION_TABLE_GENERATOR")
	protected Integer raId;

	/** ���ӱ������� */
	protected String raName;

	/** �洢���к� */
	protected String raSsn;

	/** kpi */
	protected String raKpi;

	/** ����ʱ�� */
	protected String raCreateDate;

	/**�û�����*/
	protected String raUserName;
	/**Word�ĵ�����*/
	protected String raRealName;
	/**�Ƿ�ʹ��*/
	@Transient
	protected String isUsed;
	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getRaId() {
		return raId;
	}

	/**
	 * ����ID�趨
	 *
	 * @param raId ����ID
	 */
	public void setRaId(Integer raId) {
		this.raId = raId;
	}

	
	/**
	 * ���ӱ�������ȡ��
	 *
	 * @return raName ���ӱ�������
	 */
	public String getRaName() {
		return raName;
	}

	/**
	 * ���ӱ��������趨
	 *
	 * @param raName ���ӱ�������
	 */
	public void setRaName(String raName) {
		this.raName = raName;
	}

	/**
	 * �洢���к�ȡ��
	 *
	 * @return raSsn �洢���к�
	 */
	public String getRaSsn() {
		return raSsn;
	}

	/**
	 * �洢���к��趨
	 *
	 * @param raSsn �洢���к�
	 */
	public void setRaSsn(String raSsn) {
		this.raSsn = raSsn;
	}

	/**
	 * kpiȡ��
	 *
	 * @return raKpi kpi
	 */
	public String getRaKpi() {
		return raKpi;
	}

	/**
	 * kpi�趨
	 *
	 * @param raKpi kpi
	 */
	public void setRaKpi(String raKpi) {
		this.raKpi = raKpi;
	}


	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return raId;
	}

	/**
	 * �û�����ȡ��
	 *
	 * @return raUserName �û�����
	 */
	public String getRaUserName() {
		return raUserName;
	}

	/**
	 * �û������趨
	 *
	 * @param raUserName �û�����
	 */
	public void setRaUserName(String raUserName) {
		this.raUserName = raUserName;
	}

	/**
	 * Word�ĵ�����ȡ��
	 *
	 * @return raRealName Word�ĵ�����
	 */
	public String getRaRealName() {
		return raRealName;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return raCreateDate ����ʱ��
	 */
	public String getRaCreateDate() {
		return raCreateDate;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param raCreateDate ����ʱ��
	 */
	public void setRaCreateDate(String raCreateDate) {
		this.raCreateDate = raCreateDate;
	}

	/**
	 * Word�ĵ������趨
	 *
	 * @param raRealName Word�ĵ�����
	 */
	public void setRaRealName(String raRealName) {
		this.raRealName = raRealName;
	}

	/**
	 * �Ƿ�ʹ��ȡ��
	 *
	 * @return isUsed �Ƿ�ʹ��
	 */
	public String getIsUsed() {
		return isUsed;
	}

	/**
	 * �Ƿ�ʹ���趨
	 *
	 * @param isUsed �Ƿ�ʹ��
	 */
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}



}