/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0207Info;

/**
  * ����: ����ģ��ʵ��
  * ��������: ����ģ��ʵ��
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/09 ��ReportTemplateTB������ΪSOC0207TB
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0207")
public class SOC0207TB extends BaseEntity implements Serializable,
		Cloneable, SOC0207Info {

	/** ID */
	@Id
	@TableGenerator(
		name="REPORTTEMPLATE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="REPORTTEMPLATE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REPORTTEMPLATE_TABLE_GENERATOR")
	protected Integer rtId;

	/** ģ������ */
	protected String rtName;

	/** ���޸�λ���� */
	protected Integer rtSum;

	/** ʱ������ */
	protected String rtDateType;

	/** ģ����ʵ���� */
	protected String rtRealName;

	/** ģ���ϴ�ʱ�� */
	protected String rtUploadTime;

	/** ģ������ */
	protected String rtType;
	/**
	 * ģ��ӳ��
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,targetEntity = SOC0206TB.class,mappedBy="reportTemplateTB")
	@NotFound(action = NotFoundAction.IGNORE)
	protected List<SOC0206TB> rtmList;

	/**
	 * IDȡ��
	 *
	 * @return ID
	 */
	public Integer getRtId() {
		return rtId;
	}

	/**
	 * ID�趨
	 *
	 * @param rtId ID
	 */
	public void setRtId(Integer rtId) {
		this.rtId = rtId;
	}

	/**
	 * ģ������ȡ��
	 *
	 * @return ģ������
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
	 * ���޸�λ����ȡ��
	 *
	 * @return ���޸�λ����
	 */
	public Integer getRtSum() {
		return rtSum;
	}

	/**
	 * ���޸�λ�����趨
	 *
	 * @param rtSum ���޸�λ����
	 */
	public void setRtSum(Integer rtSum) {
		this.rtSum = rtSum;
	}

	/**
	 * ʱ������ȡ��
	 *
	 * @return ʱ������
	 */
	public String getRtDateType() {
		return rtDateType;
	}

	/**
	 * ʱ�������趨
	 *
	 * @param rtDateType ʱ������
	 */
	public void setRtDateType(String rtDateType) {
		this.rtDateType = rtDateType;
	}

	/**
	 * ģ����ʵ����ȡ��
	 *
	 * @return ģ����ʵ����
	 */
	public String getRtRealName() {
		return rtRealName;
	}

	/**
	 * ģ����ʵ�����趨
	 *
	 * @param rtRealName ģ����ʵ����
	 */
	public void setRtRealName(String rtRealName) {
		this.rtRealName = rtRealName;
	}

	/**
	 * ģ���ϴ�ʱ��ȡ��
	 *
	 * @return ģ���ϴ�ʱ��
	 */
	public String getRtUploadTime() {
		return rtUploadTime;
	}

	/**
	 * ģ���ϴ�ʱ���趨
	 *
	 * @param rtUploadTime ģ���ϴ�ʱ��
	 */
	public void setRtUploadTime(String rtUploadTime) {
		this.rtUploadTime = rtUploadTime;
	}

	/**
	 * ģ������ȡ��
	 *
	 * @return ģ������
	 */
	public String getRtType() {
		return rtType;
	}

	/**
	 * ģ�������趨
	 *
	 * @param rtType ģ������
	 */
	public void setRtType(String rtType) {
		this.rtType = rtType;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return rtId;
	}

	/**
	 * ģ��ӳ��ȡ��
	 *
	 * @return rtmList ģ��ӳ��
	 */
	public List<SOC0206TB> getRtmList() {
		return rtmList;
	}

	/**
	 * ģ��ӳ���趨
	 *
	 * @param rtmList ģ��ӳ��
	 */
	public void setRtmList(List<SOC0206TB> rtmList) {
		this.rtmList = rtmList;
	}

}