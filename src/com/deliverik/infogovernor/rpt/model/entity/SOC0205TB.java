/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0205Info;
import com.deliverik.infogovernor.rpt.model.entity.SOC0207TB;

/**
  * ����: ��������ʵ��
  * ��������: ��������ʵ��
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/09 ��ReportManageTB������ΪSOC0205TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0205")
public class SOC0205TB extends BaseEntity implements Serializable,
		Cloneable, SOC0205Info {

	/** ����ID */
	@Id
	@TableGenerator(
		name="REPORTMANAGE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="REPORTMANAGE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REPORTMANAGE_TABLE_GENERATOR")
	protected Integer rmId;

	/** �������� */
	protected String rmName;

	/** �� */
	protected String rmYear;

	/** ���� */
	protected String rmQuarter;

	/** �� */
	protected String rmMonth;
	/** ���� */
	protected String rmDateType;
	/** ���һ�� */
	protected String rmLastDay;
	/**ģ������*/
	protected String rtName;
	/**��׺����*/
	protected String rmSuffix;

	/** ����ʱ�� */
	protected String createDate;
	/**�����Ӹ��ӱ���ʱ��*/
	protected String lastAnnexationDate;
	/**��Ÿ��ӱ���ID,�Զ���Ϊ�ָ���*/
	protected String raStr;
	/**ģ�����*/
	@OneToOne
	@JoinColumn(name="rtId", referencedColumnName = "rtId", updatable = true, insertable = true)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0207TB reportTemplateTB;
	
	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getRmId() {
		return rmId;
	}

	/**
	 * ����ID�趨
	 *
	 * @param rmId ����ID
	 */
	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRmName() {
		return rmName;
	}

	/**
	 * ���������趨
	 *
	 * @param rmName ��������
	 */
	public void setRmName(String rmName) {
		this.rmName = rmName;
	}


	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public String getRmYear() {
		return rmYear;
	}

	/**
	 * ���趨
	 *
	 * @param rmYear ��
	 */
	public void setRmYear(String rmYear) {
		this.rmYear = rmYear;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getRmQuarter() {
		return rmQuarter;
	}

	/**
	 * �����趨
	 *
	 * @param rmQuarter ����
	 */
	public void setRmQuarter(String rmQuarter) {
		this.rmQuarter = rmQuarter;
	}

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public String getRmMonth() {
		return rmMonth;
	}

	/**
	 * ���趨
	 *
	 * @param rmMonth ��
	 */
	public void setRmMonth(String rmMonth) {
		this.rmMonth = rmMonth;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param createDate ����ʱ��
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return rmId;
	}

	/**
	 * ģ�����ȡ��
	 *
	 * @return reportTemplateTB ģ�����
	 */
	public SOC0207TB getReportTemplateTB() {
		return reportTemplateTB;
	}

	/**
	 * ģ������趨
	 *
	 * @param reportTemplateTB ģ�����
	 */
	public void setReportTemplateTB(SOC0207TB reportTemplateTB) {
		this.reportTemplateTB = reportTemplateTB;
	}

	/**
	 * �����Ӹ��ӱ���ʱ��ȡ��
	 *
	 * @return lastAnnexationDate �����Ӹ��ӱ���ʱ��
	 */
	public String getLastAnnexationDate() {
		return lastAnnexationDate;
	}

	/**
	 * �����Ӹ��ӱ���ʱ���趨
	 *
	 * @param lastAnnexationDate �����Ӹ��ӱ���ʱ��
	 */
	public void setLastAnnexationDate(String lastAnnexationDate) {
		this.lastAnnexationDate = lastAnnexationDate;
	}

	/**
	 * ����ȡ��
	 *
	 * @return rmDateType ����
	 */
	public String getRmDateType() {
		return rmDateType;
	}

	/**
	 * �����趨
	 *
	 * @param rmDateType ����
	 */
	public void setRmDateType(String rmDateType) {
		this.rmDateType = rmDateType;
	}

	/**
	 * ���һ��ȡ��
	 *
	 * @return rmLastDay ���һ��
	 */
	public String getRmLastDay() {
		return rmLastDay;
	}

	/**
	 * ���һ���趨
	 *
	 * @param rmLastDay ���һ��
	 */
	public void setRmLastDay(String rmLastDay) {
		this.rmLastDay = rmLastDay;
	}

	/**
	 * ģ������ȡ��
	 *
	 * @return rtName ģ������
	 */
	public String getRtName() {
		return rtName;
	}

	/**
	 * ģ�������趨
	 *
	 * @param rtName ģ������
	 */
	public void setRtName(String rtName) {
		this.rtName = rtName;
	}

	/**
	 * ��Ÿ��ӱ���ID�Զ���Ϊ�ָ���ȡ��
	 *
	 * @return raStr ��Ÿ��ӱ���ID�Զ���Ϊ�ָ���
	 */
	public String getRaStr() {
		return raStr;
	}

	/**
	 * ��Ÿ��ӱ���ID�Զ���Ϊ�ָ����趨
	 *
	 * @param raStr ��Ÿ��ӱ���ID�Զ���Ϊ�ָ���
	 */
	public void setRaStr(String raStr) {
		this.raStr = raStr;
	}

	/**
	 * ��׺����ȡ��
	 *
	 * @return rmSuffix ��׺����
	 */
	public String getRmSuffix() {
		return rmSuffix;
	}

	/**
	 * ��׺�����趨
	 *
	 * @param rmSuffix ��׺����
	 */
	public void setRmSuffix(String rmSuffix) {
		this.rmSuffix = rmSuffix;
	}
	
	

}