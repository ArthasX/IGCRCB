/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dut.model.DutyResult;

/**
 * 值班情况汇总业务逻辑接口
 */
public class IGDUT03031VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 值班情况汇总信息检索结果
	 */
	protected List<DutyResult> dutyResultList;

	/**
	 * 值班情况汇总信息检索结果取得
	 * @return 值班情况汇总信息检索结果
	 */
	public List<DutyResult> getDutyResultList() {
		return dutyResultList;
	}

	/**
	 * 值班情况汇总信息检索结果设定
	 * @param dutyResultList 值班情况汇总信息检索结果
	 */
	public void setDutyResultList(List<DutyResult> dutyResultList) {
		this.dutyResultList = dutyResultList;
	}

}
