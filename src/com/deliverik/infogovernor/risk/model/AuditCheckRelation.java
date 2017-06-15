/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 风险检查与风险审计项关系实体接口
 * 
 * @author lipeng@deliverik.com
 */
public interface AuditCheckRelation  extends BaseModel {
	/**
	 * 风险检查与风险审计关系ID取得
	 * @return 风险检查与风险审计关系ID
	 */
	public Integer getAcrid();
	
	/**
	 * 风险检查ID取得
	 * @return 风险检查ID
	 */
	public Integer getRcid();

	/**
	 * 风险审计项ID取得
	 * @return 风险审计项ID
	 */
	public Integer getRadid();

	/**
	 * 风险审计项编码取得
	 * @return 风险审计项编码
	 */
	public String getRadcode();

}