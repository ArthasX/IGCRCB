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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.entity.RoleTB;
import com.deliverik.framework.workflow.prd.model.IG298Info;

/**
  * ����: ����״̬�ɷ��ɽ�ɫ������Ϣʵ��
  * ��������: ����״̬�ɷ��ɽ�ɫ������Ϣʵ��
  * ������¼: 2012/04/11
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG298")
public class IG298TB extends BaseEntity implements Serializable,
		Cloneable, IG298Info {

	/** ���� */
	@Id
	protected String psrdid;

	/** ״̬ID */
	protected String psdid;

	/** ��ɫID */
	protected Integer roleid;
	
	/** ��ɫ��Ϣ */
	@ManyToOne
	@JoinColumn(name="roleid", referencedColumnName="roleid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected RoleTB role;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPsrdid() {
		return psrdid;
	}

	/**
	 * �����趨
	 *
	 * @param psrdid ����
	 */
	public void setPsrdid(String psrdid) {
		this.psrdid = psrdid;
	}

	/**
	 * ״̬IDȡ��
	 *
	 * @return ״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬ID�趨
	 *
	 * @param psdid ״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
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
		return psrdid;
	}

	/**
	 * ��ɫ��Ϣȡ��
	 * 
	 * @return ��ɫ��Ϣ
	 */
	public Role getRole() {
		return role;
	}

}