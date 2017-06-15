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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0206Info;

/**
  * ����: ģ��ӳ���ʵ��
  * ��������: ģ��ӳ���ʵ��
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/09 ��ReportTemplateMappingTB������ΪSOC0206TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0206")
public class SOC0206TB extends BaseEntity implements Serializable,
		Cloneable, SOC0206Info {

	/** ��ˮID */
	@Id
	@TableGenerator(
		name="REPORTTEMPLATEMAPPING_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="REPORTTEMPLATEMAPPING_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REPORTTEMPLATEMAPPING_TABLE_GENERATOR")
	protected Integer rtmId;

	/** ģ��λ����� */
	protected Integer rtNumber;

	/** �洢���к� */
	protected String rtmSsn;
	
	/** ��ʶ */
	protected String rtmFlag;
	/** �Ƿ����� */
	protected String rtmUsed;
	/** �洢���� */
	protected String rtmSsnType;
	/** KPI */
	protected String rtmKpi;
	
	/** Word�ĵ�����ͼƬλ�� */
	protected Integer rtmImgNumber;
	/**ģ��id*/
	protected Integer rtId;
	/**��Ӧģ��*/
	@ManyToOne
	@JoinColumn(name="rtId", referencedColumnName="rtId",updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)

	protected SOC0207TB reportTemplateTB;
	/**
	 * ��ˮIDȡ��
	 *
	 * @return ��ˮID
	 */
	public Integer getRtmId() {
		return rtmId;
	}

	/**
	 * ��ˮID�趨
	 *
	 * @param rtmId ��ˮID
	 */
	public void setRtmId(Integer rtmId) {
		this.rtmId = rtmId;
	}

	/**
	 * ģ��λ�����ȡ��
	 *
	 * @return ģ��λ�����
	 */
	public Integer getRtNumber() {
		return rtNumber;
	}

	/**
	 * ģ��λ������趨
	 *
	 * @param rtNumber ģ��λ�����
	 */
	public void setRtNumber(Integer rtNumber) {
		this.rtNumber = rtNumber;
	}

	/**
	 * �洢���к�ȡ��
	 *
	 * @return �洢���к�
	 */
	public String getRtmSsn() {
		return rtmSsn;
	}

	/**
	 * �洢���к��趨
	 *
	 * @param rtmSsn �洢���к�
	 */
	public void setRtmSsn(String rtmSsn) {
		this.rtmSsn = rtmSsn;
	}

	/**
	 * KPIȡ��
	 *
	 * @return KPI
	 */
	public String getRtmKpi() {
		return rtmKpi;
	}

	/**
	 * KPI�趨
	 *
	 * @param rtmKpi KPI
	 */
	public void setRtmKpi(String rtmKpi) {
		this.rtmKpi = rtmKpi;
	}

	/**
	 * Word�ĵ�����ͼƬλ��ȡ��
	 *
	 * @return Word�ĵ�����ͼƬλ��
	 */
	public Integer getRtmImgNumber() {
		return rtmImgNumber;
	}

	/**
	 * Word�ĵ�����ͼƬλ���趨
	 *
	 * @param rtmImgNumber Word�ĵ�����ͼƬλ��
	 */
	public void setRtmImgNumber(Integer rtmImgNumber) {
		this.rtmImgNumber = rtmImgNumber;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return rtmId;
	}

	/**
	 * ��Ӧģ��ȡ��
	 *
	 * @return reportTemplateTB ��Ӧģ��
	 */
	public SOC0207TB getReportTemplateTB() {
		return reportTemplateTB;
	}

	/**
	 * ��Ӧģ���趨
	 *
	 * @param reportTemplateTB ��Ӧģ��
	 */
	public void setReportTemplateTB(SOC0207TB reportTemplateTB) {
		this.reportTemplateTB = reportTemplateTB;
	}

	/**
	 * ģ��idȡ��
	 *
	 * @return rtId ģ��id
	 */
	public Integer getRtId() {
		return rtId;
	}

	/**
	 * ģ��id�趨
	 *
	 * @param rtId ģ��id
	 */
	public void setRtId(Integer rtId) {
		this.rtId = rtId;
	}

	/**
	 * ��ʶȡ��
	 *
	 * @return rtmFlag ��ʶ
	 */
	public String getRtmFlag() {
		return rtmFlag;
	}

	/**
	 * ��ʶ�趨
	 *
	 * @param rtmFlag ��ʶ
	 */
	public void setRtmFlag(String rtmFlag) {
		this.rtmFlag = rtmFlag;
	}

	/**
	 * �Ƿ�����ȡ��
	 *
	 * @return rtmUsed �Ƿ�����
	 */
	public String getRtmUsed() {
		return rtmUsed;
	}

	/**
	 * �Ƿ������趨
	 *
	 * @param rtmUsed �Ƿ�����
	 */
	public void setRtmUsed(String rtmUsed) {
		this.rtmUsed = rtmUsed;
	}

	/**
	 * �洢����ȡ��
	 *
	 * @return rtmSsnType �洢����
	 */
	public String getRtmSsnType() {
		return rtmSsnType;
	}

	/**
	 * �洢�����趨
	 *
	 * @param rtmSsnType �洢����
	 */
	public void setRtmSsnType(String rtmSsnType) {
		this.rtmSsnType = rtmSsnType;
	}
	
}