/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model;


/**
  * 概述: 监控报表详细页视图接口
  * 功能描述: 监控报表详细页视图接口
  * 创建记录: 2013/09/04
  * 修改记录: 
  */
public interface ReportDetailVWInfo  {

	
	/**
	 * 主键ID取得
	 *
	 * @return 主键ID
	 */
	public Integer getId();
	
	/**
	 * 用户ID取得
	 *
	 * @return 用户ID
	 */
	public String getUserid();

	/**
	 * 用户姓名取得
	 *
	 * @return 用户姓名
	 */
	public String getUsername();

	/**
	 * 机构ID取得
	 *
	 * @return 机构ID
	 */
	public String getOrgid();

	/**
	 * 名称（年报）取得
	 *
	 * @return 名称（年报）
	 */
	public String getName_y();

	/**
	 * 是否及时（年报）0-及时 1-不及时 取得
	 *
	 * @return 是否及时（年报）0-及时 1-不及时
	 */
	public String getOntime_y();

	/**
	 * 是否准确（年报）大于1不准确 取得
	 *
	 * @return 是否准确（年报）大于1不准确
	 */
	public String getCon_y();

	/**
	 * 名称（季报）取得
	 *
	 * @return 名称（季报）
	 */
	public String getName_m();

	/**
	 * 是否及时（季报）0-及时 1-不及时 取得
	 *
	 * @return 是否及时（季报）0-及时 1-不及时
	 */
	public String getOntime_m();

	/**
	 * 是否准确（季报）大于1不准确 取得
	 *
	 * @return 是否准确（季报）大于1不准确
	 */
	public String getCon_m();

	/**
	 * 名称（不定期）取得
	 *
	 * @return 名称（不定期）
	 */
	public String getName_z();

	/**
	 * 是否及时（不定期）0-及时 1-不及时 取得
	 *
	 * @return 是否及时（不定期）0-及时 1-不及时
	 */
	public String getOntime_z();

	/**
	 * 是否准确（不定期）大于1不准确 取得
	 *
	 * @return 是否准确（不定期）大于1不准确
	 */
	public String getCon_z();

}