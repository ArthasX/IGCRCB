/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险检查统计查询接口 （风险）
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public interface RiskVWInfo {
	/**
	 * eiid取得
	 * @return eiid eiid
	 */
	public String getEiid();

	/**
	 * syscoding取得
	 * @return syscoding syscoding
	 */
	public String getSyscoding();

	/**
	 * 风险领域取得
	 * @return riskly 风险领域
	 */
	public String getRiskly();

	/**
	 * 风险子域取得
	 * @return riskarea 风险子域
	 */
	public String getRiskarea();

	/**
	 * 风险项取得
	 * @return riskitem 风险项
	 */
	public String getRiskitem();

	/**
	 * 风险点（检查点）取得
	 * @return einame 风险点（检查点）
	 */
	public String getEiname();

	/**
	 * 严重等级取得
	 * @return grad 严重等级
	 */
	public String getGrad();

	/**
	 * 发生可能性取得
	 * @return poss 发生可能性
	 */
	public String getPoss();

	/**
	 * 风险级别取得
	 * @return levels 风险级别
	 */
	public String getLevels();

	/**
	 * 风险点标志取得
	 * @return risksign 风险点标志
	 */
	public String getRisksign();
}
