/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;

/**
  * 概述: 风险指标查询实体
  * 功能描述: 风险指标查询实体
  * 创建记录: 2014/07/25
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RiskIndexSearchVW")
public class RiskIndexSearchVW extends BaseEntity implements Serializable,
		Cloneable, RiskIndexSearchVWInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="RISKINDEXSEARCHVW_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="RISKINDEXSEARCHVW_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKINDEXSEARCHVW_TABLE_GENERATOR")
	protected Integer eiid;

	/** 责任部门 */
	protected String dutydepartment;

	/**  */
	protected String esyscoding;

	/** 指标名 */
	protected String einame;

	/** 登记日期 */
	protected String eiinsdate;

	/** 编号 */
	protected String eilabel;

	/** 更新日期 */
	protected String eiupdtime;

	/** 小版本 */
	protected String eismallversion;

	/** 阀值 */
	protected String zbfz;

	/** 状态 */
	protected String eistatus;

	/** 登记人ID */
	protected String eiuserid;

	/** 登记人名字 */
	protected String eiusername;

	/** eid */
	protected String eid;

	/**  */
	protected String eirootmark;

	/** 管理人ID */
	protected String mguserid;

	/** 用途 */
	protected String indexused;

	/** 是否关键指标 */
	protected String keyindex;

	/** 指标说明 */
	protected String eidesc;

	/** 机构码 */
	protected String eiorgsyscoding;

	/** 版本号 */
	protected String eiversion;

	/** 责任人 */
	protected String dutyuser;

	/** 风险领域 */
	protected String riskly;

	/** 风险域 */
	protected String riskarea;

	/** 风险项 */
	protected String riskitem;

	/** 管理人名 */
	protected String mgusername;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 主键设定
	 *
	 * @param eiid 主键
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 责任部门取得
	 *
	 * @return 责任部门
	 */
	public String getDutydepartment() {
		return dutydepartment;
	}

	/**
	 * 责任部门设定
	 *
	 * @param dutydepartment 责任部门
	 */
	public void setDutydepartment(String dutydepartment) {
		this.dutydepartment = dutydepartment;
	}

	/**
	 * 取得
	 *
	 * @return 
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 设定
	 *
	 * @param esyscoding 
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 指标名取得
	 *
	 * @return 指标名
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 指标名设定
	 *
	 * @param einame 指标名
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 登记日期取得
	 *
	 * @return 登记日期
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 登记日期设定
	 *
	 * @param eiinsdate 登记日期
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * 编号取得
	 *
	 * @return 编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 编号设定
	 *
	 * @param eilabel 编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 更新日期取得
	 *
	 * @return 更新日期
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * 更新日期设定
	 *
	 * @param eiupdtime 更新日期
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * 小版本取得
	 *
	 * @return 小版本
	 */
	public String getEismallversion() {
		return eismallversion;
	}

	/**
	 * 小版本设定
	 *
	 * @param eismallversion 小版本
	 */
	public void setEismallversion(String eismallversion) {
		this.eismallversion = eismallversion;
	}

	/**
	 * 阀值取得
	 *
	 * @return 阀值
	 */
	public String getZbfz() {
		return zbfz;
	}

	/**
	 * 阀值设定
	 *
	 * @param zbfz 阀值
	 */
	public void setZbfz(String zbfz) {
		this.zbfz = zbfz;
	}

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * 状态设定
	 *
	 * @param eistatus 状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * 登记人ID取得
	 *
	 * @return 登记人ID
	 */
	public String getEiuserid() {
		return eiuserid;
	}

	/**
	 * 登记人ID设定
	 *
	 * @param eiuserid 登记人ID
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}

	/**
	 * 登记人名字取得
	 *
	 * @return 登记人名字
	 */
	public String getEiusername() {
		return eiusername;
	}

	/**
	 * 登记人名字设定
	 *
	 * @param eiusername 登记人名字
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	/**
	 * eid取得
	 *
	 * @return eid
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * eid设定
	 *
	 * @param eid eid
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 取得
	 *
	 * @return 
	 */
	public String getEirootmark() {
		return eirootmark;
	}

	/**
	 * 设定
	 *
	 * @param eirootmark 
	 */
	public void setEirootmark(String eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * 管理人ID取得
	 *
	 * @return 管理人ID
	 */
	public String getMguserid() {
		return mguserid;
	}

	/**
	 * 管理人ID设定
	 *
	 * @param mguserid 管理人ID
	 */
	public void setMguserid(String mguserid) {
		this.mguserid = mguserid;
	}

	/**
	 * 用途取得
	 *
	 * @return 用途
	 */
	public String getIndexused() {
		return indexused;
	}

	/**
	 * 用途设定
	 *
	 * @param indexused 用途
	 */
	public void setIndexused(String indexused) {
		this.indexused = indexused;
	}

	/**
	 * 是否关键指标取得
	 *
	 * @return 是否关键指标
	 */
	public String getKeyindex() {
		return keyindex;
	}

	/**
	 * 是否关键指标设定
	 *
	 * @param keyindex 是否关键指标
	 */
	public void setKeyindex(String keyindex) {
		this.keyindex = keyindex;
	}

	/**
	 * 指标说明取得
	 *
	 * @return 指标说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 指标说明设定
	 *
	 * @param eidesc 指标说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 机构码取得
	 *
	 * @return 机构码
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	/**
	 * 机构码设定
	 *
	 * @param eiorgsyscoding 机构码
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * 版本号取得
	 *
	 * @return 版本号
	 */
	public String getEiversion() {
		return eiversion;
	}

	/**
	 * 版本号设定
	 *
	 * @param eiversion 版本号
	 */
	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 责任人取得
	 *
	 * @return 责任人
	 */
	public String getDutyuser() {
		return dutyuser;
	}

	/**
	 * 责任人设定
	 *
	 * @param dutyuser 责任人
	 */
	public void setDutyuser(String dutyuser) {
		this.dutyuser = dutyuser;
	}

	/**
	 * 风险领域取得
	 *
	 * @return 风险领域
	 */
	public String getRiskly() {
		return riskly;
	}

	/**
	 * 风险领域设定
	 *
	 * @param riskly 风险领域
	 */
	public void setRiskly(String riskly) {
		this.riskly = riskly;
	}

	/**
	 * 风险域取得
	 *
	 * @return 风险域
	 */
	public String getRiskarea() {
		return riskarea;
	}

	/**
	 * 风险域设定
	 *
	 * @param riskarea 风险域
	 */
	public void setRiskarea(String riskarea) {
		this.riskarea = riskarea;
	}

	/**
	 * 风险项取得
	 *
	 * @return 风险项
	 */
	public String getRiskitem() {
		return riskitem;
	}

	/**
	 * 风险项设定
	 *
	 * @param riskitem 风险项
	 */
	public void setRiskitem(String riskitem) {
		this.riskitem = riskitem;
	}

	/**
	 * 管理人名取得
	 *
	 * @return 管理人名
	 */
	public String getMgusername() {
		return mgusername;
	}

	/**
	 * 管理人名设定
	 *
	 * @param mgusername 管理人名
	 */
	public void setMgusername(String mgusername) {
		this.mgusername = mgusername;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return eiid;
	}

}