/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.cic.model.CompareroleInfo;

/**
  * 概述: 对比规则实体
  * 功能描述: 对比规则实体
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="comparerole")
public class CompareroleTB extends BaseEntity implements Serializable,
		Cloneable, CompareroleInfo {

	/** crid */
	@Id
	@GeneratedValue(generator = "crid")
	@GenericGenerator(name = "crid", strategy = "sequence", 
			parameters = { @Parameter(name = "sequence", 
						value = "comparerole_seq") })
	protected Integer crid;

	/** 对比类型 */
	protected String crtype;

	/** 名称 */
	protected String crname;

	/** 对比域外键 */
	protected Integer fkCsid;
	
	@ManyToOne
	@JoinColumn(name="fkCsid", referencedColumnName="csid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected ComparescopeTB comparescopeTb;
	
	

	/** 业务系统id */
	protected Integer crsystemid;

	/** 业务系统名称 */
	protected String crsystemname;
	
	/** 对比规则版本 */
    protected Integer crversion;

	/**
	 * crid取得
	 *
	 * @return crid
	 */
	public Integer getCrid() {
		return crid;
	}

	/**
	 * crid设定
	 *
	 * @param crid crid
	 */
	public void setCrid(Integer crid) {
		this.crid = crid;
	}

	/**
	 * 对比类型取得
	 *
	 * @return 对比类型
	 */
	public String getCrtype() {
		return crtype;
	}

	/**
	 * 对比类型设定
	 *
	 * @param crtype 对比类型
	 */
	public void setCrtype(String crtype) {
		this.crtype = crtype;
	}

	/**
	 * 名称取得
	 *
	 * @return 名称
	 */
	public String getCrname() {
		return crname;
	}

	/**
	 * 名称设定
	 *
	 * @param crname 名称
	 */
	public void setCrname(String crname) {
		this.crname = crname;
	}

	/**
	 * 对比域外键取得
	 *
	 * @return 对比域外键
	 */
	public Integer getFkCsid() {
		return fkCsid;
	}

	/**
	 * 对比域外键设定
	 *
	 * @param fkCsid 对比域外键
	 */
	public void setFkCsid(Integer fkCsid) {
		this.fkCsid = fkCsid;
	}

	/**
	 * 业务系统id取得
	 *
	 * @return 业务系统id
	 */
	public Integer getCrsystemid() {
		return crsystemid;
	}

	/**
	 * 业务系统id设定
	 *
	 * @param crsystemid 业务系统id
	 */
	public void setCrsystemid(Integer crsystemid) {
		this.crsystemid = crsystemid;
	}

	/**
	 * 业务系统名称取得
	 *
	 * @return 业务系统名称
	 */
	public String getCrsystemname() {
		return crsystemname;
	}

	/**
	 * 业务系统名称设定
	 *
	 * @param crsystemname 业务系统名称
	 */
	public void setCrsystemname(String crsystemname) {
		this.crsystemname = crsystemname;
	}

	/** 
     * 对比规则版本 取得
     * @return crversion 对比规则版本 
     */
    public Integer getCrversion() {
        return crversion;
    }

    /** 
     * 对比规则版本 设定
     * @param crversion 对比规则版本 
     */
    public void setCrversion(Integer crversion) {
        this.crversion = crversion;
    }

    /**
	 * 主键取得
	 *
	 * @return 主键
	 */
	@Override
	public Serializable getPK() {
		return crid;
	}

}