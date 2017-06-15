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
 * 机构信息实体
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="ORGANIZATION")
public class OrganizationTB extends BaseEntity implements Serializable, Cloneable, Organization {
	
	/** 机构ID */
	@Id
	@TableGenerator(
		    name="ORGANIZATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="ORGANIZATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ORGANIZATION_TABLE_GENERATOR")
	protected Integer orgid;
	
	/** 机构名称 */
	protected String orgname;

	/** 机构说明 */
	protected String orgdesc;

	/** 机构信息 */
	protected String orginfo;

	/** 机构类型 */
	protected String orgtype;

	/** 上级机构层次码 */
	protected String orgpar;

	/** 上级机构名称 */
	protected String orgparname;

	/** 机构地址 */
	protected String orgaddr;

	/** 机构电话 */
	protected String orgphone;

	/** 机构传真 */
	protected String orgfax;

	/** 机构联系人 */
	protected String orgcontact;

	/** 机构状态 */
	protected String orgstatus;

	/** 机构层次码 */
	protected String orgsyscoding;
	
	/** 机构编码 */
	protected String orgusercoding;

	/** 机构信息实体 */
	@Transient
	protected OrganizationTB organizationTB;
	

	/**
	 * 机构ID取得
	 * @return 机构ID
	 */
	public Integer getOrgid() {
		return orgid;
	}

	/**
	 * 机构ID设定
	 *
	 * @param orgid 机构ID
	 */
	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}

	/**
	 * 机构名称取得
	 * @return 机构名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 机构名称设定
	 *
	 * @param orgname 机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 机构说明取得
	 * @return 机构说明
	 */
	public String getOrgdesc() {
		return orgdesc;
	}

	/**
	 * 机构说明设定
	 *
	 * @param orgdesc 机构说明
	 */
	public void setOrgdesc(String orgdesc) {
		this.orgdesc = orgdesc;
	}

	/**
	 * 机构信息取得
	 * @return 机构信息
	 */
	public String getOrginfo() {
		return orginfo;
	}

	/**
	 * 机构信息设定
	 *
	 * @param orginfo 机构信息
	 */
	public void setOrginfo(String orginfo) {
		this.orginfo = orginfo;
	}

	/**
	 * 机构类型取得
	 * @return 机构类型
	 */
	public String getOrgtype() {
		return orgtype;
	}

	/**
	 * 机构类型设定
	 *
	 * @param orgtype 机构类型
	 */
	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	/**
	 * 机构地址取得
	 * @return 机构地址
	 */
	public String getOrgaddr() {
		return orgaddr;
	}

	/**
	 * 机构地址设定
	 *
	 * @param orgaddr 机构地址
	 */
	public void setOrgaddr(String orgaddr) {
		this.orgaddr = orgaddr;
	}

	/**
	 * 机构电话取得
	 * @return 机构电话
	 */
	public String getOrgphone() {
		return orgphone;
	}

	/**
	 * 机构电话设定
	 *
	 * @param orgphone 机构电话
	 */
	public void setOrgphone(String orgphone) {
		this.orgphone = orgphone;
	}

	/**
	 * 机构传真取得
	 * @return 机构传真
	 */
	public String getOrgfax() {
		return orgfax;
	}

	/**
	 * 机构传真设定
	 *
	 * @param orgfax 机构传真
	 */
	public void setOrgfax(String orgfax) {
		this.orgfax = orgfax;
	}

	/**
	 * 机构联系人取得
	 * @return 机构联系人
	 */
	public String getOrgcontact() {
		return orgcontact;
	}

	/**
	 * 机构联系人设定
	 *
	 * @param orgcontact 机构联系人
	 */
	public void setOrgcontact(String orgcontact) {
		this.orgcontact = orgcontact;
	}

	/**
	 * 机构状态取得
	 * @return 机构状态
	 */
	public String getOrgstatus() {
		return orgstatus;
	}

	/**
	 * 机构状态设定
	 *
	 * @param orgstatus 机构状态
	 */
	public void setOrgstatus(String orgstatus) {
		this.orgstatus = orgstatus;
	}
	
	/**
	 * 上级机构名称取得
	 * @return 上级机构名称
	 */
	public String getOrgparname() {
		return orgparname;
	}

	/**
	 * *
	 * 上级机构名称设定
	 *
	 * @param orgparname 上级机构名称
	 */
	public void setOrgparname(String orgparname) {
		this.orgparname = orgparname;
	}
	
	/**
	 * 机构信息实体取得
	 * @return 机构信息实体
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
	 * 机构信息实体设定
	 *
	 * @param organizationTB 机构信息实体
	 */
	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}
	
	/**
	 * 上级机构层次码取得
	 * @return 上级机构层次码
	 */
	public String getOrgpar() {
		return orgpar;
	}

	/**
	 * 上级机构层次码设定
	 *
	 * @param orgpar 上级机构层次码
	 */
	public void setOrgpar(String orgpar) {
		this.orgpar = orgpar;
	}

	/**
	 * 机构层次码取得
	 * @return 机构层次码
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * 机构层次码设定
	 *
	 * @param orgsyscoding 机构层次码
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * 机构编码取得
	 * @return 机构编码
	 */
	public String getOrgusercoding() {
		return orgusercoding;
	}

	/**
	 * 机构编码设定
	 *
	 * @param orgusercoding 机构编码
	 */
	public void setOrgusercoding(String orgusercoding) {
		this.orgusercoding = orgusercoding;
	}
	
	/**
	 * 获取主键
	 * @return 主键
	 */
	public Serializable getPK() {
		return orgid;
	}

	/**
	 * 比较两个对象是否相同
	 * @param obj
	 * @return 比较结果（true相同，false不同）
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
	 * 复制新的机构实体
	 * @param org
	 * @return 新的机构实体
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
