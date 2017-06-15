/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

/**
 * 
 * @Description:自动报表配置列表实体接口
 * @Author
 * @History
 * @Version V1.0
 * 修改记录：2012/08/09 将ReportConfiguration表名改为SOC0203Info
 */
public interface SOC0203Info {
	/**
	 *自增无意义主键
	 */
	public Integer getId();

	/**
	 *报表文件的名称
	 */
	public String getR_path();

	/**
	 *报表文件的中文含义
	 */
	public String getR_title();

	/**
	 *报表运行时所用的参数
	 */
	public String getPara();

	/**
	 * @return the 数据ID
	 */
	public String getDataid();

}
