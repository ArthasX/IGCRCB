/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG933TB;
import com.deliverik.infogovernor.kgm.model.KnowledgeProcess;

/**
 * 概述: 知识流程关联信息实体
 * 功能描述：知识流程关联信息实体
 * 创建记录：刘鹏 2010/12/07
 * 修改记录：
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "KnowledgeProcess")
public class KnowledgeProcessTB extends BaseEntity implements Serializable,
		Cloneable, KnowledgeProcess {
	@Id
	@TableGenerator(name = "KNOWLEDGEPROCESS_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", 
					pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", 
					pkColumnValue = "KNOWLEDGEPROCESS_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "KNOWLEDGEPROCESS_TABLE_GENERATOR")
	/* * 主键 */
	protected Integer kpid;

	/** 知识ID */
	protected Integer knid;

	/** 流程ID */
	protected Integer prid;
	
	/** 工单ID */
	protected Integer sfid;

	/** 关联类型：0-流程关联知识，1-知识关联流程*/
	protected String connecttype;
	
	/** 是否有效标识：0-无效，1-有效*/
	protected String kpEffect;
	
	/** 知识版本*/
	protected Integer knversion;
	
	/** 知识信息 */
	@ManyToOne
	//@JoinColumns
	  @JoinColumns({
		  @JoinColumn(name="knid", referencedColumnName="knid" ,updatable=false, insertable= false),
		  @JoinColumn(name="knversion", referencedColumnName="knversion",updatable=false, insertable= false)
		      })
    @Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected KnowledgeTB knowledge;
	
	/** 流程信息 */
	@ManyToOne
	@JoinColumn(name="prid", referencedColumnName="prid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG500TB processRecord;

	/** 流程信息 */
	@ManyToOne
	@JoinColumn(name="sfid", referencedColumnName="sfid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG933TB serviceForm;
	
	
	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public Integer getKpid() {
		return kpid;
	}

	/**
	 * 主键设定
	 * 
	 * @param kpid主键
	 */
	public void setKpid(Integer kpid) {
		this.kpid = kpid;
	}

	/**
	 * 知识ID取得
	 * 
	 * @return 知识ID
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 * 知识ID设定
	 * 
	 * @param knid知识ID
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	/**
	 * 流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 * 
	 * @param prid流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * 工单ID取得
	 * 
	 * @return 工单ID
	 */
	public Integer getSfid() {
		return sfid;
	}

	/**
	 * 工单ID设定
	 * 
	 * @param sfid工单ID
	 */
	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}

	/**
	 * 关联类型取得
	 * 
	 * @return 关联类型
	 */
	public String getConnecttype() {
		return connecttype;
	}

	/**
	 * 关联类型设定
	 * 
	 * @param connecttype关联类型
	 */
	public void setConnecttype(String connecttype) {
		this.connecttype = connecttype;
	}
	
	/**
	 * 是否有效标识取得
	 * 
	 * @return 是否有效标识
	 */
	public String getKpEffect() {
		return kpEffect;
	}

	/**
	 * 是否有效标识设定
	 * 
	 * @param kpEffect是否有效标识
	 */
	public void setKpEffect(String kpEffect) {
		this.kpEffect = kpEffect;
	}

	/**
	 * 知识信息取得
	 * @return 知识信息
	 */
	public KnowledgeTB getKnowledge() {
		return knowledge;
	}

	/**
	 * 流程信息取得
	 * @return 流程信息
	 */
	public IG500TB getProcessRecord() {
		return processRecord;
	}

	/**
	 * 服务工单取得
	 * @return 服务工单
	 */
	public IG933TB getServiceForm() {
		return serviceForm;
	}


	/**
	 * 知识版本取得
	 * @return 知识版本
	 */
	public Integer getKnversion() {
		return knversion;
	}

	/**
	 * 知识版本设定
	 * @param knversion 知识版本
	 */
	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}
	
	
	
	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public Serializable getPK() {
		return kpid;
	}

}
