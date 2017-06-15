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
import com.deliverik.infogovernor.drm.model.DrillplanitemInfo;

/**
  * 概述: 演练计划条目实体
  * 功能描述: 演练计划条目实体
  * 创建记录: 2015/03/02
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="drillplanitem")
public class DrillplanitemTB extends BaseEntity implements Serializable,
		Cloneable, DrillplanitemInfo {

	/** 演练计划条目id */
	@Id
	@TableGenerator(
		name="DRILLPLANITEM_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="DRILLPLANITEM_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="DRILLPLANITEM_TABLE_GENERATOR")
	protected Integer diid;

	/** 演练计划id */
	protected Integer did;

	/** 演练流程prid */
	protected Integer prid;

	/** 演练状态 已演练/未演练 */
	protected String status;

	/** 演练预期开始时间 */
	protected String expecttime;

	/** 演练实际开始时间 */
	protected String actstarttime;

	/** 演练名称 */
	protected String diname;

	/** 演练内容 */
	protected String dicontant;

	/** 演练目的 */
	protected String didestination;

	/** 演练场景 */
	protected String discene;

	/** 影响范围 */
	protected String discope;

	/** 演练负责部门 */
	protected String didutyorg;

	/** 参与部门 */
	protected String partorg;

	/**
	 * 演练计划条目id取得
	 *
	 * @return 演练计划条目id
	 */
	public Integer getDiid() {
		return diid;
	}

	/**
	 * 演练计划条目id设定
	 *
	 * @param diid 演练计划条目id
	 */
	public void setDiid(Integer diid) {
		this.diid = diid;
	}

	/**
	 * 演练计划id取得
	 *
	 * @return 演练计划id
	 */
	public Integer getDid() {
		return did;
	}

	/**
	 * 演练计划id设定
	 *
	 * @param did 演练计划id
	 */
	public void setDid(Integer did) {
		this.did = did;
	}

	/**
	 * 演练流程prid取得
	 *
	 * @return 演练流程prid
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 演练流程prid设定
	 *
	 * @param prid 演练流程prid
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 演练状态 已演练/未演练取得
	 *
	 * @return 演练状态 已演练/未演练
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 演练状态 已演练/未演练设定
	 *
	 * @param status 演练状态 已演练/未演练
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 演练预期开始时间取得
	 *
	 * @return 演练预期开始时间
	 */
	public String getExpecttime() {
		return expecttime;
	}

	/**
	 * 演练预期开始时间设定
	 *
	 * @param expecttime 演练预期开始时间
	 */
	public void setExpecttime(String expecttime) {
		this.expecttime = expecttime;
	}

	/**
	 * 演练实际开始时间取得
	 *
	 * @return 演练实际开始时间
	 */
	public String getActstarttime() {
		return actstarttime;
	}

	/**
	 * 演练实际开始时间设定
	 *
	 * @param actstarttime 演练实际开始时间
	 */
	public void setActstarttime(String actstarttime) {
		this.actstarttime = actstarttime;
	}

	/**
	 * 演练名称取得
	 *
	 * @return 演练名称
	 */
	public String getDiname() {
		return diname;
	}

	/**
	 * 演练名称设定
	 *
	 * @param diname 演练名称
	 */
	public void setDiname(String diname) {
		this.diname = diname;
	}

	/**
	 * 演练内容取得
	 *
	 * @return 演练内容
	 */
	public String getDicontant() {
		return dicontant;
	}

	/**
	 * 演练内容设定
	 *
	 * @param dicontant 演练内容
	 */
	public void setDicontant(String dicontant) {
		this.dicontant = dicontant;
	}

	/**
	 * 演练目的取得
	 *
	 * @return 演练目的
	 */
	public String getDidestination() {
		return didestination;
	}

	/**
	 * 演练目的设定
	 *
	 * @param didestination 演练目的
	 */
	public void setDidestination(String didestination) {
		this.didestination = didestination;
	}

	/**
	 * 演练场景取得
	 *
	 * @return 演练场景
	 */
	public String getDiscene() {
		return discene;
	}

	/**
	 * 演练场景设定
	 *
	 * @param discene 演练场景
	 */
	public void setDiscene(String discene) {
		this.discene = discene;
	}

	/**
	 * 影响范围取得
	 *
	 * @return 影响范围
	 */
	public String getDiscope() {
		return discope;
	}

	/**
	 * 影响范围设定
	 *
	 * @param discope 影响范围
	 */
	public void setDiscope(String discope) {
		this.discope = discope;
	}

	/**
	 * 演练负责部门取得
	 *
	 * @return 演练负责部门
	 */
	public String getDidutyorg() {
		return didutyorg;
	}

	/**
	 * 演练负责部门设定
	 *
	 * @param didutyorg 演练负责部门
	 */
	public void setDidutyorg(String didutyorg) {
		this.didutyorg = didutyorg;
	}

	/**
	 * 参与部门取得
	 *
	 * @return 参与部门
	 */
	public String getPartorg() {
		return partorg;
	}

	/**
	 * 参与部门设定
	 *
	 * @param partorg 参与部门
	 */
	public void setPartorg(String partorg) {
		this.partorg = partorg;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return diid;
	}

}