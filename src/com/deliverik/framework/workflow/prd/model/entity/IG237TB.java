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
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prd.model.IG237Info;

/**
  * ����: ���̲���֪ͨ��ʵ��
  * ��������: ���̲���֪ͨ��ʵ��
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG237PK.class)
@Table(name="IG237")
public class IG237TB extends BaseEntity implements Serializable,
		Cloneable, IG237Info {

	/** ״̬ID */
	@Id
	protected String psdid;

	/** �Ƿ�ȷ�� */
	@Id
	protected String psdconfirm;

	/** �û�ID */
	@Id
	protected String userid;
	
	/** ��ֵ */
	@Id
	protected String pivalue;
	
	/** ��ɫID */
	protected Integer roleid;
	
	/** �û���Ϣ */
	@ManyToOne
	@JoinColumn(name="userid", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected UserTB user;

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
	 * �Ƿ�ȷ��ȡ��
	 *
	 * @return �Ƿ�ȷ��
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * �Ƿ�ȷ���趨
	 *
	 * @param psdconfirm �Ƿ�ȷ��
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}

	/**
	 * �û�IDȡ��
	 *
	 * @return �û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�ID�趨
	 *
	 * @param userid �û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	/**
	 * ��ֵȡ��
	 * @return pivalue ��ֵ
	 */
	public String getPivalue() {
		return pivalue;
	}

	/**
	 * ��ֵ�趨
	 * @param pivalue ��ֵ
	 */
	public void setPivalue(String pivalue) {
		this.pivalue = pivalue;
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
	 * �û���Ϣȡ��
	 * 
	 * @return �û���Ϣ
	 */
	public UserTB getUser() {
		return user;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new IG237PK(psdid, psdconfirm, userid, pivalue);
	}

}