/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;


/**
 * 
 * 物品领用信息视图实体接口
 *
 */
public interface GinoutStockDetailVWInfo {

	public Integer getGiodid();
	
	public String getGiodtype();
	
	public String getGiodorg();
	
	public String getGiodcategory();
	
	public String getGiodname();
	
	public String getGiodcode();
	
	public Integer getGiodinnum();
	
	public String getGiodreliefnum();
	
	public BigDecimal getGiodhavocnum();
	
	public String getGiodreqnum();
	
	public Integer getGiodoutnum();
	
	public String getGiodunit();
	
	public BigDecimal getGiodinprice();
	
	/**
	 * GStock主键取得
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
