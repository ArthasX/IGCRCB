/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sya.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sya.model.InstitutionInfo;

/**	
 * 概述: 制度汇编实体
 * 功能描述： 制度汇编实体
 * 创建记录：yukexin    2015-2-5 上午10:50:44	
 * 修改记录：null
 */	
@SuppressWarnings("serial")
@Entity
@Table(name="Institution")
public class InstitutionTB extends BaseEntity implements Serializable,
		Cloneable, InstitutionInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="INSTITUTION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="INSTITUTION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="INSTITUTION_TABLE_GENERATOR")
	protected Integer inid;

	/** 制度名称  */	
	protected String inname;

	/** 制度描述  */	
	protected String indesc;

	/** 附件 */
	protected String attkey;

	/** 登记人id */
	protected String inuserid;

	/** 登记人姓名 */
	protected String inusername;

	/** 登记人机构id */
	protected String inorgid;

	/** 登记人机构名称 */
	protected String inorgname;

	/** 创建时间 */
	protected String createtime;
	
	/** 制度分类  */	
	public String intype;
	/**
	 * 主键取得
	 * @return inid  主键
	 */
	public Integer getInid() {
		return inid;
	}

	/**
	 * 主键设定
	 * @param inid  主键
	 */
	public void setInid(Integer inid) {
		this.inid = inid;
	}

	/**
	 * 制度名称取得
	 * @return inname  制度名称
	 */
	public String getInname() {
		return inname;
	}

	/**
	 * 制度名称设定
	 * @param inname  制度名称
	 */
	public void setInname(String inname) {
		this.inname = inname;
	}

	/**
	 * 制度描述取得
	 * @return indesc  制度描述
	 */
	public String getIndesc() {
		return indesc;
	}

	/**
	 * 制度描述设定
	 * @param indesc  制度描述
	 */
	public void setIndesc(String indesc) {
		this.indesc = indesc;
	}

	/**
	 * 附件取得
	 * @return attkey  附件
	 */
	public String getAttkey() {
		return attkey;
	}

	/**
	 * 附件设定
	 * @param attkey  附件
	 */
	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	/**
	 * 登记人id取得
	 * @return inuserid  登记人id
	 */
	public String getInuserid() {
		return inuserid;
	}

	/**
	 * 登记人id设定
	 * @param inuserid  登记人id
	 */
	public void setInuserid(String inuserid) {
		this.inuserid = inuserid;
	}

	/**
	 * 登记人姓名取得
	 * @return inusername  登记人姓名
	 */
	public String getInusername() {
		return inusername;
	}

	/**
	 * 登记人姓名设定
	 * @param inusername  登记人姓名
	 */
	public void setInusername(String inusername) {
		this.inusername = inusername;
	}

	/**
	 * 登记人机构id取得
	 * @return inorgid  登记人机构id
	 */
	public String getInorgid() {
		return inorgid;
	}

	/**
	 * 登记人机构id设定
	 * @param inorgid  登记人机构id
	 */
	public void setInorgid(String inorgid) {
		this.inorgid = inorgid;
	}

	/**
	 * 登记人机构名称取得
	 * @return inorgname  登记人机构名称
	 */
	public String getInorgname() {
		return inorgname;
	}

	/**
	 * 登记人机构名称设定
	 * @param inorgname  登记人机构名称
	 */
	public void setInorgname(String inorgname) {
		this.inorgname = inorgname;
	}

	/**
	 * 创建时间取得
	 * @return createtime  创建时间
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * 创建时间设定
	 * @param createtime  创建时间
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	@Override
	public Serializable getPK() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 制度分类取得
	 * @return intype  制度分类
	 */
	public String getIntype() {
		return intype;
	}

	/**
	 * 制度分类设定
	 * @param intype  制度分类
	 */
	public void setIntype(String intype) {
		this.intype = intype;
	}

	

}