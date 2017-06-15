/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prj.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 项目日志合同表接口
  * 功能描述: 项目日志合同表接口
  * 创建记录: 2012/04/10
  * 修改记录: 
  */
public interface ProjectLogContractInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPlcid();

	/**
	 * 合同金额取得
	 *
	 * @return 合同金额
	 */
	public Double getPlcsum();

	/**
	 * 合同付款条件取得
	 *
	 * @return 合同付款条件
	 */
	public String getPlcsumterm();

	/**
	 * 一期付款金额取得
	 *
	 * @return 一期付款金额
	 */
	public Double getPlcfirst();

	/**
	 * 一期付款条件取得
	 *
	 * @return 一期付款条件
	 */
	public String getPlcfirstterm();

	/**
	 * 二期付款金额取得
	 *
	 * @return 二期付款金额
	 */
	public Double getPlcsecond();

	/**
	 * 二期付款条件取得
	 *
	 * @return 二期付款条件
	 */
	public String getPlcsecondterm();

	/**
	 * 三期付款金额取得
	 *
	 * @return 三期付款金额
	 */
	public Double getPlcthird();

	/**
	 * 三期付款条件取得
	 *
	 * @return 三期付款条件
	 */
	public String getPlcthirdterm();

	/**
	 * 四期付款金额取得
	 *
	 * @return 四期付款金额
	 */
	public Double getPlcfourth();

	/**
	 * 四期付款条件取得
	 *
	 * @return 四期付款条件
	 */
	public String getPlcfourthterm();

	/**
	 * 五期付款金额取得
	 *
	 * @return 五期付款金额
	 */
	public Double getPlcfifth();

	/**
	 * 五期付款条件取得
	 *
	 * @return 五期付款条件
	 */
	public String getPlcfifthterm();
	
	/**
	 * 对应项目id取得
	 *
	 * @return 对应项目id
	 */
	public Integer getPlcpid();

	/**
	 * 对应项目日志id取得
	 *
	 * @return 对应项目日志id
	 */
	public Integer getPlcplid();
	
	/**
	 * 项目 资本金 开发取得
	 *
	 * @return 项目 资本金 开发
	 */
	public Double getBzdevelop();
	
	/**
	 * 项目 资本金 硬件取得
	 *
	 * @return 项目 资本金 硬件
	 */
	public Double getBzhardware();
	
	/**
	 * 项目 资本金 软件取得
	 *
	 * @return 项目 资本金 软件
	 */
	public Double getBzsoftware();
	
	/**
	 * 项目 资本金 工程取得
	 *
	 * @return 项目 资本金 工程
	 */
	public Double getBzproject();

	/**
	 * 项目 资本金 其他取得
	 *
	 * @return 项目 资本金 其他
	 */
	public Double getBzelse();
	
	/**
	 * 项目 成本金 实施取得
	 *
	 * @return 项目 成本金 实施
	 */
	public Double getBcimplement();

	/**
	 * 项目 成本金 其他取得
	 *
	 * @return 项目 成本金 其他
	 */
	public Double getBcelse();
	
	/**
	 * 合同编号取得
	 * @return 合同编号
	 */
	public String getPlcnumber();

}