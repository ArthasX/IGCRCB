/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.vir.model.VCD05Info;

/**
  * 概述: vCloud部署模板实体
  * 功能描述: vCloud部署模板实体
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="VCD05")
public class VCD05TB extends BaseEntity implements Serializable,
		Cloneable, VCD05Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="VCD05_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VCD05_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VCD05_TABLE_GENERATOR")
	protected Integer id;

	/** 模板名称 */
	protected String templateName;

	/** vCloudId */
	protected Integer vcloudid;

	/** vapp名称 */
	protected String vappname;

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
	 * 模板名称取得
	 *
	 * @return 模板名称
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * 模板名称设定
	 *
	 * @param templateName 模板名称
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * vCloudId取得
	 *
	 * @return vCloudId
	 */
	public Integer getVcloudid() {
		return vcloudid;
	}

	/**
	 * vCloudId设定
	 *
	 * @param vcloudid vCloudId
	 */
	public void setVcloudid(Integer vcloudid) {
		this.vcloudid = vcloudid;
	}

	/**
	 * vapp名称取得
	 *
	 * @return vapp名称
	 */
	public String getVappname() {
		return vappname;
	}

	/**
	 * vapp名称设定
	 *
	 * @param vappname vapp名称
	 */
	public void setVappname(String vappname) {
		this.vappname = vappname;
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