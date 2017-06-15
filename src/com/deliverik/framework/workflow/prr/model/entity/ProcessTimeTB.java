/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.ProcessTimeInfo;

/**
  * ����: ���̼�ʱ��ʵ��
  * ��������: ���̼�ʱ��ʵ��
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="processTime")
public class ProcessTimeTB extends BaseEntity implements Serializable,
		Cloneable, ProcessTimeInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="PROCESSTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="PROCESSTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PROCESSTIME_TABLE_GENERATOR")
	protected Integer prtid;

	/** ����ID */
	protected Integer prid;

	/** ��ʱ�û�ID */
	protected String userid;

	/** ��ʱ��ʼʱ�� */
	protected String prtstartTime;

	/** ��ʼ��ʱ״̬ */
	protected String prtstartStatus;

	/** ��ʱ����ʱ�� */
	protected String prtEndTime;

	/** ��ʱ����״̬ */
	protected String prtEndStatus;

	/** ��Ч������ */
	protected Integer factTime;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPrtid() {
		return prtid;
	}

	/**
	 * �����趨
	 *
	 * @param prtid����
	 */
	public void setPrtid(Integer prtid) {
		this.prtid = prtid;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param prid����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ��ʱ�û�IDȡ��
	 *
	 * @return ��ʱ�û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ��ʱ�û�ID�趨
	 *
	 * @param userid��ʱ�û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ��ʱ��ʼʱ��ȡ��
	 *
	 * @return ��ʱ��ʼʱ��
	 */
	public String getPrtstartTime() {
		return prtstartTime;
	}

	/**
	 * ��ʱ��ʼʱ���趨
	 *
	 * @param prtstartTime��ʱ��ʼʱ��
	 */
	public void setPrtstartTime(String prtstartTime) {
		this.prtstartTime = prtstartTime;
	}

	/**
	 * ��ʼ��ʱ״̬ȡ��
	 *
	 * @return ��ʼ��ʱ״̬
	 */
	public String getPrtstartStatus() {
		return prtstartStatus;
	}

	/**
	 * ��ʼ��ʱ״̬�趨
	 *
	 * @param prtstartStatus��ʼ��ʱ״̬
	 */
	public void setPrtstartStatus(String prtstartStatus) {
		this.prtstartStatus = prtstartStatus;
	}

	/**
	 * ��ʱ����ʱ��ȡ��
	 *
	 * @return ��ʱ����ʱ��
	 */
	public String getPrtEndTime() {
		return prtEndTime;
	}

	/**
	 * ��ʱ����ʱ���趨
	 *
	 * @param prtEndTime��ʱ����ʱ��
	 */
	public void setPrtEndTime(String prtEndTime) {
		this.prtEndTime = prtEndTime;
	}

	/**
	 * ��ʱ����״̬ȡ��
	 *
	 * @return ��ʱ����״̬
	 */
	public String getPrtEndStatus() {
		return prtEndStatus;
	}

	/**
	 * ��ʱ����״̬�趨
	 *
	 * @param prtEndStatus��ʱ����״̬
	 */
	public void setPrtEndStatus(String prtEndStatus) {
		this.prtEndStatus = prtEndStatus;
	}

	/**
	 * ��Ч������ȡ��
	 *
	 * @return ��Ч������
	 */
	public Integer getFactTime() {
		return factTime;
	}

	/**
	 * ��Ч�������趨
	 *
	 * @param factTime��Ч������
	 */
	public void setFactTime(Integer factTime) {
		this.factTime = factTime;
	}


	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return prtid;
	}

}