package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.Role;


/**
 * <p>
 * ��ɫ��Ϣʵ��
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="ROLE")
public class RoleTB extends BaseEntity implements Serializable, Cloneable, Role {

	/** ��ɫID */
	@Id
	@TableGenerator(
		    name="ROLE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="ROLE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ROLE_TABLE_GENERATOR")
	protected Integer roleid;
	
	/** ��ɫ���� */
	protected String rolename;

	/** ��ɫ˵�� */
	protected String roledesc;

	/** ��ɫ��Ϣ */
	protected String roleinfo;

	/** ��ɫ���� */
	protected String roletype;

	/** ��ɫ��������Χ */
	protected String roledomain;

	/** ��ɫ�ʲ�����Χ */
	protected String assetdomain;

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
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * ��ɫ�����趨
	 *
	 * @param rolename ��ɫ����
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * ��ɫ˵��ȡ��
	 * @return ��ɫ˵��
	 */
	public String getRoledesc() {
		return roledesc;
	}

	/**
	 * ��ɫ˵���趨
	 *
	 * @param roledesc ��ɫ˵��
	 */
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	/**
	 * ��ɫ��Ϣȡ��
	 * @return ��ɫ��Ϣ
	 */
	public String getRoleinfo() {
		return roleinfo;
	}

	/**
	 * ��ɫ��Ϣ�趨
	 *
	 * @param roleinfo ��ɫ��Ϣ
	 */
	public void setRoleinfo(String roleinfo) {
		this.roleinfo = roleinfo;
	}
	
	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public String getRoletype() {
		return roletype;
	}

	/**
	 * ��ɫ�����趨
	 *
	 * @param roletype ��ɫ����
	 */
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}
	
	/**
	 * ��ɫ��������Χȡ��
	 * @return ��ɫ��������Χ
	 */
	public String getRoledomain() {
		return roledomain;
	}
	
	/**
	 * ��ɫ��������Χ�趨
	 *
	 * @param roledomain ��ɫ��������Χ
	 */
	public void setRoledomain(String roledomain) {
		this.roledomain = roledomain;
	}
	
	/**
	 * ��ɫ�ʲ�����Χȡ��
	 * @return ��ɫ�ʲ�����Χ
	 */
	public String getAssetdomain() {
		return assetdomain;
	}

	/**
	 * ��ɫ�ʲ�����Χ�趨
	 *
	 * @param assetdomain ��ɫ�ʲ�����Χ
	 */
	public void setAssetdomain(String assetdomain) {
		this.assetdomain = assetdomain;
	}

	/**
	 * ��ȡ����
	 * @return ����
	 */
	public Serializable getPK() {
		return roleid;
	}

	/**
	 * �Ƚ����������Ƿ���ͬ
	 * @param obj
	 * @return �ȽϽ����true��ͬ��false��ͬ��
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof RoleTB))
			return false;
		RoleTB target = (RoleTB) obj;
		if (!(getRoleid()==target.getRoleid()))
			return false;

		return true;
	}

}
