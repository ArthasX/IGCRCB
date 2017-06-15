/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;

/**
 * 流程状态跃迁规则
 *
 */
public interface IG273Info extends BaseModel {
	/**
	 * 流程状态跃迁规则ID取得
	 * @return 流程状态跃迁规则ID
	 */
	public String getPtdid();
	
	/**
	 * 流程状态ID（From）取得
	 * @return 流程状态ID（From）
	 */
	public String getFpsdid();
	
	/**
	 * 流程状态ID（To）取得
	 * @return 流程状态ID（To）
	 */
	public String getTpsdid();

	/**
	 * 流程状态跃迁规则名称取得
	 * @return 流程状态跃迁规则名称
	 */
	public String getPtdname();
	
	/**
	 * 流程状态跃迁规则描述取得
	 * @return 流程状态跃迁规则描述
	 */
	public String getPtddesc();
	
	/**
	 * 流程状态跃迁规则类型取得
	 * @return 流程状态跃迁规则类型
	 */
	public String getPtdtype();
	
	/**
	 * 流程状态跃迁条件取得
	 * @return 流程状态跃迁条件
	 */
	public String getPtdcond();
	
	/**
	 * 流程状态跃迁条件取得
	 * @return 流程状态跃迁条件
	 */
	public String getPtdcondinfo();
	
	/**
	 * 流程当前状态取得
	 * @return 流程当前状态
	 */
	public IG333TB getFromPSDTB();
	
	/**
	 * 流程跃迁状态取得
	 * @return 流程跃迁状态
	 */
	public IG333TB getToPSDTB();
	
}
