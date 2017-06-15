package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.base.BasePK;

/**
 * </p>
 * 资产属性信息视图主键定义
 *</p>
 */
@SuppressWarnings("serial")
public class SOC0152PK extends BasePK implements Serializable{

	/** 开始模型ID */
	@Id
	protected String fromModelEid;


	/** 到模型ID */
	@Id
	protected String toModelEid;

	/**
	 * 构造函数
	 * 
	 */
	public SOC0152PK(){}
	
	/**
	 * 构造函数
	 * 
	 */
	public SOC0152PK(String fromModelEid, String toModelEid) {
		super();
		this.fromModelEid = fromModelEid;
		this.toModelEid = toModelEid;
	}

	public String getFromModelEid() {
		return fromModelEid;
	}

	public void setFromModelEid(String fromModelEid) {
		this.fromModelEid = fromModelEid;
	}

	public String getToModelEid() {
		return toModelEid;
	}

	public void setToModelEid(String toModelEid) {
		this.toModelEid = toModelEid;
	}


}
