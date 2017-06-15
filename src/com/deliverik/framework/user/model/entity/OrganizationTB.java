package com.deliverik.framework.user.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;


/**
 * <p>
 * ������Ϣʵ��
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="ORGANIZATION")
public class OrganizationTB extends BaseEntity implements Serializable, Cloneable, Organization {
	
	/** ����ID */
	@Id
	@TableGenerator(
		    name="ORGANIZATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="ORGANIZATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ORGANIZATION_TABLE_GENERATOR")
	protected Integer orgid;
	
	/** �������� */
	protected String orgname;

	/** ����˵�� */
	protected String orgdesc;

	/** ������Ϣ */
	protected String orginfo;

	/** �������� */
	protected String orgtype;

	/** �ϼ���������� */
	protected String orgpar;

	/** �ϼ��������� */
	protected String orgparname;

	/** ������ַ */
	protected String orgaddr;

	/** �����绰 */
	protected String orgphone;

	/** �������� */
	protected String orgfax;

	/** ������ϵ�� */
	protected String orgcontact;

	/** ����״̬ */
	protected String orgstatus;

	/** ��������� */
	protected String orgsyscoding;
	
	/** �������� */
	protected String orgusercoding;

	/** ������Ϣʵ�� */
	@Transient
	protected OrganizationTB organizationTB;
	

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getOrgid() {
		return orgid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param orgid ����ID
	 */
	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
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
	 * ����˵��ȡ��
	 * @return ����˵��
	 */
	public String getOrgdesc() {
		return orgdesc;
	}

	/**
	 * ����˵���趨
	 *
	 * @param orgdesc ����˵��
	 */
	public void setOrgdesc(String orgdesc) {
		this.orgdesc = orgdesc;
	}

	/**
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public String getOrginfo() {
		return orginfo;
	}

	/**
	 * ������Ϣ�趨
	 *
	 * @param orginfo ������Ϣ
	 */
	public void setOrginfo(String orginfo) {
		this.orginfo = orginfo;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getOrgtype() {
		return orgtype;
	}

	/**
	 * ���������趨
	 *
	 * @param orgtype ��������
	 */
	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	/**
	 * ������ַȡ��
	 * @return ������ַ
	 */
	public String getOrgaddr() {
		return orgaddr;
	}

	/**
	 * ������ַ�趨
	 *
	 * @param orgaddr ������ַ
	 */
	public void setOrgaddr(String orgaddr) {
		this.orgaddr = orgaddr;
	}

	/**
	 * �����绰ȡ��
	 * @return �����绰
	 */
	public String getOrgphone() {
		return orgphone;
	}

	/**
	 * �����绰�趨
	 *
	 * @param orgphone �����绰
	 */
	public void setOrgphone(String orgphone) {
		this.orgphone = orgphone;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getOrgfax() {
		return orgfax;
	}

	/**
	 * ���������趨
	 *
	 * @param orgfax ��������
	 */
	public void setOrgfax(String orgfax) {
		this.orgfax = orgfax;
	}

	/**
	 * ������ϵ��ȡ��
	 * @return ������ϵ��
	 */
	public String getOrgcontact() {
		return orgcontact;
	}

	/**
	 * ������ϵ���趨
	 *
	 * @param orgcontact ������ϵ��
	 */
	public void setOrgcontact(String orgcontact) {
		this.orgcontact = orgcontact;
	}

	/**
	 * ����״̬ȡ��
	 * @return ����״̬
	 */
	public String getOrgstatus() {
		return orgstatus;
	}

	/**
	 * ����״̬�趨
	 *
	 * @param orgstatus ����״̬
	 */
	public void setOrgstatus(String orgstatus) {
		this.orgstatus = orgstatus;
	}
	
	/**
	 * �ϼ���������ȡ��
	 * @return �ϼ���������
	 */
	public String getOrgparname() {
		return orgparname;
	}

	/**
	 * *
	 * �ϼ����������趨
	 *
	 * @param orgparname �ϼ���������
	 */
	public void setOrgparname(String orgparname) {
		this.orgparname = orgparname;
	}
	
	/**
	 * ������Ϣʵ��ȡ��
	 * @return ������Ϣʵ��
	 */
	public OrganizationTB getOrganizationTB() {
		if(this.organizationTB == null){
			if(StringUtils.isNotEmpty(this.orgpar)){
				OrganizationBL bl = (OrganizationBL) WebApplicationSupport.getBean("organizationBL");
				OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
				cond.setOrgsyscoding(this.orgpar);
				List<Organization> list = bl.searchOrganization(cond);
				if(list.size() == 1){
					this.organizationTB = (OrganizationTB) list.get(0);
				}
			}
		}
		return organizationTB;
	}

	/**
	 * ������Ϣʵ���趨
	 *
	 * @param organizationTB ������Ϣʵ��
	 */
	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}
	
	/**
	 * �ϼ����������ȡ��
	 * @return �ϼ����������
	 */
	public String getOrgpar() {
		return orgpar;
	}

	/**
	 * �ϼ�����������趨
	 *
	 * @param orgpar �ϼ����������
	 */
	public void setOrgpar(String orgpar) {
		this.orgpar = orgpar;
	}

	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * ����������趨
	 *
	 * @param orgsyscoding ���������
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getOrgusercoding() {
		return orgusercoding;
	}

	/**
	 * ���������趨
	 *
	 * @param orgusercoding ��������
	 */
	public void setOrgusercoding(String orgusercoding) {
		this.orgusercoding = orgusercoding;
	}
	
	/**
	 * ��ȡ����
	 * @return ����
	 */
	public Serializable getPK() {
		return orgid;
	}

	/**
	 * �Ƚ����������Ƿ���ͬ
	 * @param obj
	 * @return �ȽϽ����true��ͬ��false��ͬ��
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof OrganizationTB))
			return false;
		OrganizationTB target = (OrganizationTB) obj;
		if (!(getOrgid()==target.getOrgid()))
			return false;

		return true;
	}
	
	/**
	 * �����µĻ���ʵ��
	 * @param org
	 * @return �µĻ���ʵ��
	 */
	public OrganizationTB clone(Organization org){
		
		this.orgid = org.getOrgid();
		
		this.orgname = org.getOrgname();
		
		this.orgdesc = org.getOrgdesc();

		this.orginfo = org.getOrginfo();

		this.orgtype = org.getOrgtype();
		
		this.orgpar = org.getOrgpar();
		
		this.orgparname = org.getOrgparname();
		
		this.orgaddr = org.getOrgaddr();
		
		this.orgphone = org.getOrgphone();
		
		this.orgfax = org.getOrgfax();
		
		this.orgcontact = org.getOrgcontact();
		
		this.orgstatus = org.getOrgstatus();
		
		this.orgsyscoding = org.getOrgsyscoding();
		
		this.orgusercoding = org.getOrgusercoding();
		return this;
	}

}
