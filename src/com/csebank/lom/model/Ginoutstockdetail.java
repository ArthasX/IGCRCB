/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;



import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * 物品入出库明细信息实体接口
 *
 */
public interface Ginoutstockdetail extends BaseModel {

	/**
	 * 物品入出库明细信息ID取得
	 * @return 物品入出库明细信息ID
	 */
	public Integer getGiodid();


	/**
	 * 库存数量取得
	 * @return 库存数量
	 */
	public Integer getGsnum();
	

	/**
	 * 入出库类型(0:入库 1:领用 2:调剂 3:核销)取得
	 * @return 入出库类型(0:入库 1:领用 2:调剂 3:核销)
	 */
	public String getGiodtype();




	/**
	 * 所属机构层次码取得
	 * @return 所属机构层次码
	 */
	public String getGiodorg();




	/**
	 * 物品种类取得
	 * @return 物品种类
	 */
	public String getGiodcategory();




	/**
	 * 物品名称取得
	 * @return 物品名称
	 */
	public String getGiodname();




	/**
	 * 物品编号取得
	 * @return 物品编号
	 */
	public String getGiodcode();




	/**
	 * 入出库时间取得
	 * @return 入出库时间
	 */
	public String getGiodtime();




	/**
	 * 采购申请单批号取得
	 * @return 采购申请单批号
	 */
	public String getGiodreqnum();




	/**
	 * 入库单价取得
	 * @return 入库单价
	 */
	public BigDecimal getGiodinprice();




//	/**
//	 * 出库单价取得
//	 * @return 出库单价
//	 */
//	public BigDecimal getGiodoutprice();




	/**
	 * 入出库数量取得
	 * @return 入出库数量
	 */
	public Integer getGiodinnum();



	/**
	 * 计量单位取得
	 * @return 计量单位
	 */
	public String getGiodunit();




	/**
	 * 供应商取得
	 * @return 供应商
	 */
	public String getGiodprovider();




	/**
	 * 购买人取得
	 * @return 购买人
	 */
	public String getGiodpurchaser();




	/**
	 * 调剂价格取得
	 * @return 调剂价格
	 */
	public BigDecimal getGiodreliefprice();




	/**
	 * 调剂数量取得
	 * @return 调剂数量
	 */
	public Integer getGiodreliefnum();




	/**
	 * 入出库状态(入库时：0:库存无 1:库存有;出库时：0:出库完成 1:待审批 2:审批未通过)取得
	 * @return 入出库状态(入库时：0:库存无 1:库存有;出库时：0:出库完成 1:待审批 2:审批未通过)
	 */
	public String getGiodstatus();




	/**
	 * 领用机构/调剂机构层次码取得
	 * @return 领用机构/调剂机构层次码
	 */
	public String getGiodreqorg();




	/**
	 * 领用人/调剂人ID取得
	 * @return 领用人/调剂人ID
	 */
	public String getGiodrequser();




	/**
	 * 领用人/调剂人姓名取得
	 * @return 领用人/调剂人姓名
	 */
	public String getGiodrequsername();




	/**
	 * 登记人取得
	 * @return 登记人
	 */
	public String getGioduser();




	/**
	 * 登记人姓名取得
	 * @return 登记人姓名
	 */
	public String getGiodusername();



	/**
	 * 审批数量取得
	 * @return 审批数量
	 */
	public Integer getGiodchknum();




	/**
	 * 审批人ID取得
	 * @return 审批人ID
	 */
	public String getGiodchkid();




	/**
	 * 审批人姓名取得
	 * @return 审批人姓名
	 */
	public String getGiodchkkname();
	
	/**
	 * 物品出库信息ID取得
	 * @return 物品出库信息ID
	 */
	public Integer getGoid();
	
	/**
	 * 物品入库记录ID取得
	 * @return 物品入库记录ID
	 */
	public Integer getGioid();
	
	/**
	 * 领用数量取得
	 * @return 领用数量
	 */
	public Integer getGiodoutnum();



	/**
	 * 核销数量取得
	 * @return 核销数量
	 */
	public Integer getGiodhavocnum();
}
