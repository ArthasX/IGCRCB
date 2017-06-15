/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.vir.model.VIM06Info;

/**
  * 概述: vim06实体
  * 功能描述: vim06实体
  * 创建记录: 2014/02/21
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="vim06")
public class VIM06TB extends BaseEntity implements Serializable,
		Cloneable, VIM06Info {
	
	@Id
	@TableGenerator(
		name="VIM06_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VIM06_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VIM06_TABLE_GENERATOR")
	protected Integer id;
	
	protected String resourceitem;
	
	protected Integer price;
	
	protected String version;
	
	protected Integer strategyid;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return id;
	}

	public Integer getId() {
		return id;
	}

	public String getResourceitem() {
		return resourceitem;
	}

	public Integer getPrice() {
		return price;
	}

	public String getVersion() {
		return version;
	}

	public Integer getStrategyid() {
		return strategyid;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setResourceitem(String resourceitem) {
		this.resourceitem = resourceitem;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setStrategyid(Integer strategyid) {
		this.strategyid = strategyid;
	}

}