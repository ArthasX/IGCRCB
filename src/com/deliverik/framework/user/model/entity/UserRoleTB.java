package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.UserRole;

/**
 * <p>
 * �û���ɫ��Ȩ��Ϣʵ��
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="USERROLE")
public class UserRoleTB extends BaseEntity implements Serializable, Cloneable, UserRole {

	/** �û���ɫ��ȨID */
	@Id
	@TableGenerator(
		    name="USERROLE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="USERROLE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="USERROLE_TABLE_GENERATOR")
	protected Integer urid;
	
	/** �û�ID */
	protected String userid;

	/** �û���ɫID */
	protected Integer roleid;

	/** �û���������� */
	protected String orgid;
	
	/** �û��Ƿ��ɫ�����˱�ʶ */
	protected String rolemanager;
	
	/** �û��Ƿ�ֵ���˱�ʶ */
	protected String dutyflag;

	/**
	 * �û���ɫ��ȨIDȡ��
	 * @return �û���ɫ��ȨID
	 */
	public Integer getUrid() {
		return urid;
	}

	/**
	 * �û���ɫ��ȨID�趨
	 *
	 * @param urid �û���ɫ��ȨID
	 */
	public void setUrid(Integer urid) {
		this.urid = urid;
	}

	/**
	 * �û�IDȡ��
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
	 * �û���ɫIDȡ��
	 * @return �û���ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * �û���ɫID�趨
	 *
	 * @param roleid �û���ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * �û����������ȡ��
	 * @return �û����������
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * �û�����������趨
	 *
	 * @param orgid �û����������
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * �û��Ƿ��ɫ�����˱�ʶȡ��
	 * @return �û��Ƿ��ɫ�����˱�ʶ
	 */
	public String getRolemanager() {
		return rolemanager;
	}

	/**
	 * �û��Ƿ��ɫ�����˱�ʶ�趨
	 *
	 * @param rolemanager �û��Ƿ��ɫ�����˱�ʶ
	 */
	public void setRolemanager(String rolemanager) {
		this.rolemanager = rolemanager;
	}

	/**
	 * ��ȡ����
	 * @return ����
	 */
	public Serializable getPK() {
		return urid;
	}

	/**
	 * �û��Ƿ�ֵ���˱�ʶȡ��
	 * @return �û��Ƿ�ֵ���˱�ʶ
	 */
	public String getDutyflag() {
		return dutyflag;
	}

	/**
	 * �û��Ƿ�ֵ���˱�ʶ�趨
	 *
	 * @param rolemanager �û��Ƿ�ֵ���˱�ʶ
	 */
	public void setDutyflag(String dutyflag) {
		this.dutyflag = dutyflag;
	}
	
	

}
