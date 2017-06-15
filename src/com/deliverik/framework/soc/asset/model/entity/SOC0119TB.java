package com.deliverik.framework.soc.asset.model.entity;

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
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0123Info;

/**
 * <p>
 * 资产关系信息实体
 * </p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="SOC0119")
public class SOC0119TB extends BaseEntity implements Serializable, Cloneable, SOC0119Info, LogicalDelete {

	/** 资产关系信息ID */
	@Id
	@TableGenerator(
			name="SOC0119_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
			pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
			pkColumnValue="SOC0119_SEQUENCE", initialValue=1, allocationSize=1
		)
		@GeneratedValue(strategy = GenerationType.TABLE, generator="SOC0119_TABLE_GENERATOR")
	protected Integer eirid;
	
	/** 资产ID（正向，外键） */
	protected Integer pareiid;

	/** 资产模型ID（正向） */
	protected String pareid;

	/** 资产ID（反向，外键） */
	protected Integer cldeiid;

	/** 资产模型ID（反向） */
	protected String cldeid;

	/** 资产关系信息更新时间 */
	protected String eirupdtime;
	
	/** 资产关系是否可以删除标识（"C"标识不能删除） */
	protected String eirstatus;
	
	/** 资产关系说明 */
	protected String eirdesc;
	
	/** 资产关系ID */
	protected String eirrelation;
	
	/** 资产关系编码 */
	protected String eirrelationcode;
	
	/** 资产关系方向（0正向，1反向）*/
	@Transient
	protected String parflag;
	
	/**
	 * 通过资产属性增加自动生成的关系信息
	 * @return 通过资产属性增加自动生成的关系信息
	 */
	protected String eirinfo;
	
	
	/** 资产（正向）信息 */
	@ManyToOne
	@JoinColumn(name="pareiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0123VW parEntityItemVW;

	/** 资产（反向）信息 */
	@ManyToOne
	@JoinColumn(name="cldeiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0123VW cldEntityItemVW;
	
	/** 正向资产大版本 */
	protected Integer parversion;
	
	/** 正向资产小版本 */
	protected Integer parsmallversion;
	
	/** 反向资产大版本 */
	protected Integer cldversion;
	
	/** 反向资产小版本 */
	protected Integer cldsmallversion;
	
	/** 逻辑删除标识 */
	protected String deleteflag;

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return eirid;
	}

	/**
	 * 资产关系信息ID取得
	 * @return 资产关系信息ID
	 */
	public Integer getEirid() {
		return eirid;
	}

	/**
	 * 资产关系信息ID设定
	 *
	 * @param eirid 资产关系信息ID
	 */
	public void setEirid(Integer eirid) {
		this.eirid = eirid;
	}


	/**
	 * 资产ID（正向）取得
	 * @return 资产ID（正向）
	 */
	public Integer getPareiid() {
		return pareiid;
	}


	/**
	 * 资产ID（正向）设定
	 *
	 * @param pareiid 资产ID（正向）
	 */
	public void setPareiid(Integer pareiid) {
		this.pareiid = pareiid;
	}

	/**
	 * 资产模型ID（正向）取得
	 * @return 资产模型ID（正向）
	 */
	public String getPareid() {
		return pareid;
	}


	/**
	 * 资产模型ID（正向）设定
	 *
	 * @param pareid 资产模型ID（正向）
	 */
	public void setPareid(String pareid) {
		this.pareid = pareid;
	}


	/**
	 * 资产ID（反向）取得
	 * @return 资产ID（反向）
	 */
	public Integer getCldeiid() {
		return cldeiid;
	}


	/**
	 * 资产ID（反向）设定
	 *
	 * @param cldeiid 资产ID（反向）
	 */
	public void setCldeiid(Integer cldeiid) {
		this.cldeiid = cldeiid;
	}


	/**
	 * 资产模型ID（反向）取得
	 * @return 资产模型ID（反向）
	 */
	public String getCldeid() {
		return cldeid;
	}


	/**
	 * 资产模型ID（反向）设定
	 *
	 * @param cldeid 资产模型ID（反向）
	 */
	public void setCldeid(String cldeid) {
		this.cldeid = cldeid;
	}


	/**
	 * 资产关系信息更新时间取得
	 * @return 资产关系信息更新时间
	 */
	public String getEirupdtime() {
		return eirupdtime;
	}


	/**
	 * 资产关系信息更新时间设定
	 *
	 * @param eirupdtime 资产关系信息更新时间
	 */
	public void setEirupdtime(String eirupdtime) {
		this.eirupdtime = eirupdtime;
	}


	/**
	 * 资产关系信息是否可以删除标识取得
	 * @return 资产关系信息是否可以删除标识
	 */
	public String getEirstatus() {
		return eirstatus;
	}


	/**
	 * 资产关系信息是否可以删除标识设定
	 *
	 * @param eirstatus 资产关系信息是否可以删除标识
	 */
	public void setEirstatus(String eirstatus) {
		this.eirstatus = eirstatus;
	}



	/**
	 * 资产关系ID取得
	 * @return 资产关系ID状态
	 */
	public String getEirrelation() {
		return eirrelation;
	}


	/**
	 * 资产关系ID 
	 *
	 * @param eirrelation 资产关系ID
	 */
	public void setEirrelation(String eirrelation) {
		this.eirrelation = eirrelation;
	}


	/**
	 * 资产关系说明取得
	 * @return 资产关系说明
	 */
	public String getEirdesc() {
		return eirdesc;
	}


	/**
	 * 资产关系说明设定
	 *
	 * @param eirdesc 资产关系说明
	 */
	public void setEirdesc(String eirdesc) {
		this.eirdesc = eirdesc;
	}

	/**
	 * 资产(正向)信息取得
	 * @return 资产(正向)信息
	 */
	public SOC0123Info getParEntityItemVW() {
	    return parEntityItemVW;
	}
	
	/**
	 * 资产(反向)信息取得
	 * @return 资产(反向)信息
	 */
	public SOC0123Info getCldEntityItemVW() {
	    return cldEntityItemVW;
	}


	/**
	 * 资产关系编码取得
	 * @return 资产关系编码
	 */
	public String getEirrelationcode() {
		return eirrelationcode;
	}

	/**
	 * 资产关系编码设定
	 *
	 * @param eirrelationcode 资产关系编码
	 */
	public void setEirrelationcode(String eirrelationcode) {
		this.eirrelationcode = eirrelationcode;
	}


	/**
	 * 资产关系方向取得
	 * @return 资产关系方向
	 */
	public String getParflag() {
		return parflag;
	}

	/**
	 * 资产关系方向设定
	 *
	 * @param parflag 资产关系方向
	 */
	public void setParflag(String parflag) {
		this.parflag = parflag;
	}
	
	/**
	 * 通过资产属性增加自动生成的关系信息取得
	 * @return 通过资产属性增加自动生成的关系信息
	 */
	public String getEirinfo() {
		return eirinfo;
	}

	/**
	 * 通过资产属性增加自动生成的关系信息设定
	 *
	 * @param eirinfo 通过资产属性增加自动生成的关系信息
	 */
	public void setEirinfo(String eirinfo) {
		this.eirinfo = eirinfo;
	}

	/**
	 * 正向资产大版本取得
	 * @return 正向资产大版本
	 */
	public Integer getParversion() {
		return parversion;
	}

	/**
	 * 正向资产大版本设定
	 *
	 * @param parversion 正向资产大版本
	 */
	public void setParversion(Integer parversion) {
		this.parversion = parversion;
	}
	
	/**
	 * 正向资产小版本取得
	 * @return 正向资产小版本
	 */
	public Integer getParsmallversion() {
		return parsmallversion;
	}

	/**
	 * 正向资产小版本设定
	 *
	 * @param parsmallversion 正向资产小版本
	 */
	public void setParsmallversion(Integer parsmallversion) {
		this.parsmallversion = parsmallversion;
	}
	
	/**
	 * 反向资产大版本取得
	 * @return 反向资产大版本
	 */
	public Integer getCldversion() {
		return cldversion;
	}

	/**
	 * 反向资产大版本设定
	 *
	 * @param cldversion 反向资产大版本
	 */
	public void setCldversion(Integer cldversion) {
		this.cldversion = cldversion;
	}

	/**
	 * 反向资产小版本取得
	 * @return 反向资产小版本
	 */
	public Integer getCldsmallversion() {
		return cldsmallversion;
	}

	/**
	 * 反向资产小版本设定
	 *
	 * @param cldsmallversion 反向资产小版本
	 */
	public void setCldsmallversion(Integer cldsmallversion) {
		this.cldsmallversion = cldsmallversion;
	}

	/**
	 * 逻辑删除标识取得
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * 逻辑删除标识（反向）设定
	 *
	 * @param deleteflag 逻辑删除标识（反向）
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	
}
