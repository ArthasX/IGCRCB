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
import com.deliverik.framework.user.model.entity.RoleTB;
import com.deliverik.framework.workflow.prd.model.IG700Info;

/**
  * ����: ���̲鿴��ɫ���ñ�ʵ��
  * ��������: ���̲鿴��ɫ���ñ�ʵ��
  * ������¼: 2012/10/15
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG700PK.class)
@Table(name="ig700")
public class IG700TB extends BaseEntity implements Serializable,
		Cloneable, IG700Info {

	/** ���̶���ID */
	@Id
	protected String pdid;

	/** ��ɫID */
	@Id
	protected Integer roleid;
	
	/** ��ɫ��Ϣ */
	@ManyToOne
	@JoinColumn(name="roleid", referencedColumnName="roleid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected RoleTB roleTB;

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
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new IG700PK(pdid, roleid);
	}

	public RoleTB getRoleTB() {
		return roleTB;
	}

	public void setRoleTB(RoleTB roleTB) {
		this.roleTB = roleTB;
	}

}