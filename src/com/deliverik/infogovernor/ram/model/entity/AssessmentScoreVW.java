/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ram.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;

/**
  * ����: ������ʷ��ѯʵ��
  * ��������: ������ʷ��ѯʵ��
  * ������¼: 2013/10/10
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="AssessmentScoreVW")
public class AssessmentScoreVW extends BaseEntity implements Serializable,
		Cloneable, AssessmentScoreVWInfo {

	/** ���� */
	@Id
	protected Integer ppiid;

	/** ���б�id */
	protected Integer piid;

	/** ����id */
	protected Integer prid;

	/** ���� */
	protected String pivarname;

	/** ������ */
	protected String pivarlabel;

	/** ������ */
	protected String pivartype;

	/** ��id */
	protected String pidid;

	/** ��ɫid */
	protected String roleid;

	/** �û�id */
	protected String userid;

	/** ˽�б�ֵ */
	protected String ppivalue;

	/** ������ */
	protected String orgid;

	/** �û��� */
	protected String username;
	
	/** ˽�б�����  */
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
	 * @param ppiid ����
	 */
	public void setPpiid(Integer ppiid) {
		this.ppiid = ppiid;
	}

	/**
	 * ���б�idȡ��
	 *
	 * @return ���б�id
	 */
	public Integer getPiid() {
		return piid;
	}

	/**
	 * ���б�id�趨
	 *
	 * @param piid ���б�id
	 */
	public void setPiid(Integer piid) {
		this.piid = piid;
	}

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����id�趨
	 *
	 * @param prid ����id
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPivarname() {
		return pivarname;
	}

	/**
	 * �����趨
	 *
	 * @param pivarname ����
	 */
	public void setPivarname(String pivarname) {
		this.pivarname = pivarname;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPivarlabel() {
		return pivarlabel;
	}

	/**
	 * �������趨
	 *
	 * @param pivarlabel ������
	 */
	public void setPivarlabel(String pivarlabel) {
		this.pivarlabel = pivarlabel;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPivartype() {
		return pivartype;
	}

	/**
	 * �������趨
	 *
	 * @param pivartype ������
	 */
	public void setPivartype(String pivartype) {
		this.pivartype = pivartype;
	}

	/**
	 * ��idȡ��
	 *
	 * @return ��id
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ��id�趨
	 *
	 * @param pidid ��id
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ��ɫidȡ��
	 *
	 * @return ��ɫid
	 */
	public String getRoleid() {
		return roleid;
	}

	/**
	 * ��ɫid�趨
	 *
	 * @param roleid ��ɫid
	 */
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	/**
	 * �û�idȡ��
	 *
	 * @return �û�id
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�id�趨
	 *
	 * @param userid �û�id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ˽�б�ֵȡ��
	 *
	 * @return ˽�б�ֵ
	 */
	public String getPpivalue() {
		return ppivalue;
	}

	/**
	 * ˽�б�ֵ�趨
	 *
	 * @param ppivalue ˽�б�ֵ
	 */
	public void setPpivalue(String ppivalue) {
		this.ppivalue = ppivalue;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * �������趨
	 *
	 * @param orgid ������
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * �û���ȡ��
	 *
	 * @return �û���
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * �û����趨
	 *
	 * @param username �û���
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * ppicommectȡ��
	 */
	public String getPpicommect() {
		return ppicommect;
	}

	/**
	 * ppicommect�趨
	 */
	public void setPpicommect(String ppicommect) {
		this.ppicommect = ppicommect;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return ppiid;
	}

}