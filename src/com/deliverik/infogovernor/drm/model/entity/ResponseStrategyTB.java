/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.ResponseStrategyInfo;

/**
  * 概述: 场景响应策略实体
  * 功能描述: 场景响应策略实体
  * 创建记录: 2016/09/20
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="ResponseStrategy")
public class ResponseStrategyTB extends BaseEntity implements Serializable,
		Cloneable, ResponseStrategyInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="RESPONSESTRATEGY_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="RESPONSESTRATEGY_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RESPONSESTRATEGY_TABLE_GENERATOR")
	protected Integer rsid;

	/** 场景id */
	protected Integer senceid;

	/** 策略描述 */
	protected String strategyDesc;

	/** 关键字 */
	protected String keyword;

	/** 特殊处理类 */
	protected String handleBL;

	/**特殊处理参数一下划线分割*/
	protected String rsargs;
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getRsid() {
		return rsid;
	}

	public String getRsargs() {
		return rsargs;
	}

	public void setRsargs(String rsargs) {
		this.rsargs = rsargs;
	}

	/**
	 * 主键设定
	 *
	 * @param rsid 主键
	 */
	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}

	/**
	 * 场景id取得
	 *
	 * @return 场景id
	 */
	public Integer getSenceid() {
		return senceid;
	}

	/**
	 * 场景id设定
	 *
	 * @param senceid 场景id
	 */
	public void setSenceid(Integer senceid) {
		this.senceid = senceid;
	}

	/**
	 * 策略描述取得
	 *
	 * @return 策略描述
	 */
	public String getStrategyDesc() {
		return strategyDesc;
	}

	/**
	 * 策略描述设定
	 *
	 * @param strategyDesc 策略描述
	 */
	public void setStrategyDesc(String strategyDesc) {
		this.strategyDesc = strategyDesc;
	}

	/**
	 * 关键字取得
	 *
	 * @return 关键字
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * 关键字设定
	 *
	 * @param keyword 关键字
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * 特殊处理类取得
	 *
	 * @return 特殊处理类
	 */
	public String getHandleBL() {
		return handleBL;
	}

	/**
	 * 特殊处理类设定
	 *
	 * @param handleBL 特殊处理类
	 */
	public void setHandleBL(String handleBL) {
		this.handleBL = handleBL;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return rsid;
	}

}