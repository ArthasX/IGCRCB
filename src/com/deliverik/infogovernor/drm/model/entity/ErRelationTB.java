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
import com.deliverik.infogovernor.drm.model.ErRelationInfo;

/**
  * 概述: 应急资源关系实体
  * 功能描述: 应急资源关系实体
  * 创建记录: 2016/06/14
  * 修改记录: 2017年3月16日15:48:17  使用fingerprint资源记录 资源类型(1:应急资源,0演练资源)
  */
@SuppressWarnings("serial")
@Entity
@Table(name="ErRelation")
public class ErRelationTB extends BaseEntity implements Serializable,
		Cloneable, ErRelationInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="ERRELATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="ERRELATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ERRELATION_TABLE_GENERATOR")
	protected Integer errid;

	/** 应急资源主键 */
	protected Integer erid;

	/** 资源编码 */
	protected String ercode;

	/** 资产id */
	protected String eiid;

	/** 删除标志 */
	protected String deleteflag;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getErrid() {
		return errid;
	}

	/**
	 * 主键设定
	 *
	 * @param errid 主键
	 */
	public void setErrid(Integer errid) {
		this.errid = errid;
	}

	/**
	 * 应急资源主键取得
	 *
	 * @return 应急资源主键
	 */
	public Integer getErid() {
		return erid;
	}

	/**
	 * 应急资源主键设定
	 *
	 * @param erid 应急资源主键
	 */
	public void setErid(Integer erid) {
		this.erid = erid;
	}

	/**
	 * 资源编码取得
	 *
	 * @return 资源编码
	 */
	public String getErcode() {
		return ercode;
	}

	/**
	 * 资源编码设定
	 *
	 * @param ercode 资源编码
	 */
	public void setErcode(String ercode) {
		this.ercode = ercode;
	}


	/**
	 * 资产id取得
	 *
	 * @return 资产id
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 资产id设定
	 *
	 * @param eiid 资产id
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}



	/**
	 * 删除标志取得
	 *
	 * @return 删除标志
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * 删除标志设定
	 *
	 * @param deleteflag 删除标志
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return errid;
	}

}