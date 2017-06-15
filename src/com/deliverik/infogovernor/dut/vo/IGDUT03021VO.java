/*
 * 北京递蓝科信息技术有限公司版权所有,保留所有权利.
 */
package com.deliverik.infogovernor.dut.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.DutyResult;

/**
 * 值班检查内容VO
 */
public class IGDUT03021VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 值班检查内容检索结果
	 */
	private List<DutyResult> dutyResultList;
	
	/**
	 * 值班检查内容显示VO
	 */
	protected List<IGDUT02042VO> voList;
	
	/** 白班计划 */
	protected DutyPlan dutyPlanAM;
	
	/** 夜班计划 */
	protected DutyPlan dutyPlanPM;
	
	/**
	 * 值班检查内容检索结果取得
	 * @return 值班检查内容检索结果
	 */
	public List<DutyResult> getDutyResultList() {
		return dutyResultList;
	}

	/**
	 * 值班检查内容检索结果设定
	 * @param dutyDataList 值班检查内容检索结果
	 */
	public void setDutyResultList(List<DutyResult> dutyResultList) {
		this.dutyResultList = dutyResultList;
		if(dutyResultList != null && dutyResultList.size() > 0) {
			voList = new ArrayList<IGDUT02042VO>();
			//检查类型
			String dadtype = "";
			//VO序号
			int i = -1;
			for(DutyResult dr :dutyResultList) {
				if(dr.getDadtype().equals(dadtype)) {
					voList.get(i).getDutyResultList().add(dr);
				} else {
					dadtype = dr.getDadtype();
					voList.add(new IGDUT02042VO());
					voList.get(++i).setDutyResultList(new ArrayList<DutyResult>());
					voList.get(i).setDutyResult(dr);
				}
				int count = voList.get(i).getRowspanNum();
				voList.get(i).setRowspanNum(++count);
			}
		}
	}

	/**
	 * 值班检查内容显示VO
	 * @return 值班检查内容显示VO
	 */
	public List<IGDUT02042VO> getVoList() {
		return voList;
	}
	
	/**
	 * 白班计划取得
	 * @return 白班计划
	 */
	public DutyPlan getDutyPlanAM() {
		return dutyPlanAM;
	}

	/**
	 * 白班计划设定
	 * @param dutyPlanAM 白班计划
	 */
	public void setDutyPlanAM(DutyPlan dutyPlanAM) {
		this.dutyPlanAM = dutyPlanAM;
	}
	
	/**
	 * 夜班计划取得
	 * @return 夜班计划
	 */
	public DutyPlan getDutyPlanPM() {
		return dutyPlanPM;
	}

	/**
	 * 夜班计划设定
	 * @param dutyPlanPM 夜班计划
	 */
	public void setDutyPlanPM(DutyPlan dutyPlanPM) {
		this.dutyPlanPM = dutyPlanPM;
	}
	
}
