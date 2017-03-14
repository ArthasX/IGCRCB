/**
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */
package com.deliverik.infogovernor.dut.model.condition;
/**
 * 
 * 值班检查项检查时间查询实现类
 *
 */
public class DutyAuditTimeSearchCondImpl  implements DutyAuditTimeSearchCond{
	/**
	 * 检查项ID
	 */
	protected Integer dadid;

	/**
	 * 检查项ID取得
	 */
	public Integer getDadid() {
		return dadid;
	}

	/**
	 * 检查项ID设定
	 */
	public void setDadid(Integer dadid) {
		this.dadid = dadid;
	}
	
	
}
