/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.asset.model.IG342Info;

/**
  * 概述: IG342VW实体
  * 功能描述: IG342VW实体
  * 创建记录: 2012/08/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
public class IG342VW implements Serializable,Cloneable, IG342Info {

	@Id
	/** 单位编号 */
	protected Integer eiid;

	/** 单位名称 */
	protected String einame;

	/** 地址 */
	protected String address;

	/** 联系人 */
	protected String linkman;

	/** 联系方式 */
	protected String phone;

	/** 注册资金 */
	protected String fund;

	/** 登记时间 */
	protected String eiinsdate;
	
	/** 修改时间 */
	protected String eiupdtime;

	/** 是否列入资源池 */
	protected String civalue;

	/** 公司资质 */
	protected String aptitude;

	/** 成功案例 */
	protected String succeedcase;

	/**
	 * 单位编号取得
	 *
	 * @return 单位编号
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 单位编号设定
	 *
	 * @param eiid 单位编号
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 单位名称取得
	 *
	 * @return 单位名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 单位名称设定
	 *
	 * @param einame 单位名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 地址取得
	 *
	 * @return 地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 地址设定
	 *
	 * @param address 地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 联系人取得
	 *
	 * @return 联系人
	 */
	public String getLinkman() {
		return linkman;
	}

	/**
	 * 联系人设定
	 *
	 * @param linkman 联系人
	 */
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	/**
	 * 联系方式取得
	 *
	 * @return 联系方式
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 联系方式设定
	 *
	 * @param phone 联系方式
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 注册资金取得
	 *
	 * @return 注册资金
	 */
	public String getFund() {
		return fund;
	}

	/**
	 * 注册资金设定
	 *
	 * @param fund 注册资金
	 */
	public void setFund(String fund) {
		this.fund = fund;
	}

	

	public String getEiinsdate() {
		return eiinsdate;
	}

	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}
	
	/**
	 * 修改时间取得
	 *
	 * @return 修改时间
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * 修改时间设定
	 *
	 * @param eiupdtime 修改时间
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * 是否列入资源池取得
	 *
	 * @return 是否列入资源池
	 */
	public String getCivalue() {
		return civalue;
	}

	/**
	 * 是否列入资源池设定
	 *
	 * @param civalue 是否列入资源池
	 */
	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	/**
	 * 公司资质取得
	 *
	 * @return 公司资质
	 */
	public String getAptitude() {
		return aptitude;
	}

	/**
	 * 公司资质设定
	 *
	 * @param aptitude 公司资质
	 */
	public void setAptitude(String aptitude) {
		this.aptitude = aptitude;
	}

	/**
	 * 成功案例取得
	 *
	 * @return 成功案例
	 */
	public String getSucceedcase() {
		return succeedcase;
	}

	/**
	 * 成功案例设定
	 *
	 * @param succeedcase 成功案例
	 */
	public void setSucceedcase(String succeedcase) {
		this.succeedcase = succeedcase;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return this.eiid;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.base.BaseModel#getFingerPrint()
	 */
	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}