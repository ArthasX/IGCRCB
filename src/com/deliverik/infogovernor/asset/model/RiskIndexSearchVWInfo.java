/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 风险指标查询接口
  * 功能描述: 风险指标查询接口
  * 创建记录: 2014/07/25
  * 修改记录: 
  */
public interface RiskIndexSearchVWInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getEiid();

	/**
	 * 责任部门取得
	 *
	 * @return 责任部门
	 */
	public String getDutydepartment();

	/**
	 * 取得
	 *
	 * @return 
	 */
	public String getEsyscoding();

	/**
	 * 指标名取得
	 *
	 * @return 指标名
	 */
	public String getEiname();

	/**
	 * 登记日期取得
	 *
	 * @return 登记日期
	 */
	public String getEiinsdate();

	/**
	 * 编号取得
	 *
	 * @return 编号
	 */
	public String getEilabel();

	/**
	 * 更新日期取得
	 *
	 * @return 更新日期
	 */
	public String getEiupdtime();

	/**
	 * 小版本取得
	 *
	 * @return 小版本
	 */
	public String getEismallversion();

	/**
	 * 阀值取得
	 *
	 * @return 阀值
	 */
	public String getZbfz();

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getEistatus();

	/**
	 * 登记人ID取得
	 *
	 * @return 登记人ID
	 */
	public String getEiuserid();

	/**
	 * 登记人名字取得
	 *
	 * @return 登记人名字
	 */
	public String getEiusername();

	/**
	 * eid取得
	 *
	 * @return eid
	 */
	public String getEid();

	/**
	 * 取得
	 *
	 * @return 
	 */
	public String getEirootmark();

	/**
	 * 管理人ID取得
	 *
	 * @return 管理人ID
	 */
	public String getMguserid();

	/**
	 * 用途取得
	 *
	 * @return 用途
	 */
	public String getIndexused();

	/**
	 * 是否关键指标取得
	 *
	 * @return 是否关键指标
	 */
	public String getKeyindex();

	/**
	 * 指标说明取得
	 *
	 * @return 指标说明
	 */
	public String getEidesc();

	/**
	 * 机构码取得
	 *
	 * @return 机构码
	 */
	public String getEiorgsyscoding();

	/**
	 * 版本号取得
	 *
	 * @return 版本号
	 */
	public String getEiversion();

	/**
	 * 责任人取得
	 *
	 * @return 责任人
	 */
	public String getDutyuser();

	/**
	 * 风险领域取得
	 *
	 * @return 风险领域
	 */
	public String getRiskly();

	/**
	 * 风险域取得
	 *
	 * @return 风险域
	 */
	public String getRiskarea();

	/**
	 * 风险项取得
	 *
	 * @return 风险项
	 */
	public String getRiskitem();

	/**
	 * 管理人名取得
	 *
	 * @return 管理人名
	 */
	public String getMgusername();

}