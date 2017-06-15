/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 风险审计项实体接口
 * 
 * @author lipeng@deliverik.com
 */
public interface RiskAuditDef  extends BaseModel {
	/**
	 * 风险审计项ID取得
	 * @return 风险审计项ID
	 */
	public Integer getRadid();

	/**
	 * 风险审计ID取得
	 * @return 风险审计ID
	 */
	public Integer getRaid();

	/**
	 * 风险审计版本取得
	 * @return 风险审计版本
	 */
	public String getRaversion();

	/**
	 * 风险审计项名称取得
	 * @return 风险审计项名称
	 */
	public String getRadname();

	/**
	 * 风险审计项层次码取得
	 * @return 风险审计项层次码
	 */
	public String getRadcode();

	/**
	 * 风险审计项上级层次码取得
	 * @return 风险审计项上级层次码
	 */
	public String getRadparcode();
	
	/**
	 * 风险审计项级次取得
	 * @return 风险审计项级次
	 */
	public String getRadlevel();

	/**
	 * 风险审计项描述取得
	 * @return 风险审计项描述
	 */
	public String getRaddesc();

	/**
	 * 风险审计项风险程度取得
	 * @return 风险审计项风险程度
	 */
	public String getRadrisklevel();

	/**
	 * 风险审计项责任人ID取得
	 * @return 风险审计项责任人ID
	 */
	public String getRaduserid();

	/**
	 * 风险审计项责任人姓名取得
	 * @return 风险审计项责任人姓名
	 */
	public String getRadusername();

	/**
	 * 风险审计项责任部门取得
	 * @return 风险审计项责任部门
	 */
	public String getRadorg();
	
	/**
	 * 风险审计项责任部门编码取得
	 * @return 风险审计项责任部门编码
	 */
	public String getRadorgcoding();

	/**
	 * 风险审计项控制手段取得
	 * @return 风险审计项控制手段
	 */
	public String getRadmode();

	/**
	 * 风险审计项控制类型取得
	 * @return 风险审计项控制类型
	 */
	public String getRadtype();

	/**
	 * 风险审计项控制频率取得
	 * @return 风险审计项控制频率
	 */
	public String getRadfrequency();
	
	/**
	 * 风险审计项状态取得
	 * @return 风险审计项状态
	 */
	public String getRadstatus();

}