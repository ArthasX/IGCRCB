/*
 * 北京递蓝科信息技术有限公司版权所有,保留所有权利.
 */
package com.deliverik.infogovernor.dut.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dut.model.DutyResult;

/**
 * 值班检查内容VO
 */
public class IGDUT02042VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 值班检查内容
	 */
	protected DutyResult dutyResult;
	/**
	 * 值班检查内容检索结果
	 */
	protected List<DutyResult> dutyResultList;
	
	/**
	 * 检查分类合并行数
	 */
	protected Integer rowspanNum = 0;

	/**
	 * 值班检查内容检索结果取得
	 * @return 值班检查内容检索结果
	 */
	public List<DutyResult> getDutyResultList() {
		return dutyResultList;
	}

	/**
	 * 检查分类合并行数设定
	 * @param dutyDataList 检查分类合并行数
	 */
	public void setDutyResultList(List<DutyResult> dutyResultList) {
		this.dutyResultList = dutyResultList;
	}

	/**
	 * 检查分类合并行数取得
	 * @return 检查分类合并行数
	 */
	public Integer getRowspanNum() {
		return rowspanNum;
	}

	/**
	 * 检查分类合并行数设定
	 * @param rowspanNum 检查分类合并行数
	 */
	public void setRowspanNum(Integer rowspanNum) {
		this.rowspanNum = rowspanNum;
	}

	/**
	 * 值班检查内容取得
	 * @return 值班检查内容
	 */
	public DutyResult getDutyResult() {
		return dutyResult;
	}

	/**
	 * 值班检查内容设定
	 * @param dutyResult 值班检查内容
	 */
	public void setDutyResult(DutyResult dutyResult) {
		this.dutyResult = dutyResult;
	}
	
}
