/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckTB;

/**
 * 风险检查结果实体接口
 * 
 * @author lipeng@deliverik.com
 */
public interface RiskCheckResult  extends BaseModel {
	/**
	 * 风险检查结果ID取得
	 * @return 风险检查结果ID
	 */
	public Integer getRcrid();

	/**
	 * 风险检查ID取得
	 * @return 风险检查ID
	 */
	public Integer getRcid();

	/**
	 * 风险检查计划检查时间取得
	 * @return 风险检查计划检查时间
	 */
	public String getRcrplandate();

	/**
	 * 风险检查实际检查时间取得
	 * @return 风险检查实际检查时间
	 */
	public String getRcrrealtime();

	/**
	 * 风险检查结果提交人ID取得
	 * @return 风险检查结果提交人ID
	 */
	public String getRcruserid();

	/**
	 * 风险检查结果提交人姓名取得
	 * @return 风险检查结果提交人姓名
	 */
	public String getRcrusername();

	/**
	 * 风险检查结果取得
	 * @return 风险检查结果
	 */
	public String getRcrresult();

	/**
	 * 风险检查结果说明取得
	 * @return 风险检查结果说明
	 */
	public String getRcrcomment();
	
	/**
	 * 风险检查对象取得
	 * @return 风险检查对象
	 */
	public RiskCheckTB getRiskCheck();
	
	/**
	 * 风险检查结果附件取得
	 * @return 风险检查结果附件
	 */
	public String getRcrattch();
	
	/**
	 * 风险检查重要程度取得
	 * @return 风险检查重要程度
	 */
	public String getRctype();
	
	/**
	 * 下次执行检查时间取得
	 * @return 下次执行检查时间
	 */
	public String getRcrnextdate();

	/**
	 * 关联流程取得
	 * @return 关联流程
	 */
	public Integer getPrid();
	
	/**
	 * 关联指派工作流程id
	 * @return
	 */
	public Integer getAssignprid();
	
	/**
	 * 完成情况取得
	 * @return
	 */
	public String getRcrtestmode();
	
	/**
	 * 检查项名称取得
	 * @return the rcname
	 */
	public String getRcname();

	/**
	 * 检查项类型取得
	 * @return the rcrclass
	 */
	public String getRcrclass();

	/**
	 * 检查项描述取得
	 * @return the rcdesc
	 */
	public String getRcdesc();

	/**
	 * 检查项说明取得
	 * @return the rccommon
	 */
	public String getRccommon();

	
}