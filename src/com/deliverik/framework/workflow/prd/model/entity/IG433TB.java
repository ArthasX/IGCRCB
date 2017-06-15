/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

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

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.workflow.prd.model.IG433Info;

/**
 * 概述:流程评审实体TB类 功能描述：针对流程评审实体
 * 
 * 创建记录：宋海洋 2010/11/26
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "IG433")
public class IG433TB extends BaseEntity implements Serializable,
		Cloneable, IG433Info {
	@Id
	@TableGenerator(name = "IG433_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", 
					pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", 
					pkColumnValue = "IG433_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "IG433_TABLE_GENERATOR")
	/*
	 * *主键
	 */
	protected Integer paid;

	/**
	 *主键取得
	 * 
	 * @return 主键
	 */
	public Integer getPaid() {
		return paid;
	}

	/**
	 *主键设定
	 * 
	 * @param paid主键
	 */
	public void setPaid(Integer paid) {
		this.paid = paid;
	}

	/**
	 *流程ID
	 */
	protected Integer paprid;

	/**
	 *流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPaprid() {
		return paprid;
	}

	/**
	 *流程ID设定
	 * 
	 * @param paprid流程ID
	 */
	public void setPaprid(Integer paprid) {
		this.paprid = paprid;
	}

	/**
	 *流程名
	 */
	protected String paprname;

	/**
	 *流程名取得
	 * 
	 * @return 流程名
	 */
	public String getPaprname() {
		return paprname;
	}

	/**
	 *流程名设定
	 * 
	 * @param paprname流程名
	 */
	public void setPaprname(String paprname) {
		this.paprname = paprname;
	}

	/**
	 *评审人id
	 */
	protected String pauserid;

	/**
	 *评审人id取得
	 * 
	 * @return 评审人id
	 */
	public String getPauserid() {
		return pauserid;
	}

	/**
	 *评审人id设定
	 * 
	 * @param pauserid评审人id
	 */
	public void setPauserid(String pauserid) {
		this.pauserid = pauserid;
	}

	/**
	 *评审说明1
	 */
	protected String paassessmentdes;

	/**
	 *评审说明1取得
	 * 
	 * @return 评审说明1
	 */
	public String getPaassessmentdes() {
		return paassessmentdes;
	}

	/**
	 *评审说明1设定
	 * 
	 * @param paassessmentdes评审说明1
	 */
	public void setPaassessmentdes(String paassessmentdes) {
		this.paassessmentdes = paassessmentdes;
	}

	/**
	 *评审时间
	 */
	protected String paassessmentdate;

	/**
	 *评审时间取得
	 * 
	 * @return 评审时间
	 */
	public String getPaassessmentdate() {
		return paassessmentdate;
	}

	/**
	 *评审时间设定
	 * 
	 * @param paassessmentdate评审时间
	 */
	public void setPaassessmentdate(String paassessmentdate) {
		this.paassessmentdate = paassessmentdate;
	}
	
	/**
	 * 事件类别code
	 */
	protected String paeventtypecode;
	
	/**
	 *事件类别code取得
	 * 
	 * @return 事件类别code
	 */
	public String getPaeventtypecode() {
		return paeventtypecode;
	}

	/**
	 *事件类别code设定
	 * 
	 * @param paeventtypecode事件类别code
	 */
	public void setPaeventtypecode(String paeventtypecode) {
		this.paeventtypecode = paeventtypecode;
	}

	/**
	 * 事件附件key
	 */
	protected String paattkey;
	
	/**
	 * 事件附件Key取得
	 * @return 事件附件Key
	 */
	public String getPaattkey() {
		return paattkey;
	}

	/**
	 * 事件附件Key设定
	 * @param paattkey 事件附件Key
	 */
	public void setPaattkey(String paattkey) {
		this.paattkey = paattkey;
	}

	@OneToMany(targetEntity=AttachmentTB.class)
	@JoinColumn(name="attkey", referencedColumnName="paattkey", updatable=false, insertable= false)
	@Basic(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	protected List<AttachmentTB> attachmentList;
	
	public List<AttachmentTB> getAttachmentList() {
		return attachmentList;
	}

	/**
	 * 评审状态
	 */
	protected String pastatus;
	
	/**
	 * 评审状态取得
	 * @return 评审状态
	 */
	public String getPastatus() {
		return pastatus;
	}

	/**
	 * 评审状态设定
	 * @param pastatus 评审状态
	 */
	public void setPastatus(String pastatus) {
		this.pastatus = pastatus;
	}

	public Serializable getPK() {
		return paid;
	}
}
