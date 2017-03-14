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
import com.deliverik.infogovernor.soc.vir.model.VIM07Info;

/**
  * 概述: 虚机调整信息表实体
  * 功能描述: 虚机调整信息表实体
  * 创建记录: 2014/03/24
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="vim07")
public class VIM07TB extends BaseEntity implements Serializable,
		Cloneable, VIM07Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="VIM07_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VIM07_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VIM07_TABLE_GENERATOR")
	protected Integer id;

	/** 虚机主键 */
	protected Integer vmid;
	
	/** 项目ID */
	protected Integer pid;

	/** 调整类型 */
	protected String ctype;

	/** 流程主键 */
	protected Integer prid;

	/** 调整申请时间 */
	protected String ctime;

	/** 调整完成时间 */
	protected String atime;
	
	/** 调整用户ID */
	protected String userid;

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
	 * 虚机主键取得
	 *
	 * @return 虚机主键
	 */
	public Integer getVmid() {
		return vmid;
	}

	/**
	 * 虚机主键设定
	 *
	 * @param vmid 虚机主键
	 */
	public void setVmid(Integer vmid) {
		this.vmid = vmid;
	}

	/**
	 * 项目ID取得
	 * @return pid 项目ID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 项目ID设定
	 * @param pid 项目ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * 调整类型取得
	 *
	 * @return 调整类型
	 */
	public String getCtype() {
		return ctype;
	}

	/**
	 * 调整类型设定
	 *
	 * @param ctype 调整类型
	 */
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	/**
	 * 流程主键取得
	 *
	 * @return 流程主键
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程主键设定
	 *
	 * @param prid 流程主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 调整申请时间取得
	 *
	 * @return 调整申请时间
	 */
	public String getCtime() {
		return ctime;
	}

	/**
	 * 调整申请时间设定
	 *
	 * @param ctime 调整申请时间
	 */
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	/**
	 * 调整完成时间取得
	 *
	 * @return 调整完成时间
	 */
	public String getAtime() {
		return atime;
	}

	/**
	 * 调整完成时间设定
	 *
	 * @param atime 调整完成时间
	 */
	public void setAtime(String atime) {
		this.atime = atime;
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
	 * 调整用户ID取得
	 * @return userid 调整用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 调整用户ID设定
	 * @param userid 调整用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

}