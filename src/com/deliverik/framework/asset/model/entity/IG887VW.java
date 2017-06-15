/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset.model.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;

import com.deliverik.framework.asset.model.IG887Info;


/**
 * 资产属性历史版本更新时间实体
 *
 */
@SuppressWarnings("serial")
@Entity
@IdClass(IG887PK.class)
public class IG887VW implements Serializable, Cloneable, IG887Info {
	
	/** 资产属性大版本号 */
	@Id
	protected Integer civersion;
	
	/** 资产属性更新时间 */
    protected String ciupdtime;
    
    /** 是否存在配置文件附件，不存在的在版本比较时不显示 */
    @Transient
    protected String isshow;
    
    /** 资产属性小版本号 */
    @Id
	protected Integer cismallversion;
    
    /**
	 * 是否存在配置文件附件，不存在的在版本比较时不显示 0不显示 1显示
	 * @return 显示标识
	 */
    public String getIsshow() {
		return isshow;
	}

    /**
	 * 是否存在配置文件附件，不存在的在版本比较时不显示 0不显示 1显示
	 *
	 * @param isshow 
	 */
	public void setIsshow(String isshow) {
		this.isshow = isshow;
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

}
