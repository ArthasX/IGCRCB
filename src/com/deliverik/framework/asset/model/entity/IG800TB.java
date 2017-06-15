package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.base.BaseEntity;


/**
 * </p>
 * 资产属性信息实体
 *</p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG800")
public class IG800TB extends BaseEntity implements Serializable, Cloneable, IG800Info {

	/** 资产属性ID */
	@Id
	@TableGenerator(
		    name="IG800_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG800_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG800_TABLE_GENERATOR")
	protected Integer ciid;
	
	/** 资产ID（外键）*/
	protected Integer eiid;
	
	/** 资产模型属性ID（外键）*/
	protected Integer cid;
	
	/** 资产模型ID*/
	protected Integer eid;
	
	/** 资产属性值 */
	protected String civalue;
	
	/** 资产属性更新时间 */
	protected String ciupdtime;
	
	/** 资产属性失效时间 */
	protected String ciexpire;
	
	/** 资产属性状态 */
	protected String cistatus;
	
	/** 资产属性当前版本号 */
	protected String cicurver;
	
	/** 资产属性版本号 */
	protected Integer civersion;
	
	/** 资产属性版本信息 */
	protected String civerinfo;
	
	/** 资产模型层次码 */
	protected String esyscoding;
	
	/** 资产属性小版本 */
	protected Integer cismallversion;

	/** 资产模型属性信息 */
	@ManyToOne
	@JoinColumn(name="cid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG225TB configuration;


	/**
	 * 资产模型层次码取得
	 * @return 资产模型层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产模型层次码设定
	 *
	 * @param esyscoding 资产模型层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return ciid;
	}

	/**
	 * 资产属性ID取得
	 * @return 资产项属性ID
	 */
	public Integer getCiid() {
		return ciid;
	}

	/**
	 * 资产属性ID设定
	 *
	 * @param ciid 资产项属性ID
	 */
	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}

	/**
	 * 资产ID取得
	 * @return 资产项ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 *
	 * @param eiid 资产项ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}


	/**
	 * 资产模型属性ID取得
	 * @return 资产模型属性ID
	 */
	public Integer getCid() {
		return cid;
	}

	/**
	 * 资产模型属性ID设定
	 *
	 * @param cid 资产模型属性ID
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}


	/**
	 * 资产属性值取得
	 * @return 资产属性值
	 */
	public String getCivalue() {
		return civalue;
	}

	/**
	 * 资产属性值设定
	 *
	 * @param civalue 资产属性值
	 */
	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	/**
	 * 资产属性更新时间取得
	 * @return 资产属性更新时间
	 */
	public String getCiupdtime() {
		return ciupdtime;
	}

	/**
	 * 资产属性更新时间设定
	 *
	 * @param ciupdtime 资产属性更新时间
	 */
	public void setCiupdtime(String ciupdtime) {
		this.ciupdtime = ciupdtime;
	}

	/**
	 * 资产属性失效时间取得
	 * @return 资产属性失效时间
	 */
	public String getCiexpire() {
		return ciexpire;
	}

	/**
	 * 资产属性失效时间设定
	 *
	 * @param ciexpire 资产属性失效时间
	 */
	public void setCiexpire(String ciexpire) {
		this.ciexpire = ciexpire;
	}

	/**
	 * 资产属性状态取得
	 * @return 资产属性状态
	 */
	public String getCistatus() {
		return cistatus;
	}

	/**
	 * 资产属性状态设定
	 *
	 * @param eistatus 资产属性状态
	 */
	public void setCistatus(String cistatus) {
		this.cistatus = cistatus;
	}

	/**
	 * 资产属性当前版本号取得
	 * @return 资产属性当前版本号
	 */
	public String getCicurver() {
		return cicurver;
	}

	/**
	 * 资产属性当前版本号设定
	 *
	 * @param cicurver 资产属性当前版本号
	 */
	public void setCicurver(String cicurver) {
		this.cicurver = cicurver;
	}

	/**
	 * 资产属性版本号取得
	 * @return 资产属性版本号
	 */
	public Integer getCiversion() {
		return civersion;
	}

	/**
	 * 资产属性版本号设定
	 *
	 * @param civersion 资产属性版本号
	 */
	public void setCiversion(Integer civersion) {
		this.civersion = civersion;
	}

	/**
	 * 资产属性版本信息取得
	 * @return 资产属性版本信息
	 */
	public String getCiverinfo() {
		return civerinfo;
	}

	/**
	 * 资产属性版本信息设定
	 *
	 * @param civerinfo 资产属性版本信息
	 */
	public void setCiverinfo(String civerinfo) {
		this.civerinfo = civerinfo;
	}


	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public Integer getEid() {
		return eid;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(Integer eid) {
		this.eid = eid;
	}

	/**
	 * 资产模型属性信息取得
	 * @return 资产模型属性信息
	 */
	public IG225Info getConfiguration() {
	    return configuration;
	}
	
	/**
	 * 资产属性小版本取得
	 * @return 资产属性小版本
	 */
	public Integer getCismallversion() {
		return cismallversion;
	}

	/**
	 * 资产属性小版本设定
	 *
	 * @param cismallversion 资产属性小版本
	 */
	public void setCismallversion(Integer cismallversion) {
		this.cismallversion = cismallversion;
	}
	
}
