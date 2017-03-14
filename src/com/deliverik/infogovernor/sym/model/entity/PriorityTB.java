/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sym.model.Priority;

/**
 * 概述:实体表类
 * 功能描述：优先级priorityTB类
 * 创建记录：fangyunlong@deliverik.com    2010/12/14
 */
@SuppressWarnings("serial")
@Entity
@IdClass(PriorityTBPK.class)
@Table(name = "PRIORITY")
public class PriorityTB extends BaseEntity implements Serializable,
		Cloneable, Priority {
	
	@TableGenerator(name = "PRIORITY_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", 
					pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", 
					pkColumnValue = "PRIORITY_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PRIORITY_TABLE_GENERATOR")
	
	/***
	 * 优先级KEY
	 */
	protected String pvalue;
	/***
	 * 紧急程度KEY
	 */
	@Id
	protected String uvalue;
	/***
	 * 影响度KEY	
	 */
	@Id
	protected String ivalue;
	/***
	 * 对应流程类型
	 */
	@Id
	protected String pprtype;
	
	public String getPvalue() {
		return pvalue;
	}


	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}


	public String getUvalue() {
		return uvalue;
	}


	public void setUvalue(String uvalue) {
		this.uvalue = uvalue;
	}


	public String getIvalue() {
		return ivalue;
	}


	public void setIvalue(String ivalue) {
		this.ivalue = ivalue;
	}


	public String getPprtype() {
		return pprtype;
	}


	public void setPprtype(String pprtype) {
		this.pprtype = pprtype;
	}


	@Override
	public Serializable getPK() {
		// TODO Auto-generated method stub
		return null;
	}
}
