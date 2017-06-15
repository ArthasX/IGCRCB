package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.deliverik.framework.asset.model.IG011Info;

/**
 * 资产统计信息实现
 * 
 */
@SuppressWarnings("serial")
@Entity
public class IG011VW implements Serializable,
	Cloneable, IG011Info {
	
	/** 资产模型层次码*/
	@Id
	protected String cid;
	
	/** 资产模型名称*/
	protected String cvalue;
	
	/** 总数*/
	protected Integer total;
	
	/** 所占百分数*/
	@Transient
	protected String proportion;
	
	/**
	 * 资产模型层次码取得
	 * @return 资产模型层次码
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * 资产模型层次码设定
	 *
	 * @param cid 资产模型层次码
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * 资产模型名称取得
	 * @return 资产模型名称
	 */
	public String getCvalue() {
		return cvalue;
	}

	/**
	 * 资产模型名称设定
	 *
	 * @param cvalue 资产模型名称
	 */
	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}

	/**
	 * 总数取得
	 * @return 总数
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * 总数设定
	 *
	 * @param total 总数
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	/**
	 * 每种资产模型数量所占总数的百分数取得
	 * @return 每种资产模型数量所占总数的百分数
	 */
	public String getProportion() {
		return proportion;
	}

	/**
	 * 每种资产模型数量所占总数的百分数设定
	 *
	 * @param proportion 每种资产模型数量所占总数的百分数
	 */
	public void setProportion(String proportion) {
		this.proportion = proportion;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof IG011VW))
			return false;
		IG011Info target = (IG011Info) obj;
		if (!(getCid() == target.getCid()))
			return false;

		return true;
	}

}
