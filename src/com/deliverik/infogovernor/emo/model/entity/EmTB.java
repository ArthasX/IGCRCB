/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.emo.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.emo.model.EmInfo;

/**
  * ����: oracle���ܲɼ�ʵ��
  * ��������: oracle���ܲɼ�ʵ��
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="em")
public class EmTB extends BaseEntity implements Serializable,
		Cloneable, EmInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="EM_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="EM_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="EM_TABLE_GENERATOR")
	protected Integer em_id;

	/** ���� */
	protected String em_type;

	/** ����sql��ID */
	protected String em_sqlid;

	/** �����Ự��ID */
	protected String em_sessionid;

	/** SQL���� */
	protected String em_sqltype;

	/** SQL���� */
	protected String em_sqlcontent;

	/** �û��� */
	protected String em_username;

	/** ���� */
	protected String em_program;

	/** ָ������ */
	protected String em_other;

	/** ָ������ */
	protected String em_network;

	/** ָ������ */
	protected String em_Queueing;

	/** ָ������ */
	protected String em_Idle;

	/** ָ������ */
	protected String em_Cluster;

	/** ָ������ */
	protected String em_administrative;

	/** ָ������ */
	protected String em_configuraction;

	/** ָ������ */
	protected String em_commit;

	/** ָ������ */
	protected String em_application;

	/** ָ������ */
	protected String em_concurrency;

	/** ָ������ */
	protected String em_systemIO;

	/** ָ������ */
	protected String em_userIO;

	/** ָ������ */
	protected String em_scheduler;

	/** ָ������ */
	protected String em_cpu;

	/** ָ���ܺ� */
	protected String em_Totail;

	/** �ɼ�ʱ�� */
	protected String em_Collecttime;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getEm_id() {
		return em_id;
	}

	/**
	 * �����趨
	 *
	 * @param em_id ����
	 */
	public void setEm_id(Integer em_id) {
		this.em_id = em_id;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getEm_type() {
		return em_type;
	}

	/**
	 * �����趨
	 *
	 * @param em_type ����
	 */
	public void setEm_type(String em_type) {
		this.em_type = em_type;
	}

	/**
	 * ����sql��IDȡ��
	 *
	 * @return ����sql��ID
	 */
	public String getEm_sqlid() {
		return em_sqlid;
	}

	/**
	 * ����sql��ID�趨
	 *
	 * @param em_sqlid ����sql��ID
	 */
	public void setEm_sqlid(String em_sqlid) {
		this.em_sqlid = em_sqlid;
	}

	/**
	 * �����Ự��IDȡ��
	 *
	 * @return �����Ự��ID
	 */
	public String getEm_sessionid() {
		return em_sessionid;
	}

	/**
	 * �����Ự��ID�趨
	 *
	 * @param em_sessionid �����Ự��ID
	 */
	public void setEm_sessionid(String em_sessionid) {
		this.em_sessionid = em_sessionid;
	}

	/**
	 * SQL����ȡ��
	 *
	 * @return SQL����
	 */
	public String getEm_sqltype() {
		return em_sqltype;
	}

	/**
	 * SQL�����趨
	 *
	 * @param em_sqltype SQL����
	 */
	public void setEm_sqltype(String em_sqltype) {
		this.em_sqltype = em_sqltype;
	}

	/**
	 * SQL����ȡ��
	 *
	 * @return SQL����
	 */
	public String getEm_sqlcontent() {
		return em_sqlcontent;
	}

	/**
	 * SQL�����趨
	 *
	 * @param em_sqlcontent SQL����
	 */
	public void setEm_sqlcontent(String em_sqlcontent) {
		this.em_sqlcontent = em_sqlcontent;
	}

	/**
	 * �û���ȡ��
	 *
	 * @return �û���
	 */
	public String getEm_username() {
		return em_username;
	}

	/**
	 * �û����趨
	 *
	 * @param em_username �û���
	 */
	public void setEm_username(String em_username) {
		this.em_username = em_username;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getEm_program() {
		return em_program;
	}

	/**
	 * �����趨
	 *
	 * @param em_program ����
	 */
	public void setEm_program(String em_program) {
		this.em_program = em_program;
	}

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_other() {
		return em_other;
	}

	/**
	 * ָ�������趨
	 *
	 * @param em_other ָ������
	 */
	public void setEm_other(String em_other) {
		this.em_other = em_other;
	}

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_network() {
		return em_network;
	}

	/**
	 * ָ�������趨
	 *
	 * @param em_network ָ������
	 */
	public void setEm_network(String em_network) {
		this.em_network = em_network;
	}

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_Queueing() {
		return em_Queueing;
	}

	/**
	 * ָ�������趨
	 *
	 * @param em_Queueing ָ������
	 */
	public void setEm_Queueing(String em_Queueing) {
		this.em_Queueing = em_Queueing;
	}

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_Idle() {
		return em_Idle;
	}

	/**
	 * ָ�������趨
	 *
	 * @param em_Idle ָ������
	 */
	public void setEm_Idle(String em_Idle) {
		this.em_Idle = em_Idle;
	}

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_Cluster() {
		return em_Cluster;
	}

	/**
	 * ָ�������趨
	 *
	 * @param em_Cluster ָ������
	 */
	public void setEm_Cluster(String em_Cluster) {
		this.em_Cluster = em_Cluster;
	}

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_administrative() {
		return em_administrative;
	}

	/**
	 * ָ�������趨
	 *
	 * @param em_administrative ָ������
	 */
	public void setEm_administrative(String em_administrative) {
		this.em_administrative = em_administrative;
	}

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_configuraction() {
		return em_configuraction;
	}

	/**
	 * ָ�������趨
	 *
	 * @param em_configuraction ָ������
	 */
	public void setEm_configuraction(String em_configuraction) {
		this.em_configuraction = em_configuraction;
	}

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_commit() {
		return em_commit;
	}

	/**
	 * ָ�������趨
	 *
	 * @param em_commit ָ������
	 */
	public void setEm_commit(String em_commit) {
		this.em_commit = em_commit;
	}

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_application() {
		return em_application;
	}

	/**
	 * ָ�������趨
	 *
	 * @param em_application ָ������
	 */
	public void setEm_application(String em_application) {
		this.em_application = em_application;
	}

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_concurrency() {
		return em_concurrency;
	}

	/**
	 * ָ�������趨
	 *
	 * @param em_concurrency ָ������
	 */
	public void setEm_concurrency(String em_concurrency) {
		this.em_concurrency = em_concurrency;
	}

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_systemIO() {
		return em_systemIO;
	}

	/**
	 * ָ�������趨
	 *
	 * @param em_systemIO ָ������
	 */
	public void setEm_systemIO(String em_systemIO) {
		this.em_systemIO = em_systemIO;
	}

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_userIO() {
		return em_userIO;
	}

	/**
	 * ָ�������趨
	 *
	 * @param em_userIO ָ������
	 */
	public void setEm_userIO(String em_userIO) {
		this.em_userIO = em_userIO;
	}

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_scheduler() {
		return em_scheduler;
	}

	/**
	 * ָ�������趨
	 *
	 * @param em_scheduler ָ������
	 */
	public void setEm_scheduler(String em_scheduler) {
		this.em_scheduler = em_scheduler;
	}

	/**
	 * ָ������ȡ��
	 *
	 * @return ָ������
	 */
	public String getEm_cpu() {
		return em_cpu;
	}

	/**
	 * ָ�������趨
	 *
	 * @param em_cpu ָ������
	 */
	public void setEm_cpu(String em_cpu) {
		this.em_cpu = em_cpu;
	}

	/**
	 * ָ���ܺ�ȡ��
	 *
	 * @return ָ���ܺ�
	 */
	public String getEm_Totail() {
		return em_Totail;
	}

	/**
	 * ָ���ܺ��趨
	 *
	 * @param em_Totail ָ���ܺ�
	 */
	public void setEm_Totail(String em_Totail) {
		this.em_Totail = em_Totail;
	}

	/**
	 * �ɼ�ʱ��ȡ��
	 *
	 * @return �ɼ�ʱ��
	 */
	public String getEm_Collecttime() {
		return em_Collecttime;
	}

	/**
	 * �ɼ�ʱ���趨
	 *
	 * @param em_Collecttime �ɼ�ʱ��
	 */
	public void setEm_Collecttime(String em_Collecttime) {
		this.em_Collecttime = em_Collecttime;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return em_id;
	}

}