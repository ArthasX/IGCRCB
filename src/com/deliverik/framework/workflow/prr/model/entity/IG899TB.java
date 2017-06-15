/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.user.model.entity.RoleTB;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prr.model.IG899Info;

/**
  * ����: ����˽�б�����ʵ��
  * ��������: ����˽�б�����ʵ��
  * ������¼: 2012/03/27
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG899")
public class IG899TB extends BaseEntity implements Serializable,
		Cloneable, IG899Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="IG899_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG899_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG899_TABLE_GENERATOR")
	protected Integer ppiid;

	/** ���̱�������ID */
	protected String pidid;

	/** ���̱���ֵID */
	protected Integer piid;

	/** ���̲����ߵĽ�ɫID */
	protected Integer roleid;
	
	/** ���̲�����ID */
	protected String userid;

	/** ֵ */
	protected String ppivalue;

	/** �������� */
	protected String ppiattkey;
	
	/** ������ */
	protected String orgid;
	
	/** ��ע */
	protected String ppicommect;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPpiid() {
		return ppiid;
	}

	/**
	 * �����趨
	 *
	 * @param Ppiid ����
	 */
	public void setPpiid(Integer ppiid) {
		this.ppiid = ppiid;
	}

	/**
	 * ���̱�������IDȡ��
	 *
	 * @return ���̱�������ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ���̱�������ID�趨
	 *
	 * @param Pidid ���̱�������ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ���̱���ֵIDȡ��
	 *
	 * @return ���̱���ֵID
	 */
	public Integer getPiid() {
		return piid;
	}

	/**
	 * ���̱���ֵID�趨
	 *
	 * @param Piid ���̱���ֵID
	 */
	public void setPiid(Integer piid) {
		this.piid = piid;
	}

	/**
	 * ���̲����ߵĽ�ɫIDȡ��
	 *
	 * @return ���̲����ߵĽ�ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ���̲����ߵĽ�ɫID�趨
	 *
	 * @param roleid ���̲����ߵĽ�ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ֵȡ��
	 *
	 * @return ֵ
	 */
	public String getPpivalue() {
		return ppivalue;
	}

	/**
	 * ֵ�趨
	 *
	 * @param Ppivalue ֵ
	 */
	public void setPpivalue(String ppivalue) {
		this.ppivalue = ppivalue;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPpiattkey() {
		return ppiattkey;
	}

	/**
	 * ���������趨
	 *
	 * @param Ppiattkey ��������
	 */
	public void setPpiattkey(String ppiattkey) {
		this.ppiattkey = ppiattkey;
	}

	/**
	 * ���̲�����IDȡ��
	 * 
	 * @return ���̲�����ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ���̲�����ID�趨
	 * 
	 * @param userid ���̲�����ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return ppiid;
	}

	/** �û���Ϣʵ�� */
	@OneToOne
	@JoinColumn(name="userid", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected UserTB userTB;
	
	public UserTB getUserTB() {
		return userTB;
	}
	public void setUserTB(UserTB userTB) {
		this.userTB = userTB;
	}
	
	/** ��ɫʵ�� */
	@OneToOne
	@JoinColumn(name="roleid", referencedColumnName="roleid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected RoleTB roleTB;
	
	public RoleTB getRoleTB() {
		return roleTB;
	}
	public void setRoleTB(RoleTB roleTB) {
		this.roleTB = roleTB;
	}
	
	/**
	 * ����״̬ǰ�������
	 */
	@ManyToOne
	@JoinColumn(name = "piid", referencedColumnName="pidgid", insertable=false, updatable=false)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG007TB processInfoDef;

	/**
	 * ������ȡ��
	 * @return �������趨
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * �������趨
	 * @param orgid ������
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	
	/** ������Ϣ */
	@OneToOne
	@JoinColumn(name="orgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB org;

	/**
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public OrganizationTB getOrg() {
		return org;
	}

	/**
	 * ������Ϣ�趨
	 * @param org ������Ϣ
	 */
	public void setOrg(OrganizationTB org) {
		this.org = org;
	}

	/**
	 * ��עȡ��
	 * @return ppicommect ��ע
	 */
	public String getPpicommect() {
		return ppicommect;
	}

	/**
	 * ��ע�趨
	 * @param ppicommect ��ע
	 */
	public void setPpicommect(String ppicommect) {
		this.ppicommect = ppicommect;
	}
}