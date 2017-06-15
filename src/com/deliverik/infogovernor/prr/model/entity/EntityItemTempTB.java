/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.prr.model.EntityItemTempInfo;

/**
  * 概述: 放置临时设备信息表实体
  * 功能描述: 放置临时设备信息表实体
  * 创建记录: 2013/08/29
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="entityItemTemp")
public class EntityItemTempTB extends BaseEntity implements Serializable,
		Cloneable, EntityItemTempInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="ENTITYITEMTEMP_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="ENTITYITEMTEMP_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ENTITYITEMTEMP_TABLE_GENERATOR")
	protected Integer eitid;

	/** 对应的采购编号 */
	protected String eitConNum;
	
	/** 对应的采购Eiid */
	protected String eitConEiid;
	
	/** 对应的服务商编号 */
	protected String eitSupNum;
	
	/** 对应的服务商Eiid */
	protected String eitSupEiid;

	/** 设备类型 */
	protected String eitBClass;

	/** 设备小类 */
	protected String eitSClass;

	/** 设备品牌 */
	protected String eitBrand;

	/** 设备型号 */
	protected String eitModelNum;

	/** 设备产权归属 */
	protected String eitSyscoding;

	/** 原始价格 */
	protected String eitPrice;

	/** 维保年限 */
	protected String eitFYear;

	/** 设备数量 */
	protected Integer eitNum;

	/** 保修开始日期 */
	protected String eitWarFrom;

	/** 保修结束日期 */
	protected String eitWarTo;

	/** 备注 */
	protected String eitDesc;

	/** 未验收设备数量 */
	protected Integer eitUncheckNum;

	/** 已验收设备数量 */
	protected Integer EitCheckedNum;
	
	/** 采购时间 */
	protected String eitPurchaseDate;
	
	/** 流程id */
	protected Integer prid;
	
	/** 类别 */
	protected String type;
	
	/** 类别 -例如设备，软件，耗材，备件*/
	public  String getType() {
		return type;
	}
	/** 类别-例如设备，软件，耗材，备件 */
	public  void setType(String type) {
		this.type = type;
	}

	/**
	 * 对应的采购Eiid取得
	 *
	 * @return eitConEiid 对应的采购Eiid
	 */
	public String getEitConEiid() {
		return eitConEiid;
	}

	/**
	 * 对应的采购Eiid设定
	 *
	 * @param eitConEiid 对应的采购Eiid
	 */
	public void setEitConEiid(String eitConEiid) {
		this.eitConEiid = eitConEiid;
	}

	/**
	 * 对应的服务商编号取得
	 *
	 * @return eitSupNum 对应的服务商编号
	 */
	public String getEitSupNum() {
		return eitSupNum;
	}

	/**
	 * 对应的服务商编号设定
	 *
	 * @param eitSupNum 对应的服务商编号
	 */
	public void setEitSupNum(String eitSupNum) {
		this.eitSupNum = eitSupNum;
	}

	/**
	 * 对应的服务商Eiid取得
	 *
	 * @return eitSupEiid 对应的服务商Eiid
	 */
	public String getEitSupEiid() {
		return eitSupEiid;
	}

	/**
	 * 对应的服务商Eiid设定
	 *
	 * @param eitSupEiid 对应的服务商Eiid
	 */
	public void setEitSupEiid(String eitSupEiid) {
		this.eitSupEiid = eitSupEiid;
	}

	/**
	 * 流程id取得
	 *
	 * @return prid 流程id
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
	 * 采购时间取得
	 *
	 * @return eitPurchaseDate 采购时间
	 */
	public String getEitPurchaseDate() {
		return eitPurchaseDate;
	}

	/**
	 * 采购时间设定
	 *
	 * @param eitPurchaseDate 采购时间
	 */
	public void setEitPurchaseDate(String eitPurchaseDate) {
		this.eitPurchaseDate = eitPurchaseDate;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getEitid() {
		return eitid;
	}

	/**
	 * 主键设定
	 *
	 * @param eitid 主键
	 */
	public void setEitid(Integer eitid) {
		this.eitid = eitid;
	}

	/**
	 * 对应的采购编号取得
	 *
	 * @return 对应的采购编号
	 */
	public String getEitConNum() {
		return eitConNum;
	}

	/**
	 * 对应的采购编号设定
	 *
	 * @param eitConNum 对应的采购编号
	 */
	public void setEitConNum(String eitConNum) {
		this.eitConNum = eitConNum;
	}

	/**
	 * 设备大类取得
	 *
	 * @return 设备大类
	 */
	public String getEitBClass() {
		return eitBClass;
	}

	/**
	 * 设备大类设定
	 *
	 * @param eitBClass 设备大类
	 */
	public void setEitBClass(String eitBClass) {
		this.eitBClass = eitBClass;
	}

	/**
	 * 设备小类取得
	 *
	 * @return 设备小类
	 */
	public String getEitSClass() {
		return eitSClass;
	}

	/**
	 * 设备小类设定
	 *
	 * @param eitSClass 设备小类
	 */
	public void setEitSClass(String eitSClass) {
		this.eitSClass = eitSClass;
	}

	/**
	 * 设备品牌取得
	 *
	 * @return 设备品牌
	 */
	public String getEitBrand() {
		return eitBrand;
	}

	/**
	 * 设备品牌设定
	 *
	 * @param eitBrand 设备品牌
	 */
	public void setEitBrand(String eitBrand) {
		this.eitBrand = eitBrand;
	}

	/**
	 * 设备型号取得
	 *
	 * @return 设备型号
	 */
	public String getEitModelNum() {
		return eitModelNum;
	}

	/**
	 * 设备型号设定
	 *
	 * @param eitModelNum 设备型号
	 */
	public void setEitModelNum(String eitModelNum) {
		this.eitModelNum = eitModelNum;
	}

	/**
	 * 设备产权归属取得
	 *
	 * @return 设备产权归属
	 */
	public String getEitSyscoding() {
		return eitSyscoding;
	}

	/**
	 * 设备产权归属设定
	 *
	 * @param eitSyscoding 设备产权归属
	 */
	public void setEitSyscoding(String eitSyscoding) {
		this.eitSyscoding = eitSyscoding;
	}

	/**
	 * 原始价格取得
	 *
	 * @return 原始价格
	 */
	public String getEitPrice() {
		return eitPrice;
	}

	/**
	 * 原始价格设定
	 *
	 * @param eitPrice 原始价格
	 */
	public void setEitPrice(String eitPrice) {
		this.eitPrice = eitPrice;
	}

	/**
	 * 维保年限取得
	 *
	 * @return 维保年限
	 */
	public String getEitFYear() {
		return eitFYear;
	}

	/**
	 * 维保年限设定
	 *
	 * @param eitFYear 维保年限
	 */
	public void setEitFYear(String eitFYear) {
		this.eitFYear = eitFYear;
	}

	/**
	 * 设备数量取得
	 *
	 * @return 设备数量
	 */
	public Integer getEitNum() {
		return eitNum;
	}

	/**
	 * 设备数量设定
	 *
	 * @param eitNum 设备数量
	 */
	public void setEitNum(Integer eitNum) {
		this.eitNum = eitNum;
	}

	/**
	 * 保修开始日期取得
	 *
	 * @return 保修开始日期
	 */
	public String getEitWarFrom() {
		return eitWarFrom;
	}

	/**
	 * 保修开始日期设定
	 *
	 * @param eitWarFrom 保修开始日期
	 */
	public void setEitWarFrom(String eitWarFrom) {
		this.eitWarFrom = eitWarFrom;
	}

	/**
	 * 保修结束日期取得
	 *
	 * @return 保修结束日期
	 */
	public String getEitWarTo() {
		return eitWarTo;
	}

	/**
	 * 保修结束日期设定
	 *
	 * @param eitWarTo 保修结束日期
	 */
	public void setEitWarTo(String eitWarTo) {
		this.eitWarTo = eitWarTo;
	}

	/**
	 * 备注取得
	 *
	 * @return 备注
	 */
	public String getEitDesc() {
		return eitDesc;
	}

	/**
	 * 备注设定
	 *
	 * @param eitDesc 备注
	 */
	public void setEitDesc(String eitDesc) {
		this.eitDesc = eitDesc;
	}

	/**
	 * 未验收设备数量取得
	 *
	 * @return 未验收设备数量
	 */
	public Integer getEitUncheckNum() {
		return eitUncheckNum;
	}

	/**
	 * 未验收设备数量设定
	 *
	 * @param eitUncheckNum 未验收设备数量
	 */
	public void setEitUncheckNum(Integer eitUncheckNum) {
		this.eitUncheckNum = eitUncheckNum;
	}

	/**
	 * 已验收设备数量取得
	 *
	 * @return 已验收设备数量
	 */
	public Integer getEitCheckedNum() {
		return EitCheckedNum;
	}

	/**
	 * 已验收设备数量设定
	 *
	 * @param EitCheckedNum 已验收设备数量
	 */
	public void setEitCheckedNum(Integer EitCheckedNum) {
		this.EitCheckedNum = EitCheckedNum;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return eitid;
	}

}