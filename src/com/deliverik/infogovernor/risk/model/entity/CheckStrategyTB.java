/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.risk.model.CheckStrategyInfo;

/**
  * 概述: 检查策略实体
  * 功能描述: 检查策略实体
  * 创建记录: 2014/09/02
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CheckStrategy")
public class CheckStrategyTB extends BaseEntity implements Serializable,
		Cloneable, CheckStrategyInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="CHECKSTRATEGY_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CHECKSTRATEGY_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CHECKSTRATEGY_TABLE_GENERATOR")
	protected Integer csid;

	/** 检查名称 */
	protected String csname;

	/** 描述 */
	protected String csdesc;

	/** 状态 */
	protected String csstatus;

	/** 开始日期 */
	protected String csstartdate;

	/** 结束日期 */
	protected String csenddate;

	/** 检查方式*/
	protected String csrtestmode;
	
	/** 频率 */
	protected String csfrequency;
	
	/** 重要程度*/
	protected String cstype;

	/** 策略执行表达式 */
	protected String cscron;

	/** 责任人ID */
	protected String csuserid;

	/** 责任人姓名 */
	protected String csusername;

	/** 责任组角色ID */
	protected String csroleid;

	/** 责任组角色名称 */
	protected String csrolename;

	/** 合作责任人id */
	protected String csasset;
	
	/** 合作责任人姓名 */
	protected String csassetname;
	
	/** 合作责任组角色id*/
	protected String csassetorgid;
	
	/** 合作责任组名称*/
	protected String csassetorgname;
	
	/** 附件 */
	protected String csattch ;

	/** 选项 */
	protected String csoption ;
	
	

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCsid() {
		return csid;
	}

	/**
	 * 主键设定
	 *
	 * @param csid 主键
	 */
	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	/**
	 * 检查名称取得
	 *
	 * @return 检查名称
	 */
	public String getCsname() {
		return csname;
	}

	/**
	 * 检查名称设定
	 *
	 * @param csname 检查名称
	 */
	public void setCsname(String csname) {
		this.csname = csname;
	}

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getCsdesc() {
		return csdesc;
	}

	/**
	 * 描述设定
	 *
	 * @param csdesc 描述
	 */
	public void setCsdesc(String csdesc) {
		this.csdesc = csdesc;
	}

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getCsstatus() {
		return csstatus;
	}

	/**
	 * 状态设定
	 *
	 * @param csstatus 状态
	 */
	public void setCsstatus(String csstatus) {
		this.csstatus = csstatus;
	}

	/**
	 * 开始日期取得
	 *
	 * @return 开始日期
	 */
	public String getCsstartdate() {
		return csstartdate;
	}

	/**
	 * 开始日期设定
	 *
	 * @param csstartdate 开始日期
	 */
	public void setCsstartdate(String csstartdate) {
		this.csstartdate = csstartdate;
	}

	/**
	 * 结束日期取得
	 *
	 * @return 结束日期
	 */
	public String getCsenddate() {
		return csenddate;
	}

	/**
	 * 结束日期设定
	 *
	 * @param csenddate 结束日期
	 */
	public void setCsenddate(String csenddate) {
		this.csenddate = csenddate;
	}

	/**
	 * 频率取得
	 *
	 * @return 频率
	 */
	public String getCsfrequency() {
		return csfrequency;
	}

	/**
	 * 频率设定
	 *
	 * @param csfrequency 频率
	 */
	public void setCsfrequency(String csfrequency) {
		this.csfrequency = csfrequency;
	}

	/**
	 * 策略执行表达式取得
	 *
	 * @return 策略执行表达式
	 */
	public String getCscron() {
		return cscron;
	}

	/**
	 * 策略执行表达式设定
	 *
	 * @param cscron 策略执行表达式
	 */
	public void setCscron(String cscron) {
		this.cscron = cscron;
	}

	/**
	 * 责任人ID取得
	 *
	 * @return 责任人ID
	 */
	public String getCsuserid() {
		return csuserid;
	}

	/**
	 * 责任人ID设定
	 *
	 * @param csuserid 责任人ID
	 */
	public void setCsuserid(String csuserid) {
		this.csuserid = csuserid;
	}

	/**
	 * 责任人姓名取得
	 *
	 * @return 责任人姓名
	 */
	public String getCsusername() {
		return csusername;
	}

	/**
	 * 责任人姓名设定
	 *
	 * @param csusername 责任人姓名
	 */
	public void setCsusername(String csusername) {
		this.csusername = csusername;
	}

	/**
	 * 责任组角色ID取得
	 *
	 * @return 责任组角色ID
	 */
	public String getCsroleid() {
		return csroleid;
	}

	/**
	 * 责任组角色ID设定
	 *
	 * @param csroleid 责任组角色ID
	 */
	public void setCsroleid(String csroleid) {
		this.csroleid = csroleid;
	}

	/**
	 * 责任组角色名称取得
	 *
	 * @return 责任组角色名称
	 */
	public String getCsrolename() {
		return csrolename;
	}

	/**
	 * 责任组角色名称设定
	 *
	 * @param csrolename 责任组角色名称
	 */
	public void setCsrolename(String csrolename) {
		this.csrolename = csrolename;
	}

	/**
	 * 合作责任人id取得
	 *
	 * @return 合作责任人id
	 */
	public String getCsasset() {
		return csasset;
	}

	/**
	 * 合作责任人id设定
	 *
	 * @param csasset 合作责任人id
	 */
	public void setCsasset(String csasset) {
		this.csasset = csasset;
	}

	/**
	 * 合作责任人姓名取得
	 *
	 * @return 合作责任人姓名
	 */
	public String getCsassetname() {
		return csassetname;
	}

	/**
	 * 合作责任人姓名设定
	 *
	 * @param csassetname 合作责任人姓名
	 */
	public void setCsassetname(String csassetname) {
		this.csassetname = csassetname;
	}

	/**
	 * 附件取得
	 *
	 * @return 附件
	 */
	public String getCsattch () {
		return csattch ;
	}

	/**
	 * 附件设定
	 *
	 * @param csattch  附件
	 */
	public void setCsattch (String csattch ) {
		this.csattch  = csattch ;
	}

	/**
	 * 选项取得
	 *
	 * @return 选项
	 */
	public String getCsoption () {
		return csoption ;
	}

	/**
	 * 选项设定
	 *
	 * @param csoption  选项
	 */
	public void setCsoption (String csoption ) {
		this.csoption  = csoption ;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return csid;
	}

	/**
	 * @return the csrtestmode
	 */
	public String getCsrtestmode() {
		return csrtestmode;
	}

	/**
	 * @param csrtestmode the csrtestmode to set
	 */
	public void setCsrtestmode(String csrtestmode) {
		this.csrtestmode = csrtestmode;
	}

	/**
	 * @return the cstype
	 */
	public String getCstype() {
		return cstype;
	}

	/**
	 * @param cstype the cstype to set
	 */
	public void setCstype(String cstype) {
		this.cstype = cstype;
	}

	/**
	 * @return the csassetorgid
	 */
	public String getCsassetorgid() {
		return csassetorgid;
	}

	/**
	 * @param csassetorgid the csassetorgid to set
	 */
	public void setCsassetorgid(String csassetorgid) {
		this.csassetorgid = csassetorgid;
	}

	/**
	 * @return the csassetorgname
	 */
	public String getCsassetorgname() {
		return csassetorgname;
	}

	/**
	 * @param csassetorgname the csassetorgname to set
	 */
	public void setCsassetorgname(String csassetorgname) {
		this.csassetorgname = csassetorgname;
	}

	
}