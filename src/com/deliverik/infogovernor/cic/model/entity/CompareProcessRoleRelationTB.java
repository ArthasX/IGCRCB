/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.cic.model.CompareProcessRoleRelationInfo;

/**
  * 概述: 关系表实体
  * 功能描述: 关系表实体
  * 创建记录: 2014/04/24
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="compareprocessrolerelation")
public class CompareProcessRoleRelationTB extends BaseEntity implements Serializable,
		Cloneable, CompareProcessRoleRelationInfo {

	/** 主键 */
	@Id
	@GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "sequence", 
            parameters = { @Parameter(name = "sequence", 
                        value = "compareprocessrolerelation_seq") })
	protected Integer id;

	/** 比对任务表主键 */
	protected Integer cpid;

	/** 对比规则表主键 */
	protected Integer crid;

	/** 比对规则表版本 */
	protected Integer crversion;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 *
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 比对任务表主键取得
	 *
	 * @return 比对任务表主键
	 */
	public Integer getCpid() {
		return cpid;
	}

	/**
	 * 比对任务表主键设定
	 *
	 * @param cpid 比对任务表主键
	 */
	public void setCpid(Integer cpid) {
		this.cpid = cpid;
	}

	/**
	 * 对比规则表主键取得
	 *
	 * @return 对比规则表主键
	 */
	public Integer getCrid() {
		return crid;
	}

	/**
	 * 对比规则表主键设定
	 *
	 * @param crid 对比规则表主键
	 */
	public void setCrid(Integer crid) {
		this.crid = crid;
	}

	/**
	 * 比对规则表版本取得
	 *
	 * @return 比对规则表版本
	 */
	public Integer getCrversion() {
		return crversion;
	}

	/**
	 * 比对规则表版本设定
	 *
	 * @param crversion 比对规则表版本
	 */
	public void setCrversion(Integer crversion) {
		this.crversion = crversion;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return id;
	}

}