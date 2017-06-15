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

import com.deliverik.infogovernor.drm.model.SigninInfo;

/**
  * 概述: 签到表实体
  * 功能描述: 签到表实体
  * 创建记录: 2015/03/12
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="signin")
public class SigninTB implements Serializable,
		Cloneable, SigninInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="SIGNIN_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SIGNIN_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SIGNIN_TABLE_GENERATOR")
	protected Integer siid;

	/** 演练流程id */
	protected Integer drillprid;

	/** 应急指挥流程id */
	protected Integer ecprid;

	/** 场景流程id */
	protected Integer sceneprid;

	/** 用户id */
	protected String siuserid;
	/** 用户名 */
	protected String siusername;

	/** 角色id */
	protected Integer siroleid;

	/** 是否应急指挥参与人 */
	protected Integer wdc;

	/** 是否场景参与人 */
	protected Integer wdp;

	/** 是否签到 */
	protected Integer signined;

	/** 签到时间 */
	protected String sitime;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getSiid() {
		return siid;
	}

	/**
	 * 主键设定
	 *
	 * @param siid 主键
	 */
	public void setSiid(Integer siid) {
		this.siid = siid;
	}

	/**
	 * 演练流程id取得
	 *
	 * @return 演练流程id
	 */
	public Integer getDrillprid() {
		return drillprid;
	}

	/**
	 * 演练流程id设定
	 *
	 * @param drillprid 演练流程id
	 */
	public void setDrillprid(Integer drillprid) {
		this.drillprid = drillprid;
	}

	/**
	 * 应急指挥流程id取得
	 *
	 * @return 应急指挥流程id
	 */
	public Integer getEcprid() {
		return ecprid;
	}

	/**
	 * 应急指挥流程id设定
	 *
	 * @param ecprid 应急指挥流程id
	 */
	public void setEcprid(Integer ecprid) {
		this.ecprid = ecprid;
	}

	/**
	 * 场景流程id取得
	 *
	 * @return 场景流程id
	 */
	public Integer getSceneprid() {
		return sceneprid;
	}

	/**
	 * 场景流程id设定
	 *
	 * @param sceneprid 场景流程id
	 */
	public void setSceneprid(Integer sceneprid) {
		this.sceneprid = sceneprid;
	}

	/**
	 * 用户id取得
	 *
	 * @return 用户id
	 */
	public String getSiuserid() {
		return siuserid;
	}

	/**
	 * 用户id设定
	 *
	 * @param siuserid 用户id
	 */
	public void setSiuserid(String siuserid) {
		this.siuserid = siuserid;
	}
	/**
	 * 用户名取得
	 *
	 * @return 用户名
	 */
	public String getSiusername() {
		return siusername;
	}
	
	/**
	 * 用户名设定
	 *
	 * @param siuserid 用户名
	 */
	public void setSiusername(String siusername) {
		this.siusername = siusername;
	}

	/**
	 * 角色id取得
	 *
	 * @return 角色id
	 */
	public Integer getSiroleid() {
		return siroleid;
	}

	/**
	 * 角色id设定
	 *
	 * @param siroleid 角色id
	 */
	public void setSiroleid(Integer siroleid) {
		this.siroleid = siroleid;
	}

	/**
	 * 是否应急指挥参与人取得
	 *
	 * @return 是否应急指挥参与人
	 */
	public Integer getWdc() {
		return wdc;
	}

	/**
	 * 是否应急指挥参与人设定
	 *
	 * @param wdc 是否应急指挥参与人
	 */
	public void setWdc(Integer wdc) {
		this.wdc = wdc;
	}

	/**
	 * 是否场景参与人取得
	 *
	 * @return 是否场景参与人
	 */
	public Integer getWdp() {
		return wdp;
	}

	/**
	 * 是否场景参与人设定
	 *
	 * @param wdp 是否场景参与人
	 */
	public void setWdp(Integer wdp) {
		this.wdp = wdp;
	}

	/**
	 * 是否签到取得
	 *
	 * @return 是否签到
	 */
	public Integer getSignined() {
		return signined;
	}

	/**
	 * 是否签到设定
	 *
	 * @param signined 是否签到
	 */
	public void setSignined(Integer signined) {
		this.signined = signined;
	}

	/**
	 * 签到时间取得
	 *
	 * @return 签到时间
	 */
	public String getSitime() {
		return sitime;
	}

	/**
	 * 签到时间设定
	 *
	 * @param sitime 签到时间
	 */
	public void setSitime(String sitime) {
		this.sitime = sitime;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return siid;
	}

}