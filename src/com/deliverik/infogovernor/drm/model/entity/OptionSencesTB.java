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
import com.deliverik.infogovernor.drm.model.OptionSencesInfo;

/**
  * 概述: 备选场景实体
  * 功能描述: 备选场景实体
  * 创建记录: 2016/10/09
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="OptionSences")
public class OptionSencesTB extends BaseEntity implements Serializable,
		Cloneable, OptionSencesInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="OPTIONSENCES_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="OPTIONSENCES_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="OPTIONSENCES_TABLE_GENERATOR")
	protected Integer osid;

	/** 应急流程prid */
	protected Integer prid;

	/** 场景eiid */
	protected Integer senceEiid;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getOsid() {
		return osid;
	}

	/**
	 * 主键设定
	 *
	 * @param osid 主键
	 */
	public void setOsid(Integer osid) {
		this.osid = osid;
	}

	/**
	 * 应急流程prid取得
	 *
	 * @return 应急流程prid
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 应急流程prid设定
	 *
	 * @param prid 应急流程prid
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 场景eiid取得
	 *
	 * @return 场景eiid
	 */
	public Integer getSenceEiid() {
		return senceEiid;
	}

	/**
	 * 场景eiid设定
	 *
	 * @param senceEiid 场景eiid
	 */
	public void setSenceEiid(Integer senceEiid) {
		this.senceEiid = senceEiid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return osid;
	}

}