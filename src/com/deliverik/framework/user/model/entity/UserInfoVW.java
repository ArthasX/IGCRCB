package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.user.model.UserInfo;


/**
 * <p>
 * �û���Ϣʵ��
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@IdClass(UserInfoVWPK.class)
@Table(name="UserInfoVW")
public class UserInfoVW implements Serializable, Cloneable, UserInfo {

	/** �û�ID */
	@Id
	protected String userida;
	
	/** �û����� */
	protected String username;

	/** �û����� */
	protected String password;

	/** �û�˵�� */
	protected String userdesc;

	/** �û���Ϣ */
	protected String userinfo;

	/** �û����� */
	protected String usertype;

	/** �û�״̬ */
	protected String userstatus;

	/** �û��绰 */
	protected String userphone;

	/** �û��ֻ� */
	protected String usermobile;

	/** �û����� */
	protected String useremail;
	
	/** �û���ɫID */
	@Id
	protected Integer roleida;

	/** �û���ɫ���� */
	protected String rolename;

	/** �û���ɫ˵�� */
	protected String roledesc;

	/** �û���ɫ��Ϣ */
	protected String roleinfo;

	/** �û���ɫ���� */
	protected String roletype;

	/** �û���������� */
	protected String orgida;

	/** �û��������� */
	protected String orgname;

	/** �û�����˵�� */
	protected String orgdesc;

	/** �û�������Ϣ */
	protected String orginfo;

	/** �û��������� */
	protected String orgtype;

	/** �û��������ϼ���������� */
	protected String orgpar;

	/** �û��������ϼ��������� */
	protected String orgparname;

	/** �û�������ַ */
	protected String orgaddr;

	/** �û������绰 */
	protected String orgphone;

	/** �û��������� */
	protected String orgfax;

	/** �û�������ϵ�� */
	protected String orgcontact;

	/** �û�����״̬ */
	protected String orgstatus;

	/** �û���ɫ�ʲ�����Χ */
	protected String rolemanager;
	
	/** �߼�ɾ����־λ */
	protected String deleteflag;
	
	/** �û��Ƿ�ֵ���˱�ʶ */
	protected String dutyflag;
	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserida() {
		return userida;
	}

	/**
	 * �û�ID�趨
	 *
	 * @param userida �û�ID
	 */
	public void setUserida(String userida) {
		this.userida = userida;
	}

	/**
	 * �û�����ȡ��
	 * @return �û�����
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
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * �û������趨
	 *
	 * @param password �û�����
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * �û�˵��ȡ��
	 * @return �û�˵��
	 */
	public String getUserdesc() {
		return userdesc;
	}

	/**
	 * �û�˵���趨
	 *
	 * @param userdesc �û�˵��
	 */
	public void setUserdesc(String userdesc) {
		this.userdesc = userdesc;
	}

	/**
	 * �û���Ϣȡ��
	 * @return �û���Ϣ
	 */
	public String getUserinfo() {
		return userinfo;
	}

	/**
	 * �û���Ϣ�趨
	 *
	 * @param userinfo �û���Ϣ
	 */
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}

	/**
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getUsertype() {
		return usertype;
	}

	/**
	 * �û������趨
	 *
	 * @param usertype �û�����
	 */
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	/**
	 * �û�״̬ȡ��
	 * @return �û�״̬
	 */
	public String getUserstatus() {
		return userstatus;
	}

	/**
	 * �û�״̬�趨
	 *
	 * @param userstatus �û�״̬
	 */
	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}

	/**
	 * �û��绰ȡ��
	 * @return �û��绰
	 */
	public String getUserphone() {
		return userphone;
	}

	/**
	 * �û��绰�趨
	 *
	 * @param userphone �û��绰
	 */
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	/**
	 * �û��ֻ�ȡ��
	 * @return �û��ֻ�
	 */
	public String getUsermobile() {
		return usermobile;
	}

	/**
	 * �û��ֻ��趨
	 *
	 * @param usermobile �û��ֻ�
	 */
	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	/**
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getUseremail() {
		return useremail;
	}

	/**
	 * �û������趨
	 *
	 * @param useremail �û�����
	 */
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	/**
	 * �û���ɫIDȡ��
	 * @return �û���ɫID
	 */
	public Integer getRoleida() {
		return roleida;
	}

	/**
	 * �û���ɫID�趨
	 *
	 * @param roleida �û���ɫID
	 */
	public void setRoleida(Integer roleida) {
		this.roleida = roleida;
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
	 * �û���ɫ��Ϣȡ��
	 * @return �û���ɫ��Ϣ
	 */
	public String getRoleinfo() {
		return roleinfo;
	}

	/**
	 * �û���ɫ��Ϣ�趨
	 *
	 * @param roleinfo �û���ɫ��Ϣ
	 */
	public void setRoleinfo(String roleinfo) {
		this.roleinfo = roleinfo;
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
	 * �û����������ȡ��
	 * @return �û����������
	 */
	public String getOrgida() {
		return orgida;
	}

	/**
	 * �û�����������趨
	 *
	 * @param orgida �û����������
	 */
	public void setOrgida(String orgida) {
		this.orgida = orgida;
	}

	/**
	 * �û���������ȡ��
	 * @return �û���������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * �û����������趨
	 *
	 * @param orgname �û���������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * �û�����˵��ȡ��
	 * @return �û�����˵��
	 */
	public String getOrgdesc() {
		return orgdesc;
	}

	/**
	 * �û�����˵���趨
	 *
	 * @param orgdesc �û�����˵��
	 */
	public void setOrgdesc(String orgdesc) {
		this.orgdesc = orgdesc;
	}

	/**
	 * �û�������Ϣȡ��
	 * @return �û�������Ϣ
	 */
	public String getOrginfo() {
		return orginfo;
	}

	/**
	 * �û�������Ϣ�趨
	 *
	 * @param orginfo �û�������Ϣ
	 */
	public void setOrginfo(String orginfo) {
		this.orginfo = orginfo;
	}

	/**
	 * �û���������ȡ��
	 * @return �û���������
	 */
	public String getOrgtype() {
		return orgtype;
	}

	/**
	 * �û����������趨
	 *
	 * @param orgtype �û���������
	 */
	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	/**
	 * �û��������ϼ����������ȡ��
	 * @return �û��������ϼ����������
	 */
	public String getOrgpar() {
		return orgpar;
	}

	/**
	 * �û��������ϼ�����������趨
	 *
	 * @param orgpar �û��������ϼ����������
	 */
	public void setOrgpar(String orgpar) {
		this.orgpar = orgpar;
	}

	/**
	 * �û��������ϼ���������ȡ��
	 * @return �û��������ϼ���������
	 */
	public String getOrgparname() {
		return orgparname;
	}

	/**
	 * �û��������ϼ����������趨
	 *
	 * @param orgparname �û��������ϼ���������
	 */
	public void setOrgparname(String orgparname) {
		this.orgparname = orgparname;
	}

	/**
	 * �û�������ַȡ��
	 * @return �û�������ַ
	 */
	public String getOrgaddr() {
		return orgaddr;
	}

	/**
	 * �û�������ַ�趨
	 *
	 * @param orgaddr �û�������ַ
	 */
	public void setOrgaddr(String orgaddr) {
		this.orgaddr = orgaddr;
	}

	/**
	 * �û������绰ȡ��
	 * @return �û������绰
	 */
	public String getOrgphone() {
		return orgphone;
	}

	/**
	 * �û������绰�趨
	 *
	 * @param orgphone �û������绰
	 */
	public void setOrgphone(String orgphone) {
		this.orgphone = orgphone;
	}

	/**
	 * �û���������ȡ��
	 * @return �û���������
	 */
	public String getOrgfax() {
		return orgfax;
	}

	/**
	 * �û����������趨
	 *
	 * @param orgfax �û���������
	 */
	public void setOrgfax(String orgfax) {
		this.orgfax = orgfax;
	}

	/**
	 * �û�������ϵ��ȡ��
	 * @return �û�������ϵ��
	 */
	public String getOrgcontact() {
		return orgcontact;
	}

	/**
	 * �û�������ϵ���趨
	 *
	 * @param orgcontact �û�������ϵ��
	 */
	public void setOrgcontact(String orgcontact) {
		this.orgcontact = orgcontact;
	}

	/**
	 * �û�����״̬ȡ��
	 * @return �û�����״̬
	 */
	public String getOrgstatus() {
		return orgstatus;
	}

	/**
	 * �û�����״̬�趨
	 *
	 * @param orgstatus �û�����״̬
	 */
	public void setOrgstatus(String orgstatus) {
		this.orgstatus = orgstatus;
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
		return new UserInfoVWPK(userida, roleida);
	}

	/**
	 * �߼�ɾ����־λȡ��
	 * @return �߼�ɾ����־λ
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * �߼�ɾ����־λ�趨
	 *
	 * @param deleteflag �߼�ɾ����־λ
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
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