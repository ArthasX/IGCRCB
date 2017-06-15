/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dut.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dut.model.DutyPerson;

/**
 * 值班检查管理实体
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="DutyPerson")
public class DutyPersonTB extends BaseEntity implements Serializable, Cloneable, DutyPerson {
	
	@Id
	@TableGenerator(
		    name="DUTYPERSON_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="DUTYPERSON_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="DUTYPERSON_TABLE_GENERATOR")
	private Integer dperid;
	private Integer dpid;
	private String dpertime;
	private String dptype;
	private String dperuserid;
	private String dperusername;
	public Integer getDperid() {
		return dperid;
	}
	public void setDperid(Integer dperid) {
		this.dperid = dperid;
	}
	public Integer getDpid() {
		return dpid;
	}
	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}
	public String getDpertime() {
		return dpertime;
	}
	public void setDpertime(String dpertime) {
		this.dpertime = dpertime;
	}
	public String getDptype() {
		return dptype;
	}
	public void setDptype(String dptype) {
		this.dptype = dptype;
	}
	public String getDperuserid() {
		return dperuserid;
	}
	public void setDperuserid(String dperuserid) {
		this.dperuserid = dperuserid;
	}
	public String getDperusername() {
		return dperusername;
	}
	public void setDperusername(String dperusername) {
		this.dperusername = dperusername;
	}
	@Override
	public Serializable getPK() {
		return dperid;
	}
	
}
