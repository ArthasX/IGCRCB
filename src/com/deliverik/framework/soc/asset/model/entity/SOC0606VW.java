package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.framework.soc.asset.model.SOC0606Info;



/**
 * </p>
 * 资产属性信息视图实体
 *</p>
 */
@SuppressWarnings("serial")
@org.hibernate.annotations.Entity(mutable=false)
@IdClass(SOC0606PK.class)
@Entity
//public class ConfigItemVW extends BaseEntity implements Serializable, Cloneable, ConfigItemVWInfo {
public class SOC0606VW implements Serializable, Cloneable, SOC0606Info {

	/** 资产属性ID */
	protected String ciid;
	
	/** 资产ID */
	@Id
	protected String eiid;
	
	/** 资产模型属性ID */
	@Id
	protected String cid;
	
	/** 资产模型ID */
	protected String eid;
	
	/** 资产模型属性名称 */
	protected String cname;
	
	/** 资产模型属性说明 */
	protected String cdesc;
	
	/** 资产模型属性单位 */
	protected String cunit;
	
	/** 资产模型属性状态（1启用，2停用） */
	protected String cstatus;
	
	/** 资产模型属性类型 */
	protected String ccategory;
	
	/** 资产模型属性是否显示标识（1显示，0不显示） */
	protected String cseq;
	
	/** 资产模型属性编号 */
	protected String clabel;
	
	/** 资产模型属性取值范围 */
	protected String coption;

	/** 资产模型属性附件标识 */
	protected String cattach;
	
	/** 资产模型层次码*/
	public String esyscoding;
	
	/** 资产模型属性必填项 */
	protected String crequired;
	
	/** 资产属性值 */
	protected String civalue;
	
	/** 资产属性更新时间 */
	protected String ciupdtime;
	
	/** 资产属性过期时间 */
	protected String ciexpire;
	
	/** 资产属性状态（平台保留，未使用） */
	protected String cistatus;
	
	/** 资产属性更新标识 */
	protected String cicurver;
	
	/** 资产属性大版本号 */
	protected Integer civersion;
	
    /** 资产属性小版本号 */
	protected Integer cismallversion;
	
	/** 资产属性版本信息 */
	protected String civerinfo;
	
	protected String eilabel;
	
	protected String einame;
	
	protected String srename;

	/**排序标识*/
    private Integer corder;
	
	public String getCicurver() {
		return cicurver;
	}

	public void setCicurver(String cicurver) {
		this.cicurver = cicurver;
	}

	public String getSrename() {
		return srename;
	}

	public void setSrename(String srename) {
		this.srename = srename;
	}

	public String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}

	public String getEilabel() {
		return eilabel;
	}

	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

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
	 * 
	 * @return 
	 */
	public Serializable getPK() {
		return new SOC0606PK(eiid, cid);
	}

	/**
	 * 资产属性ID取得
	 * @return 资产属性ID
	 */
	public String getCiid() {
		return ciid;
	}

	/**
	 * 资产属性ID设定
	 *
	 * @param ciid 资产属性ID
	 */
	public void setCiid(String ciid) {
		this.ciid = ciid;
	}

	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 *
	 * @param eiid 资产ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产模型属性ID取得
	 * @return 资产模型属性ID
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * 资产模型属性ID设定
	 *
	 * @param cid 资产模型属性ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * 资产模型ID取得
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
	 * @return 资产项置更新时间
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
	 * 资产属性过期时间取得
	 * @return 资产属性过期时间
	 */
	public String getCiexpire() {
		return ciexpire;
	}

	/**
	 * 资产属性过期时间设定
	 *
	 * @param ciexpire 资产属性过期时间
	 */
	public void setCiexpire(String ciexpire) {
		this.ciexpire = ciexpire;
	}

	/**
	 * 资产模型属性名称取得
	 * @return 资产模型属性名称
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * 资产模型属性名称设定
	 *
	 * @param cname 资产模型属性名称
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * 资产模型属性说明取得
	 * @return 资产模型属性说明
	 */
	public String getCdesc() {
		return cdesc;
	}

	/**
	 * 资产模型属性说明设定
	 *
	 * @param cdesc 资产模型属性说明
	 */
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	/**
	 * 资产模型属性单位取得
	 * @return 资产模型属性单位
	 */
	public String getCunit() {
		return cunit;
	}

	/**
	 * 资产模型属性单位设定
	 *
	 * @param cunit 资产模型属性单位
	 */
	public void setCunit(String cunit) {
		this.cunit = cunit;
	}

	/**
	 * 资产模型属性状态取得
	 * @return 资产模型属性状态
	 */
	public String getCstatus() {
		return cstatus;
	}

	/**
	 * 资产模型属性状态设定
	 *
	 * @param cstatus 资产模型属性状态
	 */
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	/**
	 * 资产模型属性是否显示标识取得
	 * @return 资产模型属性是否显示标识
	 */
	public String getCseq() {
		return cseq;
	}

	/**
	 * 资产模型属性是否显示标识设定
	 *
	 * @param cseq 资产模型属性是否显示标识
	 */
	public void setCseq(String cseq) {
		this.cseq = cseq;
	}

	/**
	 * 资产模型属性类型取得
	 * @return 资产模型属性类型 
	 */
	public String getCcategory() {
		return ccategory;
	}

	/**
	 * 资产模型属性类型设定
	 *
	 * @param ccategory 资产模型属性类型
	 */
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
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
	 * @param cistatus 资产属性状态
	 */
	public void setCistatus(String cistatus) {
		this.cistatus = cistatus;
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
	 * 资产模型属性编号取得
	 * @return 资产模型属性编号
	 */
	public String getClabel() {
		return clabel;
	}

	/**
	 * 资产模型属性编号设定
	 *
	 * @param clabel 资产模型属性编号
	 */
	public void setClabel(String clabel) {
		this.clabel = clabel;
	}

	/**
	 * 资产模型属性取值范围取得
	 * @return 资产模型属性取值范围
	 */
	public String getCoption() {
		return coption;
	}

	/**
	 * 资产模型属性取值范围设定
	 *
	 * @param coption 资产模型属性取值范围
	 */
	public void setCoption(String coption) {
		this.coption = coption;
	}

	/**
	 * 资产模型属性附件标识取得
	 * @return 资产模型属性附件标识
	 */
	public String getCattach() {
		return cattach;
	}

	/**
	 * 资产模型属性附件标识设定
	 *
	 * @param cattach 资产模型属性附件标识
	 */
	public void setCattach(String cattach) {
		this.cattach = cattach;
	}
	
	/**
	 * 资产模型属性必填项取得
	 * @return 资产模型属性必填项
	 */
	public String getCrequired() {
		return crequired;
	}
	/**
	 * 资产模型属性必填项设定
	 *
	 * @param crequired 资产模型属性必填项
	 */
	public void setCrequired(String crequired) {
		this.crequired = crequired;
	}
	
	/**
	 * 资产属性大版本号取得
	 * @return 资产属性大版本号
	 */
	public Integer getCiversion() {
		return civersion;
	}

	/**
	 * 资产属性大版本号设定
	 *
	 * @param civersion 资产属性大版本号
	 */
	public void setCiversion(Integer civersion) {
		this.civersion = civersion;
	}

	/**
	 * 资产属性小版本号取得
	 * @return 资产属性小版本号
	 */
	public Integer getCismallversion() {
		return cismallversion;
	}

	/**
	 * 资产属性小版本号设定
	 *
	 * @param cismallversion 资产属性小版本号
	 */
	public void setCismallversion(Integer cismallversion) {
		this.cismallversion = cismallversion;
	}

    /**
     * 排序标识 is returned.
     * @return corder
     */
    public Integer getCorder() {
        return corder;
    }

    /**
     * 排序标识 is set.
     * @param corder 排序标识
     */
    public void setCorder(Integer corder) {
        this.corder = corder;
    }


}
