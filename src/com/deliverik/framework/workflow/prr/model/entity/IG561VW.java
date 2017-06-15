/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;

/**
  * 概述: 状态级私有表单值记录表实体
  * 功能描述: 状态级私有表单值记录表实体
  * 创建记录: 2015/02/07
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
public class IG561VW extends BaseEntity implements Serializable,
		Cloneable, IG561VWInfo {

	/** 流水id */
    @Id
	protected Integer pvlid;

	/** 流程id */
	protected Integer prid;
	
	/** 表单值id fk于 ig599*/
	protected Integer piid;

	/** 状态id */
	protected String psdid;

	/** 表单id */
	protected String pidid;

	/** 表单名称 */
	protected String pivarname;

	/** 表单显示 */
	protected String pivarlabel;

	/** 表单类型 */
	protected String pivartype;

	/** 表单值 */
	protected String pivarvalue;

	/** 附件key */
	protected String piattkey;

	/** 权限 */
	protected String pidaccess;

	/** 必填 */
	protected String pidrequired;
	
	/**用户id*/
	protected String piuserid;
	
	/**节点名称*/
	protected String psdname;
	
	
	public String getPsdname() {
        return psdname;
    }
    public void setPsdname(String psdname) {
        this.psdname = psdname;
    }
    /**用户id*/
	public String getPiuserid() {
        return piuserid;
    }
	/**用户id*/
    public void setPiuserid(String piuserid) {
        this.piuserid = piuserid;
    }

    /**
	 * 流水id取得
	 *
	 * @return 流水id
	 */
	public Integer getPvlid() {
		return pvlid;
	}

	/**
	 * 流水id设定
	 *
	 * @param pvlid 流水id
	 */
	public void setPvlid(Integer pvlid) {
		this.pvlid = pvlid;
	}

	/**
	 * 流程id取得
	 *
	 * @return 流程id
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程id设定
	 *
	 * @param prid 流程id
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 状态id取得
	 *
	 * @return 状态id
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态id设定
	 *
	 * @param psdid 状态id
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 表单id取得
	 *
	 * @return 表单id
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单id设定
	 *
	 * @param pidid 表单id
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 表单名称取得
	 *
	 * @return 表单名称
	 */
	public String getPivarname() {
		return pivarname;
	}

	/**
	 * 表单名称设定
	 *
	 * @param pivarname 表单名称
	 */
	public void setPivarname(String pivarname) {
		this.pivarname = pivarname;
	}

	/**
	 * 表单显示取得
	 *
	 * @return 表单显示
	 */
	public String getPivarlabel() {
		return pivarlabel;
	}

	/**
	 * 表单显示设定
	 *
	 * @param pivarlabel 表单显示
	 */
	public void setPivarlabel(String pivarlabel) {
		this.pivarlabel = pivarlabel;
	}

	/**
	 * 表单类型取得
	 *
	 * @return 表单类型
	 */
	public String getPivartype() {
		return pivartype;
	}

	/**
	 * 表单类型设定
	 *
	 * @param pivartype 表单类型
	 */
	public void setPivartype(String pivartype) {
		this.pivartype = pivartype;
	}

	/**
	 * 表单值取得
	 *
	 * @return 表单值
	 */
	public String getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * 表单值设定
	 *
	 * @param pivarvalue 表单值
	 */
	public void setPivarvalue(String pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * 附件key取得
	 *
	 * @return 附件key
	 */
	public String getPiattkey() {
		return piattkey;
	}

	/**
	 * 附件key设定
	 *
	 * @param piattkey 附件key
	 */
	public void setPiattkey(String piattkey) {
		this.piattkey = piattkey;
	}

	/**
	 * 权限取得
	 *
	 * @return 权限
	 */
	public String getPidaccess() {
		return pidaccess;
	}

	/**
	 * 权限设定
	 *
	 * @param pidaccess 权限
	 */
	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}

	/**
	 * 必填取得
	 *
	 * @return 必填
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * 必填设定
	 *
	 * @param pidrequired 必填
	 */
	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	@Override
    public Serializable getPK() {
		return pvlid;
	}
    public Integer getPiid() {
        return piid;
    }
    public void setPiid(Integer piid) {
        this.piid = piid;
    }

}