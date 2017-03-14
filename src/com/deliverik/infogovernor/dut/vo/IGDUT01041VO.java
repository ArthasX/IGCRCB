/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dut.model.DutyAuditDef;

/**
 * 值班检查项查询业务逻辑接口
 */
public class IGDUT01041VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 值班检查信息检索结果
	 */
	protected List<DutyAuditDef> dutyAuditList;

	/**
	 * 构造函数
	 * @return 值班检查信息检索结果
	 */
	public List<DutyAuditDef> getDutyAuditList() {
		return dutyAuditList;
	}

	/**
	 * 值班检查信息检索结果
	 * @param dutyDataList 值班检查信息检索结果
	 */
	public void setDutyAuditList(List<DutyAuditDef> dutyAuditList) {
		this.dutyAuditList = dutyAuditList;
	}
	
}
