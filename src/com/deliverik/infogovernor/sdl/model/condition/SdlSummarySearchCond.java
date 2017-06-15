/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_服务水平统计查询MODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public interface SdlSummarySearchCond {
	/**
	 * 获取年度
	 * @return 年度
	 */
	public String getYear();

	/**
	 * 获取相关资产ID
	 * @return 相关资产ID
	 */
	public Integer getEiid();

	/**
	 * 获取资产名称
	 * @return 资产名称
	 */
	public String getEiname();

}
