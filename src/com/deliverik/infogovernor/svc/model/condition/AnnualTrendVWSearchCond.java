/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 年度工作趋势统计查询条件接口
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
public interface AnnualTrendVWSearchCond {
	
	/**
	 * 年份取得
	 * @return year 年份
	 */
	public String getYear();

	/**
	 * 机构id取得
	 * @return orgid 机构id
	 */
	public String getOrgid();
}
