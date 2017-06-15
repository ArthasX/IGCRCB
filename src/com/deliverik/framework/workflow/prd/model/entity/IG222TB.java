/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.user.model.entity.RoleTB;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prd.model.IG222Info;

/**
 * <p>����:���̲����߶���ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG222")
public class IG222TB extends BaseEntity implements Serializable, Cloneable, IG222Info {
	
	/** ���̲�����ID */
	@Id
	protected String ppdid;
	
	/**
	 * ����״̬ID
	 */
	protected String psdid;
	
	/**
	 * ���̲����߽�ɫID
	 */
	protected Integer roleid;
	
	/**
	 * ���̲�����ID
	 */
	protected String userid;
	
	/**
	 * ����super�����߱�ʶ
	 */
	protected String ppdsuper;
	
	/** ������ */
	protected String orgid;
	

	
	/** ��ɫ */
	@OneToOne
	@JoinColumn(name="roleid", referencedColumnName="roleid",  updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected RoleTB role;
	
	/** �û� */
	@OneToOne
	@JoinColumn(name="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected UserTB user;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="ppdid", referencedColumnName="ppdid", updatable=false, insertable= false)
	@NotFound(action = NotFoundAction.IGNORE)
	protected List<IG132TB> ProcessParticipantButtonDefList;
	
	/** ���� */
	@OneToOne
	@JoinColumn(name="orgid",referencedColumnName="orgsyscoding", updatable=false, insertable= false )
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB org;
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return ppdid;
	}
	
	/**
	 * ���ܣ����̲�����IDȡ��
	 * @return ���̲�����ID
	 */
	public String getPpdid() {
		return ppdid;
	}

	/**
	 * ���ܣ����̲�����ID�趨
	 * @param ppdid ���̲�����ID
	 */
	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}

	/**
	 * ���ܣ�����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ���ܣ�����״̬ID�趨
	 * @param psdid ����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ���ܣ����̲����߽�ɫIDȡ��
	 * @return ���̲����߽�ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ���ܣ����̲����߽�ɫID�趨
	 * @param roleid ���̲����߽�ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	
	/**
	 * ���ܣ�����super�����߱�ʶȡ��
	 * @return ����super�����߱�ʶ
	 */
	public String getPpdsuper() {
		return ppdsuper;
	}

	/**
	 * ���ܣ�����super�����߱�ʶ�趨
	 * @param ppdsuper ����super�����߱�ʶ
	 */
	public void setPpdsuper(String ppdsuper) {
		this.ppdsuper = ppdsuper;
	}

	/**
	 * ���ܣ���ɫȡ��
	 * @return ��ɫ
	 */
	public RoleTB getRole() {
		return role;
	}

	/**
	 * ���ܣ���ɫ�趨
	 * @param role ��ɫ
	 */
	public void setRole(RoleTB role) {
		this.role = role;
	}

	/**
	 * ���ܣ����̲�����IDȡ��
	 * @return ���̲�����ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ���ܣ����̲�����ID�趨
	 * @param userid ���̲�����ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ���ܣ��û�ȡ��
	 * @return �û�
	 */
	public UserTB getUser() {
		return user;
	}

	/**
	 * ���ܣ��û��趨
	 * @param user �û�
	 */
	public void setUser(UserTB user) {
		this.user = user;
	}
	
	public List<IG132TB> getProcessParticipantButtonDefList() {
		return ProcessParticipantButtonDefList;
	}

	public void setProcessParticipantButtonDefList(
			List<IG132TB> processParticipantButtonDefList) {
		ProcessParticipantButtonDefList = processParticipantButtonDefList;
	}

	/**
	 * ������ȡ��
	 * @return ������
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

}
