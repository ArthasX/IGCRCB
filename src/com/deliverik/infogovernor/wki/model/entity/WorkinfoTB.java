/*
 * ��������������ɷ����޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wki.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.wki.model.WorkinfoInfo;

/**
  * ����: ������Ϣʵ��
  * ��������: ������Ϣʵ��
  * ������¼: 2017/03/02
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="workinfo")
public class WorkinfoTB extends BaseEntity implements Serializable,
		Cloneable, WorkinfoInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="WORKINFO_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="WORKINFO_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="WORKINFO_TABLE_GENERATOR")
	protected Integer workinfoid;

	/** �������� */
	protected String workname;

	protected String startdate;
	/** ���� */
	protected Integer workperiod;

	/** Ԥ�����ʱ�� */
	protected String estFinDate;

	/** ʵ�����ʱ�� */
	protected String actFinDate;

	/** ��ʱ�������� */
	protected Integer timeOutPeriod;

	/** ������id */
	protected Integer initid;

	/** ���������� */
	protected String initname;

	/** ִ����id */
	protected Integer execid;

	/** ִ�������� */
	protected String execname;

	/** ����״̬ */
	protected Integer workstatus;

	/** ��ע */
	protected String remark;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getWorkinfoid() {
		return workinfoid;
	}

	/**
	 * �����趨
	 *
	 * @param workinfoid ����
	 */
	public void setWorkinfoid(Integer workinfoid) {
		this.workinfoid = workinfoid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getWorkname() {
		return workname;
	}

	/**
	 * ���������趨
	 *
	 * @param workname ��������
	 */
	public void setWorkname(String workname) {
		this.workname = workname;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getWorkperiod() {
		return workperiod;
	}

	/**
	 * �����趨
	 *
	 * @param workperiod ����
	 */
	public void setWorkperiod(Integer workperiod) {
		this.workperiod = workperiod;
	}

	/**
	 * Ԥ�����ʱ��ȡ��
	 *
	 * @return Ԥ�����ʱ��
	 */
	public String getEstFinDate() {
		return estFinDate;
	}

	/**
	 * Ԥ�����ʱ���趨
	 *
	 * @param estFinDate Ԥ�����ʱ��
	 */
	public void setEstFinDate(String estFinDate) {
		this.estFinDate = estFinDate;
	}

	/**
	 * ʵ�����ʱ��ȡ��
	 *
	 * @return ʵ�����ʱ��
	 */
	public String getActFinDate() {
		return actFinDate;
	}

	/**
	 * ʵ�����ʱ���趨
	 *
	 * @param actFinDate ʵ�����ʱ��
	 */
	public void setActFinDate(String actFinDate) {
		this.actFinDate = actFinDate;
	}

	/**
	 * ��ʱ��������ȡ��
	 *
	 * @return ��ʱ��������
	 */
	public Integer getTimeOutPeriod() {
		return timeOutPeriod;
	}

	/**
	 * ��ʱ���������趨
	 *
	 * @param timeOutPeriod ��ʱ��������
	 */
	public void setTimeOutPeriod(Integer timeOutPeriod) {
		this.timeOutPeriod = timeOutPeriod;
	}

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public Integer getInitid() {
		return initid;
	}

	/**
	 * ������id�趨
	 *
	 * @param initid ������id
	 */
	public void setInitid(Integer initid) {
		this.initid = initid;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getInitname() {
		return initname;
	}

	/**
	 * �����������趨
	 *
	 * @param initname ����������
	 */
	public void setInitname(String initname) {
		this.initname = initname;
	}

	/**
	 * ִ����idȡ��
	 *
	 * @return ִ����id
	 */
	public Integer getExecid() {
		return execid;
	}

	/**
	 * ִ����id�趨
	 *
	 * @param execid ִ����id
	 */
	public void setExecid(Integer execid) {
		this.execid = execid;
	}

	/**
	 * ִ��������ȡ��
	 *
	 * @return ִ��������
	 */
	public String getExecname() {
		return execname;
	}

	/**
	 * ִ���������趨
	 *
	 * @param execname ִ��������
	 */
	public void setExecname(String execname) {
		this.execname = execname;
	}

	/**
	 * ����״̬ȡ��
	 *
	 * @return ����״̬
	 */
	public Integer getWorkstatus() {
		return workstatus;
	}

	/**
	 * ����״̬�趨
	 *
	 * @param workstatus ����״̬
	 */
	public void setWorkstatus(Integer workstatus) {
		this.workstatus = workstatus;
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
	 * @param remark ��ע
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return workinfoid;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

}