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
import com.deliverik.infogovernor.soc.vir.model.VCD06Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: vCloud组织与平台机构对照实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="VCD06")
public class VCD06TB extends BaseEntity implements VCD06Info{
	
	/** 主键 */
	@Id
	@TableGenerator(
		name="VCD06_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VCD06_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VCD06_TABLE_GENERATOR")
	protected Integer id;
	
	/** vCloud组织 */
	protected String vorg;
	
	/** 机构吗 */
	protected String orgsyscoding;
	
	/** 机构名称 */
	protected String orgname;

	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * vCloud组织取得
	 * @return vorg vCloud组织
	 */
	public String getVorg() {
		return vorg;
	}

	/**
	 * vCloud组织设定
	 * @param vorg vCloud组织
	 */
	public void setVorg(String vorg) {
		this.vorg = vorg;
	}

	/**
	 * 机构吗取得
	 * @return orgsyscoding 机构吗
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * 机构吗设定
	 * @param orgsyscoding 机构吗
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * 机构名称取得
	 * @return orgname 机构名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 机构名称设定
	 * @param orgname 机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public Serializable getPK() {
		return this.id;
	}

}
