/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.model;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 食堂管理_统计汇总_库存统计信息MODEL
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */
public interface GoodsStock {
	
	/**
	 * 序号
	 * @return 序号
	 */
	public String getGid();
	
	/**
	 * 物品编号
	 * @return 物品编号
	 */
	public String getGiodcode();
	
	/**
	 * 物品名称
	 * @return 物品名称
	 */
	public String getGiodname();
	
	/**
	 * 出库数量
	 * @return 出库数量
	 */
	public Integer getGiodoutnum();
	
	/**
	 * 入库数量
	 * @return 入库数量
	 */
	public Integer getGiodinnum();
	
	/**
	 * 库存量
	 * @return 库存量
	 */
	public Integer getGiodnum();
	
	public String getType();

}