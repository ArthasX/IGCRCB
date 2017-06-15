/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prj.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 项目日志付款表接口
  * 功能描述: 项目日志付款表接口
  * 创建记录: 2012/04/11
  * 修改记录: 
  */
public interface ProjectLogBusinessInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPlbid();

	/**
	 * 合同总额取得
	 *
	 * @return 合同总额
	 */
	public Double getPlbplcsum();

	/**
	 * 一期付款金额取得
	 *
	 * @return 一期付款金额
	 */
	public Double getPlbfirst();

	/**
	 * 二期付款金额取得
	 *
	 * @return 二期付款金额
	 */
	public Double getPlbsecond();

	/**
	 * 三期付款金额取得
	 *
	 * @return 三期付款金额
	 */
	public Double getPlbthird();

	/**
	 * 四期付款金额取得
	 *
	 * @return 四期付款金额
	 */
	public Double getPlbfourth();

	/**
	 * 五期付款金额取得
	 *
	 * @return 五期付款金额
	 */
	public Double getPlbfifth();

	/**
	 * 对应项目id取得
	 *
	 * @return 对应项目id
	 */
	public Integer getPlbpid();
	
	/**
	 * 对应项目日志id取得
	 *
	 * @return 对应项目日志id
	 */
	public Integer getPlbplid();

	/**
	 * 已付款总额取得
	 *
	 * @return 已付款总额
	 */
	public Double getPlbsum();

	/**
	 * 已付款比例取得
	 *
	 * @return 已付款比例
	 */
	public Double getPlbscale();

	/**
	 * 未付款总额取得
	 *
	 * @return 未付款总额
	 */
	public Double getPlbnotsum();

	/**
	 * 未付款比例取得
	 *
	 * @return 未付款比例
	 */
	public Double getPlbnotscale();

}