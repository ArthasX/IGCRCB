/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * 风险审计实体接口
 * 
 * @author lipeng@deliverik.com
 * 
 */

public interface RiskAudit extends BaseModel {
	/**
	 * 风险审计ID取得
	 * 
	 * @return 风险审计ID
	 */
	public Integer getRaid();

	/**
	 * 风险审计版本取得
	 * 
	 * @return 风险审计版本
	 */
	public String getRaversion();
	
	/**
	 * 风险审计创建日期取得
	 * 
	 * @return 风险审计创建日期
	 */
	public String getRadate();
	
	/**
	 * 风险审计创建人ID取得
	 * 
	 * @return 风险审计创建人ID
	 */
	public String getRauserid();
	
	/**
	 * 风险审计创建人姓名取得
	 * 
	 * @return 风险审计创建人姓名
	 */
	public String getRausername();

	/**
	 * 风险审计描述取得
	 * 
	 * @return 风险审计描述
	 */
	public String getRadesc();

	/**
	 * 风险审计状态取得
	 * 
	 * @return 风险审计状态
	 */
	public String getRastatus();
	
	/**
	 * 风险审计根标识取得
	 * 
	 * @return 风险审计根标识
	 */
	public String getRacode();

}