/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0107VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0109VWInfo;

/**
  * 概述: SOC0107VW实体
  * 功能描述: SOC0107VW实体
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0107VWPK.class)
@Table(name="SOC0107VW")
public class SOC0107VW extends BaseEntity implements Serializable,
		Cloneable, SOC0107VWInfo {

	/** 主键 */
	@Id
	protected Integer id;

	/** 无意义主键 */
	@Id
	protected Integer ciid;

	/** 资产模型属性ID（外键） */
	protected String cid;

	/** 资产ID（外键） */
	protected Integer eiid;

	/** 资产模型ID */
	protected String eid;

	/** 资产属性值 */
	protected String civalue;

	/** 资产属性更新时间 */
	protected String ciupdtime;

	/** 资产模型层次码 */
	protected String esyscoding;

	/** 资产属性失效时间 */
	protected String ciexpire;

	/** 资产属性状态 */
	protected String cistatus;

	/** 资产属性当前版本号 */
	protected String cicurver;

	/** 资产属性版本号 */
	protected String civersion;

	/** 资产属性版本信息 */
	protected String civerinfo;
	
	/** 资产属性小版本 */
	protected Integer cismallversion;
	
	
	/**
	 * @return the cismallversion
	 */
	public Integer getCismallversion() {
		return cismallversion;
	}

	/**
	 * @param cismallversion the cismallversion to set
	 */
	public void setCismallversion(Integer cismallversion) {
		this.cismallversion = cismallversion;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 *
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 无意义主键取得
	 *
	 * @return 无意义主键
	 */
	public Integer getCiid() {
		return ciid;
	}

	/**
	 * 无意义主键设定
	 *
	 * @param ciid 无意义主键
	 */
	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}

	/**
	 * 资产模型属性ID（外键）取得
	 *
	 * @return 资产模型属性ID（外键）
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * 资产模型属性ID（外键）设定
	 *
	 * @param cid 资产模型属性ID（外键）
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * 资产ID（外键）取得
	 *
	 * @return 资产ID（外键）
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产ID（外键）设定
	 *
	 * @param eiid 资产ID（外键）
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产模型ID取得
	 *
	 * @return 资产模型ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 资产属性值取得
	 *
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
	 *
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
	 * 资产模型层次码取得
	 *
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
	 * 资产属性失效时间取得
	 *
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
	 *
	 * @return 资产属性状态
	 */
	public String getCistatus() {
		return cistatus;
	}

	/**
	 * 资产属性状态设定
	 *
	 * @param cistatus 资产属性状态
	 */
	public void setCistatus(String cistatus) {
		this.cistatus = cistatus;
	}

	/**
	 * 资产属性当前版本号取得
	 *
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
	 *
	 * @return 资产属性版本号
	 */
	public String getCiversion() {
		return civersion;
	}

	/**
	 * 资产属性版本号设定
	 *
	 * @param civersion 资产属性版本号
	 */
	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}

	/**
	 * 资产属性版本信息取得
	 *
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
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new SOC0107VWPK(id, ciid);
	}

	/** 资产模型属性信息 */
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id",referencedColumnName = "id",insertable = false, updatable = false),
		@JoinColumn(name="cid",referencedColumnName = "cid",insertable = false, updatable = false)
	})
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0109VW configuration;
	/**
	 * 资产模型属性信息取得
	 * @return 资产模型属性信息
	 */
	public SOC0109VWInfo getConfiguration() {
	    return configuration;
	}
}