/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 演练计划接口
  * 功能描述: 演练计划接口
  * 创建记录: 2015/03/02
  * 修改记录: 
  */
public interface DrillplanInfo extends BaseModel {

	/**
	 * 演练计划id取得
	 *
	 * @return 演练计划id
	 */
	public Integer getDid();

	/**
	 * 演练计划制定人id取得
	 *
	 * @return 演练计划制定人id
	 */
	public String getDuserid();

	/**
	 * 演练计划指定人名取得
	 *
	 * @return 演练计划指定人名
	 */
	public String getDusername();

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getCrttime();

	/**
	 * 审批时间取得
	 *
	 * @return 审批时间
	 */
	public String getJudgetime();

	/**
	 * 演练计划编号取得
	 *
	 * @return 演练计划编号
	 */
	public String getDserial();

	/**
	 * 演练计划名称取得
	 *
	 * @return 演练计划名称
	 */
	public String getDname();

	/**
	 * 审批状态 a 为送审，b审批中，c审批完成取得
	 *
	 * @return 审批状态 a 为送审，b审批中，c审批完成
	 */
	public String getJudgestatus();

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getDepict();
	//审批人userid
	public String getJudgeuserid();
	//审批人username
	public String getJudgeusername();
	
    /** 审批意见 */
    public String getDopinion();
    /**完成数量*/
    public String getCompletecount();

}