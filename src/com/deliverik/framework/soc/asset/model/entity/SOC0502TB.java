/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0502Info;

/**
  * 概述: 	密码关联分析表
  * 功能描述: 密码关联分析表
  * 创建记录: 
  * 修改记录: 
  */
@Entity
@Table(name="SOC0502")
public class SOC0502TB extends BaseEntity implements SOC0502Info, Serializable,Cloneable{
	@Id
	@SequenceGenerator(
			name="SOC0502_GENERATOR", sequenceName="SOC0502_SEQ", 
			initialValue=1, allocationSize=1
		)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SOC0502_GENERATOR")
	private Integer rid;
	private Integer pid ;
	private String rDescription;
	private String rName;
	private String serverIp;
	private String operationInfo;
	private String regDate ;
	
	
	
	public Integer getRid() {
		return rid;
	}



	public void setRid(Integer rid) {
		this.rid = rid;
	}



	public Integer getPid() {
		return pid;
	}



	public void setPid(Integer pid) {
		this.pid = pid;
	}



	public String getrDescription() {
		return rDescription;
	}



	public void setrDescription(String rDescription) {
		this.rDescription = rDescription;
	}



	public String getrName() {
		return rName;
	}



	public void setrName(String rName) {
		this.rName = rName;
	}



	public String getServerIp() {
		return serverIp;
	}



	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}



	public String getOperationInfo() {
		return operationInfo;
	}



	public void setOperationInfo(String operationInfo) {
		this.operationInfo = operationInfo;
	}



	public String getRegDate() {
		return regDate;
	}



	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}



	@Override
	public Serializable getPK() {
		return this.rid;
	}

	
}