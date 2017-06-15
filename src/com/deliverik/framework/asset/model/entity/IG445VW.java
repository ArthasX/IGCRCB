package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.deliverik.framework.asset.model.IG445Info;

/**
 * 设备分布式统计分析信息（平台保留）
 * 
 */
@SuppressWarnings("serial")
@Entity
public class IG445VW implements Serializable,
	Cloneable, IG445Info {
	
	/** 机构层次码*/
	@Id
	protected String orgsyscoding;
	
	/** 机构名称*/
	protected String orgname;
	
	/** 个数*/
	protected Integer count;
	
	/** 所占百分数*/
	@Transient
	protected String proportion;

	/**
	 * 取得机构层次码取得
	 * @return 取得机构层次码
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * 取得机构层次码设定
	 *
	 * @param orgsyscoding 取得机构层次码
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * 取得机构层次码取得
	 * @return 取得机构层次码
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 取得机构名称设定
	 *
	 * @param orgname 取得机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 取得个数取得
	 * @return 取得个数
	 */
	public Integer getCount() {
		if(count==null){
			return 0;
		}else{
			return count;
		}
	}

	/**
	 * 取得个数设定
	 *
	 * @param count 取得个数
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * 取得所占百分数取得
	 * @return 取得所占百分数
	 */
	public String getProportion() {
		return proportion;
	}

	/**
	 * 取得所占百分数设定
	 *
	 * @param proportion 取得所占百分数
	 */
	public void setProportion(String proportion) {
		this.proportion = proportion;
	}

}
