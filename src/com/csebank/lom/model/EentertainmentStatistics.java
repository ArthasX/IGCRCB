/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.model;

import java.math.BigDecimal;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 食堂管理_统计汇总_招待统计信息MODEL
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */
public interface EentertainmentStatistics {
	
	/**
	 * 日期
	 * @return 日期
	 */
	public String getEdate();
	
	/**
	 * 招待次数
	 * @return 招待次数
	 */
	public BigDecimal getEnumber();
	
	/**
	 * 招待次数
	 * @param enumber 招待次数
	 */
	public void setEnumber(BigDecimal enumber);
	
	/**
	 * 菜价
	 * @return 菜价
	 */
	public BigDecimal getEefoodprice();
	
	/**
	 * 酒价
	 * @return 酒价
	 */
	public BigDecimal getEedrinkprice();
	
	/**
	 * 烟价
	 * @return 烟价
	 */
	public BigDecimal getEesmokeprice();
	
	/**
	 * 合计
	 * @return 合计
	 */
	public BigDecimal getEtotal();
	public BigDecimal getEeotherprice();

}