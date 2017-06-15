/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.prj.model.ProjectBudgetRelationInfo;

/**
 * ����:Ԥ������Ŀ��ϵ��ʵ�� 
 * ����������Ԥ������Ŀ��ϵ��ʵ��
 * �����ˣ���͢־
 * ������¼�� 2012-5-17
 * �޸ļ�¼��
 */
@Entity
@Table(name="ProjectBudgetRelation")
@SuppressWarnings("serial")
public class ProjectBudgetRelationTB extends BaseEntity implements ProjectBudgetRelationInfo{
	@Id
	@TableGenerator(
			name="PROJECTBUDGETRELATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
			pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
			pkColumnValue="PROJECTBUDGETRELATION_SEQUENCE", initialValue=1, allocationSize=1
		)
		@GeneratedValue(strategy = GenerationType.TABLE, generator="PROJECTBUDGETRELATION_TABLE_GENERATOR")
	/** ��ϵ������ */
	protected Integer pbid;
	/** ��ĿID */
	protected Integer pid;
	/** Ԥ��ID */
	protected Integer bid;
	/** Ԥ�� �ʱ��� ����*/
	protected Double bzdevelop;
	/** Ԥ�� �ʱ��� Ӳ��*/
	protected Double bzhardware;
	/** Ԥ�� �ʱ��� ���*/
	protected Double bzsoftware;
	/** Ԥ�� �ʱ��� ����*/
	protected Double bzproject;
	/** Ԥ�� �ʱ��� ����*/
	protected Double bzelse;
	/** Ԥ�� �ɱ��� ʵʩ*/
	protected Double bcimplement;
	/** Ԥ�� �ɱ��� ����*/
	protected Double bcelse;
	/** ����ʱ�� */
	protected String pbdatetime;
	/**
	 * ��ϵ������ȡ��
	 * @return pbid ��ϵ������
	 */
	public Integer getPbid() {
		return pbid;
	}
	/**
	 * ��ϵ�������趨
	 * @param pbid ��ϵ������
	 */
	public void setPbid(Integer pbid) {
		this.pbid = pbid;
	}
	/**
	 * ��ĿIDȡ��
	 * @return pid ��ĿID
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * ��ĿID�趨
	 * @param pid ��ĿID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * Ԥ��IDȡ��
	 * @return bid Ԥ��ID
	 */
	public Integer getBid() {
		return bid;
	}
	/**
	 * Ԥ��ID�趨
	 * @param bid Ԥ��ID
	 */
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	/**
	 * Ԥ���ʱ��𿪷�ȡ��
	 * @return bzdevelop Ԥ���ʱ��𿪷�
	 */
	public Double getBzdevelop() {
		return bzdevelop;
	}
	/**
	 * Ԥ���ʱ��𿪷��趨
	 * @param bzdevelop Ԥ���ʱ��𿪷�
	 */
	public void setBzdevelop(Double bzdevelop) {
		this.bzdevelop = bzdevelop;
	}
	/**
	 * Ԥ���ʱ���Ӳ��ȡ��
	 * @return bzhardware Ԥ���ʱ���Ӳ��
	 */
	public Double getBzhardware() {
		return bzhardware;
	}
	/**
	 * Ԥ���ʱ���Ӳ���趨
	 * @param bzhardware Ԥ���ʱ���Ӳ��
	 */
	public void setBzhardware(Double bzhardware) {
		this.bzhardware = bzhardware;
	}
	/**
	 * Ԥ���ʱ������ȡ��
	 * @return bzsoftware Ԥ���ʱ������
	 */
	public Double getBzsoftware() {
		return bzsoftware;
	}
	/**
	 * Ԥ���ʱ�������趨
	 * @param bzsoftware Ԥ���ʱ������
	 */
	public void setBzsoftware(Double bzsoftware) {
		this.bzsoftware = bzsoftware;
	}
	/**
	 * Ԥ���ʱ��𹤳�ȡ��
	 * @return bzproject Ԥ���ʱ��𹤳�
	 */
	public Double getBzproject() {
		return bzproject;
	}
	/**
	 * Ԥ���ʱ��𹤳��趨
	 * @param bzproject Ԥ���ʱ��𹤳�
	 */
	public void setBzproject(Double bzproject) {
		this.bzproject = bzproject;
	}
	/**
	 * Ԥ���ʱ�������ȡ��
	 * @return bzelse Ԥ���ʱ�������
	 */
	public Double getBzelse() {
		return bzelse;
	}
	/**
	 * Ԥ���ʱ��������趨
	 * @param bzelse Ԥ���ʱ�������
	 */
	public void setBzelse(Double bzelse) {
		this.bzelse = bzelse;
	}
	/**
	 * Ԥ��ɱ���ʵʩȡ��
	 * @return bcimplement Ԥ��ɱ���ʵʩ
	 */
	public Double getBcimplement() {
		return bcimplement;
	}
	/**
	 * Ԥ��ɱ���ʵʩ�趨
	 * @param bcimplement Ԥ��ɱ���ʵʩ
	 */
	public void setBcimplement(Double bcimplement) {
		this.bcimplement = bcimplement;
	}
	/**
	 * Ԥ��ɱ�������ȡ��
	 * @return bcelse Ԥ��ɱ�������
	 */
	public Double getBcelse() {
		return bcelse;
	}
	/**
	 * Ԥ��ɱ��������趨
	 * @param bcelse Ԥ��ɱ�������
	 */
	public void setBcelse(Double bcelse) {
		this.bcelse = bcelse;
	}
	/**
	 * ����ʱ��ȡ��
	 * @return pbdatetime ����ʱ��
	 */
	public String getPbdatetime() {
		return pbdatetime;
	}
	/**
	 * ����ʱ���趨
	 * @param pbdatetime ����ʱ��
	 */
	public void setPbdatetime(String pbdatetime) {
		this.pbdatetime = pbdatetime;
	}
	/***
	 * ����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return this.pbid;
	}
	
}
