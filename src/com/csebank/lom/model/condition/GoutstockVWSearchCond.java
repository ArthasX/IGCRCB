/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

import java.math.BigDecimal;

/**
 * 
 * 物品出库信息视图查询接口
 *
 */
public interface GoutstockVWSearchCond {
	

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
	 * 主键ID取得
	 * @return 主键ID
	 */
	public Integer getGsid();
	
	/**
	 * 总数量取得
	 * @return 总数量
	 */
	public Integer getGsnum();
	/**
	 * 所属机构层次码取得
	 * @return 所属机构层次码
	 */
	public String getGsorg();
	/**
	 * 采购平均价取得
	 * @return 采购平均价
	 */
	public BigDecimal getGsavgprice();
	/**
	 * 冻结数量取得
	 * @return 冻结数量
	 */
	public Integer getGsfreezenum();
	
}
