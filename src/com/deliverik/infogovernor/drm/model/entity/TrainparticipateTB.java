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
import com.deliverik.infogovernor.drm.model.TrainparticipateInfo;

/**
  * 概述: 培训参与人实体
  * 功能描述: 培训参与人实体
  * 创建记录: 2015/04/13
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="trainparticipate")
public class TrainparticipateTB extends BaseEntity implements Serializable,
		Cloneable, TrainparticipateInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="TRAINPARTICIPATE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="TRAINPARTICIPATE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TRAINPARTICIPATE_TABLE_GENERATOR")
	protected Integer tpaid;

	/** 培训人姓名 */
	protected String tpaname;

	/** 培训人联系电话 */
	protected String tpatel;

	/** 培训记录id */
	protected Integer trid;
	
	protected String tpaorg;
	
	

	/**  
	 * 获取tpaorg  
	 * @return tpaorg tpaorg  
	 */
	
	public String getTpaorg() {
		return tpaorg;
	}

	/**  
	 * 设置tpaorg  
	 * @param tpaorg tpaorg  
	 */
	
	public void setTpaorg(String tpaorg) {
		this.tpaorg = tpaorg;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getTpaid() {
		return tpaid;
	}

	/**
	 * 主键设定
	 *
	 * @param tpaid 主键
	 */
	public void setTpaid(Integer tpaid) {
		this.tpaid = tpaid;
	}

	/**
	 * 培训人姓名取得
	 *
	 * @return 培训人姓名
	 */
	public String getTpaname() {
		return tpaname;
	}

	/**
	 * 培训人姓名设定
	 *
	 * @param tpaname 培训人姓名
	 */
	public void setTpaname(String tpaname) {
		this.tpaname = tpaname;
	}

	/**
	 * 培训人联系电话取得
	 *
	 * @return 培训人联系电话
	 */
	public String getTpatel() {
		return tpatel;
	}

	/**
	 * 培训人联系电话设定
	 *
	 * @param tpatel 培训人联系电话
	 */
	public void setTpatel(String tpatel) {
		this.tpatel = tpatel;
	}

	/**
	 * 培训记录id取得
	 *
	 * @return 培训记录id
	 */
	public Integer getTrid() {
		return trid;
	}

	/**
	 * 培训记录id设定
	 *
	 * @param trid 培训记录id
	 */
	public void setTrid(Integer trid) {
		this.trid = trid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return tpaid;
	}

}