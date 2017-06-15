/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.DrillplanitemInfo;

/**
  * ����: �����ƻ���Ŀʵ��
  * ��������: �����ƻ���Ŀʵ��
  * ������¼: 2015/03/02
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="drillplanitem")
public class DrillplanitemTB extends BaseEntity implements Serializable,
		Cloneable, DrillplanitemInfo {

	/** �����ƻ���Ŀid */
	@Id
	@TableGenerator(
		name="DRILLPLANITEM_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="DRILLPLANITEM_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="DRILLPLANITEM_TABLE_GENERATOR")
	protected Integer diid;

	/** �����ƻ�id */
	protected Integer did;

	/** ��������prid */
	protected Integer prid;

	/** ����״̬ ������/δ���� */
	protected String status;

	/** ����Ԥ�ڿ�ʼʱ�� */
	protected String expecttime;

	/** ����ʵ�ʿ�ʼʱ�� */
	protected String actstarttime;

	/** �������� */
	protected String diname;

	/** �������� */
	protected String dicontant;

	/** ����Ŀ�� */
	protected String didestination;

	/** �������� */
	protected String discene;

	/** Ӱ�췶Χ */
	protected String discope;

	/** ���������� */
	protected String didutyorg;

	/** ���벿�� */
	protected String partorg;

	/**
	 * �����ƻ���Ŀidȡ��
	 *
	 * @return �����ƻ���Ŀid
	 */
	public Integer getDiid() {
		return diid;
	}

	/**
	 * �����ƻ���Ŀid�趨
	 *
	 * @param diid �����ƻ���Ŀid
	 */
	public void setDiid(Integer diid) {
		this.diid = diid;
	}

	/**
	 * �����ƻ�idȡ��
	 *
	 * @return �����ƻ�id
	 */
	public Integer getDid() {
		return did;
	}

	/**
	 * �����ƻ�id�趨
	 *
	 * @param did �����ƻ�id
	 */
	public void setDid(Integer did) {
		this.did = did;
	}

	/**
	 * ��������pridȡ��
	 *
	 * @return ��������prid
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ��������prid�趨
	 *
	 * @param prid ��������prid
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ����״̬ ������/δ����ȡ��
	 *
	 * @return ����״̬ ������/δ����
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ����״̬ ������/δ�����趨
	 *
	 * @param status ����״̬ ������/δ����
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * ����Ԥ�ڿ�ʼʱ��ȡ��
	 *
	 * @return ����Ԥ�ڿ�ʼʱ��
	 */
	public String getExpecttime() {
		return expecttime;
	}

	/**
	 * ����Ԥ�ڿ�ʼʱ���趨
	 *
	 * @param expecttime ����Ԥ�ڿ�ʼʱ��
	 */
	public void setExpecttime(String expecttime) {
		this.expecttime = expecttime;
	}

	/**
	 * ����ʵ�ʿ�ʼʱ��ȡ��
	 *
	 * @return ����ʵ�ʿ�ʼʱ��
	 */
	public String getActstarttime() {
		return actstarttime;
	}

	/**
	 * ����ʵ�ʿ�ʼʱ���趨
	 *
	 * @param actstarttime ����ʵ�ʿ�ʼʱ��
	 */
	public void setActstarttime(String actstarttime) {
		this.actstarttime = actstarttime;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getDiname() {
		return diname;
	}

	/**
	 * ���������趨
	 *
	 * @param diname ��������
	 */
	public void setDiname(String diname) {
		this.diname = diname;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getDicontant() {
		return dicontant;
	}

	/**
	 * ���������趨
	 *
	 * @param dicontant ��������
	 */
	public void setDicontant(String dicontant) {
		this.dicontant = dicontant;
	}

	/**
	 * ����Ŀ��ȡ��
	 *
	 * @return ����Ŀ��
	 */
	public String getDidestination() {
		return didestination;
	}

	/**
	 * ����Ŀ���趨
	 *
	 * @param didestination ����Ŀ��
	 */
	public void setDidestination(String didestination) {
		this.didestination = didestination;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getDiscene() {
		return discene;
	}

	/**
	 * ���������趨
	 *
	 * @param discene ��������
	 */
	public void setDiscene(String discene) {
		this.discene = discene;
	}

	/**
	 * Ӱ�췶Χȡ��
	 *
	 * @return Ӱ�췶Χ
	 */
	public String getDiscope() {
		return discope;
	}

	/**
	 * Ӱ�췶Χ�趨
	 *
	 * @param discope Ӱ�췶Χ
	 */
	public void setDiscope(String discope) {
		this.discope = discope;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getDidutyorg() {
		return didutyorg;
	}

	/**
	 * �����������趨
	 *
	 * @param didutyorg ����������
	 */
	public void setDidutyorg(String didutyorg) {
		this.didutyorg = didutyorg;
	}

	/**
	 * ���벿��ȡ��
	 *
	 * @return ���벿��
	 */
	public String getPartorg() {
		return partorg;
	}

	/**
	 * ���벿���趨
	 *
	 * @param partorg ���벿��
	 */
	public void setPartorg(String partorg) {
		this.partorg = partorg;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return diid;
	}

}