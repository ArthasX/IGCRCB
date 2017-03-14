/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.model.condition;

/**
  * 概述: 放置临时设备信息表检索条件实现
  * 功能描述: 放置临时设备信息表检索条件实现
  * 创建记录: 2013/08/29
  * 修改记录: 
  */
public class EntityItemTempSearchCondImpl implements
		EntityItemTempSearchCond {
	
	/** 对应的采购编号 */
	protected String eitConNum;
	
	/** 设备类型 */
	protected String eitBClass;

//	/** 设备小类 */
//	protected String eitSClass;
	
	/** 流程id */
	protected Integer prid;
	
	/** 设备品牌 */
	protected String eitBrand;
	/** 类别 */
	protected String type;
	/** 类别例如设备，软件，耗材，备件*/
	public  String getType() {
		return type;
	}
	/** 类别 例如设备，软件，耗材，备件*/
	public  void setType(String type) {
		this.type = type;
	}

	/**
	 * 设备品牌取得
	 *
	 * @return eitBrand 设备品牌
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
	 * 设备类型取得
	 *
	 * @return eitBClass 设备类型
	 */
	public String getEitBClass() {
		return eitBClass;
	}

	/**
	 * 设备类型设定
	 *
	 * @param eitBClass 设备类型
	 */
	public void setEitBClass(String eitBClass) {
		this.eitBClass = eitBClass;
	}

//	/**
//	 * 设备小类取得
//	 *
//	 * @return eitSClass 设备小类
//	 */
//	public String getEitSClass() {
//		return eitSClass;
//	}
//
//	/**
//	 * 设备小类设定
//	 *
//	 * @param eitSClass 设备小类
//	 */
//	public void setEitSClass(String eitSClass) {
//		this.eitSClass = eitSClass;
//	}

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
	 * 对应的采购编号取得
	 *
	 * @return eitConNum 对应的采购编号
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

	


}