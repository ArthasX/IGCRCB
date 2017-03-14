package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.RoleAction;

/**
 * <p>
 * ��ɫ�˵���Ȩ��Ϣʵ��
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="RoleAction")
public class RoleActionTB extends BaseEntity implements Serializable, Cloneable, RoleAction {

	/** ��ɫ�˵���ȨID */
	@Id
	@TableGenerator(
		    name="ROLEACTION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="ROLEACTION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ROLEACTION_TABLE_GENERATOR")
	protected Integer raid;
	
	/** ��ɫID */
	protected Integer roleid;
	
	/** �˵�ID */
	protected String actname;

	/** ��ɫ���ڲ˵���Ȩ�� */
	protected String raperm;

	/** ��ɫ���ڲ˵���Ȩ�޵�˵�� */
	protected String radesc;

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
		this.actname= actname;
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
	 * ��ɫ���ڲ˵���Ȩ�޵�˵��ȡ��
	 * @return ��ɫ���ڲ˵���Ȩ�޵�˵��
	 */
	public String getRadesc() {
		return radesc;
	}

	/**
	 * ��ɫ���ڲ˵���Ȩ�޵�˵���趨
	 *
	 * @param radesc ��ɫ���ڲ˵���Ȩ�޵�˵��
	 */
	public void setRadesc(String radesc) {
		this.radesc = radesc;
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
		if (!(obj instanceof RoleActionTB))
			return false;
		RoleAction target = (RoleAction) obj;
		if (!(getRaid()==target.getRaid()))
			return false;

		return true;
	}

}
