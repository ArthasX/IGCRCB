/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 物品查询接口
 *
 */
public interface GstockSearchCond {
	/**
	 * 主键ID取得
	 * @return 主键ID
	 */
	public Integer getGsid();
	
	/**
	 * 物品种类取得
	 * @return 物品种类
	 */
	public String getGscategory();
	
	/**
	 * 物品名称取得
	 * @return 物品名称
	 */
	public String getGsname();
	
	/**
	 * 物品编号取得
	 * @return 物品编号
	 */
	public String getGscode();
	
	
	/**
	 * 所属机构层次码取得
	 * @return 所属机构层次码
	 */
	public String getGsorg();
	
	public Integer getGsnum() ;
	public String getGsavgprice() ;
	public Integer getGsfreezenum();
	public String getGsuserid();
	public String getGsusername();
	public String getGsdate() ;
}
