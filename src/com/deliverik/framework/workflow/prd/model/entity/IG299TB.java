/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.workflow.prd.model.IG299Info;

/**
  * ����: ״̬�ɷ��ɻ��������ʵ��
  * ��������: ״̬�ɷ��ɻ��������ʵ��
  * ������¼: 2013/02/26
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="ig299")
public class IG299TB extends BaseEntity implements Serializable,
		Cloneable, IG299Info {

	/** ״̬���û����������� */
	@Id
	protected String psodid;

	/** ״̬�ڵ�ID */
	protected String psdid;

	/** ��������� */
	protected String orgsyscoding;
	
	/** �������� */
	protected String orgname;
	
	/** ���� */
	@OneToOne
	@JoinColumn(name="orgsyscoding",referencedColumnName="orgsyscoding", updatable=false, insertable= false )
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB org;

	/**
	 * ״̬���û�����������ȡ��
	 *
	 * @return ״̬���û�����������
	 */
	public String getPsodid() {
		return psodid;
	}

	/**
	 * ״̬���û������������趨
	 *
	 * @param psodid ״̬���û�����������
	 */
	public void setPsodid(String psodid) {
		this.psodid = psodid;
	}

	/**
	 * ״̬�ڵ�IDȡ��
	 *
	 * @return psdid ״̬�ڵ�ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬�ڵ�ID�趨
	 *
	 * @param psdid ״̬�ڵ�ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ���������ȡ��
	 *
	 * @return orgsyscoding ���������
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * ����������趨
	 *
	 * @param orgsyscoding ���������
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return orgname ��������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ���������趨
	 *
	 * @param orgname ��������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public OrganizationTB getOrg() {
		return org;
	}

	/**
	 * �����趨
	 * @param org ����
	 */
	public void setOrg(OrganizationTB org) {
		this.org = org;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return psodid;
	}

}