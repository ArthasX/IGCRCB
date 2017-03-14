/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.iam.model.InternalauditJobInfo;

/**
  * ����: ���ù�����ʵ��
  * ��������: ���ù�����ʵ��
  * ������¼: 2012/07/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="InternalauditJob")
public class InternalauditJobTB extends BaseEntity implements Serializable,
		Cloneable, InternalauditJobInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="INTERNALAUDITJOB_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="INTERNALAUDITJOB_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="INTERNALAUDITJOB_TABLE_GENERATOR")
	protected Integer iajid;

	/** �ƻ���� */
	protected String iajyear;

	/** ������ĿID */
	protected Integer iajiapid;

	/** �������� */
	protected String iajname;

	/** ʵ�ʹ�����ʼ���� */
	protected String iajstarttime;

	/** ʵ�ʹ����������� */
	protected String iajovertime;

	/** ������������ */
	protected String iajdesc;

	/** �Ǽ�ʱ�� */
	protected String iajinserttime;

	/** ���� */
	protected String iajattkey;

	/** �Ǽ���ID */
	protected String iajuserid;

	/** ������Ŀ��Ϣʵ�� */
	@OneToOne
	@JoinColumn(name="iajiapid", referencedColumnName="iapid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected  InternalauditprjTB internalauditprjTB;
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getIajid() {
		return iajid;
	}

	/**
	 * �����趨
	 *
	 * @param iajid ����
	 */
	public void setIajid(Integer iajid) {
		this.iajid = iajid;
	}

	/**
	 * �ƻ����ȡ��
	 *
	 * @return �ƻ����
	 */
	public String getIajyear() {
		return iajyear;
	}

	/**
	 * �ƻ�����趨
	 *
	 * @param iajyear �ƻ����
	 */
	public void setIajyear(String iajyear) {
		this.iajyear = iajyear;
	}

	/**
	 * ������ĿIDȡ��
	 *
	 * @return ������ĿID
	 */
	public Integer getIajiapid() {
		return iajiapid;
	}

	/**
	 * ������ĿID�趨
	 *
	 * @param iajiapid ������ĿID
	 */
	public void setIajiapid(Integer iajiapid) {
		this.iajiapid = iajiapid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getIajname() {
		return iajname;
	}

	/**
	 * ���������趨
	 *
	 * @param iajname ��������
	 */
	public void setIajname(String iajname) {
		this.iajname = iajname;
	}

	/**
	 * ʵ�ʹ�����ʼ����ȡ��
	 *
	 * @return ʵ�ʹ�����ʼ����
	 */
	public String getIajstarttime() {
		return iajstarttime;
	}

	/**
	 * ʵ�ʹ�����ʼ�����趨
	 *
	 * @param iajstarttime ʵ�ʹ�����ʼ����
	 */
	public void setIajstarttime(String iajstarttime) {
		this.iajstarttime = iajstarttime;
	}

	/**
	 * ʵ�ʹ�����������ȡ��
	 *
	 * @return ʵ�ʹ�����������
	 */
	public String getIajovertime() {
		return iajovertime;
	}

	/**
	 * ʵ�ʹ������������趨
	 *
	 * @param iajovertime ʵ�ʹ�����������
	 */
	public void setIajovertime(String iajovertime) {
		this.iajovertime = iajovertime;
	}

	/**
	 * ������������ȡ��
	 *
	 * @return ������������
	 */
	public String getIajdesc() {
		return iajdesc;
	}

	/**
	 * �������������趨
	 *
	 * @param iajdesc ������������
	 */
	public void setIajdesc(String iajdesc) {
		this.iajdesc = iajdesc;
	}

	/**
	 * �Ǽ�ʱ��ȡ��
	 *
	 * @return �Ǽ�ʱ��
	 */
	public String getIajinserttime() {
		return iajinserttime;
	}

	/**
	 * �Ǽ�ʱ���趨
	 *
	 * @param iajinserttime �Ǽ�ʱ��
	 */
	public void setIajinserttime(String iajinserttime) {
		this.iajinserttime = iajinserttime;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getIajattkey() {
		return iajattkey;
	}

	/**
	 * �����趨
	 *
	 * @param iajattkey ����
	 */
	public void setIajattkey(String iajattkey) {
		this.iajattkey = iajattkey;
	}

	/**
	 * �Ǽ���IDȡ��
	 *
	 * @return �Ǽ���ID
	 */
	public String getIajuserid() {
		return iajuserid;
	}

	/**
	 * �Ǽ���ID�趨
	 *
	 * @param iajuserid �Ǽ���ID
	 */
	public void setIajuserid(String iajuserid) {
		this.iajuserid = iajuserid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return iajid;
	}

	/**
	 * ��ȡinternalauditprjTB
	 * @return finternalauditprjTB internalauditprjTB
	 */
	public InternalauditprjTB getInternalauditprjTB() {
		return internalauditprjTB;
	}

	/**
	 * ����internalauditprjTB
	 * @param internalauditprjTB  internalauditprjTB
	 */
	public void setInternalauditprjTB(InternalauditprjTB internalauditprjTB) {
		this.internalauditprjTB = internalauditprjTB;
	}

}