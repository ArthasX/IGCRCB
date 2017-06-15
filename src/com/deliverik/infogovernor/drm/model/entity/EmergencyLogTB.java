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
import com.deliverik.infogovernor.drm.model.EmergencyLogInfo;

/**
 * 概述：应急日志信息表实体
 * 功能描述：应急日志信息表实体
 * 创建记录：2014/05/19
 * 修改记录：
 */
@SuppressWarnings("serial")
@Entity
@Table(name="emergencylog")
public class EmergencyLogTB extends BaseEntity implements Serializable, Cloneable, EmergencyLogInfo {
	/**主键ID*/
    @Id
    @TableGenerator(
        name="EMERGENCYLOG_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
        pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
        pkColumnValue="EMERGENCYLOG_SEQUENCE", initialValue=1, allocationSize=1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator="EMERGENCYLOG_TABLE_GENERATOR")
	protected Integer elid;
	/**应急启动流程ID*/
	protected Integer elprid;
	/**日志信息类型*/
	protected String ellitype;
	/**日志信息发布时间*/
	protected String ellidtime;
	/**日志信息发布人用户ID*/
	protected String eluserid;
	/**日志信息发布人用户名称*/
	protected String elusername;
	/**日志信息内容*/
	protected String elliinfo;
	/**日志状态ID*/
	protected String elpsdid;

	/**日志状态名称*/
	protected String elpsdname;
	
	/**操作信息*/
	protected String operate;
	/**
	 * Getter and Setter
	 */
	@Override
	/**
	 * 主键取得
	 * @return elid
	 */
	public Serializable getPK() {
		return elid;
	}
	/**
	 * 主键ID取得
	 * @return elid
	 */
	public Integer getElid() {
		return elid;
	}
	/**
	 * 主键ID设定
	 * @param ecid
	 */
	public void setElid(Integer elid) {
		this.elid = elid;
	}
	
	/**
	 * 应急启动流程ID取得
	 * @return elprid
	 */
	public Integer getElprid() {
		return elprid;
	}
	/**
	 * 应急启动流程ID设定
	 * @param elprid
	 */
	public void setElprid(Integer elprid) {
		this.elprid = elprid;
	}
	
	/**
	 * 日志信息类型取得
	 * @return ellitype
	 */
	public String getEllitype() {
		return ellitype;
	}
	/**
	 * 日志信息类型设定
	 * @param ellitype
	 */
	public void setEllitype(String ellitype) {
		this.ellitype = ellitype;
	}
	
	/**
	 * 日志信息发布时间取得
	 * @return ellidtime
	 */
	public String getEllidtime() {
		return ellidtime;
	}
	/**
	 * 日志信息发布时间设定
	 * @param ellidtime
	 */
	public void setEllidtime(String ellidtime) {
		this.ellidtime = ellidtime;
	}
	
	/**
	 * 日志信息发布人用户ID取得
	 * @return eluserid
	 */
	public String getEluserid() {
		return eluserid;
	}
	/**
	 * 日志信息发布人用户ID设定
	 * @param eluserid
	 */
	public void setEluserid(String eluserid) {
		this.eluserid = eluserid;
	}
	
	/**
	 * 日志信息发布人用户名称取得
	 * @return elusername
	 */
	public String getElusername() {
		return elusername;
	}
	/**
	 * 日志信息发布人用户名称设定
	 * @param elusername
	 */
	public void setElusername(String elusername) {
		this.elusername = elusername;
	}
	
	/**
	 * 日志信息内容取得
	 * @return elliinfo
	 */
	public String getElliinfo() {
		return elliinfo;
	}
	/**
	 * 日志信息内容设定
	 * @param elliinfo
	 */
	public void setElliinfo(String elliinfo) {
		this.elliinfo = elliinfo;
	}
	public String getElpsdid() {
		return elpsdid;
	}
	public void setElpsdid(String elpsdid) {
		this.elpsdid = elpsdid;
	}
	public String getElpsdname() {
		return elpsdname;
	}
	public void setElpsdname(String elpsdname) {
		this.elpsdname = elpsdname;
	}
	/**  
	 * 获取operate  
	 * @return operate 
	 */
	public String getOperate() {
		return operate;
	}
	/**  
	 * 设置operate  
	 * @param operate
	 */
	
	public void setOperate(String operate) {
		this.operate = operate;
	}
	
}