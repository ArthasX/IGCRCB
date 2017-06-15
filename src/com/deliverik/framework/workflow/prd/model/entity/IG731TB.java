package com.deliverik.framework.workflow.prd.model.entity;

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
import com.deliverik.framework.asset.model.entity.IG688VW;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG731Info;

/**
 * 流程与资产关系信息
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG731")
public class IG731TB extends BaseEntity implements Serializable, Cloneable, IG731Info {

	/** 自增无意义主键 */
	@Id
	@TableGenerator(
		    name="IG731_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG731_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG731_TABLE_GENERATOR")
	protected Integer pieid;

	/** 流程ID(Ig500表) */
	protected Integer prid;

	/** 动态表单ID（Ig599表）*/
	protected Integer piid;

	/** 资产ID(EntityItem表) */
	protected Integer eiid;
	
	/** 资产版本号 */
	protected Integer eiversion;

	/** 资产信息 */
	@OneToOne
	@JoinColumn(name="eiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG013TB entityItemTB;
	
	/** 资产信息视图 */
	@OneToOne
	@JoinColumn(name="eiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG688VW entityItemVWTB;
	
	/**
	 * 资产信息视图取得
	 *
	 * @return entityItemVWTB 资产信息视图
	 */
	public IG688VW getEntityItemVWTB() {
		return entityItemVWTB;
	}

	/**
	 * 资产信息视图设定
	 *
	 * @param entityItemVWTB 资产信息视图
	 */
	public void setEntityItemVWTB(IG688VW entityItemVWTB) {
		this.entityItemVWTB = entityItemVWTB;
	}

	/**
	 * 主键取得
	 * @return pieid
	 */
	public Serializable getPK() {
		return pieid;
	}

	/**
	 *自增无意义主键取得
	 * @return 自增无意义主键
	 */
	public Integer getPieid(){
		return pieid;
	}
	
	/**
	 *自增无意义主键设定
	 * @param pieid自增无意义主键
	 */
	public void setPieid(Integer pieid){
		this.pieid=pieid;
	}
	
	/**
	 *流程ID(Ig500表)取得
	 * @return 流程ID(Ig500表)
	 */
	public Integer getPrid(){
		return prid;
	}

	/**
	 *流程ID(Ig500表)设定
	 * @param prid流程ID(Ig500表)
 	 */
	public void setPrid(Integer prid){
		this.prid=prid;
	}
	
	/**
	 *动态表单ID（Ig599表）取得
	 * @return 动态表单ID（Ig599表）
	 */
	public Integer getPiid(){
		return piid;
	}
	
	/**
	 *动态表单ID（Ig599表）设定
	 * @param pidid动态表单ID（Ig599表）
	 */
	public void setPiid(Integer piid){
		this.piid=piid;
	}
	
	/**
	 *资产ID(EntityItem表)取得
	 * @return 资产ID(EntityItem表)
	 */
	public Integer getEiid(){
		return eiid;
	}
	
	/**
	 *资产ID(EntityItem表)设定
	 * @param eiid资产ID(EntityItem表)
	 */
	public void setEiid(Integer eiid){
		this.eiid=eiid;
	}
	
	/**
	 * 资产版本号取得
	 * @return eiversion 资产版本号
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 资产版本号设定
	 * @param eiversion 资产版本号
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
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

}
