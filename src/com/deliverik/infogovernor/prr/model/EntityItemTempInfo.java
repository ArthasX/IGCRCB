/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 放置临时设备信息表接口
  * 功能描述: 放置临时设备信息表接口
  * 创建记录: 2013/08/29
  * 修改记录: 
  */
public interface EntityItemTempInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getEitid();

	/**
	 * 对应的采购编号取得
	 *
	 * @return 对应的采购编号
	 */
	public String getEitConNum();
	
	/**
	 * 对应的服务商Eiid取得
	 *
	 * @return eitSupEiid 对应的服务商Eiid
	 */
	public String getEitSupEiid();
	
	/**
	 * 对应的服务商编号取得
	 *
	 * @return eitSupNum 对应的服务商编号
	 */
	public String getEitSupNum();
	
	/**
	 * 对应的采购Eiid取得
	 *
	 * @return eitConEiid 对应的采购Eiid
	 */
	public String getEitConEiid();

	/**
	 * 设备类型那个取得
	 *
	 * @return 设备类型
	 */
	public String getEitBClass();

	/**
	 * 设备小类取得
	 *
	 * @return 设备小类
	 */
	public String getEitSClass();

	/**
	 * 设备品牌取得
	 *
	 * @return 设备品牌
	 */
	public String getEitBrand();

	/**
	 * 设备型号取得
	 *
	 * @return 设备型号
	 */
	public String getEitModelNum();

	/**
	 * 设备产权归属取得
	 *
	 * @return 设备产权归属
	 */
	public String getEitSyscoding();

	/**
	 * 原始价格取得
	 *
	 * @return 原始价格
	 */
	public String getEitPrice();

	/**
	 * 维保年限取得
	 *
	 * @return 维保年限
	 */
	public String getEitFYear();

	/**
	 * 设备数量取得
	 *
	 * @return 设备数量
	 */
	public Integer getEitNum();

	/**
	 * 保修开始日期取得
	 *
	 * @return 保修开始日期
	 */
	public String getEitWarFrom();

	/**
	 * 保修结束日期取得
	 *
	 * @return 保修结束日期
	 */
	public String getEitWarTo();

	/**
	 * 备注取得
	 *
	 * @return 备注
	 */
	public String getEitDesc();

	/**
	 * 未验收设备数量取得
	 *
	 * @return 未验收设备数量
	 */
	public Integer getEitUncheckNum();

	/**
	 * 已验收设备数量取得
	 *
	 * @return 已验收设备数量
	 */
	public Integer getEitCheckedNum();
	
	/**
	 * 采购时间取得
	 *
	 * @return eitPurchaseDate 采购时间
	 */
	public String getEitPurchaseDate();

	/**
	 * 流程id取得
	 *
	 * @return prid 流程id
	 */
	public Integer getPrid();
	/** 类别 */
	public String getType();
}