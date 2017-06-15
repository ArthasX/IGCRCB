/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.cic.model.CompareprocessInfo;

/**
  * ����: �Աȼ�¼ʵ��
  * ��������: �Աȼ�¼ʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="compareprocess")
public class CompareprocessTB extends BaseEntity implements Serializable,
		Cloneable, CompareprocessInfo {

	/** ���� */
	@Id
	@GeneratedValue(generator = "cpid")
	@GenericGenerator(name = "cpid", strategy = "sequence", 
			parameters = { @Parameter(name = "sequence", 
						value = "compareprocess_seq") })
	protected Integer cpid;

	/** �ȶ������ */
	protected Integer fkCsid;
	
	@ManyToOne
	@JoinColumn(name="fkCsid", referencedColumnName="csid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected ComparescopeTB compareScopeTb;

	/** ��ʼʱ�� */
	protected String cpstarttime;

	/** ����ʱ�� */
	protected String cpendtime;

	/** ���� */
	protected String cpschedule;

	/** ִ�н�� */
	protected String cpresulttype;

	/** ������ʾ */
	protected String errorcaption;



	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCpid() {
		return cpid;
	}

	/**
	 * �����趨
	 *
	 * @param cpid ����
	 */
	public void setCpid(Integer cpid) {
		this.cpid = cpid;
	}

	/**
	 * �ȶ������ȡ��
	 *
	 * @return �ȶ������
	 */
	public Integer getFkCsid() {
		return fkCsid;
	}

	/**
	 * �ȶ�������趨
	 *
	 * @param fk_csid �ȶ������
	 */
	public void setFkCsid(Integer fkCsid) {
		this.fkCsid = fkCsid;
	}

	/**
	 * ��ʼʱ��ȡ��
	 *
	 * @return ��ʼʱ��
	 */
	public String getCpstarttime() {
		return cpstarttime;
	}

	/**
	 * ��ʼʱ���趨
	 *
	 * @param cpstarttime ��ʼʱ��
	 */
	public void setCpstarttime(String cpstarttime) {
		this.cpstarttime = cpstarttime;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getCpendtime() {
		return cpendtime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param cpendtime ����ʱ��
	 */
	public void setCpendtime(String cpendtime) {
		this.cpendtime = cpendtime;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCpschedule() {
		return cpschedule;
	}

	/**
	 * �����趨
	 *
	 * @param cpschedule ����
	 */
	public void setCpschedule(String cpschedule) {
		this.cpschedule = cpschedule;
	}

	/**
	 * ִ�н��ȡ��
	 *
	 * @return ִ�н��
	 */
	public String getCpresulttype() {
		return cpresulttype;
	}

	/**
	 * ִ�н���趨
	 *
	 * @param cpresulttype ִ�н��
	 */
	public void setCpresulttype(String cpresulttype) {
		this.cpresulttype = cpresulttype;
	}

	/**
	 * ������ʾȡ��
	 *
	 * @return ������ʾ
	 */
	public String getErrorcaption() {
		return errorcaption;
	}

	/**
	 * ������ʾ�趨
	 *
	 * @param errorcaption ������ʾ
	 */
	public void setErrorcaption(String errorcaption) {
		this.errorcaption = errorcaption;
	}




	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	@Override
	public Serializable getPK() {
		return cpid;
	}

	public ComparescopeTB getCompareScopeTb() {
		return compareScopeTb;
	}

	public void setCompareScopeTb(ComparescopeTB compareScopeTb) {
		this.compareScopeTb = compareScopeTb;
	}

	
}