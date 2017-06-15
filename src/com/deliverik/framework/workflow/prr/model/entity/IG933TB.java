/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.asset.model.entity.IG688VW;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.model.entity.CodeDetailTB;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prr.model.IG933Info;

/**
 * <p>概述:服务工单实体</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */

@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG933")
public class IG933TB extends BaseEntity implements Serializable, Cloneable, IG933Info {
	/** 服务工单ID */
	@Id
	@TableGenerator(
		    name="IG933_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG933_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG933_TABLE_GENERATOR")
	protected Integer sfid;
	
	/** 服务工单编码*/
	protected String sfcode;

	/** 服务工单报告人*/
	protected String sfreportname;

	/** 服务工单报告人电话*/
	protected String sfreportphone;

	/** 服务工单报告人部门*/
	protected String sfreportorgid;

	/** 服务工单题目*/
	protected String sftitle;

	/** 服务工单描述*/
	protected String sfdesc;
	
	/** 服务工单附件*/
	protected String sfattkey;

	/** 服务工单状态*/
	protected String sfstatus;

	/** 服务工单部门ID*/
	protected String sforgid;

	/** 服务工单记录人ID*/
	protected String sfregisterid;

	/** 服务工单记录时间*/
	protected String sfinstime;

	/** 服务工单记录分类*/
	protected String sftype;
	
	/** 服务工单相关资产*/
	protected Integer sfeiid;
	
	/** 服务工单来源*/
	protected String sfsource;
	
	/** 服务工单办公电话*/
	protected String sfworkphone;
	
	/** 服务工单邮箱*/
	protected String sfemail;
	
	/** 基础数据实体 */
	@OneToOne
	@JoinColumn(name="sftype", referencedColumnName="syscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected CodeDetailTB codeDetailTB;
	
	/** 资产实体 */
	@OneToOne
	@JoinColumn(name="sfeiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG688VW entityItemVW;
	
	/** 用户实体 */
	@OneToOne
	@JoinColumn(name="sfregisterid", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected UserTB userTB;
	
	/** 机构实体 */
	@OneToOne
	@JoinColumn(name="sforgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB organizationTB;
	
	/** 报告人机构实体 */
	@OneToOne
	@JoinColumn(name="sfreportorgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB reportorganizationTB;
	
	/**
	 * 功能：主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return sfid;
	}
	
	/**
	 * 功能：服务工单ID取得
	 * 
	 * @return 服务工单ID
	 */
	public Integer getSfid() {
		return sfid;
	}
	
	/**
	 * 功能：服务工单ID设置
	 * @param sfid
	 */
	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}
	
	/**
	 * 功能：服务工单编码取得
	 * 
	 * @return 服务工单编码
	 */
	public String getSfcode() {
		return sfcode;
	}
	
	/**
	 * 功能：服务工单编码设置
	 * @param sfcode
	 */
	public void setSfcode(String sfcode) {
		this.sfcode = sfcode;
	}
	
	/**
	 * 功能：服务工单报告人取得
	 * 
	 * @return 服务工单报告人
	 */
	public String getSfreportname() {
		return sfreportname;
	}
	/**
	 * 功能：服务工单报告人设置
	 * @param sfreportname
	 */
	public void setSfreportname(String sfreportname) {
		this.sfreportname = sfreportname;
	}
	
	/**
	 * 功能：服务工单报告人电话取得
	 * 
	 * @return 服务工单报告人电话
	 */
	public String getSfreportphone() {
		return sfreportphone;
	}
	
	/**
	 * 功能：服务工单报告人电话设置
	 * @param sfreportphone
	 */
	public void setSfreportphone(String sfreportphone) {
		this.sfreportphone = sfreportphone;
	}
	
	/**
	 * 功能：服务工单报告人部门取得
	 * 
	 * @return 服务工单报告人部门
	 */
	public String getSfreportorgid() {
		return sfreportorgid;
	}
	
	/**
	 * 功能：服务工单报告人部门设置
	 * @param sfreportorgid
	 */
	public void setSfreportorgid(String sfreportorgid) {
		this.sfreportorgid = sfreportorgid;
	}
	
	/**
	 * 功能：服务工单题目取得
	 * 
	 * @return 服务工单题目
	 */
	public String getSftitle() {
		return sftitle;
	}
	
	/**
	 * 功能：服务工单题目设置
	 * @param sftitle
	 */
	public void setSftitle(String sftitle) {
		this.sftitle = sftitle;
	}

	/**
	 * 功能：服务工单描述取得
	 * 
	 * @return 服务工单描述
	 */
	public String getSfdesc() {
		return sfdesc;
	}
	/**
	 * 功能：服务工单描述设置
	 * @param sfdesc
	 */
	public void setSfdesc(String sfdesc) {
		this.sfdesc = sfdesc;
	}


	/**
	 * 功能：服务工单附件取得
	 * 
	 * @return 服务工单附件
	 */
	public String getSfattkey() {
		return sfattkey;
	}
	
	/**
	 * 功能：服务工单附件设置
	 * @param sfattkey
	 */
	public void setSfattkey(String sfattkey) {
		this.sfattkey = sfattkey;
	}
	
	/**
	 * 功能：服务工单状态取得
	 * 
	 * @return 服务工单状态
	 */
	public String getSfstatus() {
		return sfstatus;
	}
	
	/**
	 * 功能：服务工单状态设置
	 * @param sfstatus
	 */
	public void setSfstatus(String sfstatus) {
		this.sfstatus = sfstatus;
	}

	/**
	 * 功能：服务工单部门ID取得
	 * 
	 * @return 服务工单部门ID
	 */
	public String getSforgid() {
		return sforgid;
	}
	
	/**
	 * 功能：服务工单部门ID设置
	 * @param sforgid
	 */
	public void setSforgid(String sforgid) {
		this.sforgid = sforgid;
	}

	/**
	 * 功能：服务工单记录人ID取得
	 * 
	 * @return 服务工单记录人ID
	 */
	public String getSfregisterid() {
		return sfregisterid;
	}
	
	/**
	 * 功能：服务工单记录人ID设置
	 * @param sfregisterid
	 */
	public void setSfregisterid(String sfregisterid) {
		this.sfregisterid = sfregisterid;
	}

	/**
	 * 功能：服务工单记录时间取得
	 * 
	 * @return 服务工单记录时间
	 */
	public String getSfinstime() {
		return sfinstime;
	}
	
	/**
	 * 功能：服务工单记录时间设置
	 * @param sfinstime
	 */
	public void setSfinstime(String sfinstime) {
		this.sfinstime = sfinstime;
	}
	
	
	/** 
	 * 功能：服务工单记录分类取得
	 * 
	 * @return 服务工单记录分类
	 */
	public String getSftype() {
		return sftype;
	}

	/**
	 * 功能：服务工单记录分类设置
	 * @param sftype
	 */
	public void setSftype(String sftype) {
		this.sftype = sftype;
	}

	/** 
	 * 功能：服务工单相关资产取得
	 * 
	 * @return 服务工单相关资产
	 */
	public Integer getSfeiid() {
		return sfeiid;
	}

	/**
	 * 功能：服务工单相关资产设置
	 * @param sfeiid
	 */
	public void setSfeiid(Integer sfeiid) {
		this.sfeiid = sfeiid;
	}
	
	/**
	 * 功能：基础数据类型对象取得
	 * 
	 * @return codeDetailTB 基础数据类型对象
	 */
	public CodeDetailTB getCodeDetailTB() {
		return codeDetailTB;
	}

	/**
	 * 功能：基础数据类型对象设置
	 * @param codeDetailTB
	 */
	public void setCodeDetailTB(CodeDetailTB codeDetailTB) {
		this.codeDetailTB = codeDetailTB;
	}
	
	/**
	 * 功能：资产实体对象取得
	 * 
	 * @return entityItemVW 资产实体对象
	 */
	public IG688VW getEntityItemVW() {
		return entityItemVW;
	}

	/**
	 * 功能：资产实体对象设置
	 * @param entityItemVW
	 */
	public void setEntityItemVW(IG688VW entityItemVW) {
		this.entityItemVW = entityItemVW;
	}

	/**
	 * 功能：用户实体对象取得
	 * 
	 * @return userTB 用户实体对象
	 */
	public UserTB getUserTB() {
		return userTB;
	}

	/**
	 * 功能：用户实体对象设置
	 * @param userTB
	 */
	public void setUserTB(UserTB userTB) {
		this.userTB = userTB;
	}
	
	/**
	 * 功能：机构实体对象取得
	 * 
	 * @return organizationTB 机构实体对象
	 */
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}

	/**
	 * 功能：机构实体对象设置
	 * @param organizationTB
	 */
	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}

	/**
	 * 功能：报告人机构实体对象取得
	 * 
	 * @return organizationTB 报告人机构实体对象
	 */
	public OrganizationTB getReportOrganizationTB() {
		return reportorganizationTB;
	}

	/**
	 * 功能：报告人机构实体对象设置
	 * @param reportorganizationTB
	 */
	public void setReportOrganizationTB(OrganizationTB reportorganizationTB) {
		this.reportorganizationTB = reportorganizationTB;
	}

	/**
	 * 功能：服务工单来源取得
	 * 
	 * @return 服务工单来源
	 */
	public String getSfsource() {
		return sfsource;
	}

	/**
	 * 功能：服务工单来源设置
	 * @param sfsource 服务工单来源
	 */
	public void setSfsource(String sfsource) {
		this.sfsource = sfsource;
	}

	/**
	 * 功能：服务工单办公电话取得
	 * 
	 * @return 服务工单办公电话
	 */
	public String getSfworkphone() {
		return sfworkphone;
	}

	/**
	 * 功能：服务工单办公电话设置
	 * @param sfworkphone 服务工单办公电话
	 */
	public void setSfworkphone(String sfworkphone) {
		this.sfworkphone = sfworkphone;
	}

	/**
	 * 功能：邮箱取得
	 * 
	 * @return 邮箱
	 */
	public String getSfemail() {
		return sfemail;
	}

	/**
	 * 功能：邮箱设置
	 * @param sfemail 邮箱
	 */
	public void setSfemail(String sfemail) {
		this.sfemail = sfemail;
	}



}
