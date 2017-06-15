/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.model;

import com.csebank.lom.model.entity.RecptionTB;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 食堂管理_统计汇总_单一物品库存统计信息MODEL
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */
public interface SingleGoodsStock {
	
	/**
	 * 日期
	 * @return 日期
	 */
	public String getGiodtime();
	
	/**
	 * 出入库类型
	 * @return 出入库类型
	 */
	public String getGiodtype();
	
	/**
	 * 部门名
	 * @return 部门名
	 */
	//public String getOrgname();
	
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
	
	public RecptionTB getRecptionTB();
	
	public Integer getRid() ;

}