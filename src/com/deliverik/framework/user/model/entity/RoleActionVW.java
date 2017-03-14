package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.user.model.RoleActionInfo;

/**
 * <p>
 * ��ɫ�˵���Ȩ��Ϣʵ��
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="RoleActionVW")
public class RoleActionVW implements Serializable, Cloneable, RoleActionInfo {
	
	/** ��ɫ�˵���ȨID */
	@Id
	protected Integer raid;
	
	/** ��ɫID */
	protected Integer roleid;

	/** �˵�ID */
	protected String actname;
	
	/** ��ɫ���ڲ˵���Ȩ�� */
	protected String raperm;

	/** ��ɫ���ڲ˵���Ȩ�޵�˵�� */
	protected String radesc;

	/** �˵���ʾ���� */
	protected String actlabel;

	/** �˵����� */
	protected String actdesc;

	/** �˵�URL */
	protected String acturl;

	/** �˵����� */
	protected String acttype;
	
	/** �˵�����ID*/
	protected String actsortid;
	
	/** �˵�URL���� */
	protected String acturltype;

	/**
	 * ��ɫ�˵���ȨIDȡ��
	 * @return ��ɫ�˵���ȨID
	 */
	public Integer getRaid() {
		return raid;
	}

	/**
	 * ��ɫ�˵���ȨID�趨
	 *
	 * @param raid ��ɫ�˵���ȨID
	 */
	public void setRaid(Integer raid) {
		this.raid = raid;
	}

	/**
	 * ��ɫIDȡ��
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
	 * �˵�IDȡ��
	 * @return �˵�ID
	 */
	public String getActname() {
		return actname;
	}

	/**
	 * �˵�ID�趨
	 *
	 * @param actname �˵�ID
	 */
	public void setActname(String actname) {
		this.actname = actname;
	}

	/**
	 * ��ɫ���ڲ˵���Ȩ��ȡ��
	 * @return ��ɫ���ڲ˵���Ȩ��
	 */
	public String getRaperm() {
		return raperm;
	}

	/**
	 * ��ɫ���ڲ˵���Ȩ���趨
	 *
	 * @param raperm ��ɫ���ڲ˵���Ȩ��
	 */
	public void setRaperm(String raperm) {
		this.raperm = raperm;
	}

	/**
	 * ��ɫ���ڲ˵���Ȩ��˵��ȡ��
	 * @return ��ɫ���ڲ˵���Ȩ��˵��
	 */
	public String getRadesc() {
		return radesc;
	}

	/**
	 * ��ɫ���ڲ˵���Ȩ��˵���趨
	 *
	 * @param radesc ��ɫ���ڲ˵���Ȩ��˵��
	 */
	public void setRadesc(String radesc) {
		this.radesc = radesc;
	}

	/**
	 * �˵���ʾ����ȡ��
	 * @return �˵���ʾ����
	 */
	public String getActlabel() {
		return actlabel;
	}

	/**
	 * �˵���ʾ�����趨
	 *
	 * @param actlabel �˵���ʾ����
	 */
	public void setActlabel(String actlabel) {
		this.actlabel = actlabel;
	}

	/**
	 * �˵�����ȡ��
	 * @return �˵�����
	 */
	public String getActdesc() {
		return actdesc;
	}

	/**
	 * �˵������趨
	 *
	 * @param actdesc �˵�����
	 */
	public void setActdesc(String actdesc) {
		this.actdesc = actdesc;
	}

	/**
	 * �˵�URLȡ��
	 * @return �˵�URL
	 */
	public String getActurl() {
		return acturl;
	}

	/**
	 * �˵�URL�趨
	 *
	 * @param acturl �˵�URL
	 */
	public void setActurl(String acturl) {
		this.acturl = acturl;
	}

	/**
	 * �˵�����ȡ��
	 * @return �˵�����
	 */
	public String getActtype() {
		return acttype;
	}

	/**
	 * �˵������趨
	 *
	 * @param acttype �˵�����
	 */
	public void setActtype(String acttype) {
		this.acttype = acttype;
	}
	
	/**
	 * �˵�����IDȡ��
	 * @return �˵�����ID
	 */
	public String getActsortid() {
		return actsortid;
	}

	/**
	 * �˵�����ID�趨
	 * @param actsortid �˵�����ID
	 */
	public void setActsortid(String actsortid) {
		this.actsortid = actsortid;
	}
	
	/**
	 * �˵�URL����ȡ��
	 * @return �˵�URL����
	 */
	public String getActurltype() {
		return acturltype;
	}

	/**
	 * �˵�URL�����趨
	 *
	 * @param acturltype �˵�URL����
	 */
	public void setActurltype(String acturltype) {
		this.acturltype = acturltype;
	}

	/**
	 * ��ȡ����
	 * @return ����
	 */
	public Serializable getPK() {
		return raid;
	}

	/**
	 * �Ƚ����������Ƿ���ͬ
	 * @param obj
	 * @return �ȽϽ����true��ͬ��false��ͬ��
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof RoleActionVW))
			return false;
		RoleActionInfo target = (RoleActionInfo) obj;
		if (!(getRaid()==target.getRaid()))
			return false;

		return true;
	}

}
