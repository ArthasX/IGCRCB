package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG113Info;


/**
 * <p>
 * 表单日志信息实体
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG113")
public class IG113TB extends BaseEntity implements Serializable, Cloneable, IG113Info {

	/** 主键ID */
	@Id
	@TableGenerator(
		    name="IG113_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG113_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG113_TABLE_GENERATOR")
	protected Integer rlvid;
	
	/** 变量ID */
	protected Integer piid;
	
	/** 日志ID */
	protected Integer rlid;
	
	/** 流程记录ID */
	protected Integer prid;
	
	
	/**
	 * 流程变量标识
	 */
	protected String pivarname;
	
	/**
	 * 流程变量名称
	 */
	protected String pivarlabel;
	
	/**
	 * 流程变量类型
	 */
	protected String pivartype;
	
	/**
	 * 流程变量值
	 */
	protected String pivarvalue;
	
	/**
	 * 流程附件KEY
	 */
	protected String piattkey;
	
	/**
	 * 流程自定义前处理标识
	 */
	protected String pidid;
	
	
	/**
	 * 流程对象类型变量显示名称
	 */
	protected String pishowvarname;
	
	/** 显示内容 */
	@Transient
	protected String showValue;
	
	
	/** 流程日志实体 */
	@ManyToOne
	@JoinColumn(name = "rlid", referencedColumnName="rlid", insertable=false, updatable=false)
	@Basic(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG036TB recordLog;

	
	
	/**
	 * 流程对象类型变量显示名称取得
	 * @return 流程对象类型变量显示名称
	 */
	public String getPishowvarname() {
		return pishowvarname;
	}



	/**
	 * 流程对象类型变量显示名称设定
	 * @param pishowvarname 流程对象类型变量显示名称
	 */
	public void setPishowvarname(String pishowvarname) {
		this.pishowvarname = pishowvarname;
	}




	/**
	 * 主键取得
	 * @return rlvid
	 */
	public Serializable getPK() {
		return rlvid;
	}
	
	
	/**
	 * 主键ID取得
	 * @return 主键ID
	 */
	public Integer getRlvid() {
		return rlvid;
	}

	/**
	 * 主键ID设定
	 * @param rlvid 主键ID
	 */
	public void setRlvid(Integer rlvid) {
		this.rlvid = rlvid;
	}

	/**
	 * 变量ID取得
	 * @return 变量ID
	 */
	public Integer getPiid() {
		return piid;
	}

	/**
	 * 变量ID设定
	 * @param piid 变量ID
	 */
	public void setPiid(Integer piid) {
		this.piid = piid;
	}

	

	/**
	 * 日志ID取得
	 * @return 日志ID
	 */
	public Integer getRlid() {
		return rlid;
	}

	/**
	 * 日志ID设定
	 * @param rlid 日志ID
	 */
	public void setRlid(Integer rlid) {
		this.rlid = rlid;
	}

	/**
	 * 流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程记录ID设定
	 * @param prid 流程记录ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	
	/**
	 * 流程变量标识取得
	 * @return 流程变量标识
	 */
	public String getPivarname() {
		return pivarname;
	}

	/**
	 * 流程变量标识设定
	 * @param pivarname 流程变量标识
	 */
	public void setPivarname(String pivarname) {
		this.pivarname = pivarname;
	}

	/**
	 * 流程变量类型取得
	 * @return 流程变量类型
	 */
	public String getPivartype() {
		return pivartype;
	}

	/**
	 * 流程变量类型设定
	 * @param pivartype 流程变量类型
	 */
	public void setPivartype(String pivartype) {
		this.pivartype = pivartype;
	}

	/**
	 * 流程变量值取得
	 * @return 流程变量值
	 */
	public String getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * 流程变量值设定
	 * @param pivarvalue 流程变量值
	 */
	public void setPivarvalue(String pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * 流程附件KEY取得
	 * @return 流程附件KEY
	 */
	public String getPiattkey() {
		return piattkey;
	}

	/**
	 * 流程附件KEY设定
	 * @param piattkey 流程附件KEY
	 */
	public void setPiattkey(String piattkey) {
		this.piattkey = piattkey;
	}

	/**
	 * 流程变量名称取得
	 * @return 流程变量名称
	 */
	public String getPivarlabel() {
		return pivarlabel;
	}

	/**
	 * 流程变量名称设定
	 * @param pivarlabel 流程变量名称
	 */
	public void setPivarlabel(String pivarlabel) {
		this.pivarlabel = pivarlabel;
	}

	/**
	 * 流程自定义前处理标识取得
	 * @return 流程自定义前处理标识
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 流程自定义前处理标识设定
	 * @param pidid 流程自定义前处理标识
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 流程日志实体取得
	 * @return recordLog 流程日志实体
	 */
	public IG036TB getRecordLog() {
		return recordLog;
	}

	/**
	 * 流程日志实体设定
	 * @param recordLog 流程日志实体
	 */
	public void setRecordLog(IG036TB recordLog) {
		this.recordLog = recordLog;
	}

	/**
	 * 显示内容取得
	 * @return showValue 显示内容
	 */
	public String getShowValue() {
		if(StringUtils.isNotEmpty(pishowvarname)){
			this.showValue = this.pishowvarname;
		}else if(StringUtils.isNotEmpty(pivarvalue)){
			this.showValue = this.pivarvalue;
		}
		return showValue;
	}

	/**
	 * 显示内容设定
	 * @param showValue 显示内容
	 */
	public void setShowValue(String showValue) {
		this.showValue = showValue;
	}

}
