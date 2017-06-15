/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset.model.entity;
import java.io.Serializable;

import com.deliverik.framework.base.BasePK;


/**
 * 资产属性历史版本更新时间主键实体
 *
 */
@SuppressWarnings("serial")
public class IG887PK extends BasePK implements Serializable {
	
	/** 资产属性大版本号 */
	protected Integer civersion;
	
    /** 资产属性小版本号 */
	protected Integer cismallversion;
    
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
	 * 构造函数
	 * 
	 */
	public IG887PK(){}
	
	/**
	 * 构造函数
	 * 
	 */
	public IG887PK(Integer civersion, Integer cismallversion) {
		super();
		this.civersion = civersion;
		this.cismallversion = cismallversion;
	}

}
