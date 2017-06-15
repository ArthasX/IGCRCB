/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model;


/**
 * 审计项和相关审计人外联视图实体接口
 * 
 * @author lipeng@deliverik.com
 */
public interface RiskAuditDefResultVWInfo {
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
	 * 风险审计项状态取得
	 * @return 风险审计项状态
	 */
	public String getRadstatus();

	/**
	 * 风险审计项级次取得
	 * @return 风险审计项级次
	 */
	public String getRadlevel();

	/**
	 * 风险审计评估结果ID取得
	 * @return 风险审计评估结果ID
	 */
	public Integer getRarid();

	/**
	 * 风险审计发起ID取得
	 * @return 风险审计发起ID
	 */
	public Integer getRaiid();

	/**
	 * 风险审计评估人ID取得
	 * @return 风险审计评估人ID
	 */
	public String getRaruserid();

	/**
	 * 风险审计评估人姓名取得
	 * @return 风险审计评估人姓名
	 */
	public String getRarusername();

	/**
	 * 风险审计制度建设评分取得
	 * @return 风险审计制度建设评分
	 */
	public String getRarplanscore();

	/**
	 * 风险审计制度建设评价取得
	 * @return 风险审计制度建设评价
	 */
	public String getRarplandesc();

	/**
	 * 风险审计制度执行评分取得
	 * @return 风险审计制度执行评分
	 */
	public String getRarexecscore();

	/**
	 * 风险审计制度执行评价取得
	 * @return 风险审计制度执行评价
	 */
	public String getRarexecdesc();

	/**
	 * 风险审计总体评分取得
	 * @return 风险审计总体评分
	 */
	public String getRaroverallscore();
	/**
	 * 风险审计总体评价取得
	 * @return 风险审计总体评价
	 */
	public String getRaroveralldesc();

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
	 * 风险审计项风险程度取得
	 * @return 风险审计项风险程度
	 */
	public String getRadrisklevel();
	
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
	 * 风险审计项描述取得
	 * @return 风险审计项描述
	 */
	public String getRaddesc();
}