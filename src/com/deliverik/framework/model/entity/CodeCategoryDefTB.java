package com.deliverik.framework.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.model.CodeCategoryDefInfo;

/**
 * 数据分类信息实体
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="CodeCategoryDef")
public class CodeCategoryDefTB extends BaseEntity implements Serializable, CodeCategoryDefInfo {

	/** 数据分类CD */
	@Id
	protected String ccid ;
	
	/** 数据分类名 */
	protected String ccname;

	/** 数据分类说明 */
	protected String ccinfo;

	/** 数据分类编辑标识 */
	protected String cceditable;

	/** 数据分类编号(父) */
	protected String pccid;

	/** 父子类型数据分类标识 */
	protected String pcflag;

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return ccid;
	}


	/**
	 * 数据分类CD取得
	 * @return 数据分类CD
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * 数据分类CD设定
	 *
	 * @param ccid 数据分类CD
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * 数据分类名取得
	 * @return 数据分类名
	 */
	public String getCcname() {
		return ccname;
	}


	/**
	 * 数据分类名设定
	 *
	 * @param ccname 数据分类名
	 */
	public void setCcname(String ccname) {
		this.ccname = ccname;
	}


	/**
	 * 数据分类说明取得
	 * @return 数据分类说明
	 */
	public String getCcinfo() {
		return ccinfo;
	}


	/**
	 * 数据分类说明设定
	 *
	 * @param ccinfo 数据分类说明
	 */
	public void setCcinfo(String ccinfo) {
		this.ccinfo = ccinfo;
	}


	/**
	 * 数据分类编辑标识取得
	 * @return 数据分类编辑标识
	 */
	public String getCceditable() {
		return cceditable;
	}

	/**
	 * 数据分类编辑标识设定
	 *
	 * @param cceditable 数据分类编辑标识
	 */
	public void setCceditable(String cceditable) {
		this.cceditable = cceditable;
	}

	/**
	 * 数据分类编号(父)取得
	 * @return 数据分类编号(父)
	 */
	public String getPccid() {
		return pccid;
	}


	/**
	 * 数据分类编号(父)设定
	 *
	 * @param pccid 数据分类编号(父)
	 */
	public void setPccid(String pccid) {
		this.pccid = pccid;
	}


	/**
	 * 父子类型数据分类标识取得
	 * @return 父子类型数据分类标识
	 */
	public String getPcflag() {
		return pcflag;
	}


	/**
	 * 父子类型数据分类标识设定
	 *
	 * @param pcflag 父子类型数据分类标识
	 */
	public void setPcflag(String pcflag) {
		this.pcflag = pcflag;
	}
}
