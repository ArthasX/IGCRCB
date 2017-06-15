/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;

/**
 * 流程关系实体接口
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG512")
public class IG512TB extends BaseEntity implements Serializable, Cloneable, IG512Info {

	/** 流程关系ID */
	@Id
	@TableGenerator(
		    name="IG512_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG512_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG512_TABLE_GENERATOR")
	protected Integer prrid;
	
	/** 主动流程ID */
	protected Integer parprid;

	/** 被动流程ID */
	protected Integer cldprid;
	
	/** 关系建立时间 */
	protected String prrinstime;
	
	/** 主动流程信息 */
	@ManyToOne
	@JoinColumn(name="parprid", referencedColumnName="prid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG500TB parProcess;
	
	/** 被动流程信息 */
	@ManyToOne
	@JoinColumn(name="cldprid", referencedColumnName="prid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG500TB cldProcess;
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return prrid;
	}

	/**
	 * 流程关系ID取得
	 * 
	 * @return 流程关系ID
	 */
	public Integer getPrrid() {
		return prrid;
	}

	/**
	 * 流程关系ID取得
	 * 
	 * @param prrid 流程关系ID
	 */
	public void setPrrid(Integer prrid) {
		this.prrid = prrid;
	}

	/**
	 * 主动流程ID取得
	 * 
	 * @return 主动流程ID
	 */
	public Integer getParprid() {
		return parprid;
	}

	/**
	 * 主动流程ID取得
	 * 
	 * @param parprid 主动流程ID
	 */
	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	/**
	 * 被动流程ID取得
	 * 
	 * @return 被动流程ID
	 */
	public Integer getCldprid() {
		return cldprid;
	}

	/**
	 * 被动流程ID取得
	 * 
	 * @param cldprid 被动流程ID
	 */
	public void setCldprid(Integer cldprid) {
		this.cldprid = cldprid;
	}

	/**
	 * 关系建立时间取得
	 * 
	 * @return 关系建立时间
	 */
	public String getPrrinstime() {
		return prrinstime;
	}

	/**
	 * 关系建立时间取得
	 * 
	 * @param prrinstime 关系建立时间
	 */
	public void setPrrinstime(String prrinstime) {
		this.prrinstime = prrinstime;
	}

	/**
	 * 主动流程信息取得
	 * 
	 * @param parProcess 主动流程信息
	 */
	public IG500Info getParProcess() {
		return parProcess;
	}

	/**
	 * 主动流程信息取得
	 * 
	 * @param cldProcess 主动流程信息
	 */
	public IG500Info getCldProcess() {
		return cldProcess;
	}
	
}
