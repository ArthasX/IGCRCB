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
import com.deliverik.infogovernor.soc.vir.model.VCD04Info;

/**
  * 概述: vCloud部署日志实体
  * 功能描述: vCloud部署日志实体
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="VCD04")
public class VCD04TB extends BaseEntity implements Serializable,
		Cloneable, VCD04Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="VCD04_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VCD04_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VCD04_TABLE_GENERATOR")
	protected Integer id;

	/** 项目主键 */
	protected Integer pid;

	/** 虚机名称 */
	protected String vmName;

	/** 日志内容 */
	protected String content;

	/** 发生时间 */
	protected String updateTime;

	/** 标志 */
	protected String flag;

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
	 * 项目主键取得
	 *
	 * @return 项目主键
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 项目主键设定
	 *
	 * @param pid 项目主键
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * 虚机名称取得
	 *
	 * @return 虚机名称
	 */
	public String getVmName() {
		return vmName;
	}

	/**
	 * 虚机名称设定
	 *
	 * @param vmName 虚机名称
	 */
	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

	/**
	 * 日志内容取得
	 *
	 * @return 日志内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 日志内容设定
	 *
	 * @param content 日志内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 发生时间取得
	 *
	 * @return 发生时间
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * 发生时间设定
	 *
	 * @param updateTime 发生时间
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 标志取得
	 *
	 * @return 标志
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 标志设定
	 *
	 * @param flag 标志
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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