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
import com.deliverik.infogovernor.drm.model.TrainmissionInfo;

/**
  * 概述: 培训任务表实体
  * 功能描述: 培训任务表实体
  * 创建记录: 2015/04/10
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="trainmission")
public class TrainmissionTB extends BaseEntity implements Serializable,
		Cloneable, TrainmissionInfo {

	/** tmid */
	@Id
	@TableGenerator(
			name="TRAINMISSION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
			pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
			pkColumnValue="TRAINMISSION_SEQUENCE", initialValue=1, allocationSize=1
		)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TRAINMISSION_TABLE_GENERATOR")
	protected Integer tmid;

	/** 外键 */
	protected  Integer tpid;

	/** 培训课程 */
	protected String tmcourse;

	/** 培训机构 */
	protected String tmorg;

	/** 培训时间 */
	protected String tmtime;

	/** 培训对象 */
	protected String tmtarget;

	/** 附件key */
	protected String tmatt;

	/**
	 * tmid取得
	 *
	 * @return tmid
	 */
	public Integer getTmid() {
		return tmid;
	}

	/**
	 * tmid设定
	 *
	 * @param tmid tmid
	 */
	public void setTmid(Integer tmid) {
		this.tmid = tmid;
	}

	/**
	 * 外键取得
	 *
	 * @return 外键
	 */
	public Integer getTpid() {
		return tpid;
	}

	/**
	 * 外键设定
	 *
	 * @param tpid 外键
	 */
	public void setTpid(Integer tpid) {
		this.tpid = tpid;
	}

	/**
	 * 培训课程取得
	 *
	 * @return 培训课程
	 */
	public String getTmcourse() {
		return tmcourse;
	}

	/**
	 * 培训课程设定
	 *
	 * @param tmcourse 培训课程
	 */
	public void setTmcourse(String tmcourse) {
		this.tmcourse = tmcourse;
	}

	/**
	 * 培训机构取得
	 *
	 * @return 培训机构
	 */
	public String getTmorg() {
		return tmorg;
	}

	/**
	 * 培训机构设定
	 *
	 * @param tmorg 培训机构
	 */
	public void setTmorg(String tmorg) {
		this.tmorg = tmorg;
	}

	/**
	 * 培训时间取得
	 *
	 * @return 培训时间
	 */
	public String getTmtime() {
		return tmtime;
	}

	/**
	 * 培训时间设定
	 *
	 * @param tmtime 培训时间
	 */
	public void setTmtime(String tmtime) {
		this.tmtime = tmtime;
	}

	/**
	 * 培训对象取得
	 *
	 * @return 培训对象
	 */
	public String getTmtarget() {
		return tmtarget;
	}

	/**
	 * 培训对象设定
	 *
	 * @param tmtarget 培训对象
	 */
	public void setTmtarget(String tmtarget) {
		this.tmtarget = tmtarget;
	}

	/**
	 * 附件取得
	 *
	 * @return 附件
	 */
	public String getTmatt() {
		return tmatt;
	}

	/**
	 * 附件设定
	 *
	 * @param tmatt 附件
	 */
	public void setTmatt(String tmatt) {
		this.tmatt = tmatt;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return tmid;
	}

	
}