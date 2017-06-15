/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dut.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dut.model.DelayInfo;

/**
  * ����: ��ʱ������Ϣ��ʵ��
  * ��������: ��ʱ������Ϣ��ʵ��
  * ������¼: 2012/04/05
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="delay")
public class DelayTB extends BaseEntity implements Serializable,
		Cloneable, DelayInfo {

	/** ����id */
	@Id
	@TableGenerator(
		name="DELAY_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="DELAY_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="DELAY_TABLE_GENERATOR")
	protected Integer id;

	/** ���� */
	protected String datetime;

	/** ���뵥λ */
	protected String orgname;

	/** ������� */
	protected String title;
	
	/** �г����� */
	protected String hzname;

	/** �г��绰 */
	protected String hztel;
	
	/** �������� */
	protected String jlname;

	/** ����绰 */
	protected String jltel;

	/** ��ע */
	protected String remark;

	/** ��ʼʱ�� */
	protected String starttime;

	/** ����ʱ�� */
	protected String endtime;

	/** ������ */
	protected String operater;
	
	/** ����ʱ�� */
	protected String unlocktime;

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * ����id�趨
	 *
	 * @param id ����id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getDatetime() {
		return datetime;
	}

	/**
	 * �����趨
	 *
	 * @param delaydate ����
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	/**
	 * ���뵥λȡ��
	 *
	 * @return ���뵥λ
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ���뵥λ�趨
	 *
	 * @param orgname ���뵥λ
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * �г��绰ȡ��
	 *
	 * @return �г��绰
	 */
	public String getHztel() {
		return hztel;
	}

	/**
	 * �г��绰�趨
	 *
	 * @param hztel �г��绰
	 */
	public void setHztel(String hztel) {
		this.hztel = hztel;
	}

	/**
	 * ����绰ȡ��
	 *
	 * @return ����绰
	 */
	public String getJltel() {
		return jltel;
	}

	/**
	 * ����绰�趨
	 *
	 * @param jltel ����绰
	 */
	public void setJltel(String jltel) {
		this.jltel = jltel;
	}

	/**
	 * ��עȡ��
	 *
	 * @return ��ע
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * ��ע�趨
	 *
	 * @param comment ��ע
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * ��ʼʱ��ȡ��
	 *
	 * @return ��ʼʱ��
	 */
	public String getStarttime() {
		return starttime;
	}

	/**
	 * ��ʼʱ���趨
	 *
	 * @param starttime ��ʼʱ��
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param endtime ����ʱ��
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getOperater() {
		return operater;
	}

	/**
	 * �������趨
	 *
	 * @param operater ������
	 */
	public void setOperater(String operater) {
		this.operater = operater;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

	/**
	 * �г�����ȡ��
	 * @return
	 */
	public String getHzname() {
		return hzname;
	}

	/**
	 * �г������趨
	 * @param hzname
	 */
	public void setHzname(String hzname) {
		this.hzname = hzname;
	}

	/**
	 * ��������ȡ��
	 * @return
	 */
	public String getJlname() {
		return jlname;
	}

	/**
	 * ���������趨
	 * @param jlname
	 */
	public void setJlname(String jlname) {
		this.jlname = jlname;
	}

	/**
	 * �������ȡ��
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * ��������趨
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return
	 */
	public String getUnlocktime() {
		return unlocktime;
	}

	/**
	 * ����ʱ���趨
	 * @param unlocktime
	 */
	public void setUnlocktime(String unlocktime) {
		this.unlocktime = unlocktime;
	}

}