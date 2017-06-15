package com.deliverik.infogovernor.scheduling.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;

/**
 * 流程与资产关系信息
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="QuartzProcessInfoEntity")
public class QuartzProcessInfoEntityTB extends BaseEntity implements Serializable, Cloneable, QuartzProcessInfoEntity {

	/** 自增无意义主键 */
	@Id
	@TableGenerator(
		    name="QUARTZPROCESSINFOENTITY_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="QUARTZPROCESSINFOENTITY_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="QUARTZPROCESSINFOENTITY_TABLE_GENERATOR")
	protected Integer qpieid;

	/** 流程ID(QuartzProcessRecord表) */
	protected Integer qprid;

	/** 动态表单ID（QuartzProcessInfo表）*/
	protected Integer qpiid;

	/** 资产ID(EntityItem表) */
	protected Integer qeiid;

	/** 资产信息 */
	@OneToOne
	@JoinColumn(name="qeiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG013TB entityItemTB;
	
	/** 资产信息 */
	@OneToOne
	@JoinColumn(name="qeiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0118TB soc0118TB;
	
	/**
	 * 主键取得
	 * @return qpieid
	 */
	public Serializable getPK() {
		return qpieid;
	}

	/**
	 *自增无意义主键取得
	 * @return 自增无意义主键
	 */
	public Integer getQpieid(){
		return qpieid;
	}
	
	/**
	 *自增无意义主键设定
	 * @param pieid自增无意义主键
	 */
	public void setQpieid(Integer qpieid){
		this.qpieid=qpieid;
	}
	
	/**
	 *流程ID(QuartzProcessRecord表)取得
	 * @return 流程ID(QuartzProcessRecord表)
	 */
	public Integer getQprid(){
		return qprid;
	}

	/**
	 *流程ID(QuartzProcessRecord表)设定
	 * @param prid流程ID(QuartzProcessRecord表)
 	 */
	public void setQprid(Integer qprid){
		this.qprid=qprid;
	}
	
	/**
	 *动态表单ID（QuartzProcessInfo表）取得
	 * @return 动态表单ID（QuartzProcessInfo表）
	 */
	public Integer getQpiid(){
		return qpiid;
	}
	
	/**
	 *动态表单ID（QuartzProcessInfo表）设定
	 * @param pidid动态表单ID（QuartzProcessInfo表）
	 */
	public void setQpiid(Integer qpiid){
		this.qpiid=qpiid;
	}
	
	/**
	 *资产ID(EntityItem表)取得
	 * @return 资产ID(EntityItem表)
	 */
	public Integer getQeiid(){
		return qeiid;
	}
	
	/**
	 *资产ID(EntityItem表)设定
	 * @param eiid资产ID(EntityItem表)
	 */
	public void setQeiid(Integer qeiid){
		this.qeiid=qeiid;
	}

	/**
	 * 资产信息取得
	 * @return 资产信息
	 */
	public IG013TB getEntityItemTB() {
		return entityItemTB;
	}

	/**
	 * 资产信息设定
	 * @param entityItemTB 资产信息
	 */
	public void setEntityItemTB(IG013TB entityItemTB) {
		this.entityItemTB = entityItemTB;
	}

	public SOC0118TB getSoc0118TB() {
		return soc0118TB;
	}

	public void setSoc0118TB(SOC0118TB soc0118TB) {
		this.soc0118TB = soc0118TB;
	}


}
