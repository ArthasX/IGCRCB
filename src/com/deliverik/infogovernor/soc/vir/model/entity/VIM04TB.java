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
import com.deliverik.infogovernor.soc.vir.model.VIM04Info;

/**
  * 概述: 日志表实体
  * 功能描述: 日志表实体
  * 创建记录: 2014/02/19
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="VIM04")
public class VIM04TB extends BaseEntity implements Serializable,
		Cloneable, VIM04Info {

	/** 自增主键 */
	@Id
	@TableGenerator(
		name="VIM04_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VIM04_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VIM04_TABLE_GENERATOR")
	protected Integer id;

	/** 项目主键 */
	protected Integer pid;

	/** 虚机名称 */
	protected String vmName;

	/** 日志内容 */
	protected String content;

	/** 发生时间 */
	protected String updateTime;

	/** 标志 （0：失败 1：成功） */
	protected String flag;
	
	/**
	 * 自增主键取得
	 *
	 * @return 自增主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 自增主键设定
	 *
	 * @param id 自增主键
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
     * 获取发生时间
     * @return 发生时间 
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置发生时间
     * @param updateTime 发生时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return id;
	}

    /**
     * 获取标志（0：失败1：成功）
     * @return 标志（0：失败1：成功） 
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置标志（0：失败1：成功）
     * @param flag 标志（0：失败1：成功）
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

}