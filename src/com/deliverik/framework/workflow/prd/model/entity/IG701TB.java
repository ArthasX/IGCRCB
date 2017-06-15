/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG701Info;

/**
  * ����: ���̲鿴��ɫ��Ȩ����ʵ��
  * ��������: ���̲鿴��ɫ��Ȩ����ʵ��
  * ������¼: 2012/10/15
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG701PK.class)
@Table(name="ig701")
public class IG701TB extends BaseEntity implements Serializable,
		Cloneable, IG701Info {

	/** ���̶���ID */
	@Id
	protected String pdid;

	/** ��ɫID */
	@Id
	protected Integer roleid;

	/** ��ID */
	@Id
	protected String pidid;
	
	/** ����Ϣ */
	@ManyToOne
	@JoinColumn(name="pidid", referencedColumnName="pidid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG007TB processInfoDef;

	/**
	 * ���̶���IDȡ��
	 *
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 *
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ��ɫIDȡ��
	 *
	 * @return ��ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ��ɫID�趨
	 *
	 * @param roleid ��ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ��IDȡ��
	 *
	 * @return ��ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ��ID�趨
	 *
	 * @param pidid ��ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new IG701PK(pdid, roleid,pidid);
	}

	/**
	 * ����Ϣȡ��
	 * @return ����Ϣ
	 */
	public IG007TB getProcessInfoDef() {
		return processInfoDef;
	}

	/**
	 * ����Ϣ�趨
	 * @param processInfoDef����Ϣ
	 */
	public void setProcessInfoDef(IG007TB processInfoDef) {
		this.processInfoDef = processInfoDef;
	}

}