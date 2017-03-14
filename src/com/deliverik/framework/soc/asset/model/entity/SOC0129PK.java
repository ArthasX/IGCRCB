package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * </p>
 * 资产属性信息视图主键定义
 *</p>
 */
@SuppressWarnings("serial")
public class SOC0129PK extends BasePK implements Serializable{

	/** 资产ID */
	protected String eiid ;
	
	/** 资产模型属性ID */
	protected String cid;

	/**
	 * 构造函数
	 * 
	 */
	public SOC0129PK(){}
	
	/**
	 * 构造函数
	 * 
	 */
	public SOC0129PK(String eiid, String cid) {
		super();
		this.eiid = eiid;
		this.cid = cid;
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

}
