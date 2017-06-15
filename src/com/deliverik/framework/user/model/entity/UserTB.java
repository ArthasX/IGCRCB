package com.deliverik.framework.user.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.StringEncrypt;


/**
 * <p>
 * �û���Ϣʵ��
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IgUser")
public class UserTB extends BaseEntity implements Serializable, Cloneable, User ,LogicalDelete {

	/** �û�ID */
	@Id
	protected String userid;
	
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

	/** �û���������� */
	protected String orgid;

	/** �û��������� */
	protected String orgname;
	
	/** �߼�ɾ����־λ */
	protected String deleteflag;
	
	/** �û�������Ϣʵ�� */
	@Transient
	protected OrganizationTB organizationTB;
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
		if(StringUtils.isEmpty(password)) {
			return password;
		} else {
			return StringEncrypt.asciiToChar(password);
		}
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
	 * ��ȡ����
	 * @return ����
	 */
	public Serializable getPK() {
		return userid;
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
//ҵ�������� drm


	
	
	/**
	 * �û�������Ϣʵ��ȡ��
	 * @return �û�������Ϣʵ��
	 */
	public OrganizationTB getOrganizationTB() {
		if(this.organizationTB == null){
			if(StringUtils.isNotEmpty(this.orgid)){
				OrganizationBL bl = (OrganizationBL) WebApplicationSupport.getBean("organizationBL");
				OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
				cond.setOrgsyscoding(this.orgid);
				List<Organization> list = bl.searchOrganization(cond);
				if(list.size() == 1){
					this.organizationTB = (OrganizationTB) list.get(0);
				}
			}
		}
		return organizationTB;
	}

	/**
	 * �û�������Ϣʵ���趨
	 *
	 * @param organizationTB �û�������Ϣʵ��
	 */
	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}

}
