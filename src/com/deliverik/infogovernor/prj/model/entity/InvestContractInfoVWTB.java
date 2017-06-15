/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.prj.model.InvestContractInfoVW;

/**
 * 概述: 投资合同明细视图实体
 * 功能描述：投资合同明细视图实体
 * 创建人：王廷志
 * 创建记录： 2012-5-25
 * 修改记录：
 */
@Entity
public class InvestContractInfoVWTB implements InvestContractInfoVW{
	@Id
	/** 项目ID */
	private Integer pid;
	/** 项目名称 */
	private String pname;
	/** 项目编号 */
	private String pcode;
	/** 预算编号 */
	private String pstorecode;
	/** 预算名称 */
	private String btitle;
	/** 软硬件 */
	private String pcut;
	/** 合同编号 */
	private String plcnumber;
	/** 合同金额 */
	private Double plcsum;
	/** 已付款 */
	private Double plbsum;
	/** 余额 */
	private Double subnum;
	/** 合同期数 */
	private Integer lcount;
	/** 付款期数 */
	private Integer bcount;
	/** 经办人 */
	private String username;
	/**
	 * 项目ID取得
	 * @return pid 项目ID
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 项目ID设定
	 * @param pid 项目ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 项目名称取得
	 * @return pname 项目名称
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * 项目名称设定
	 * @param pname 项目名称
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	/**
	 * 项目编号取得
	 * @return pcode 项目编号
	 */
	public String getPcode() {
		return pcode;
	}
	/**
	 * 项目编号设定
	 * @param pcode 项目编号
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	/**
	 * 预算编号取得
	 * @return pstorecode 预算编号
	 */
	public String getPstorecode() {
		return pstorecode;
	}
	/**
	 * 预算编号设定
	 * @param pstorecode 预算编号
	 */
	public void setPstorecode(String pstorecode) {
		this.pstorecode = pstorecode;
	}
	/**
	 * 预算名称取得
	 * @return btitle 预算名称
	 */
	public String getBtitle() {
		return btitle;
	}
	/**
	 * 预算名称设定
	 * @param btitle 预算名称
	 */
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	/**
	 * 软硬件取得
	 * @return pcut 软硬件
	 */
	public String getPcut() {
		return pcut;
	}
	/**
	 * 软硬件设定
	 * @param pcut 软硬件
	 */
	public void setPcut(String pcut) {
		this.pcut = pcut;
	}
	/**
	 * 合同编号取得
	 * @return plcnumber 合同编号
	 */
	public String getPlcnumber() {
		return plcnumber;
	}
	/**
	 * 合同编号设定
	 * @param plcnumber 合同编号
	 */
	public void setPlcnumber(String plcnumber) {
		this.plcnumber = plcnumber;
	}
	/**
	 * 合同金额取得
	 * @return plcsum 合同金额
	 */
	public Double getPlcsum() {
		return plcsum;
	}
	/**
	 * 合同金额设定
	 * @param plcsum 合同金额
	 */
	public void setPlcsum(Double plcsum) {
		this.plcsum = plcsum;
	}
	/**
	 * 已付款取得
	 * @return plbplcsum 已付款
	 */
	public Double getPlbsum() {
		return plbsum;
	}
	/**
	 * 已付款设定
	 * @param plbplcsum 已付款
	 */
	public void setPlbsum(Double plbsum) {
		this.plbsum = plbsum;
	}
	/**
	 * 余额取得
	 * @return subnum 余额
	 */
	public Double getSubnum() {
		return subnum;
	}
	/**
	 * 余额设定
	 * @param subnum 余额
	 */
	public void setSubnum(Double subnum) {
		this.subnum = subnum;
	}
	/**
	 * 合同期数取得
	 * @return lcount 合同期数
	 */
	public Integer getLcount() {
		return lcount;
	}
	/**
	 * 合同期数设定
	 * @param lcount 合同期数
	 */
	public void setLcount(Integer lcount) {
		this.lcount = lcount;
	}
	/**
	 * 付款期数取得
	 * @return bcount 付款期数
	 */
	public Integer getBcount() {
		return bcount;
	}
	/**
	 * 付款期数设定
	 * @param bcount 付款期数
	 */
	public void setBcount(Integer bcount) {
		this.bcount = bcount;
	}
	/**
	 * 经办人取得
	 * @return username 经办人
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 经办人设定
	 * @param username 经办人
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}
