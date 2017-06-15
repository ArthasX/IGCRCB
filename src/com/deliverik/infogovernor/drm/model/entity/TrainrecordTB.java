/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.infogovernor.drm.model.TrainrecordInfo;

/**
  * 概述: 培训记录实体
  * 功能描述: 培训记录实体
  * 创建记录: 2015/04/13
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="trainrecord")
public class TrainrecordTB implements Serializable,
		Cloneable, TrainrecordInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="TRAINRECORD_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="TRAINRECORD_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TRAINRECORD_TABLE_GENERATOR")
	protected Integer trid;

	/** 培训名称 */
	protected String trname;

	/** 培训计划id */
	protected Integer tpid;

	/** 培训计划名称 */
	protected String tpname;

	/** 培训内容 */
	protected String tpcontent;

	/** 培训开始时间 */
	protected String trstime;

	/** 培训结束时间 */
	protected String tretime;

	/** 培训地点 */
	protected String trside;

	/** 讲师 */
	protected String trlecturer;

	/** 附件 */
	protected String tratt;
	
	/**
	 * 附件
	 */
	@OneToMany(targetEntity=AttachmentTB.class)
	@JoinColumn(name="attkey", referencedColumnName="tratt")
	@Basic(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	protected List<AttachmentTB> attachmentList;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getTrid() {
		return trid;
	}

	/**
	 * 主键设定
	 *
	 * @param trid 主键
	 */
	public void setTrid(Integer trid) {
		this.trid = trid;
	}

	/**
	 * 培训名称取得
	 *
	 * @return 培训名称
	 */
	public String getTrname() {
		return trname;
	}

	/**
	 * 培训名称设定
	 *
	 * @param trname 培训名称
	 */
	public void setTrname(String trname) {
		this.trname = trname;
	}

	/**
	 * 培训计划id取得
	 *
	 * @return 培训计划id
	 */
	public Integer getTpid() {
		return tpid;
	}

	/**
	 * 培训计划id设定
	 *
	 * @param tpid 培训计划id
	 */
	public void setTpid(Integer tpid) {
		this.tpid = tpid;
	}

	/**
	 * 培训计划名称取得
	 *
	 * @return 培训计划名称
	 */
	public String getTpname() {
		return tpname;
	}

	/**
	 * 培训计划名称设定
	 *
	 * @param tpname 培训计划名称
	 */
	public void setTpname(String tpname) {
		this.tpname = tpname;
	}

	/**
	 * 培训内容取得
	 *
	 * @return 培训内容
	 */
	public String getTpcontent() {
		return tpcontent;
	}

	/**
	 * 培训内容设定
	 *
	 * @param tpcontent 培训内容
	 */
	public void setTpcontent(String tpcontent) {
		this.tpcontent = tpcontent;
	}

	/**
	 * 培训开始时间取得
	 *
	 * @return 培训开始时间
	 */
	public String getTrstime() {
		return trstime;
	}

	/**
	 * 培训开始时间设定
	 *
	 * @param trstime 培训开始时间
	 */
	public void setTrstime(String trstime) {
		this.trstime = trstime;
	}

	/**
	 * 培训结束时间取得
	 *
	 * @return 培训结束时间
	 */
	public String getTretime() {
		return tretime;
	}

	/**
	 * 培训结束时间设定
	 *
	 * @param tretime 培训结束时间
	 */
	public void setTretime(String tretime) {
		this.tretime = tretime;
	}

	/**
	 * 培训地点取得
	 *
	 * @return 培训地点
	 */
	public String getTrside() {
		return trside;
	}

	/**
	 * 培训地点设定
	 *
	 * @param trside 培训地点
	 */
	public void setTrside(String trside) {
		this.trside = trside;
	}

	/**
	 * 讲师取得
	 *
	 * @return 讲师
	 */
	public String getTrlecturer() {
		return trlecturer;
	}

	/**
	 * 讲师设定
	 *
	 * @param trlecturer 讲师
	 */
	public void setTrlecturer(String trlecturer) {
		this.trlecturer = trlecturer;
	}

	/**
	 * 附件取得
	 *
	 * @return 附件
	 */
	public String getTratt() {
		return tratt;
	}

	/**
	 * 附件设定
	 *
	 * @param tratt 附件
	 */
	public void setTratt(String tratt) {
		this.tratt = tratt;
	}

	/**  
	 * 获取附件  
	 * @return attachmentList 附件  
	 */
	public List<AttachmentTB> getAttachmentList() {
		return attachmentList;
	}

	/**  
	 * 设置附件  
	 * @param attachmentList 附件  
	 */
	public void setAttachmentList(List<AttachmentTB> attachmentList) {
		this.attachmentList = attachmentList;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return trid;
	}
}