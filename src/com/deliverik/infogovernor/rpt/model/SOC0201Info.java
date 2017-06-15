/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

/**
 * 
 * @Description:自动报表生成表实体接口
 * @Author
 * @History
 * @Version V1.0
 * 修改记录：2012/08/09 将REPORT_GDATA_ITEM表名改为SOC0201Info
 */
public interface SOC0201Info {
	/**
	 *自增无意义主键
	 */
	public Integer getId();

	/**
	 *统计类型
	 */
	public String getR_category();

	/**
	 *报表文件名称
	 */
	public String getR_path();

	/**
	 *报表配置id
	 */
	public Integer getR_rcid();

	/**
	 *报表统计年月
	 */
	public String getR_time();

	/**
	 * @return the 数据ID
	 */
	public String getDataid();
}
