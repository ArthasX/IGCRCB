/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * 物品出库信息查询接口
 *
 */
public interface GoutstockSearchCond {
	
	/**
	 *物品出库信息ID取得
	 * @return 物品出库信息ID
	 */
	public Integer getGoid();
	
	/**
	 * 出库类型(0:入库 1:领用 2:调剂 3:核销)取得
	 * @return 出库类型(0:入库 1:领用 2:调剂 3:核销)
	 */
	public String getGotype();

	/**
	 * 所属机构层次码取得
	 * @return 所属机构层次码
	 */
	public String getGoorg();
	
	/**
	 * 物品种类取得
	 * @return 物品种类
	 */
	public String getGocategory();


	/**
	 * 物品名称取得
	 * @return 物品名称
	 */
	public String getGoname();

	/**
	 * 物品编号取得
	 * @return 物品编号
	 */
	public String getGocode();


	/**
	 * 出库时间取得
	 * @return 出库时间
	 */
	public String getGotime();

	/**
	 * 采购申请单批号取得
	 * @return 采购申请单批号
	 */
	public String getGoreqnum();


	/**
	 * 出库单价取得
	 * @return 出库单价
	 */
	public BigDecimal getGooutprice();


	/**
	 * 出库数量取得
	 * @return 出库数量
	 */
	public Integer getGoinnum();


	/**
	 * 计量单位取得
	 * @return 计量单位
	 */
	public String getGounit();


	/**
	 * 供应商取得
	 * @return 供应商
	 */
	public String getGoprovider();



	/**
	 * 购买人取得
	 * @return 购买人
	 */
	public String getGopurchaser();


	/**
	 * 调剂价格取得
	 * @return 调剂价格
	 */
	public BigDecimal getGoreliefprice();

	/**
	 * 调剂数量取得
	 * @return 调剂数量
	 */
	public Integer getGoreliefnum();


	/**
	 * 出库状态(入库时：0:库存无 1:库存有;出库时：0:出库完成 1:待审批 2:审批未通过)取得
	 * @return 出库状态(入库时：0:库存无 1:库存有;出库时：0:出库完成 1:待审批 2:审批未通过)
	 */
	public String getGostatus();


	/**
	 * 领用机构/调剂机构层次码取得
	 * @return 领用机构/调剂机构层次码
	 */
	public String getGoreqorg();


	/**
	 * 领用人/调剂人ID取得
	 * @return 领用人/调剂人ID
	 */
	public String getGorequser();



	/**
	 * 领用人/调剂人姓名取得
	 * @return 领用人/调剂人姓名
	 */
	public String getGorequsername();


	/**
	 * 登记人取得
	 * @return 登记人
	 */
	public String getGouser();


	/**
	 * 登记人姓名取得
	 * @return 登记人姓名
	 */
	public String getGousername();

	/**
	 * 审批数量取得
	 * @return 审批数量
	 */
	public Integer getGochknum();



	/**
	 * 审批人ID取得
	 * @return 审批人ID
	 */
	public String getGochkid();



	/**
	 * 审批人姓名取得
	 * @return 审批人姓名
	 */
	public String getGochkkname();

	/**
	 * 查询开始时间取得
	 * @return 开始时间
	 */
	public String getGotime_f();

	/**
	 * 查询结束时间取得
	 * @return 结束时间
	 */
	public String getGotime_t();
	
	/**
	 * 接待ID取得
	 * @return 接待ID
	 */
	public Integer getRid();
	/**
	 * 是否有礼品code取得
	 * @return 是否有礼品code
	 */
	public boolean isHascategory();
	
	/**
	 * @return the gotypeList
	 */
	public List<String> getGotypeList();
}
