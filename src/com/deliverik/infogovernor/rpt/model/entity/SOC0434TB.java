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

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.rpt.model.SOC0434Info;

/**
  * ����: PVVIOʵ��
  * ��������: PVVIOʵ��
  * ������¼: 2012/08/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="PVVIO")
public class SOC0434TB extends BaseEntity implements Serializable,
		Cloneable, SOC0434Info {

	/** PVVID */
	@Id
	@TableGenerator(
		name="PVVIO_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="PVVIO_SEQUENCE", initialValue=1000, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PVVIO_TABLE_GENERATOR")
	protected Integer PVVID;

	/** SN */
	protected String SN;

	/** PVID */
	protected String PVID;

	/** SNAME */
	protected String SNAME;

	/** LUNID */
	protected String LUNID;

	/** PVSIZE */
	protected Integer PVSIZE;

	/** ISUSED */
	protected String ISUSED;

	/** CREATEDATE */
	protected String CREATEDATE;

	/**
	 * PVVIDȡ��
	 *
	 * @return PVVID
	 */
	public Integer getPVVID() {
		return PVVID;
	}

	/**
	 * PVVID�趨
	 *
	 * @param PVVID PVVID
	 */
	public void setPVVID(Integer PVVID) {
		this.PVVID = PVVID;
	}

	/**
	 * SNȡ��
	 *
	 * @return SN
	 */
	public String getSN() {
		return SN;
	}

	/**
	 * SN�趨
	 *
	 * @param SN SN
	 */
	public void setSN(String SN) {
		this.SN = SN;
	}

	/**
	 * PVIDȡ��
	 *
	 * @return PVID
	 */
	public String getPVID() {
		return PVID;
	}

	/**
	 * PVID�趨
	 *
	 * @param PVID PVID
	 */
	public void setPVID(String PVID) {
		this.PVID = PVID;
	}

	/**
	 * SNAMEȡ��
	 *
	 * @return SNAME
	 */
	public String getSNAME() {
		return SNAME;
	}

	/**
	 * SNAME�趨
	 *
	 * @param SNAME SNAME
	 */
	public void setSNAME(String SNAME) {
		this.SNAME = SNAME;
	}

	/**
	 * LUNIDȡ��
	 *
	 * @return LUNID
	 */
	public String getLUNID() {
		return LUNID;
	}

	/**
	 * LUNID�趨
	 *
	 * @param LUNID LUNID
	 */
	public void setLUNID(String LUNID) {
		this.LUNID = LUNID;
	}

	/**
	 * PVSIZEȡ��
	 *
	 * @return PVSIZE
	 */
	public Integer getPVSIZE() {
		return PVSIZE;
	}

	/**
	 * PVSIZE�趨
	 *
	 * @param PVSIZE PVSIZE
	 */
	public void setPVSIZE(Integer PVSIZE) {
		this.PVSIZE = PVSIZE;
	}

	/**
	 * ISUSEDȡ��
	 *
	 * @return ISUSED
	 */
	public String getISUSED() {
		return ISUSED;
	}

	/**
	 * ISUSED�趨
	 *
	 * @param ISUSED ISUSED
	 */
	public void setISUSED(String ISUSED) {
		this.ISUSED = ISUSED;
	}

	/**
	 * CREATEDATEȡ��
	 *
	 * @return CREATEDATE
	 */
	public String getCREATEDATE() {
		return CREATEDATE;
	}

	/**
	 * CREATEDATE�趨
	 *
	 * @param CREATEDATE CREATEDATE
	 */
	public void setCREATEDATE(String CREATEDATE) {
		this.CREATEDATE = CREATEDATE;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return PVVID;
	}

}