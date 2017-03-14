package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG599Info;

/**
 * 流程变量信息实体
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG599")
public class IG599TB extends BaseEntity implements Serializable, Cloneable, IG599Info {

	/**
	 * 流程类型定义ID
	 */
	@Id
	@TableGenerator(
		    name="IG599_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG599_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG599_TABLE_GENERATOR")
	protected Integer piid;
	
	/**
	 * 流程记录ID
	 */
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
	
	/** 流程变量模式 */
	public String pidmode;
	
	/** 私有变量权限范围 */
	protected String privatescope;
	
	/** 备注 */
	protected String pidcomment;
	
	/**
	 * 参与者具有的流程变量权限
	 */
	@Transient
	protected String pidaccess;

	/**
	 * 主键取得
	 * @return piid
	 */
	public Serializable getPK() {
		return piid;
	}


	public boolean equals(Object obj) {
		if (!(obj instanceof IG599TB))
			return false;
		IG599Info target = (IG599Info) obj;
		if (!(getPiid()==target.getPiid()))
			return false;

		return true;
	}

	/**
	 * 流程类型定义ID取得
	 * @return 流程类型定义ID
	 */
	public Integer getPiid() {
		return piid;
	}

	/**
	 * 流程类型定义ID设定
	 * @param piid 流程类型定义ID
	 */
	public void setPiid(Integer piid) {
		this.piid = piid;
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
	 * 流程变量模式取得
	 * @return 流程变量模式
	 */
	public String getPidmode() {
		return pidmode;
	}

	/**
	 * 流程变量模式设定
	 * @param pidmode 流程变量模式
	 */
	public void setPidmode(String pidmode) {
		this.pidmode = pidmode;
	}
	
	/**
	 * 私有变量权限范围设定
	 * 
	 * @return 私有变量权限范围
	 */
	public String getPrivatescope() {
		return privatescope;
	}

	/**
	 * 私有变量权限范围取得
	 * 
	 * @param privatescope 私有变量权限范围
	 */
	public void setPrivatescope(String privatescope) {
		this.privatescope = privatescope;
	}
	
	/**
	 * 参与者具有的流程变量权限取得
	 * @return 参与者具有的流程变量权限
	 */
	public String getPidaccess() {
		return pidaccess;
	}

	public List<IG899TB> getProcessPrivateInfoList() {
		return processPrivateInfoList;
	}

	
	/**
	 *备注取得
	 */
	public String getPidcomment() {
		return pidcomment;
	}


	/**
	 *备注设置
	 */
	public void setPidcomment(String pidcomment) {
		this.pidcomment = pidcomment;
	}


	/**
	 * 流参与者具有的流程变量权限设定
	 * @param pidaccess 参与者具有的流程变量权限
	 */
	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}
	
	@OneToMany(mappedBy = "processInfoDef",fetch = FetchType.EAGER)
	@JoinColumn(name = "piid",updatable=false, insertable= false)
	@NotFound(action = NotFoundAction.IGNORE)
	protected List<IG899TB> processPrivateInfoList;
	public List<IG899TB> getProcessPrivateInfofList() {
		return processPrivateInfoList;
	}

	public void setProcessPrivateInfoList(
			List<IG899TB> processPrivateInfoList) {
		this.processPrivateInfoList = processPrivateInfoList;
	}
}
