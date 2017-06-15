package com.deliverik.framework.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.model.CodeDetail;

/**
 * 数据详细信息实体
 *
 */
@SuppressWarnings("serial")
@Entity
@IdClass(CodeDetailTBPK.class)
@Table(name="CODEDETAIL")
public class CodeDetailTB extends BaseEntity implements Serializable, Cloneable, CodeDetail {

	/** 数据分类CD */
	@Id
	protected String ccid ;
	
	/** 数据CD */
	@Id
	protected String cid;
	
	/** 数据内容 */
	protected String cvalue;

	/** 数据分类编号(父) */
	protected String pccid;

	/** 数据编号(父) */
	protected String pcid;

	/** 更新时间 */
	protected String updtime;
	
	/** 层次码 */
	public String syscoding;
	
	/** 上级层次码 */
	public String psyscoding;
	
	/** 状态 0-停用，1-启用 */
	public String cdstatus;
	
	/** 数据业务码 */
	public String businesscode;
	
	/** 数据说明 */
	public String cdinfo;
	
	/** 排列标识 */
	public Integer cdorder;
	
	/** 数据分类信息 */
	@ManyToOne
	@JoinColumn(name="ccid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected CodeCategoryTB codeCategory;

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return new CodeDetailTBPK(ccid,cid);
	}

	/**
	 * 数据分类CD取得
	 * @return 数据分类CD
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * 数据分类CD设定
	 *
	 * @param ccid 数据分类CD
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * 数据CD取得
	 * @return 数据CD
	 */
	public String getCid() {
		return cid;
	}


	/**
	 * 数据CD设定
	 *
	 * @param cid 数据CD
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}


	/**
	 * 数据内容取得
	 * @return 数据内容
	 */
	public String getCvalue() {
		return cvalue;
	}


	/**
	 * 数据内容设定
	 *
	 * @param cvalue 数据内容
	 */
	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}


	/**
	 * 数据分类编号(父)取得
	 * @return 数据分类编号(父)
	 */
	public String getPccid() {
		return pccid;
	}


	/**
	 * 数据分类编号(父)设定
	 *
	 * @param pccid 数据分类编号(父)
	 */
	public void setPccid(String pccid) {
		this.pccid = pccid;
	}


	/**
	 * 数据编号(父)取得
	 * @return 数据编号(父)
	 */
	public String getPcid() {
		return pcid;
	}


	/**
	 * 数据编号(父)设定
	 *
	 * @param pcid 数据编号(父)
	 */
	public void setPcid(String pcid) {
		this.pcid = pcid;
	}


	/**
	 * 更新时间取得
	 * @return 更新时间
	 */
	public String getUpdtime() {
		return updtime;
	}


	/**
	 * 更新时间设定
	 *
	 * @param updtime 更新时间
	 */
	public void setUpdtime(String updtime) {
		this.updtime = updtime;
	}

	/**
	 * 数据分类信息取得
	 * @return 数据分类信息
	 */
	public CodeCategoryTB getCodeCategory() {
		return codeCategory;
	}

	/**
	 * 层次码
	 * @return 层次码
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * 层次码
	 *
	 * @param syscoding 层次码
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**
	 * 上级层次码
	 * @return 上级层次码
	 */
	public String getPsyscoding() {
		return psyscoding;
	}

	/**
	 * 层次码
	 *
	 * @param syscoding 层次码
	 */
	public void setPsyscoding(String psyscoding) {
		this.psyscoding = psyscoding;
	}

	/**
	 * 状态 0-停用，1-启用
	 * @return 状态
	 */
	public String getCdstatus() {
		return cdstatus;
	}

	/**
	 * 状态 0-停用，1-启用
	 *
	 * @param cdstatus 状态
	 */
	public void setCdstatus(String cdstatus) {
		this.cdstatus = cdstatus;
	}

	/**
	 * 数据业务码
	 * @return 数据业务码
	 */
	public String getBusinesscode() {
		return businesscode;
	}

	/**
	 * 数据业务码
	 *
	 * @param businesscode 数据业务码
	 */
	public void setBusinesscode(String businesscode) {
		this.businesscode = businesscode;
	}

	/**
	 * 数据说明
	 * @return 数据说明
	 */
	public String getCdinfo() {
		return cdinfo;
	}

	/**
	 * 数据说明
	 *
	 * @param cdinfo 数据说明
	 */
	public void setCdinfo(String cdinfo) {
		this.cdinfo = cdinfo;
	}

	/**
	 * 排列标识
	 * @return 排列标识
	 */
	public Integer getCdorder() {
		return cdorder;
	}

	/**
	 * 排列标识
	 * @param cdorder 排列标识
	 */
	public void setCdorder(Integer cdorder) {
		this.cdorder = cdorder;
	}
	
}
