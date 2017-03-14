/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dut.model.DutyPlan;

/**
 * 值班启动逻辑接口
 */
public class IGDUT02062VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 值班启动检索结果
	 */
	protected DutyPlan dutyPlan;
	
	protected String name;

	/**
	 * 值班启动取得
	 * @return 值班启动
	 */
	public DutyPlan getDutyPlan() {
		return dutyPlan;
	}

	/**
	 * 值班启动设定
	 * @param dutyPlan 值班启动
	 */
	public void setDutyPlan(DutyPlan dutyPlan) {
		this.dutyPlan = dutyPlan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
