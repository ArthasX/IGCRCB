/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dut.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 值班检查管理实体接口
 */
public interface DutyAuditDef extends BaseModel {	
	
	/**
	 * 检查项ID
	 */
	public Integer getDadid();

	/**
	 * 值班类型
	 */
	public String getDadcategory();
	
	/**
	 * 检查分类
	 */
	public String getDadtype();
	
	/**
	 * 检查名称
	 */
	public String getDadname();
	
	/**
	 * 填报时间限制
	 */
	public String getDadlimtime();
	
	/**
	 * 检查结果内容
	 */
	public String getDadcontent();
	
	/**
	 * 结果说明
	 */
	public String getDadinfo();
	
	/**
	 * 使用状态
	 */
	public String getDadstatus();
	
	/**
	 * 更新者ID
	 */
	public String getDaduserid();
	
	/**
	 * 更新者姓名
	 */
	public String getDadusername();
	
	/**
	 * 更新时间
	 */
	public String getDadupdtime();
	
	/**
	 * 排序标识取得
	 *
	 * @return dadorderby 排序标识
	 */
	public Integer getDadorderby();
	
	/**
	 * 周期类型取得
	 * @return 周期类型
	 */
	public String getPeriodType();

	/**
	 * 周期时间取得
	 * @return 周期时间
	 */
	public String getPeriodValue();

}
