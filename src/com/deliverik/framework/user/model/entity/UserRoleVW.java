package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * <p>
 * �û���ɫ��Ȩ��Ϣʵ��
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="UserRoleVW")
public class UserRoleVW implements Serializable, Cloneable, UserRoleInfo {

	/** �û���ɫ��ȨID */
	@Id
	protected Integer urid;
	
	/** �û�ID */
	protected String userid;
	
	/** �û����� */
	protected String username;

	/** �û���ɫID */
	protected Integer roleid;

	/** �û���ɫ���� */
	protected String rolename;
	
	/** �û���ɫ˵�� */
	protected String roledesc;
	
	/** �û���ɫ���� */
	protected String roletype;
	
	/** �û���ɫ��������Χ */
	protected String roledomain;
	
	/** �û���ɫ�ʲ�����Χ */
	protected String assetdomain;
	
	/** �û��Ƿ��ɫ�����˱�ʶ */
	protected String rolemanager;
	
	/** ����syscoding */
	protected String orgid;
	
	/** ��������*/
	protected String orgname;
	
	/** �û��Ƿ�ֵ���˱�ʶ */
	protected String dutyflag;
	
	/** �û����� */
	protected String userinfo;
	
	/** �û��ֻ� */
	protected String usermobile;
	
	/** �û����� */
	protected String useremail;

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
	 * �û�����ȡ��
	 *
	 * @return username �û�����
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * �û������趨
	 *
	 * @param username �û�����
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * ����syscodingȡ��
	 *
	 * @return orgid ����syscoding
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * ����syscoding�趨
	 *
	 * @param orgid ����syscoding
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return orgname ��������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ���������趨
	 *
	 * @param orgname ��������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
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
	 * �û���ɫ����ȡ��
	 * @return �û���ɫ����
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * �û���ɫ�����趨
	 *
	 * @param rolename �û���ɫ����
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * �û���ɫ˵��ȡ��
	 * @return �û���ɫ˵��
	 */
	public String getRoledesc() {
		return roledesc;
	}

	/**
	 * �û���ɫ˵���趨
	 *
	 * @param roledesc �û���ɫ˵��
	 */
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	/**
	 * �û���ɫ����ȡ��
	 * @return �û���ɫ����
	 */
	public String getRoletype() {
		return roletype;
	}

	/**
	 * �û���ɫ�����趨
	 *
	 * @param roletype �û���ɫ����
	 */
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	/**
	 * �û���ɫ��������Χȡ��
	 * @return �û���ɫ��������Χ
	 */
	public String getRoledomain() {
		return roledomain;
	}

	/**
	 * �û���ɫ��������Χ�趨
	 *
	 * @param roledomain �û���ɫ��������Χ
	 */
	public void setRoledomain(String roledomain) {
		this.roledomain = roledomain;
	}

	/**
	 * �û���ɫ�ʲ�����Χȡ��
	 * @return �û���ɫ�ʲ�����Χ
	 */
	public String getAssetdomain() {
		return assetdomain;
	}

	/**
	 * �û���ɫ�ʲ�����Χ�趨
	 *
	 * @param assetdomain �û���ɫ�ʲ�����Χ
	 */
	public void setAssetdomain(String assetdomain) {
		this.assetdomain = assetdomain;
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
	
	/**
	 * �û�����ȡ��
	 * @return userinfo �û�����
	 */
	public String getUserinfo() {
		return userinfo;
	}

	/**
	 * �û������趨
	 * @param userinfo �û�����
	 */
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}

	/**
	 * �û��ֻ�ȡ��
	 * @return usermobile �û��ֻ�
	 */
	public String getUsermobile() {
		return usermobile;
	}

	/**
	 * �û��ֻ��趨
	 * @param usermobile �û��ֻ�
	 */
	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	/**
	 * �û�����ȡ��
	 * @return useremail �û�����
	 */
	public String getUseremail() {
		return useremail;
	}

	/**
	 * �û������趨
	 * @param useremail �û�����
	 */
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

}
